// #Sireum

package isolette

import org.sireum._
import art._

// This file was auto-generated.  Do not edit

object isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_mode_mrmt_App extends App {

  val entryPoints: Bridge.EntryPoints = Arch.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_mode_mrmt.entryPoints
  val appPortId: Art.PortId = IPCPorts.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_mode_mrmt_App
  val appPortIdOpt: Option[Art.PortId] = Some(appPortId)
  val current_tempWstatusPortId: Art.PortId = Arch.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_mode_mrmt.current_tempWstatus.id
  val current_tempWstatusPortIdOpt: Option[Art.PortId] = Some(current_tempWstatusPortId)
  val interface_failurePortId: Art.PortId = Arch.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_mode_mrmt.interface_failure.id
  val interface_failurePortIdOpt: Option[Art.PortId] = Some(interface_failurePortId)
  val internal_failurePortId: Art.PortId = Arch.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_mode_mrmt.internal_failure.id
  val internal_failurePortIdOpt: Option[Art.PortId] = Some(internal_failurePortId)

  def initialiseArchitecture(seed: Z): Unit = {
    Platform.initialise(seed, appPortIdOpt)
    Platform.initialise(seed, current_tempWstatusPortIdOpt)
    Platform.initialise(seed, interface_failurePortIdOpt)
    Platform.initialise(seed, internal_failurePortIdOpt)

    Art.run(Arch.ad)
  }

  def initialise(): Unit = {
    entryPoints.initialise()
  }

  def compute(): Unit = {

    {
      val out = IPCPorts.emptyReceiveAsyncOut
      Platform.receiveAsync(current_tempWstatusPortIdOpt, out)
      out.value2 match {
        case Some(v: Isolette_Data_Model.TempWstatus_impl_Payload) => ArtNix.updateData(current_tempWstatusPortId, v)
        case Some(v) => halt(s"Unexpected payload on port current_tempWstatus.  Expecting something of type Isolette_Data_Model.TempWstatus_impl_Payload but received ${v}")
        case None() => // do nothing
      }
    }
    {
      val out = IPCPorts.emptyReceiveAsyncOut
      Platform.receiveAsync(interface_failurePortIdOpt, out)
      out.value2 match {
        case Some(v: Isolette_Data_Model.Failure_Flag_impl_Payload) => ArtNix.updateData(interface_failurePortId, v)
        case Some(v) => halt(s"Unexpected payload on port interface_failure.  Expecting something of type Isolette_Data_Model.Failure_Flag_impl_Payload but received ${v}")
        case None() => // do nothing
      }
    }
    {
      val out = IPCPorts.emptyReceiveAsyncOut
      Platform.receiveAsync(internal_failurePortIdOpt, out)
      out.value2 match {
        case Some(v: Isolette_Data_Model.Failure_Flag_impl_Payload) => ArtNix.updateData(internal_failurePortId, v)
        case Some(v) => halt(s"Unexpected payload on port internal_failure.  Expecting something of type Isolette_Data_Model.Failure_Flag_impl_Payload but received ${v}")
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

    println("isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_mode_mrmt_App starting ...")

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