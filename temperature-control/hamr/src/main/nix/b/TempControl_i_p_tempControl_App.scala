// #Sireum

package b

import org.sireum._
import art._

// This file was auto-generated.  Do not edit

object TempControl_i_p_tempControl_App extends App {

  val entryPoints: Bridge.EntryPoints = Arch.TempControlSystem_i_Instance_p_tempControl.entryPoints
  val appPortId: Art.PortId = IPCPorts.TempControl_i_p_tempControl_App
  val appPortIdOpt: Option[Art.PortId] = Some(appPortId)
  val currentTempPortId: Art.PortId = Arch.TempControlSystem_i_Instance_p_tempControl.currentTemp.id
  val currentTempPortIdOpt: Option[Art.PortId] = Some(currentTempPortId)
  val fanAckPortId: Art.PortId = Arch.TempControlSystem_i_Instance_p_tempControl.fanAck.id
  val fanAckPortIdOpt: Option[Art.PortId] = Some(fanAckPortId)
  val setPointPortId: Art.PortId = Arch.TempControlSystem_i_Instance_p_tempControl.setPoint.id
  val setPointPortIdOpt: Option[Art.PortId] = Some(setPointPortId)
  val tempChangedPortId: Art.PortId = Arch.TempControlSystem_i_Instance_p_tempControl.tempChanged.id
  val tempChangedPortIdOpt: Option[Art.PortId] = Some(tempChangedPortId)

  def initialiseArchitecture(seed: Z): Unit = {
    Platform.initialise(seed, appPortIdOpt)
    Platform.initialise(seed, currentTempPortIdOpt)
    Platform.initialise(seed, fanAckPortIdOpt)
    Platform.initialise(seed, setPointPortIdOpt)
    Platform.initialise(seed, tempChangedPortIdOpt)

    Art.run(Arch.ad)
  }

  def initialise(): Unit = {
    entryPoints.initialise()
  }

  def compute(): Unit = {
    var dispatch = F

    {
      val out = IPCPorts.emptyReceiveAsyncOut
      Platform.receiveAsync(currentTempPortIdOpt, out)
      out.value2 match {
        case Some(v: TemperatureControl.Temperature_i_Payload) => ArtNix.updateData(currentTempPortId, v); dispatch = F
        case Some(v) => halt(s"Unexpected payload on port currentTemp.  Expecting something of type TemperatureControl.Temperature_i_Payload but received ${v}")
        case None() => // do nothing
      }
    }
    {
      val out = IPCPorts.emptyReceiveAsyncOut
      Platform.receiveAsync(fanAckPortIdOpt, out)
      out.value2 match {
        case Some(v: TemperatureControl.FanAck_Payload) => ArtNix.updateData(fanAckPortId, v); dispatch = T
        case Some(v) => halt(s"Unexpected payload on port fanAck.  Expecting something of type TemperatureControl.FanAck_Payload but received ${v}")
        case None() => // do nothing
      }
    }
    {
      val out = IPCPorts.emptyReceiveAsyncOut
      Platform.receiveAsync(setPointPortIdOpt, out)
      out.value2 match {
        case Some(v: TemperatureControl.SetPoint_i_Payload) => ArtNix.updateData(setPointPortId, v); dispatch = T
        case Some(v) => halt(s"Unexpected payload on port setPoint.  Expecting something of type TemperatureControl.SetPoint_i_Payload but received ${v}")
        case None() => // do nothing
      }
    }
    {
      val out = IPCPorts.emptyReceiveAsyncOut
      Platform.receiveAsync(tempChangedPortIdOpt, out)
      out.value2 match {
        case Some(v: art.Empty) => ArtNix.updateData(tempChangedPortId, v); dispatch = T
        case Some(v) => halt(s"Unexpected payload on port tempChanged.  Expecting something of type art.Empty but received ${v}")
        case None() => // do nothing
      }
    }
    if (dispatch) {
      entryPoints.compute()
      Process.sleep(1)
    } else {
      Process.sleep(10)
    }
  }

  def finalise(): Unit = {
    entryPoints.finalise()
  }

  def main(args: ISZ[String]): Z = {

    val seed: Z = if (args.size == z"1") {
      val n = Z(args(0)).get
      if (n == z"0") 1 else n
    } else {
      1
    }

    initialiseArchitecture(seed)

    Platform.receive(appPortIdOpt, IPCPorts.emptyReceiveOut) // pause after setting up component

    initialise()

    Platform.receive(appPortIdOpt, IPCPorts.emptyReceiveOut) // pause after component init

    println("TempControl_i_p_tempControl_App starting ...")

    ArtNix.eventDispatch()

    var terminated = F
    while (!terminated) {
      val out = IPCPorts.emptyReceiveAsyncOut
      Platform.receiveAsync(appPortIdOpt, out)
      if (out.value2.isEmpty) {
        compute()
      } else {
        terminated = T
      }
    }
    exit()

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

  def exit(): Unit = {
    finalise()
    Platform.finalise()
  }

  override def atExit(): Unit = {
    exit()
  }
}