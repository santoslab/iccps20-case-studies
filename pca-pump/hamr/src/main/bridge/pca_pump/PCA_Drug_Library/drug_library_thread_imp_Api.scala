// #Sireum

package pca_pump.PCA_Drug_Library

import org.sireum._
import art._
import pca_pump._

@sig trait drug_library_thread_imp_Api {
  def id: Art.BridgeId
  def Load_Drug_Library_Id : Art.PortId
  def Get_Drug_Record_Id : Art.PortId
  def The_Drug_Record_Id : Art.PortId
  def No_Drug_Found_Id : Art.PortId

  def sendThe_Drug_Record(value : PCA_Types.Drug_Record_imp) : Unit = {
    Art.putValue(The_Drug_Record_Id, PCA_Types.Drug_Record_imp_Payload(value))
  }

  def sendNo_Drug_Found() : Unit = {
    Art.putValue(No_Drug_Found_Id, art.Empty())
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

@datatype class drug_library_thread_imp_Initialization_Api (
  val id: Art.BridgeId,
  val Load_Drug_Library_Id : Art.PortId,
  val Get_Drug_Record_Id : Art.PortId,
  val The_Drug_Record_Id : Art.PortId,
  val No_Drug_Found_Id : Art.PortId) extends drug_library_thread_imp_Api

@datatype class drug_library_thread_imp_Operational_Api (
  val id: Art.BridgeId,
  val Load_Drug_Library_Id : Art.PortId,
  val Get_Drug_Record_Id : Art.PortId,
  val The_Drug_Record_Id : Art.PortId,
  val No_Drug_Found_Id : Art.PortId) extends drug_library_thread_imp_Api {

  def getLoad_Drug_Library() : Option[PCA_Types.Drug_Library] = {
    val value : Option[PCA_Types.Drug_Library] = Art.getValue(Load_Drug_Library_Id) match {
      case Some(PCA_Types.Drug_Library_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Load_Drug_Library.  Expecting 'PCA_Types.Drug_Library_Payload' but received ${v}")
        None[PCA_Types.Drug_Library]()
      case _ => None[PCA_Types.Drug_Library]()
    }
    return value
  }

  def getGet_Drug_Record() : Option[PCA_Types.Drug_Code_imp] = {
    val value : Option[PCA_Types.Drug_Code_imp] = Art.getValue(Get_Drug_Record_Id) match {
      case Some(PCA_Types.Drug_Code_imp_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Get_Drug_Record.  Expecting 'PCA_Types.Drug_Code_imp_Payload' but received ${v}")
        None[PCA_Types.Drug_Code_imp]()
      case _ => None[PCA_Types.Drug_Code_imp]()
    }
    return value
  }
}
