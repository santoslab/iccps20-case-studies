package pca_pump.PCA_System

import art.{ArtNative_Ext, Empty}
import pca_pump._
import org.sireum._

// This file will not be overwritten so is safe to edit
class maintenance_imp_maint_Test extends BridgeTestSuite[maintenance_imp_maint_Bridge](Arch.wrap_pca_imp_Instance_maint) {
  test("Example Unit Test"){
    executeTest()
  }

  //////////////////////
  // HELPER FUNCTIONS //
  //////////////////////

  // setter for in EventDataPort
  def put_The_Fault_Log(value : PCA_Types.Fault_Log): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.The_Fault_Log_Id, PCA_Types.Fault_Log_Payload(value))
  }

  // setter for in EventDataPort
  def put_The_Event_Log(value : PCA_Types.Event_Log): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.The_Event_Log_Id, PCA_Types.Event_Log_Payload(value))
  }

  // getter for out EventDataPort
  def get_Load_Drug_Library(): Option[PCA_Types.Drug_Library] = {
    val value: Option[PCA_Types.Drug_Library] = get_Load_Drug_Library_payload() match {
      case Some(PCA_Types.Drug_Library_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port Load_Drug_Library.  Expecting 'PCA_Types.Drug_Library_Payload' but received ${v}")
      case _ => None[PCA_Types.Drug_Library]()
    }
    return value
  }

  // payload getter for out EventDataPort
  def get_Load_Drug_Library_payload(): Option[PCA_Types.Drug_Library_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Load_Drug_Library_Id).asInstanceOf[Option[PCA_Types.Drug_Library_Payload]]
  }

  // getter for out EventPort
  def get_Get_Fault_Log(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_Get_Fault_Log_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port Get_Fault_Log.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_Get_Fault_Log_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Get_Fault_Log_Id).asInstanceOf[Option[Empty]]
  }

  // getter for out EventPort
  def get_Get_Event_Log(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_Get_Event_Log_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port Get_Event_Log.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_Get_Event_Log_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Get_Event_Log_Id).asInstanceOf[Option[Empty]]
  }

}
