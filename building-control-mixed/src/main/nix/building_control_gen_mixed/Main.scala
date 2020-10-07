// #Sireum

package building_control_gen_mixed

import org.sireum._
import art._

// This file was auto-generated.  Do not edit

object Main extends App {
  def main(args: ISZ[String]): Z = {

    val seed: Z = if (args.size == z"1") {
      val n = Z(args(0)).get
      if (n == z"0") 1 else n
    } else {
      1
    }

    Platform.initialise(seed, None())

    val empty = art.Empty()

    Platform.sendAsync(IPCPorts.BuildingControlDemo_i_Instance_tcp_tempSensor_App, IPCPorts.BuildingControlDemo_i_Instance_tcp_tempSensor_App, empty)
    Platform.sendAsync(IPCPorts.BuildingControlDemo_i_Instance_tcp_tempControl_App, IPCPorts.BuildingControlDemo_i_Instance_tcp_tempControl_App, empty)
    Platform.sendAsync(IPCPorts.BuildingControlDemo_i_Instance_tcp_fan_App, IPCPorts.BuildingControlDemo_i_Instance_tcp_fan_App, empty)

    Platform.finalise()
    return 0
  }
}
