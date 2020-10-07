// #Sireum

package pca_pump.PCA_Mechanical

import org.sireum._
import art._
import pca_pump._
import pca_pump.PCA_Mechanical.{downstream_monitor_imp_pump_fluid_downstream_mon => component}

// This file was auto-generated.  Do not edit

@record class downstream_monitor_imp_pump_fluid_downstream_mon_Bridge(
  val id: Art.BridgeId,
  val name: String,
  val dispatchProtocol: DispatchPropertyProtocol,
  val dispatchTriggers: Option[ISZ[Art.PortId]],

  Drug_Intake: Port[Physical_Types.Fluid_Flow_imp],
  Drug_Outlet: Port[Physical_Types.Fluid_Flow_imp],
  Downstream_Flow_Rate: Port[PCA_Types.Flow_Rate_imp],
  Occlusion: Port[art.Empty],
  Bubble: Port[art.Empty]
  ) extends Bridge {

  val ports : Bridge.Ports = Bridge.Ports(
    all = ISZ(Drug_Intake,
              Drug_Outlet,
              Downstream_Flow_Rate,
              Occlusion,
              Bubble),

    dataIns = ISZ(Drug_Intake),

    dataOuts = ISZ(Drug_Outlet,
                   Downstream_Flow_Rate),

    eventIns = ISZ(),

    eventOuts = ISZ(Occlusion,
                    Bubble)
  )

  val initialization_api : downstream_monitor_imp_Initialization_Api = {
    val api = downstream_monitor_imp_Initialization_Api(
      id,
      Drug_Intake.id,
      Drug_Outlet.id,
      Downstream_Flow_Rate.id,
      Occlusion.id,
      Bubble.id
    )
    downstream_monitor_imp_pump_fluid_downstream_mon_Bridge.c_initialization_api = Some(api)
    api
  }

  val operational_api : downstream_monitor_imp_Operational_Api = {
    val api = downstream_monitor_imp_Operational_Api(
      id,
      Drug_Intake.id,
      Drug_Outlet.id,
      Downstream_Flow_Rate.id,
      Occlusion.id,
      Bubble.id
    )
    downstream_monitor_imp_pump_fluid_downstream_mon_Bridge.c_operational_api = Some(api)
    api
  }

  val entryPoints : Bridge.EntryPoints =
    downstream_monitor_imp_pump_fluid_downstream_mon_Bridge.EntryPoints(
      id,

      Drug_Intake.id,
      Drug_Outlet.id,
      Downstream_Flow_Rate.id,
      Occlusion.id,
      Bubble.id,

      dispatchTriggers,

      initialization_api,
      operational_api)
}

object downstream_monitor_imp_pump_fluid_downstream_mon_Bridge {

  var c_initialization_api: Option[downstream_monitor_imp_Initialization_Api] = None()
  var c_operational_api: Option[downstream_monitor_imp_Operational_Api] = None()

  @record class EntryPoints(
    downstream_monitor_imp_pump_fluid_downstream_mon_BridgeId : Art.BridgeId,

    Drug_Intake_Id : Art.PortId,
    Drug_Outlet_Id : Art.PortId,
    Downstream_Flow_Rate_Id : Art.PortId,
    Occlusion_Id : Art.PortId,
    Bubble_Id : Art.PortId,

    dispatchTriggers : Option[ISZ[Art.PortId]],

    initialization_api: downstream_monitor_imp_Initialization_Api,
    operational_api: downstream_monitor_imp_Operational_Api) extends Bridge.EntryPoints {

    val dataInPortIds: ISZ[Art.PortId] = ISZ(Drug_Intake_Id)

    val eventInPortIds: ISZ[Art.PortId] = ISZ()

    val dataOutPortIds: ISZ[Art.PortId] = ISZ(Drug_Outlet_Id,
                                              Downstream_Flow_Rate_Id)

    val eventOutPortIds: ISZ[Art.PortId] = ISZ(Occlusion_Id,
                                               Bubble_Id)

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