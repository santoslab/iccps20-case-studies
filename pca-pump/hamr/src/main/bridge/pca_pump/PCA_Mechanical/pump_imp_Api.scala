// #Sireum

package pca_pump.PCA_Mechanical

import org.sireum._
import art._
import pca_pump._

@sig trait pump_imp_Api {
  def id: Art.BridgeId
  def Drug_Intake_Id : Art.PortId
  def Rate_Id : Art.PortId
  def Drug_Outlet_Id : Art.PortId
  def Halt_Id : Art.PortId
  def Pump_Too_Hot_Id : Art.PortId

  def setDrug_Outlet(value : Physical_Types.Fluid_Flow_imp) : Unit = {
    Art.putValue(Drug_Outlet_Id, Physical_Types.Fluid_Flow_imp_Payload(value))
  }

  def sendPump_Too_Hot() : Unit = {
    Art.putValue(Pump_Too_Hot_Id, art.Empty())
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

@datatype class pump_imp_Initialization_Api (
  val id: Art.BridgeId,
  val Drug_Intake_Id : Art.PortId,
  val Rate_Id : Art.PortId,
  val Drug_Outlet_Id : Art.PortId,
  val Halt_Id : Art.PortId,
  val Pump_Too_Hot_Id : Art.PortId) extends pump_imp_Api

@datatype class pump_imp_Operational_Api (
  val id: Art.BridgeId,
  val Drug_Intake_Id : Art.PortId,
  val Rate_Id : Art.PortId,
  val Drug_Outlet_Id : Art.PortId,
  val Halt_Id : Art.PortId,
  val Pump_Too_Hot_Id : Art.PortId) extends pump_imp_Api {

  def getDrug_Intake() : Option[Physical_Types.Fluid_Flow_imp] = {
    val value : Option[Physical_Types.Fluid_Flow_imp] = Art.getValue(Drug_Intake_Id) match {
      case Some(Physical_Types.Fluid_Flow_imp_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Drug_Intake.  Expecting 'Physical_Types.Fluid_Flow_imp_Payload' but received ${v}")
        None[Physical_Types.Fluid_Flow_imp]()
      case _ => None[Physical_Types.Fluid_Flow_imp]()
    }
    return value
  }

  def getRate() : Option[PCA_Types.Flow_Rate_imp] = {
    val value : Option[PCA_Types.Flow_Rate_imp] = Art.getValue(Rate_Id) match {
      case Some(PCA_Types.Flow_Rate_imp_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Rate.  Expecting 'PCA_Types.Flow_Rate_imp_Payload' but received ${v}")
        None[PCA_Types.Flow_Rate_imp]()
      case _ => None[PCA_Types.Flow_Rate_imp]()
    }
    return value
  }

  def getHalt() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(Halt_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Halt.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }
}
