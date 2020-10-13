// #Sireum

package isolette.Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_mhst

import org.sireum._
import art._
import art.DispatchPropertyProtocol._
import art.PortMode._
import isolette._
import isolette.Regulate.Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_mhst_seL4Nix

object mhst extends App {

  val mhstBridge : isolette.Regulate.Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_mhst_Bridge = {
    val current_tempWstatus = Port[Isolette_Data_Model.TempWstatus_impl] (id = 0, name = "isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_heat_source_mhst_current_tempWstatus", mode = DataIn)
    val lower_desired_temp = Port[Isolette_Data_Model.Temp_impl] (id = 1, name = "isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_heat_source_mhst_lower_desired_temp", mode = DataIn)
    val upper_desired_temp = Port[Isolette_Data_Model.Temp_impl] (id = 2, name = "isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_heat_source_mhst_upper_desired_temp", mode = DataIn)
    val regulator_mode = Port[Isolette_Data_Model.Regulator_Mode.Type] (id = 3, name = "isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_heat_source_mhst_regulator_mode", mode = DataIn)
    val heat_control = Port[Isolette_Data_Model.On_Off.Type] (id = 4, name = "isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_heat_source_mhst_heat_control", mode = DataOut)

    isolette.Regulate.Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_mhst_Bridge(
      id = 0,
      name = "isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_heat_source_mhst",
      dispatchProtocol = Periodic(period = 1000),
      dispatchTriggers = None(),

      current_tempWstatus = current_tempWstatus,
      lower_desired_temp = lower_desired_temp,
      upper_desired_temp = upper_desired_temp,
      regulator_mode = regulator_mode,
      heat_control = heat_control
    )
  }

  val entryPoints: Bridge.EntryPoints = mhstBridge.entryPoints
  val noData: Option[DataContent] = None()

  // current_tempWstatus: In DataPort Isolette_Data_Model.TempWstatus_impl
  val current_tempWstatus_id: Art.PortId = mhstBridge.current_tempWstatus.id
  var current_tempWstatus_port: Option[DataContent] = noData

  // lower_desired_temp: In DataPort Isolette_Data_Model.Temp_impl
  val lower_desired_temp_id: Art.PortId = mhstBridge.lower_desired_temp.id
  var lower_desired_temp_port: Option[DataContent] = noData

  // upper_desired_temp: In DataPort Isolette_Data_Model.Temp_impl
  val upper_desired_temp_id: Art.PortId = mhstBridge.upper_desired_temp.id
  var upper_desired_temp_port: Option[DataContent] = noData

  // regulator_mode: In DataPort Isolette_Data_Model.Regulator_Mode
  val regulator_mode_id: Art.PortId = mhstBridge.regulator_mode.id
  var regulator_mode_port: Option[DataContent] = noData

  // heat_control: Out DataPort Isolette_Data_Model.On_Off
  val heat_control_id: Art.PortId = mhstBridge.heat_control.id
  var heat_control_port: Option[DataContent] = noData

  def dispatchStatus(bridgeId: Art.BridgeId): DispatchStatus = {
    return TimeTriggered()
  }

  def getValue(portId: Art.PortId): Option[DataContent] = {
    if(portId == current_tempWstatus_id) {
      return current_tempWstatus_port
    } else if(portId == lower_desired_temp_id) {
      return lower_desired_temp_port
    } else if(portId == upper_desired_temp_id) {
      return upper_desired_temp_port
    } else if(portId == regulator_mode_id) {
      return regulator_mode_port
    } else {
      halt(s"Unexpected: mhst.getValue called with: ${portId}")
    }
  }

  def receiveInput(eventPortIds: ISZ[Art.PortId], dataPortIds: ISZ[Art.PortId]): Unit = {
    // ignore params

    current_tempWstatus_port = Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_mhst_seL4Nix.current_tempWstatus_Receive()

    lower_desired_temp_port = Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_mhst_seL4Nix.lower_desired_temp_Receive()

    upper_desired_temp_port = Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_mhst_seL4Nix.upper_desired_temp_Receive()

    regulator_mode_port = Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_mhst_seL4Nix.regulator_mode_Receive()
  }

  def putValue(portId: Art.PortId, data: DataContent): Unit = {
    if(portId == heat_control_id) {
      heat_control_port = Some(data)
    } else {
      halt(s"Unexpected: mhst.putValue called with: ${portId}")
    }
  }

  def sendOutput(eventPortIds: ISZ[Art.PortId], dataPortIds: ISZ[Art.PortId]): Unit = {
    // ignore params

    if(heat_control_port.nonEmpty) {
      Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_mhst_seL4Nix.heat_control_Send(heat_control_port.get)
      heat_control_port = noData
    }
  }

  def initialiseArchitecture(): Unit = {
    val ad = ArchitectureDescription(
      components = MSZ (mhstBridge),
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

      isolette.Regulate.Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_mhst_Bridge.c_initialization_api.get.logInfo("")
      isolette.Regulate.Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_mhst_Bridge.c_initialization_api.get.logDebug("")
      isolette.Regulate.Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_mhst_Bridge.c_initialization_api.get.logError("")
      isolette.Regulate.Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_mhst_Bridge.c_operational_api.get.logInfo("")
      isolette.Regulate.Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_mhst_Bridge.c_operational_api.get.logDebug("")
      isolette.Regulate.Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_mhst_Bridge.c_operational_api.get.logError("")
      val apiUsage_current_tempWstatus: Option[Isolette_Data_Model.TempWstatus_impl] = isolette.Regulate.Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_mhst_Bridge.c_operational_api.get.getcurrent_tempWstatus()
      val apiUsage_lower_desired_temp: Option[Isolette_Data_Model.Temp_impl] = isolette.Regulate.Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_mhst_Bridge.c_operational_api.get.getlower_desired_temp()
      val apiUsage_upper_desired_temp: Option[Isolette_Data_Model.Temp_impl] = isolette.Regulate.Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_mhst_Bridge.c_operational_api.get.getupper_desired_temp()
      val apiUsage_regulator_mode: Option[Isolette_Data_Model.Regulator_Mode.Type] = isolette.Regulate.Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_mhst_Bridge.c_operational_api.get.getregulator_mode()
      isolette.Regulate.Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_mhst_Bridge.c_initialization_api.get.setheat_control(Isolette_Data_Model.On_Off.byOrdinal(0).get)
      isolette.Regulate.Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_mhst_Bridge.c_operational_api.get.setheat_control(Isolette_Data_Model.On_Off.byOrdinal(0).get)
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
