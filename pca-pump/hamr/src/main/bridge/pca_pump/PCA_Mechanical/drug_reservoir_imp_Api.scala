// #Sireum

package pca_pump.PCA_Mechanical

import org.sireum._
import art._
import pca_pump._

@sig trait drug_reservoir_imp_Api {
  def id: Art.BridgeId
  def Fill_Reservoir_Id : Art.PortId
  def Drug_Outlet_Id : Art.PortId
  def Door_Open_Id : Art.PortId
  def Door_Closed_Id : Art.PortId
  def Low_Reservoir_Id : Art.PortId
  def Empty_Reservoir_Id : Art.PortId

  def setDrug_Outlet(value : Physical_Types.Fluid_Flow_imp) : Unit = {
    Art.putValue(Drug_Outlet_Id, Physical_Types.Fluid_Flow_imp_Payload(value))
  }

  def setDoor_Open(value : Base_Types.Boolean) : Unit = {
    Art.putValue(Door_Open_Id, Base_Types.Boolean_Payload(value))
  }

  def sendDoor_Closed() : Unit = {
    Art.putValue(Door_Closed_Id, art.Empty())
  }

  def sendLow_Reservoir() : Unit = {
    Art.putValue(Low_Reservoir_Id, art.Empty())
  }

  def sendEmpty_Reservoir() : Unit = {
    Art.putValue(Empty_Reservoir_Id, art.Empty())
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

@datatype class drug_reservoir_imp_Initialization_Api (
  val id: Art.BridgeId,
  val Fill_Reservoir_Id : Art.PortId,
  val Drug_Outlet_Id : Art.PortId,
  val Door_Open_Id : Art.PortId,
  val Door_Closed_Id : Art.PortId,
  val Low_Reservoir_Id : Art.PortId,
  val Empty_Reservoir_Id : Art.PortId) extends drug_reservoir_imp_Api

@datatype class drug_reservoir_imp_Operational_Api (
  val id: Art.BridgeId,
  val Fill_Reservoir_Id : Art.PortId,
  val Drug_Outlet_Id : Art.PortId,
  val Door_Open_Id : Art.PortId,
  val Door_Closed_Id : Art.PortId,
  val Low_Reservoir_Id : Art.PortId,
  val Empty_Reservoir_Id : Art.PortId) extends drug_reservoir_imp_Api {

  def getFill_Reservoir() : Option[Physical_Types.Fluid_Volume_imp] = {
    val value : Option[Physical_Types.Fluid_Volume_imp] = Art.getValue(Fill_Reservoir_Id) match {
      case Some(Physical_Types.Fluid_Volume_imp_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Fill_Reservoir.  Expecting 'Physical_Types.Fluid_Volume_imp_Payload' but received ${v}")
        None[Physical_Types.Fluid_Volume_imp]()
      case _ => None[Physical_Types.Fluid_Volume_imp]()
    }
    return value
  }
}
