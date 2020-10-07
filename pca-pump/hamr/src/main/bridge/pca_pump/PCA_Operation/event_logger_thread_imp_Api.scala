// #Sireum

package pca_pump.PCA_Operation

import org.sireum._
import art._
import pca_pump._

@sig trait event_logger_thread_imp_Api {
  def id: Art.BridgeId
  def Log_Event_Id : Art.PortId
  def The_Event_Log_Id : Art.PortId
  def Get_Event_Log_Id : Art.PortId

  def sendThe_Event_Log(value : PCA_Types.Event_Log) : Unit = {
    Art.putValue(The_Event_Log_Id, PCA_Types.Event_Log_Payload(value))
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

@datatype class event_logger_thread_imp_Initialization_Api (
  val id: Art.BridgeId,
  val Log_Event_Id : Art.PortId,
  val The_Event_Log_Id : Art.PortId,
  val Get_Event_Log_Id : Art.PortId) extends event_logger_thread_imp_Api

@datatype class event_logger_thread_imp_Operational_Api (
  val id: Art.BridgeId,
  val Log_Event_Id : Art.PortId,
  val The_Event_Log_Id : Art.PortId,
  val Get_Event_Log_Id : Art.PortId) extends event_logger_thread_imp_Api {

  def getLog_Event() : Option[PCA_Types.Event_Record] = {
    val value : Option[PCA_Types.Event_Record] = Art.getValue(Log_Event_Id) match {
      case Some(PCA_Types.Event_Record_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Log_Event.  Expecting 'PCA_Types.Event_Record_Payload' but received ${v}")
        None[PCA_Types.Event_Record]()
      case _ => None[PCA_Types.Event_Record]()
    }
    return value
  }

  def getGet_Event_Log() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(Get_Event_Log_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Get_Event_Log.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }
}
