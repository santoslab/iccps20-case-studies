// #Sireum

package isolette.Heat_Source_impl_heat_source_cpi_heat_controller

import org.sireum._
import art._
import art.DispatchPropertyProtocol._
import art.PortMode._
import isolette._
import isolette.Devices.Heat_Source_impl_heat_source_cpi_heat_controller_seL4Nix

object heat_controller extends App {

  val heat_controllerBridge : isolette.Devices.Heat_Source_impl_heat_source_cpi_heat_controller_Bridge = {
    val heat_control = Port[Isolette_Data_Model.On_Off.Type] (id = 0, name = "isolette_single_sensor_Instance_heat_source_cpi_heat_controller_heat_control", mode = DataIn)
    val heat_out = Port[Isolette_Environment.Heat.Type] (id = 1, name = "isolette_single_sensor_Instance_heat_source_cpi_heat_controller_heat_out", mode = DataOut)

    isolette.Devices.Heat_Source_impl_heat_source_cpi_heat_controller_Bridge(
      id = 0,
      name = "isolette_single_sensor_Instance_heat_source_cpi_heat_controller",
      dispatchProtocol = Periodic(period = 1000),
      dispatchTriggers = None(),

      heat_control = heat_control,
      heat_out = heat_out
    )
  }

  val entryPoints: Bridge.EntryPoints = heat_controllerBridge.entryPoints
  val noData: Option[DataContent] = None()

  // heat_control: In DataPort Isolette_Data_Model.On_Off
  val heat_control_id: Art.PortId = heat_controllerBridge.heat_control.id
  var heat_control_port: Option[DataContent] = noData

  // heat_out: Out DataPort Isolette_Environment.Heat
  val heat_out_id: Art.PortId = heat_controllerBridge.heat_out.id
  var heat_out_port: Option[DataContent] = noData

  def dispatchStatus(bridgeId: Art.BridgeId): DispatchStatus = {
    return TimeTriggered()
  }

  def getValue(portId: Art.PortId): Option[DataContent] = {
    if(portId == heat_control_id) {
      return heat_control_port
    } else {
      halt(s"Unexpected: heat_controller.getValue called with: ${portId}")
    }
  }

  def receiveInput(eventPortIds: ISZ[Art.PortId], dataPortIds: ISZ[Art.PortId]): Unit = {
    // ignore params

    heat_control_port = Heat_Source_impl_heat_source_cpi_heat_controller_seL4Nix.heat_control_Receive()
  }

  def putValue(portId: Art.PortId, data: DataContent): Unit = {
    if(portId == heat_out_id) {
      heat_out_port = Some(data)
    } else {
      halt(s"Unexpected: heat_controller.putValue called with: ${portId}")
    }
  }

  def sendOutput(eventPortIds: ISZ[Art.PortId], dataPortIds: ISZ[Art.PortId]): Unit = {
    // ignore params

    if(heat_out_port.nonEmpty) {
      Heat_Source_impl_heat_source_cpi_heat_controller_seL4Nix.heat_out_Send(heat_out_port.get)
      heat_out_port = noData
    }
  }

  def initialiseArchitecture(): Unit = {
    val ad = ArchitectureDescription(
      components = MSZ (heat_controllerBridge),
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

      isolette.Devices.Heat_Source_impl_heat_source_cpi_heat_controller_Bridge.c_initialization_api.get.logInfo("")
      isolette.Devices.Heat_Source_impl_heat_source_cpi_heat_controller_Bridge.c_initialization_api.get.logDebug("")
      isolette.Devices.Heat_Source_impl_heat_source_cpi_heat_controller_Bridge.c_initialization_api.get.logError("")
      isolette.Devices.Heat_Source_impl_heat_source_cpi_heat_controller_Bridge.c_operational_api.get.logInfo("")
      isolette.Devices.Heat_Source_impl_heat_source_cpi_heat_controller_Bridge.c_operational_api.get.logDebug("")
      isolette.Devices.Heat_Source_impl_heat_source_cpi_heat_controller_Bridge.c_operational_api.get.logError("")
      val apiUsage_heat_control: Option[Isolette_Data_Model.On_Off.Type] = isolette.Devices.Heat_Source_impl_heat_source_cpi_heat_controller_Bridge.c_operational_api.get.getheat_control()
      isolette.Devices.Heat_Source_impl_heat_source_cpi_heat_controller_Bridge.c_initialization_api.get.setheat_out(Isolette_Environment.Heat.byOrdinal(0).get)
      isolette.Devices.Heat_Source_impl_heat_source_cpi_heat_controller_Bridge.c_operational_api.get.setheat_out(Isolette_Environment.Heat.byOrdinal(0).get)
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
