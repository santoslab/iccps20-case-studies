// #Sireum

package pca_pump.PCA_Safety

import org.sireum._
import art._
import pca_pump._
import pca_pump.PCA_Safety.{error_detector_imp_pump_safety_error_detect => component}

// This file was auto-generated.  Do not edit

@record class error_detector_imp_pump_safety_error_detect_Bridge(
  val id: Art.BridgeId,
  val name: String,
  val dispatchProtocol: DispatchPropertyProtocol,
  val dispatchTriggers: Option[ISZ[Art.PortId]],

  Software_Stop_Pump: Port[art.Empty],
  Stop_Pump_Completely: Port[art.Empty],
  POST_Failure: Port[art.Empty],
  POST_Done: Port[art.Empty],
  RAM_Failure: Port[art.Empty],
  ROM_failure: Port[art.Empty],
  CPU_Failure: Port[art.Empty],
  Thread_Monitor_Failure: Port[art.Empty],
  HW_Detected_Failure: Port[art.Empty]
  ) extends Bridge {

  val ports : Bridge.Ports = Bridge.Ports(
    all = ISZ(Software_Stop_Pump,
              Stop_Pump_Completely,
              POST_Failure,
              POST_Done,
              RAM_Failure,
              ROM_failure,
              CPU_Failure,
              Thread_Monitor_Failure,
              HW_Detected_Failure),

    dataIns = ISZ(),

    dataOuts = ISZ(),

    eventIns = ISZ(Software_Stop_Pump),

    eventOuts = ISZ(Stop_Pump_Completely,
                    POST_Failure,
                    POST_Done,
                    RAM_Failure,
                    ROM_failure,
                    CPU_Failure,
                    Thread_Monitor_Failure,
                    HW_Detected_Failure)
  )

  val initialization_api : error_detector_imp_Initialization_Api = {
    val api = error_detector_imp_Initialization_Api(
      id,
      Software_Stop_Pump.id,
      Stop_Pump_Completely.id,
      POST_Failure.id,
      POST_Done.id,
      RAM_Failure.id,
      ROM_failure.id,
      CPU_Failure.id,
      Thread_Monitor_Failure.id,
      HW_Detected_Failure.id
    )
    error_detector_imp_pump_safety_error_detect_Bridge.c_initialization_api = Some(api)
    api
  }

  val operational_api : error_detector_imp_Operational_Api = {
    val api = error_detector_imp_Operational_Api(
      id,
      Software_Stop_Pump.id,
      Stop_Pump_Completely.id,
      POST_Failure.id,
      POST_Done.id,
      RAM_Failure.id,
      ROM_failure.id,
      CPU_Failure.id,
      Thread_Monitor_Failure.id,
      HW_Detected_Failure.id
    )
    error_detector_imp_pump_safety_error_detect_Bridge.c_operational_api = Some(api)
    api
  }

  val entryPoints : Bridge.EntryPoints =
    error_detector_imp_pump_safety_error_detect_Bridge.EntryPoints(
      id,

      Software_Stop_Pump.id,
      Stop_Pump_Completely.id,
      POST_Failure.id,
      POST_Done.id,
      RAM_Failure.id,
      ROM_failure.id,
      CPU_Failure.id,
      Thread_Monitor_Failure.id,
      HW_Detected_Failure.id,

      dispatchTriggers,

      initialization_api,
      operational_api)
}

object error_detector_imp_pump_safety_error_detect_Bridge {

  var c_initialization_api: Option[error_detector_imp_Initialization_Api] = None()
  var c_operational_api: Option[error_detector_imp_Operational_Api] = None()

  @record class EntryPoints(
    error_detector_imp_pump_safety_error_detect_BridgeId : Art.BridgeId,

    Software_Stop_Pump_Id : Art.PortId,
    Stop_Pump_Completely_Id : Art.PortId,
    POST_Failure_Id : Art.PortId,
    POST_Done_Id : Art.PortId,
    RAM_Failure_Id : Art.PortId,
    ROM_failure_Id : Art.PortId,
    CPU_Failure_Id : Art.PortId,
    Thread_Monitor_Failure_Id : Art.PortId,
    HW_Detected_Failure_Id : Art.PortId,

    dispatchTriggers : Option[ISZ[Art.PortId]],

    initialization_api: error_detector_imp_Initialization_Api,
    operational_api: error_detector_imp_Operational_Api) extends Bridge.EntryPoints {

    val dataInPortIds: ISZ[Art.PortId] = ISZ()

    val eventInPortIds: ISZ[Art.PortId] = ISZ(Software_Stop_Pump_Id)

    val dataOutPortIds: ISZ[Art.PortId] = ISZ()

    val eventOutPortIds: ISZ[Art.PortId] = ISZ(Stop_Pump_Completely_Id,
                                               POST_Failure_Id,
                                               POST_Done_Id,
                                               RAM_Failure_Id,
                                               ROM_failure_Id,
                                               CPU_Failure_Id,
                                               Thread_Monitor_Failure_Id,
                                               HW_Detected_Failure_Id)

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
      val EventTriggered(receivedEvents) = Art.dispatchStatus(error_detector_imp_pump_safety_error_detect_BridgeId)

      // remove non-dispatching event ports
      val dispatchableEventPorts: ISZ[Art.PortId] =
        if(dispatchTriggers.isEmpty) receivedEvents
        else filter(receivedEvents, dispatchTriggers.get)

      Art.receiveInput(eventInPortIds, dataInPortIds)

      for(portId <- dispatchableEventPorts) {
        if(portId == Software_Stop_Pump_Id) {
          component.handleSoftware_Stop_Pump(operational_api)
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
      val EventTriggered(receivedEvents) = Art.dispatchStatus(error_detector_imp_pump_safety_error_detect_BridgeId)

      // remove non-dispatching event ports
      val dispatchableEventPorts: ISZ[Art.PortId] =
        if(dispatchTriggers.isEmpty) receivedEvents
        else filter(receivedEvents, dispatchTriggers.get)

      Art.receiveInput(eventInPortIds, dataInPortIds)

      for(portId <- dispatchableEventPorts) {
        if(portId == Software_Stop_Pump_Id) {
          component.handleSoftware_Stop_Pump(operational_api)
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