package building_control_gen_mixed.BuildingControl

import art.{ArtNative_Ext, Empty}
import building_control_gen_mixed._
import org.sireum._

// This file will not be overwritten so is safe to edit
class BuildingControlDemo_i_Instance_tcp_tempControl_Test extends BridgeTestSuite[TempControl_i_Bridge](Arch.BuildingControlDemo_i_Instance_tcp_tempControl) {
  val initialSetPoint = BuildingControl.BuildingControlDemo_i_Instance_tcp_tempControl.setPoint

  def reset(): Unit = {
    BuildingControl.BuildingControlDemo_i_Instance_tcp_tempControl.setPoint = initialSetPoint
  }

  test("105f should result in a 'On' command"){

    put_currentTemp(BuildingControl.Temperature_i(105f, TempUnit.Fahrenheit))
    put_tempChanged()

    executeTest()

    get_fanCmd() match {
      case Some(x) => assert(x == BuildingControl.FanCmd.On)

      case None() => assert(F)
    }

    reset()
  }

  test("70f and a low setPoint of 80f should result in an 'Off' command"){

    val desiredSetPoint = SetPoint_i(
      Temperature_i(80f, TempUnit.Fahrenheit),
      Temperature_i(100f, TempUnit.Fahrenheit))

    BuildingControl.BuildingControlDemo_i_Instance_tcp_tempControl.setPoint = desiredSetPoint

    put_currentTemp(BuildingControl.Temperature_i(70, TempUnit.Fahrenheit))
    put_tempChanged()

    executeTest()

    assert(BuildingControl.BuildingControlDemo_i_Instance_tcp_tempControl.setPoint == desiredSetPoint)

    get_fanCmd() match {
      case Some(x) => assert(x == BuildingControl.FanCmd.Off)

      case None() => assert(F)
    }

    reset()
  }

  test("Alt: 70f and a low setPoint of 80f should result in an 'Off' command"){

    val desiredSetPoint = SetPoint_i(
      Temperature_i(80f, TempUnit.Fahrenheit),
      Temperature_i(100f, TempUnit.Fahrenheit))

    put_setPoint(desiredSetPoint)

    put_currentTemp(BuildingControl.Temperature_i(70, TempUnit.Fahrenheit))
    put_tempChanged()

    executeTest()

    assert(BuildingControl.BuildingControlDemo_i_Instance_tcp_tempControl.setPoint == desiredSetPoint)

    get_fanCmd() match {
      case Some(x) => assert(x == BuildingControl.FanCmd.Off)

      case None() => assert(F)
    }

    reset()
  }

  test("Let's make sure reset works"){

    put_currentTemp(BuildingControl.Temperature_i(70, TempUnit.Fahrenheit))
    put_tempChanged()

    executeTest()

    assert(BuildingControl.BuildingControlDemo_i_Instance_tcp_tempControl.setPoint == initialSetPoint)

    get_fanCmd() match {
      case None() => assert(T)

      case _ => assert(F)
    }

    reset()
  }
  //////////////////////
  // HELPER FUNCTIONS //
  //////////////////////

  // setter for in DataPort
  def put_currentTemp(value : BuildingControl.Temperature_i): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.api.currentTemp_Id, BuildingControl.Temperature_i_Payload(value))
  }

  // setter for in EventDataPort
  def put_fanAck(value : BuildingControl.FanAck.Type): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.api.fanAck_Id, BuildingControl.FanAck_Payload(value))
  }

  // setter for in EventDataPort
  def put_setPoint(value : BuildingControl.SetPoint_i): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.api.setPoint_Id, BuildingControl.SetPoint_i_Payload(value))
  }

  // setter for in EventPort
  def put_tempChanged(): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.api.tempChanged_Id, Empty())
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
    return ArtNative_Ext.observeOutPortValue(bridge.api.fanCmd_Id).asInstanceOf[Option[BuildingControl.FanCmd_Payload]]
  }
}
