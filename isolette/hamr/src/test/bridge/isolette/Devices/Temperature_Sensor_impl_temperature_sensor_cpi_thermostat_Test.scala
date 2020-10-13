package isolette.Devices

import art.{ArtNative_Ext, Empty}
import isolette._
import org.sireum._

// This file will not be overwritten so is safe to edit
class Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_Test extends BridgeTestSuite[Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_Bridge](Arch.isolette_single_sensor_Instance_temperature_sensor_cpi_thermostat) {
  test("Example Unit Test"){
    executeTest()
  }

  //////////////////////
  // HELPER FUNCTIONS //
  //////////////////////

  // setter for in DataPort
  def put_air(value : Isolette_Data_Model.PhysicalTemp_impl): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.air_Id, Isolette_Data_Model.PhysicalTemp_impl_Payload(value))
  }

  // getter for out DataPort
  def get_current_tempWstatus(): Option[Isolette_Data_Model.TempWstatus_impl] = {
    val value: Option[Isolette_Data_Model.TempWstatus_impl] = get_current_tempWstatus_payload() match {
      case Some(Isolette_Data_Model.TempWstatus_impl_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port current_tempWstatus.  Expecting 'Isolette_Data_Model.TempWstatus_impl_Payload' but received ${v}")
      case _ => None[Isolette_Data_Model.TempWstatus_impl]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_current_tempWstatus_payload(): Option[Isolette_Data_Model.TempWstatus_impl_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.current_tempWstatus_Id).asInstanceOf[Option[Isolette_Data_Model.TempWstatus_impl_Payload]]
  }

}
