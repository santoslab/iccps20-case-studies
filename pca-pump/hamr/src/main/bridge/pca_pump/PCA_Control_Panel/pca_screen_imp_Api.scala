// #Sireum

package pca_pump.PCA_Control_Panel

import org.sireum._
import art._
import pca_pump._

@sig trait pca_screen_imp_Api {
  def id: Art.BridgeId
  def Image_Id : Art.PortId
  def LightToEye_Id : Art.PortId
  def Touch_Id : Art.PortId
  def Finger_Press_Id : Art.PortId

  def setLightToEye(value : Base_Types.Boolean) : Unit = {
    Art.putValue(LightToEye_Id, Base_Types.Boolean_Payload(value))
  }

  def sendTouch(value : PCA_Types.Touch) : Unit = {
    Art.putValue(Touch_Id, PCA_Types.Touch_Payload(value))
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

@datatype class pca_screen_imp_Initialization_Api (
  val id: Art.BridgeId,
  val Image_Id : Art.PortId,
  val LightToEye_Id : Art.PortId,
  val Touch_Id : Art.PortId,
  val Finger_Press_Id : Art.PortId) extends pca_screen_imp_Api

@datatype class pca_screen_imp_Operational_Api (
  val id: Art.BridgeId,
  val Image_Id : Art.PortId,
  val LightToEye_Id : Art.PortId,
  val Touch_Id : Art.PortId,
  val Finger_Press_Id : Art.PortId) extends pca_screen_imp_Api {

  def getImage() : Option[PCA_Types.Image] = {
    val value : Option[PCA_Types.Image] = Art.getValue(Image_Id) match {
      case Some(PCA_Types.Image_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Image.  Expecting 'PCA_Types.Image_Payload' but received ${v}")
        None[PCA_Types.Image]()
      case _ => None[PCA_Types.Image]()
    }
    return value
  }

  def getFinger_Press() : Option[Base_Types.Boolean] = {
    val value : Option[Base_Types.Boolean] = Art.getValue(Finger_Press_Id) match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Finger_Press.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
        None[Base_Types.Boolean]()
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }
}
