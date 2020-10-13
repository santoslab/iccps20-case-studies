// #Sireum

package building_control_mixed

import org.sireum._
import art._

// This file was auto-generated.  Do not edit

object TempSensor_i_tcp_tempSensor_App extends App {

  val entryPoints: Bridge.EntryPoints = Arch.BuildingControlDemo_i_Instance_tcp_tempSensor.entryPoints
  val appPortId: Art.PortId = IPCPorts.TempSensor_i_tcp_tempSensor_App
  val appPortIdOpt: Option[Art.PortId] = Some(appPortId)

  def initialiseArchitecture(seed: Z): Unit = {
    Platform.initialise(seed, appPortIdOpt)

    Art.run(Arch.ad)
  }

  def initialise(): Unit = {
    entryPoints.initialise()
  }

  def compute(): Unit = {

    entryPoints.compute()
    Process.sleep(1000)
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

    println("TempSensor_i_tcp_tempSensor_App starting ...")

    ArtNix.timeDispatch()

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
      printDataContent(BuildingControl.TempUnit_Payload(BuildingControl.TempUnit.byOrdinal(0).get))
      printDataContent(BuildingControl.Temperature_i_Payload(BuildingControl.Temperature_i.empty()))
      printDataContent(BuildingControl.SetPoint_i_Payload(BuildingControl.SetPoint_i.empty()))
      printDataContent(BuildingControl.FanAck_Payload(BuildingControl.FanAck.byOrdinal(0).get))
      printDataContent(BuildingControl.FanCmd_Payload(BuildingControl.FanCmd.byOrdinal(0).get))
      printDataContent(art.Empty())

      building_control_mixed.BuildingControl.TempSensor_i_tcp_tempSensor_Bridge.c_initialization_api.get.logInfo("")
      building_control_mixed.BuildingControl.TempSensor_i_tcp_tempSensor_Bridge.c_initialization_api.get.logDebug("")
      building_control_mixed.BuildingControl.TempSensor_i_tcp_tempSensor_Bridge.c_initialization_api.get.logError("")
      building_control_mixed.BuildingControl.TempSensor_i_tcp_tempSensor_Bridge.c_operational_api.get.logInfo("")
      building_control_mixed.BuildingControl.TempSensor_i_tcp_tempSensor_Bridge.c_operational_api.get.logDebug("")
      building_control_mixed.BuildingControl.TempSensor_i_tcp_tempSensor_Bridge.c_operational_api.get.logError("")
      building_control_mixed.BuildingControl.TempSensor_i_tcp_tempSensor_Bridge.c_initialization_api.get.setcurrentTemp(BuildingControl.Temperature_i.empty())
      building_control_mixed.BuildingControl.TempSensor_i_tcp_tempSensor_Bridge.c_operational_api.get.setcurrentTemp(BuildingControl.Temperature_i.empty())
      building_control_mixed.BuildingControl.TempSensor_i_tcp_tempSensor_Bridge.c_initialization_api.get.sendtempChanged()
      building_control_mixed.BuildingControl.TempSensor_i_tcp_tempSensor_Bridge.c_operational_api.get.sendtempChanged()
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