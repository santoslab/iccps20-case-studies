package pca_pump.PCA_Mechanical

import art.{ArtNative_Ext, Empty}
import pca_pump._
import org.sireum._

// This file will not be overwritten so is safe to edit
class pump_imp_pump_fluid_mech_pump_Test extends BridgeTestSuite[pump_imp_pump_fluid_mech_pump_Bridge](Arch.wrap_pca_imp_Instance_pump_fluid_mech_pump) {
  test("Example Unit Test"){
    executeTest()
  }

  //////////////////////
  // HELPER FUNCTIONS //
  //////////////////////

  // setter for in DataPort
  def put_Drug_Intake(value : Physical_Types.Fluid_Flow_imp): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Drug_Intake_Id, Physical_Types.Fluid_Flow_imp_Payload(value))
  }

  // setter for in DataPort
  def put_Rate(value : PCA_Types.Flow_Rate_imp): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Rate_Id, PCA_Types.Flow_Rate_imp_Payload(value))
  }

  // setter for in EventPort
  def put_Halt(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Halt_Id, Empty())
  }

  // getter for out DataPort
  def get_Drug_Outlet(): Option[Physical_Types.Fluid_Flow_imp] = {
    val value: Option[Physical_Types.Fluid_Flow_imp] = get_Drug_Outlet_payload() match {
      case Some(Physical_Types.Fluid_Flow_imp_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port Drug_Outlet.  Expecting 'Physical_Types.Fluid_Flow_imp_Payload' but received ${v}")
      case _ => None[Physical_Types.Fluid_Flow_imp]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_Drug_Outlet_payload(): Option[Physical_Types.Fluid_Flow_imp_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Drug_Outlet_Id).asInstanceOf[Option[Physical_Types.Fluid_Flow_imp_Payload]]
  }

  // getter for out EventPort
  def get_Pump_Too_Hot(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_Pump_Too_Hot_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port Pump_Too_Hot.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_Pump_Too_Hot_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Pump_Too_Hot_Id).asInstanceOf[Option[Empty]]
  }

}
