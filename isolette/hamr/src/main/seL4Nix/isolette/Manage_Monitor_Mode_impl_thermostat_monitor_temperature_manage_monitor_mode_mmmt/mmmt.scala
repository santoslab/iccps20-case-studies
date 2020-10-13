// #Sireum

package isolette.Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_mmmt

import org.sireum._
import art._
import art.DispatchPropertyProtocol._
import art.PortMode._
import isolette._
import isolette.Monitor.Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_mmmt_seL4Nix

object mmmt extends App {

  val mmmtBridge : isolette.Monitor.Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_mmmt_Bridge = {
    val current_tempWstatus = Port[Isolette_Data_Model.TempWstatus_impl] (id = 0, name = "isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_mode_mmmt_current_tempWstatus", mode = DataIn)
    val interface_failure = Port[Isolette_Data_Model.Failure_Flag_impl] (id = 1, name = "isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_mode_mmmt_interface_failure", mode = DataIn)
    val internal_failure = Port[Isolette_Data_Model.Failure_Flag_impl] (id = 2, name = "isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_mode_mmmt_internal_failure", mode = DataIn)
    val monitor_mode = Port[Isolette_Data_Model.Monitor_Mode.Type] (id = 3, name = "isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_mode_mmmt_monitor_mode", mode = DataOut)

    isolette.Monitor.Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_mmmt_Bridge(
      id = 0,
      name = "isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_mode_mmmt",
      dispatchProtocol = Periodic(period = 1000),
      dispatchTriggers = None(),

      current_tempWstatus = current_tempWstatus,
      interface_failure = interface_failure,
      internal_failure = internal_failure,
      monitor_mode = monitor_mode
    )
  }

  val entryPoints: Bridge.EntryPoints = mmmtBridge.entryPoints
  val noData: Option[DataContent] = None()

  // current_tempWstatus: In DataPort Isolette_Data_Model.TempWstatus_impl
  val current_tempWstatus_id: Art.PortId = mmmtBridge.current_tempWstatus.id
  var current_tempWstatus_port: Option[DataContent] = noData

  // interface_failure: In DataPort Isolette_Data_Model.Failure_Flag_impl
  val interface_failure_id: Art.PortId = mmmtBridge.interface_failure.id
  var interface_failure_port: Option[DataContent] = noData

  // internal_failure: In DataPort Isolette_Data_Model.Failure_Flag_impl
  val internal_failure_id: Art.PortId = mmmtBridge.internal_failure.id
  var internal_failure_port: Option[DataContent] = noData

  // monitor_mode: Out DataPort Isolette_Data_Model.Monitor_Mode
  val monitor_mode_id: Art.PortId = mmmtBridge.monitor_mode.id
  var monitor_mode_port: Option[DataContent] = noData

  def dispatchStatus(bridgeId: Art.BridgeId): DispatchStatus = {
    return TimeTriggered()
  }

  def getValue(portId: Art.PortId): Option[DataContent] = {
    if(portId == current_tempWstatus_id) {
      return current_tempWstatus_port
    } else if(portId == interface_failure_id) {
      return interface_failure_port
    } else if(portId == internal_failure_id) {
      return internal_failure_port
    } else {
      halt(s"Unexpected: mmmt.getValue called with: ${portId}")
    }
  }

  def receiveInput(eventPortIds: ISZ[Art.PortId], dataPortIds: ISZ[Art.PortId]): Unit = {
    // ignore params

    current_tempWstatus_port = Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_mmmt_seL4Nix.current_tempWstatus_Receive()

    interface_failure_port = Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_mmmt_seL4Nix.interface_failure_Receive()

    internal_failure_port = Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_mmmt_seL4Nix.internal_failure_Receive()
  }

  def putValue(portId: Art.PortId, data: DataContent): Unit = {
    if(portId == monitor_mode_id) {
      monitor_mode_port = Some(data)
    } else {
      halt(s"Unexpected: mmmt.putValue called with: ${portId}")
    }
  }

  def sendOutput(eventPortIds: ISZ[Art.PortId], dataPortIds: ISZ[Art.PortId]): Unit = {
    // ignore params

    if(monitor_mode_port.nonEmpty) {
      Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_mmmt_seL4Nix.monitor_mode_Send(monitor_mode_port.get)
      monitor_mode_port = noData
    }
  }

  def initialiseArchitecture(): Unit = {
    val ad = ArchitectureDescription(
      components = MSZ (mmmtBridge),
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

      isolette.Monitor.Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_mmmt_Bridge.c_initialization_api.get.logInfo("")
      isolette.Monitor.Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_mmmt_Bridge.c_initialization_api.get.logDebug("")
      isolette.Monitor.Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_mmmt_Bridge.c_initialization_api.get.logError("")
      isolette.Monitor.Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_mmmt_Bridge.c_operational_api.get.logInfo("")
      isolette.Monitor.Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_mmmt_Bridge.c_operational_api.get.logDebug("")
      isolette.Monitor.Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_mmmt_Bridge.c_operational_api.get.logError("")
      val apiUsage_current_tempWstatus: Option[Isolette_Data_Model.TempWstatus_impl] = isolette.Monitor.Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_mmmt_Bridge.c_operational_api.get.getcurrent_tempWstatus()
      val apiUsage_interface_failure: Option[Isolette_Data_Model.Failure_Flag_impl] = isolette.Monitor.Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_mmmt_Bridge.c_operational_api.get.getinterface_failure()
      val apiUsage_internal_failure: Option[Isolette_Data_Model.Failure_Flag_impl] = isolette.Monitor.Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_mmmt_Bridge.c_operational_api.get.getinternal_failure()
      isolette.Monitor.Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_mmmt_Bridge.c_initialization_api.get.setmonitor_mode(Isolette_Data_Model.Monitor_Mode.byOrdinal(0).get)
      isolette.Monitor.Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_mmmt_Bridge.c_operational_api.get.setmonitor_mode(Isolette_Data_Model.Monitor_Mode.byOrdinal(0).get)
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
