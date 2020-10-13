// #Sireum

package isolette.Isolette

import org.sireum._
import art._
import isolette._

@sig trait operator_interface_thread_impl_Api {
  def id: Art.BridgeId
  def regulator_status_Id : Art.PortId
  def monitor_status_Id : Art.PortId
  def display_temperature_Id : Art.PortId
  def alarm_control_Id : Art.PortId
  def lower_desired_tempWstatus_Id : Art.PortId
  def upper_desired_tempWstatus_Id : Art.PortId
  def lower_alarm_tempWstatus_Id : Art.PortId
  def upper_alarm_tempWstatus_Id : Art.PortId

  def setlower_desired_tempWstatus(value : Isolette_Data_Model.TempWstatus_impl) : Unit = {
    Art.putValue(lower_desired_tempWstatus_Id, Isolette_Data_Model.TempWstatus_impl_Payload(value))
  }

  def setupper_desired_tempWstatus(value : Isolette_Data_Model.TempWstatus_impl) : Unit = {
    Art.putValue(upper_desired_tempWstatus_Id, Isolette_Data_Model.TempWstatus_impl_Payload(value))
  }

  def setlower_alarm_tempWstatus(value : Isolette_Data_Model.TempWstatus_impl) : Unit = {
    Art.putValue(lower_alarm_tempWstatus_Id, Isolette_Data_Model.TempWstatus_impl_Payload(value))
  }

  def setupper_alarm_tempWstatus(value : Isolette_Data_Model.TempWstatus_impl) : Unit = {
    Art.putValue(upper_alarm_tempWstatus_Id, Isolette_Data_Model.TempWstatus_impl_Payload(value))
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

@datatype class operator_interface_thread_impl_Initialization_Api (
  val id: Art.BridgeId,
  val regulator_status_Id : Art.PortId,
  val monitor_status_Id : Art.PortId,
  val display_temperature_Id : Art.PortId,
  val alarm_control_Id : Art.PortId,
  val lower_desired_tempWstatus_Id : Art.PortId,
  val upper_desired_tempWstatus_Id : Art.PortId,
  val lower_alarm_tempWstatus_Id : Art.PortId,
  val upper_alarm_tempWstatus_Id : Art.PortId) extends operator_interface_thread_impl_Api

@datatype class operator_interface_thread_impl_Operational_Api (
  val id: Art.BridgeId,
  val regulator_status_Id : Art.PortId,
  val monitor_status_Id : Art.PortId,
  val display_temperature_Id : Art.PortId,
  val alarm_control_Id : Art.PortId,
  val lower_desired_tempWstatus_Id : Art.PortId,
  val upper_desired_tempWstatus_Id : Art.PortId,
  val lower_alarm_tempWstatus_Id : Art.PortId,
  val upper_alarm_tempWstatus_Id : Art.PortId) extends operator_interface_thread_impl_Api {

  def getregulator_status() : Option[Isolette_Data_Model.Status.Type] = {
    val value : Option[Isolette_Data_Model.Status.Type] = Art.getValue(regulator_status_Id) match {
      case Some(Isolette_Data_Model.Status_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port regulator_status.  Expecting 'Isolette_Data_Model.Status_Payload' but received ${v}")
        None[Isolette_Data_Model.Status.Type]()
      case _ => None[Isolette_Data_Model.Status.Type]()
    }
    return value
  }

  def getmonitor_status() : Option[Isolette_Data_Model.Status.Type] = {
    val value : Option[Isolette_Data_Model.Status.Type] = Art.getValue(monitor_status_Id) match {
      case Some(Isolette_Data_Model.Status_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port monitor_status.  Expecting 'Isolette_Data_Model.Status_Payload' but received ${v}")
        None[Isolette_Data_Model.Status.Type]()
      case _ => None[Isolette_Data_Model.Status.Type]()
    }
    return value
  }

  def getdisplay_temperature() : Option[Isolette_Data_Model.Temp_impl] = {
    val value : Option[Isolette_Data_Model.Temp_impl] = Art.getValue(display_temperature_Id) match {
      case Some(Isolette_Data_Model.Temp_impl_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port display_temperature.  Expecting 'Isolette_Data_Model.Temp_impl_Payload' but received ${v}")
        None[Isolette_Data_Model.Temp_impl]()
      case _ => None[Isolette_Data_Model.Temp_impl]()
    }
    return value
  }

  def getalarm_control() : Option[Isolette_Data_Model.On_Off.Type] = {
    val value : Option[Isolette_Data_Model.On_Off.Type] = Art.getValue(alarm_control_Id) match {
      case Some(Isolette_Data_Model.On_Off_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port alarm_control.  Expecting 'Isolette_Data_Model.On_Off_Payload' but received ${v}")
        None[Isolette_Data_Model.On_Off.Type]()
      case _ => None[Isolette_Data_Model.On_Off.Type]()
    }
    return value
  }
}
