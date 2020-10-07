// #Sireum

package pca_pump.PCA_Operation

import org.sireum._
import art._
import pca_pump._
import pca_pump.PCA_Operation.{event_logger_thread_imp_pump_operation_operation_process_event_logger => component}

// This file was auto-generated.  Do not edit

@record class event_logger_thread_imp_pump_operation_operation_process_event_logger_Bridge(
  val id: Art.BridgeId,
  val name: String,
  val dispatchProtocol: DispatchPropertyProtocol,
  val dispatchTriggers: Option[ISZ[Art.PortId]],

  Log_Event: Port[PCA_Types.Event_Record],
  The_Event_Log: Port[PCA_Types.Event_Log],
  Get_Event_Log: Port[art.Empty]
  ) extends Bridge {

  val ports : Bridge.Ports = Bridge.Ports(
    all = ISZ(Log_Event,
              The_Event_Log,
              Get_Event_Log),

    dataIns = ISZ(),

    dataOuts = ISZ(),

    eventIns = ISZ(Log_Event,
                   Get_Event_Log),

    eventOuts = ISZ(The_Event_Log)
  )

  val initialization_api : event_logger_thread_imp_Initialization_Api = {
    val api = event_logger_thread_imp_Initialization_Api(
      id,
      Log_Event.id,
      The_Event_Log.id,
      Get_Event_Log.id
    )
    event_logger_thread_imp_pump_operation_operation_process_event_logger_Bridge.c_initialization_api = Some(api)
    api
  }

  val operational_api : event_logger_thread_imp_Operational_Api = {
    val api = event_logger_thread_imp_Operational_Api(
      id,
      Log_Event.id,
      The_Event_Log.id,
      Get_Event_Log.id
    )
    event_logger_thread_imp_pump_operation_operation_process_event_logger_Bridge.c_operational_api = Some(api)
    api
  }

  val entryPoints : Bridge.EntryPoints =
    event_logger_thread_imp_pump_operation_operation_process_event_logger_Bridge.EntryPoints(
      id,

      Log_Event.id,
      The_Event_Log.id,
      Get_Event_Log.id,

      dispatchTriggers,

      initialization_api,
      operational_api)
}

object event_logger_thread_imp_pump_operation_operation_process_event_logger_Bridge {

  var c_initialization_api: Option[event_logger_thread_imp_Initialization_Api] = None()
  var c_operational_api: Option[event_logger_thread_imp_Operational_Api] = None()

  @record class EntryPoints(
    event_logger_thread_imp_pump_operation_operation_process_event_logger_BridgeId : Art.BridgeId,

    Log_Event_Id : Art.PortId,
    The_Event_Log_Id : Art.PortId,
    Get_Event_Log_Id : Art.PortId,

    dispatchTriggers : Option[ISZ[Art.PortId]],

    initialization_api: event_logger_thread_imp_Initialization_Api,
    operational_api: event_logger_thread_imp_Operational_Api) extends Bridge.EntryPoints {

    val dataInPortIds: ISZ[Art.PortId] = ISZ()

    val eventInPortIds: ISZ[Art.PortId] = ISZ(Log_Event_Id,
                                              Get_Event_Log_Id)

    val dataOutPortIds: ISZ[Art.PortId] = ISZ()

    val eventOutPortIds: ISZ[Art.PortId] = ISZ(The_Event_Log_Id)

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
      val EventTriggered(receivedEvents) = Art.dispatchStatus(event_logger_thread_imp_pump_operation_operation_process_event_logger_BridgeId)

      // remove non-dispatching event ports
      val dispatchableEventPorts: ISZ[Art.PortId] =
        if(dispatchTriggers.isEmpty) receivedEvents
        else filter(receivedEvents, dispatchTriggers.get)

      Art.receiveInput(eventInPortIds, dataInPortIds)

      for(portId <- dispatchableEventPorts) {
        if(portId == Log_Event_Id){
          val Some(PCA_Types.Event_Record_Payload(value)) = Art.getValue(Log_Event_Id)
          component.handleLog_Event(operational_api, value)
        }
        else if(portId == Get_Event_Log_Id) {
          component.handleGet_Event_Log(operational_api)
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
      val EventTriggered(receivedEvents) = Art.dispatchStatus(event_logger_thread_imp_pump_operation_operation_process_event_logger_BridgeId)

      // remove non-dispatching event ports
      val dispatchableEventPorts: ISZ[Art.PortId] =
        if(dispatchTriggers.isEmpty) receivedEvents
        else filter(receivedEvents, dispatchTriggers.get)

      Art.receiveInput(eventInPortIds, dataInPortIds)

      for(portId <- dispatchableEventPorts) {
        if(portId == Log_Event_Id){
          val Some(PCA_Types.Event_Record_Payload(value)) = Art.getValue(Log_Event_Id)
          component.handleLog_Event(operational_api, value)
        }
        else if(portId == Get_Event_Log_Id) {
          component.handleGet_Event_Log(operational_api)
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