package pca_pump.PCA_Mechanical

import art.{ArtNative_Ext, Empty}
import pca_pump._
import org.sireum._

// This file will not be overwritten so is safe to edit
class drug_reservoir_imp_pump_fluid_reservoir_Test extends BridgeTestSuite[drug_reservoir_imp_pump_fluid_reservoir_Bridge](Arch.wrap_pca_imp_Instance_pump_fluid_reservoir) {
  test("Example Unit Test"){
    executeTest()
  }

  //////////////////////
  // HELPER FUNCTIONS //
  //////////////////////

  // setter for in DataPort
  def put_Fill_Reservoir(value : Physical_Types.Fluid_Volume_imp): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Fill_Reservoir_Id, Physical_Types.Fluid_Volume_imp_Payload(value))
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

  // getter for out DataPort
  def get_Door_Open(): Option[Base_Types.Boolean] = {
    val value: Option[Base_Types.Boolean] = get_Door_Open_payload() match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port Door_Open.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_Door_Open_payload(): Option[Base_Types.Boolean_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Door_Open_Id).asInstanceOf[Option[Base_Types.Boolean_Payload]]
  }

  // getter for out EventPort
  def get_Door_Closed(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_Door_Closed_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port Door_Closed.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_Door_Closed_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Door_Closed_Id).asInstanceOf[Option[Empty]]
  }

  // getter for out EventPort
  def get_Low_Reservoir(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_Low_Reservoir_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port Low_Reservoir.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_Low_Reservoir_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Low_Reservoir_Id).asInstanceOf[Option[Empty]]
  }

  // getter for out EventPort
  def get_Empty_Reservoir(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_Empty_Reservoir_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port Empty_Reservoir.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_Empty_Reservoir_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Empty_Reservoir_Id).asInstanceOf[Option[Empty]]
  }

}
