// #Sireum

package pca_pump.PCA_Operation_Threads

import org.sireum._
import art._
import pca_pump._

@sig trait Patient_Bolus_Checker_imp_Api {
  def id: Art.BridgeId
  def Minimum_Time_Between_Bolus_Id : Art.PortId
  def Patient_Button_Request_Id : Art.PortId
  def Patient_Request_Not_Too_Soon_Id : Art.PortId
  def Patient_Request_Too_Soon_Id : Art.PortId

  def sendPatient_Request_Not_Too_Soon() : Unit = {
    Art.putValue(Patient_Request_Not_Too_Soon_Id, art.Empty())
  }

  def sendPatient_Request_Too_Soon() : Unit = {
    Art.putValue(Patient_Request_Too_Soon_Id, art.Empty())
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

@datatype class Patient_Bolus_Checker_imp_Initialization_Api (
  val id: Art.BridgeId,
  val Minimum_Time_Between_Bolus_Id : Art.PortId,
  val Patient_Button_Request_Id : Art.PortId,
  val Patient_Request_Not_Too_Soon_Id : Art.PortId,
  val Patient_Request_Too_Soon_Id : Art.PortId) extends Patient_Bolus_Checker_imp_Api

@datatype class Patient_Bolus_Checker_imp_Operational_Api (
  val id: Art.BridgeId,
  val Minimum_Time_Between_Bolus_Id : Art.PortId,
  val Patient_Button_Request_Id : Art.PortId,
  val Patient_Request_Not_Too_Soon_Id : Art.PortId,
  val Patient_Request_Too_Soon_Id : Art.PortId) extends Patient_Bolus_Checker_imp_Api {

  def getMinimum_Time_Between_Bolus() : Option[ICE_Types.Minute_imp] = {
    val value : Option[ICE_Types.Minute_imp] = Art.getValue(Minimum_Time_Between_Bolus_Id) match {
      case Some(ICE_Types.Minute_imp_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Minimum_Time_Between_Bolus.  Expecting 'ICE_Types.Minute_imp_Payload' but received ${v}")
        None[ICE_Types.Minute_imp]()
      case _ => None[ICE_Types.Minute_imp]()
    }
    return value
  }

  def getPatient_Button_Request() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(Patient_Button_Request_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Patient_Button_Request.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }
}
