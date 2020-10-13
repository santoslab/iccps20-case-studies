package isolette.Regulate

import art.{ArtNative_Ext, Empty}
import isolette._
import org.sireum._

// This file will not be overwritten so is safe to edit
class Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_mhst_Test extends BridgeTestSuite[Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_mhst_Bridge](Arch.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_heat_source_mhst) {
  test("Example Unit Test"){
    executeTest()
  }

  //////////////////////
  // HELPER FUNCTIONS //
  //////////////////////

  // setter for in DataPort
  def put_current_tempWstatus(value : Isolette_Data_Model.TempWstatus_impl): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.current_tempWstatus_Id, Isolette_Data_Model.TempWstatus_impl_Payload(value))
  }

  // setter for in DataPort
  def put_lower_desired_temp(value : Isolette_Data_Model.Temp_impl): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.lower_desired_temp_Id, Isolette_Data_Model.Temp_impl_Payload(value))
  }

  // setter for in DataPort
  def put_upper_desired_temp(value : Isolette_Data_Model.Temp_impl): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.upper_desired_temp_Id, Isolette_Data_Model.Temp_impl_Payload(value))
  }

  // setter for in DataPort
  def put_regulator_mode(value : Isolette_Data_Model.Regulator_Mode.Type): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.regulator_mode_Id, Isolette_Data_Model.Regulator_Mode_Payload(value))
  }

  // getter for out DataPort
  def get_heat_control(): Option[Isolette_Data_Model.On_Off.Type] = {
    val value: Option[Isolette_Data_Model.On_Off.Type] = get_heat_control_payload() match {
      case Some(Isolette_Data_Model.On_Off_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port heat_control.  Expecting 'Isolette_Data_Model.On_Off_Payload' but received ${v}")
      case _ => None[Isolette_Data_Model.On_Off.Type]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_heat_control_payload(): Option[Isolette_Data_Model.On_Off_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.heat_control_Id).asInstanceOf[Option[Isolette_Data_Model.On_Off_Payload]]
  }

}
