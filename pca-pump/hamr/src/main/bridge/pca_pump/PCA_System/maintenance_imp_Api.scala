// #Sireum

package pca_pump.PCA_System

import org.sireum._
import art._
import pca_pump._

@sig trait maintenance_imp_Api {
  def id: Art.BridgeId
  def The_Fault_Log_Id : Art.PortId
  def The_Event_Log_Id : Art.PortId
  def Load_Drug_Library_Id : Art.PortId
  def Get_Fault_Log_Id : Art.PortId
  def Get_Event_Log_Id : Art.PortId

  def sendLoad_Drug_Library(value : PCA_Types.Drug_Library) : Unit = {
    Art.putValue(Load_Drug_Library_Id, PCA_Types.Drug_Library_Payload(value))
  }

  def sendGet_Fault_Log() : Unit = {
    Art.putValue(Get_Fault_Log_Id, art.Empty())
  }

  def sendGet_Event_Log() : Unit = {
    Art.putValue(Get_Event_Log_Id, art.Empty())
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

@datatype class maintenance_imp_Initialization_Api (
  val id: Art.BridgeId,
  val The_Fault_Log_Id : Art.PortId,
  val The_Event_Log_Id : Art.PortId,
  val Load_Drug_Library_Id : Art.PortId,
  val Get_Fault_Log_Id : Art.PortId,
  val Get_Event_Log_Id : Art.PortId) extends maintenance_imp_Api

@datatype class maintenance_imp_Operational_Api (
  val id: Art.BridgeId,
  val The_Fault_Log_Id : Art.PortId,
  val The_Event_Log_Id : Art.PortId,
  val Load_Drug_Library_Id : Art.PortId,
  val Get_Fault_Log_Id : Art.PortId,
  val Get_Event_Log_Id : Art.PortId) extends maintenance_imp_Api {

  def getThe_Fault_Log() : Option[PCA_Types.Fault_Log] = {
    val value : Option[PCA_Types.Fault_Log] = Art.getValue(The_Fault_Log_Id) match {
      case Some(PCA_Types.Fault_Log_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port The_Fault_Log.  Expecting 'PCA_Types.Fault_Log_Payload' but received ${v}")
        None[PCA_Types.Fault_Log]()
      case _ => None[PCA_Types.Fault_Log]()
    }
    return value
  }

  def getThe_Event_Log() : Option[PCA_Types.Event_Log] = {
    val value : Option[PCA_Types.Event_Log] = Art.getValue(The_Event_Log_Id) match {
      case Some(PCA_Types.Event_Log_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port The_Event_Log.  Expecting 'PCA_Types.Event_Log_Payload' but received ${v}")
        None[PCA_Types.Event_Log]()
      case _ => None[PCA_Types.Event_Log]()
    }
    return value
  }
}
