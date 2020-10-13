// #Sireum

package isolette.operator_interface_thread_impl_operator_interface_oip_oit

import org.sireum._
import art._
import art.DispatchPropertyProtocol._
import art.PortMode._
import isolette._
import isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit_seL4Nix

object oit extends App {

  val oitBridge : isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit_Bridge = {
    val regulator_status = Port[Isolette_Data_Model.Status.Type] (id = 0, name = "isolette_single_sensor_Instance_operator_interface_oip_oit_regulator_status", mode = DataIn)
    val monitor_status = Port[Isolette_Data_Model.Status.Type] (id = 1, name = "isolette_single_sensor_Instance_operator_interface_oip_oit_monitor_status", mode = DataIn)
    val display_temperature = Port[Isolette_Data_Model.Temp_impl] (id = 2, name = "isolette_single_sensor_Instance_operator_interface_oip_oit_display_temperature", mode = DataIn)
    val alarm_control = Port[Isolette_Data_Model.On_Off.Type] (id = 3, name = "isolette_single_sensor_Instance_operator_interface_oip_oit_alarm_control", mode = DataIn)
    val lower_desired_tempWstatus = Port[Isolette_Data_Model.TempWstatus_impl] (id = 4, name = "isolette_single_sensor_Instance_operator_interface_oip_oit_lower_desired_tempWstatus", mode = DataOut)
    val upper_desired_tempWstatus = Port[Isolette_Data_Model.TempWstatus_impl] (id = 5, name = "isolette_single_sensor_Instance_operator_interface_oip_oit_upper_desired_tempWstatus", mode = DataOut)
    val lower_alarm_tempWstatus = Port[Isolette_Data_Model.TempWstatus_impl] (id = 6, name = "isolette_single_sensor_Instance_operator_interface_oip_oit_lower_alarm_tempWstatus", mode = DataOut)
    val upper_alarm_tempWstatus = Port[Isolette_Data_Model.TempWstatus_impl] (id = 7, name = "isolette_single_sensor_Instance_operator_interface_oip_oit_upper_alarm_tempWstatus", mode = DataOut)

    isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit_Bridge(
      id = 0,
      name = "isolette_single_sensor_Instance_operator_interface_oip_oit",
      dispatchProtocol = Periodic(period = 1000),
      dispatchTriggers = None(),

      regulator_status = regulator_status,
      monitor_status = monitor_status,
      display_temperature = display_temperature,
      alarm_control = alarm_control,
      lower_desired_tempWstatus = lower_desired_tempWstatus,
      upper_desired_tempWstatus = upper_desired_tempWstatus,
      lower_alarm_tempWstatus = lower_alarm_tempWstatus,
      upper_alarm_tempWstatus = upper_alarm_tempWstatus
    )
  }

  val entryPoints: Bridge.EntryPoints = oitBridge.entryPoints
  val noData: Option[DataContent] = None()

  // regulator_status: In DataPort Isolette_Data_Model.Status
  val regulator_status_id: Art.PortId = oitBridge.regulator_status.id
  var regulator_status_port: Option[DataContent] = noData

  // monitor_status: In DataPort Isolette_Data_Model.Status
  val monitor_status_id: Art.PortId = oitBridge.monitor_status.id
  var monitor_status_port: Option[DataContent] = noData

  // display_temperature: In DataPort Isolette_Data_Model.Temp_impl
  val display_temperature_id: Art.PortId = oitBridge.display_temperature.id
  var display_temperature_port: Option[DataContent] = noData

  // alarm_control: In DataPort Isolette_Data_Model.On_Off
  val alarm_control_id: Art.PortId = oitBridge.alarm_control.id
  var alarm_control_port: Option[DataContent] = noData

  // lower_desired_tempWstatus: Out DataPort Isolette_Data_Model.TempWstatus_impl
  val lower_desired_tempWstatus_id: Art.PortId = oitBridge.lower_desired_tempWstatus.id
  var lower_desired_tempWstatus_port: Option[DataContent] = noData

  // upper_desired_tempWstatus: Out DataPort Isolette_Data_Model.TempWstatus_impl
  val upper_desired_tempWstatus_id: Art.PortId = oitBridge.upper_desired_tempWstatus.id
  var upper_desired_tempWstatus_port: Option[DataContent] = noData

  // lower_alarm_tempWstatus: Out DataPort Isolette_Data_Model.TempWstatus_impl
  val lower_alarm_tempWstatus_id: Art.PortId = oitBridge.lower_alarm_tempWstatus.id
  var lower_alarm_tempWstatus_port: Option[DataContent] = noData

  // upper_alarm_tempWstatus: Out DataPort Isolette_Data_Model.TempWstatus_impl
  val upper_alarm_tempWstatus_id: Art.PortId = oitBridge.upper_alarm_tempWstatus.id
  var upper_alarm_tempWstatus_port: Option[DataContent] = noData

  def dispatchStatus(bridgeId: Art.BridgeId): DispatchStatus = {
    return TimeTriggered()
  }

  def getValue(portId: Art.PortId): Option[DataContent] = {
    if(portId == regulator_status_id) {
      return regulator_status_port
    } else if(portId == monitor_status_id) {
      return monitor_status_port
    } else if(portId == display_temperature_id) {
      return display_temperature_port
    } else if(portId == alarm_control_id) {
      return alarm_control_port
    } else {
      halt(s"Unexpected: oit.getValue called with: ${portId}")
    }
  }

  def receiveInput(eventPortIds: ISZ[Art.PortId], dataPortIds: ISZ[Art.PortId]): Unit = {
    // ignore params

    regulator_status_port = operator_interface_thread_impl_operator_interface_oip_oit_seL4Nix.regulator_status_Receive()

    monitor_status_port = operator_interface_thread_impl_operator_interface_oip_oit_seL4Nix.monitor_status_Receive()

    display_temperature_port = operator_interface_thread_impl_operator_interface_oip_oit_seL4Nix.display_temperature_Receive()

    alarm_control_port = operator_interface_thread_impl_operator_interface_oip_oit_seL4Nix.alarm_control_Receive()
  }

  def putValue(portId: Art.PortId, data: DataContent): Unit = {
    if(portId == lower_desired_tempWstatus_id) {
      lower_desired_tempWstatus_port = Some(data)
    } else if(portId == upper_desired_tempWstatus_id) {
      upper_desired_tempWstatus_port = Some(data)
    } else if(portId == lower_alarm_tempWstatus_id) {
      lower_alarm_tempWstatus_port = Some(data)
    } else if(portId == upper_alarm_tempWstatus_id) {
      upper_alarm_tempWstatus_port = Some(data)
    } else {
      halt(s"Unexpected: oit.putValue called with: ${portId}")
    }
  }

  def sendOutput(eventPortIds: ISZ[Art.PortId], dataPortIds: ISZ[Art.PortId]): Unit = {
    // ignore params

    if(lower_desired_tempWstatus_port.nonEmpty) {
      operator_interface_thread_impl_operator_interface_oip_oit_seL4Nix.lower_desired_tempWstatus_Send(lower_desired_tempWstatus_port.get)
      lower_desired_tempWstatus_port = noData
    }

    if(upper_desired_tempWstatus_port.nonEmpty) {
      operator_interface_thread_impl_operator_interface_oip_oit_seL4Nix.upper_desired_tempWstatus_Send(upper_desired_tempWstatus_port.get)
      upper_desired_tempWstatus_port = noData
    }

    if(lower_alarm_tempWstatus_port.nonEmpty) {
      operator_interface_thread_impl_operator_interface_oip_oit_seL4Nix.lower_alarm_tempWstatus_Send(lower_alarm_tempWstatus_port.get)
      lower_alarm_tempWstatus_port = noData
    }

    if(upper_alarm_tempWstatus_port.nonEmpty) {
      operator_interface_thread_impl_operator_interface_oip_oit_seL4Nix.upper_alarm_tempWstatus_Send(upper_alarm_tempWstatus_port.get)
      upper_alarm_tempWstatus_port = noData
    }
  }

  def initialiseArchitecture(): Unit = {
    val ad = ArchitectureDescription(
      components = MSZ (oitBridge),
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
