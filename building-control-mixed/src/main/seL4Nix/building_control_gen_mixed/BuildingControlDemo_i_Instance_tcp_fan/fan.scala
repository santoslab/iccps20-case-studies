// #Sireum

package building_control_gen_mixed.BuildingControlDemo_i_Instance_tcp_fan

import org.sireum._
import art._
import art.DispatchPropertyProtocol._
import art.PortMode._
import building_control_gen_mixed._
import building_control_gen_mixed.BuildingControl.Fan_i_seL4Nix

object fan extends App {

  val fanBridge : building_control_gen_mixed.BuildingControl.Fan_i_Bridge = {
    val fanCmd = Port[BuildingControl.FanCmd.Type] (id = 0, name = "BuildingControlDemo_i_Instance_tcp_fan_fanCmd", mode = EventIn)
    val fanAck = Port[BuildingControl.FanAck.Type] (id = 1, name = "BuildingControlDemo_i_Instance_tcp_fan_fanAck", mode = EventOut)

    building_control_gen_mixed.BuildingControl.Fan_i_Bridge(
      id = 0,
      name = "BuildingControlDemo_i_Instance_tcp_fan",
      dispatchProtocol = Sporadic(min = 1000),
      dispatchTriggers = None(),

      fanCmd = fanCmd,
      fanAck = fanAck
    )
  }

  val entryPoints: Bridge.EntryPoints = fanBridge.entryPoints
  val noData: Option[DataContent] = None()

  // fanCmd: In EventDataPort BuildingControl.FanCmd
  val fanCmd_id: Art.PortId = fanBridge.fanCmd.id
  var fanCmd_port: Option[DataContent] = noData

  // fanAck: Out EventDataPort BuildingControl.FanAck
  val fanAck_id: Art.PortId = fanBridge.fanAck.id
  var fanAck_port: Option[DataContent] = noData

  def dispatchStatus(bridgeId: Art.BridgeId): DispatchStatus = {
    var portIds: ISZ[Art.PortId] = ISZ()
    if(!Fan_i_seL4Nix.fanCmd_IsEmpty()) {
      portIds = portIds :+ fanCmd_id
    }
    return EventTriggered(portIds)
  }

  def getValue(portId: Art.PortId): Option[DataContent] = {
    if(portId == fanCmd_id) {
      return fanCmd_port
    } else {
      halt(s"Unexpected: fan.getValue called with: ${portId}")
    }
  }

  def receiveInput(eventPortIds: ISZ[Art.PortId], dataPortIds: ISZ[Art.PortId]): Unit = {
    // ignore params

    fanCmd_port = Fan_i_seL4Nix.fanCmd_Receive()
  }

  def putValue(portId: Art.PortId, data: DataContent): Unit = {
    if(portId == fanAck_id) {
      fanAck_port = Some(data)
    } else {
      halt(s"Unexpected: fan.putValue called with: ${portId}")
    }
  }

  def sendOutput(eventPortIds: ISZ[Art.PortId], dataPortIds: ISZ[Art.PortId]): Unit = {
    // ignore params

    if(fanAck_port.nonEmpty) {
      Fan_i_seL4Nix.fanAck_Send(fanAck_port.get)
      fanAck_port = noData
    }
  }

  def initialiseArchitecture(): Unit = {
    val ad = ArchitectureDescription(
      components = MSZ (fanBridge),
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
