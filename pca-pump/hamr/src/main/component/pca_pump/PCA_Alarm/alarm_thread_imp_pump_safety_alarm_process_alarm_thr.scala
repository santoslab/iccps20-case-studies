// #Sireum

package pca_pump.PCA_Alarm

import org.sireum._
import art.Art
import pca_pump._

// This file will not be overwritten so is safe to edit
object alarm_thread_imp_pump_safety_alarm_process_alarm_thr {
  var currentWarning: PCA_Types.Warning_Type.Type = PCA_Types.Warning_Type.No_Warning
  var currentAlarm: PCA_Types.Alarm_Type.Type = PCA_Types.Alarm_Type.No_Alarm

  def handleICE_Alarm_Signal(api: alarm_thread_imp_Operational_Api, value: ICE_Types.Alarm_Signal.Type): Unit = {
    /* FIXME: unclear how this event should be handled
     * See Section 5.4.2 Alarm Visual  {@link https://www.smarturl.it/IPCA#page=54}
     *     Section 5.4.3 Alarm Audible {@link https://www.smarturl.it/IPCA#page=54}
     *
     * Note that the original port was 'in out' and was changed to just 'in'
     *
     * Currently it is not connected to anything
     */
    api.logInfo("received ICE_Alarm_Signal $value")

    api.logError("Unclear how this should be handled")
  }

  def handleICE_Reset_Alarm(api: alarm_thread_imp_Operational_Api): Unit = {
    // FIXME
    // req: ???
    api.logInfo("received ICE_Reset_Alarm")

    helperResetAlarmWarning(api)
  }

  def handleMax_Dose_Warning(api: alarm_thread_imp_Operational_Api): Unit = {
    /* req: EC13 Maximum Safe Dose     {@link https://www.smarturl.it/IPCA#page=43}
     * req: R4.2.0(5) max dose warning {@link https://www.smarturl.it/IPCA#page=50}
     * Table 4: PCA Pump Alarm Priority and Alarm Pump Rate {@link https://www.smarturl.it/IPCA#page=53}
     */
    api.logInfo("received Max_Dose_Warning")

    sendWarningAndLogFault(api, PCA_Types.Warning_Type.Over_Max_Drug_Per_Hour)

    api.sendPump_At_KVO_Rate()
  }

  def handleHard_Limit_Violation(api: alarm_thread_imp_Operational_Api): Unit = {
    /* req: EC3 Drug Library Hard Limit {@link https://www.smarturl.it/IPCA#page=35}
     * req: R5.5.0(10) hard limit       {@link https://www.smarturl.it/IPCA#page=56}
     */
    api.logInfo("received Hard_Limit_Violation")

    sendWarningAndLogFault(api, PCA_Types.Warning_Type.Hard_Limit_Violated)
  }

  def handleEmpty_Res(api: alarm_thread_imp_Operational_Api): Unit = {
    /* req: EC21 Reservoir Empty             {@link https://www.smarturl.it/IPCA#page=47}
     * req: R5.8.0(10) empty-reservoir alarm {@link https://www.smarturl.it/IPCA#page=59}
     * req: Table 4: PCA Pump Alarm Priority and Alarm Pump Rate {@link https://www.smarturl.it/IPCA#page=53}
     */
    api.logInfo("received Empty_Res")

    sendAlarmAndLogFault(api, PCA_Types.Alarm_Type.Empty_Reservoir)

    api.sendStop_Pump_Completely()
  }

  def handleLow_Res(api: alarm_thread_imp_Operational_Api): Unit = {
    /* req: EC20 Reservoir Low              {@link https://www.smarturl.it/IPCA#page=46}
     * req: R5.8.0(9) low-reservoir warning {@link https://www.smarturl.it/IPCA#page=59}
     * req: Table 4: PCA Pump Alarm Priority and Alarm Pump Rate {@link https://www.smarturl.it/IPCA#page=53}*
     */
    api.logInfo("received Low_Res")

    sendWarningAndLogFault(api, PCA_Types.Warning_Type.Low_Reservoir)

    api.sendPump_At_KVO_Rate()
  }

  def handlePump_Hot(api: alarm_thread_imp_Operational_Api): Unit = {
    /* req: EC9 Pump Overheating            {@link https://www.smarturl.it/IPCA#page=41}
     * req: R5.4.0(8) pump overheated alarm {@link https://www.smarturl.it/IPCA#page=52}
     * req: Table 4: PCA Pump Alarm Priority and Alarm Pump Rate {@link https://www.smarturl.it/IPCA#page=53}
     */
    api.logInfo("received Pump_Hot")

    sendAlarmAndLogFault(api, PCA_Types.Alarm_Type.Pump_Overheated)

    api.sendStop_Pump_Completely()
  }

  def handleUpstream_Occlusion(api: alarm_thread_imp_Operational_Api): Unit = {
    /* req: EC11 Upstream Occlusion               {@link https://www.smarturl.it/IPCA#page=41}
     * req: R6.2.0(4) downstream occlusion alarm  {@link https://www.smarturl.it/IPCA#page=61}
     * req: Table 4: PCA Pump Alarm Priority and Alarm Pump Rate {@link https://www.smarturl.it/IPCA#page=53}
     */
    api.logInfo("received Upstream_Occlusion")

    sendAlarmAndLogFault(api, PCA_Types.Alarm_Type.Upstream_Occlusion)

    api.sendStop_Pump_Completely()
  }

  def handleDownstream_Occlusion(api: alarm_thread_imp_Operational_Api): Unit = {
    /* req: EC10 Downstream Occlusion             {@link https://www.smarturl.it/IPCA#page=41}
     * req: R6.2.0(5) downstream occlusion alarm  {@link https://www.smarturl.it/IPCA#page=61}
     * req: Table 4: PCA Pump Alarm Priority and Alarm Pump Rate {@link https://www.smarturl.it/IPCA#page=53}
     */
    api.logInfo("received Downstream_Occlusion")

    sendAlarmAndLogFault(api, PCA_Types.Alarm_Type.Downstream_Occlusion)

    api.sendStop_Pump_Completely()  }

  def handleBubble(api: alarm_thread_imp_Operational_Api): Unit = {
    /* req: EC12 Air-in-line Embolism              {@link https://www.smarturl.it/OPCA#ec_bubble}
     * req: R6.2.0(3) air-in-line alarm            {@link https://www.smarturl.it/OPCA#sec_anomalydetectionandresponse}
     * req: Table 4: PCA Pump Alarm Priority and Alarm Pump Rate {@link https://www.smarturl.it/OPCA#pap}
     */
    api.logInfo("received air-in-line notification")

    sendAlarmAndLogFault(api, PCA_Types.Alarm_Type.Air_In_Line)

    api.sendStop_Pump_Completely()
  }

  def handlePrime_Failure(api: alarm_thread_imp_Operational_Api): Unit = {
    /* req: EC6 Pump Priming Failure {@link https://www.smarturl.it/IPCA#page=37}
     */
    api.logInfo("received Prime_Failure")

    // FIXME: EC6 states a *priming failure alarm* is sounded, but
    // PrimingFailure was only found in Warning_Type.  Moved it to
    // from Warning_Type to Alarm_Type
    sendAlarmAndLogFault(api, PCA_Types.Alarm_Type.Priming_Failure)
  }

  def handleCP_Reset_Alarm(api: alarm_thread_imp_Operational_Api): Unit = {
    // FIXME
    // req: ???
    api.logInfo("received CP_Reset_Alarm")

    helperResetAlarmWarning(api)
  }

  def handleDrug_Not_In_Library(api: alarm_thread_imp_Operational_Api): Unit = {
    /* req: 5.9.0(4) Drug Library {@link https://www.smarturl.it/IPCA#page=59}
     */
    api.logInfo("received Drug_Not_In_Library")

    sendWarningAndLogFault(api, PCA_Types.Warning_Type.Drug_Not_In_Library)

    // assume pump is already stopped
  }

  def handleDefective_Btty(api: alarm_thread_imp_Operational_Api): Unit = {
    /* req: EC5.1 battery failure alarm     {@link https://www.smarturl.it/IPCA#page=37}
     * req: R6.3.0(5) battery failure alarm {@link https://www.smarturl.it/IPCA#page=62}
     * req: Table 4: PCA Pump Alarm Priority and Alarm Pump Rate {@link https://www.smarturl.it/IPCA#page=53}
     */
    api.logInfo("received Defective_Btty")

    sendAlarmAndLogFault(api, PCA_Types.Alarm_Type.Defective_Battery)

    // FIXME: unclear how pump should respond
    // see EC 22 a)  {@link https://www.smarturl.it/IPCA#page=47}
    //     R5.4.1(3) {@link https://www.smarturl.it/IPCA#page=52}
    api.logError("Not clear how to pump should respond.")
  }

  def handleLow_Battery_Warning(api: alarm_thread_imp_Operational_Api): Unit = {
    /* req: R6.3.0(4) low-battery warning {@link https://www.smarturl.it/IPCA#page=62}
     * req: Table 4: PCA Pump Alarm Priority and Alarm Pump Rate {@link https://www.smarturl.it/IPCA#page=53}
     */
    api.logInfo("received Low_Battery_Warning")

    sendWarningAndLogFault(api, PCA_Types.Warning_Type.Low_Battery)

    api.sendPump_At_KVO_Rate()
  }

  def handleVoltage_OOR(api: alarm_thread_imp_Operational_Api): Unit = {
    /* req: EC5.1 voltage out-of-range warning   {@link https://www.smarturl.it/IPCA#page=37}
     * req: EC22.a Diagnostic Detected Hazard    {@link https://www.smarturl.it/IPCA#page=47}
     * req: R6.3.0(6) voltage out-of-range warning  {@link https://www.smarturl.it/IPCA#page=62}
     * req: Table 4: PCA Pump Alarm Priority and Alarm Pump Rate {@link https://www.smarturl.it/IPCA#page=53}
     */
    api.logInfo("received Voltage_OOR")

    sendWarningAndLogFault(api, PCA_Types.Warning_Type.Voltage_OOR)

    // FIXME: pump behavior depends on if battery alarm failure
    // see EC 22 a)  {@link https://www.smarturl.it/IPCA#page=47}
    //     R5.4.1(3) {@link https://www.smarturl.it/IPCA#page=52}
    api.logError("Not clear how to pump should respond.")
  }

  def handleBasal_Overinfusion(api: alarm_thread_imp_Operational_Api): Unit = {

    /* req: EC7 a) basal over-infusion alarm    {@link https://www.smarturl.it/IPCA#page=38}
     * req: R5.4.0(2) basal over-infusion alarm {@link https://www.smarturl.it/IPCA#page=51}
     * Table 4: PCA Pump Alarm Priority and Alarm Pump Rate {@link https://www.smarturl.it/IPCA#page=53}
     */

    api.logInfo("received Basal_Overinfusion")

    sendAlarmAndLogFault(api, PCA_Types.Alarm_Type.Basal_Overinfusion)

    api.sendPump_At_KVO_Rate()

    //api.logInfo("Issued basal over infusion alarm and command to pump at KVO")
  }

  def handleBolus_Overinfusion(api: alarm_thread_imp_Operational_Api): Unit = {
    /* req: EC7 c) bolus over-infusion alarm    {@link https://www.smarturl.it/IPCA#page=39}
     * req: R5.4.0(4) bolus over-infusion alarm {@link https://www.smarturl.it/IPCA#page=52}
     * Table 4: PCA Pump Alarm Priority and Alarm Pump Rate {@link https://www.smarturl.it/IPCA#page=53}
     */
    api.logInfo("received Bolus_Overinfusion")

    sendAlarmAndLogFault(api, PCA_Types.Alarm_Type.Bolus_Overinfusion)

    api.sendPump_At_KVO_Rate()

    //api.logInfo("Issued bolus over infusion alarm and command to pump at KVO")
  }

  def handleSquare_Bolus_Overinfusion(api: alarm_thread_imp_Operational_Api): Unit = {
    /* req: EC7 e) square bolus over-infusion alarm    {@link https://www.smarturl.it/IPCA#page=39}
     * req: R5.4.0(6) square bolus over-infusion alarm {@link https://www.smarturl.it/IPCA#page=52}
     * Table 4: PCA Pump Alarm Priority and Alarm Pump Rate {@link https://www.smarturl.it/IPCA#page=53}
     */
    api.logInfo("received Square_Bolus_Overinfusion")

    sendAlarmAndLogFault(api, PCA_Types.Alarm_Type.Square_Bolus_Overinfusion)

    api.sendPump_At_KVO_Rate()

    //api.logInfo("Issued square bolus over infusion alarm and command to pump at KVO")
  }

  def handleBasal_Underinfusion(api: alarm_thread_imp_Operational_Api): Unit = {
    /* req: EC8 a) basal under-infusion warning    {@link https://www.smarturl.it/IPCA#page=39}
     *  req: R5.4.0(3) basal under-infusion warning {@link https://www.smarturl.it/IPCA#page=52}
     *  Table 4: PCA Pump Alarm Priority and Alarm Pump Rate {@link https://www.smarturl.it/IPCA#page=53}
     */
    api.logInfo("received Basal_Underinfusion")

    sendWarningAndLogFault(api, PCA_Types.Warning_Type.Basal_Underinfusion)

    //api.logInfo("Issued basal under infusion warning")
  }

  def handleBolus_Underinfusion(api: alarm_thread_imp_Operational_Api): Unit = {
    /* req: EC8 b) bolus under-infusion warning    {@link https://www.smarturl.it/IPCA#page=39}
     * req: R5.4.0(5) bolus under-infusion warning {@link https://www.smarturl.it/IPCA#page=52}
     * Table 4: PCA Pump Alarm Priority and Alarm Pump Rate {@link https://www.smarturl.it/IPCA#page=53}
     */
    api.logInfo("received Bolus_Underinfusion")

    sendWarningAndLogFault(api, PCA_Types.Warning_Type.Bolus_Underinfusion)

    //api.logInfo("Issued bolus under infusion warning")
  }

  def handleSquare_Bolus_Underinfusion(api: alarm_thread_imp_Operational_Api): Unit = {
    /* req: EC8 c) square bolus under-infusion warning    {@link https://www.smarturl.it/IPCA#page=39}
     * req: R5.4.0(7) square bolus under-infusion warning {@link https://www.smarturl.it/IPCA#page=52}
     * Table 4: PCA Pump Alarm Priority and Alarm Pump Rate {@link https://www.smarturl.it/IPCA#page=53}
     */
    api.logInfo("received Square_Bolus_Underinfusion")

    sendWarningAndLogFault(api, PCA_Types.Warning_Type.Square_Bolus_Underinfusion)

    //api.logInfo("Issued square bolus under infusion warning")
  }

  def handleSecurity_Fault(api: alarm_thread_imp_Operational_Api): Unit = {
    // FIXME
    api.logInfo("example handleSecurity_Fault implementation")
    api.logError("Unclear how to handle this event")
  }


  def helperResetAlarmWarning(api: alarm_thread_imp_Api): Unit = {
    currentWarning = PCA_Types.Warning_Type.No_Warning
    currentAlarm = PCA_Types.Alarm_Type.No_Alarm

    api.sendWarning(currentWarning)
    api.sendAlarm(currentAlarm)

    api.sendLog_Fault(PCA_Types.Fault_Record_imp(
      alarm = currentAlarm,
      warning = currentWarning,
      occurrence_time = Art.time()))
  }

  def sendWarningAndLogFault(api: alarm_thread_imp_Api, theWarning: PCA_Types.Warning_Type.Type): Unit = {
    currentWarning = theWarning

    api.sendWarning(theWarning)

    api.sendLog_Fault(PCA_Types.Fault_Record_imp(
      alarm = currentAlarm,
      warning = theWarning,
      occurrence_time = Art.time())
    )
  }

  def sendAlarmAndLogFault(api: alarm_thread_imp_Api, theAlarm: PCA_Types.Alarm_Type.Type): Unit = {
    currentAlarm = theAlarm

    api.sendAlarm(theAlarm)

    api.sendLog_Fault(PCA_Types.Fault_Record_imp(
      alarm = theAlarm,
      warning = currentWarning,
      occurrence_time = Art.time())
    )
  }

  def initialise(api: alarm_thread_imp_Initialization_Api): Unit = {}

  def activate(api: alarm_thread_imp_Operational_Api): Unit = {}

  def deactivate(api: alarm_thread_imp_Operational_Api): Unit = {}

  def finalise(api: alarm_thread_imp_Operational_Api): Unit = {}

  def recover(api: alarm_thread_imp_Operational_Api): Unit = {}
}
