package pca_pump.PCA_Mechanical

import art.{ArtNative_Ext, Empty}
import pca_pump._
import org.sireum._

// This file will not be overwritten so is safe to edit
class scanner_imp_pump_operation_scanner_Test extends BridgeTestSuite[scanner_imp_pump_operation_scanner_Bridge](Arch.wrap_pca_imp_Instance_pump_operation_scanner) {
  test("Example Unit Test"){
    executeTest()
  }

  //////////////////////
  // HELPER FUNCTIONS //
  //////////////////////

  // setter for in EventPort
  def put_Do_Scan(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Do_Scan_Id, Empty())
  }

  // getter for out EventDataPort
  def get_Scan_Data(): Option[PCA_Types.Scan_Data_Type] = {
    val value: Option[PCA_Types.Scan_Data_Type] = get_Scan_Data_payload() match {
      case Some(PCA_Types.Scan_Data_Type_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port Scan_Data.  Expecting 'PCA_Types.Scan_Data_Type_Payload' but received ${v}")
      case _ => None[PCA_Types.Scan_Data_Type]()
    }
    return value
  }

  // payload getter for out EventDataPort
  def get_Scan_Data_payload(): Option[PCA_Types.Scan_Data_Type_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Scan_Data_Id).asInstanceOf[Option[PCA_Types.Scan_Data_Type_Payload]]
  }

  // getter for out EventPort
  def get_Scan_Done(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_Scan_Done_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port Scan_Done.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_Scan_Done_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Scan_Done_Id).asInstanceOf[Option[Empty]]
  }

}
