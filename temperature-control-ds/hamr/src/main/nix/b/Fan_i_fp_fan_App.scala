// #Sireum

package b

import org.sireum._
import art._

// This file was auto-generated.  Do not edit

object Fan_i_fp_fan_App extends App {

  val entryPoints: Bridge.EntryPoints = Arch.TempControlSystem_i_Instance_fp_fan.entryPoints
  val appPortId: Art.PortId = IPCPorts.Fan_i_fp_fan_App
  val appPortIdOpt: Option[Art.PortId] = Some(appPortId)
  val fanCmdPortId: Art.PortId = Arch.TempControlSystem_i_Instance_fp_fan.fanCmd.id
  val fanCmdPortIdOpt: Option[Art.PortId] = Some(fanCmdPortId)

  def initialiseArchitecture(seed: Z): Unit = {
    Platform.initialise(seed, appPortIdOpt)
    Platform.initialise(seed, fanCmdPortIdOpt)

    Art.run(Arch.ad)
  }

  def initialise(): Unit = {
    entryPoints.initialise()
  }

  def compute(): Unit = {
    var dispatch = F

    {
      val out = IPCPorts.emptyReceiveAsyncOut
      Platform.receiveAsync(fanCmdPortIdOpt, out)
      out.value2 match {
        case Some(v: TemperatureControl.FanCmd_Payload) => ArtNix.updateData(fanCmdPortId, v); dispatch = T
        case Some(v) => halt(s"Unexpected payload on port fanCmd.  Expecting something of type TemperatureControl.FanCmd_Payload but received ${v}")
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

    println("Fan_i_fp_fan_App starting ...")

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

  def exit(): Unit = {
    finalise()
    Platform.finalise()
  }

  override def atExit(): Unit = {
    exit()
  }
}