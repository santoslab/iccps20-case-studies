package pca_pump.PCA_Drug_Library

import art.{ArtNative_Ext, Empty}
import pca_pump._
import org.sireum._

// This file will not be overwritten so is safe to edit
class drug_library_thread_imp_pump_operation_operation_process_drug_library_Test extends BridgeTestSuite[drug_library_thread_imp_pump_operation_operation_process_drug_library_Bridge](Arch.wrap_pca_imp_Instance_pump_operation_operation_process_drug_library) {
  test("Example Unit Test"){
    executeTest()
  }

  //////////////////////
  // HELPER FUNCTIONS //
  //////////////////////

  // setter for in EventDataPort
  def put_Load_Drug_Library(value : PCA_Types.Drug_Library): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Load_Drug_Library_Id, PCA_Types.Drug_Library_Payload(value))
  }

  // setter for in EventDataPort
  def put_Get_Drug_Record(value : PCA_Types.Drug_Code_imp): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Get_Drug_Record_Id, PCA_Types.Drug_Code_imp_Payload(value))
  }

  // getter for out EventDataPort
  def get_The_Drug_Record(): Option[PCA_Types.Drug_Record_imp] = {
    val value: Option[PCA_Types.Drug_Record_imp] = get_The_Drug_Record_payload() match {
      case Some(PCA_Types.Drug_Record_imp_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port The_Drug_Record.  Expecting 'PCA_Types.Drug_Record_imp_Payload' but received ${v}")
      case _ => None[PCA_Types.Drug_Record_imp]()
    }
    return value
  }

  // payload getter for out EventDataPort
  def get_The_Drug_Record_payload(): Option[PCA_Types.Drug_Record_imp_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.The_Drug_Record_Id).asInstanceOf[Option[PCA_Types.Drug_Record_imp_Payload]]
  }

  // getter for out EventPort
  def get_No_Drug_Found(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_No_Drug_Found_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port No_Drug_Found.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_No_Drug_Found_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.No_Drug_Found_Id).asInstanceOf[Option[Empty]]
  }

}
