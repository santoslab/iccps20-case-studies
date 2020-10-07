package pca_pump.PCA_Alarm

import art.{ArtNative_Ext, Empty}
import pca_pump._
import org.sireum._

// This file will not be overwritten so is safe to edit
class alarm_thread_imp_pump_safety_alarm_process_alarm_thr_Test extends BridgeTestSuite[alarm_thread_imp_pump_safety_alarm_process_alarm_thr_Bridge](Arch.wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr) {
  test("Example Unit Test"){
    executeTest()
  }

  //////////////////////
  // HELPER FUNCTIONS //
  //////////////////////

  // setter for in EventDataPort
  def put_ICE_Alarm_Signal(value : ICE_Types.Alarm_Signal.Type): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.ICE_Alarm_Signal_Id, ICE_Types.Alarm_Signal_Payload(value))
  }

  // setter for in EventPort
  def put_ICE_Reset_Alarm(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.ICE_Reset_Alarm_Id, Empty())
  }

  // setter for in EventPort
  def put_Max_Dose_Warning(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Max_Dose_Warning_Id, Empty())
  }

  // setter for in EventPort
  def put_Hard_Limit_Violation(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Hard_Limit_Violation_Id, Empty())
  }

  // setter for in EventPort
  def put_Empty_Res(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Empty_Res_Id, Empty())
  }

  // setter for in EventPort
  def put_Low_Res(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Low_Res_Id, Empty())
  }

  // setter for in EventPort
  def put_Pump_Hot(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Pump_Hot_Id, Empty())
  }

  // setter for in EventPort
  def put_Upstream_Occlusion(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Upstream_Occlusion_Id, Empty())
  }

  // setter for in EventPort
  def put_Downstream_Occlusion(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Downstream_Occlusion_Id, Empty())
  }

  // setter for in EventPort
  def put_Bubble(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Bubble_Id, Empty())
  }

  // setter for in EventPort
  def put_Prime_Failure(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Prime_Failure_Id, Empty())
  }

  // setter for in EventPort
  def put_CP_Reset_Alarm(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.CP_Reset_Alarm_Id, Empty())
  }

  // setter for in EventPort
  def put_Drug_Not_In_Library(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Drug_Not_In_Library_Id, Empty())
  }

  // setter for in EventPort
  def put_Defective_Btty(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Defective_Btty_Id, Empty())
  }

  // setter for in EventPort
  def put_Low_Battery_Warning(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Low_Battery_Warning_Id, Empty())
  }

  // setter for in EventPort
  def put_Voltage_OOR(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Voltage_OOR_Id, Empty())
  }

  // setter for in EventPort
  def put_Basal_Overinfusion(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Basal_Overinfusion_Id, Empty())
  }

  // setter for in EventPort
  def put_Bolus_Overinfusion(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Bolus_Overinfusion_Id, Empty())
  }

  // setter for in EventPort
  def put_Square_Bolus_Overinfusion(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Square_Bolus_Overinfusion_Id, Empty())
  }

  // setter for in EventPort
  def put_Basal_Underinfusion(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Basal_Underinfusion_Id, Empty())
  }

  // setter for in EventPort
  def put_Bolus_Underinfusion(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Bolus_Underinfusion_Id, Empty())
  }

  // setter for in EventPort
  def put_Square_Bolus_Underinfusion(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Square_Bolus_Underinfusion_Id, Empty())
  }

  // setter for in EventPort
  def put_Security_Fault(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Security_Fault_Id, Empty())
  }

  // getter for out EventDataPort
  def get_Alarm(): Option[PCA_Types.Alarm_Type.Type] = {
    val value: Option[PCA_Types.Alarm_Type.Type] = get_Alarm_payload() match {
      case Some(PCA_Types.Alarm_Type_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port Alarm.  Expecting 'PCA_Types.Alarm_Type_Payload' but received ${v}")
      case _ => None[PCA_Types.Alarm_Type.Type]()
    }
    return value
  }

  // payload getter for out EventDataPort
  def get_Alarm_payload(): Option[PCA_Types.Alarm_Type_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Alarm_Id).asInstanceOf[Option[PCA_Types.Alarm_Type_Payload]]
  }

  // getter for out EventDataPort
  def get_Warning(): Option[PCA_Types.Warning_Type.Type] = {
    val value: Option[PCA_Types.Warning_Type.Type] = get_Warning_payload() match {
      case Some(PCA_Types.Warning_Type_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port Warning.  Expecting 'PCA_Types.Warning_Type_Payload' but received ${v}")
      case _ => None[PCA_Types.Warning_Type.Type]()
    }
    return value
  }

  // payload getter for out EventDataPort
  def get_Warning_payload(): Option[PCA_Types.Warning_Type_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Warning_Id).asInstanceOf[Option[PCA_Types.Warning_Type_Payload]]
  }

  // getter for out EventDataPort
  def get_Log_Fault(): Option[PCA_Types.Fault_Record_imp] = {
    val value: Option[PCA_Types.Fault_Record_imp] = get_Log_Fault_payload() match {
      case Some(PCA_Types.Fault_Record_imp_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port Log_Fault.  Expecting 'PCA_Types.Fault_Record_imp_Payload' but received ${v}")
      case _ => None[PCA_Types.Fault_Record_imp]()
    }
    return value
  }

  // payload getter for out EventDataPort
  def get_Log_Fault_payload(): Option[PCA_Types.Fault_Record_imp_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Log_Fault_Id).asInstanceOf[Option[PCA_Types.Fault_Record_imp_Payload]]
  }

  // getter for out EventPort
  def get_ICE_Immediate(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_ICE_Immediate_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port ICE_Immediate.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_ICE_Immediate_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.ICE_Immediate_Id).asInstanceOf[Option[Empty]]
  }

  // getter for out EventPort
  def get_ICE_Prompt(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_ICE_Prompt_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port ICE_Prompt.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_ICE_Prompt_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.ICE_Prompt_Id).asInstanceOf[Option[Empty]]
  }

  // getter for out EventPort
  def get_ICE_Delayed(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_ICE_Delayed_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port ICE_Delayed.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_ICE_Delayed_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.ICE_Delayed_Id).asInstanceOf[Option[Empty]]
  }

  // getter for out EventPort
  def get_ICE_Malfunction(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_ICE_Malfunction_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port ICE_Malfunction.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_ICE_Malfunction_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.ICE_Malfunction_Id).asInstanceOf[Option[Empty]]
  }

  // getter for out EventPort
  def get_Stop_Pump_Completely(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_Stop_Pump_Completely_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port Stop_Pump_Completely.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_Stop_Pump_Completely_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Stop_Pump_Completely_Id).asInstanceOf[Option[Empty]]
  }

  // getter for out EventPort
  def get_Pump_At_KVO_Rate(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_Pump_At_KVO_Rate_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port Pump_At_KVO_Rate.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_Pump_At_KVO_Rate_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Pump_At_KVO_Rate_Id).asInstanceOf[Option[Empty]]
  }

}
