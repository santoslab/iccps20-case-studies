package pca_pump.PCA_Boss

import art.{ArtNative_Ext, Empty}
import pca_pump._
import org.sireum._

// This file will not be overwritten so is safe to edit
class Boss_Thread_imp_pump_operation_operation_process_operation_threads_boss_Test extends BridgeTestSuite[Boss_Thread_imp_pump_operation_operation_process_operation_threads_boss_Bridge](Arch.wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_boss) {
  test("Example Unit Test"){
    executeTest()
  }

  //////////////////////
  // HELPER FUNCTIONS //
  //////////////////////

  // setter for in EventPort
  def put_POST_done(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.POST_done_Id, Empty())
  }

  // setter for in EventPort
  def put_POST_fail(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.POST_fail_Id, Empty())
  }

  // setter for in EventPort
  def put_Stop_Button_Pressed(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Stop_Button_Pressed_Id, Empty())
  }

  // setter for in EventPort
  def put_Start_Button_Pressed(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Start_Button_Pressed_Id, Empty())
  }

  // setter for in EventPort
  def put_Scan_Done(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Scan_Done_Id, Empty())
  }

  // setter for in EventPort
  def put_Authentication_fail(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Authentication_fail_Id, Empty())
  }

  // setter for in EventPort
  def put_Authentication_pass(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Authentication_pass_Id, Empty())
  }

  // setter for in EventPort
  def put_Drug_Not_In_Library(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Drug_Not_In_Library_Id, Empty())
  }

  // setter for in EventPort
  def put_Hard_Limit_Violated(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Hard_Limit_Violated_Id, Empty())
  }

  // setter for in EventPort
  def put_Reject_Soft_Limit_Exception(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Reject_Soft_Limit_Exception_Id, Empty())
  }

  // setter for in EventPort
  def put_Confirm_Soft_Limit_Exception(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Confirm_Soft_Limit_Exception_Id, Empty())
  }

  // setter for in EventPort
  def put_Rx_Okay(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Rx_Okay_Id, Empty())
  }

  // setter for in EventPort
  def put_Door_Closed(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Door_Closed_Id, Empty())
  }

  // setter for in EventPort
  def put_Turn_Off(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Turn_Off_Id, Empty())
  }

  // getter for out EventDataPort
  def get_Display_Message(): Option[PCA_Types.Message.Type] = {
    val value: Option[PCA_Types.Message.Type] = get_Display_Message_payload() match {
      case Some(PCA_Types.Message_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port Display_Message.  Expecting 'PCA_Types.Message_Payload' but received ${v}")
      case _ => None[PCA_Types.Message.Type]()
    }
    return value
  }

  // payload getter for out EventDataPort
  def get_Display_Message_payload(): Option[PCA_Types.Message_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Display_Message_Id).asInstanceOf[Option[PCA_Types.Message_Payload]]
  }

  // getter for out EventDataPort
  def get_Sound_Type(): Option[PCA_Types.Sound.Type] = {
    val value: Option[PCA_Types.Sound.Type] = get_Sound_Type_payload() match {
      case Some(PCA_Types.Sound_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port Sound_Type.  Expecting 'PCA_Types.Sound_Payload' but received ${v}")
      case _ => None[PCA_Types.Sound.Type]()
    }
    return value
  }

  // payload getter for out EventDataPort
  def get_Sound_Type_payload(): Option[PCA_Types.Sound_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Sound_Type_Id).asInstanceOf[Option[PCA_Types.Sound_Payload]]
  }

  // getter for out EventDataPort
  def get_Log_Event(): Option[PCA_Types.Event_Record] = {
    val value: Option[PCA_Types.Event_Record] = get_Log_Event_payload() match {
      case Some(PCA_Types.Event_Record_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port Log_Event.  Expecting 'PCA_Types.Event_Record_Payload' but received ${v}")
      case _ => None[PCA_Types.Event_Record]()
    }
    return value
  }

  // payload getter for out EventDataPort
  def get_Log_Event_payload(): Option[PCA_Types.Event_Record_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Log_Event_Id).asInstanceOf[Option[PCA_Types.Event_Record_Payload]]
  }

  // getter for out EventPort
  def get_Do_Scan(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_Do_Scan_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port Do_Scan.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_Do_Scan_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Do_Scan_Id).asInstanceOf[Option[Empty]]
  }

  // getter for out EventPort
  def get_Authenticate_Clinician(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_Authenticate_Clinician_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port Authenticate_Clinician.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_Authenticate_Clinician_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Authenticate_Clinician_Id).asInstanceOf[Option[Empty]]
  }

  // getter for out EventPort
  def get_Authenticate_Patient(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_Authenticate_Patient_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port Authenticate_Patient.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_Authenticate_Patient_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Authenticate_Patient_Id).asInstanceOf[Option[Empty]]
  }

  // getter for out EventPort
  def get_Authenticate_Prescription(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_Authenticate_Prescription_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port Authenticate_Prescription.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_Authenticate_Prescription_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Authenticate_Prescription_Id).asInstanceOf[Option[Empty]]
  }

  // getter for out EventPort
  def get_Check_Rx(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_Check_Rx_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port Check_Rx.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_Check_Rx_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Check_Rx_Id).asInstanceOf[Option[Empty]]
  }

  // getter for out EventPort
  def get_Begin_Priming(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_Begin_Priming_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port Begin_Priming.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_Begin_Priming_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Begin_Priming_Id).asInstanceOf[Option[Empty]]
  }

  // getter for out EventPort
  def get_End_Priming(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_End_Priming_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port End_Priming.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_End_Priming_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.End_Priming_Id).asInstanceOf[Option[Empty]]
  }

  // getter for out EventPort
  def get_Prime_Failure(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_Prime_Failure_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port Prime_Failure.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_Prime_Failure_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Prime_Failure_Id).asInstanceOf[Option[Empty]]
  }

  // getter for out EventPort
  def get_Begin_Infusion(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_Begin_Infusion_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port Begin_Infusion.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_Begin_Infusion_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Begin_Infusion_Id).asInstanceOf[Option[Empty]]
  }

  // getter for out EventPort
  def get_Halt_Infusion(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_Halt_Infusion_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port Halt_Infusion.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_Halt_Infusion_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Halt_Infusion_Id).asInstanceOf[Option[Empty]]
  }

}
