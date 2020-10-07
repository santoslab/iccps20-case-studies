package pca_pump.PCA_Operation_Threads

import art.{ArtNative_Ext, Empty}
import pca_pump._
import org.sireum._

// This file will not be overwritten so is safe to edit
class Prescription_Checker_imp_pump_operation_operation_process_operation_threads_prescription_checker_Test extends BridgeTestSuite[Prescription_Checker_imp_pump_operation_operation_process_operation_threads_prescription_checker_Bridge](Arch.wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_prescription_checker) {
  test("Example Unit Test"){
    executeTest()
  }

  //////////////////////
  // HELPER FUNCTIONS //
  //////////////////////

  // setter for in DataPort
  def put_Prescription(value : PCA_Types.Prescription_imp): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Prescription_Id, PCA_Types.Prescription_imp_Payload(value))
  }

  // setter for in EventDataPort
  def put_The_Drug_Record(value : PCA_Types.Drug_Record_imp): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.The_Drug_Record_Id, PCA_Types.Drug_Record_imp_Payload(value))
  }

  // setter for in EventPort
  def put_Check_Rx(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Check_Rx_Id, Empty())
  }

  // setter for in EventPort
  def put_Drug_Not_In_Library(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Drug_Not_In_Library_Id, Empty())
  }

  // setter for in EventPort
  def put_Confirm_Soft_Limit_Exception(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Confirm_Soft_Limit_Exception_Id, Empty())
  }

  // setter for in EventPort
  def put_Reject_Soft_Limit_Exception(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Reject_Soft_Limit_Exception_Id, Empty())
  }

  // getter for out DataPort
  def get_VTBI(): Option[PCA_Types.Drug_Volume_imp] = {
    val value: Option[PCA_Types.Drug_Volume_imp] = get_VTBI_payload() match {
      case Some(PCA_Types.Drug_Volume_imp_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port VTBI.  Expecting 'PCA_Types.Drug_Volume_imp_Payload' but received ${v}")
      case _ => None[PCA_Types.Drug_Volume_imp]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_VTBI_payload(): Option[PCA_Types.Drug_Volume_imp_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.VTBI_Id).asInstanceOf[Option[PCA_Types.Drug_Volume_imp_Payload]]
  }

  // getter for out DataPort
  def get_Square_Bolus_Rate(): Option[PCA_Types.Flow_Rate_imp] = {
    val value: Option[PCA_Types.Flow_Rate_imp] = get_Square_Bolus_Rate_payload() match {
      case Some(PCA_Types.Flow_Rate_imp_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port Square_Bolus_Rate.  Expecting 'PCA_Types.Flow_Rate_imp_Payload' but received ${v}")
      case _ => None[PCA_Types.Flow_Rate_imp]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_Square_Bolus_Rate_payload(): Option[PCA_Types.Flow_Rate_imp_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Square_Bolus_Rate_Id).asInstanceOf[Option[PCA_Types.Flow_Rate_imp_Payload]]
  }

  // getter for out DataPort
  def get_Patient_Bolus_Rate(): Option[PCA_Types.Flow_Rate_imp] = {
    val value: Option[PCA_Types.Flow_Rate_imp] = get_Patient_Bolus_Rate_payload() match {
      case Some(PCA_Types.Flow_Rate_imp_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port Patient_Bolus_Rate.  Expecting 'PCA_Types.Flow_Rate_imp_Payload' but received ${v}")
      case _ => None[PCA_Types.Flow_Rate_imp]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_Patient_Bolus_Rate_payload(): Option[PCA_Types.Flow_Rate_imp_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Patient_Bolus_Rate_Id).asInstanceOf[Option[PCA_Types.Flow_Rate_imp_Payload]]
  }

  // getter for out DataPort
  def get_Basal_Rate(): Option[PCA_Types.Flow_Rate_imp] = {
    val value: Option[PCA_Types.Flow_Rate_imp] = get_Basal_Rate_payload() match {
      case Some(PCA_Types.Flow_Rate_imp_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port Basal_Rate.  Expecting 'PCA_Types.Flow_Rate_imp_Payload' but received ${v}")
      case _ => None[PCA_Types.Flow_Rate_imp]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_Basal_Rate_payload(): Option[PCA_Types.Flow_Rate_imp_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Basal_Rate_Id).asInstanceOf[Option[PCA_Types.Flow_Rate_imp_Payload]]
  }

  // getter for out DataPort
  def get_Minimum_Time_Between_Bolus(): Option[ICE_Types.Minute_imp] = {
    val value: Option[ICE_Types.Minute_imp] = get_Minimum_Time_Between_Bolus_payload() match {
      case Some(ICE_Types.Minute_imp_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port Minimum_Time_Between_Bolus.  Expecting 'ICE_Types.Minute_imp_Payload' but received ${v}")
      case _ => None[ICE_Types.Minute_imp]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_Minimum_Time_Between_Bolus_payload(): Option[ICE_Types.Minute_imp_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Minimum_Time_Between_Bolus_Id).asInstanceOf[Option[ICE_Types.Minute_imp_Payload]]
  }

  // getter for out DataPort
  def get_Max_Drug_Per_Hour(): Option[PCA_Types.Drug_Volume_imp] = {
    val value: Option[PCA_Types.Drug_Volume_imp] = get_Max_Drug_Per_Hour_payload() match {
      case Some(PCA_Types.Drug_Volume_imp_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port Max_Drug_Per_Hour.  Expecting 'PCA_Types.Drug_Volume_imp_Payload' but received ${v}")
      case _ => None[PCA_Types.Drug_Volume_imp]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_Max_Drug_Per_Hour_payload(): Option[PCA_Types.Drug_Volume_imp_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Max_Drug_Per_Hour_Id).asInstanceOf[Option[PCA_Types.Drug_Volume_imp_Payload]]
  }

  // getter for out EventDataPort
  def get_Get_Drug_Record(): Option[PCA_Types.Drug_Code_imp] = {
    val value: Option[PCA_Types.Drug_Code_imp] = get_Get_Drug_Record_payload() match {
      case Some(PCA_Types.Drug_Code_imp_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port Get_Drug_Record.  Expecting 'PCA_Types.Drug_Code_imp_Payload' but received ${v}")
      case _ => None[PCA_Types.Drug_Code_imp]()
    }
    return value
  }

  // payload getter for out EventDataPort
  def get_Get_Drug_Record_payload(): Option[PCA_Types.Drug_Code_imp_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Get_Drug_Record_Id).asInstanceOf[Option[PCA_Types.Drug_Code_imp_Payload]]
  }

  // getter for out EventPort
  def get_Rx_Okay(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_Rx_Okay_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port Rx_Okay.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_Rx_Okay_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Rx_Okay_Id).asInstanceOf[Option[Empty]]
  }

  // getter for out EventPort
  def get_Soft_Limit_Warning(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_Soft_Limit_Warning_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port Soft_Limit_Warning.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_Soft_Limit_Warning_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Soft_Limit_Warning_Id).asInstanceOf[Option[Empty]]
  }

  // getter for out EventPort
  def get_Hard_Limit_Violated(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_Hard_Limit_Violated_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port Hard_Limit_Violated.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_Hard_Limit_Violated_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Hard_Limit_Violated_Id).asInstanceOf[Option[Empty]]
  }

}
