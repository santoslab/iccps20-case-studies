package isolette.Monitor

import art.{ArtNative_Ext, Empty}
import isolette._
import org.sireum._

// This file will not be overwritten so is safe to edit
class Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_mat_Test extends BridgeTestSuite[Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_mat_Bridge](Arch.isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_alarm_mat) {
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
  def put_lower_alarm_temp(value : Isolette_Data_Model.Temp_impl): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.lower_alarm_temp_Id, Isolette_Data_Model.Temp_impl_Payload(value))
  }

  // setter for in DataPort
  def put_upper_alarm_temp(value : Isolette_Data_Model.Temp_impl): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.upper_alarm_temp_Id, Isolette_Data_Model.Temp_impl_Payload(value))
  }

  // setter for in DataPort
  def put_monitor_mode(value : Isolette_Data_Model.Monitor_Mode.Type): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.monitor_mode_Id, Isolette_Data_Model.Monitor_Mode_Payload(value))
  }

  // getter for out DataPort
  def get_alarm_control(): Option[Isolette_Data_Model.On_Off.Type] = {
    val value: Option[Isolette_Data_Model.On_Off.Type] = get_alarm_control_payload() match {
      case Some(Isolette_Data_Model.On_Off_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port alarm_control.  Expecting 'Isolette_Data_Model.On_Off_Payload' but received ${v}")
      case _ => None[Isolette_Data_Model.On_Off.Type]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_alarm_control_payload(): Option[Isolette_Data_Model.On_Off_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.alarm_control_Id).asInstanceOf[Option[Isolette_Data_Model.On_Off_Payload]]
  }

}
