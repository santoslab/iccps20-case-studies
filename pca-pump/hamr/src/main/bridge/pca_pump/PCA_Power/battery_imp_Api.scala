// #Sireum

package pca_pump.PCA_Power

import org.sireum._
import art._
import pca_pump._

@sig trait battery_imp_Api {
  def id: Art.BridgeId
  def Battery_Voltage_Id : Art.PortId
  def Battery_Current_Id : Art.PortId

  def setBattery_Voltage(value : Physical_Types.Voltage_imp) : Unit = {
    Art.putValue(Battery_Voltage_Id, Physical_Types.Voltage_imp_Payload(value))
  }

  def setBattery_Current(value : Physical_Types.Current_imp) : Unit = {
    Art.putValue(Battery_Current_Id, Physical_Types.Current_imp_Payload(value))
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

@datatype class battery_imp_Initialization_Api (
  val id: Art.BridgeId,
  val Battery_Voltage_Id : Art.PortId,
  val Battery_Current_Id : Art.PortId) extends battery_imp_Api

@datatype class battery_imp_Operational_Api (
  val id: Art.BridgeId,
  val Battery_Voltage_Id : Art.PortId,
  val Battery_Current_Id : Art.PortId) extends battery_imp_Api {

}
