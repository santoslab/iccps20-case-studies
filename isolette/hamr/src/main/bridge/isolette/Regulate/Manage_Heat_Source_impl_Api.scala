// #Sireum

package isolette.Regulate

import org.sireum._
import art._
import isolette._

@sig trait Manage_Heat_Source_impl_Api {
  def id: Art.BridgeId
  def current_tempWstatus_Id : Art.PortId
  def lower_desired_temp_Id : Art.PortId
  def upper_desired_temp_Id : Art.PortId
  def regulator_mode_Id : Art.PortId
  def heat_control_Id : Art.PortId

  def setheat_control(value : Isolette_Data_Model.On_Off.Type) : Unit = {
    Art.putValue(heat_control_Id, Isolette_Data_Model.On_Off_Payload(value))
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

@datatype class Manage_Heat_Source_impl_Initialization_Api (
  val id: Art.BridgeId,
  val current_tempWstatus_Id : Art.PortId,
  val lower_desired_temp_Id : Art.PortId,
  val upper_desired_temp_Id : Art.PortId,
  val regulator_mode_Id : Art.PortId,
  val heat_control_Id : Art.PortId) extends Manage_Heat_Source_impl_Api

@datatype class Manage_Heat_Source_impl_Operational_Api (
  val id: Art.BridgeId,
  val current_tempWstatus_Id : Art.PortId,
  val lower_desired_temp_Id : Art.PortId,
  val upper_desired_temp_Id : Art.PortId,
  val regulator_mode_Id : Art.PortId,
  val heat_control_Id : Art.PortId) extends Manage_Heat_Source_impl_Api {

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

  def getlower_desired_temp() : Option[Isolette_Data_Model.Temp_impl] = {
    val value : Option[Isolette_Data_Model.Temp_impl] = Art.getValue(lower_desired_temp_Id) match {
      case Some(Isolette_Data_Model.Temp_impl_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port lower_desired_temp.  Expecting 'Isolette_Data_Model.Temp_impl_Payload' but received ${v}")
        None[Isolette_Data_Model.Temp_impl]()
      case _ => None[Isolette_Data_Model.Temp_impl]()
    }
    return value
  }

  def getupper_desired_temp() : Option[Isolette_Data_Model.Temp_impl] = {
    val value : Option[Isolette_Data_Model.Temp_impl] = Art.getValue(upper_desired_temp_Id) match {
      case Some(Isolette_Data_Model.Temp_impl_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port upper_desired_temp.  Expecting 'Isolette_Data_Model.Temp_impl_Payload' but received ${v}")
        None[Isolette_Data_Model.Temp_impl]()
      case _ => None[Isolette_Data_Model.Temp_impl]()
    }
    return value
  }

  def getregulator_mode() : Option[Isolette_Data_Model.Regulator_Mode.Type] = {
    val value : Option[Isolette_Data_Model.Regulator_Mode.Type] = Art.getValue(regulator_mode_Id) match {
      case Some(Isolette_Data_Model.Regulator_Mode_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port regulator_mode.  Expecting 'Isolette_Data_Model.Regulator_Mode_Payload' but received ${v}")
        None[Isolette_Data_Model.Regulator_Mode.Type]()
      case _ => None[Isolette_Data_Model.Regulator_Mode.Type]()
    }
    return value
  }
}
