// #Sireum

package isolette.Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_mat

import org.sireum._
import art._
import art.DispatchPropertyProtocol._
import art.PortMode._
import isolette._
import isolette.Monitor.Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_mat_seL4Nix

object mat extends App {

  val matBridge : isolette.Monitor.Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_mat_Bridge = {
    val current_tempWstatus = Port[Isolette_Data_Model.TempWstatus_impl] (id = 0, name = "isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_alarm_mat_current_tempWstatus", mode = DataIn)
    val lower_alarm_temp = Port[Isolette_Data_Model.Temp_impl] (id = 1, name = "isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_alarm_mat_lower_alarm_temp", mode = DataIn)
    val upper_alarm_temp = Port[Isolette_Data_Model.Temp_impl] (id = 2, name = "isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_alarm_mat_upper_alarm_temp", mode = DataIn)
    val monitor_mode = Port[Isolette_Data_Model.Monitor_Mode.Type] (id = 3, name = "isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_alarm_mat_monitor_mode", mode = DataIn)
    val alarm_control = Port[Isolette_Data_Model.On_Off.Type] (id = 4, name = "isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_alarm_mat_alarm_control", mode = DataOut)

    isolette.Monitor.Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_mat_Bridge(
      id = 0,
      name = "isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_alarm_mat",
      dispatchProtocol = Periodic(period = 1000),
      dispatchTriggers = None(),

      current_tempWstatus = current_tempWstatus,
      lower_alarm_temp = lower_alarm_temp,
      upper_alarm_temp = upper_alarm_temp,
      monitor_mode = monitor_mode,
      alarm_control = alarm_control
    )
  }

  val entryPoints: Bridge.EntryPoints = matBridge.entryPoints
  val noData: Option[DataContent] = None()

  // current_tempWstatus: In DataPort Isolette_Data_Model.TempWstatus_impl
  val current_tempWstatus_id: Art.PortId = matBridge.current_tempWstatus.id
  var current_tempWstatus_port: Option[DataContent] = noData

  // lower_alarm_temp: In DataPort Isolette_Data_Model.Temp_impl
  val lower_alarm_temp_id: Art.PortId = matBridge.lower_alarm_temp.id
  var lower_alarm_temp_port: Option[DataContent] = noData

  // upper_alarm_temp: In DataPort Isolette_Data_Model.Temp_impl
  val upper_alarm_temp_id: Art.PortId = matBridge.upper_alarm_temp.id
  var upper_alarm_temp_port: Option[DataContent] = noData

  // monitor_mode: In DataPort Isolette_Data_Model.Monitor_Mode
  val monitor_mode_id: Art.PortId = matBridge.monitor_mode.id
  var monitor_mode_port: Option[DataContent] = noData

  // alarm_control: Out DataPort Isolette_Data_Model.On_Off
  val alarm_control_id: Art.PortId = matBridge.alarm_control.id
  var alarm_control_port: Option[DataContent] = noData

  def dispatchStatus(bridgeId: Art.BridgeId): DispatchStatus = {
    return TimeTriggered()
  }

  def getValue(portId: Art.PortId): Option[DataContent] = {
    if(portId == current_tempWstatus_id) {
      return current_tempWstatus_port
    } else if(portId == lower_alarm_temp_id) {
      return lower_alarm_temp_port
    } else if(portId == upper_alarm_temp_id) {
      return upper_alarm_temp_port
    } else if(portId == monitor_mode_id) {
      return monitor_mode_port
    } else {
      halt(s"Unexpected: mat.getValue called with: ${portId}")
    }
  }

  def receiveInput(eventPortIds: ISZ[Art.PortId], dataPortIds: ISZ[Art.PortId]): Unit = {
    // ignore params

    current_tempWstatus_port = Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_mat_seL4Nix.current_tempWstatus_Receive()

    lower_alarm_temp_port = Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_mat_seL4Nix.lower_alarm_temp_Receive()

    upper_alarm_temp_port = Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_mat_seL4Nix.upper_alarm_temp_Receive()

    monitor_mode_port = Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_mat_seL4Nix.monitor_mode_Receive()
  }

  def putValue(portId: Art.PortId, data: DataContent): Unit = {
    if(portId == alarm_control_id) {
      alarm_control_port = Some(data)
    } else {
      halt(s"Unexpected: mat.putValue called with: ${portId}")
    }
  }

  def sendOutput(eventPortIds: ISZ[Art.PortId], dataPortIds: ISZ[Art.PortId]): Unit = {
    // ignore params

    if(alarm_control_port.nonEmpty) {
      Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_mat_seL4Nix.alarm_control_Send(alarm_control_port.get)
      alarm_control_port = noData
    }
  }

  def initialiseArchitecture(): Unit = {
    val ad = ArchitectureDescription(
      components = MSZ (matBridge),
      connections = ISZ ()
    )
    Art.run(ad)
  }

  def initialiseEntryPoint(): Unit = { entryPoints.initialise() }

  def computeEntryPoint(): Unit = { entryPoints.compute() }

  def finaliseEntryPoint(): Unit = { entryPoints.finalise() }

  def main(args: ISZ[String]): Z = {

    // need to touch the following for transpiler
    initialiseArchitecture()
    initialiseEntryPoint()
    computeEntryPoint()
    finaliseEntryPoint()

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

  def logInfo(title: String, msg: String): Unit = {
    print(title)
    print(": ")
    println(msg)
  }

  def logError(title: String, msg: String): Unit = {
    eprint(title)
    eprint(": ")
    eprintln(msg)
  }

  def logDebug(title: String, msg: String): Unit = {
    print(title)
    print(": ")
    println(msg)
  }

  def run(): Unit = {}

}
