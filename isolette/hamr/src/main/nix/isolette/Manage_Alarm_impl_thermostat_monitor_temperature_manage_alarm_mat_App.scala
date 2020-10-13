// #Sireum

package isolette

import org.sireum._
import art._

// This file was auto-generated.  Do not edit

object Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_mat_App extends App {

  val entryPoints: Bridge.EntryPoints = Arch.isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_alarm_mat.entryPoints
  val appPortId: Art.PortId = IPCPorts.Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_mat_App
  val appPortIdOpt: Option[Art.PortId] = Some(appPortId)
  val current_tempWstatusPortId: Art.PortId = Arch.isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_alarm_mat.current_tempWstatus.id
  val current_tempWstatusPortIdOpt: Option[Art.PortId] = Some(current_tempWstatusPortId)
  val lower_alarm_tempPortId: Art.PortId = Arch.isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_alarm_mat.lower_alarm_temp.id
  val lower_alarm_tempPortIdOpt: Option[Art.PortId] = Some(lower_alarm_tempPortId)
  val upper_alarm_tempPortId: Art.PortId = Arch.isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_alarm_mat.upper_alarm_temp.id
  val upper_alarm_tempPortIdOpt: Option[Art.PortId] = Some(upper_alarm_tempPortId)
  val monitor_modePortId: Art.PortId = Arch.isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_alarm_mat.monitor_mode.id
  val monitor_modePortIdOpt: Option[Art.PortId] = Some(monitor_modePortId)

  def initialiseArchitecture(seed: Z): Unit = {
    Platform.initialise(seed, appPortIdOpt)
    Platform.initialise(seed, current_tempWstatusPortIdOpt)
    Platform.initialise(seed, lower_alarm_tempPortIdOpt)
    Platform.initialise(seed, upper_alarm_tempPortIdOpt)
    Platform.initialise(seed, monitor_modePortIdOpt)

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
      Platform.receiveAsync(lower_alarm_tempPortIdOpt, out)
      out.value2 match {
        case Some(v: Isolette_Data_Model.Temp_impl_Payload) => ArtNix.updateData(lower_alarm_tempPortId, v)
        case Some(v) => halt(s"Unexpected payload on port lower_alarm_temp.  Expecting something of type Isolette_Data_Model.Temp_impl_Payload but received ${v}")
        case None() => // do nothing
      }
    }
    {
      val out = IPCPorts.emptyReceiveAsyncOut
      Platform.receiveAsync(upper_alarm_tempPortIdOpt, out)
      out.value2 match {
        case Some(v: Isolette_Data_Model.Temp_impl_Payload) => ArtNix.updateData(upper_alarm_tempPortId, v)
        case Some(v) => halt(s"Unexpected payload on port upper_alarm_temp.  Expecting something of type Isolette_Data_Model.Temp_impl_Payload but received ${v}")
        case None() => // do nothing
      }
    }
    {
      val out = IPCPorts.emptyReceiveAsyncOut
      Platform.receiveAsync(monitor_modePortIdOpt, out)
      out.value2 match {
        case Some(v: Isolette_Data_Model.Monitor_Mode_Payload) => ArtNix.updateData(monitor_modePortId, v)
        case Some(v) => halt(s"Unexpected payload on port monitor_mode.  Expecting something of type Isolette_Data_Model.Monitor_Mode_Payload but received ${v}")
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

    println("Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_mat_App starting ...")

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

      isolette.Monitor.Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_mat_Bridge.c_initialization_api.get.logInfo("")
      isolette.Monitor.Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_mat_Bridge.c_initialization_api.get.logDebug("")
      isolette.Monitor.Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_mat_Bridge.c_initialization_api.get.logError("")
      isolette.Monitor.Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_mat_Bridge.c_operational_api.get.logInfo("")
      isolette.Monitor.Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_mat_Bridge.c_operational_api.get.logDebug("")
      isolette.Monitor.Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_mat_Bridge.c_operational_api.get.logError("")
      val apiUsage_current_tempWstatus: Option[Isolette_Data_Model.TempWstatus_impl] = isolette.Monitor.Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_mat_Bridge.c_operational_api.get.getcurrent_tempWstatus()
      val apiUsage_lower_alarm_temp: Option[Isolette_Data_Model.Temp_impl] = isolette.Monitor.Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_mat_Bridge.c_operational_api.get.getlower_alarm_temp()
      val apiUsage_upper_alarm_temp: Option[Isolette_Data_Model.Temp_impl] = isolette.Monitor.Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_mat_Bridge.c_operational_api.get.getupper_alarm_temp()
      val apiUsage_monitor_mode: Option[Isolette_Data_Model.Monitor_Mode.Type] = isolette.Monitor.Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_mat_Bridge.c_operational_api.get.getmonitor_mode()
      isolette.Monitor.Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_mat_Bridge.c_initialization_api.get.setalarm_control(Isolette_Data_Model.On_Off.byOrdinal(0).get)
      isolette.Monitor.Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_mat_Bridge.c_operational_api.get.setalarm_control(Isolette_Data_Model.On_Off.byOrdinal(0).get)
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