// #Sireum

package building_control_gen_mixed.BuildingControlDemo_i_Instance_tcp_tempControl

import org.sireum._
import art._
import art.DispatchPropertyProtocol._
import art.PortMode._
import building_control_gen_mixed._
import building_control_gen_mixed.BuildingControl.TempControl_i_seL4Nix

object tempControl extends App {

  val tempControlBridge : building_control_gen_mixed.BuildingControl.TempControl_i_Bridge = {
    val currentTemp = Port[BuildingControl.Temperature_i] (id = 0, name = "BuildingControlDemo_i_Instance_tcp_tempControl_currentTemp", mode = DataIn)
    val fanAck = Port[BuildingControl.FanAck.Type] (id = 1, name = "BuildingControlDemo_i_Instance_tcp_tempControl_fanAck", mode = EventIn)
    val setPoint = Port[BuildingControl.SetPoint_i] (id = 2, name = "BuildingControlDemo_i_Instance_tcp_tempControl_setPoint", mode = EventIn)
    val fanCmd = Port[BuildingControl.FanCmd.Type] (id = 3, name = "BuildingControlDemo_i_Instance_tcp_tempControl_fanCmd", mode = EventOut)
    val tempChanged = Port[art.Empty] (id = 4, name = "BuildingControlDemo_i_Instance_tcp_tempControl_tempChanged", mode = EventIn)

    building_control_gen_mixed.BuildingControl.TempControl_i_Bridge(
      id = 0,
      name = "BuildingControlDemo_i_Instance_tcp_tempControl",
      dispatchProtocol = Sporadic(min = 1000),
      dispatchTriggers = None(),

      currentTemp = currentTemp,
      fanAck = fanAck,
      setPoint = setPoint,
      fanCmd = fanCmd,
      tempChanged = tempChanged
    )
  }

  val entryPoints: Bridge.EntryPoints = tempControlBridge.entryPoints
  val noData: Option[DataContent] = None()

  // currentTemp: In DataPort BuildingControl.Temperature_i
  val currentTemp_id: Art.PortId = tempControlBridge.currentTemp.id
  var currentTemp_port: Option[DataContent] = noData

  // fanAck: In EventDataPort BuildingControl.FanAck
  val fanAck_id: Art.PortId = tempControlBridge.fanAck.id
  var fanAck_port: Option[DataContent] = noData

  // setPoint: In EventDataPort BuildingControl.SetPoint_i
  val setPoint_id: Art.PortId = tempControlBridge.setPoint.id
  var setPoint_port: Option[DataContent] = noData

  // fanCmd: Out EventDataPort BuildingControl.FanCmd
  val fanCmd_id: Art.PortId = tempControlBridge.fanCmd.id
  var fanCmd_port: Option[DataContent] = noData

  // tempChanged: In EventPort art.Empty
  val tempChanged_id: Art.PortId = tempControlBridge.tempChanged.id
  var tempChanged_port: Option[DataContent] = noData

  def dispatchStatus(bridgeId: Art.BridgeId): DispatchStatus = {
    var portIds: ISZ[Art.PortId] = ISZ()
    if(!TempControl_i_seL4Nix.fanAck_IsEmpty()) {
      portIds = portIds :+ fanAck_id
    }
    if(!TempControl_i_seL4Nix.setPoint_IsEmpty()) {
      portIds = portIds :+ setPoint_id
    }
    if(!TempControl_i_seL4Nix.tempChanged_IsEmpty()) {
      portIds = portIds :+ tempChanged_id
    }
    return EventTriggered(portIds)
  }

  def getValue(portId: Art.PortId): Option[DataContent] = {
    if(portId == currentTemp_id) {
      return currentTemp_port
    } else if(portId == fanAck_id) {
      return fanAck_port
    } else if(portId == setPoint_id) {
      return setPoint_port
    } else if(portId == tempChanged_id) {
      return tempChanged_port
    } else {
      halt(s"Unexpected: tempControl.getValue called with: ${portId}")
    }
  }

  def receiveInput(eventPortIds: ISZ[Art.PortId], dataPortIds: ISZ[Art.PortId]): Unit = {
    // ignore params

    currentTemp_port = TempControl_i_seL4Nix.currentTemp_Receive()

    fanAck_port = TempControl_i_seL4Nix.fanAck_Receive()

    setPoint_port = TempControl_i_seL4Nix.setPoint_Receive()

    tempChanged_port = TempControl_i_seL4Nix.tempChanged_Receive()
  }

  def putValue(portId: Art.PortId, data: DataContent): Unit = {
    if(portId == fanCmd_id) {
      fanCmd_port = Some(data)
    } else {
      halt(s"Unexpected: tempControl.putValue called with: ${portId}")
    }
  }

  def sendOutput(eventPortIds: ISZ[Art.PortId], dataPortIds: ISZ[Art.PortId]): Unit = {
    // ignore params

    if(fanCmd_port.nonEmpty) {
      TempControl_i_seL4Nix.fanCmd_Send(fanCmd_port.get)
      fanCmd_port = noData
    }
  }

  def initialiseArchitecture(): Unit = {
    val ad = ArchitectureDescription(
      components = MSZ (tempControlBridge),
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
