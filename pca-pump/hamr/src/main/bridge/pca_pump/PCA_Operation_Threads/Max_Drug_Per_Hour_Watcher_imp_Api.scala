// #Sireum

package pca_pump.PCA_Operation_Threads

import org.sireum._
import art._
import pca_pump._

@sig trait Max_Drug_Per_Hour_Watcher_imp_Api {
  def id: Art.BridgeId
  def Infusion_Flow_Rate_Id : Art.PortId
  def Max_Drug_Per_Hour_Id : Art.PortId
  def Near_Max_Drug_Per_Hour_Id : Art.PortId
  def Over_Max_Drug_Per_Hour_Id : Art.PortId

  def sendNear_Max_Drug_Per_Hour() : Unit = {
    Art.putValue(Near_Max_Drug_Per_Hour_Id, art.Empty())
  }

  def sendOver_Max_Drug_Per_Hour() : Unit = {
    Art.putValue(Over_Max_Drug_Per_Hour_Id, art.Empty())
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

@datatype class Max_Drug_Per_Hour_Watcher_imp_Initialization_Api (
  val id: Art.BridgeId,
  val Infusion_Flow_Rate_Id : Art.PortId,
  val Max_Drug_Per_Hour_Id : Art.PortId,
  val Near_Max_Drug_Per_Hour_Id : Art.PortId,
  val Over_Max_Drug_Per_Hour_Id : Art.PortId) extends Max_Drug_Per_Hour_Watcher_imp_Api

@datatype class Max_Drug_Per_Hour_Watcher_imp_Operational_Api (
  val id: Art.BridgeId,
  val Infusion_Flow_Rate_Id : Art.PortId,
  val Max_Drug_Per_Hour_Id : Art.PortId,
  val Near_Max_Drug_Per_Hour_Id : Art.PortId,
  val Over_Max_Drug_Per_Hour_Id : Art.PortId) extends Max_Drug_Per_Hour_Watcher_imp_Api {

  def getInfusion_Flow_Rate() : Option[PCA_Types.Flow_Rate_imp] = {
    val value : Option[PCA_Types.Flow_Rate_imp] = Art.getValue(Infusion_Flow_Rate_Id) match {
      case Some(PCA_Types.Flow_Rate_imp_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Infusion_Flow_Rate.  Expecting 'PCA_Types.Flow_Rate_imp_Payload' but received ${v}")
        None[PCA_Types.Flow_Rate_imp]()
      case _ => None[PCA_Types.Flow_Rate_imp]()
    }
    return value
  }

  def getMax_Drug_Per_Hour() : Option[PCA_Types.Drug_Volume_imp] = {
    val value : Option[PCA_Types.Drug_Volume_imp] = Art.getValue(Max_Drug_Per_Hour_Id) match {
      case Some(PCA_Types.Drug_Volume_imp_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Max_Drug_Per_Hour.  Expecting 'PCA_Types.Drug_Volume_imp_Payload' but received ${v}")
        None[PCA_Types.Drug_Volume_imp]()
      case _ => None[PCA_Types.Drug_Volume_imp]()
    }
    return value
  }
}
