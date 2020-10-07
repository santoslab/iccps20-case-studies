package pca_pump.PCA_Security

import art.{ArtNative_Ext, Empty}
import pca_pump._
import org.sireum._

// This file will not be overwritten so is safe to edit
class Security_Thread_imp_pump_operation_security_subsystem_security_process_security_thread_Test extends BridgeTestSuite[Security_Thread_imp_pump_operation_security_subsystem_security_process_security_thread_Bridge](Arch.wrap_pca_imp_Instance_pump_operation_security_subsystem_security_process_security_thread) {
  test("Example Unit Test"){
    executeTest()
  }

  //////////////////////
  // HELPER FUNCTIONS //
  //////////////////////

  // setter for in EventDataPort
  def put_Scan_Data(value : PCA_Types.Scan_Data_Type): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Scan_Data_Id, PCA_Types.Scan_Data_Type_Payload(value))
  }

  // setter for in EventPort
  def put_Authenticate_Clinician(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Authenticate_Clinician_Id, Empty())
  }

  // setter for in EventPort
  def put_Authenticate_Patient(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Authenticate_Patient_Id, Empty())
  }

  // setter for in EventPort
  def put_Authenticate_Prescription(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Authenticate_Prescription_Id, Empty())
  }

  // getter for out DataPort
  def get_Clinician_Name(): Option[Base_Types.String] = {
    val value: Option[Base_Types.String] = get_Clinician_Name_payload() match {
      case Some(Base_Types.String_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port Clinician_Name.  Expecting 'Base_Types.String_Payload' but received ${v}")
      case _ => None[Base_Types.String]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_Clinician_Name_payload(): Option[Base_Types.String_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Clinician_Name_Id).asInstanceOf[Option[Base_Types.String_Payload]]
  }

  // getter for out DataPort
  def get_Patient_Name(): Option[Base_Types.String] = {
    val value: Option[Base_Types.String] = get_Patient_Name_payload() match {
      case Some(Base_Types.String_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port Patient_Name.  Expecting 'Base_Types.String_Payload' but received ${v}")
      case _ => None[Base_Types.String]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_Patient_Name_payload(): Option[Base_Types.String_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Patient_Name_Id).asInstanceOf[Option[Base_Types.String_Payload]]
  }

  // getter for out DataPort
  def get_Prescription(): Option[PCA_Types.Prescription_imp] = {
    val value: Option[PCA_Types.Prescription_imp] = get_Prescription_payload() match {
      case Some(PCA_Types.Prescription_imp_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port Prescription.  Expecting 'PCA_Types.Prescription_imp_Payload' but received ${v}")
      case _ => None[PCA_Types.Prescription_imp]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_Prescription_payload(): Option[PCA_Types.Prescription_imp_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Prescription_Id).asInstanceOf[Option[PCA_Types.Prescription_imp_Payload]]
  }

  // getter for out EventPort
  def get_Authentication_fail(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_Authentication_fail_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port Authentication_fail.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_Authentication_fail_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Authentication_fail_Id).asInstanceOf[Option[Empty]]
  }

  // getter for out EventPort
  def get_Authentication_pass(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_Authentication_pass_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port Authentication_pass.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_Authentication_pass_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Authentication_pass_Id).asInstanceOf[Option[Empty]]
  }

  // getter for out EventPort
  def get_Security_Fault(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_Security_Fault_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port Security_Fault.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_Security_Fault_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Security_Fault_Id).asInstanceOf[Option[Empty]]
  }

}
