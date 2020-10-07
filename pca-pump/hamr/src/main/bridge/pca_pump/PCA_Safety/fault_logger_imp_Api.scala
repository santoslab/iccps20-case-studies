// #Sireum

package pca_pump.PCA_Safety

import org.sireum._
import art._
import pca_pump._

@sig trait fault_logger_imp_Api {
  def id: Art.BridgeId
  def Log_Fault_Id : Art.PortId
  def The_Log_Id : Art.PortId
  def Get_Log_Id : Art.PortId
  def POST_Failure_Id : Art.PortId
  def RAM_Failure_Id : Art.PortId
  def ROM_Failure_Id : Art.PortId
  def CPU_Failure_Id : Art.PortId
  def Thread_Monitor_Failure_Id : Art.PortId
  def Voltage_OOR_Id : Art.PortId

  def sendThe_Log(value : PCA_Types.Fault_Log) : Unit = {
    Art.putValue(The_Log_Id, PCA_Types.Fault_Log_Payload(value))
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

@datatype class fault_logger_imp_Initialization_Api (
  val id: Art.BridgeId,
  val Log_Fault_Id : Art.PortId,
  val The_Log_Id : Art.PortId,
  val Get_Log_Id : Art.PortId,
  val POST_Failure_Id : Art.PortId,
  val RAM_Failure_Id : Art.PortId,
  val ROM_Failure_Id : Art.PortId,
  val CPU_Failure_Id : Art.PortId,
  val Thread_Monitor_Failure_Id : Art.PortId,
  val Voltage_OOR_Id : Art.PortId) extends fault_logger_imp_Api

@datatype class fault_logger_imp_Operational_Api (
  val id: Art.BridgeId,
  val Log_Fault_Id : Art.PortId,
  val The_Log_Id : Art.PortId,
  val Get_Log_Id : Art.PortId,
  val POST_Failure_Id : Art.PortId,
  val RAM_Failure_Id : Art.PortId,
  val ROM_Failure_Id : Art.PortId,
  val CPU_Failure_Id : Art.PortId,
  val Thread_Monitor_Failure_Id : Art.PortId,
  val Voltage_OOR_Id : Art.PortId) extends fault_logger_imp_Api {

  def getLog_Fault() : Option[PCA_Types.Fault_Record_imp] = {
    val value : Option[PCA_Types.Fault_Record_imp] = Art.getValue(Log_Fault_Id) match {
      case Some(PCA_Types.Fault_Record_imp_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Log_Fault.  Expecting 'PCA_Types.Fault_Record_imp_Payload' but received ${v}")
        None[PCA_Types.Fault_Record_imp]()
      case _ => None[PCA_Types.Fault_Record_imp]()
    }
    return value
  }

  def getGet_Log() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(Get_Log_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Get_Log.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  def getPOST_Failure() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(POST_Failure_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port POST_Failure.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  def getRAM_Failure() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(RAM_Failure_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port RAM_Failure.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  def getROM_Failure() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(ROM_Failure_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port ROM_Failure.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  def getCPU_Failure() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(CPU_Failure_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port CPU_Failure.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  def getThread_Monitor_Failure() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(Thread_Monitor_Failure_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Thread_Monitor_Failure.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  def getVoltage_OOR() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(Voltage_OOR_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Voltage_OOR.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }
}
