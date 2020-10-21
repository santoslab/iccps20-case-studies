// #Sireum

package b.Fan_i_fp_fan

import org.sireum._
import art._
import art.DispatchPropertyProtocol._
import art.PortMode._
import b._
import b.TemperatureControl.Fan_i_fp_fan_seL4Nix

object fan extends App {

  val fanBridge : b.TemperatureControl.Fan_i_fp_fan_Bridge = {
    val fanCmd = Port[TemperatureControl.FanCmd.Type] (id = 0, name = "TempControlSystem_i_Instance_fp_fan_fanCmd", mode = EventIn)
    val fanAck = Port[TemperatureControl.FanAck.Type] (id = 1, name = "TempControlSystem_i_Instance_fp_fan_fanAck", mode = EventOut)

    b.TemperatureControl.Fan_i_fp_fan_Bridge(
      id = 0,
      name = "TempControlSystem_i_Instance_fp_fan",
      dispatchProtocol = Sporadic(min = 1),
      dispatchTriggers = None(),

      fanCmd = fanCmd,
      fanAck = fanAck
    )
  }

  val entryPoints: Bridge.EntryPoints = fanBridge.entryPoints
  val noData: Option[DataContent] = None()

  // fanCmd: In EventDataPort TemperatureControl.FanCmd
  val fanCmd_id: Art.PortId = fanBridge.fanCmd.id
  var fanCmd_port: Option[DataContent] = noData

  // fanAck: Out EventDataPort TemperatureControl.FanAck
  val fanAck_id: Art.PortId = fanBridge.fanAck.id
  var fanAck_port: Option[DataContent] = noData

  def dispatchStatus(bridgeId: Art.BridgeId): DispatchStatus = {
    var portIds: ISZ[Art.PortId] = ISZ()
    if(!Fan_i_fp_fan_seL4Nix.fanCmd_IsEmpty()) {
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

    fanCmd_port = Fan_i_fp_fan_seL4Nix.fanCmd_Receive()
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
      Fan_i_fp_fan_seL4Nix.fanAck_Send(fanAck_port.get)
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

      b.TemperatureControl.Fan_i_fp_fan_Bridge.c_initialization_api.get.logInfo("")
      b.TemperatureControl.Fan_i_fp_fan_Bridge.c_initialization_api.get.logDebug("")
      b.TemperatureControl.Fan_i_fp_fan_Bridge.c_initialization_api.get.logError("")
      b.TemperatureControl.Fan_i_fp_fan_Bridge.c_operational_api.get.logInfo("")
      b.TemperatureControl.Fan_i_fp_fan_Bridge.c_operational_api.get.logDebug("")
      b.TemperatureControl.Fan_i_fp_fan_Bridge.c_operational_api.get.logError("")
      val apiUsage_fanCmd: Option[TemperatureControl.FanCmd.Type] = b.TemperatureControl.Fan_i_fp_fan_Bridge.c_operational_api.get.getfanCmd()
      b.TemperatureControl.Fan_i_fp_fan_Bridge.c_initialization_api.get.sendfanAck(TemperatureControl.FanAck.byOrdinal(0).get)
      b.TemperatureControl.Fan_i_fp_fan_Bridge.c_operational_api.get.sendfanAck(TemperatureControl.FanAck.byOrdinal(0).get)
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
