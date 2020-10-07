package pca_pump.PCA_Operation_Threads

import art.{ArtNative_Ext, Empty}
import pca_pump._
import org.sireum._

// This file will not be overwritten so is safe to edit
class Max_Drug_Per_Hour_Watcher_imp_pump_operation_operation_process_operation_threads_max_drug_watcher_Test extends BridgeTestSuite[Max_Drug_Per_Hour_Watcher_imp_pump_operation_operation_process_operation_threads_max_drug_watcher_Bridge](Arch.wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_max_drug_watcher) {
  test("Example Unit Test"){
    executeTest()
  }

  //////////////////////
  // HELPER FUNCTIONS //
  //////////////////////

  // setter for in DataPort
  def put_Infusion_Flow_Rate(value : PCA_Types.Flow_Rate_imp): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Infusion_Flow_Rate_Id, PCA_Types.Flow_Rate_imp_Payload(value))
  }

  // setter for in DataPort
  def put_Max_Drug_Per_Hour(value : PCA_Types.Drug_Volume_imp): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Max_Drug_Per_Hour_Id, PCA_Types.Drug_Volume_imp_Payload(value))
  }

  // getter for out EventPort
  def get_Near_Max_Drug_Per_Hour(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_Near_Max_Drug_Per_Hour_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port Near_Max_Drug_Per_Hour.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_Near_Max_Drug_Per_Hour_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Near_Max_Drug_Per_Hour_Id).asInstanceOf[Option[Empty]]
  }

  // getter for out EventPort
  def get_Over_Max_Drug_Per_Hour(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_Over_Max_Drug_Per_Hour_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port Over_Max_Drug_Per_Hour.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_Over_Max_Drug_Per_Hour_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Over_Max_Drug_Per_Hour_Id).asInstanceOf[Option[Empty]]
  }

}
