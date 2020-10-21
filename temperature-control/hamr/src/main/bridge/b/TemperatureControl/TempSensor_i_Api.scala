// #Sireum

package b.TemperatureControl

import org.sireum._
import art._
import b._

@sig trait TempSensor_i_Api {
  def id: Art.BridgeId
  def currentTemp_Id : Art.PortId
  def tempChanged_Id : Art.PortId

  def setcurrentTemp(value : TemperatureControl.Temperature_i) : Unit = {
    Art.putValue(currentTemp_Id, TemperatureControl.Temperature_i_Payload(value))
  }

  def sendtempChanged() : Unit = {
    Art.putValue(tempChanged_Id, art.Empty())
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

@datatype class TempSensor_i_Initialization_Api (
  val id: Art.BridgeId,
  val currentTemp_Id : Art.PortId,
  val tempChanged_Id : Art.PortId) extends TempSensor_i_Api

@datatype class TempSensor_i_Operational_Api (
  val id: Art.BridgeId,
  val currentTemp_Id : Art.PortId,
  val tempChanged_Id : Art.PortId) extends TempSensor_i_Api {

}
