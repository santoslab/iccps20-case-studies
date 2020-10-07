// #Sireum

package pca_pump.PCA_Safety

import org.sireum._
import art._
import pca_pump._

@sig trait failure_led_imp_Api {
  def id: Art.BridgeId
  def Light_Id : Art.PortId
  def Illuminate_Id : Art.PortId

  def setLight(value : Base_Types.Boolean) : Unit = {
    Art.putValue(Light_Id, Base_Types.Boolean_Payload(value))
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

@datatype class failure_led_imp_Initialization_Api (
  val id: Art.BridgeId,
  val Light_Id : Art.PortId,
  val Illuminate_Id : Art.PortId) extends failure_led_imp_Api

@datatype class failure_led_imp_Operational_Api (
  val id: Art.BridgeId,
  val Light_Id : Art.PortId,
  val Illuminate_Id : Art.PortId) extends failure_led_imp_Api {

  def getIlluminate() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(Illuminate_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Illuminate.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }
}
