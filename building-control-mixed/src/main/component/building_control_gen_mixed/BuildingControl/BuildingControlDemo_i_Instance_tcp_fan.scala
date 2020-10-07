// #Sireum
package building_control_gen_mixed.BuildingControl

import org.sireum._
import building_control_gen_mixed._
import building_control_gen_mixed.BuildingControl

object BuildingControlDemo_i_Instance_tcp_fan {

  val api: Fan_i_Bridge.Api = Fan_i_Bridge.Api(
    id = Arch.BuildingControlDemo_i_Instance_tcp_fan.id,
    fanCmd_Id = Arch.BuildingControlDemo_i_Instance_tcp_fan.fanCmd.id,
    fanAck_Id = Arch.BuildingControlDemo_i_Instance_tcp_fan.fanAck.id)

  def handlefanCmd(value : BuildingControl.FanCmd.Type): Unit = {
    api.logInfo(s"received fanCmd $value")

    val ack = FanNative.fanCmdActuate(value)

    api.sendfanAck(ack)

    api.logInfo(s"Actuation result: ${ack}")
  }

  def activate(): Unit = {}

  def deactivate(): Unit = {}

  def finalise(): Unit = {}

  def initialise(): Unit = {}

  def recover(): Unit = {}
}

@ext object FanNative {
  def fanCmdActuate(cmd: FanCmd.Type): FanAck.Type = $
}