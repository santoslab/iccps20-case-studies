// #Sireum

package building_control_mixed.BuildingControl

import org.sireum._
import building_control_mixed._

// This file will not be overwritten so is safe to edit
object Fan_i_tcp_fan {

  def initialise(api: Fan_i_Initialization_Api): Unit = {
    api.sendfanAck(FanAck.Ok)
  }

  def handlefanCmd(api: Fan_i_Operational_Api, value : BuildingControl.FanCmd.Type): Unit = {
    api.logInfo(s"received fanCmd $value")

    val ack = FanNative.fanCmdActuate(value)

    api.sendfanAck(ack)

    api.logInfo(s"Actuation result: ${ack}")
  }

  def activate(api: Fan_i_Operational_Api): Unit = { }

  def deactivate(api: Fan_i_Operational_Api): Unit = { }

  def finalise(api: Fan_i_Operational_Api): Unit = { }

  def recover(api: Fan_i_Operational_Api): Unit = { }
}

@ext object FanNative {
  def fanCmdActuate(cmd: FanCmd.Type): FanAck.Type = $
}