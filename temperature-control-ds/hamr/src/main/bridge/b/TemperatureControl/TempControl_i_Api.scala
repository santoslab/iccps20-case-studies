// #Sireum

package b.TemperatureControl

import org.sireum._
import art._
import b._

@sig trait TempControl_i_Api {
  def id: Art.BridgeId
  def currentTemp_Id : Art.PortId
  def fanAck_Id : Art.PortId
  def setPoint_Id : Art.PortId
  def fanCmd_Id : Art.PortId
  def tempChanged_Id : Art.PortId

  def sendfanCmd(value : TemperatureControl.FanCmd.Type) : Unit = {
    Art.putValue(fanCmd_Id, TemperatureControl.FanCmd_Payload(value))
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

@datatype class TempControl_i_Initialization_Api (
  val id: Art.BridgeId,
  val currentTemp_Id : Art.PortId,
  val fanAck_Id : Art.PortId,
  val setPoint_Id : Art.PortId,
  val fanCmd_Id : Art.PortId,
  val tempChanged_Id : Art.PortId) extends TempControl_i_Api

@datatype class TempControl_i_Operational_Api (
  val id: Art.BridgeId,
  val currentTemp_Id : Art.PortId,
  val fanAck_Id : Art.PortId,
  val setPoint_Id : Art.PortId,
  val fanCmd_Id : Art.PortId,
  val tempChanged_Id : Art.PortId) extends TempControl_i_Api {

  def getcurrentTemp() : Option[TemperatureControl.Temperature_i] = {
    val value : Option[TemperatureControl.Temperature_i] = Art.getValue(currentTemp_Id) match {
      case Some(TemperatureControl.Temperature_i_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port currentTemp.  Expecting 'TemperatureControl.Temperature_i_Payload' but received ${v}")
        None[TemperatureControl.Temperature_i]()
      case _ => None[TemperatureControl.Temperature_i]()
    }
    return value
  }

  def getfanAck() : Option[TemperatureControl.FanAck.Type] = {
    val value : Option[TemperatureControl.FanAck.Type] = Art.getValue(fanAck_Id) match {
      case Some(TemperatureControl.FanAck_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port fanAck.  Expecting 'TemperatureControl.FanAck_Payload' but received ${v}")
        None[TemperatureControl.FanAck.Type]()
      case _ => None[TemperatureControl.FanAck.Type]()
    }
    return value
  }

  def getsetPoint() : Option[TemperatureControl.SetPoint_i] = {
    val value : Option[TemperatureControl.SetPoint_i] = Art.getValue(setPoint_Id) match {
      case Some(TemperatureControl.SetPoint_i_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port setPoint.  Expecting 'TemperatureControl.SetPoint_i_Payload' but received ${v}")
        None[TemperatureControl.SetPoint_i]()
      case _ => None[TemperatureControl.SetPoint_i]()
    }
    return value
  }

  def gettempChanged() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(tempChanged_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port tempChanged.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }
}
