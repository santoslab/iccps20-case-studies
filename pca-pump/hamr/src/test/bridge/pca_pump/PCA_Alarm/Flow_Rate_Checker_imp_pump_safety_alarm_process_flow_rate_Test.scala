package pca_pump.PCA_Alarm

import art.{ArtNative_Ext, Empty}
import pca_pump._
import org.sireum._

// This file will not be overwritten so is safe to edit
class Flow_Rate_Checker_imp_pump_safety_alarm_process_flow_rate_Test extends BridgeTestSuite[Flow_Rate_Checker_imp_pump_safety_alarm_process_flow_rate_Bridge](Arch.wrap_pca_imp_Instance_pump_safety_alarm_process_flow_rate) {
  test("Example Unit Test"){
    executeTest()
  }

  //////////////////////
  // HELPER FUNCTIONS //
  //////////////////////

  // setter for in DataPort
  def put_System_Status(value : PCA_Types.Status_Type.Type): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.System_Status_Id, PCA_Types.Status_Type_Payload(value))
  }

  // setter for in DataPort
  def put_Infusion_Flow_Rate(value : PCA_Types.Flow_Rate_imp): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Infusion_Flow_Rate_Id, PCA_Types.Flow_Rate_imp_Payload(value))
  }

  // setter for in DataPort
  def put_Upstream_Flow_Rate(value : PCA_Types.Flow_Rate_imp): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Upstream_Flow_Rate_Id, PCA_Types.Flow_Rate_imp_Payload(value))
  }

  // setter for in DataPort
  def put_Downstream_Flow_Rate(value : PCA_Types.Flow_Rate_imp): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Downstream_Flow_Rate_Id, PCA_Types.Flow_Rate_imp_Payload(value))
  }

  // getter for out EventPort
  def get_Basal_Overinfusion(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_Basal_Overinfusion_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port Basal_Overinfusion.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_Basal_Overinfusion_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Basal_Overinfusion_Id).asInstanceOf[Option[Empty]]
  }

  // getter for out EventPort
  def get_Bolus_Overinfusion(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_Bolus_Overinfusion_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port Bolus_Overinfusion.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_Bolus_Overinfusion_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Bolus_Overinfusion_Id).asInstanceOf[Option[Empty]]
  }

  // getter for out EventPort
  def get_Square_Bolus_Overinfusion(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_Square_Bolus_Overinfusion_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port Square_Bolus_Overinfusion.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_Square_Bolus_Overinfusion_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Square_Bolus_Overinfusion_Id).asInstanceOf[Option[Empty]]
  }

  // getter for out EventPort
  def get_Basal_Underinfusion(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_Basal_Underinfusion_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port Basal_Underinfusion.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_Basal_Underinfusion_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Basal_Underinfusion_Id).asInstanceOf[Option[Empty]]
  }

  // getter for out EventPort
  def get_Bolus_Underinfusion(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_Bolus_Underinfusion_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port Bolus_Underinfusion.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_Bolus_Underinfusion_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Bolus_Underinfusion_Id).asInstanceOf[Option[Empty]]
  }

  // getter for out EventPort
  def get_Square_Bolus_Underinfusion(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_Square_Bolus_Underinfusion_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port Square_Bolus_Underinfusion.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_Square_Bolus_Underinfusion_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Square_Bolus_Underinfusion_Id).asInstanceOf[Option[Empty]]
  }

}
