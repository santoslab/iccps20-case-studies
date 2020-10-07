package pca_pump.PCA_Control_Panel

import art.{ArtNative_Ext, Empty}
import pca_pump._
import org.sireum._

// This file will not be overwritten so is safe to edit
class ui_thread_imp_pump_operation_control_panel_ui_process_ui_thread_Test extends BridgeTestSuite[ui_thread_imp_pump_operation_control_panel_ui_process_ui_thread_Bridge](Arch.wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread) {
  test("Example Unit Test"){
    executeTest()
  }

  //////////////////////
  // HELPER FUNCTIONS //
  //////////////////////

  // setter for in DataPort
  def put_Remaining_Battery_Time(value : BLESS_Types.Time): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Remaining_Battery_Time_Id, BLESS_Types.Time_Payload(value))
  }

  // setter for in DataPort
  def put_Using_Battery_Power(value : Base_Types.Boolean): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Using_Battery_Power_Id, Base_Types.Boolean_Payload(value))
  }

  // setter for in DataPort
  def put_Prescription(value : PCA_Types.Prescription_imp): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Prescription_Id, PCA_Types.Prescription_imp_Payload(value))
  }

  // setter for in DataPort
  def put_Infusion_Flow_Rate(value : PCA_Types.Flow_Rate_imp): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Infusion_Flow_Rate_Id, PCA_Types.Flow_Rate_imp_Payload(value))
  }

  // setter for in DataPort
  def put_Clinician_Name(value : Base_Types.String): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Clinician_Name_Id, Base_Types.String_Payload(value))
  }

  // setter for in DataPort
  def put_Patient_Name(value : Base_Types.String): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Patient_Name_Id, Base_Types.String_Payload(value))
  }

  // setter for in EventDataPort
  def put_Touch(value : PCA_Types.Touch): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Touch_Id, PCA_Types.Touch_Payload(value))
  }

  // setter for in EventDataPort
  def put_Alarm(value : PCA_Types.Alarm_Type.Type): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Alarm_Id, PCA_Types.Alarm_Type_Payload(value))
  }

  // setter for in EventDataPort
  def put_Warning(value : PCA_Types.Warning_Type.Type): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Warning_Id, PCA_Types.Warning_Type_Payload(value))
  }

  // setter for in EventDataPort
  def put_System_Status(value : PCA_Types.Status_Type.Type): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.System_Status_Id, PCA_Types.Status_Type_Payload(value))
  }

  // setter for in EventDataPort
  def put_Display_Message(value : PCA_Types.Message.Type): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Display_Message_Id, PCA_Types.Message_Payload(value))
  }

  // setter for in EventDataPort
  def put_Sound_Type(value : PCA_Types.Sound.Type): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Sound_Type_Id, PCA_Types.Sound_Payload(value))
  }

  // setter for in EventPort
  def put_Low_Battery_Warning(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Low_Battery_Warning_Id, Empty())
  }

  // setter for in EventPort
  def put_Hard_Limit_Violated(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Hard_Limit_Violated_Id, Empty())
  }

  // setter for in EventPort
  def put_Soft_Limit_Warning(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Soft_Limit_Warning_Id, Empty())
  }

  // setter for in EventPort
  def put_Patient_Request_Not_Too_Soon(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Patient_Request_Not_Too_Soon_Id, Empty())
  }

  // setter for in EventPort
  def put_Patient_Request_Too_Soon(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Patient_Request_Too_Soon_Id, Empty())
  }

  // getter for out DataPort
  def get_Image(): Option[PCA_Types.Image] = {
    val value: Option[PCA_Types.Image] = get_Image_payload() match {
      case Some(PCA_Types.Image_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port Image.  Expecting 'PCA_Types.Image_Payload' but received ${v}")
      case _ => None[PCA_Types.Image]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_Image_payload(): Option[PCA_Types.Image_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Image_Id).asInstanceOf[Option[PCA_Types.Image_Payload]]
  }

  // getter for out DataPort
  def get_AudioSignal(): Option[PCA_Types.Sound.Type] = {
    val value: Option[PCA_Types.Sound.Type] = get_AudioSignal_payload() match {
      case Some(PCA_Types.Sound_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port AudioSignal.  Expecting 'PCA_Types.Sound_Payload' but received ${v}")
      case _ => None[PCA_Types.Sound.Type]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_AudioSignal_payload(): Option[PCA_Types.Sound_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.AudioSignal_Id).asInstanceOf[Option[PCA_Types.Sound_Payload]]
  }

  // getter for out DataPort
  def get_Alarm_Inactivation(): Option[ICE_Types.Alarm_Signal.Type] = {
    val value: Option[ICE_Types.Alarm_Signal.Type] = get_Alarm_Inactivation_payload() match {
      case Some(ICE_Types.Alarm_Signal_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port Alarm_Inactivation.  Expecting 'ICE_Types.Alarm_Signal_Payload' but received ${v}")
      case _ => None[ICE_Types.Alarm_Signal.Type]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_Alarm_Inactivation_payload(): Option[ICE_Types.Alarm_Signal_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Alarm_Inactivation_Id).asInstanceOf[Option[ICE_Types.Alarm_Signal_Payload]]
  }

  // getter for out EventDataPort
  def get_Bolus_Duration(): Option[ICE_Types.Minute_imp] = {
    val value: Option[ICE_Types.Minute_imp] = get_Bolus_Duration_payload() match {
      case Some(ICE_Types.Minute_imp_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port Bolus_Duration.  Expecting 'ICE_Types.Minute_imp_Payload' but received ${v}")
      case _ => None[ICE_Types.Minute_imp]()
    }
    return value
  }

  // payload getter for out EventDataPort
  def get_Bolus_Duration_payload(): Option[ICE_Types.Minute_imp_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Bolus_Duration_Id).asInstanceOf[Option[ICE_Types.Minute_imp_Payload]]
  }

  // getter for out EventPort
  def get_CP_Reset_Alarm(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_CP_Reset_Alarm_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port CP_Reset_Alarm.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_CP_Reset_Alarm_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.CP_Reset_Alarm_Id).asInstanceOf[Option[Empty]]
  }

  // getter for out EventPort
  def get_Confirm_Soft_Limit_Exception(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_Confirm_Soft_Limit_Exception_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port Confirm_Soft_Limit_Exception.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_Confirm_Soft_Limit_Exception_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Confirm_Soft_Limit_Exception_Id).asInstanceOf[Option[Empty]]
  }

  // getter for out EventPort
  def get_Reject_Soft_Limit_Exception(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_Reject_Soft_Limit_Exception_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port Reject_Soft_Limit_Exception.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_Reject_Soft_Limit_Exception_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Reject_Soft_Limit_Exception_Id).asInstanceOf[Option[Empty]]
  }

  // getter for out EventPort
  def get_Stop_Button_Pressed(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_Stop_Button_Pressed_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port Stop_Button_Pressed.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_Stop_Button_Pressed_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Stop_Button_Pressed_Id).asInstanceOf[Option[Empty]]
  }

  // getter for out EventPort
  def get_Start_Button_Pressed(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_Start_Button_Pressed_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port Start_Button_Pressed.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_Start_Button_Pressed_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Start_Button_Pressed_Id).asInstanceOf[Option[Empty]]
  }

  // getter for out EventPort
  def get_Clinician_Request_Bolus(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_Clinician_Request_Bolus_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port Clinician_Request_Bolus.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_Clinician_Request_Bolus_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Clinician_Request_Bolus_Id).asInstanceOf[Option[Empty]]
  }

  // getter for out EventPort
  def get_Pause_Infusion(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_Pause_Infusion_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port Pause_Infusion.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_Pause_Infusion_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Pause_Infusion_Id).asInstanceOf[Option[Empty]]
  }

  // getter for out EventPort
  def get_Resume_Infusion(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_Resume_Infusion_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port Resume_Infusion.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_Resume_Infusion_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Resume_Infusion_Id).asInstanceOf[Option[Empty]]
  }

  // getter for out EventPort
  def get_Turn_Off(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_Turn_Off_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port Turn_Off.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_Turn_Off_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Turn_Off_Id).asInstanceOf[Option[Empty]]
  }

}
