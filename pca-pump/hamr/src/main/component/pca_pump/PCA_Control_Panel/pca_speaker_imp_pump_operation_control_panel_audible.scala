// #Sireum

package pca_pump.PCA_Control_Panel

import org.sireum._
import pca_pump._

// This file will not be overwritten so is safe to edit
object pca_speaker_imp_pump_operation_control_panel_audible {

  var lastSound: Option[PCA_Types.Sound.Type] = None[PCA_Types.Sound.Type]()

  def initialise(api: pca_speaker_imp_Initialization_Api): Unit = { }

  def timeTriggered(api: pca_speaker_imp_Operational_Api): Unit = {
    if(api.getAudioSignal() != lastSound) {
      lastSound = api.getAudioSignal()

      CP_Shared_Object.setSound(lastSound.get)
    }
  }

  def activate(api: pca_speaker_imp_Operational_Api): Unit = { }

  def deactivate(api: pca_speaker_imp_Operational_Api): Unit = { }

  def finalise(api: pca_speaker_imp_Operational_Api): Unit = { }

  def recover(api: pca_speaker_imp_Operational_Api): Unit = { }
}
