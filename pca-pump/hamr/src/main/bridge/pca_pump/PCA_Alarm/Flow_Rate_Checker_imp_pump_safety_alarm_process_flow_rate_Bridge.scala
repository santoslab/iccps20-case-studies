// #Sireum

package pca_pump.PCA_Alarm

import org.sireum._
import art._
import pca_pump._
import pca_pump.PCA_Alarm.{Flow_Rate_Checker_imp_pump_safety_alarm_process_flow_rate => component}

// This file was auto-generated.  Do not edit

@record class Flow_Rate_Checker_imp_pump_safety_alarm_process_flow_rate_Bridge(
  val id: Art.BridgeId,
  val name: String,
  val dispatchProtocol: DispatchPropertyProtocol,
  val dispatchTriggers: Option[ISZ[Art.PortId]],

  System_Status: Port[PCA_Types.Status_Type.Type],
  Infusion_Flow_Rate: Port[PCA_Types.Flow_Rate_imp],
  Upstream_Flow_Rate: Port[PCA_Types.Flow_Rate_imp],
  Downstream_Flow_Rate: Port[PCA_Types.Flow_Rate_imp],
  Basal_Overinfusion: Port[art.Empty],
  Bolus_Overinfusion: Port[art.Empty],
  Square_Bolus_Overinfusion: Port[art.Empty],
  Basal_Underinfusion: Port[art.Empty],
  Bolus_Underinfusion: Port[art.Empty],
  Square_Bolus_Underinfusion: Port[art.Empty]
  ) extends Bridge {

  val ports : Bridge.Ports = Bridge.Ports(
    all = ISZ(System_Status,
              Infusion_Flow_Rate,
              Upstream_Flow_Rate,
              Downstream_Flow_Rate,
              Basal_Overinfusion,
              Bolus_Overinfusion,
              Square_Bolus_Overinfusion,
              Basal_Underinfusion,
              Bolus_Underinfusion,
              Square_Bolus_Underinfusion),

    dataIns = ISZ(System_Status,
                  Infusion_Flow_Rate,
                  Upstream_Flow_Rate,
                  Downstream_Flow_Rate),

    dataOuts = ISZ(),

    eventIns = ISZ(),

    eventOuts = ISZ(Basal_Overinfusion,
                    Bolus_Overinfusion,
                    Square_Bolus_Overinfusion,
                    Basal_Underinfusion,
                    Bolus_Underinfusion,
                    Square_Bolus_Underinfusion)
  )

  val initialization_api : Flow_Rate_Checker_imp_Initialization_Api = {
    val api = Flow_Rate_Checker_imp_Initialization_Api(
      id,
      System_Status.id,
      Infusion_Flow_Rate.id,
      Upstream_Flow_Rate.id,
      Downstream_Flow_Rate.id,
      Basal_Overinfusion.id,
      Bolus_Overinfusion.id,
      Square_Bolus_Overinfusion.id,
      Basal_Underinfusion.id,
      Bolus_Underinfusion.id,
      Square_Bolus_Underinfusion.id
    )
    Flow_Rate_Checker_imp_pump_safety_alarm_process_flow_rate_Bridge.c_initialization_api = Some(api)
    api
  }

  val operational_api : Flow_Rate_Checker_imp_Operational_Api = {
    val api = Flow_Rate_Checker_imp_Operational_Api(
      id,
      System_Status.id,
      Infusion_Flow_Rate.id,
      Upstream_Flow_Rate.id,
      Downstream_Flow_Rate.id,
      Basal_Overinfusion.id,
      Bolus_Overinfusion.id,
      Square_Bolus_Overinfusion.id,
      Basal_Underinfusion.id,
      Bolus_Underinfusion.id,
      Square_Bolus_Underinfusion.id
    )
    Flow_Rate_Checker_imp_pump_safety_alarm_process_flow_rate_Bridge.c_operational_api = Some(api)
    api
  }

  val entryPoints : Bridge.EntryPoints =
    Flow_Rate_Checker_imp_pump_safety_alarm_process_flow_rate_Bridge.EntryPoints(
      id,

      System_Status.id,
      Infusion_Flow_Rate.id,
      Upstream_Flow_Rate.id,
      Downstream_Flow_Rate.id,
      Basal_Overinfusion.id,
      Bolus_Overinfusion.id,
      Square_Bolus_Overinfusion.id,
      Basal_Underinfusion.id,
      Bolus_Underinfusion.id,
      Square_Bolus_Underinfusion.id,

      dispatchTriggers,

      initialization_api,
      operational_api)
}

object Flow_Rate_Checker_imp_pump_safety_alarm_process_flow_rate_Bridge {

  var c_initialization_api: Option[Flow_Rate_Checker_imp_Initialization_Api] = None()
  var c_operational_api: Option[Flow_Rate_Checker_imp_Operational_Api] = None()

  @record class EntryPoints(
    Flow_Rate_Checker_imp_pump_safety_alarm_process_flow_rate_BridgeId : Art.BridgeId,

    System_Status_Id : Art.PortId,
    Infusion_Flow_Rate_Id : Art.PortId,
    Upstream_Flow_Rate_Id : Art.PortId,
    Downstream_Flow_Rate_Id : Art.PortId,
    Basal_Overinfusion_Id : Art.PortId,
    Bolus_Overinfusion_Id : Art.PortId,
    Square_Bolus_Overinfusion_Id : Art.PortId,
    Basal_Underinfusion_Id : Art.PortId,
    Bolus_Underinfusion_Id : Art.PortId,
    Square_Bolus_Underinfusion_Id : Art.PortId,

    dispatchTriggers : Option[ISZ[Art.PortId]],

    initialization_api: Flow_Rate_Checker_imp_Initialization_Api,
    operational_api: Flow_Rate_Checker_imp_Operational_Api) extends Bridge.EntryPoints {

    val dataInPortIds: ISZ[Art.PortId] = ISZ(System_Status_Id,
                                             Infusion_Flow_Rate_Id,
                                             Upstream_Flow_Rate_Id,
                                             Downstream_Flow_Rate_Id)

    val eventInPortIds: ISZ[Art.PortId] = ISZ()

    val dataOutPortIds: ISZ[Art.PortId] = ISZ()

    val eventOutPortIds: ISZ[Art.PortId] = ISZ(Basal_Overinfusion_Id,
                                               Bolus_Overinfusion_Id,
                                               Square_Bolus_Overinfusion_Id,
                                               Basal_Underinfusion_Id,
                                               Bolus_Underinfusion_Id,
                                               Square_Bolus_Underinfusion_Id)

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