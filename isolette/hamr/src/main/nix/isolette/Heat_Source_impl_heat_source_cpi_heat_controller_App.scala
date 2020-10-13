// #Sireum

package isolette

import org.sireum._
import art._

// This file was auto-generated.  Do not edit

object Heat_Source_impl_heat_source_cpi_heat_controller_App extends App {

  val entryPoints: Bridge.EntryPoints = Arch.isolette_single_sensor_Instance_heat_source_cpi_heat_controller.entryPoints
  val appPortId: Art.PortId = IPCPorts.Heat_Source_impl_heat_source_cpi_heat_controller_App
  val appPortIdOpt: Option[Art.PortId] = Some(appPortId)
  val heat_controlPortId: Art.PortId = Arch.isolette_single_sensor_Instance_heat_source_cpi_heat_controller.heat_control.id
  val heat_controlPortIdOpt: Option[Art.PortId] = Some(heat_controlPortId)

  def initialiseArchitecture(seed: Z): Unit = {
    Platform.initialise(seed, appPortIdOpt)
    Platform.initialise(seed, heat_controlPortIdOpt)

    Art.run(Arch.ad)
  }

  def initialise(): Unit = {
    entryPoints.initialise()
  }

  def compute(): Unit = {

    {
      val out = IPCPorts.emptyReceiveAsyncOut
      Platform.receiveAsync(heat_controlPortIdOpt, out)
      out.value2 match {
        case Some(v: Isolette_Data_Model.On_Off_Payload) => ArtNix.updateData(heat_controlPortId, v)
        case Some(v) => halt(s"Unexpected payload on port heat_control.  Expecting something of type Isolette_Data_Model.On_Off_Payload but received ${v}")
        case None() => // do nothing
      }
    }
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

    println("Heat_Source_impl_heat_source_cpi_heat_controller_App starting ...")

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

      isolette.Devices.Heat_Source_impl_heat_source_cpi_heat_controller_Bridge.c_initialization_api.get.logInfo("")
      isolette.Devices.Heat_Source_impl_heat_source_cpi_heat_controller_Bridge.c_initialization_api.get.logDebug("")
      isolette.Devices.Heat_Source_impl_heat_source_cpi_heat_controller_Bridge.c_initialization_api.get.logError("")
      isolette.Devices.Heat_Source_impl_heat_source_cpi_heat_controller_Bridge.c_operational_api.get.logInfo("")
      isolette.Devices.Heat_Source_impl_heat_source_cpi_heat_controller_Bridge.c_operational_api.get.logDebug("")
      isolette.Devices.Heat_Source_impl_heat_source_cpi_heat_controller_Bridge.c_operational_api.get.logError("")
      val apiUsage_heat_control: Option[Isolette_Data_Model.On_Off.Type] = isolette.Devices.Heat_Source_impl_heat_source_cpi_heat_controller_Bridge.c_operational_api.get.getheat_control()
      isolette.Devices.Heat_Source_impl_heat_source_cpi_heat_controller_Bridge.c_initialization_api.get.setheat_out(Isolette_Environment.Heat.byOrdinal(0).get)
      isolette.Devices.Heat_Source_impl_heat_source_cpi_heat_controller_Bridge.c_operational_api.get.setheat_out(Isolette_Environment.Heat.byOrdinal(0).get)
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