package building_control_mixed.BuildingControl

import art.{ArtNative_Ext, Empty}
import building_control_mixed._
import org.sireum._

// This file will not be overwritten so is safe to edit
class TempControl_i_tcp_tempControl_Test extends BridgeTestSuite[TempControl_i_tcp_tempControl_Bridge](Arch.BuildingControlDemo_i_Instance_tcp_tempControl) {
  test("Example Unit Test"){
    executeTest()
  }

  //////////////////////
  // HELPER FUNCTIONS //
  //////////////////////

  // setter for in DataPort
  def put_currentTemp(value : BuildingControl.Temperature_i): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.currentTemp_Id, BuildingControl.Temperature_i_Payload(value))
  }

  // setter for in EventDataPort
  def put_fanAck(value : BuildingControl.FanAck.Type): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.fanAck_Id, BuildingControl.FanAck_Payload(value))
  }

  // setter for in EventDataPort
  def put_setPoint(value : BuildingControl.SetPoint_i): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.setPoint_Id, BuildingControl.SetPoint_i_Payload(value))
  }

  // setter for in EventPort
  def put_tempChanged(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.tempChanged_Id, Empty())
  }

  // getter for out EventDataPort
  def get_fanCmd(): Option[BuildingControl.FanCmd.Type] = {
    val value: Option[BuildingControl.FanCmd.Type] = get_fanCmd_payload() match {
      case Some(BuildingControl.FanCmd_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port fanCmd.  Expecting 'BuildingControl.FanCmd_Payload' but received ${v}")
      case _ => None[BuildingControl.FanCmd.Type]()
    }
    return value
  }

  // payload getter for out EventDataPort
  def get_fanCmd_payload(): Option[BuildingControl.FanCmd_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.fanCmd_Id).asInstanceOf[Option[BuildingControl.FanCmd_Payload]]
  }

}
