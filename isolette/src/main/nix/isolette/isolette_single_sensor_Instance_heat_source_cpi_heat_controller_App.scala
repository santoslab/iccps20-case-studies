// #Sireum

package isolette

import org.sireum._
import art._

// This file was auto-generated.  Do not edit

object isolette_single_sensor_Instance_heat_source_cpi_heat_controller_App extends App {

  val entryPoints: Bridge.EntryPoints = Arch.isolette_single_sensor_Instance_heat_source_cpi_heat_controller.entryPoints
  val appPortId: Art.PortId = IPCPorts.isolette_single_sensor_Instance_heat_source_cpi_heat_controller_App
  val appPortIdOpt: Option[Art.PortId] = Some(appPortId)
  val heat_controlPortId: Art.PortId = Arch.isolette_single_sensor_Instance_heat_source_cpi_heat_controller.heat_control.id
  val heat_controlPortIdOpt: Option[Art.PortId] = Some(heat_controlPortId)

  def initialiseArchitecture(seed: Z): Unit = {
    Platform.initialise(seed, appPortIdOpt)
    Platform.initialise(seed, heat_controlPortIdOpt)

    Art.run(Arch.ad)
  }

  def initialise(): Unit = {
    entryPoints.initialise()
  }

  def compute(): Unit = {

    {
      val out = IPCPorts.emptyReceiveAsyncOut
      Platform.receiveAsync(heat_controlPortIdOpt, out)
      out.value2 match {
        case Some(v: Isolette_Data_Model.On_Off_Payload) => ArtNix.updateData(heat_controlPortId, v)
        case Some(v) => halt(s"Unexpected payload on port heat_control.  Expecting something of type Isolette_Data_Model.On_Off_Payload but received ${v}")
        case None() => // do nothing
      }
    }
    entryPoints.compute()
    Process.sleep(1000)
  }

  def finalise(): Unit = {
    entryPoints.finalise()
  }

  def main(args: ISZ[String]): Z = {

    val seed: Z = if (args.size == z"1") {
      val n = Z(args(0)).get
      if (n == z"0") 1 else n
    } else {
      1
    }

    initialiseArchitecture(seed)

    Platform.receive(appPortIdOpt, IPCPorts.emptyReceiveOut) // pause after setting up component

    initialise()

    Platform.receive(appPortIdOpt, IPCPorts.emptyReceiveOut) // pause after component init

    println("isolette_single_sensor_Instance_heat_source_cpi_heat_controller_App starting ...")

    ArtNix.timeDispatch()

    var terminated = F
    while (!terminated) {
      val out = IPCPorts.emptyReceiveAsyncOut
      Platform.receiveAsync(appPortIdOpt, out)
      if (out.value2.isEmpty) {
        compute()
      } else {
        terminated = T
      }
    }
    exit()

    return 0
  }

  def exit(): Unit = {
    finalise()
    Platform.finalise()
  }

  override def atExit(): Unit = {
    exit()
  }
}