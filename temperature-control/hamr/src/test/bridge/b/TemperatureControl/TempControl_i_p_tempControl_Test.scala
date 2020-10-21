package b.TemperatureControl

import art.{ArtNative_Ext, Empty}
import b._
import org.sireum._

// This file will not be overwritten so is safe to edit
class TempControl_i_p_tempControl_Test extends BridgeTestSuite[TempControl_i_p_tempControl_Bridge](Arch.TempControlSystem_i_Instance_p_tempControl) {
  test("Example Unit Test"){
    executeTest()
  }

  //////////////////////
  // HELPER FUNCTIONS //
  //////////////////////

  // setter for in DataPort
  def put_currentTemp(value : TemperatureControl.Temperature_i): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.currentTemp_Id, TemperatureControl.Temperature_i_Payload(value))
  }

  // setter for in EventDataPort
  def put_fanAck(value : TemperatureControl.FanAck.Type): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.fanAck_Id, TemperatureControl.FanAck_Payload(value))
  }

  // setter for in EventDataPort
  def put_setPoint(value : TemperatureControl.SetPoint_i): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.setPoint_Id, TemperatureControl.SetPoint_i_Payload(value))
  }

  // setter for in EventPort
  def put_tempChanged(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.tempChanged_Id, Empty())
  }

  // getter for out EventDataPort
  def get_fanCmd(): Option[TemperatureControl.FanCmd.Type] = {
    val value: Option[TemperatureControl.FanCmd.Type] = get_fanCmd_payload() match {
      case Some(TemperatureControl.FanCmd_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port fanCmd.  Expecting 'TemperatureControl.FanCmd_Payload' but received ${v}")
      case _ => None[TemperatureControl.FanCmd.Type]()
    }
    return value
  }

  // payload getter for out EventDataPort
  def get_fanCmd_payload(): Option[TemperatureControl.FanCmd_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.fanCmd_Id).asInstanceOf[Option[TemperatureControl.FanCmd_Payload]]
  }

}
