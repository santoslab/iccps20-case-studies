// #Sireum

package isolette.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit

import org.sireum._
import art._
import art.DispatchPropertyProtocol._
import art.PortMode._
import isolette._
import isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_seL4Nix

object mrit extends App {

  val mritBridge : isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_Bridge = {
    val current_tempWstatus = Port[Isolette_Data_Model.TempWstatus_impl] (id = 0, name = "isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit_current_tempWstatus", mode = DataIn)
    val lower_desired_tempWstatus = Port[Isolette_Data_Model.TempWstatus_impl] (id = 1, name = "isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit_lower_desired_tempWstatus", mode = DataIn)
    val upper_desired_tempWstatus = Port[Isolette_Data_Model.TempWstatus_impl] (id = 2, name = "isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit_upper_desired_tempWstatus", mode = DataIn)
    val regulator_mode = Port[Isolette_Data_Model.Regulator_Mode.Type] (id = 3, name = "isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit_regulator_mode", mode = DataIn)
    val upper_desired_temp = Port[Isolette_Data_Model.Temp_impl] (id = 4, name = "isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit_upper_desired_temp", mode = DataOut)
    val lower_desired_temp = Port[Isolette_Data_Model.Temp_impl] (id = 5, name = "isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit_lower_desired_temp", mode = DataOut)
    val displayed_temp = Port[Isolette_Data_Model.Temp_impl] (id = 6, name = "isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit_displayed_temp", mode = DataOut)
    val regulator_status = Port[Isolette_Data_Model.Status.Type] (id = 7, name = "isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit_regulator_status", mode = DataOut)
    val interface_failure = Port[Isolette_Data_Model.Failure_Flag_impl] (id = 8, name = "isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit_interface_failure", mode = DataOut)

    isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_Bridge(
      id = 0,
      name = "isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit",
      dispatchProtocol = Periodic(period = 1000),
      dispatchTriggers = None(),

      current_tempWstatus = current_tempWstatus,
      lower_desired_tempWstatus = lower_desired_tempWstatus,
      upper_desired_tempWstatus = upper_desired_tempWstatus,
      regulator_mode = regulator_mode,
      upper_desired_temp = upper_desired_temp,
      lower_desired_temp = lower_desired_temp,
      displayed_temp = displayed_temp,
      regulator_status = regulator_status,
      interface_failure = interface_failure
    )
  }

  val entryPoints: Bridge.EntryPoints = mritBridge.entryPoints
  val noData: Option[DataContent] = None()

  // current_tempWstatus: In DataPort Isolette_Data_Model.TempWstatus_impl
  val current_tempWstatus_id: Art.PortId = mritBridge.current_tempWstatus.id
  var current_tempWstatus_port: Option[DataContent] = noData

  // lower_desired_tempWstatus: In DataPort Isolette_Data_Model.TempWstatus_impl
  val lower_desired_tempWstatus_id: Art.PortId = mritBridge.lower_desired_tempWstatus.id
  var lower_desired_tempWstatus_port: Option[DataContent] = noData

  // upper_desired_tempWstatus: In DataPort Isolette_Data_Model.TempWstatus_impl
  val upper_desired_tempWstatus_id: Art.PortId = mritBridge.upper_desired_tempWstatus.id
  var upper_desired_tempWstatus_port: Option[DataContent] = noData

  // regulator_mode: In DataPort Isolette_Data_Model.Regulator_Mode
  val regulator_mode_id: Art.PortId = mritBridge.regulator_mode.id
  var regulator_mode_port: Option[DataContent] = noData

  // upper_desired_temp: Out DataPort Isolette_Data_Model.Temp_impl
  val upper_desired_temp_id: Art.PortId = mritBridge.upper_desired_temp.id
  var upper_desired_temp_port: Option[DataContent] = noData

  // lower_desired_temp: Out DataPort Isolette_Data_Model.Temp_impl
  val lower_desired_temp_id: Art.PortId = mritBridge.lower_desired_temp.id
  var lower_desired_temp_port: Option[DataContent] = noData

  // displayed_temp: Out DataPort Isolette_Data_Model.Temp_impl
  val displayed_temp_id: Art.PortId = mritBridge.displayed_temp.id
  var displayed_temp_port: Option[DataContent] = noData

  // regulator_status: Out DataPort Isolette_Data_Model.Status
  val regulator_status_id: Art.PortId = mritBridge.regulator_status.id
  var regulator_status_port: Option[DataContent] = noData

  // interface_failure: Out DataPort Isolette_Data_Model.Failure_Flag_impl
  val interface_failure_id: Art.PortId = mritBridge.interface_failure.id
  var interface_failure_port: Option[DataContent] = noData

  def dispatchStatus(bridgeId: Art.BridgeId): DispatchStatus = {
    return TimeTriggered()
  }

  def getValue(portId: Art.PortId): Option[DataContent] = {
    if(portId == current_tempWstatus_id) {
      return current_tempWstatus_port
    } else if(portId == lower_desired_tempWstatus_id) {
      return lower_desired_tempWstatus_port
    } else if(portId == upper_desired_tempWstatus_id) {
      return upper_desired_tempWstatus_port
    } else if(portId == regulator_mode_id) {
      return regulator_mode_port
    } else {
      halt(s"Unexpected: mrit.getValue called with: ${portId}")
    }
  }

  def receiveInput(eventPortIds: ISZ[Art.PortId], dataPortIds: ISZ[Art.PortId]): Unit = {
    // ignore params

    current_tempWstatus_port = Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_seL4Nix.current_tempWstatus_Receive()

    lower_desired_tempWstatus_port = Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_seL4Nix.lower_desired_tempWstatus_Receive()

    upper_desired_tempWstatus_port = Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_seL4Nix.upper_desired_tempWstatus_Receive()

    regulator_mode_port = Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_seL4Nix.regulator_mode_Receive()
  }

  def putValue(portId: Art.PortId, data: DataContent): Unit = {
    if(portId == upper_desired_temp_id) {
      upper_desired_temp_port = Some(data)
    } else if(portId == lower_desired_temp_id) {
      lower_desired_temp_port = Some(data)
    } else if(portId == displayed_temp_id) {
      displayed_temp_port = Some(data)
    } else if(portId == regulator_status_id) {
      regulator_status_port = Some(data)
    } else if(portId == interface_failure_id) {
      interface_failure_port = Some(data)
    } else {
      halt(s"Unexpected: mrit.putValue called with: ${portId}")
    }
  }

  def sendOutput(eventPortIds: ISZ[Art.PortId], dataPortIds: ISZ[Art.PortId]): Unit = {
    // ignore params

    if(upper_desired_temp_port.nonEmpty) {
      Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_seL4Nix.upper_desired_temp_Send(upper_desired_temp_port.get)
      upper_desired_temp_port = noData
    }

    if(lower_desired_temp_port.nonEmpty) {
      Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_seL4Nix.lower_desired_temp_Send(lower_desired_temp_port.get)
      lower_desired_temp_port = noData
    }

    if(displayed_temp_port.nonEmpty) {
      Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_seL4Nix.displayed_temp_Send(displayed_temp_port.get)
      displayed_temp_port = noData
    }

    if(regulator_status_port.nonEmpty) {
      Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_seL4Nix.regulator_status_Send(regulator_status_port.get)
      regulator_status_port = noData
    }

    if(interface_failure_port.nonEmpty) {
      Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_seL4Nix.interface_failure_Send(interface_failure_port.get)
      interface_failure_port = noData
    }
  }

  def initialiseArchitecture(): Unit = {
    val ad = ArchitectureDescription(
      components = MSZ (mritBridge),
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

      isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_Bridge.c_initialization_api.get.logInfo("")
      isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_Bridge.c_initialization_api.get.logDebug("")
      isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_Bridge.c_initialization_api.get.logError("")
      isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_Bridge.c_operational_api.get.logInfo("")
      isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_Bridge.c_operational_api.get.logDebug("")
      isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_Bridge.c_operational_api.get.logError("")
      val apiUsage_current_tempWstatus: Option[Isolette_Data_Model.TempWstatus_impl] = isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_Bridge.c_operational_api.get.getcurrent_tempWstatus()
      val apiUsage_lower_desired_tempWstatus: Option[Isolette_Data_Model.TempWstatus_impl] = isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_Bridge.c_operational_api.get.getlower_desired_tempWstatus()
      val apiUsage_upper_desired_tempWstatus: Option[Isolette_Data_Model.TempWstatus_impl] = isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_Bridge.c_operational_api.get.getupper_desired_tempWstatus()
      val apiUsage_regulator_mode: Option[Isolette_Data_Model.Regulator_Mode.Type] = isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_Bridge.c_operational_api.get.getregulator_mode()
      isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_Bridge.c_initialization_api.get.setupper_desired_temp(Isolette_Data_Model.Temp_impl.empty())
      isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_Bridge.c_operational_api.get.setupper_desired_temp(Isolette_Data_Model.Temp_impl.empty())
      isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_Bridge.c_initialization_api.get.setlower_desired_temp(Isolette_Data_Model.Temp_impl.empty())
      isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_Bridge.c_operational_api.get.setlower_desired_temp(Isolette_Data_Model.Temp_impl.empty())
      isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_Bridge.c_initialization_api.get.setdisplayed_temp(Isolette_Data_Model.Temp_impl.empty())
      isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_Bridge.c_operational_api.get.setdisplayed_temp(Isolette_Data_Model.Temp_impl.empty())
      isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_Bridge.c_initialization_api.get.setregulator_status(Isolette_Data_Model.Status.byOrdinal(0).get)
      isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_Bridge.c_operational_api.get.setregulator_status(Isolette_Data_Model.Status.byOrdinal(0).get)
      isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_Bridge.c_initialization_api.get.setinterface_failure(Isolette_Data_Model.Failure_Flag_impl.empty())
      isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_Bridge.c_operational_api.get.setinterface_failure(Isolette_Data_Model.Failure_Flag_impl.empty())
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
