// #Sireum

package isolette.Monitor

import org.sireum._
import art._
import isolette._

@sig trait Manage_Monitor_Mode_impl_Api {
  def id: Art.BridgeId
  def current_tempWstatus_Id : Art.PortId
  def interface_failure_Id : Art.PortId
  def internal_failure_Id : Art.PortId
  def monitor_mode_Id : Art.PortId

  def setmonitor_mode(value : Isolette_Data_Model.Monitor_Mode.Type) : Unit = {
    Art.putValue(monitor_mode_Id, Isolette_Data_Model.Monitor_Mode_Payload(value))
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

@datatype class Manage_Monitor_Mode_impl_Initialization_Api (
  val id: Art.BridgeId,
  val current_tempWstatus_Id : Art.PortId,
  val interface_failure_Id : Art.PortId,
  val internal_failure_Id : Art.PortId,
  val monitor_mode_Id : Art.PortId) extends Manage_Monitor_Mode_impl_Api

@datatype class Manage_Monitor_Mode_impl_Operational_Api (
  val id: Art.BridgeId,
  val current_tempWstatus_Id : Art.PortId,
  val interface_failure_Id : Art.PortId,
  val internal_failure_Id : Art.PortId,
  val monitor_mode_Id : Art.PortId) extends Manage_Monitor_Mode_impl_Api {

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

  def getinterface_failure() : Option[Isolette_Data_Model.Failure_Flag_impl] = {
    val value : Option[Isolette_Data_Model.Failure_Flag_impl] = Art.getValue(interface_failure_Id) match {
      case Some(Isolette_Data_Model.Failure_Flag_impl_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port interface_failure.  Expecting 'Isolette_Data_Model.Failure_Flag_impl_Payload' but received ${v}")
        None[Isolette_Data_Model.Failure_Flag_impl]()
      case _ => None[Isolette_Data_Model.Failure_Flag_impl]()
    }
    return value
  }

  def getinternal_failure() : Option[Isolette_Data_Model.Failure_Flag_impl] = {
    val value : Option[Isolette_Data_Model.Failure_Flag_impl] = Art.getValue(internal_failure_Id) match {
      case Some(Isolette_Data_Model.Failure_Flag_impl_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port internal_failure.  Expecting 'Isolette_Data_Model.Failure_Flag_impl_Payload' but received ${v}")
        None[Isolette_Data_Model.Failure_Flag_impl]()
      case _ => None[Isolette_Data_Model.Failure_Flag_impl]()
    }
    return value
  }
}
