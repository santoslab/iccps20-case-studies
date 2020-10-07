// #Sireum

package pca_pump.PCA_Alarm

import org.sireum._
import art._
import pca_pump._
import pca_pump.PCA_Alarm.{alarm_thread_imp_pump_safety_alarm_process_alarm_thr => component}

// This file was auto-generated.  Do not edit

@record class alarm_thread_imp_pump_safety_alarm_process_alarm_thr_Bridge(
  val id: Art.BridgeId,
  val name: String,
  val dispatchProtocol: DispatchPropertyProtocol,
  val dispatchTriggers: Option[ISZ[Art.PortId]],

  Alarm: Port[PCA_Types.Alarm_Type.Type],
  Warning: Port[PCA_Types.Warning_Type.Type],
  ICE_Alarm_Signal: Port[ICE_Types.Alarm_Signal.Type],
  Log_Fault: Port[PCA_Types.Fault_Record_imp],
  ICE_Immediate: Port[art.Empty],
  ICE_Prompt: Port[art.Empty],
  ICE_Delayed: Port[art.Empty],
  ICE_Malfunction: Port[art.Empty],
  ICE_Reset_Alarm: Port[art.Empty],
  Stop_Pump_Completely: Port[art.Empty],
  Pump_At_KVO_Rate: Port[art.Empty],
  Max_Dose_Warning: Port[art.Empty],
  Hard_Limit_Violation: Port[art.Empty],
  Empty_Res: Port[art.Empty],
  Low_Res: Port[art.Empty],
  Pump_Hot: Port[art.Empty],
  Upstream_Occlusion: Port[art.Empty],
  Downstream_Occlusion: Port[art.Empty],
  Bubble: Port[art.Empty],
  Prime_Failure: Port[art.Empty],
  CP_Reset_Alarm: Port[art.Empty],
  Drug_Not_In_Library: Port[art.Empty],
  Defective_Btty: Port[art.Empty],
  Low_Battery_Warning: Port[art.Empty],
  Voltage_OOR: Port[art.Empty],
  Basal_Overinfusion: Port[art.Empty],
  Bolus_Overinfusion: Port[art.Empty],
  Square_Bolus_Overinfusion: Port[art.Empty],
  Basal_Underinfusion: Port[art.Empty],
  Bolus_Underinfusion: Port[art.Empty],
  Square_Bolus_Underinfusion: Port[art.Empty],
  Security_Fault: Port[art.Empty]
  ) extends Bridge {

  val ports : Bridge.Ports = Bridge.Ports(
    all = ISZ(Alarm,
              Warning,
              ICE_Alarm_Signal,
              Log_Fault,
              ICE_Immediate,
              ICE_Prompt,
              ICE_Delayed,
              ICE_Malfunction,
              ICE_Reset_Alarm,
              Stop_Pump_Completely,
              Pump_At_KVO_Rate,
              Max_Dose_Warning,
              Hard_Limit_Violation,
              Empty_Res,
              Low_Res,
              Pump_Hot,
              Upstream_Occlusion,
              Downstream_Occlusion,
              Bubble,
              Prime_Failure,
              CP_Reset_Alarm,
              Drug_Not_In_Library,
              Defective_Btty,
              Low_Battery_Warning,
              Voltage_OOR,
              Basal_Overinfusion,
              Bolus_Overinfusion,
              Square_Bolus_Overinfusion,
              Basal_Underinfusion,
              Bolus_Underinfusion,
              Square_Bolus_Underinfusion,
              Security_Fault),

    dataIns = ISZ(),

    dataOuts = ISZ(),

    eventIns = ISZ(ICE_Alarm_Signal,
                   ICE_Reset_Alarm,
                   Max_Dose_Warning,
                   Hard_Limit_Violation,
                   Empty_Res,
                   Low_Res,
                   Pump_Hot,
                   Upstream_Occlusion,
                   Downstream_Occlusion,
                   Bubble,
                   Prime_Failure,
                   CP_Reset_Alarm,
                   Drug_Not_In_Library,
                   Defective_Btty,
                   Low_Battery_Warning,
                   Voltage_OOR,
                   Basal_Overinfusion,
                   Bolus_Overinfusion,
                   Square_Bolus_Overinfusion,
                   Basal_Underinfusion,
                   Bolus_Underinfusion,
                   Square_Bolus_Underinfusion,
                   Security_Fault),

    eventOuts = ISZ(Alarm,
                    Warning,
                    Log_Fault,
                    ICE_Immediate,
                    ICE_Prompt,
                    ICE_Delayed,
                    ICE_Malfunction,
                    Stop_Pump_Completely,
                    Pump_At_KVO_Rate)
  )

  val initialization_api : alarm_thread_imp_Initialization_Api = {
    val api = alarm_thread_imp_Initialization_Api(
      id,
      Alarm.id,
      Warning.id,
      ICE_Alarm_Signal.id,
      Log_Fault.id,
      ICE_Immediate.id,
      ICE_Prompt.id,
      ICE_Delayed.id,
      ICE_Malfunction.id,
      ICE_Reset_Alarm.id,
      Stop_Pump_Completely.id,
      Pump_At_KVO_Rate.id,
      Max_Dose_Warning.id,
      Hard_Limit_Violation.id,
      Empty_Res.id,
      Low_Res.id,
      Pump_Hot.id,
      Upstream_Occlusion.id,
      Downstream_Occlusion.id,
      Bubble.id,
      Prime_Failure.id,
      CP_Reset_Alarm.id,
      Drug_Not_In_Library.id,
      Defective_Btty.id,
      Low_Battery_Warning.id,
      Voltage_OOR.id,
      Basal_Overinfusion.id,
      Bolus_Overinfusion.id,
      Square_Bolus_Overinfusion.id,
      Basal_Underinfusion.id,
      Bolus_Underinfusion.id,
      Square_Bolus_Underinfusion.id,
      Security_Fault.id
    )
    alarm_thread_imp_pump_safety_alarm_process_alarm_thr_Bridge.c_initialization_api = Some(api)
    api
  }

  val operational_api : alarm_thread_imp_Operational_Api = {
    val api = alarm_thread_imp_Operational_Api(
      id,
      Alarm.id,
      Warning.id,
      ICE_Alarm_Signal.id,
      Log_Fault.id,
      ICE_Immediate.id,
      ICE_Prompt.id,
      ICE_Delayed.id,
      ICE_Malfunction.id,
      ICE_Reset_Alarm.id,
      Stop_Pump_Completely.id,
      Pump_At_KVO_Rate.id,
      Max_Dose_Warning.id,
      Hard_Limit_Violation.id,
      Empty_Res.id,
      Low_Res.id,
      Pump_Hot.id,
      Upstream_Occlusion.id,
      Downstream_Occlusion.id,
      Bubble.id,
      Prime_Failure.id,
      CP_Reset_Alarm.id,
      Drug_Not_In_Library.id,
      Defective_Btty.id,
      Low_Battery_Warning.id,
      Voltage_OOR.id,
      Basal_Overinfusion.id,
      Bolus_Overinfusion.id,
      Square_Bolus_Overinfusion.id,
      Basal_Underinfusion.id,
      Bolus_Underinfusion.id,
      Square_Bolus_Underinfusion.id,
      Security_Fault.id
    )
    alarm_thread_imp_pump_safety_alarm_process_alarm_thr_Bridge.c_operational_api = Some(api)
    api
  }

  val entryPoints : Bridge.EntryPoints =
    alarm_thread_imp_pump_safety_alarm_process_alarm_thr_Bridge.EntryPoints(
      id,

      Alarm.id,
      Warning.id,
      ICE_Alarm_Signal.id,
      Log_Fault.id,
      ICE_Immediate.id,
      ICE_Prompt.id,
      ICE_Delayed.id,
      ICE_Malfunction.id,
      ICE_Reset_Alarm.id,
      Stop_Pump_Completely.id,
      Pump_At_KVO_Rate.id,
      Max_Dose_Warning.id,
      Hard_Limit_Violation.id,
      Empty_Res.id,
      Low_Res.id,
      Pump_Hot.id,
      Upstream_Occlusion.id,
      Downstream_Occlusion.id,
      Bubble.id,
      Prime_Failure.id,
      CP_Reset_Alarm.id,
      Drug_Not_In_Library.id,
      Defective_Btty.id,
      Low_Battery_Warning.id,
      Voltage_OOR.id,
      Basal_Overinfusion.id,
      Bolus_Overinfusion.id,
      Square_Bolus_Overinfusion.id,
      Basal_Underinfusion.id,
      Bolus_Underinfusion.id,
      Square_Bolus_Underinfusion.id,
      Security_Fault.id,

      dispatchTriggers,

      initialization_api,
      operational_api)
}

object alarm_thread_imp_pump_safety_alarm_process_alarm_thr_Bridge {

  var c_initialization_api: Option[alarm_thread_imp_Initialization_Api] = None()
  var c_operational_api: Option[alarm_thread_imp_Operational_Api] = None()

  @record class EntryPoints(
    alarm_thread_imp_pump_safety_alarm_process_alarm_thr_BridgeId : Art.BridgeId,

    Alarm_Id : Art.PortId,
    Warning_Id : Art.PortId,
    ICE_Alarm_Signal_Id : Art.PortId,
    Log_Fault_Id : Art.PortId,
    ICE_Immediate_Id : Art.PortId,
    ICE_Prompt_Id : Art.PortId,
    ICE_Delayed_Id : Art.PortId,
    ICE_Malfunction_Id : Art.PortId,
    ICE_Reset_Alarm_Id : Art.PortId,
    Stop_Pump_Completely_Id : Art.PortId,
    Pump_At_KVO_Rate_Id : Art.PortId,
    Max_Dose_Warning_Id : Art.PortId,
    Hard_Limit_Violation_Id : Art.PortId,
    Empty_Res_Id : Art.PortId,
    Low_Res_Id : Art.PortId,
    Pump_Hot_Id : Art.PortId,
    Upstream_Occlusion_Id : Art.PortId,
    Downstream_Occlusion_Id : Art.PortId,
    Bubble_Id : Art.PortId,
    Prime_Failure_Id : Art.PortId,
    CP_Reset_Alarm_Id : Art.PortId,
    Drug_Not_In_Library_Id : Art.PortId,
    Defective_Btty_Id : Art.PortId,
    Low_Battery_Warning_Id : Art.PortId,
    Voltage_OOR_Id : Art.PortId,
    Basal_Overinfusion_Id : Art.PortId,
    Bolus_Overinfusion_Id : Art.PortId,
    Square_Bolus_Overinfusion_Id : Art.PortId,
    Basal_Underinfusion_Id : Art.PortId,
    Bolus_Underinfusion_Id : Art.PortId,
    Square_Bolus_Underinfusion_Id : Art.PortId,
    Security_Fault_Id : Art.PortId,

    dispatchTriggers : Option[ISZ[Art.PortId]],

    initialization_api: alarm_thread_imp_Initialization_Api,
    operational_api: alarm_thread_imp_Operational_Api) extends Bridge.EntryPoints {

    val dataInPortIds: ISZ[Art.PortId] = ISZ()

    val eventInPortIds: ISZ[Art.PortId] = ISZ(ICE_Alarm_Signal_Id,
                                              ICE_Reset_Alarm_Id,
                                              Max_Dose_Warning_Id,
                                              Hard_Limit_Violation_Id,
                                              Empty_Res_Id,
                                              Low_Res_Id,
                                              Pump_Hot_Id,
                                              Upstream_Occlusion_Id,
                                              Downstream_Occlusion_Id,
                                              Bubble_Id,
                                              Prime_Failure_Id,
                                              CP_Reset_Alarm_Id,
                                              Drug_Not_In_Library_Id,
                                              Defective_Btty_Id,
                                              Low_Battery_Warning_Id,
                                              Voltage_OOR_Id,
                                              Basal_Overinfusion_Id,
                                              Bolus_Overinfusion_Id,
                                              Square_Bolus_Overinfusion_Id,
                                              Basal_Underinfusion_Id,
                                              Bolus_Underinfusion_Id,
                                              Square_Bolus_Underinfusion_Id,
                                              Security_Fault_Id)

    val dataOutPortIds: ISZ[Art.PortId] = ISZ()

    val eventOutPortIds: ISZ[Art.PortId] = ISZ(Alarm_Id,
                                               Warning_Id,
                                               Log_Fault_Id,
                                               ICE_Immediate_Id,
                                               ICE_Prompt_Id,
                                               ICE_Delayed_Id,
                                               ICE_Malfunction_Id,
                                               Stop_Pump_Completely_Id,
                                               Pump_At_KVO_Rate_Id)

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
      val EventTriggered(receivedEvents) = Art.dispatchStatus(alarm_thread_imp_pump_safety_alarm_process_alarm_thr_BridgeId)

      // remove non-dispatching event ports
      val dispatchableEventPorts: ISZ[Art.PortId] =
        if(dispatchTriggers.isEmpty) receivedEvents
        else filter(receivedEvents, dispatchTriggers.get)

      Art.receiveInput(eventInPortIds, dataInPortIds)

      for(portId <- dispatchableEventPorts) {
        if(portId == ICE_Alarm_Signal_Id){
          val Some(ICE_Types.Alarm_Signal_Payload(value)) = Art.getValue(ICE_Alarm_Signal_Id)
          component.handleICE_Alarm_Signal(operational_api, value)
        }
        else if(portId == ICE_Reset_Alarm_Id) {
          component.handleICE_Reset_Alarm(operational_api)
        }
        else if(portId == Max_Dose_Warning_Id) {
          component.handleMax_Dose_Warning(operational_api)
        }
        else if(portId == Hard_Limit_Violation_Id) {
          component.handleHard_Limit_Violation(operational_api)
        }
        else if(portId == Empty_Res_Id) {
          component.handleEmpty_Res(operational_api)
        }
        else if(portId == Low_Res_Id) {
          component.handleLow_Res(operational_api)
        }
        else if(portId == Pump_Hot_Id) {
          component.handlePump_Hot(operational_api)
        }
        else if(portId == Upstream_Occlusion_Id) {
          component.handleUpstream_Occlusion(operational_api)
        }
        else if(portId == Downstream_Occlusion_Id) {
          component.handleDownstream_Occlusion(operational_api)
        }
        else if(portId == Bubble_Id) {
          component.handleBubble(operational_api)
        }
        else if(portId == Prime_Failure_Id) {
          component.handlePrime_Failure(operational_api)
        }
        else if(portId == CP_Reset_Alarm_Id) {
          component.handleCP_Reset_Alarm(operational_api)
        }
        else if(portId == Drug_Not_In_Library_Id) {
          component.handleDrug_Not_In_Library(operational_api)
        }
        else if(portId == Defective_Btty_Id) {
          component.handleDefective_Btty(operational_api)
        }
        else if(portId == Low_Battery_Warning_Id) {
          component.handleLow_Battery_Warning(operational_api)
        }
        else if(portId == Voltage_OOR_Id) {
          component.handleVoltage_OOR(operational_api)
        }
        else if(portId == Basal_Overinfusion_Id) {
          component.handleBasal_Overinfusion(operational_api)
        }
        else if(portId == Bolus_Overinfusion_Id) {
          component.handleBolus_Overinfusion(operational_api)
        }
        else if(portId == Square_Bolus_Overinfusion_Id) {
          component.handleSquare_Bolus_Overinfusion(operational_api)
        }
        else if(portId == Basal_Underinfusion_Id) {
          component.handleBasal_Underinfusion(operational_api)
        }
        else if(portId == Bolus_Underinfusion_Id) {
          component.handleBolus_Underinfusion(operational_api)
        }
        else if(portId == Square_Bolus_Underinfusion_Id) {
          component.handleSquare_Bolus_Underinfusion(operational_api)
        }
        else if(portId == Security_Fault_Id) {
          component.handleSecurity_Fault(operational_api)
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
      val EventTriggered(receivedEvents) = Art.dispatchStatus(alarm_thread_imp_pump_safety_alarm_process_alarm_thr_BridgeId)

      // remove non-dispatching event ports
      val dispatchableEventPorts: ISZ[Art.PortId] =
        if(dispatchTriggers.isEmpty) receivedEvents
        else filter(receivedEvents, dispatchTriggers.get)

      Art.receiveInput(eventInPortIds, dataInPortIds)

      for(portId <- dispatchableEventPorts) {
        if(portId == ICE_Alarm_Signal_Id){
          val Some(ICE_Types.Alarm_Signal_Payload(value)) = Art.getValue(ICE_Alarm_Signal_Id)
          component.handleICE_Alarm_Signal(operational_api, value)
        }
        else if(portId == ICE_Reset_Alarm_Id) {
          component.handleICE_Reset_Alarm(operational_api)
        }
        else if(portId == Max_Dose_Warning_Id) {
          component.handleMax_Dose_Warning(operational_api)
        }
        else if(portId == Hard_Limit_Violation_Id) {
          component.handleHard_Limit_Violation(operational_api)
        }
        else if(portId == Empty_Res_Id) {
          component.handleEmpty_Res(operational_api)
        }
        else if(portId == Low_Res_Id) {
          component.handleLow_Res(operational_api)
        }
        else if(portId == Pump_Hot_Id) {
          component.handlePump_Hot(operational_api)
        }
        else if(portId == Upstream_Occlusion_Id) {
          component.handleUpstream_Occlusion(operational_api)
        }
        else if(portId == Downstream_Occlusion_Id) {
          component.handleDownstream_Occlusion(operational_api)
        }
        else if(portId == Bubble_Id) {
          component.handleBubble(operational_api)
        }
        else if(portId == Prime_Failure_Id) {
          component.handlePrime_Failure(operational_api)
        }
        else if(portId == CP_Reset_Alarm_Id) {
          component.handleCP_Reset_Alarm(operational_api)
        }
        else if(portId == Drug_Not_In_Library_Id) {
          component.handleDrug_Not_In_Library(operational_api)
        }
        else if(portId == Defective_Btty_Id) {
          component.handleDefective_Btty(operational_api)
        }
        else if(portId == Low_Battery_Warning_Id) {
          component.handleLow_Battery_Warning(operational_api)
        }
        else if(portId == Voltage_OOR_Id) {
          component.handleVoltage_OOR(operational_api)
        }
        else if(portId == Basal_Overinfusion_Id) {
          component.handleBasal_Overinfusion(operational_api)
        }
        else if(portId == Bolus_Overinfusion_Id) {
          component.handleBolus_Overinfusion(operational_api)
        }
        else if(portId == Square_Bolus_Overinfusion_Id) {
          component.handleSquare_Bolus_Overinfusion(operational_api)
        }
        else if(portId == Basal_Underinfusion_Id) {
          component.handleBasal_Underinfusion(operational_api)
        }
        else if(portId == Bolus_Underinfusion_Id) {
          component.handleBolus_Underinfusion(operational_api)
        }
        else if(portId == Square_Bolus_Underinfusion_Id) {
          component.handleSquare_Bolus_Underinfusion(operational_api)
        }
        else if(portId == Security_Fault_Id) {
          component.handleSecurity_Fault(operational_api)
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