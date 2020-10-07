package isolette.Monitor

import art.{ArtNative_Ext, Empty}
import isolette._
import org.sireum._

// This file will not be overwritten so is safe to edit
class isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_mode_mmmt_Test extends BridgeTestSuite[Manage_Monitor_Mode_impl_Bridge](Arch.isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_mode_mmmt) {
  test("Example Unit Test"){
    executeTest()
  }

  //////////////////////
  // HELPER FUNCTIONS //
  //////////////////////

  // setter for in DataPort
  def put_current_tempWstatus(value : Isolette_Data_Model.TempWstatus_impl): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.api.current_tempWstatus_Id, Isolette_Data_Model.TempWstatus_impl_Payload(value))
  }

  // setter for in DataPort
  def put_interface_failure(value : Isolette_Data_Model.Failure_Flag_impl): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.api.interface_failure_Id, Isolette_Data_Model.Failure_Flag_impl_Payload(value))
  }

  // setter for in DataPort
  def put_internal_failure(value : Isolette_Data_Model.Failure_Flag_impl): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.api.internal_failure_Id, Isolette_Data_Model.Failure_Flag_impl_Payload(value))
  }

  // getter for out DataPort
  def get_monitor_mode(): Option[Isolette_Data_Model.Monitor_Mode.Type] = {
    val value: Option[Isolette_Data_Model.Monitor_Mode.Type] = get_monitor_mode_payload() match {
      case Some(Isolette_Data_Model.Monitor_Mode_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port monitor_mode.  Expecting 'Isolette_Data_Model.Monitor_Mode_Payload' but received ${v}")
      case _ => None[Isolette_Data_Model.Monitor_Mode.Type]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_monitor_mode_payload(): Option[Isolette_Data_Model.Monitor_Mode_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.api.monitor_mode_Id).asInstanceOf[Option[Isolette_Data_Model.Monitor_Mode_Payload]]
  }

  def getComponent(): Manage_Monitor_Mode_impl_Impl = {
    return bridge.entryPoints.asInstanceOf[Manage_Monitor_Mode_impl_Bridge.EntryPoints].component
  }
}
