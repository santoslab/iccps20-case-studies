package isolette.Regulate

import art.{ArtNative_Ext, Empty}
import isolette._
import org.sireum._

// This file will not be overwritten so is safe to edit
class Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode_mrmt_Test extends BridgeTestSuite[Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode_mrmt_Bridge](Arch.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_mode_mrmt) {
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
  def put_interface_failure(value : Isolette_Data_Model.Failure_Flag_impl): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.interface_failure_Id, Isolette_Data_Model.Failure_Flag_impl_Payload(value))
  }

  // setter for in DataPort
  def put_internal_failure(value : Isolette_Data_Model.Failure_Flag_impl): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.internal_failure_Id, Isolette_Data_Model.Failure_Flag_impl_Payload(value))
  }

  // getter for out DataPort
  def get_regulator_mode(): Option[Isolette_Data_Model.Regulator_Mode.Type] = {
    val value: Option[Isolette_Data_Model.Regulator_Mode.Type] = get_regulator_mode_payload() match {
      case Some(Isolette_Data_Model.Regulator_Mode_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port regulator_mode.  Expecting 'Isolette_Data_Model.Regulator_Mode_Payload' but received ${v}")
      case _ => None[Isolette_Data_Model.Regulator_Mode.Type]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_regulator_mode_payload(): Option[Isolette_Data_Model.Regulator_Mode_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.regulator_mode_Id).asInstanceOf[Option[Isolette_Data_Model.Regulator_Mode_Payload]]
  }

}
