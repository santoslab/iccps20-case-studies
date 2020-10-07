// #Sireum

package pca_pump.PCA_Control_Panel

import org.sireum._
import art._
import pca_pump._

@sig trait pca_speaker_imp_Api {
  def id: Art.BridgeId
  def AudioSignal_Id : Art.PortId
  def Sound_Id : Art.PortId

  def setSound(value : PCA_Types.Sound.Type) : Unit = {
    Art.putValue(Sound_Id, PCA_Types.Sound_Payload(value))
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

@datatype class pca_speaker_imp_Initialization_Api (
  val id: Art.BridgeId,
  val AudioSignal_Id : Art.PortId,
  val Sound_Id : Art.PortId) extends pca_speaker_imp_Api

@datatype class pca_speaker_imp_Operational_Api (
  val id: Art.BridgeId,
  val AudioSignal_Id : Art.PortId,
  val Sound_Id : Art.PortId) extends pca_speaker_imp_Api {

  def getAudioSignal() : Option[PCA_Types.Sound.Type] = {
    val value : Option[PCA_Types.Sound.Type] = Art.getValue(AudioSignal_Id) match {
      case Some(PCA_Types.Sound_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port AudioSignal.  Expecting 'PCA_Types.Sound_Payload' but received ${v}")
        None[PCA_Types.Sound.Type]()
      case _ => None[PCA_Types.Sound.Type]()
    }
    return value
  }
}
