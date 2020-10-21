package b.TemperatureControl

import art.{ArtNative_Ext, Empty}
import b._
import org.sireum._

// This file will not be overwritten so is safe to edit
class TempSensor_i_p_tempSensor_Test extends BridgeTestSuite[TempSensor_i_p_tempSensor_Bridge](Arch.TempControlSystem_i_Instance_p_tempSensor) {
  test("Example Unit Test"){
    executeTest()
  }

  //////////////////////
  // HELPER FUNCTIONS //
  //////////////////////

  // getter for out DataPort
  def get_currentTemp(): Option[TemperatureControl.Temperature_i] = {
    val value: Option[TemperatureControl.Temperature_i] = get_currentTemp_payload() match {
      case Some(TemperatureControl.Temperature_i_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port currentTemp.  Expecting 'TemperatureControl.Temperature_i_Payload' but received ${v}")
      case _ => None[TemperatureControl.Temperature_i]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_currentTemp_payload(): Option[TemperatureControl.Temperature_i_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.currentTemp_Id).asInstanceOf[Option[TemperatureControl.Temperature_i_Payload]]
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
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.tempChanged_Id).asInstanceOf[Option[Empty]]
  }

}
