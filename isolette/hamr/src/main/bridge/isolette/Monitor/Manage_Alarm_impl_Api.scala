// #Sireum

package isolette.Monitor

import org.sireum._
import art._
import isolette._

@sig trait Manage_Alarm_impl_Api {
  def id: Art.BridgeId
  def current_tempWstatus_Id : Art.PortId
  def lower_alarm_temp_Id : Art.PortId
  def upper_alarm_temp_Id : Art.PortId
  def monitor_mode_Id : Art.PortId
  def alarm_control_Id : Art.PortId

  def setalarm_control(value : Isolette_Data_Model.On_Off.Type) : Unit = {
    Art.putValue(alarm_control_Id, Isolette_Data_Model.On_Off_Payload(value))
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

@datatype class Manage_Alarm_impl_Initialization_Api (
  val id: Art.BridgeId,
  val current_tempWstatus_Id : Art.PortId,
  val lower_alarm_temp_Id : Art.PortId,
  val upper_alarm_temp_Id : Art.PortId,
  val monitor_mode_Id : Art.PortId,
  val alarm_control_Id : Art.PortId) extends Manage_Alarm_impl_Api

@datatype class Manage_Alarm_impl_Operational_Api (
  val id: Art.BridgeId,
  val current_tempWstatus_Id : Art.PortId,
  val lower_alarm_temp_Id : Art.PortId,
  val upper_alarm_temp_Id : Art.PortId,
  val monitor_mode_Id : Art.PortId,
  val alarm_control_Id : Art.PortId) extends Manage_Alarm_impl_Api {

  def getcurrent_tempWstatus() : Option[Isolette_Data_Model.TempWstatus_impl] = {
    val value : Option[Isolette_Data_Model.TempWstatus_impl] = Art.getValue(current_tempWstatus_Id) match {
      case Some(Isolette_Data_Model.TempWstatus_impl_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port current_tempWstatus.  Expecting 'Isolette_Data_Model.TempWstatus_impl_Payload' but received ${v}")
        None[Isolette_Data_Model.TempWstatus_impl]()
      case _ => None[Isolette_Data_Model.TempWstatus_impl]()
    }
    return value
  }

  def getlower_alarm_temp() : Option[Isolette_Data_Model.Temp_impl] = {
    val value : Option[Isolette_Data_Model.Temp_impl] = Art.getValue(lower_alarm_temp_Id) match {
      case Some(Isolette_Data_Model.Temp_impl_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port lower_alarm_temp.  Expecting 'Isolette_Data_Model.Temp_impl_Payload' but received ${v}")
        None[Isolette_Data_Model.Temp_impl]()
      case _ => None[Isolette_Data_Model.Temp_impl]()
    }
    return value
  }

  def getupper_alarm_temp() : Option[Isolette_Data_Model.Temp_impl] = {
    val value : Option[Isolette_Data_Model.Temp_impl] = Art.getValue(upper_alarm_temp_Id) match {
      case Some(Isolette_Data_Model.Temp_impl_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port upper_alarm_temp.  Expecting 'Isolette_Data_Model.Temp_impl_Payload' but received ${v}")
        None[Isolette_Data_Model.Temp_impl]()
      case _ => None[Isolette_Data_Model.Temp_impl]()
    }
    return value
  }

  def getmonitor_mode() : Option[Isolette_Data_Model.Monitor_Mode.Type] = {
    val value : Option[Isolette_Data_Model.Monitor_Mode.Type] = Art.getValue(monitor_mode_Id) match {
      case Some(Isolette_Data_Model.Monitor_Mode_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port monitor_mode.  Expecting 'Isolette_Data_Model.Monitor_Mode_Payload' but received ${v}")
        None[Isolette_Data_Model.Monitor_Mode.Type]()
      case _ => None[Isolette_Data_Model.Monitor_Mode.Type]()
    }
    return value
  }
}
