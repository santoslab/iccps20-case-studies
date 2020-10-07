package pca_pump.PCA_Safety

import art.{ArtNative_Ext, Empty}
import pca_pump._
import org.sireum._

// This file will not be overwritten so is safe to edit
class fault_logger_imp_pump_safety_fault_log_Test extends BridgeTestSuite[fault_logger_imp_pump_safety_fault_log_Bridge](Arch.wrap_pca_imp_Instance_pump_safety_fault_log) {
  test("Example Unit Test"){
    executeTest()
  }

  //////////////////////
  // HELPER FUNCTIONS //
  //////////////////////

  // setter for in EventDataPort
  def put_Log_Fault(value : PCA_Types.Fault_Record_imp): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Log_Fault_Id, PCA_Types.Fault_Record_imp_Payload(value))
  }

  // setter for in EventPort
  def put_Get_Log(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Get_Log_Id, Empty())
  }

  // setter for in EventPort
  def put_POST_Failure(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.POST_Failure_Id, Empty())
  }

  // setter for in EventPort
  def put_RAM_Failure(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.RAM_Failure_Id, Empty())
  }

  // setter for in EventPort
  def put_ROM_Failure(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.ROM_Failure_Id, Empty())
  }

  // setter for in EventPort
  def put_CPU_Failure(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.CPU_Failure_Id, Empty())
  }

  // setter for in EventPort
  def put_Thread_Monitor_Failure(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Thread_Monitor_Failure_Id, Empty())
  }

  // setter for in EventPort
  def put_Voltage_OOR(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Voltage_OOR_Id, Empty())
  }

  // getter for out EventDataPort
  def get_The_Log(): Option[PCA_Types.Fault_Log] = {
    val value: Option[PCA_Types.Fault_Log] = get_The_Log_payload() match {
      case Some(PCA_Types.Fault_Log_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port The_Log.  Expecting 'PCA_Types.Fault_Log_Payload' but received ${v}")
      case _ => None[PCA_Types.Fault_Log]()
    }
    return value
  }

  // payload getter for out EventDataPort
  def get_The_Log_payload(): Option[PCA_Types.Fault_Log_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.The_Log_Id).asInstanceOf[Option[PCA_Types.Fault_Log_Payload]]
  }

}
