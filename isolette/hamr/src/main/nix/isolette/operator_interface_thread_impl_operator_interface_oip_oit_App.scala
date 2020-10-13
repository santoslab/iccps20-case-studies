// #Sireum

package isolette

import org.sireum._
import art._

// This file was auto-generated.  Do not edit

object operator_interface_thread_impl_operator_interface_oip_oit_App extends App {

  val entryPoints: Bridge.EntryPoints = Arch.isolette_single_sensor_Instance_operator_interface_oip_oit.entryPoints
  val appPortId: Art.PortId = IPCPorts.operator_interface_thread_impl_operator_interface_oip_oit_App
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

    println("operator_interface_thread_impl_operator_interface_oip_oit_App starting ...")

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

    touch()

    return 0
  }

  def touch(): Unit = {
    if(F) {
      TranspilerToucher.touch()

      // touch each payload/type in case some are only used as a field in a record
      def printDataContent(a: art.DataContent): Unit = { println(s"${a}") }

      printDataContent(Isolette_Environment.Heat_Payload(Isolette_Environment.Heat.byOrdinal(0).get))
      printDataContent(Isolette_Environment.Interface_Interaction_Payload(Isolette_Environment.Interface_Interaction.byOrdinal(0).get))
      printDataContent(Base_Types.Float_32_Payload(Base_Types.Float_32_empty()))
      printDataContent(Isolette_Data_Model.PhysicalTemp_impl_Payload(Isolette_Data_Model.PhysicalTemp_impl.empty()))
      printDataContent(Isolette_Data_Model.ValueStatus_Payload(Isolette_Data_Model.ValueStatus.byOrdinal(0).get))
      printDataContent(Isolette_Data_Model.TempWstatus_impl_Payload(Isolette_Data_Model.TempWstatus_impl.empty()))
      printDataContent(Isolette_Data_Model.On_Off_Payload(Isolette_Data_Model.On_Off.byOrdinal(0).get))
      printDataContent(Isolette_Data_Model.Status_Payload(Isolette_Data_Model.Status.byOrdinal(0).get))
      printDataContent(Isolette_Data_Model.Temp_impl_Payload(Isolette_Data_Model.Temp_impl.empty()))
      printDataContent(Isolette_Data_Model.Regulator_Mode_Payload(Isolette_Data_Model.Regulator_Mode.byOrdinal(0).get))
      printDataContent(Base_Types.Boolean_Payload(Base_Types.Boolean_empty()))
      printDataContent(Isolette_Data_Model.Failure_Flag_impl_Payload(Isolette_Data_Model.Failure_Flag_impl.empty()))
      printDataContent(Isolette_Data_Model.Monitor_Mode_Payload(Isolette_Data_Model.Monitor_Mode.byOrdinal(0).get))
      printDataContent(art.Empty())

      isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit_Bridge.c_initialization_api.get.logInfo("")
      isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit_Bridge.c_initialization_api.get.logDebug("")
      isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit_Bridge.c_initialization_api.get.logError("")
      isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit_Bridge.c_operational_api.get.logInfo("")
      isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit_Bridge.c_operational_api.get.logDebug("")
      isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit_Bridge.c_operational_api.get.logError("")
      val apiUsage_regulator_status: Option[Isolette_Data_Model.Status.Type] = isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit_Bridge.c_operational_api.get.getregulator_status()
      val apiUsage_monitor_status: Option[Isolette_Data_Model.Status.Type] = isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit_Bridge.c_operational_api.get.getmonitor_status()
      val apiUsage_display_temperature: Option[Isolette_Data_Model.Temp_impl] = isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit_Bridge.c_operational_api.get.getdisplay_temperature()
      val apiUsage_alarm_control: Option[Isolette_Data_Model.On_Off.Type] = isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit_Bridge.c_operational_api.get.getalarm_control()
      isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit_Bridge.c_initialization_api.get.setlower_desired_tempWstatus(Isolette_Data_Model.TempWstatus_impl.empty())
      isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit_Bridge.c_operational_api.get.setlower_desired_tempWstatus(Isolette_Data_Model.TempWstatus_impl.empty())
      isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit_Bridge.c_initialization_api.get.setupper_desired_tempWstatus(Isolette_Data_Model.TempWstatus_impl.empty())
      isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit_Bridge.c_operational_api.get.setupper_desired_tempWstatus(Isolette_Data_Model.TempWstatus_impl.empty())
      isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit_Bridge.c_initialization_api.get.setlower_alarm_tempWstatus(Isolette_Data_Model.TempWstatus_impl.empty())
      isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit_Bridge.c_operational_api.get.setlower_alarm_tempWstatus(Isolette_Data_Model.TempWstatus_impl.empty())
      isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit_Bridge.c_initialization_api.get.setupper_alarm_tempWstatus(Isolette_Data_Model.TempWstatus_impl.empty())
      isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit_Bridge.c_operational_api.get.setupper_alarm_tempWstatus(Isolette_Data_Model.TempWstatus_impl.empty())
    }
  }

  def exit(): Unit = {
    finalise()
    Platform.finalise()
  }

  override def atExit(): Unit = {
    exit()
  }
}