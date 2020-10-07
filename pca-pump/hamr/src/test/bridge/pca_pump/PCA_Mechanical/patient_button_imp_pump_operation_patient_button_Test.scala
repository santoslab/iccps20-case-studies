package pca_pump.PCA_Mechanical

import art.{ArtNative_Ext, Empty}
import pca_pump._
import org.sireum._

// This file will not be overwritten so is safe to edit
class patient_button_imp_pump_operation_patient_button_Test extends BridgeTestSuite[patient_button_imp_pump_operation_patient_button_Bridge](Arch.wrap_pca_imp_Instance_pump_operation_patient_button) {
  test("Example Unit Test"){
    executeTest()
  }

  //////////////////////
  // HELPER FUNCTIONS //
  //////////////////////

  // setter for in EventPort
  def put_Button_Press(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Button_Press_Id, Empty())
  }

  // getter for out EventPort
  def get_Request_Bolus(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_Request_Bolus_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port Request_Bolus.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_Request_Bolus_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Request_Bolus_Id).asInstanceOf[Option[Empty]]
  }

}
