package pca_pump.PCA_Operation_Threads

import art.{ArtNative_Ext, Empty}
import pca_pump._
import org.sireum._

// This file will not be overwritten so is safe to edit
class ICE_Thread_imp_pump_operation_operation_process_operation_threads_ice_thread_Test extends BridgeTestSuite[ICE_Thread_imp_pump_operation_operation_process_operation_threads_ice_thread_Bridge](Arch.wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_ice_thread) {
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
  def put_Patient_Bolus_Rate(value : PCA_Types.Flow_Rate_imp): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Patient_Bolus_Rate_Id, PCA_Types.Flow_Rate_imp_Payload(value))
  }

  // setter for in DataPort
  def put_Square_Bolus_Rate(value : PCA_Types.Flow_Rate_imp): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Square_Bolus_Rate_Id, PCA_Types.Flow_Rate_imp_Payload(value))
  }

  // setter for in DataPort
  def put_Basal_Rate(value : PCA_Types.Flow_Rate_imp): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Basal_Rate_Id, PCA_Types.Flow_Rate_imp_Payload(value))
  }

  // setter for in DataPort
  def put_VTBI(value : PCA_Types.Drug_Volume_imp): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.VTBI_Id, PCA_Types.Drug_Volume_imp_Payload(value))
  }

  // setter for in DataPort
  def put_Door_Open(value : Base_Types.Boolean): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Door_Open_Id, Base_Types.Boolean_Payload(value))
  }

  // setter for in DataPort
  def put_Alarm_Inactivation(value : ICE_Types.Alarm_Signal.Type): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Alarm_Inactivation_Id, ICE_Types.Alarm_Signal_Payload(value))
  }

  // setter for in EventDataPort
  def put_Alarm(value : PCA_Types.Alarm_Type.Type): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Alarm_Id, PCA_Types.Alarm_Type_Payload(value))
  }

  // setter for in EventDataPort
  def put_Warning(value : PCA_Types.Warning_Type.Type): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Warning_Id, PCA_Types.Warning_Type_Payload(value))
  }

  // setter for in EventDataPort
  def put_CP_Bolus_Duration(value : ICE_Types.Minute_imp): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.CP_Bolus_Duration_Id, ICE_Types.Minute_imp_Payload(value))
  }

  // setter for in EventPort
  def put_Rx_Okay(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Rx_Okay_Id, Empty())
  }

  // setter for in EventPort
  def put_Patient_Request_Not_Too_Soon(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Patient_Request_Not_Too_Soon_Id, Empty())
  }

  // setter for in EventPort
  def put_Patient_Request_Too_Soon(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Patient_Request_Too_Soon_Id, Empty())
  }

  // setter for in EventPort
  def put_HW_Detected_Failure(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.HW_Detected_Failure_Id, Empty())
  }

  // setter for in EventPort
  def put_Stop_Pump_Completely(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Stop_Pump_Completely_Id, Empty())
  }

  // setter for in EventPort
  def put_Pump_At_KVO_Rate(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Pump_At_KVO_Rate_Id, Empty())
  }

  // setter for in EventPort
  def put_CP_Clinician_Request_Bolus(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.CP_Clinician_Request_Bolus_Id, Empty())
  }

  // setter for in EventPort
  def put_Halt_Infusion(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Halt_Infusion_Id, Empty())
  }

  // setter for in EventPort
  def put_Begin_Infusion(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Begin_Infusion_Id, Empty())
  }

  // setter for in EventPort
  def put_Near_Max_Drug_Per_Hour(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Near_Max_Drug_Per_Hour_Id, Empty())
  }

  // setter for in EventPort
  def put_Over_Max_Drug_Per_Hour(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Over_Max_Drug_Per_Hour_Id, Empty())
  }

  // getter for out EventPort
  def get_ICE_Stop_Pump(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_ICE_Stop_Pump_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port ICE_Stop_Pump.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_ICE_Stop_Pump_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.ICE_Stop_Pump_Id).asInstanceOf[Option[Empty]]
  }

}
