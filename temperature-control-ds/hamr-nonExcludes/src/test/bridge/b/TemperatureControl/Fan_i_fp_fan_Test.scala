package b.TemperatureControl

import art.{ArtNative_Ext, Empty}
import b._
import org.sireum._

// This file will not be overwritten so is safe to edit
class Fan_i_fp_fan_Test extends BridgeTestSuite[Fan_i_fp_fan_Bridge](Arch.TempControlSystem_i_Instance_fp_fan) {
  test("Example Unit Test"){
    executeTest()
  }

  //////////////////////
  // HELPER FUNCTIONS //
  //////////////////////

  // setter for in EventDataPort
  def put_fanCmd(value : TemperatureControl.FanCmd.Type): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.fanCmd_Id, TemperatureControl.FanCmd_Payload(value))
  }

  // getter for out EventDataPort
  def get_fanAck(): Option[TemperatureControl.FanAck.Type] = {
    val value: Option[TemperatureControl.FanAck.Type] = get_fanAck_payload() match {
      case Some(TemperatureControl.FanAck_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port fanAck.  Expecting 'TemperatureControl.FanAck_Payload' but received ${v}")
      case _ => None[TemperatureControl.FanAck.Type]()
    }
    return value
  }

  // payload getter for out EventDataPort
  def get_fanAck_payload(): Option[TemperatureControl.FanAck_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.fanAck_Id).asInstanceOf[Option[TemperatureControl.FanAck_Payload]]
  }

}
