// #Sireum

package pca_pump.PCA_Control_Panel

import org.sireum._
import pca_pump.PCA_Types._
import pca_pump._
import org.sireum.S16._
import pca_pump.util.AuxLibrary

// This file will not be overwritten so is safe to edit
object ui_thread_imp_pump_operation_control_panel_ui_process_ui_thread {

  val upButtonImage: String = AuxLibrary.getUnicodeCharacter(9650)   // BLACK UP-POINTING TRIANGLE
  val downButtonImage: String = AuxLibrary.getUnicodeCharacter(9660) // BLACK DOWN-POINTING TRIANGLE

  var lastPrescription: Option[PCA_Types.Prescription_imp] = None[PCA_Types.Prescription_imp]()

  var lastMessage: Option[PCA_Types.Message_Image] = None[PCA_Types.Message_Image]()

  var timerSet : B = F
  var imageQueue: ISZ[PCA_Types.Image_Type] = ISZ[PCA_Types.Image_Type]()

  var currentMode: Mode.Type = Mode.Normal

  def queueImages(api: ui_thread_imp_Api, image: PCA_Types.Image_Type) : Unit = {
    // queue images for 'waitTime' ms to give pca_screen time to consume previous images
    val waitTime: art.Art.Time = 100

    imageQueue = imageQueue :+ image

    image match {
      case p: PCA_Types.Message_Image => lastMessage = Some(p)
      case _ =>
    }

    if(!timerSet) {
      timerSet = T
      def cb(): Unit = {
        api.setImage(PCA_Types.Image(imageQueue))
        imageQueue = ISZ[PCA_Types.Image_Type]()
        timerSet = F
      }
      art.ArtTimer.setTimeout(api.id, "ui_thread_timer", waitTime, true, cb _)
    }
  }

  def handleTouch(api: ui_thread_imp_Operational_Api, value : PCA_Types.Touch): Unit = {
    api.logInfo(s"received Touch ${value}")

    value match {
      case p: PCA_Types.SimpleButton_Touch =>
        p.buttonId match {
          case Button_Id.Start_Button_Pressed =>
            api.sendStart_Button_Pressed()

          case Button_Id.Stop_Button_Pressed =>
            api.sendStop_Button_Pressed()

          case Button_Id.CP_Reset_Alarm =>
            api.sendCP_Reset_Alarm()

          case Button_Id.Clinician_Request_Bolus =>
            api.sendClinician_Request_Bolus()

          case Button_Id.Up => handleUpDownPress(api, true)
          case Button_Id.Down => handleUpDownPress(api, false)

          case _ =>
            println(s"ui_thread: need to handle $p")
        }
      case p: PCA_Types.SquareBolusDuration_Touch =>
        api.logDebug(s"ui_thread: received $p")
    }
  }

  def handleAlarm(api: ui_thread_imp_Operational_Api, value : PCA_Types.Alarm_Type.Type): Unit = {
    api.logInfo(s"received Alarm ${value}")

    val s: String = value match {
      case Alarm_Type.Air_In_Line => "Air-In-Line Embolism Detected"
      case Alarm_Type.Basal_Overinfusion => "Basal Overinfusion Detected"
      case Alarm_Type.Bolus_Overinfusion => "Bolus Overinfusion Detected"
      case Alarm_Type.CPU_Failure => "CPU Failure Detected"
      case Alarm_Type.Defective_Battery => "Defective Battery Detected"
      case Alarm_Type.Downstream_Occlusion => "Downstream Occlusion Detected"
      case Alarm_Type.Empty_Reservoir => "Empty Reservoir Detected"
      case Alarm_Type.No_Alarm => ""
      case Alarm_Type.POST_Failure => "POST Failure Detected"
      case Alarm_Type.Priming_Failure => "Priming Failure Detected"
      case Alarm_Type.Pump_Overheated => "Pump Overheating Detected"
      case Alarm_Type.RAM_Failure => "RAM Failure Detected"
      case Alarm_Type.ROM_Failure => "ROM Failure Detected"
      case Alarm_Type.Square_Bolus_Overinfusion => "Square Bolus Overinfusion Detected"
      case Alarm_Type.Thread_Monitor_Failure => "Thread Monitor Failure Detected"
      case Alarm_Type.Upstream_Occlusion => "Upstream Occlusion Detected"
      case Alarm_Type.Low_Battery => "Low Battery"
    }

    val message : String = if(value == Alarm_Type.No_Alarm) "" else "Press Clear"

    queueImages(api, PCA_Types.Alarm_Image(s))
    queueImages(api, PCA_Types.Message_Image(message))
  }

  def handleWarning(api: ui_thread_imp_Operational_Api, value : PCA_Types.Warning_Type.Type): Unit = {
    api.logInfo(s"received Warning ${value}")

    val s : String = value match {
      case Warning_Type.Basal_Underinfusion => "Basal Underinfusion Detected"
      case Warning_Type.Bolus_Underinfusion => "Bolus Underinfusion Detected"
      case Warning_Type.Drug_Not_In_Library => "Drug not present in drug library"
      case Warning_Type.Hard_Limit_Violated => "Hard Limit Violated"
      case Warning_Type.Input_Needed => "Input Needed"
      case Warning_Type.Long_Pause => "Long Pause Detected"
      case Warning_Type.Low_Battery => "Low Battery Detected"
      case Warning_Type.Low_Reservoir => "Low Reservoir Detected"
      case Warning_Type.Over_Max_Drug_Per_Hour => "Maximum drug per hour exceeded"
      case Warning_Type.No_Warning => ""
      case Warning_Type.Priming_Failure => "Priming Failure"
      case Warning_Type.Soft_Limit => "Soft Limit Violated"
      case Warning_Type.Square_Bolus_Underinfusion => "Square Bolus Underinfusion Detected"
      case Warning_Type.Voltage_OOR => "Voltage Out-Of-Range Detected"
    }

    val message : String = if(value == Warning_Type.No_Warning) "" else "Press Clear"

    queueImages(api, PCA_Types.Alarm_Image(s))
    queueImages(api, PCA_Types.Message_Image(message))
  }

  def handleSystem_Status(api: ui_thread_imp_Operational_Api, value : PCA_Types.Status_Type.Type): Unit = {
    api.logInfo(s"received System_Status ${value}")

    val ifr: S16 = if(api.getInfusion_Flow_Rate().nonEmpty) {
      api.getInfusion_Flow_Rate().get.value
    } else {
      s16"0"
    }

    val s: org.sireum.String = s"System Status: ${value}"
    queueImages(api, PCA_Types.SystemStatus_Image(s))
    queueImages(api, PCA_Types.InfusionFlowRate_Image(s"Flow Rate: ${ifr} ml/hr"))
  }

  def handleDisplay_Message(api: ui_thread_imp_Operational_Api, value : PCA_Types.Message.Type): Unit = {
    api.logInfo(s"received Display_Message ${value}")
    val s: org.sireum.String = value match {
      case Message.No_Message => ""
      case Message.POST_fail => "POSTing failed"
      case Message.Turn_Off => "Turn pump off"
      case Message.If_Beep_Press_Stop_Button => "Press Stop if pump is beeping"
      case Message.Scan_Badge => "Scan Clinician Badge"
      case Message.Scan_Wristband => "Scan Patient Wristband"
      case Message.Scan_Rx => "Scan barcode on vial"
      case Message.Clinician_Not_Authenticated => "Clinician authenticatication failed"
      case Message.Patient_Not_Authenticated => "Patient authenticatication failed"
      case Message.Prescription_Not_Authenticated => "Prescription authenticatication failed"
      case Message.Hard_Limit_Violated => "Hard Limit Violated"
      case Message.Soft_Limit_Rejected => "Soft Limit Rejected"
      case Message.Sound_Failure => "Sound Failure"
      case Message.Insert_Needle_Then_Press_Start => "Insert needle and press Start"
      case Message.Insert_Vial_and_Close_Door => "Insert the vial and press Door Lock"
      case Message.Press_start_to_begin_priming => "Press Start to begin priming"
      case Message.Press_stop_to_end_priming => "Press Stop to end priming"
      case Message.Press_Stop_Again_To_End_Infusion_Press_Start_To_Resume_Infusion => "Press Stop again to end infusion.  Press Start to resume infusion"
      case Message.Priming_Failure => "Priming failed"
      case Message.Drug_Not_In_Library => "Drug not in the drug library"
    }
    queueImages(api, PCA_Types.Message_Image(s))

    if(lastPrescription != api.getPrescription() && api.getPrescription().nonEmpty) {
      lastPrescription = api.getPrescription()

      val drugName: String = lastPrescription.get.drugName
      val concentration: F32  = lastPrescription.get.concentration.value

      queueImages(api, PCA_Types.DrugName_Image(drugName))
      queueImages(api, PCA_Types.DrugConcentration_Image(s"${concentration} mg/ml"))
    }
  }

  def handleSound_Type(api: ui_thread_imp_Operational_Api, value : PCA_Types.Sound.Type): Unit = {
    api.logInfo(s"received ${value}")

    api.setAudioSignal(value)
  }

  def handleLow_Battery_Warning(api: ui_thread_imp_Operational_Api): Unit = {
    // FIXME: prescription_checker sends Hard_Limit_Violated to alarm_thread (which emits a warning that will be
    // be handled by ui_thread) and to Boss_Thread so ui_thread probably doesn't need to receive this event directly
    //api.logInfo("example handleLow_Battery_Warning implementation")
    //api.logInfo("received Low_Battery_Warning")
  }

  def handleHard_Limit_Violated(api: ui_thread_imp_Operational_Api): Unit = {
    // FIXME: prescription_checker sends Hard_Limit_Violated to alarm_thread (which emits a warning that will be
    // be handled by ui_thread) and to Boss_Thread so ui_thread probably doesn't need to receive this event directly
    //api.logInfo("example handleHard_Limit_Violated implementation")
    //api.logInfo("received Hard_Limit_Violated")
  }

  def handleSoft_Limit_Warning(api: ui_thread_imp_Operational_Api): Unit = {
    api.logInfo("received Soft_Limit_Warning")

    // prescription_checker only sends Soft_Limit_Warning to the ui_thread (i.e. it's not a typical
    // alarm/warning so don't display it in the alarm section)
    // queueImages(PCA_Types.Alarm_Image("Soft Limit Violated"))

    queueImages(api, PCA_Types.Message_Image(s"Soft Limit Warning.  Press $upButtonImage to accept or press $downButtonImage to reject"))

    setMode(Mode.WaitingForSoftLimitWarningAction)
  }

  def handlePatient_Request_Not_Too_Soon(api: ui_thread_imp_Operational_Api): Unit = {
    api.logInfo("received Patient_Request_Not_Too_Soon")
    val m = PCA_Types.Message_Image("Patient Bolus approved")
    queueImages(api, m)

    // clear the message after 10 seconds
    def cb(): Unit = {
      if (lastMessage == Some(m)) {
        queueImages(api, PCA_Types.Message_Image(""))
      }
    }
    art.ArtTimer.setTimeout(api.id, "pbapproved_timer", 10000, true, cb _)
  }

  def handlePatient_Request_Too_Soon(api: ui_thread_imp_Operational_Api): Unit = {
    api.logInfo("received Patient_Request_Too_Soon")
    val m = PCA_Types.Message_Image("Patient Bolus denied")
    queueImages(api, m)

    // clear the message after 10 seconds
    def cb(): Unit = {
      if (lastMessage == Some(m)) {
        queueImages(api, PCA_Types.Message_Image(""))
      }
    }
    art.ArtTimer.setTimeout(api.id, "pbdenied_timer", 10000, true, cb _)
  }


  def handleUpDownPress(api: ui_thread_imp_Api, upButtonPressed: B): Unit = {
    currentMode match {
      case Mode.WaitingForSoftLimitWarningAction =>
        if(upButtonPressed) {
          api.sendConfirm_Soft_Limit_Exception()
        } else {
          api.sendReject_Soft_Limit_Exception()
        }
        currentMode = Mode.Normal
      case _ =>
        api.logError(s"Not expecting Up/Down button press while in mode ${currentMode}")
    }
  }

  def setMode(m: Mode.Type) : Unit = {
    currentMode = m
  }

  def initialise(api: ui_thread_imp_Initialization_Api): Unit = { }

  def activate(api: ui_thread_imp_Operational_Api): Unit = { }

  def deactivate(api: ui_thread_imp_Operational_Api): Unit = { }

  def finalise(api: ui_thread_imp_Operational_Api): Unit = { }

  def recover(api: ui_thread_imp_Operational_Api): Unit = { }
}

@enum object Mode{
  'Normal
  'WaitingForSoftLimitWarningAction
}