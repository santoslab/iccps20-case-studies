// #Sireum

package isolette.Devices

import org.sireum._
import art._
import isolette._

@sig trait Temperature_Sensor_impl_Api {
  def id: Art.BridgeId
  def air_Id : Art.PortId
  def current_tempWstatus_Id : Art.PortId

  def setcurrent_tempWstatus(value : Isolette_Data_Model.TempWstatus_impl) : Unit = {
    Art.putValue(current_tempWstatus_Id, Isolette_Data_Model.TempWstatus_impl_Payload(value))
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

@datatype class Temperature_Sensor_impl_Initialization_Api (
  val id: Art.BridgeId,
  val air_Id : Art.PortId,
  val current_tempWstatus_Id : Art.PortId) extends Temperature_Sensor_impl_Api

@datatype class Temperature_Sensor_impl_Operational_Api (
  val id: Art.BridgeId,
  val air_Id : Art.PortId,
  val current_tempWstatus_Id : Art.PortId) extends Temperature_Sensor_impl_Api {

  def getair() : Option[Isolette_Data_Model.PhysicalTemp_impl] = {
    val value : Option[Isolette_Data_Model.PhysicalTemp_impl] = Art.getValue(air_Id) match {
      case Some(Isolette_Data_Model.PhysicalTemp_impl_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port air.  Expecting 'Isolette_Data_Model.PhysicalTemp_impl_Payload' but received ${v}")
        None[Isolette_Data_Model.PhysicalTemp_impl]()
      case _ => None[Isolette_Data_Model.PhysicalTemp_impl]()
    }
    return value
  }
}
