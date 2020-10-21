// #Sireum

package b

import org.sireum._
import art._

// This file was auto-generated.  Do not edit

object IPCPorts {
  val TempSensor_i_tsp_tempSensor_App: Art.PortId = 9
  val TempControl_i_tcp_tempControl_App: Art.PortId = 10
  val Fan_i_fp_fan_App: Art.PortId = 11
  val Main: Art.PortId = 12

  def emptyReceiveOut: MBox2[Art.PortId, DataContent] = {
    return MBox2(-1, art.Empty())
  }

  def emptyReceiveAsyncOut: MBox2[Art.PortId, Option[DataContent]] = {
    return MBox2(-1, None())
  }
}
