// #Sireum

package pca_pump.PCA_Mechanical

import org.sireum._
import art._
import pca_pump._
import pca_pump.PCA_Mechanical.{drug_reservoir_imp_pump_fluid_reservoir => component}

// This file was auto-generated.  Do not edit

@record class drug_reservoir_imp_pump_fluid_reservoir_Bridge(
  val id: Art.BridgeId,
  val name: String,
  val dispatchProtocol: DispatchPropertyProtocol,
  val dispatchTriggers: Option[ISZ[Art.PortId]],

  Fill_Reservoir: Port[Physical_Types.Fluid_Volume_imp],
  Drug_Outlet: Port[Physical_Types.Fluid_Flow_imp],
  Door_Open: Port[Base_Types.Boolean],
  Door_Closed: Port[art.Empty],
  Low_Reservoir: Port[art.Empty],
  Empty_Reservoir: Port[art.Empty]
  ) extends Bridge {

  val ports : Bridge.Ports = Bridge.Ports(
    all = ISZ(Fill_Reservoir,
              Drug_Outlet,
              Door_Open,
              Door_Closed,
              Low_Reservoir,
              Empty_Reservoir),

    dataIns = ISZ(Fill_Reservoir),

    dataOuts = ISZ(Drug_Outlet,
                   Door_Open),

    eventIns = ISZ(),

    eventOuts = ISZ(Door_Closed,
                    Low_Reservoir,
                    Empty_Reservoir)
  )

  val initialization_api : drug_reservoir_imp_Initialization_Api = {
    val api = drug_reservoir_imp_Initialization_Api(
      id,
      Fill_Reservoir.id,
      Drug_Outlet.id,
      Door_Open.id,
      Door_Closed.id,
      Low_Reservoir.id,
      Empty_Reservoir.id
    )
    drug_reservoir_imp_pump_fluid_reservoir_Bridge.c_initialization_api = Some(api)
    api
  }

  val operational_api : drug_reservoir_imp_Operational_Api = {
    val api = drug_reservoir_imp_Operational_Api(
      id,
      Fill_Reservoir.id,
      Drug_Outlet.id,
      Door_Open.id,
      Door_Closed.id,
      Low_Reservoir.id,
      Empty_Reservoir.id
    )
    drug_reservoir_imp_pump_fluid_reservoir_Bridge.c_operational_api = Some(api)
    api
  }

  val entryPoints : Bridge.EntryPoints =
    drug_reservoir_imp_pump_fluid_reservoir_Bridge.EntryPoints(
      id,

      Fill_Reservoir.id,
      Drug_Outlet.id,
      Door_Open.id,
      Door_Closed.id,
      Low_Reservoir.id,
      Empty_Reservoir.id,

      dispatchTriggers,

      initialization_api,
      operational_api)
}

object drug_reservoir_imp_pump_fluid_reservoir_Bridge {

  var c_initialization_api: Option[drug_reservoir_imp_Initialization_Api] = None()
  var c_operational_api: Option[drug_reservoir_imp_Operational_Api] = None()

  @record class EntryPoints(
    drug_reservoir_imp_pump_fluid_reservoir_BridgeId : Art.BridgeId,

    Fill_Reservoir_Id : Art.PortId,
    Drug_Outlet_Id : Art.PortId,
    Door_Open_Id : Art.PortId,
    Door_Closed_Id : Art.PortId,
    Low_Reservoir_Id : Art.PortId,
    Empty_Reservoir_Id : Art.PortId,

    dispatchTriggers : Option[ISZ[Art.PortId]],

    initialization_api: drug_reservoir_imp_Initialization_Api,
    operational_api: drug_reservoir_imp_Operational_Api) extends Bridge.EntryPoints {

    val dataInPortIds: ISZ[Art.PortId] = ISZ(Fill_Reservoir_Id)

    val eventInPortIds: ISZ[Art.PortId] = ISZ()

    val dataOutPortIds: ISZ[Art.PortId] = ISZ(Drug_Outlet_Id,
                                              Door_Open_Id)

    val eventOutPortIds: ISZ[Art.PortId] = ISZ(Door_Closed_Id,
                                               Low_Reservoir_Id,
                                               Empty_Reservoir_Id)

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