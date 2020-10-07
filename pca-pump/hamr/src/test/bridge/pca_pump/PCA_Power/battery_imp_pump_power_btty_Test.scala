package pca_pump.PCA_Power

import art.{ArtNative_Ext, Empty}
import pca_pump._
import org.sireum._

// This file will not be overwritten so is safe to edit
class battery_imp_pump_power_btty_Test extends BridgeTestSuite[battery_imp_pump_power_btty_Bridge](Arch.wrap_pca_imp_Instance_pump_power_btty) {
  test("Example Unit Test"){
    executeTest()
  }

  //////////////////////
  // HELPER FUNCTIONS //
  //////////////////////

  // getter for out DataPort
  def get_Battery_Voltage(): Option[Physical_Types.Voltage_imp] = {
    val value: Option[Physical_Types.Voltage_imp] = get_Battery_Voltage_payload() match {
      case Some(Physical_Types.Voltage_imp_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port Battery_Voltage.  Expecting 'Physical_Types.Voltage_imp_Payload' but received ${v}")
      case _ => None[Physical_Types.Voltage_imp]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_Battery_Voltage_payload(): Option[Physical_Types.Voltage_imp_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Battery_Voltage_Id).asInstanceOf[Option[Physical_Types.Voltage_imp_Payload]]
  }

  // getter for out DataPort
  def get_Battery_Current(): Option[Physical_Types.Current_imp] = {
    val value: Option[Physical_Types.Current_imp] = get_Battery_Current_payload() match {
      case Some(Physical_Types.Current_imp_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port Battery_Current.  Expecting 'Physical_Types.Current_imp_Payload' but received ${v}")
      case _ => None[Physical_Types.Current_imp]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_Battery_Current_payload(): Option[Physical_Types.Current_imp_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Battery_Current_Id).asInstanceOf[Option[Physical_Types.Current_imp_Payload]]
  }

}
