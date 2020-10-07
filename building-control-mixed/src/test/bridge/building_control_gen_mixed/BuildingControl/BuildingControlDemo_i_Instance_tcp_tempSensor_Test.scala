package building_control_gen_mixed.BuildingControl

import art.{ArtNative_Ext, Empty}
import building_control_gen_mixed._
import org.sireum._

// This file will not be overwritten so is safe to edit
class BuildingControlDemo_i_Instance_tcp_tempSensor_Test extends BridgeTestSuite[TempSensor_i_Bridge](Arch.BuildingControlDemo_i_Instance_tcp_tempSensor) {
  test("Example Unit Test"){
    executeTest()
  }

  //////////////////////
  // HELPER FUNCTIONS //
  //////////////////////

  // getter for out DataPort
  def get_currentTemp(): Option[BuildingControl.Temperature_i] = {
    val value: Option[BuildingControl.Temperature_i] = get_currentTemp_payload() match {
      case Some(BuildingControl.Temperature_i_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port currentTemp.  Expecting 'BuildingControl.Temperature_i_Payload' but received ${v}")
      case _ => None[BuildingControl.Temperature_i]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_currentTemp_payload(): Option[BuildingControl.Temperature_i_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.api.currentTemp_Id).asInstanceOf[Option[BuildingControl.Temperature_i_Payload]]
  }

  // getter for out EventPort
  def get_tempChanged(): Option[art.Empty] = {
    val value: Option[art.Empty] = get_tempChanged_payload() match {
      case Some(Empty()) => Some(Empty())
      case Some(v) => fail(s"Unexpected payload on port tempChanged.  Expecting 'Empty' but received ${v}")
      case _ => None[art.Empty]()
    }
    return value
  }

  // payload getter for out EventPort
  def get_tempChanged_payload(): Option[Empty] = {
    return ArtNative_Ext.observeOutPortValue(bridge.api.tempChanged_Id).asInstanceOf[Option[Empty]]
  }
}
