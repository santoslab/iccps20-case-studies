package pca_pump.PCA_Control_Panel

import art.{ArtNative_Ext, Empty}
import pca_pump._
import org.sireum._

// This file will not be overwritten so is safe to edit
class pca_screen_imp_pump_operation_control_panel_display_Test extends BridgeTestSuite[pca_screen_imp_pump_operation_control_panel_display_Bridge](Arch.wrap_pca_imp_Instance_pump_operation_control_panel_display) {
  test("Example Unit Test"){
    executeTest()
  }

  //////////////////////
  // HELPER FUNCTIONS //
  //////////////////////

  // setter for in DataPort
  def put_Image(value : PCA_Types.Image): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Image_Id, PCA_Types.Image_Payload(value))
  }

  // setter for in EventDataPort
  def put_Finger_Press(value : Base_Types.Boolean): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.Finger_Press_Id, Base_Types.Boolean_Payload(value))
  }

  // getter for out DataPort
  def get_LightToEye(): Option[Base_Types.Boolean] = {
    val value: Option[Base_Types.Boolean] = get_LightToEye_payload() match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port LightToEye.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_LightToEye_payload(): Option[Base_Types.Boolean_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.LightToEye_Id).asInstanceOf[Option[Base_Types.Boolean_Payload]]
  }

  // getter for out EventDataPort
  def get_Touch(): Option[PCA_Types.Touch] = {
    val value: Option[PCA_Types.Touch] = get_Touch_payload() match {
      case Some(PCA_Types.Touch_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port Touch.  Expecting 'PCA_Types.Touch_Payload' but received ${v}")
      case _ => None[PCA_Types.Touch]()
    }
    return value
  }

  // payload getter for out EventDataPort
  def get_Touch_payload(): Option[PCA_Types.Touch_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.Touch_Id).asInstanceOf[Option[PCA_Types.Touch_Payload]]
  }

}
