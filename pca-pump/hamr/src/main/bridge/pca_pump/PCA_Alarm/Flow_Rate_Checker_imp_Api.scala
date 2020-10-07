// #Sireum

package pca_pump.PCA_Alarm

import org.sireum._
import art._
import pca_pump._

@sig trait Flow_Rate_Checker_imp_Api {
  def id: Art.BridgeId
  def System_Status_Id : Art.PortId
  def Infusion_Flow_Rate_Id : Art.PortId
  def Upstream_Flow_Rate_Id : Art.PortId
  def Downstream_Flow_Rate_Id : Art.PortId
  def Basal_Overinfusion_Id : Art.PortId
  def Bolus_Overinfusion_Id : Art.PortId
  def Square_Bolus_Overinfusion_Id : Art.PortId
  def Basal_Underinfusion_Id : Art.PortId
  def Bolus_Underinfusion_Id : Art.PortId
  def Square_Bolus_Underinfusion_Id : Art.PortId

  def sendBasal_Overinfusion() : Unit = {
    Art.putValue(Basal_Overinfusion_Id, art.Empty())
  }

  def sendBolus_Overinfusion() : Unit = {
    Art.putValue(Bolus_Overinfusion_Id, art.Empty())
  }

  def sendSquare_Bolus_Overinfusion() : Unit = {
    Art.putValue(Square_Bolus_Overinfusion_Id, art.Empty())
  }

  def sendBasal_Underinfusion() : Unit = {
    Art.putValue(Basal_Underinfusion_Id, art.Empty())
  }

  def sendBolus_Underinfusion() : Unit = {
    Art.putValue(Bolus_Underinfusion_Id, art.Empty())
  }

  def sendSquare_Bolus_Underinfusion() : Unit = {
    Art.putValue(Square_Bolus_Underinfusion_Id, art.Empty())
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

@datatype class Flow_Rate_Checker_imp_Initialization_Api (
  val id: Art.BridgeId,
  val System_Status_Id : Art.PortId,
  val Infusion_Flow_Rate_Id : Art.PortId,
  val Upstream_Flow_Rate_Id : Art.PortId,
  val Downstream_Flow_Rate_Id : Art.PortId,
  val Basal_Overinfusion_Id : Art.PortId,
  val Bolus_Overinfusion_Id : Art.PortId,
  val Square_Bolus_Overinfusion_Id : Art.PortId,
  val Basal_Underinfusion_Id : Art.PortId,
  val Bolus_Underinfusion_Id : Art.PortId,
  val Square_Bolus_Underinfusion_Id : Art.PortId) extends Flow_Rate_Checker_imp_Api

@datatype class Flow_Rate_Checker_imp_Operational_Api (
  val id: Art.BridgeId,
  val System_Status_Id : Art.PortId,
  val Infusion_Flow_Rate_Id : Art.PortId,
  val Upstream_Flow_Rate_Id : Art.PortId,
  val Downstream_Flow_Rate_Id : Art.PortId,
  val Basal_Overinfusion_Id : Art.PortId,
  val Bolus_Overinfusion_Id : Art.PortId,
  val Square_Bolus_Overinfusion_Id : Art.PortId,
  val Basal_Underinfusion_Id : Art.PortId,
  val Bolus_Underinfusion_Id : Art.PortId,
  val Square_Bolus_Underinfusion_Id : Art.PortId) extends Flow_Rate_Checker_imp_Api {

  def getSystem_Status() : Option[PCA_Types.Status_Type.Type] = {
    val value : Option[PCA_Types.Status_Type.Type] = Art.getValue(System_Status_Id) match {
      case Some(PCA_Types.Status_Type_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port System_Status.  Expecting 'PCA_Types.Status_Type_Payload' but received ${v}")
        None[PCA_Types.Status_Type.Type]()
      case _ => None[PCA_Types.Status_Type.Type]()
    }
    return value
  }

  def getInfusion_Flow_Rate() : Option[PCA_Types.Flow_Rate_imp] = {
    val value : Option[PCA_Types.Flow_Rate_imp] = Art.getValue(Infusion_Flow_Rate_Id) match {
      case Some(PCA_Types.Flow_Rate_imp_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Infusion_Flow_Rate.  Expecting 'PCA_Types.Flow_Rate_imp_Payload' but received ${v}")
        None[PCA_Types.Flow_Rate_imp]()
      case _ => None[PCA_Types.Flow_Rate_imp]()
    }
    return value
  }

  def getUpstream_Flow_Rate() : Option[PCA_Types.Flow_Rate_imp] = {
    val value : Option[PCA_Types.Flow_Rate_imp] = Art.getValue(Upstream_Flow_Rate_Id) match {
      case Some(PCA_Types.Flow_Rate_imp_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Upstream_Flow_Rate.  Expecting 'PCA_Types.Flow_Rate_imp_Payload' but received ${v}")
        None[PCA_Types.Flow_Rate_imp]()
      case _ => None[PCA_Types.Flow_Rate_imp]()
    }
    return value
  }

  def getDownstream_Flow_Rate() : Option[PCA_Types.Flow_Rate_imp] = {
    val value : Option[PCA_Types.Flow_Rate_imp] = Art.getValue(Downstream_Flow_Rate_Id) match {
      case Some(PCA_Types.Flow_Rate_imp_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Downstream_Flow_Rate.  Expecting 'PCA_Types.Flow_Rate_imp_Payload' but received ${v}")
        None[PCA_Types.Flow_Rate_imp]()
      case _ => None[PCA_Types.Flow_Rate_imp]()
    }
    return value
  }
}
