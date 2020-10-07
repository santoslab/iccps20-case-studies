// #Sireum

package pca_pump.PCA_Mechanical

import org.sireum._
import art._
import pca_pump._

@sig trait upstream_monitor_imp_Api {
  def id: Art.BridgeId
  def Drug_Intake_Id : Art.PortId
  def Drug_Outlet_Id : Art.PortId
  def Upstream_Flow_Rate_Id : Art.PortId
  def Occlusion_Id : Art.PortId

  def setDrug_Outlet(value : Physical_Types.Fluid_Flow_imp) : Unit = {
    Art.putValue(Drug_Outlet_Id, Physical_Types.Fluid_Flow_imp_Payload(value))
  }

  def setUpstream_Flow_Rate(value : PCA_Types.Flow_Rate_imp) : Unit = {
    Art.putValue(Upstream_Flow_Rate_Id, PCA_Types.Flow_Rate_imp_Payload(value))
  }

  def sendOcclusion() : Unit = {
    Art.putValue(Occlusion_Id, art.Empty())
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

@datatype class upstream_monitor_imp_Initialization_Api (
  val id: Art.BridgeId,
  val Drug_Intake_Id : Art.PortId,
  val Drug_Outlet_Id : Art.PortId,
  val Upstream_Flow_Rate_Id : Art.PortId,
  val Occlusion_Id : Art.PortId) extends upstream_monitor_imp_Api

@datatype class upstream_monitor_imp_Operational_Api (
  val id: Art.BridgeId,
  val Drug_Intake_Id : Art.PortId,
  val Drug_Outlet_Id : Art.PortId,
  val Upstream_Flow_Rate_Id : Art.PortId,
  val Occlusion_Id : Art.PortId) extends upstream_monitor_imp_Api {

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
}
