// #Sireum

package b.TempSensor_i_tsp_tempSensor

import org.sireum._
import art._
import art.DispatchPropertyProtocol._
import art.PortMode._
import b._
import b.TemperatureControl.TempSensor_i_tsp_tempSensor_seL4Nix

object tempSensor extends App {

  val tempSensorBridge : b.TemperatureControl.TempSensor_i_tsp_tempSensor_Bridge = {
    val currentTemp = Port[TemperatureControl.Temperature_i] (id = 0, name = "TempControlSystem_i_Instance_tsp_tempSensor_currentTemp", mode = DataOut)
    val tempChanged = Port[art.Empty] (id = 1, name = "TempControlSystem_i_Instance_tsp_tempSensor_tempChanged", mode = EventOut)

    b.TemperatureControl.TempSensor_i_tsp_tempSensor_Bridge(
      id = 0,
      name = "TempControlSystem_i_Instance_tsp_tempSensor",
      dispatchProtocol = Periodic(period = 1000),
      dispatchTriggers = None(),

      currentTemp = currentTemp,
      tempChanged = tempChanged
    )
  }

  val entryPoints: Bridge.EntryPoints = tempSensorBridge.entryPoints
  val noData: Option[DataContent] = None()

  // currentTemp: Out DataPort TemperatureControl.Temperature_i
  val currentTemp_id: Art.PortId = tempSensorBridge.currentTemp.id
  var currentTemp_port: Option[DataContent] = noData

  // tempChanged: Out EventPort art.Empty
  val tempChanged_id: Art.PortId = tempSensorBridge.tempChanged.id
  var tempChanged_port: Option[DataContent] = noData

  def dispatchStatus(bridgeId: Art.BridgeId): DispatchStatus = {
    return TimeTriggered()
  }

  def getValue(portId: Art.PortId): Option[DataContent] = {
    halt(s"Unexpected: tempSensor.getValue called with: ${portId}")
  }

  def receiveInput(eventPortIds: ISZ[Art.PortId], dataPortIds: ISZ[Art.PortId]): Unit = {
    // ignore params


  }

  def putValue(portId: Art.PortId, data: DataContent): Unit = {
    if(portId == currentTemp_id) {
      currentTemp_port = Some(data)
    } else if(portId == tempChanged_id) {
      tempChanged_port = Some(data)
    } else {
      halt(s"Unexpected: tempSensor.putValue called with: ${portId}")
    }
  }

  def sendOutput(eventPortIds: ISZ[Art.PortId], dataPortIds: ISZ[Art.PortId]): Unit = {
    // ignore params

    if(currentTemp_port.nonEmpty) {
      TempSensor_i_tsp_tempSensor_seL4Nix.currentTemp_Send(currentTemp_port.get)
      currentTemp_port = noData
    }

    if(tempChanged_port.nonEmpty) {
      TempSensor_i_tsp_tempSensor_seL4Nix.tempChanged_Send(tempChanged_port.get)
      tempChanged_port = noData
    }
  }

  def initialiseArchitecture(): Unit = {
    val ad = ArchitectureDescription(
      components = MSZ (tempSensorBridge),
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

      printDataContent(Base_Types.Float_32_Payload(Base_Types.Float_32_empty()))
      printDataContent(TemperatureControl.TempUnit_Payload(TemperatureControl.TempUnit.byOrdinal(0).get))
      printDataContent(TemperatureControl.Temperature_i_Payload(TemperatureControl.Temperature_i.empty()))
      printDataContent(TemperatureControl.SetPoint_i_Payload(TemperatureControl.SetPoint_i.empty()))
      printDataContent(TemperatureControl.FanAck_Payload(TemperatureControl.FanAck.byOrdinal(0).get))
      printDataContent(TemperatureControl.FanCmd_Payload(TemperatureControl.FanCmd.byOrdinal(0).get))
      printDataContent(art.Empty())

      b.TemperatureControl.TempSensor_i_tsp_tempSensor_Bridge.c_initialization_api.get.logInfo("")
      b.TemperatureControl.TempSensor_i_tsp_tempSensor_Bridge.c_initialization_api.get.logDebug("")
      b.TemperatureControl.TempSensor_i_tsp_tempSensor_Bridge.c_initialization_api.get.logError("")
      b.TemperatureControl.TempSensor_i_tsp_tempSensor_Bridge.c_operational_api.get.logInfo("")
      b.TemperatureControl.TempSensor_i_tsp_tempSensor_Bridge.c_operational_api.get.logDebug("")
      b.TemperatureControl.TempSensor_i_tsp_tempSensor_Bridge.c_operational_api.get.logError("")
      b.TemperatureControl.TempSensor_i_tsp_tempSensor_Bridge.c_initialization_api.get.setcurrentTemp(TemperatureControl.Temperature_i.empty())
      b.TemperatureControl.TempSensor_i_tsp_tempSensor_Bridge.c_operational_api.get.setcurrentTemp(TemperatureControl.Temperature_i.empty())
      b.TemperatureControl.TempSensor_i_tsp_tempSensor_Bridge.c_initialization_api.get.sendtempChanged()
      b.TemperatureControl.TempSensor_i_tsp_tempSensor_Bridge.c_operational_api.get.sendtempChanged()
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
