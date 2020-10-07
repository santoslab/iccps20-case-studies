package pca_pump.PCA_Control_Panel

import art.{ArtNative_Ext, Empty}
import pca_pump._
import org.sireum._

// This file will not be overwritten so is safe to edit
class pca_speaker_imp_pump_operation_control_panel_audible_Test extends BridgeTestSuite[pca_speaker_imp_pump_operation_control_panel_audible_Bridge](Arch.wrap_pca_imp_Instance_pump_operation_control_panel_audible) {
  test("Example Unit Test"){
    executeTest()
  }

  //////////////////////
  // HELPER FUNCTIONS //
  //////////////////////

  // setter for in DataPort
  def put_AudioSignal(value : PCA_Types.Sound.Type): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.AudioSignal_Id, PCA_Types.Sound_Payload(value))
  }

  // getter for out DataPort
  def get_Sound(): Option[PCA_Types.Sound.Type] = {
    val value: Option[PCA_Types.Sound.Type] = get_Sound_payload() match {
      case Some(PCA_Types.Sound_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port Sound.  Expecting 'PCA_Types.Sound_Payload' but received ${v}")
      case _ => None[PCA_Types.Sound.Type]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_Sound_payload(): Option[PCA_Types.Sound_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Sound_Id).asInstanceOf[Option[PCA_Types.Sound_Payload]]
  }

}
