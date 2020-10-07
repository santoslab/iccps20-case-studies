// #Sireum

package pca_pump.PCA_Safety

import org.sireum._
import art._
import pca_pump._
import pca_pump.PCA_Safety.{fault_logger_imp_pump_safety_fault_log => component}

// This file was auto-generated.  Do not edit

@record class fault_logger_imp_pump_safety_fault_log_Bridge(
  val id: Art.BridgeId,
  val name: String,
  val dispatchProtocol: DispatchPropertyProtocol,
  val dispatchTriggers: Option[ISZ[Art.PortId]],

  Log_Fault: Port[PCA_Types.Fault_Record_imp],
  The_Log: Port[PCA_Types.Fault_Log],
  Get_Log: Port[art.Empty],
  POST_Failure: Port[art.Empty],
  RAM_Failure: Port[art.Empty],
  ROM_Failure: Port[art.Empty],
  CPU_Failure: Port[art.Empty],
  Thread_Monitor_Failure: Port[art.Empty],
  Voltage_OOR: Port[art.Empty]
  ) extends Bridge {

  val ports : Bridge.Ports = Bridge.Ports(
    all = ISZ(Log_Fault,
              The_Log,
              Get_Log,
              POST_Failure,
              RAM_Failure,
              ROM_Failure,
              CPU_Failure,
              Thread_Monitor_Failure,
              Voltage_OOR),

    dataIns = ISZ(),

    dataOuts = ISZ(),

    eventIns = ISZ(Log_Fault,
                   Get_Log,
                   POST_Failure,
                   RAM_Failure,
                   ROM_Failure,
                   CPU_Failure,
                   Thread_Monitor_Failure,
                   Voltage_OOR),

    eventOuts = ISZ(The_Log)
  )

  val initialization_api : fault_logger_imp_Initialization_Api = {
    val api = fault_logger_imp_Initialization_Api(
      id,
      Log_Fault.id,
      The_Log.id,
      Get_Log.id,
      POST_Failure.id,
      RAM_Failure.id,
      ROM_Failure.id,
      CPU_Failure.id,
      Thread_Monitor_Failure.id,
      Voltage_OOR.id
    )
    fault_logger_imp_pump_safety_fault_log_Bridge.c_initialization_api = Some(api)
    api
  }

  val operational_api : fault_logger_imp_Operational_Api = {
    val api = fault_logger_imp_Operational_Api(
      id,
      Log_Fault.id,
      The_Log.id,
      Get_Log.id,
      POST_Failure.id,
      RAM_Failure.id,
      ROM_Failure.id,
      CPU_Failure.id,
      Thread_Monitor_Failure.id,
      Voltage_OOR.id
    )
    fault_logger_imp_pump_safety_fault_log_Bridge.c_operational_api = Some(api)
    api
  }

  val entryPoints : Bridge.EntryPoints =
    fault_logger_imp_pump_safety_fault_log_Bridge.EntryPoints(
      id,

      Log_Fault.id,
      The_Log.id,
      Get_Log.id,
      POST_Failure.id,
      RAM_Failure.id,
      ROM_Failure.id,
      CPU_Failure.id,
      Thread_Monitor_Failure.id,
      Voltage_OOR.id,

      dispatchTriggers,

      initialization_api,
      operational_api)
}

object fault_logger_imp_pump_safety_fault_log_Bridge {

  var c_initialization_api: Option[fault_logger_imp_Initialization_Api] = None()
  var c_operational_api: Option[fault_logger_imp_Operational_Api] = None()

  @record class EntryPoints(
    fault_logger_imp_pump_safety_fault_log_BridgeId : Art.BridgeId,

    Log_Fault_Id : Art.PortId,
    The_Log_Id : Art.PortId,
    Get_Log_Id : Art.PortId,
    POST_Failure_Id : Art.PortId,
    RAM_Failure_Id : Art.PortId,
    ROM_Failure_Id : Art.PortId,
    CPU_Failure_Id : Art.PortId,
    Thread_Monitor_Failure_Id : Art.PortId,
    Voltage_OOR_Id : Art.PortId,

    dispatchTriggers : Option[ISZ[Art.PortId]],

    initialization_api: fault_logger_imp_Initialization_Api,
    operational_api: fault_logger_imp_Operational_Api) extends Bridge.EntryPoints {

    val dataInPortIds: ISZ[Art.PortId] = ISZ()

    val eventInPortIds: ISZ[Art.PortId] = ISZ(Log_Fault_Id,
                                              Get_Log_Id,
                                              POST_Failure_Id,
                                              RAM_Failure_Id,
                                              ROM_Failure_Id,
                                              CPU_Failure_Id,
                                              Thread_Monitor_Failure_Id,
                                              Voltage_OOR_Id)

    val dataOutPortIds: ISZ[Art.PortId] = ISZ()

    val eventOutPortIds: ISZ[Art.PortId] = ISZ(The_Log_Id)

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
      val EventTriggered(receivedEvents) = Art.dispatchStatus(fault_logger_imp_pump_safety_fault_log_BridgeId)

      // remove non-dispatching event ports
      val dispatchableEventPorts: ISZ[Art.PortId] =
        if(dispatchTriggers.isEmpty) receivedEvents
        else filter(receivedEvents, dispatchTriggers.get)

      Art.receiveInput(eventInPortIds, dataInPortIds)

      for(portId <- dispatchableEventPorts) {
        if(portId == Log_Fault_Id){
          val Some(PCA_Types.Fault_Record_imp_Payload(value)) = Art.getValue(Log_Fault_Id)
          component.handleLog_Fault(operational_api, value)
        }
        else if(portId == Get_Log_Id) {
          component.handleGet_Log(operational_api)
        }
        else if(portId == POST_Failure_Id) {
          component.handlePOST_Failure(operational_api)
        }
        else if(portId == RAM_Failure_Id) {
          component.handleRAM_Failure(operational_api)
        }
        else if(portId == ROM_Failure_Id) {
          component.handleROM_Failure(operational_api)
        }
        else if(portId == CPU_Failure_Id) {
          component.handleCPU_Failure(operational_api)
        }
        else if(portId == Thread_Monitor_Failure_Id) {
          component.handleThread_Monitor_Failure(operational_api)
        }
        else if(portId == Voltage_OOR_Id) {
          component.handleVoltage_OOR(operational_api)
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
      val EventTriggered(receivedEvents) = Art.dispatchStatus(fault_logger_imp_pump_safety_fault_log_BridgeId)

      // remove non-dispatching event ports
      val dispatchableEventPorts: ISZ[Art.PortId] =
        if(dispatchTriggers.isEmpty) receivedEvents
        else filter(receivedEvents, dispatchTriggers.get)

      Art.receiveInput(eventInPortIds, dataInPortIds)

      for(portId <- dispatchableEventPorts) {
        if(portId == Log_Fault_Id){
          val Some(PCA_Types.Fault_Record_imp_Payload(value)) = Art.getValue(Log_Fault_Id)
          component.handleLog_Fault(operational_api, value)
        }
        else if(portId == Get_Log_Id) {
          component.handleGet_Log(operational_api)
        }
        else if(portId == POST_Failure_Id) {
          component.handlePOST_Failure(operational_api)
        }
        else if(portId == RAM_Failure_Id) {
          component.handleRAM_Failure(operational_api)
        }
        else if(portId == ROM_Failure_Id) {
          component.handleROM_Failure(operational_api)
        }
        else if(portId == CPU_Failure_Id) {
          component.handleCPU_Failure(operational_api)
        }
        else if(portId == Thread_Monitor_Failure_Id) {
          component.handleThread_Monitor_Failure(operational_api)
        }
        else if(portId == Voltage_OOR_Id) {
          component.handleVoltage_OOR(operational_api)
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