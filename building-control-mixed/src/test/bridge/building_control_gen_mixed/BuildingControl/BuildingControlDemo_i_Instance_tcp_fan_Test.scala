package building_control_gen_mixed.BuildingControl

import art.{ArtNative_Ext, Empty}
import building_control_gen_mixed._
import org.sireum._

// This file will not be overwritten so is safe to edit
class BuildingControlDemo_i_Instance_tcp_fan_Test extends BridgeTestSuite[Fan_i_Bridge](Arch.BuildingControlDemo_i_Instance_tcp_fan) {
  test("'On' request should result in an acknowledgement"){
    put_fanCmd(BuildingControl.FanCmd.On)

    executeTest()

    val results = get_fanAck() match {
      case Some(BuildingControl.FanAck.Ok) => T
      case Some(BuildingControl.FanAck.Error) => T
      case None() => F
    }

    assert(results)
  }

  //////////////////////
  // HELPER FUNCTIONS //
  //////////////////////

  // setter for in EventDataPort
  def put_fanCmd(value : BuildingControl.FanCmd.Type): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.api.fanCmd_Id, BuildingControl.FanCmd_Payload(value))
  }

  // getter for out EventDataPort
  def get_fanAck(): Option[BuildingControl.FanAck.Type] = {
    val value: Option[BuildingControl.FanAck.Type] = get_fanAck_payload() match {
      case Some(BuildingControl.FanAck_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port fanAck.  Expecting 'BuildingControl.FanAck_Payload' but received ${v}")
      case _ => None[BuildingControl.FanAck.Type]()
    }
    return value
  }

  // payload getter for out EventDataPort
  def get_fanAck_payload(): Option[BuildingControl.FanAck_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.api.fanAck_Id).asInstanceOf[Option[BuildingControl.FanAck_Payload]]
  }
}
