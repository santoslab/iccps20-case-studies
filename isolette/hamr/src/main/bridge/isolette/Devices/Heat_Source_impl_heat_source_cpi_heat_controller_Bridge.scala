// #Sireum

package isolette.Devices

import org.sireum._
import art._
import isolette._
import isolette.Devices.{Heat_Source_impl_heat_source_cpi_heat_controller => component}

// This file was auto-generated.  Do not edit

@record class Heat_Source_impl_heat_source_cpi_heat_controller_Bridge(
  val id: Art.BridgeId,
  val name: String,
  val dispatchProtocol: DispatchPropertyProtocol,
  val dispatchTriggers: Option[ISZ[Art.PortId]],

  heat_control: Port[Isolette_Data_Model.On_Off.Type],
  heat_out: Port[Isolette_Environment.Heat.Type]
  ) extends Bridge {

  val ports : Bridge.Ports = Bridge.Ports(
    all = ISZ(heat_control,
              heat_out),

    dataIns = ISZ(heat_control),

    dataOuts = ISZ(heat_out),

    eventIns = ISZ(),

    eventOuts = ISZ()
  )

  val initialization_api : Heat_Source_impl_Initialization_Api = {
    val api = Heat_Source_impl_Initialization_Api(
      id,
      heat_control.id,
      heat_out.id
    )
    Heat_Source_impl_heat_source_cpi_heat_controller_Bridge.c_initialization_api = Some(api)
    api
  }

  val operational_api : Heat_Source_impl_Operational_Api = {
    val api = Heat_Source_impl_Operational_Api(
      id,
      heat_control.id,
      heat_out.id
    )
    Heat_Source_impl_heat_source_cpi_heat_controller_Bridge.c_operational_api = Some(api)
    api
  }

  val entryPoints : Bridge.EntryPoints =
    Heat_Source_impl_heat_source_cpi_heat_controller_Bridge.EntryPoints(
      id,

      heat_control.id,
      heat_out.id,

      dispatchTriggers,

      initialization_api,
      operational_api)
}

object Heat_Source_impl_heat_source_cpi_heat_controller_Bridge {

  var c_initialization_api: Option[Heat_Source_impl_Initialization_Api] = None()
  var c_operational_api: Option[Heat_Source_impl_Operational_Api] = None()

  @record class EntryPoints(
    Heat_Source_impl_heat_source_cpi_heat_controller_BridgeId : Art.BridgeId,

    heat_control_Id : Art.PortId,
    heat_out_Id : Art.PortId,

    dispatchTriggers : Option[ISZ[Art.PortId]],

    initialization_api: Heat_Source_impl_Initialization_Api,
    operational_api: Heat_Source_impl_Operational_Api) extends Bridge.EntryPoints {

    val dataInPortIds: ISZ[Art.PortId] = ISZ(heat_control_Id)

    val eventInPortIds: ISZ[Art.PortId] = ISZ()

    val dataOutPortIds: ISZ[Art.PortId] = ISZ(heat_out_Id)

    val eventOutPortIds: ISZ[Art.PortId] = ISZ()

    def compute(): Unit = {
      Art.receiveInput(eventInPortIds, dataInPortIds)
      component.timeTriggered(operational_api)
      Art.sendOutput(eventOutPortIds, dataOutPortIds)
    }

    override
    def testCompute(): Unit = {
      Art.receiveInput(eventInPortIds, dataInPortIds)
      component.timeTriggered(operational_api)
      Art.releaseOutput(eventOutPortIds, dataOutPortIds)
    }

    def activate(): Unit = {
      component.activate(operational_api)
    }

    def deactivate(): Unit = {
      component.deactivate(operational_api)
    }

    def finalise(): Unit = {
      component.finalise(operational_api)
    }

    def initialise(): Unit = {
      component.initialise(initialization_api)
      Art.sendOutput(eventOutPortIds, dataOutPortIds)
    }

    def recover(): Unit = {
      component.recover(operational_api)
    }
  }
}