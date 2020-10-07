// #Sireum

package building_control_gen_mixed.BuildingControlDemo_i_Instance_tcp_tempSensor

import org.sireum._
import art._
import art.DispatchPropertyProtocol._
import art.PortMode._
import building_control_gen_mixed._
import building_control_gen_mixed.BuildingControl.TempSensor_i_seL4Nix

object tempSensor extends App {

  val tempSensorBridge : building_control_gen_mixed.BuildingControl.TempSensor_i_Bridge = {
    val currentTemp = Port[BuildingControl.Temperature_i] (id = 0, name = "BuildingControlDemo_i_Instance_tcp_tempSensor_currentTemp", mode = DataOut)
    val tempChanged = Port[art.Empty] (id = 1, name = "BuildingControlDemo_i_Instance_tcp_tempSensor_tempChanged", mode = EventOut)

    building_control_gen_mixed.BuildingControl.TempSensor_i_Bridge(
      id = 0,
      name = "BuildingControlDemo_i_Instance_tcp_tempSensor",
      dispatchProtocol = Periodic(period = 1000),
      dispatchTriggers = None(),

      currentTemp = currentTemp,
      tempChanged = tempChanged
    )
  }

  val entryPoints: Bridge.EntryPoints = tempSensorBridge.entryPoints
  val noData: Option[DataContent] = None()

  // currentTemp: Out DataPort BuildingControl.Temperature_i
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
      TempSensor_i_seL4Nix.currentTemp_Send(currentTemp_port.get)
      currentTemp_port = noData
    }

    if(tempChanged_port.nonEmpty) {
      TempSensor_i_seL4Nix.tempChanged_Send(tempChanged_port.get)
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

    // touch each payload/type in case some are only used as a field in a record
    def printDataContent(a: art.DataContent): Unit = { println(s"${a}") }

    printDataContent(Base_Types.Float_32_Payload(Base_Types.Float_32_empty()))
    printDataContent(BuildingControl.TempUnit_Payload(BuildingControl.TempUnit.byOrdinal(0).get))
    printDataContent(BuildingControl.Temperature_i_Payload(BuildingControl.Temperature_i.empty()))
    printDataContent(BuildingControl.SetPoint_i_Payload(BuildingControl.SetPoint_i.empty()))
    printDataContent(BuildingControl.FanAck_Payload(BuildingControl.FanAck.byOrdinal(0).get))
    printDataContent(BuildingControl.FanCmd_Payload(BuildingControl.FanCmd.byOrdinal(0).get))
    printDataContent(art.Empty())

    TranspilerToucher.touch()

    return 0
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
