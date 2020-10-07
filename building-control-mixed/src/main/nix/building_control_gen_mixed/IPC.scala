// #Sireum

package building_control_gen_mixed

import org.sireum._
import art._

// This file was auto-generated.  Do not edit

object IPCPorts {
  val BuildingControlDemo_i_Instance_tcp_tempSensor_App: Art.PortId = 9
  val BuildingControlDemo_i_Instance_tcp_tempControl_App: Art.PortId = 10
  val BuildingControlDemo_i_Instance_tcp_fan_App: Art.PortId = 11
  val Main: Art.PortId = 12

  def emptyReceiveOut: MBox2[Art.PortId, DataContent] = {
    return MBox2(-1, art.Empty())
  }

  def emptyReceiveAsyncOut: MBox2[Art.PortId, Option[DataContent]] = {
    return MBox2(-1, None())
  }
}
