// #Sireum

package pca_pump.PCA_Power

import org.sireum._
import art._
import pca_pump._

@sig trait power_control_imp_Api {
  def id: Art.BridgeId
  def Battery_Voltage_Id : Art.PortId
  def Battery_Current_Id : Art.PortId
  def Power_Voltage_Id : Art.PortId
  def Using_Battery_Power_Id : Art.PortId
  def Remaining_Battery_Time_Id : Art.PortId
  def Low_Battery_Warning_Id : Art.PortId
  def Defective_Battery_Id : Art.PortId
  def Voltage_OOR_Id : Art.PortId

  def setUsing_Battery_Power(value : Base_Types.Boolean) : Unit = {
    Art.putValue(Using_Battery_Power_Id, Base_Types.Boolean_Payload(value))
  }

  def setRemaining_Battery_Time(value : BLESS_Types.Time) : Unit = {
    Art.putValue(Remaining_Battery_Time_Id, BLESS_Types.Time_Payload(value))
  }

  def sendLow_Battery_Warning() : Unit = {
    Art.putValue(Low_Battery_Warning_Id, art.Empty())
  }

  def sendDefective_Battery() : Unit = {
    Art.putValue(Defective_Battery_Id, art.Empty())
  }

  def sendVoltage_OOR() : Unit = {
    Art.putValue(Voltage_OOR_Id, art.Empty())
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

@datatype class power_control_imp_Initialization_Api (
  val id: Art.BridgeId,
  val Battery_Voltage_Id : Art.PortId,
  val Battery_Current_Id : Art.PortId,
  val Power_Voltage_Id : Art.PortId,
  val Using_Battery_Power_Id : Art.PortId,
  val Remaining_Battery_Time_Id : Art.PortId,
  val Low_Battery_Warning_Id : Art.PortId,
  val Defective_Battery_Id : Art.PortId,
  val Voltage_OOR_Id : Art.PortId) extends power_control_imp_Api

@datatype class power_control_imp_Operational_Api (
  val id: Art.BridgeId,
  val Battery_Voltage_Id : Art.PortId,
  val Battery_Current_Id : Art.PortId,
  val Power_Voltage_Id : Art.PortId,
  val Using_Battery_Power_Id : Art.PortId,
  val Remaining_Battery_Time_Id : Art.PortId,
  val Low_Battery_Warning_Id : Art.PortId,
  val Defective_Battery_Id : Art.PortId,
  val Voltage_OOR_Id : Art.PortId) extends power_control_imp_Api {

  def getBattery_Voltage() : Option[Physical_Types.Voltage_imp] = {
    val value : Option[Physical_Types.Voltage_imp] = Art.getValue(Battery_Voltage_Id) match {
      case Some(Physical_Types.Voltage_imp_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Battery_Voltage.  Expecting 'Physical_Types.Voltage_imp_Payload' but received ${v}")
        None[Physical_Types.Voltage_imp]()
      case _ => None[Physical_Types.Voltage_imp]()
    }
    return value
  }

  def getBattery_Current() : Option[Physical_Types.Current_imp] = {
    val value : Option[Physical_Types.Current_imp] = Art.getValue(Battery_Current_Id) match {
      case Some(Physical_Types.Current_imp_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Battery_Current.  Expecting 'Physical_Types.Current_imp_Payload' but received ${v}")
        None[Physical_Types.Current_imp]()
      case _ => None[Physical_Types.Current_imp]()
    }
    return value
  }

  def getPower_Voltage() : Option[Physical_Types.Voltage_imp] = {
    val value : Option[Physical_Types.Voltage_imp] = Art.getValue(Power_Voltage_Id) match {
      case Some(Physical_Types.Voltage_imp_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Power_Voltage.  Expecting 'Physical_Types.Voltage_imp_Payload' but received ${v}")
        None[Physical_Types.Voltage_imp]()
      case _ => None[Physical_Types.Voltage_imp]()
    }
    return value
  }
}
