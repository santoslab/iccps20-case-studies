// #Sireum

package pca_pump.PCA_Safety

import org.sireum._
import art._
import pca_pump._

@sig trait error_detector_imp_Api {
  def id: Art.BridgeId
  def Software_Stop_Pump_Id : Art.PortId
  def Stop_Pump_Completely_Id : Art.PortId
  def POST_Failure_Id : Art.PortId
  def POST_Done_Id : Art.PortId
  def RAM_Failure_Id : Art.PortId
  def ROM_failure_Id : Art.PortId
  def CPU_Failure_Id : Art.PortId
  def Thread_Monitor_Failure_Id : Art.PortId
  def HW_Detected_Failure_Id : Art.PortId

  def sendStop_Pump_Completely() : Unit = {
    Art.putValue(Stop_Pump_Completely_Id, art.Empty())
  }

  def sendPOST_Failure() : Unit = {
    Art.putValue(POST_Failure_Id, art.Empty())
  }

  def sendPOST_Done() : Unit = {
    Art.putValue(POST_Done_Id, art.Empty())
  }

  def sendRAM_Failure() : Unit = {
    Art.putValue(RAM_Failure_Id, art.Empty())
  }

  def sendROM_failure() : Unit = {
    Art.putValue(ROM_failure_Id, art.Empty())
  }

  def sendCPU_Failure() : Unit = {
    Art.putValue(CPU_Failure_Id, art.Empty())
  }

  def sendThread_Monitor_Failure() : Unit = {
    Art.putValue(Thread_Monitor_Failure_Id, art.Empty())
  }

  def sendHW_Detected_Failure() : Unit = {
    Art.putValue(HW_Detected_Failure_Id, art.Empty())
  }

  def logInfo(msg: String): Unit = {
    Art.logInfo(id, msg)
  }

  def logDebug(msg: String): Unit = {
    Art.logDebug(id, msg)
  }

  def logError(msg: String): Unit = {
    Art.logError(id, msg)
  }
}

@datatype class error_detector_imp_Initialization_Api (
  val id: Art.BridgeId,
  val Software_Stop_Pump_Id : Art.PortId,
  val Stop_Pump_Completely_Id : Art.PortId,
  val POST_Failure_Id : Art.PortId,
  val POST_Done_Id : Art.PortId,
  val RAM_Failure_Id : Art.PortId,
  val ROM_failure_Id : Art.PortId,
  val CPU_Failure_Id : Art.PortId,
  val Thread_Monitor_Failure_Id : Art.PortId,
  val HW_Detected_Failure_Id : Art.PortId) extends error_detector_imp_Api

@datatype class error_detector_imp_Operational_Api (
  val id: Art.BridgeId,
  val Software_Stop_Pump_Id : Art.PortId,
  val Stop_Pump_Completely_Id : Art.PortId,
  val POST_Failure_Id : Art.PortId,
  val POST_Done_Id : Art.PortId,
  val RAM_Failure_Id : Art.PortId,
  val ROM_failure_Id : Art.PortId,
  val CPU_Failure_Id : Art.PortId,
  val Thread_Monitor_Failure_Id : Art.PortId,
  val HW_Detected_Failure_Id : Art.PortId) extends error_detector_imp_Api {

  def getSoftware_Stop_Pump() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(Software_Stop_Pump_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Software_Stop_Pump.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }
}
