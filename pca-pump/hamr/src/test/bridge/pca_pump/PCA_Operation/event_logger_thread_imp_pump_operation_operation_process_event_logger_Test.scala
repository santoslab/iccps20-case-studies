package pca_pump.PCA_Operation

import art.{ArtNative_Ext, Empty}
import pca_pump._
import org.sireum._

// This file will not be overwritten so is safe to edit
class event_logger_thread_imp_pump_operation_operation_process_event_logger_Test extends BridgeTestSuite[event_logger_thread_imp_pump_operation_operation_process_event_logger_Bridge](Arch.wrap_pca_imp_Instance_pump_operation_operation_process_event_logger) {
  test("Example Unit Test"){
    executeTest()
  }

  //////////////////////
  // HELPER FUNCTIONS //
  //////////////////////

  // setter for in EventDataPort
  def put_Log_Event(value : PCA_Types.Event_Record): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Log_Event_Id, PCA_Types.Event_Record_Payload(value))
  }

  // setter for in EventPort
  def put_Get_Event_Log(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Get_Event_Log_Id, Empty())
  }

  // getter for out EventDataPort
  def get_The_Event_Log(): Option[PCA_Types.Event_Log] = {
    val value: Option[PCA_Types.Event_Log] = get_The_Event_Log_payload() match {
      case Some(PCA_Types.Event_Log_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port The_Event_Log.  Expecting 'PCA_Types.Event_Log_Payload' but received ${v}")
      case _ => None[PCA_Types.Event_Log]()
    }
    return value
  }

  // payload getter for out EventDataPort
  def get_The_Event_Log_payload(): Option[PCA_Types.Event_Log_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.The_Event_Log_Id).asInstanceOf[Option[PCA_Types.Event_Log_Payload]]
  }

}
