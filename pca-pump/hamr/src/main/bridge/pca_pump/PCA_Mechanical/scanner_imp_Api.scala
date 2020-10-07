// #Sireum

package pca_pump.PCA_Mechanical

import org.sireum._
import art._
import pca_pump._

@sig trait scanner_imp_Api {
  def id: Art.BridgeId
  def Scan_Data_Id : Art.PortId
  def Do_Scan_Id : Art.PortId
  def Scan_Done_Id : Art.PortId

  def sendScan_Data(value : PCA_Types.Scan_Data_Type) : Unit = {
    Art.putValue(Scan_Data_Id, PCA_Types.Scan_Data_Type_Payload(value))
  }

  def sendScan_Done() : Unit = {
    Art.putValue(Scan_Done_Id, art.Empty())
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

@datatype class scanner_imp_Initialization_Api (
  val id: Art.BridgeId,
  val Scan_Data_Id : Art.PortId,
  val Do_Scan_Id : Art.PortId,
  val Scan_Done_Id : Art.PortId) extends scanner_imp_Api

@datatype class scanner_imp_Operational_Api (
  val id: Art.BridgeId,
  val Scan_Data_Id : Art.PortId,
  val Do_Scan_Id : Art.PortId,
  val Scan_Done_Id : Art.PortId) extends scanner_imp_Api {

  def getDo_Scan() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(Do_Scan_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Do_Scan.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }
}
