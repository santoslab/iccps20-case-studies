// #Sireum

package pca_pump.PCA_Operation_Threads

import org.sireum._
import art._
import pca_pump._
import pca_pump.PCA_Operation_Threads.{Patient_Bolus_Checker_imp_pump_operation_operation_process_operation_threads_patient_bolus_checker => component}

// This file was auto-generated.  Do not edit

@record class Patient_Bolus_Checker_imp_pump_operation_operation_process_operation_threads_patient_bolus_checker_Bridge(
  val id: Art.BridgeId,
  val name: String,
  val dispatchProtocol: DispatchPropertyProtocol,
  val dispatchTriggers: Option[ISZ[Art.PortId]],

  Minimum_Time_Between_Bolus: Port[ICE_Types.Minute_imp],
  Patient_Button_Request: Port[art.Empty],
  Patient_Request_Not_Too_Soon: Port[art.Empty],
  Patient_Request_Too_Soon: Port[art.Empty]
  ) extends Bridge {

  val ports : Bridge.Ports = Bridge.Ports(
    all = ISZ(Minimum_Time_Between_Bolus,
              Patient_Button_Request,
              Patient_Request_Not_Too_Soon,
              Patient_Request_Too_Soon),

    dataIns = ISZ(Minimum_Time_Between_Bolus),

    dataOuts = ISZ(),

    eventIns = ISZ(Patient_Button_Request),

    eventOuts = ISZ(Patient_Request_Not_Too_Soon,
                    Patient_Request_Too_Soon)
  )

  val initialization_api : Patient_Bolus_Checker_imp_Initialization_Api = {
    val api = Patient_Bolus_Checker_imp_Initialization_Api(
      id,
      Minimum_Time_Between_Bolus.id,
      Patient_Button_Request.id,
      Patient_Request_Not_Too_Soon.id,
      Patient_Request_Too_Soon.id
    )
    Patient_Bolus_Checker_imp_pump_operation_operation_process_operation_threads_patient_bolus_checker_Bridge.c_initialization_api = Some(api)
    api
  }

  val operational_api : Patient_Bolus_Checker_imp_Operational_Api = {
    val api = Patient_Bolus_Checker_imp_Operational_Api(
      id,
      Minimum_Time_Between_Bolus.id,
      Patient_Button_Request.id,
      Patient_Request_Not_Too_Soon.id,
      Patient_Request_Too_Soon.id
    )
    Patient_Bolus_Checker_imp_pump_operation_operation_process_operation_threads_patient_bolus_checker_Bridge.c_operational_api = Some(api)
    api
  }

  val entryPoints : Bridge.EntryPoints =
    Patient_Bolus_Checker_imp_pump_operation_operation_process_operation_threads_patient_bolus_checker_Bridge.EntryPoints(
      id,

      Minimum_Time_Between_Bolus.id,
      Patient_Button_Request.id,
      Patient_Request_Not_Too_Soon.id,
      Patient_Request_Too_Soon.id,

      dispatchTriggers,

      initialization_api,
      operational_api)
}

object Patient_Bolus_Checker_imp_pump_operation_operation_process_operation_threads_patient_bolus_checker_Bridge {

  var c_initialization_api: Option[Patient_Bolus_Checker_imp_Initialization_Api] = None()
  var c_operational_api: Option[Patient_Bolus_Checker_imp_Operational_Api] = None()

  @record class EntryPoints(
    Patient_Bolus_Checker_imp_pump_operation_operation_process_operation_threads_patient_bolus_checker_BridgeId : Art.BridgeId,

    Minimum_Time_Between_Bolus_Id : Art.PortId,
    Patient_Button_Request_Id : Art.PortId,
    Patient_Request_Not_Too_Soon_Id : Art.PortId,
    Patient_Request_Too_Soon_Id : Art.PortId,

    dispatchTriggers : Option[ISZ[Art.PortId]],

    initialization_api: Patient_Bolus_Checker_imp_Initialization_Api,
    operational_api: Patient_Bolus_Checker_imp_Operational_Api) extends Bridge.EntryPoints {

    val dataInPortIds: ISZ[Art.PortId] = ISZ(Minimum_Time_Between_Bolus_Id)

    val eventInPortIds: ISZ[Art.PortId] = ISZ(Patient_Button_Request_Id)

    val dataOutPortIds: ISZ[Art.PortId] = ISZ()

    val eventOutPortIds: ISZ[Art.PortId] = ISZ(Patient_Request_Not_Too_Soon_Id,
                                               Patient_Request_Too_Soon_Id)

    def compute(): Unit = {
      // transpiler friendly filter
      def filter(receivedEvents: ISZ[Art.PortId], triggers: ISZ[Art.PortId]): ISZ[Art.PortId] = {
        var r = ISZ[Art.PortId]()
        val opsTriggers = ops.ISZOps(triggers)
        for(e <- receivedEvents) {
          if(opsTriggers.contains(e)) {
            r = r :+ e
          }
        }
        return r
      }

      // fetch received events ordered by highest urgency then earliest arrival-time
      val EventTriggered(receivedEvents) = Art.dispatchStatus(Patient_Bolus_Checker_imp_pump_operation_operation_process_operation_threads_patient_bolus_checker_BridgeId)

      // remove non-dispatching event ports
      val dispatchableEventPorts: ISZ[Art.PortId] =
        if(dispatchTriggers.isEmpty) receivedEvents
        else filter(receivedEvents, dispatchTriggers.get)

      Art.receiveInput(eventInPortIds, dataInPortIds)

      for(portId <- dispatchableEventPorts) {
        if(portId == Patient_Button_Request_Id) {
          component.handlePatient_Button_Request(operational_api)
        }
      }

      Art.sendOutput(eventOutPortIds, dataOutPortIds)
    }

    override
    def testCompute(): Unit = {
      // transpiler friendly filter
      def filter(receivedEvents: ISZ[Art.PortId], triggers: ISZ[Art.PortId]): ISZ[Art.PortId] = {
        var r = ISZ[Art.PortId]()
        val opsTriggers = ops.ISZOps(triggers)
        for(e <- receivedEvents) {
          if(opsTriggers.contains(e)) {
            r = r :+ e
          }
        }
        return r
      }

      // fetch received events ordered by highest urgency then earliest arrival-time
      val EventTriggered(receivedEvents) = Art.dispatchStatus(Patient_Bolus_Checker_imp_pump_operation_operation_process_operation_threads_patient_bolus_checker_BridgeId)

      // remove non-dispatching event ports
      val dispatchableEventPorts: ISZ[Art.PortId] =
        if(dispatchTriggers.isEmpty) receivedEvents
        else filter(receivedEvents, dispatchTriggers.get)

      Art.receiveInput(eventInPortIds, dataInPortIds)

      for(portId <- dispatchableEventPorts) {
        if(portId == Patient_Button_Request_Id) {
          component.handlePatient_Button_Request(operational_api)
        }
      }

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