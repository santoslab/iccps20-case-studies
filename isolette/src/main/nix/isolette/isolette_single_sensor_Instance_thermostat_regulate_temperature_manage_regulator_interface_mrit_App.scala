// #Sireum

package isolette

import org.sireum._
import art._

// This file was auto-generated.  Do not edit

object isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit_App extends App {

  val entryPoints: Bridge.EntryPoints = Arch.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit.entryPoints
  val appPortId: Art.PortId = IPCPorts.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit_App
  val appPortIdOpt: Option[Art.PortId] = Some(appPortId)
  val current_tempWstatusPortId: Art.PortId = Arch.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit.current_tempWstatus.id
  val current_tempWstatusPortIdOpt: Option[Art.PortId] = Some(current_tempWstatusPortId)
  val lower_desired_tempWstatusPortId: Art.PortId = Arch.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit.lower_desired_tempWstatus.id
  val lower_desired_tempWstatusPortIdOpt: Option[Art.PortId] = Some(lower_desired_tempWstatusPortId)
  val upper_desired_tempWstatusPortId: Art.PortId = Arch.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit.upper_desired_tempWstatus.id
  val upper_desired_tempWstatusPortIdOpt: Option[Art.PortId] = Some(upper_desired_tempWstatusPortId)
  val regulator_modePortId: Art.PortId = Arch.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit.regulator_mode.id
  val regulator_modePortIdOpt: Option[Art.PortId] = Some(regulator_modePortId)

  def initialiseArchitecture(seed: Z): Unit = {
    Platform.initialise(seed, appPortIdOpt)
    Platform.initialise(seed, current_tempWstatusPortIdOpt)
    Platform.initialise(seed, lower_desired_tempWstatusPortIdOpt)
    Platform.initialise(seed, upper_desired_tempWstatusPortIdOpt)
    Platform.initialise(seed, regulator_modePortIdOpt)

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
      Platform.receiveAsync(lower_desired_tempWstatusPortIdOpt, out)
      out.value2 match {
        case Some(v: Isolette_Data_Model.TempWstatus_impl_Payload) => ArtNix.updateData(lower_desired_tempWstatusPortId, v)
        case Some(v) => halt(s"Unexpected payload on port lower_desired_tempWstatus.  Expecting something of type Isolette_Data_Model.TempWstatus_impl_Payload but received ${v}")
        case None() => // do nothing
      }
    }
    {
      val out = IPCPorts.emptyReceiveAsyncOut
      Platform.receiveAsync(upper_desired_tempWstatusPortIdOpt, out)
      out.value2 match {
        case Some(v: Isolette_Data_Model.TempWstatus_impl_Payload) => ArtNix.updateData(upper_desired_tempWstatusPortId, v)
        case Some(v) => halt(s"Unexpected payload on port upper_desired_tempWstatus.  Expecting something of type Isolette_Data_Model.TempWstatus_impl_Payload but received ${v}")
        case None() => // do nothing
      }
    }
    {
      val out = IPCPorts.emptyReceiveAsyncOut
      Platform.receiveAsync(regulator_modePortIdOpt, out)
      out.value2 match {
        case Some(v: Isolette_Data_Model.Regulator_Mode_Payload) => ArtNix.updateData(regulator_modePortId, v)
        case Some(v) => halt(s"Unexpected payload on port regulator_mode.  Expecting something of type Isolette_Data_Model.Regulator_Mode_Payload but received ${v}")
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

    println("isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit_App starting ...")

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