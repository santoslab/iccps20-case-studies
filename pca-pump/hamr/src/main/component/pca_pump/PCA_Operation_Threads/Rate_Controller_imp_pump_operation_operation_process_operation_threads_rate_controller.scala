// #Sireum

package pca_pump.PCA_Operation_Threads

import org.sireum._
import pca_pump._
import org.sireum.S16._
import org.sireum.U16._
import pca_pump.util.{ArtSystem, PCA_Properties}

// This file will not be overwritten so is safe to edit
object Rate_Controller_imp_pump_operation_operation_process_operation_threads_rate_controller {

  // useful constants
  val ZeroDrugVolume: PCA_Types.Drug_Volume_imp = PCA_Types.Drug_Volume_imp(s16"0")
  val ZeroFlowRate: PCA_Types.Flow_Rate_imp = PCA_Types.Flow_Rate_imp(s16"0")
  val ZeroMinutes: ICE_Types.Minute_imp = ICE_Types.Minute_imp(u16"0")

  // cpBolusDuration is set by clinician
  var cpBolusDuration: Option[ICE_Types.Minute_imp] = None[ICE_Types.Minute_imp] ()

  var currentInfusionFlowRate: PCA_Types.Flow_Rate_imp = ZeroFlowRate
  var currentMode: Mode.Type = Mode.PowerOn
  var lastModeChange: art.Art.Time = z"0"

  var currentAlarm : Option[PCA_Types.Alarm_Type.Type] = None[PCA_Types.Alarm_Type.Type]()
  var currentWarning : Option[PCA_Types.Warning_Type.Type] = None[PCA_Types.Warning_Type.Type]()

  def initialise(api: Rate_Controller_imp_Initialization_Api): Unit = {
    currentInfusionFlowRate = ZeroFlowRate

    setMode(api, Mode.WaitForRx)
  }

  def handleAlarm(api: Rate_Controller_imp_Operational_Api, value : PCA_Types.Alarm_Type.Type): Unit = {
    api.logInfo(s"received Alarm ${value}")

    // FIXME: how should RateController react to alarms?  The alarm_thread issues
    // the alarms and also the corresponding events (e.g. issues Empty_Reservoir
    // Alarm and also sends Stop_Pump_Completely)

    currentAlarm = Some(value)
  }

  def handleWarning(api: Rate_Controller_imp_Operational_Api, value : PCA_Types.Warning_Type.Type): Unit = {
    api.logInfo(s"received Warning ${value}")

    // FIXME: how should RateController react to warnings?  The alarm_thread
    // issues the warnings and also the corresponding events (e.g. issues
    // Over_Max_Drug_Per_Hour warning and issues Pump_At_KVO_Rate)

    //api.logInfo(s"ALERT: unknown behavior")
    currentWarning = Some(value)
  }

  def handleCP_Bolus_Duration(api: Rate_Controller_imp_Operational_Api, value : ICE_Types.Minute_imp): Unit = {
    /* req: UC3: Clinician-Requested Bolus (UC3) {@link https://www.smarturl.it/OPCA#subsubsec_uc3}
     * req: PCA Pump Function: Clinician-Requested Bolus {@link https://www.smarturl.it/OPCA#subsec_crbolus}
     */
    api.logInfo(s"received CP_Bolus_Duration ${value}")

    verifyDoorClosed(api)

    // FIXME: is any validation needed?

    // FIXME: need to ensure clinician has scanned badge 'recently'?

    val condition = value.value >= ZeroMinutes.value
    ArtSystem.assertThat(condition, s"cp bolus must be non-negative: ${value.value}", api.id)
    if(!condition) {
      return
    }

    cpBolusDuration = Some(value)
  }

  def handleBegin_Infusion(api: Rate_Controller_imp_Operational_Api): Unit = {
    /* req: PCA Pump Function: Basal Flow Rate {@link https://www.smarturl.it/OPCA#subsec_basalflow}
     */
    api.logInfo("received Begin_Infusion")

    verifyDoorClosed(api)

    val condition : B = currentMode == Mode.WaitForStart
    ArtSystem.assertThat(condition, s"pump not in expected mode ${currentMode}", api.id)
    if(!condition){
      return
    }

    if(currentAlarm.nonEmpty && currentAlarm.get != PCA_Types.Alarm_Type.No_Alarm) {
      api.logInfo(s"Cannot fulfill begin infusion request.  Waiting for clinician to clear the ${currentAlarm.get}")
      return
    }

    val basalRate : PCA_Types.Flow_Rate_imp = api.getBasal_Rate().get
    api.logInfo(s"basalRate = ${basalRate.value}")

    setInfusionFlowRate(api, basalRate, PCA_Types.Status_Type.Basal)

    setMode(api, Mode.PumpBasalRate)
  }

  def handleBegin_Priming(api: Rate_Controller_imp_Operational_Api): Unit = {

    /* req: Use Case: Prime Pump (UC9) {@link https://www.smarturl.it/OPCA#subsubsec_uc9}
     */
    api.logInfo(s"received Begin_Priming")

    verifyDoorClosed(api)

    // FIXME:
    //assert(currentMode == Mode.RxApproved)
    setMode(api, Mode.RxApproved)

    setInfusionFlowRate(api, PCA_Properties.PrimeRate, PCA_Types.Status_Type.Priming)

    setMode(api, Mode.PumpPrimeRate)
  }

  def handleEnd_Priming(api: Rate_Controller_imp_Operational_Api): Unit = {
    /* req: Use Case: Prime Pump (UC9) {@link https://www.smarturl.it/OPCA#subsubsec_uc9}
     */

    api.logInfo(s"received End_Priming")

    verifyDoorClosed(api)

    val condition = currentMode == Mode.PumpPrimeRate
    ArtSystem.assertThat(condition, s"pump not in expected mode ${currentMode}", api.id)
    if(!condition) {
      return
    }

    setInfusionFlowRate(api, ZeroFlowRate, PCA_Types.Status_Type.Stopped)

    setMode(api, Mode.WaitForStart)
  }

  def handleHalt_Infusion(api: Rate_Controller_imp_Operational_Api): Unit = {
    api.logInfo(s"received Halt_Infusion")

    verifyDoorClosed(api)

    // comes from Boss when the stop button has been pressed during a normal
    // infusion
    setInfusionFlowRate(api, ZeroFlowRate, PCA_Types.Status_Type.Stopped)

    // REF: transitioning to WaitForStart as per IPCA UC7
    setMode(api, Mode.WaitForStart)
  }

  def handleHW_Detected_Failure(api: Rate_Controller_imp_Operational_Api): Unit = {
    api.logInfo("example handleHW_Detected_Failure implementation")
    api.logInfo("received HW_Detected_Failure")
  }

  def handleStop_Pump_Completely(api: Rate_Controller_imp_Operational_Api): Unit = {
    api.logInfo(s"received StopPumpCompletely")

    //verifyDoorClosed()??

    // this event is sent via the safety arch (i.e. not triggered by the
    // stop button being pressed)

    setInfusionFlowRate(api, ZeroFlowRate, PCA_Types.Status_Type.Stopped)

    // is this the right mode?
    setMode(api, Mode.WaitForStart)
  }

  def handlePump_At_KVO_Rate(api: Rate_Controller_imp_Operational_Api): Unit = {
    api.logInfo(s"received Pump_At_KVO_Rate")

    verifyDoorClosed(api)

    setInfusionFlowRate(api, PCA_Properties.KVORate, PCA_Types.Status_Type.KVO)

    setMode(api, Mode.PumpKVORate)
  }

  def handlePatient_Request_Not_Too_Soon(api: Rate_Controller_imp_Operational_Api): Unit = {
    /* req: Use Case: Patient-Requested Bolus (UC2) {@link https://www.smarturl.it/OPCA#subsubsec_uc2}
     * req: PCA Pump Function: Patient-Requested Bolus {@link https://www.smarturl.it/OPCA#subsec_prbolus}
     */
    api.logInfo(s"received Patient_Request_Not_Too_Soon")

    verifyDoorClosed(api)

    val condition : B = currentMode == Mode.PumpBasalRate | currentMode == Mode.PumpPatientButtonVTBI | currentMode == Mode.PumpCCBRate
    ArtSystem.assertThat(condition, s"Pump is not in the expected mode: ${currentMode}", api.id)
    if(!condition) {
      return
    }

    val vtbi : PCA_Types.Drug_Volume_imp = api.getVTBI().get
    val basalRate : PCA_Types.Flow_Rate_imp = api.getBasal_Rate().get
    val prescribedPBRate : PCA_Types.Flow_Rate_imp = api.getPatient_Bolus_Rate().get

    // A patient-requested bolus shall be delivered at its prescribed rate, F_bolus, in addition to the
    // prescribed basal flow rate, F_basal, but no more than the maximum flow rate for the pump, F_max.
    val derivedRate: PCA_Types.Flow_Rate_imp = PCA_Types.Flow_Rate_imp(prescribedPBRate.value + basalRate.value)

    // TODO: should the clinician be warned if derived rate is > MaxRate?
    val safeRate = min(derivedRate, PCA_Properties.MaxRate)

    // calculate how long it will take to deliver vtbi at the patientBolusRate
    val pbBolusDuration: Z = calculateDurationInMilliseconds(api, vtbi, safeRate)

    api.logInfo(s"It will take ${pbBolusDuration} ms to deliver patient bolus vtbi ${vtbi} ml at ${safeRate} ml/hr")


    switchModesForDuration(api, safeRate, PCA_Types.Status_Type.Bolus, pbBolusDuration)
  }

  def handlePause_Infusion(api: Rate_Controller_imp_Operational_Api): Unit = {
    api.logInfo(s"received Pause_Infusion")

    verifyDoorClosed(api)

    // FIXME: Pause_Infusion and Resume_Infusion come from the ControlPanel.
    // IPCA doesn't explicitly mention the panel has these buttons.  However,
    // R5.7.0(5) does state that the pump shall resume infusion when commanded
    // through its ICE interface.  Rate_Controller doesn't receive the
    // Start and Stop button pressed events so does the ControlPanel keep a
    // notion of mode (i.e. knows the pump is on so if Stop button pressed it
    // sends a Pause_Infusion?)

    api.logInfo(s"ALERT: unknown behavior")
  }

  def handleResume_Infusion(api: Rate_Controller_imp_Operational_Api): Unit = {
    api.logInfo(s"received Resume_Infusion")

    verifyDoorClosed(api)

    // FIXME: see FIXME in handlePauseInfusion

    api.logInfo(s"ALERT: unknown behavior")
  }

  def handleCP_Clinician_Request_Bolus(api: Rate_Controller_imp_Operational_Api): Unit = {
    /* req: Use Case: Clinician-Requested Bolus (UC3) {@link https://www.smarturl.it/OPCA#subsubsec_uc3}
     * req: PCA Pump Function: Clinician-Requested Bolus {@link https://www.smarturl.it/OPCA#subsec_crbolus}
     */
    api.logInfo(s"received CP_Clinician_Request_Bolus")

    verifyDoorClosed(api)

    // FIXME: cc bolus can be interrupted by a patient bolus and then resumed afterwards.

    // FIXME: need to ensure clinician has scanned badge 'recently'?

    val condition: B = currentMode == Mode.PumpBasalRate
    ArtSystem.assertThat(condition, s"pump not in expected mode ${currentMode}", api.id)
    if(!condition) {
      return
    }

    val vtbi: PCA_Types.Drug_Volume_imp = api.getVTBI().get

    val (rate, duration): (PCA_Types.Flow_Rate_imp, Z) =
      cpBolusDuration match {
        case Some(ICE_Types.Minute_imp(value)) =>
          // clinician set a desired duration so calculate the flow rate

          val basal_rate: S16 = api.getBasal_Rate().get.value
          val squareDur: S16 = conversions.U16.toS16(value)
          val derivedRate: PCA_Types.Flow_Rate_imp = PCA_Types.Flow_Rate_imp((vtbi.value / squareDur) + basal_rate)

          api.logInfo(s"square flow-rate: (vtib / cp_duration) + F_basal = ($vtbi / $squareDur) + $basal_rate = $derivedRate")

          (derivedRate, conversions.S16.toZ(squareDur))

        case _ =>
          // FIXME: need to calculate duration -- see notes in PCA_Types.Drug_Record.scala

          var cpRate: PCA_Types.Flow_Rate_imp = api.getSquare_Bolus_Rate().get
          val derivedDuration: Z = calculateDurationInMilliseconds(api, vtbi, cpRate)

          api.logInfo(s"Using squareBolusRateTypical from drug record: ${cpRate} ml/hr.  Duration = vtbi / rate = $vtbi / $cpRate = $derivedDuration")

          (cpRate, derivedDuration)
      }

    // FIXME: should clinician be warned if rate > F_max?
    val safeRate = min(rate, PCA_Properties.MaxRate)


    switchModesForDuration(api, safeRate, PCA_Types.Status_Type.Square_Bolus, duration)
  }

  def handleNear_Max_Drug_Per_Hour(api: Rate_Controller_imp_Operational_Api): Unit = {
    api.logInfo(s"received Near_Max_Drug_Per_Hour")

    verifyDoorClosed(api)

    // Max_Drug_Per_Hour_Watcher thread sends Near_Max_Drug_Per_Hour directly
    // to the Rate_Controller and ICEThread.  It's connected to the operation_thread
    // group, but nothing is connected to that (i.e. not connected to safety
    // arch

    // FIXME: not clear what the rate controller is supposed to do when this
    // event is fired

    api.logInfo(s"ALERT: How should the RateController thread handle this event?")
  }

  def handleOver_Max_Drug_Per_Hour(api: Rate_Controller_imp_Operational_Api): Unit = {
    /* req: Exception Case: Maximum Safe Dose (EC13) {@link https://www.smarturl.it/OPCA#ec_maxdose}
     */
    api.logInfo(s"received Over_Max_Drug_Per_Hour")

    verifyDoorClosed(api)

    // FIXME: Max_Drug_Per_Hour_Watcher thread sends Over_Max_Drug_Per_Hour
    // directly to the Rate_Controller thread.  It is also sent to the safety
    // arch which (via alarm process) issues a Over_Max_Drug_Per_Hour warning
    // and then a Pump_At_KVO_Rate event.

    // REF: IPCA EC13 Exception Case: Maximum Safe Dose

    // setInfusionFlowRate(KVORate)

    // setMode(Mode.PumpKVORate)
    api.logInfo(s"ALERT: implementation issues, see notes")
  }

  def handleICE_Stop_Pump(api: Rate_Controller_imp_Operational_Api): Unit = {
    api.logInfo(s"received ICE_Stop_Pump")

    // TODO: this event is fired when ICE detects a danger and is directly
    //       connected to the rate controller thread.  See IPCA 6.4
    //       Diagnostic and Fail-Stop which appears to indicate that pumping
    //       should be stopped (i.e. not switched to KVO)

    setInfusionFlowRate(api, ZeroFlowRate, PCA_Types.Status_Type.Stopped)

    setMode(api, Mode.WaitForStart)
  }




  def setMode(api: Rate_Controller_imp_Api,
              m: Mode.Type): Unit = {
    api.logInfo(s"mode change: $currentMode -> $m")
    currentMode = m
    lastModeChange = art.Art.time()
  }

  def setInfusionFlowRate(api: Rate_Controller_imp_Api,
                          v : PCA_Types.Flow_Rate_imp,
                          status : PCA_Types.Status_Type.Type): Unit = {
    val condition = v.value >= ZeroFlowRate.value
    ArtSystem.assertThat(condition, s"flow rate must be non-negative: ${v.value}", api.id)
    if(!condition){
      return
    }

    currentInfusionFlowRate = v

    api.setInfusion_Flow_Rate(v)

    api.sendSystem_Status(status)

    api.logInfo(s"setting Infusion Flow Rate to $v and System_Status $status")
  }

  def min(a: PCA_Types.Flow_Rate_imp, b: PCA_Types.Flow_Rate_imp): PCA_Types.Flow_Rate_imp = {
    if(a.value <= b.value) {
      return a
    }
    else {
      return b
    }
  }

  def calculateDurationInMilliseconds(api: Rate_Controller_imp_Api,
                                      vtbi : PCA_Types.Drug_Volume_imp,
                                      flowRate: PCA_Types.Flow_Rate_imp) : Z = {
    ArtSystem.assertThat(flowRate.value > ZeroFlowRate.value, "div-by-zero", api.id)

    ArtSystem.fToZ((ArtSystem.zToF(conversions.S16.toZ(vtbi.value)) / ArtSystem.zToF(conversions.S16.toZ(flowRate.value))) * 3600000f)
  }


  val patientBolusEventTimeoutId: String = "patientBolusEventTimeoutId"
  val squareBolusEventTimeoutId: String = "squareBolusEventTimeoutId"

  def switchModesForDuration(api: Rate_Controller_imp_Operational_Api,
                             flowRate: PCA_Types.Flow_Rate_imp,
                             sysStatus: PCA_Types.Status_Type.Type,
                             duration: Z) : Unit = {

    val (mode, eventId) : (Mode.Type, String) = sysStatus match {
      case PCA_Types.Status_Type.Bolus => (Mode.PumpPatientButtonVTBI, patientBolusEventTimeoutId)
      case PCA_Types.Status_Type.Square_Bolus => (Mode.PumpCCBRate, squareBolusEventTimeoutId)
      case _ =>
        ArtSystem.assertThat(false, s"Unexpected status: $sysStatus", api.id)
        return
    }

    setInfusionFlowRate(api, flowRate, sysStatus)
    setMode(api, mode)

    val modeSwitched: art.Art.Time = lastModeChange
    def callback(): Unit = {
      // change to basal delivery provided that the mode hasn't changed since the pump switched to delivery modes
      if(lastModeChange == modeSwitched) {
        val basalRate : PCA_Types.Flow_Rate_imp = api.getBasal_Rate().get
        api.logInfo(s"${sysStatus} successfully delivered.  Switching to basal delivery at ${basalRate} ml/hr.")

        setInfusionFlowRate(api, basalRate, PCA_Types.Status_Type.Basal)
        setMode(api, Mode.PumpBasalRate)
      }
    }

    art.ArtTimer.setTimeout(api.id, eventId, duration, true, callback _)
  }

  def verifyDoorClosed(api: Rate_Controller_imp_Operational_Api): B = {
    val isOpen: B = api.getDoor_Open().get
    if(isOpen){
      api.logError(s"Door is open but pump is in ${currentMode}.  Requirements unclear regarding how this should be handled")
    }
    return !isOpen
  }

  def activate(api: Rate_Controller_imp_Operational_Api): Unit = { }

  def deactivate(api: Rate_Controller_imp_Operational_Api): Unit = { }

  def finalise(api: Rate_Controller_imp_Operational_Api): Unit = { }

  def recover(api: Rate_Controller_imp_Operational_Api): Unit = { }
}

@enum object Mode {
  'PowerOn       // initial state
  'WaitForRx     // wait for valid prescription
  'CheckPBR      // check Patient_Bolus_Rate is positive
  'RxApproved    // prescription verified
  'WaitForStart  // wait for clinician to press 'start' button

  'PumpPrimeRate         // pumping at prime rate

  'PumpBasalRate         // pumping at basal rate
  'PumpPatientButtonVTBI // pumping patient-requested bolus
  'PumpCCBRate           // pumping at clinician-commanded bolus rate
  'PumpKVORate           // pumping at keep-vein-open rate

  'PumpingSuspended      // clinician pressed 'stop' button
  'Crash                 // abnormal termination
  'Done                  // normal termination
}