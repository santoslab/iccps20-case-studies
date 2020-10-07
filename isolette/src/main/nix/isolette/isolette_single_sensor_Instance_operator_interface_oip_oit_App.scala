// #Sireum

package isolette

import org.sireum._
import art._

// This file was auto-generated.  Do not edit

object isolette_single_sensor_Instance_operator_interface_oip_oit_App extends App {

  val entryPoints: Bridge.EntryPoints = Arch.isolette_single_sensor_Instance_operator_interface_oip_oit.entryPoints
  val appPortId: Art.PortId = IPCPorts.isolette_single_sensor_Instance_operator_interface_oip_oit_App
  val appPortIdOpt: Option[Art.PortId] = Some(appPortId)
  val regulator_statusPortId: Art.PortId = Arch.isolette_single_sensor_Instance_operator_interface_oip_oit.regulator_status.id
  val regulator_statusPortIdOpt: Option[Art.PortId] = Some(regulator_statusPortId)
  val monitor_statusPortId: Art.PortId = Arch.isolette_single_sensor_Instance_operator_interface_oip_oit.monitor_status.id
  val monitor_statusPortIdOpt: Option[Art.PortId] = Some(monitor_statusPortId)
  val display_temperaturePortId: Art.PortId = Arch.isolette_single_sensor_Instance_operator_interface_oip_oit.display_temperature.id
  val display_temperaturePortIdOpt: Option[Art.PortId] = Some(display_temperaturePortId)
  val alarm_controlPortId: Art.PortId = Arch.isolette_single_sensor_Instance_operator_interface_oip_oit.alarm_control.id
  val alarm_controlPortIdOpt: Option[Art.PortId] = Some(alarm_controlPortId)

  def initialiseArchitecture(seed: Z): Unit = {
    Platform.initialise(seed, appPortIdOpt)
    Platform.initialise(seed, regulator_statusPortIdOpt)
    Platform.initialise(seed, monitor_statusPortIdOpt)
    Platform.initialise(seed, display_temperaturePortIdOpt)
    Platform.initialise(seed, alarm_controlPortIdOpt)

    Art.run(Arch.ad)
  }

  def initialise(): Unit = {
    entryPoints.initialise()
  }

  def compute(): Unit = {

    {
      val out = IPCPorts.emptyReceiveAsyncOut
      Platform.receiveAsync(regulator_statusPortIdOpt, out)
      out.value2 match {
        case Some(v: Isolette_Data_Model.Status_Payload) => ArtNix.updateData(regulator_statusPortId, v)
        case Some(v) => halt(s"Unexpected payload on port regulator_status.  Expecting something of type Isolette_Data_Model.Status_Payload but received ${v}")
        case None() => // do nothing
      }
    }
    {
      val out = IPCPorts.emptyReceiveAsyncOut
      Platform.receiveAsync(monitor_statusPortIdOpt, out)
      out.value2 match {
        case Some(v: Isolette_Data_Model.Status_Payload) => ArtNix.updateData(monitor_statusPortId, v)
        case Some(v) => halt(s"Unexpected payload on port monitor_status.  Expecting something of type Isolette_Data_Model.Status_Payload but received ${v}")
        case None() => // do nothing
      }
    }
    {
      val out = IPCPorts.emptyReceiveAsyncOut
      Platform.receiveAsync(display_temperaturePortIdOpt, out)
      out.value2 match {
        case Some(v: Isolette_Data_Model.Temp_impl_Payload) => ArtNix.updateData(display_temperaturePortId, v)
        case Some(v) => halt(s"Unexpected payload on port display_temperature.  Expecting something of type Isolette_Data_Model.Temp_impl_Payload but received ${v}")
        case None() => // do nothing
      }
    }
    {
      val out = IPCPorts.emptyReceiveAsyncOut
      Platform.receiveAsync(alarm_controlPortIdOpt, out)
      out.value2 match {
        case Some(v: Isolette_Data_Model.On_Off_Payload) => ArtNix.updateData(alarm_controlPortId, v)
        case Some(v) => halt(s"Unexpected payload on port alarm_control.  Expecting something of type Isolette_Data_Model.On_Off_Payload but received ${v}")
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

    println("isolette_single_sensor_Instance_operator_interface_oip_oit_App starting ...")

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