// #Sireum

package b.TemperatureControl

import org.sireum._
import art._
import b._

@sig trait Fan_i_Api {
  def id: Art.BridgeId
  def fanCmd_Id : Art.PortId
  def fanAck_Id : Art.PortId

  def sendfanAck(value : TemperatureControl.FanAck.Type) : Unit = {
    Art.putValue(fanAck_Id, TemperatureControl.FanAck_Payload(value))
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

@datatype class Fan_i_Initialization_Api (
  val id: Art.BridgeId,
  val fanCmd_Id : Art.PortId,
  val fanAck_Id : Art.PortId) extends Fan_i_Api

@datatype class Fan_i_Operational_Api (
  val id: Art.BridgeId,
  val fanCmd_Id : Art.PortId,
  val fanAck_Id : Art.PortId) extends Fan_i_Api {

  def getfanCmd() : Option[TemperatureControl.FanCmd.Type] = {
    val value : Option[TemperatureControl.FanCmd.Type] = Art.getValue(fanCmd_Id) match {
      case Some(TemperatureControl.FanCmd_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port fanCmd.  Expecting 'TemperatureControl.FanCmd_Payload' but received ${v}")
        None[TemperatureControl.FanCmd.Type]()
      case _ => None[TemperatureControl.FanCmd.Type]()
    }
    return value
  }
}
