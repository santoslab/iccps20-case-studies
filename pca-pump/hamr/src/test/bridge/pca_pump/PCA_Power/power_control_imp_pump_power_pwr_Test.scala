package pca_pump.PCA_Power

import art.{ArtNative_Ext, Empty}
import pca_pump._
import org.sireum._

// This file will not be overwritten so is safe to edit
class power_control_imp_pump_power_pwr_Test extends BridgeTestSuite[power_control_imp_pump_power_pwr_Bridge](Arch.wrap_pca_imp_Instance_pump_power_pwr) {
  test("Example Unit Test"){
    executeTest()
  }

  //////////////////////
  // HELPER FUNCTIONS //
  //////////////////////

  // setter for in DataPort
  def put_Battery_Voltage(value : Physical_Types.Voltage_imp): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Battery_Voltage_Id, Physical_Types.Voltage_imp_Payload(value))
  }

  // setter for in DataPort
  def put_Battery_Current(value : Physical_Types.Current_imp): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Battery_Current_Id, Physical_Types.Current_imp_Payload(value))
  }

  // setter for in DataPort
  def put_Power_Voltage(value : Physical_Types.Voltage_imp): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Power_Voltage_Id, Physical_Types.Voltage_imp_Payload(value))
  }

  // getter for out DataPort
  def get_Using_Battery_Power(): Option[Base_Types.Boolean] = {
    val value: Option[Base_Types.Boolean] = get_Using_Battery_Power_payload() match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port Using_Battery_Power.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_Using_Battery_Power_payload(): Option[Base_Types.Boolean_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Using_Battery_Power_Id).asInstanceOf[Option[Base_Types.Boolean_Payload]]
  }

  // getter for out DataPort
  def get_Remaining_Battery_Time(): Option[BLESS_Types.Time] = {
    val value: Option[BLESS_Types.Time] = get_Remaining_Battery_Time_payload() match {
      case Some(BLESS_Types.Time_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port Remaining_Battery_Time.  Expecting 'BLESS_Types.Time_Payload' but received ${v}")
      case _ => None[BLESS_Types.Time]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_Remaining_Battery_Time_payload(): Option[BLESS_Types.Time_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Remaining_Battery_Time_Id).asInstanceOf[Option[BLESS_Types.Time_Payload]]
  }

  // getter for out EventPort
  def get_Low_Battery_Warning(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_Low_Battery_Warning_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port Low_Battery_Warning.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_Low_Battery_Warning_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Low_Battery_Warning_Id).asInstanceOf[Option[Empty]]
  }

  // getter for out EventPort
  def get_Defective_Battery(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_Defective_Battery_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port Defective_Battery.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_Defective_Battery_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Defective_Battery_Id).asInstanceOf[Option[Empty]]
  }

  // getter for out EventPort
  def get_Voltage_OOR(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_Voltage_OOR_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port Voltage_OOR.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_Voltage_OOR_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Voltage_OOR_Id).asInstanceOf[Option[Empty]]
  }

}
