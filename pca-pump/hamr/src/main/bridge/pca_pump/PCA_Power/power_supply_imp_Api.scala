// #Sireum

package pca_pump.PCA_Power

import org.sireum._
import art._
import pca_pump._

@sig trait power_supply_imp_Api {
  def id: Art.BridgeId
  def Power_Voltage_Id : Art.PortId

  def setPower_Voltage(value : Physical_Types.Voltage_imp) : Unit = {
    Art.putValue(Power_Voltage_Id, Physical_Types.Voltage_imp_Payload(value))
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

@datatype class power_supply_imp_Initialization_Api (
  val id: Art.BridgeId,
  val Power_Voltage_Id : Art.PortId) extends power_supply_imp_Api

@datatype class power_supply_imp_Operational_Api (
  val id: Art.BridgeId,
  val Power_Voltage_Id : Art.PortId) extends power_supply_imp_Api {

}
