// #Sireum

package isolette.Temperature_Sensor_impl_temperature_sensor_cpi_thermostat

import org.sireum._
import art._
import art.DispatchPropertyProtocol._
import art.PortMode._
import isolette._
import isolette.Devices.Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_seL4Nix

object thermostat extends App {

  val thermostatBridge : isolette.Devices.Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_Bridge = {
    val air = Port[Isolette_Data_Model.PhysicalTemp_impl] (id = 0, name = "isolette_single_sensor_Instance_temperature_sensor_cpi_thermostat_air", mode = DataIn)
    val current_tempWstatus = Port[Isolette_Data_Model.TempWstatus_impl] (id = 1, name = "isolette_single_sensor_Instance_temperature_sensor_cpi_thermostat_current_tempWstatus", mode = DataOut)

    isolette.Devices.Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_Bridge(
      id = 0,
      name = "isolette_single_sensor_Instance_temperature_sensor_cpi_thermostat",
      dispatchProtocol = Periodic(period = 1000),
      dispatchTriggers = None(),

      air = air,
      current_tempWstatus = current_tempWstatus
    )
  }

  val entryPoints: Bridge.EntryPoints = thermostatBridge.entryPoints
  val noData: Option[DataContent] = None()

  // air: In DataPort Isolette_Data_Model.PhysicalTemp_impl
  val air_id: Art.PortId = thermostatBridge.air.id
  var air_port: Option[DataContent] = noData

  // current_tempWstatus: Out DataPort Isolette_Data_Model.TempWstatus_impl
  val current_tempWstatus_id: Art.PortId = thermostatBridge.current_tempWstatus.id
  var current_tempWstatus_port: Option[DataContent] = noData

  def dispatchStatus(bridgeId: Art.BridgeId): DispatchStatus = {
    return TimeTriggered()
  }

  def getValue(portId: Art.PortId): Option[DataContent] = {
    if(portId == air_id) {
      return air_port
    } else {
      halt(s"Unexpected: thermostat.getValue called with: ${portId}")
    }
  }

  def receiveInput(eventPortIds: ISZ[Art.PortId], dataPortIds: ISZ[Art.PortId]): Unit = {
    // ignore params

    air_port = Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_seL4Nix.air_Receive()
  }

  def putValue(portId: Art.PortId, data: DataContent): Unit = {
    if(portId == current_tempWstatus_id) {
      current_tempWstatus_port = Some(data)
    } else {
      halt(s"Unexpected: thermostat.putValue called with: ${portId}")
    }
  }

  def sendOutput(eventPortIds: ISZ[Art.PortId], dataPortIds: ISZ[Art.PortId]): Unit = {
    // ignore params

    if(current_tempWstatus_port.nonEmpty) {
      Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_seL4Nix.current_tempWstatus_Send(current_tempWstatus_port.get)
      current_tempWstatus_port = noData
    }
  }

  def initialiseArchitecture(): Unit = {
    val ad = ArchitectureDescription(
      components = MSZ (thermostatBridge),
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

      isolette.Devices.Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_Bridge.c_initialization_api.get.logInfo("")
      isolette.Devices.Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_Bridge.c_initialization_api.get.logDebug("")
      isolette.Devices.Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_Bridge.c_initialization_api.get.logError("")
      isolette.Devices.Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_Bridge.c_operational_api.get.logInfo("")
      isolette.Devices.Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_Bridge.c_operational_api.get.logDebug("")
      isolette.Devices.Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_Bridge.c_operational_api.get.logError("")
      val apiUsage_air: Option[Isolette_Data_Model.PhysicalTemp_impl] = isolette.Devices.Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_Bridge.c_operational_api.get.getair()
      isolette.Devices.Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_Bridge.c_initialization_api.get.setcurrent_tempWstatus(Isolette_Data_Model.TempWstatus_impl.empty())
      isolette.Devices.Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_Bridge.c_operational_api.get.setcurrent_tempWstatus(Isolette_Data_Model.TempWstatus_impl.empty())
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
