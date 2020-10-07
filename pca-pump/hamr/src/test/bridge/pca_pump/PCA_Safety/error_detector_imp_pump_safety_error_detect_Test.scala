package pca_pump.PCA_Safety

import art.{ArtNative_Ext, Empty}
import pca_pump._
import org.sireum._

// This file will not be overwritten so is safe to edit
class error_detector_imp_pump_safety_error_detect_Test extends BridgeTestSuite[error_detector_imp_pump_safety_error_detect_Bridge](Arch.wrap_pca_imp_Instance_pump_safety_error_detect) {
  test("Example Unit Test"){
    executeTest()
  }

  //////////////////////
  // HELPER FUNCTIONS //
  //////////////////////

  // setter for in EventPort
  def put_Software_Stop_Pump(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Software_Stop_Pump_Id, Empty())
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
  def get_POST_Failure(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_POST_Failure_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port POST_Failure.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_POST_Failure_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.POST_Failure_Id).asInstanceOf[Option[Empty]]
  }

  // getter for out EventPort
  def get_POST_Done(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_POST_Done_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port POST_Done.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_POST_Done_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.POST_Done_Id).asInstanceOf[Option[Empty]]
  }

  // getter for out EventPort
  def get_RAM_Failure(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_RAM_Failure_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port RAM_Failure.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_RAM_Failure_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.RAM_Failure_Id).asInstanceOf[Option[Empty]]
  }

  // getter for out EventPort
  def get_ROM_failure(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_ROM_failure_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port ROM_failure.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_ROM_failure_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.ROM_failure_Id).asInstanceOf[Option[Empty]]
  }

  // getter for out EventPort
  def get_CPU_Failure(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_CPU_Failure_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port CPU_Failure.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_CPU_Failure_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.CPU_Failure_Id).asInstanceOf[Option[Empty]]
  }

  // getter for out EventPort
  def get_Thread_Monitor_Failure(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_Thread_Monitor_Failure_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port Thread_Monitor_Failure.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_Thread_Monitor_Failure_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Thread_Monitor_Failure_Id).asInstanceOf[Option[Empty]]
  }

  // getter for out EventPort
  def get_HW_Detected_Failure(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_HW_Detected_Failure_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port HW_Detected_Failure.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_HW_Detected_Failure_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.HW_Detected_Failure_Id).asInstanceOf[Option[Empty]]
  }

}
