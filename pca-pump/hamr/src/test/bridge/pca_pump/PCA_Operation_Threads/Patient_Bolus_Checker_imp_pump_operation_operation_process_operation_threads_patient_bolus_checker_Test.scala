package pca_pump.PCA_Operation_Threads

import art.{ArtNative_Ext, Empty}
import pca_pump._
import org.sireum._

// This file will not be overwritten so is safe to edit
class Patient_Bolus_Checker_imp_pump_operation_operation_process_operation_threads_patient_bolus_checker_Test extends BridgeTestSuite[Patient_Bolus_Checker_imp_pump_operation_operation_process_operation_threads_patient_bolus_checker_Bridge](Arch.wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_patient_bolus_checker) {
  test("Example Unit Test"){
    executeTest()
  }

  //////////////////////
  // HELPER FUNCTIONS //
  //////////////////////

  // setter for in DataPort
  def put_Minimum_Time_Between_Bolus(value : ICE_Types.Minute_imp): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Minimum_Time_Between_Bolus_Id, ICE_Types.Minute_imp_Payload(value))
  }

  // setter for in EventPort
  def put_Patient_Button_Request(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Patient_Button_Request_Id, Empty())
  }

  // getter for out EventPort
  def get_Patient_Request_Not_Too_Soon(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_Patient_Request_Not_Too_Soon_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port Patient_Request_Not_Too_Soon.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_Patient_Request_Not_Too_Soon_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Patient_Request_Not_Too_Soon_Id).asInstanceOf[Option[Empty]]
  }

  // getter for out EventPort
  def get_Patient_Request_Too_Soon(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_Patient_Request_Too_Soon_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port Patient_Request_Too_Soon.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_Patient_Request_Too_Soon_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Patient_Request_Too_Soon_Id).asInstanceOf[Option[Empty]]
  }

}
