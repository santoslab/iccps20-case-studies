package pca_pump.PCA_Safety

import art.{ArtNative_Ext, Empty}
import pca_pump._
import org.sireum._

// This file will not be overwritten so is safe to edit
class failure_led_imp_pump_safety_led_Test extends BridgeTestSuite[failure_led_imp_pump_safety_led_Bridge](Arch.wrap_pca_imp_Instance_pump_safety_led) {
  test("Example Unit Test"){
    executeTest()
  }

  //////////////////////
  // HELPER FUNCTIONS //
  //////////////////////

  // setter for in EventPort
  def put_Illuminate(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Illuminate_Id, Empty())
  }

  // getter for out DataPort
  def get_Light(): Option[Base_Types.Boolean] = {
    val value: Option[Base_Types.Boolean] = get_Light_payload() match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port Light.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_Light_payload(): Option[Base_Types.Boolean_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Light_Id).asInstanceOf[Option[Base_Types.Boolean_Payload]]
  }

}
