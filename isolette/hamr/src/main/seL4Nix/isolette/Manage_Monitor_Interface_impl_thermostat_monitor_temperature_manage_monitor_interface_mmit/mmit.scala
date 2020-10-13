// #Sireum

package isolette.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_mmit

import org.sireum._
import art._
import art.DispatchPropertyProtocol._
import art.PortMode._
import isolette._
import isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_mmit_seL4Nix

object mmit extends App {

  val mmitBridge : isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_mmit_Bridge = {
    val upper_alarm_tempWstatus = Port[Isolette_Data_Model.TempWstatus_impl] (id = 0, name = "isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_interface_mmit_upper_alarm_tempWstatus", mode = DataIn)
    val lower_alarm_tempWstatus = Port[Isolette_Data_Model.TempWstatus_impl] (id = 1, name = "isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_interface_mmit_lower_alarm_tempWstatus", mode = DataIn)
    val current_tempWstatus = Port[Isolette_Data_Model.TempWstatus_impl] (id = 2, name = "isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_interface_mmit_current_tempWstatus", mode = DataIn)
    val monitor_mode = Port[Isolette_Data_Model.Monitor_Mode.Type] (id = 3, name = "isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_interface_mmit_monitor_mode", mode = DataIn)
    val upper_alarm_temp = Port[Isolette_Data_Model.Temp_impl] (id = 4, name = "isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_interface_mmit_upper_alarm_temp", mode = DataOut)
    val lower_alarm_temp = Port[Isolette_Data_Model.Temp_impl] (id = 5, name = "isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_interface_mmit_lower_alarm_temp", mode = DataOut)
    val monitor_status = Port[Isolette_Data_Model.Status.Type] (id = 6, name = "isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_interface_mmit_monitor_status", mode = DataOut)
    val interface_failure = Port[Isolette_Data_Model.Failure_Flag_impl] (id = 7, name = "isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_interface_mmit_interface_failure", mode = DataOut)

    isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_mmit_Bridge(
      id = 0,
      name = "isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_interface_mmit",
      dispatchProtocol = Periodic(period = 1000),
      dispatchTriggers = None(),

      upper_alarm_tempWstatus = upper_alarm_tempWstatus,
      lower_alarm_tempWstatus = lower_alarm_tempWstatus,
      current_tempWstatus = current_tempWstatus,
      monitor_mode = monitor_mode,
      upper_alarm_temp = upper_alarm_temp,
      lower_alarm_temp = lower_alarm_temp,
      monitor_status = monitor_status,
      interface_failure = interface_failure
    )
  }

  val entryPoints: Bridge.EntryPoints = mmitBridge.entryPoints
  val noData: Option[DataContent] = None()

  // upper_alarm_tempWstatus: In DataPort Isolette_Data_Model.TempWstatus_impl
  val upper_alarm_tempWstatus_id: Art.PortId = mmitBridge.upper_alarm_tempWstatus.id
  var upper_alarm_tempWstatus_port: Option[DataContent] = noData

  // lower_alarm_tempWstatus: In DataPort Isolette_Data_Model.TempWstatus_impl
  val lower_alarm_tempWstatus_id: Art.PortId = mmitBridge.lower_alarm_tempWstatus.id
  var lower_alarm_tempWstatus_port: Option[DataContent] = noData

  // current_tempWstatus: In DataPort Isolette_Data_Model.TempWstatus_impl
  val current_tempWstatus_id: Art.PortId = mmitBridge.current_tempWstatus.id
  var current_tempWstatus_port: Option[DataContent] = noData

  // monitor_mode: In DataPort Isolette_Data_Model.Monitor_Mode
  val monitor_mode_id: Art.PortId = mmitBridge.monitor_mode.id
  var monitor_mode_port: Option[DataContent] = noData

  // upper_alarm_temp: Out DataPort Isolette_Data_Model.Temp_impl
  val upper_alarm_temp_id: Art.PortId = mmitBridge.upper_alarm_temp.id
  var upper_alarm_temp_port: Option[DataContent] = noData

  // lower_alarm_temp: Out DataPort Isolette_Data_Model.Temp_impl
  val lower_alarm_temp_id: Art.PortId = mmitBridge.lower_alarm_temp.id
  var lower_alarm_temp_port: Option[DataContent] = noData

  // monitor_status: Out DataPort Isolette_Data_Model.Status
  val monitor_status_id: Art.PortId = mmitBridge.monitor_status.id
  var monitor_status_port: Option[DataContent] = noData

  // interface_failure: Out DataPort Isolette_Data_Model.Failure_Flag_impl
  val interface_failure_id: Art.PortId = mmitBridge.interface_failure.id
  var interface_failure_port: Option[DataContent] = noData

  def dispatchStatus(bridgeId: Art.BridgeId): DispatchStatus = {
    return TimeTriggered()
  }

  def getValue(portId: Art.PortId): Option[DataContent] = {
    if(portId == upper_alarm_tempWstatus_id) {
      return upper_alarm_tempWstatus_port
    } else if(portId == lower_alarm_tempWstatus_id) {
      return lower_alarm_tempWstatus_port
    } else if(portId == current_tempWstatus_id) {
      return current_tempWstatus_port
    } else if(portId == monitor_mode_id) {
      return monitor_mode_port
    } else {
      halt(s"Unexpected: mmit.getValue called with: ${portId}")
    }
  }

  def receiveInput(eventPortIds: ISZ[Art.PortId], dataPortIds: ISZ[Art.PortId]): Unit = {
    // ignore params

    upper_alarm_tempWstatus_port = Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_mmit_seL4Nix.upper_alarm_tempWstatus_Receive()

    lower_alarm_tempWstatus_port = Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_mmit_seL4Nix.lower_alarm_tempWstatus_Receive()

    current_tempWstatus_port = Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_mmit_seL4Nix.current_tempWstatus_Receive()

    monitor_mode_port = Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_mmit_seL4Nix.monitor_mode_Receive()
  }

  def putValue(portId: Art.PortId, data: DataContent): Unit = {
    if(portId == upper_alarm_temp_id) {
      upper_alarm_temp_port = Some(data)
    } else if(portId == lower_alarm_temp_id) {
      lower_alarm_temp_port = Some(data)
    } else if(portId == monitor_status_id) {
      monitor_status_port = Some(data)
    } else if(portId == interface_failure_id) {
      interface_failure_port = Some(data)
    } else {
      halt(s"Unexpected: mmit.putValue called with: ${portId}")
    }
  }

  def sendOutput(eventPortIds: ISZ[Art.PortId], dataPortIds: ISZ[Art.PortId]): Unit = {
    // ignore params

    if(upper_alarm_temp_port.nonEmpty) {
      Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_mmit_seL4Nix.upper_alarm_temp_Send(upper_alarm_temp_port.get)
      upper_alarm_temp_port = noData
    }

    if(lower_alarm_temp_port.nonEmpty) {
      Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_mmit_seL4Nix.lower_alarm_temp_Send(lower_alarm_temp_port.get)
      lower_alarm_temp_port = noData
    }

    if(monitor_status_port.nonEmpty) {
      Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_mmit_seL4Nix.monitor_status_Send(monitor_status_port.get)
      monitor_status_port = noData
    }

    if(interface_failure_port.nonEmpty) {
      Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_mmit_seL4Nix.interface_failure_Send(interface_failure_port.get)
      interface_failure_port = noData
    }
  }

  def initialiseArchitecture(): Unit = {
    val ad = ArchitectureDescription(
      components = MSZ (mmitBridge),
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

      isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_mmit_Bridge.c_initialization_api.get.logInfo("")
      isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_mmit_Bridge.c_initialization_api.get.logDebug("")
      isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_mmit_Bridge.c_initialization_api.get.logError("")
      isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_mmit_Bridge.c_operational_api.get.logInfo("")
      isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_mmit_Bridge.c_operational_api.get.logDebug("")
      isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_mmit_Bridge.c_operational_api.get.logError("")
      val apiUsage_upper_alarm_tempWstatus: Option[Isolette_Data_Model.TempWstatus_impl] = isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_mmit_Bridge.c_operational_api.get.getupper_alarm_tempWstatus()
      val apiUsage_lower_alarm_tempWstatus: Option[Isolette_Data_Model.TempWstatus_impl] = isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_mmit_Bridge.c_operational_api.get.getlower_alarm_tempWstatus()
      val apiUsage_current_tempWstatus: Option[Isolette_Data_Model.TempWstatus_impl] = isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_mmit_Bridge.c_operational_api.get.getcurrent_tempWstatus()
      val apiUsage_monitor_mode: Option[Isolette_Data_Model.Monitor_Mode.Type] = isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_mmit_Bridge.c_operational_api.get.getmonitor_mode()
      isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_mmit_Bridge.c_initialization_api.get.setupper_alarm_temp(Isolette_Data_Model.Temp_impl.empty())
      isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_mmit_Bridge.c_operational_api.get.setupper_alarm_temp(Isolette_Data_Model.Temp_impl.empty())
      isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_mmit_Bridge.c_initialization_api.get.setlower_alarm_temp(Isolette_Data_Model.Temp_impl.empty())
      isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_mmit_Bridge.c_operational_api.get.setlower_alarm_temp(Isolette_Data_Model.Temp_impl.empty())
      isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_mmit_Bridge.c_initialization_api.get.setmonitor_status(Isolette_Data_Model.Status.byOrdinal(0).get)
      isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_mmit_Bridge.c_operational_api.get.setmonitor_status(Isolette_Data_Model.Status.byOrdinal(0).get)
      isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_mmit_Bridge.c_initialization_api.get.setinterface_failure(Isolette_Data_Model.Failure_Flag_impl.empty())
      isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_mmit_Bridge.c_operational_api.get.setinterface_failure(Isolette_Data_Model.Failure_Flag_impl.empty())
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
