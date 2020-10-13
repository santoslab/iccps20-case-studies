package isolette.Monitor

import art.{ArtNative_Ext, Empty}
import isolette._
import org.sireum._

// This file will not be overwritten so is safe to edit
class Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_mmit_Test extends BridgeTestSuite[Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_mmit_Bridge](Arch.isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_interface_mmit) {
  test("Example Unit Test"){
    executeTest()
  }

  //////////////////////
  // HELPER FUNCTIONS //
  //////////////////////

  // setter for in DataPort
  def put_upper_alarm_tempWstatus(value : Isolette_Data_Model.TempWstatus_impl): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.upper_alarm_tempWstatus_Id, Isolette_Data_Model.TempWstatus_impl_Payload(value))
  }

  // setter for in DataPort
  def put_lower_alarm_tempWstatus(value : Isolette_Data_Model.TempWstatus_impl): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.lower_alarm_tempWstatus_Id, Isolette_Data_Model.TempWstatus_impl_Payload(value))
  }

  // setter for in DataPort
  def put_current_tempWstatus(value : Isolette_Data_Model.TempWstatus_impl): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.current_tempWstatus_Id, Isolette_Data_Model.TempWstatus_impl_Payload(value))
  }

  // setter for in DataPort
  def put_monitor_mode(value : Isolette_Data_Model.Monitor_Mode.Type): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.monitor_mode_Id, Isolette_Data_Model.Monitor_Mode_Payload(value))
  }

  // getter for out DataPort
  def get_upper_alarm_temp(): Option[Isolette_Data_Model.Temp_impl] = {
    val value: Option[Isolette_Data_Model.Temp_impl] = get_upper_alarm_temp_payload() match {
      case Some(Isolette_Data_Model.Temp_impl_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port upper_alarm_temp.  Expecting 'Isolette_Data_Model.Temp_impl_Payload' but received ${v}")
      case _ => None[Isolette_Data_Model.Temp_impl]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_upper_alarm_temp_payload(): Option[Isolette_Data_Model.Temp_impl_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.upper_alarm_temp_Id).asInstanceOf[Option[Isolette_Data_Model.Temp_impl_Payload]]
  }

  // getter for out DataPort
  def get_lower_alarm_temp(): Option[Isolette_Data_Model.Temp_impl] = {
    val value: Option[Isolette_Data_Model.Temp_impl] = get_lower_alarm_temp_payload() match {
      case Some(Isolette_Data_Model.Temp_impl_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port lower_alarm_temp.  Expecting 'Isolette_Data_Model.Temp_impl_Payload' but received ${v}")
      case _ => None[Isolette_Data_Model.Temp_impl]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_lower_alarm_temp_payload(): Option[Isolette_Data_Model.Temp_impl_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.lower_alarm_temp_Id).asInstanceOf[Option[Isolette_Data_Model.Temp_impl_Payload]]
  }

  // getter for out DataPort
  def get_monitor_status(): Option[Isolette_Data_Model.Status.Type] = {
    val value: Option[Isolette_Data_Model.Status.Type] = get_monitor_status_payload() match {
      case Some(Isolette_Data_Model.Status_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port monitor_status.  Expecting 'Isolette_Data_Model.Status_Payload' but received ${v}")
      case _ => None[Isolette_Data_Model.Status.Type]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_monitor_status_payload(): Option[Isolette_Data_Model.Status_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.monitor_status_Id).asInstanceOf[Option[Isolette_Data_Model.Status_Payload]]
  }

  // getter for out DataPort
  def get_interface_failure(): Option[Isolette_Data_Model.Failure_Flag_impl] = {
    val value: Option[Isolette_Data_Model.Failure_Flag_impl] = get_interface_failure_payload() match {
      case Some(Isolette_Data_Model.Failure_Flag_impl_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port interface_failure.  Expecting 'Isolette_Data_Model.Failure_Flag_impl_Payload' but received ${v}")
      case _ => None[Isolette_Data_Model.Failure_Flag_impl]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_interface_failure_payload(): Option[Isolette_Data_Model.Failure_Flag_impl_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.interface_failure_Id).asInstanceOf[Option[Isolette_Data_Model.Failure_Flag_impl_Payload]]
  }

}
