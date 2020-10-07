// #Sireum

package pca_pump.PCA_Operation_Threads

import org.sireum._
import art._
import pca_pump._
import pca_pump.PCA_Operation_Threads.{Max_Drug_Per_Hour_Watcher_imp_pump_operation_operation_process_operation_threads_max_drug_watcher => component}

// This file was auto-generated.  Do not edit

@record class Max_Drug_Per_Hour_Watcher_imp_pump_operation_operation_process_operation_threads_max_drug_watcher_Bridge(
  val id: Art.BridgeId,
  val name: String,
  val dispatchProtocol: DispatchPropertyProtocol,
  val dispatchTriggers: Option[ISZ[Art.PortId]],

  Infusion_Flow_Rate: Port[PCA_Types.Flow_Rate_imp],
  Max_Drug_Per_Hour: Port[PCA_Types.Drug_Volume_imp],
  Near_Max_Drug_Per_Hour: Port[art.Empty],
  Over_Max_Drug_Per_Hour: Port[art.Empty]
  ) extends Bridge {

  val ports : Bridge.Ports = Bridge.Ports(
    all = ISZ(Infusion_Flow_Rate,
              Max_Drug_Per_Hour,
              Near_Max_Drug_Per_Hour,
              Over_Max_Drug_Per_Hour),

    dataIns = ISZ(Infusion_Flow_Rate,
                  Max_Drug_Per_Hour),

    dataOuts = ISZ(),

    eventIns = ISZ(),

    eventOuts = ISZ(Near_Max_Drug_Per_Hour,
                    Over_Max_Drug_Per_Hour)
  )

  val initialization_api : Max_Drug_Per_Hour_Watcher_imp_Initialization_Api = {
    val api = Max_Drug_Per_Hour_Watcher_imp_Initialization_Api(
      id,
      Infusion_Flow_Rate.id,
      Max_Drug_Per_Hour.id,
      Near_Max_Drug_Per_Hour.id,
      Over_Max_Drug_Per_Hour.id
    )
    Max_Drug_Per_Hour_Watcher_imp_pump_operation_operation_process_operation_threads_max_drug_watcher_Bridge.c_initialization_api = Some(api)
    api
  }

  val operational_api : Max_Drug_Per_Hour_Watcher_imp_Operational_Api = {
    val api = Max_Drug_Per_Hour_Watcher_imp_Operational_Api(
      id,
      Infusion_Flow_Rate.id,
      Max_Drug_Per_Hour.id,
      Near_Max_Drug_Per_Hour.id,
      Over_Max_Drug_Per_Hour.id
    )
    Max_Drug_Per_Hour_Watcher_imp_pump_operation_operation_process_operation_threads_max_drug_watcher_Bridge.c_operational_api = Some(api)
    api
  }

  val entryPoints : Bridge.EntryPoints =
    Max_Drug_Per_Hour_Watcher_imp_pump_operation_operation_process_operation_threads_max_drug_watcher_Bridge.EntryPoints(
      id,

      Infusion_Flow_Rate.id,
      Max_Drug_Per_Hour.id,
      Near_Max_Drug_Per_Hour.id,
      Over_Max_Drug_Per_Hour.id,

      dispatchTriggers,

      initialization_api,
      operational_api)
}

object Max_Drug_Per_Hour_Watcher_imp_pump_operation_operation_process_operation_threads_max_drug_watcher_Bridge {

  var c_initialization_api: Option[Max_Drug_Per_Hour_Watcher_imp_Initialization_Api] = None()
  var c_operational_api: Option[Max_Drug_Per_Hour_Watcher_imp_Operational_Api] = None()

  @record class EntryPoints(
    Max_Drug_Per_Hour_Watcher_imp_pump_operation_operation_process_operation_threads_max_drug_watcher_BridgeId : Art.BridgeId,

    Infusion_Flow_Rate_Id : Art.PortId,
    Max_Drug_Per_Hour_Id : Art.PortId,
    Near_Max_Drug_Per_Hour_Id : Art.PortId,
    Over_Max_Drug_Per_Hour_Id : Art.PortId,

    dispatchTriggers : Option[ISZ[Art.PortId]],

    initialization_api: Max_Drug_Per_Hour_Watcher_imp_Initialization_Api,
    operational_api: Max_Drug_Per_Hour_Watcher_imp_Operational_Api) extends Bridge.EntryPoints {

    val dataInPortIds: ISZ[Art.PortId] = ISZ(Infusion_Flow_Rate_Id,
                                             Max_Drug_Per_Hour_Id)

    val eventInPortIds: ISZ[Art.PortId] = ISZ()

    val dataOutPortIds: ISZ[Art.PortId] = ISZ()

    val eventOutPortIds: ISZ[Art.PortId] = ISZ(Near_Max_Drug_Per_Hour_Id,
                                               Over_Max_Drug_Per_Hour_Id)

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