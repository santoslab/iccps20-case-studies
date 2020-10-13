package isolette.Isolette

import art.{ArtNative_Ext, Empty}
import isolette._
import org.sireum._

// This file will not be overwritten so is safe to edit
class operator_interface_thread_impl_operator_interface_oip_oit_Test extends BridgeTestSuite[operator_interface_thread_impl_operator_interface_oip_oit_Bridge](Arch.isolette_single_sensor_Instance_operator_interface_oip_oit) {
  test("Example Unit Test"){
    executeTest()
  }

  //////////////////////
  // HELPER FUNCTIONS //
  //////////////////////

  // setter for in DataPort
  def put_regulator_status(value : Isolette_Data_Model.Status.Type): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.regulator_status_Id, Isolette_Data_Model.Status_Payload(value))
  }

  // setter for in DataPort
  def put_monitor_status(value : Isolette_Data_Model.Status.Type): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.monitor_status_Id, Isolette_Data_Model.Status_Payload(value))
  }

  // setter for in DataPort
  def put_display_temperature(value : Isolette_Data_Model.Temp_impl): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.display_temperature_Id, Isolette_Data_Model.Temp_impl_Payload(value))
  }

  // setter for in DataPort
  def put_alarm_control(value : Isolette_Data_Model.On_Off.Type): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.alarm_control_Id, Isolette_Data_Model.On_Off_Payload(value))
  }

  // getter for out DataPort
  def get_lower_desired_tempWstatus(): Option[Isolette_Data_Model.TempWstatus_impl] = {
    val value: Option[Isolette_Data_Model.TempWstatus_impl] = get_lower_desired_tempWstatus_payload() match {
      case Some(Isolette_Data_Model.TempWstatus_impl_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port lower_desired_tempWstatus.  Expecting 'Isolette_Data_Model.TempWstatus_impl_Payload' but received ${v}")
      case _ => None[Isolette_Data_Model.TempWstatus_impl]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_lower_desired_tempWstatus_payload(): Option[Isolette_Data_Model.TempWstatus_impl_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.lower_desired_tempWstatus_Id).asInstanceOf[Option[Isolette_Data_Model.TempWstatus_impl_Payload]]
  }

  // getter for out DataPort
  def get_upper_desired_tempWstatus(): Option[Isolette_Data_Model.TempWstatus_impl] = {
    val value: Option[Isolette_Data_Model.TempWstatus_impl] = get_upper_desired_tempWstatus_payload() match {
      case Some(Isolette_Data_Model.TempWstatus_impl_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port upper_desired_tempWstatus.  Expecting 'Isolette_Data_Model.TempWstatus_impl_Payload' but received ${v}")
      case _ => None[Isolette_Data_Model.TempWstatus_impl]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_upper_desired_tempWstatus_payload(): Option[Isolette_Data_Model.TempWstatus_impl_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.upper_desired_tempWstatus_Id).asInstanceOf[Option[Isolette_Data_Model.TempWstatus_impl_Payload]]
  }

  // getter for out DataPort
  def get_lower_alarm_tempWstatus(): Option[Isolette_Data_Model.TempWstatus_impl] = {
    val value: Option[Isolette_Data_Model.TempWstatus_impl] = get_lower_alarm_tempWstatus_payload() match {
      case Some(Isolette_Data_Model.TempWstatus_impl_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port lower_alarm_tempWstatus.  Expecting 'Isolette_Data_Model.TempWstatus_impl_Payload' but received ${v}")
      case _ => None[Isolette_Data_Model.TempWstatus_impl]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_lower_alarm_tempWstatus_payload(): Option[Isolette_Data_Model.TempWstatus_impl_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.lower_alarm_tempWstatus_Id).asInstanceOf[Option[Isolette_Data_Model.TempWstatus_impl_Payload]]
  }

  // getter for out DataPort
  def get_upper_alarm_tempWstatus(): Option[Isolette_Data_Model.TempWstatus_impl] = {
    val value: Option[Isolette_Data_Model.TempWstatus_impl] = get_upper_alarm_tempWstatus_payload() match {
      case Some(Isolette_Data_Model.TempWstatus_impl_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port upper_alarm_tempWstatus.  Expecting 'Isolette_Data_Model.TempWstatus_impl_Payload' but received ${v}")
      case _ => None[Isolette_Data_Model.TempWstatus_impl]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_upper_alarm_tempWstatus_payload(): Option[Isolette_Data_Model.TempWstatus_impl_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.upper_alarm_tempWstatus_Id).asInstanceOf[Option[Isolette_Data_Model.TempWstatus_impl_Payload]]
  }

}
