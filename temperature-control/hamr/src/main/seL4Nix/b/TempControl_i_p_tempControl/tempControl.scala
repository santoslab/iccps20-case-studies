// #Sireum

package b.TempControl_i_p_tempControl

import org.sireum._
import art._
import art.DispatchPropertyProtocol._
import art.PortMode._
import b._
import b.TemperatureControl.TempControl_i_p_tempControl_seL4Nix

object tempControl extends App {

  val tempControlBridge : b.TemperatureControl.TempControl_i_p_tempControl_Bridge = {
    val currentTemp = Port[TemperatureControl.Temperature_i] (id = 0, name = "TempControlSystem_i_Instance_p_tempControl_currentTemp", mode = DataIn)
    val fanAck = Port[TemperatureControl.FanAck.Type] (id = 1, name = "TempControlSystem_i_Instance_p_tempControl_fanAck", mode = EventIn)
    val setPoint = Port[TemperatureControl.SetPoint_i] (id = 2, name = "TempControlSystem_i_Instance_p_tempControl_setPoint", mode = EventIn)
    val fanCmd = Port[TemperatureControl.FanCmd.Type] (id = 3, name = "TempControlSystem_i_Instance_p_tempControl_fanCmd", mode = EventOut)
    val tempChanged = Port[art.Empty] (id = 4, name = "TempControlSystem_i_Instance_p_tempControl_tempChanged", mode = EventIn)

    b.TemperatureControl.TempControl_i_p_tempControl_Bridge(
      id = 0,
      name = "TempControlSystem_i_Instance_p_tempControl",
      dispatchProtocol = Sporadic(min = 1),
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

  // currentTemp: In DataPort TemperatureControl.Temperature_i
  val currentTemp_id: Art.PortId = tempControlBridge.currentTemp.id
  var currentTemp_port: Option[DataContent] = noData

  // fanAck: In EventDataPort TemperatureControl.FanAck
  val fanAck_id: Art.PortId = tempControlBridge.fanAck.id
  var fanAck_port: Option[DataContent] = noData

  // setPoint: In EventDataPort TemperatureControl.SetPoint_i
  val setPoint_id: Art.PortId = tempControlBridge.setPoint.id
  var setPoint_port: Option[DataContent] = noData

  // fanCmd: Out EventDataPort TemperatureControl.FanCmd
  val fanCmd_id: Art.PortId = tempControlBridge.fanCmd.id
  var fanCmd_port: Option[DataContent] = noData

  // tempChanged: In EventPort art.Empty
  val tempChanged_id: Art.PortId = tempControlBridge.tempChanged.id
  var tempChanged_port: Option[DataContent] = noData

  def dispatchStatus(bridgeId: Art.BridgeId): DispatchStatus = {
    var portIds: ISZ[Art.PortId] = ISZ()
    if(!TempControl_i_p_tempControl_seL4Nix.fanAck_IsEmpty()) {
      portIds = portIds :+ fanAck_id
    }
    if(!TempControl_i_p_tempControl_seL4Nix.setPoint_IsEmpty()) {
      portIds = portIds :+ setPoint_id
    }
    if(!TempControl_i_p_tempControl_seL4Nix.tempChanged_IsEmpty()) {
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

    currentTemp_port = TempControl_i_p_tempControl_seL4Nix.currentTemp_Receive()

    fanAck_port = TempControl_i_p_tempControl_seL4Nix.fanAck_Receive()

    setPoint_port = TempControl_i_p_tempControl_seL4Nix.setPoint_Receive()

    tempChanged_port = TempControl_i_p_tempControl_seL4Nix.tempChanged_Receive()
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
      TempControl_i_p_tempControl_seL4Nix.fanCmd_Send(fanCmd_port.get)
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

      b.TemperatureControl.TempControl_i_p_tempControl_Bridge.c_initialization_api.get.logInfo("")
      b.TemperatureControl.TempControl_i_p_tempControl_Bridge.c_initialization_api.get.logDebug("")
      b.TemperatureControl.TempControl_i_p_tempControl_Bridge.c_initialization_api.get.logError("")
      b.TemperatureControl.TempControl_i_p_tempControl_Bridge.c_operational_api.get.logInfo("")
      b.TemperatureControl.TempControl_i_p_tempControl_Bridge.c_operational_api.get.logDebug("")
      b.TemperatureControl.TempControl_i_p_tempControl_Bridge.c_operational_api.get.logError("")
      val apiUsage_currentTemp: Option[TemperatureControl.Temperature_i] = b.TemperatureControl.TempControl_i_p_tempControl_Bridge.c_operational_api.get.getcurrentTemp()
      val apiUsage_fanAck: Option[TemperatureControl.FanAck.Type] = b.TemperatureControl.TempControl_i_p_tempControl_Bridge.c_operational_api.get.getfanAck()
      val apiUsage_setPoint: Option[TemperatureControl.SetPoint_i] = b.TemperatureControl.TempControl_i_p_tempControl_Bridge.c_operational_api.get.getsetPoint()
      b.TemperatureControl.TempControl_i_p_tempControl_Bridge.c_initialization_api.get.sendfanCmd(TemperatureControl.FanCmd.byOrdinal(0).get)
      b.TemperatureControl.TempControl_i_p_tempControl_Bridge.c_operational_api.get.sendfanCmd(TemperatureControl.FanCmd.byOrdinal(0).get)
      val apiUsage_tempChanged: Option[art.Empty] = b.TemperatureControl.TempControl_i_p_tempControl_Bridge.c_operational_api.get.gettempChanged()
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
