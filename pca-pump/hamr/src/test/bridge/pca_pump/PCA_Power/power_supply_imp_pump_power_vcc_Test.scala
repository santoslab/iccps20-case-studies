package pca_pump.PCA_Power

import art.{ArtNative_Ext, Empty}
import pca_pump._
import org.sireum._

// This file will not be overwritten so is safe to edit
class power_supply_imp_pump_power_vcc_Test extends BridgeTestSuite[power_supply_imp_pump_power_vcc_Bridge](Arch.wrap_pca_imp_Instance_pump_power_vcc) {
  test("Example Unit Test"){
    executeTest()
  }

  //////////////////////
  // HELPER FUNCTIONS //
  //////////////////////

  // getter for out DataPort
  def get_Power_Voltage(): Option[Physical_Types.Voltage_imp] = {
    val value: Option[Physical_Types.Voltage_imp] = get_Power_Voltage_payload() match {
      case Some(Physical_Types.Voltage_imp_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port Power_Voltage.  Expecting 'Physical_Types.Voltage_imp_Payload' but received ${v}")
      case _ => None[Physical_Types.Voltage_imp]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_Power_Voltage_payload(): Option[Physical_Types.Voltage_imp_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Power_Voltage_Id).asInstanceOf[Option[Physical_Types.Voltage_imp_Payload]]
  }

}
