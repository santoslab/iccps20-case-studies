// #Sireum

package pca_pump.PCA_Mechanical

import org.sireum._
import art._
import pca_pump._

@sig trait patient_button_imp_Api {
  def id: Art.BridgeId
  def Button_Press_Id : Art.PortId
  def Request_Bolus_Id : Art.PortId

  def sendRequest_Bolus() : Unit = {
    Art.putValue(Request_Bolus_Id, art.Empty())
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

@datatype class patient_button_imp_Initialization_Api (
  val id: Art.BridgeId,
  val Button_Press_Id : Art.PortId,
  val Request_Bolus_Id : Art.PortId) extends patient_button_imp_Api

@datatype class patient_button_imp_Operational_Api (
  val id: Art.BridgeId,
  val Button_Press_Id : Art.PortId,
  val Request_Bolus_Id : Art.PortId) extends patient_button_imp_Api {

  def getButton_Press() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(Button_Press_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Button_Press.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }
}
