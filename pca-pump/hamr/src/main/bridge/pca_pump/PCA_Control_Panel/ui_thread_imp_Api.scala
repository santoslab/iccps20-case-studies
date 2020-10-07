// #Sireum

package pca_pump.PCA_Control_Panel

import org.sireum._
import art._
import pca_pump._

@sig trait ui_thread_imp_Api {
  def id: Art.BridgeId
  def Image_Id : Art.PortId
  def AudioSignal_Id : Art.PortId
  def Alarm_Inactivation_Id : Art.PortId
  def Remaining_Battery_Time_Id : Art.PortId
  def Using_Battery_Power_Id : Art.PortId
  def Prescription_Id : Art.PortId
  def Infusion_Flow_Rate_Id : Art.PortId
  def Clinician_Name_Id : Art.PortId
  def Patient_Name_Id : Art.PortId
  def Touch_Id : Art.PortId
  def Alarm_Id : Art.PortId
  def Warning_Id : Art.PortId
  def System_Status_Id : Art.PortId
  def Display_Message_Id : Art.PortId
  def Sound_Type_Id : Art.PortId
  def Bolus_Duration_Id : Art.PortId
  def CP_Reset_Alarm_Id : Art.PortId
  def Low_Battery_Warning_Id : Art.PortId
  def Hard_Limit_Violated_Id : Art.PortId
  def Soft_Limit_Warning_Id : Art.PortId
  def Confirm_Soft_Limit_Exception_Id : Art.PortId
  def Reject_Soft_Limit_Exception_Id : Art.PortId
  def Stop_Button_Pressed_Id : Art.PortId
  def Start_Button_Pressed_Id : Art.PortId
  def Clinician_Request_Bolus_Id : Art.PortId
  def Pause_Infusion_Id : Art.PortId
  def Resume_Infusion_Id : Art.PortId
  def Turn_Off_Id : Art.PortId
  def Patient_Request_Not_Too_Soon_Id : Art.PortId
  def Patient_Request_Too_Soon_Id : Art.PortId

  def setImage(value : PCA_Types.Image) : Unit = {
    Art.putValue(Image_Id, PCA_Types.Image_Payload(value))
  }

  def setAudioSignal(value : PCA_Types.Sound.Type) : Unit = {
    Art.putValue(AudioSignal_Id, PCA_Types.Sound_Payload(value))
  }

  def setAlarm_Inactivation(value : ICE_Types.Alarm_Signal.Type) : Unit = {
    Art.putValue(Alarm_Inactivation_Id, ICE_Types.Alarm_Signal_Payload(value))
  }

  def sendBolus_Duration(value : ICE_Types.Minute_imp) : Unit = {
    Art.putValue(Bolus_Duration_Id, ICE_Types.Minute_imp_Payload(value))
  }

  def sendCP_Reset_Alarm() : Unit = {
    Art.putValue(CP_Reset_Alarm_Id, art.Empty())
  }

  def sendConfirm_Soft_Limit_Exception() : Unit = {
    Art.putValue(Confirm_Soft_Limit_Exception_Id, art.Empty())
  }

  def sendReject_Soft_Limit_Exception() : Unit = {
    Art.putValue(Reject_Soft_Limit_Exception_Id, art.Empty())
  }

  def sendStop_Button_Pressed() : Unit = {
    Art.putValue(Stop_Button_Pressed_Id, art.Empty())
  }

  def sendStart_Button_Pressed() : Unit = {
    Art.putValue(Start_Button_Pressed_Id, art.Empty())
  }

  def sendClinician_Request_Bolus() : Unit = {
    Art.putValue(Clinician_Request_Bolus_Id, art.Empty())
  }

  def sendPause_Infusion() : Unit = {
    Art.putValue(Pause_Infusion_Id, art.Empty())
  }

  def sendResume_Infusion() : Unit = {
    Art.putValue(Resume_Infusion_Id, art.Empty())
  }

  def sendTurn_Off() : Unit = {
    Art.putValue(Turn_Off_Id, art.Empty())
  }

  def logInfo(msg: String): Unit = {
    Art.logInfo(id, msg)
  }

  def logDebug(msg: String): Unit = {
    Art.logDebug(id, msg)
  }

  def logError(msg: String): Unit = {
    Art.logError(id, msg)
  }
}

@datatype class ui_thread_imp_Initialization_Api (
  val id: Art.BridgeId,
  val Image_Id : Art.PortId,
  val AudioSignal_Id : Art.PortId,
  val Alarm_Inactivation_Id : Art.PortId,
  val Remaining_Battery_Time_Id : Art.PortId,
  val Using_Battery_Power_Id : Art.PortId,
  val Prescription_Id : Art.PortId,
  val Infusion_Flow_Rate_Id : Art.PortId,
  val Clinician_Name_Id : Art.PortId,
  val Patient_Name_Id : Art.PortId,
  val Touch_Id : Art.PortId,
  val Alarm_Id : Art.PortId,
  val Warning_Id : Art.PortId,
  val System_Status_Id : Art.PortId,
  val Display_Message_Id : Art.PortId,
  val Sound_Type_Id : Art.PortId,
  val Bolus_Duration_Id : Art.PortId,
  val CP_Reset_Alarm_Id : Art.PortId,
  val Low_Battery_Warning_Id : Art.PortId,
  val Hard_Limit_Violated_Id : Art.PortId,
  val Soft_Limit_Warning_Id : Art.PortId,
  val Confirm_Soft_Limit_Exception_Id : Art.PortId,
  val Reject_Soft_Limit_Exception_Id : Art.PortId,
  val Stop_Button_Pressed_Id : Art.PortId,
  val Start_Button_Pressed_Id : Art.PortId,
  val Clinician_Request_Bolus_Id : Art.PortId,
  val Pause_Infusion_Id : Art.PortId,
  val Resume_Infusion_Id : Art.PortId,
  val Turn_Off_Id : Art.PortId,
  val Patient_Request_Not_Too_Soon_Id : Art.PortId,
  val Patient_Request_Too_Soon_Id : Art.PortId) extends ui_thread_imp_Api

@datatype class ui_thread_imp_Operational_Api (
  val id: Art.BridgeId,
  val Image_Id : Art.PortId,
  val AudioSignal_Id : Art.PortId,
  val Alarm_Inactivation_Id : Art.PortId,
  val Remaining_Battery_Time_Id : Art.PortId,
  val Using_Battery_Power_Id : Art.PortId,
  val Prescription_Id : Art.PortId,
  val Infusion_Flow_Rate_Id : Art.PortId,
  val Clinician_Name_Id : Art.PortId,
  val Patient_Name_Id : Art.PortId,
  val Touch_Id : Art.PortId,
  val Alarm_Id : Art.PortId,
  val Warning_Id : Art.PortId,
  val System_Status_Id : Art.PortId,
  val Display_Message_Id : Art.PortId,
  val Sound_Type_Id : Art.PortId,
  val Bolus_Duration_Id : Art.PortId,
  val CP_Reset_Alarm_Id : Art.PortId,
  val Low_Battery_Warning_Id : Art.PortId,
  val Hard_Limit_Violated_Id : Art.PortId,
  val Soft_Limit_Warning_Id : Art.PortId,
  val Confirm_Soft_Limit_Exception_Id : Art.PortId,
  val Reject_Soft_Limit_Exception_Id : Art.PortId,
  val Stop_Button_Pressed_Id : Art.PortId,
  val Start_Button_Pressed_Id : Art.PortId,
  val Clinician_Request_Bolus_Id : Art.PortId,
  val Pause_Infusion_Id : Art.PortId,
  val Resume_Infusion_Id : Art.PortId,
  val Turn_Off_Id : Art.PortId,
  val Patient_Request_Not_Too_Soon_Id : Art.PortId,
  val Patient_Request_Too_Soon_Id : Art.PortId) extends ui_thread_imp_Api {

  def getRemaining_Battery_Time() : Option[BLESS_Types.Time] = {
    val value : Option[BLESS_Types.Time] = Art.getValue(Remaining_Battery_Time_Id) match {
      case Some(BLESS_Types.Time_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Remaining_Battery_Time.  Expecting 'BLESS_Types.Time_Payload' but received ${v}")
        None[BLESS_Types.Time]()
      case _ => None[BLESS_Types.Time]()
    }
    return value
  }

  def getUsing_Battery_Power() : Option[Base_Types.Boolean] = {
    val value : Option[Base_Types.Boolean] = Art.getValue(Using_Battery_Power_Id) match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Using_Battery_Power.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
        None[Base_Types.Boolean]()
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }

  def getPrescription() : Option[PCA_Types.Prescription_imp] = {
    val value : Option[PCA_Types.Prescription_imp] = Art.getValue(Prescription_Id) match {
      case Some(PCA_Types.Prescription_imp_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Prescription.  Expecting 'PCA_Types.Prescription_imp_Payload' but received ${v}")
        None[PCA_Types.Prescription_imp]()
      case _ => None[PCA_Types.Prescription_imp]()
    }
    return value
  }

  def getInfusion_Flow_Rate() : Option[PCA_Types.Flow_Rate_imp] = {
    val value : Option[PCA_Types.Flow_Rate_imp] = Art.getValue(Infusion_Flow_Rate_Id) match {
      case Some(PCA_Types.Flow_Rate_imp_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Infusion_Flow_Rate.  Expecting 'PCA_Types.Flow_Rate_imp_Payload' but received ${v}")
        None[PCA_Types.Flow_Rate_imp]()
      case _ => None[PCA_Types.Flow_Rate_imp]()
    }
    return value
  }

  def getClinician_Name() : Option[Base_Types.String] = {
    val value : Option[Base_Types.String] = Art.getValue(Clinician_Name_Id) match {
      case Some(Base_Types.String_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Clinician_Name.  Expecting 'Base_Types.String_Payload' but received ${v}")
        None[Base_Types.String]()
      case _ => None[Base_Types.String]()
    }
    return value
  }

  def getPatient_Name() : Option[Base_Types.String] = {
    val value : Option[Base_Types.String] = Art.getValue(Patient_Name_Id) match {
      case Some(Base_Types.String_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Patient_Name.  Expecting 'Base_Types.String_Payload' but received ${v}")
        None[Base_Types.String]()
      case _ => None[Base_Types.String]()
    }
    return value
  }

  def getTouch() : Option[PCA_Types.Touch] = {
    val value : Option[PCA_Types.Touch] = Art.getValue(Touch_Id) match {
      case Some(PCA_Types.Touch_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Touch.  Expecting 'PCA_Types.Touch_Payload' but received ${v}")
        None[PCA_Types.Touch]()
      case _ => None[PCA_Types.Touch]()
    }
    return value
  }

  def getAlarm() : Option[PCA_Types.Alarm_Type.Type] = {
    val value : Option[PCA_Types.Alarm_Type.Type] = Art.getValue(Alarm_Id) match {
      case Some(PCA_Types.Alarm_Type_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Alarm.  Expecting 'PCA_Types.Alarm_Type_Payload' but received ${v}")
        None[PCA_Types.Alarm_Type.Type]()
      case _ => None[PCA_Types.Alarm_Type.Type]()
    }
    return value
  }

  def getWarning() : Option[PCA_Types.Warning_Type.Type] = {
    val value : Option[PCA_Types.Warning_Type.Type] = Art.getValue(Warning_Id) match {
      case Some(PCA_Types.Warning_Type_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Warning.  Expecting 'PCA_Types.Warning_Type_Payload' but received ${v}")
        None[PCA_Types.Warning_Type.Type]()
      case _ => None[PCA_Types.Warning_Type.Type]()
    }
    return value
  }

  def getSystem_Status() : Option[PCA_Types.Status_Type.Type] = {
    val value : Option[PCA_Types.Status_Type.Type] = Art.getValue(System_Status_Id) match {
      case Some(PCA_Types.Status_Type_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port System_Status.  Expecting 'PCA_Types.Status_Type_Payload' but received ${v}")
        None[PCA_Types.Status_Type.Type]()
      case _ => None[PCA_Types.Status_Type.Type]()
    }
    return value
  }

  def getDisplay_Message() : Option[PCA_Types.Message.Type] = {
    val value : Option[PCA_Types.Message.Type] = Art.getValue(Display_Message_Id) match {
      case Some(PCA_Types.Message_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Display_Message.  Expecting 'PCA_Types.Message_Payload' but received ${v}")
        None[PCA_Types.Message.Type]()
      case _ => None[PCA_Types.Message.Type]()
    }
    return value
  }

  def getSound_Type() : Option[PCA_Types.Sound.Type] = {
    val value : Option[PCA_Types.Sound.Type] = Art.getValue(Sound_Type_Id) match {
      case Some(PCA_Types.Sound_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Sound_Type.  Expecting 'PCA_Types.Sound_Payload' but received ${v}")
        None[PCA_Types.Sound.Type]()
      case _ => None[PCA_Types.Sound.Type]()
    }
    return value
  }

  def getLow_Battery_Warning() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(Low_Battery_Warning_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Low_Battery_Warning.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  def getHard_Limit_Violated() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(Hard_Limit_Violated_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Hard_Limit_Violated.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  def getSoft_Limit_Warning() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(Soft_Limit_Warning_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Soft_Limit_Warning.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  def getPatient_Request_Not_Too_Soon() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(Patient_Request_Not_Too_Soon_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Patient_Request_Not_Too_Soon.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  def getPatient_Request_Too_Soon() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(Patient_Request_Too_Soon_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Patient_Request_Too_Soon.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }
}
