// #Sireum

package pca_pump.PCA_Operation_Threads

import org.sireum._
import art._
import pca_pump._
import pca_pump.PCA_Operation_Threads.{ICE_Thread_imp_pump_operation_operation_process_operation_threads_ice_thread => component}

// This file was auto-generated.  Do not edit

@record class ICE_Thread_imp_pump_operation_operation_process_operation_threads_ice_thread_Bridge(
  val id: Art.BridgeId,
  val name: String,
  val dispatchProtocol: DispatchPropertyProtocol,
  val dispatchTriggers: Option[ISZ[Art.PortId]],

  Infusion_Flow_Rate: Port[PCA_Types.Flow_Rate_imp],
  Patient_Bolus_Rate: Port[PCA_Types.Flow_Rate_imp],
  Square_Bolus_Rate: Port[PCA_Types.Flow_Rate_imp],
  Basal_Rate: Port[PCA_Types.Flow_Rate_imp],
  VTBI: Port[PCA_Types.Drug_Volume_imp],
  Door_Open: Port[Base_Types.Boolean],
  Alarm_Inactivation: Port[ICE_Types.Alarm_Signal.Type],
  Alarm: Port[PCA_Types.Alarm_Type.Type],
  Warning: Port[PCA_Types.Warning_Type.Type],
  CP_Bolus_Duration: Port[ICE_Types.Minute_imp],
  ICE_Stop_Pump: Port[art.Empty],
  Rx_Okay: Port[art.Empty],
  Patient_Request_Not_Too_Soon: Port[art.Empty],
  Patient_Request_Too_Soon: Port[art.Empty],
  HW_Detected_Failure: Port[art.Empty],
  Stop_Pump_Completely: Port[art.Empty],
  Pump_At_KVO_Rate: Port[art.Empty],
  CP_Clinician_Request_Bolus: Port[art.Empty],
  Halt_Infusion: Port[art.Empty],
  Begin_Infusion: Port[art.Empty],
  Near_Max_Drug_Per_Hour: Port[art.Empty],
  Over_Max_Drug_Per_Hour: Port[art.Empty]
  ) extends Bridge {

  val ports : Bridge.Ports = Bridge.Ports(
    all = ISZ(Infusion_Flow_Rate,
              Patient_Bolus_Rate,
              Square_Bolus_Rate,
              Basal_Rate,
              VTBI,
              Door_Open,
              Alarm_Inactivation,
              Alarm,
              Warning,
              CP_Bolus_Duration,
              ICE_Stop_Pump,
              Rx_Okay,
              Patient_Request_Not_Too_Soon,
              Patient_Request_Too_Soon,
              HW_Detected_Failure,
              Stop_Pump_Completely,
              Pump_At_KVO_Rate,
              CP_Clinician_Request_Bolus,
              Halt_Infusion,
              Begin_Infusion,
              Near_Max_Drug_Per_Hour,
              Over_Max_Drug_Per_Hour),

    dataIns = ISZ(Infusion_Flow_Rate,
                  Patient_Bolus_Rate,
                  Square_Bolus_Rate,
                  Basal_Rate,
                  VTBI,
                  Door_Open,
                  Alarm_Inactivation),

    dataOuts = ISZ(),

    eventIns = ISZ(Alarm,
                   Warning,
                   CP_Bolus_Duration,
                   Rx_Okay,
                   Patient_Request_Not_Too_Soon,
                   Patient_Request_Too_Soon,
                   HW_Detected_Failure,
                   Stop_Pump_Completely,
                   Pump_At_KVO_Rate,
                   CP_Clinician_Request_Bolus,
                   Halt_Infusion,
                   Begin_Infusion,
                   Near_Max_Drug_Per_Hour,
                   Over_Max_Drug_Per_Hour),

    eventOuts = ISZ(ICE_Stop_Pump)
  )

  val initialization_api : ICE_Thread_imp_Initialization_Api = {
    val api = ICE_Thread_imp_Initialization_Api(
      id,
      Infusion_Flow_Rate.id,
      Patient_Bolus_Rate.id,
      Square_Bolus_Rate.id,
      Basal_Rate.id,
      VTBI.id,
      Door_Open.id,
      Alarm_Inactivation.id,
      Alarm.id,
      Warning.id,
      CP_Bolus_Duration.id,
      ICE_Stop_Pump.id,
      Rx_Okay.id,
      Patient_Request_Not_Too_Soon.id,
      Patient_Request_Too_Soon.id,
      HW_Detected_Failure.id,
      Stop_Pump_Completely.id,
      Pump_At_KVO_Rate.id,
      CP_Clinician_Request_Bolus.id,
      Halt_Infusion.id,
      Begin_Infusion.id,
      Near_Max_Drug_Per_Hour.id,
      Over_Max_Drug_Per_Hour.id
    )
    ICE_Thread_imp_pump_operation_operation_process_operation_threads_ice_thread_Bridge.c_initialization_api = Some(api)
    api
  }

  val operational_api : ICE_Thread_imp_Operational_Api = {
    val api = ICE_Thread_imp_Operational_Api(
      id,
      Infusion_Flow_Rate.id,
      Patient_Bolus_Rate.id,
      Square_Bolus_Rate.id,
      Basal_Rate.id,
      VTBI.id,
      Door_Open.id,
      Alarm_Inactivation.id,
      Alarm.id,
      Warning.id,
      CP_Bolus_Duration.id,
      ICE_Stop_Pump.id,
      Rx_Okay.id,
      Patient_Request_Not_Too_Soon.id,
      Patient_Request_Too_Soon.id,
      HW_Detected_Failure.id,
      Stop_Pump_Completely.id,
      Pump_At_KVO_Rate.id,
      CP_Clinician_Request_Bolus.id,
      Halt_Infusion.id,
      Begin_Infusion.id,
      Near_Max_Drug_Per_Hour.id,
      Over_Max_Drug_Per_Hour.id
    )
    ICE_Thread_imp_pump_operation_operation_process_operation_threads_ice_thread_Bridge.c_operational_api = Some(api)
    api
  }

  val entryPoints : Bridge.EntryPoints =
    ICE_Thread_imp_pump_operation_operation_process_operation_threads_ice_thread_Bridge.EntryPoints(
      id,

      Infusion_Flow_Rate.id,
      Patient_Bolus_Rate.id,
      Square_Bolus_Rate.id,
      Basal_Rate.id,
      VTBI.id,
      Door_Open.id,
      Alarm_Inactivation.id,
      Alarm.id,
      Warning.id,
      CP_Bolus_Duration.id,
      ICE_Stop_Pump.id,
      Rx_Okay.id,
      Patient_Request_Not_Too_Soon.id,
      Patient_Request_Too_Soon.id,
      HW_Detected_Failure.id,
      Stop_Pump_Completely.id,
      Pump_At_KVO_Rate.id,
      CP_Clinician_Request_Bolus.id,
      Halt_Infusion.id,
      Begin_Infusion.id,
      Near_Max_Drug_Per_Hour.id,
      Over_Max_Drug_Per_Hour.id,

      dispatchTriggers,

      initialization_api,
      operational_api)
}

object ICE_Thread_imp_pump_operation_operation_process_operation_threads_ice_thread_Bridge {

  var c_initialization_api: Option[ICE_Thread_imp_Initialization_Api] = None()
  var c_operational_api: Option[ICE_Thread_imp_Operational_Api] = None()

  @record class EntryPoints(
    ICE_Thread_imp_pump_operation_operation_process_operation_threads_ice_thread_BridgeId : Art.BridgeId,

    Infusion_Flow_Rate_Id : Art.PortId,
    Patient_Bolus_Rate_Id : Art.PortId,
    Square_Bolus_Rate_Id : Art.PortId,
    Basal_Rate_Id : Art.PortId,
    VTBI_Id : Art.PortId,
    Door_Open_Id : Art.PortId,
    Alarm_Inactivation_Id : Art.PortId,
    Alarm_Id : Art.PortId,
    Warning_Id : Art.PortId,
    CP_Bolus_Duration_Id : Art.PortId,
    ICE_Stop_Pump_Id : Art.PortId,
    Rx_Okay_Id : Art.PortId,
    Patient_Request_Not_Too_Soon_Id : Art.PortId,
    Patient_Request_Too_Soon_Id : Art.PortId,
    HW_Detected_Failure_Id : Art.PortId,
    Stop_Pump_Completely_Id : Art.PortId,
    Pump_At_KVO_Rate_Id : Art.PortId,
    CP_Clinician_Request_Bolus_Id : Art.PortId,
    Halt_Infusion_Id : Art.PortId,
    Begin_Infusion_Id : Art.PortId,
    Near_Max_Drug_Per_Hour_Id : Art.PortId,
    Over_Max_Drug_Per_Hour_Id : Art.PortId,

    dispatchTriggers : Option[ISZ[Art.PortId]],

    initialization_api: ICE_Thread_imp_Initialization_Api,
    operational_api: ICE_Thread_imp_Operational_Api) extends Bridge.EntryPoints {

    val dataInPortIds: ISZ[Art.PortId] = ISZ(Infusion_Flow_Rate_Id,
                                             Patient_Bolus_Rate_Id,
                                             Square_Bolus_Rate_Id,
                                             Basal_Rate_Id,
                                             VTBI_Id,
                                             Door_Open_Id,
                                             Alarm_Inactivation_Id)

    val eventInPortIds: ISZ[Art.PortId] = ISZ(Alarm_Id,
                                              Warning_Id,
                                              CP_Bolus_Duration_Id,
                                              Rx_Okay_Id,
                                              Patient_Request_Not_Too_Soon_Id,
                                              Patient_Request_Too_Soon_Id,
                                              HW_Detected_Failure_Id,
                                              Stop_Pump_Completely_Id,
                                              Pump_At_KVO_Rate_Id,
                                              CP_Clinician_Request_Bolus_Id,
                                              Halt_Infusion_Id,
                                              Begin_Infusion_Id,
                                              Near_Max_Drug_Per_Hour_Id,
                                              Over_Max_Drug_Per_Hour_Id)

    val dataOutPortIds: ISZ[Art.PortId] = ISZ()

    val eventOutPortIds: ISZ[Art.PortId] = ISZ(ICE_Stop_Pump_Id)

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
      val EventTriggered(receivedEvents) = Art.dispatchStatus(ICE_Thread_imp_pump_operation_operation_process_operation_threads_ice_thread_BridgeId)

      // remove non-dispatching event ports
      val dispatchableEventPorts: ISZ[Art.PortId] =
        if(dispatchTriggers.isEmpty) receivedEvents
        else filter(receivedEvents, dispatchTriggers.get)

      Art.receiveInput(eventInPortIds, dataInPortIds)

      for(portId <- dispatchableEventPorts) {
        if(portId == Alarm_Id){
          val Some(PCA_Types.Alarm_Type_Payload(value)) = Art.getValue(Alarm_Id)
          component.handleAlarm(operational_api, value)
        }
        else if(portId == Warning_Id){
          val Some(PCA_Types.Warning_Type_Payload(value)) = Art.getValue(Warning_Id)
          component.handleWarning(operational_api, value)
        }
        else if(portId == CP_Bolus_Duration_Id){
          val Some(ICE_Types.Minute_imp_Payload(value)) = Art.getValue(CP_Bolus_Duration_Id)
          component.handleCP_Bolus_Duration(operational_api, value)
        }
        else if(portId == Rx_Okay_Id) {
          component.handleRx_Okay(operational_api)
        }
        else if(portId == Patient_Request_Not_Too_Soon_Id) {
          component.handlePatient_Request_Not_Too_Soon(operational_api)
        }
        else if(portId == Patient_Request_Too_Soon_Id) {
          component.handlePatient_Request_Too_Soon(operational_api)
        }
        else if(portId == HW_Detected_Failure_Id) {
          component.handleHW_Detected_Failure(operational_api)
        }
        else if(portId == Stop_Pump_Completely_Id) {
          component.handleStop_Pump_Completely(operational_api)
        }
        else if(portId == Pump_At_KVO_Rate_Id) {
          component.handlePump_At_KVO_Rate(operational_api)
        }
        else if(portId == CP_Clinician_Request_Bolus_Id) {
          component.handleCP_Clinician_Request_Bolus(operational_api)
        }
        else if(portId == Halt_Infusion_Id) {
          component.handleHalt_Infusion(operational_api)
        }
        else if(portId == Begin_Infusion_Id) {
          component.handleBegin_Infusion(operational_api)
        }
        else if(portId == Near_Max_Drug_Per_Hour_Id) {
          component.handleNear_Max_Drug_Per_Hour(operational_api)
        }
        else if(portId == Over_Max_Drug_Per_Hour_Id) {
          component.handleOver_Max_Drug_Per_Hour(operational_api)
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
      val EventTriggered(receivedEvents) = Art.dispatchStatus(ICE_Thread_imp_pump_operation_operation_process_operation_threads_ice_thread_BridgeId)

      // remove non-dispatching event ports
      val dispatchableEventPorts: ISZ[Art.PortId] =
        if(dispatchTriggers.isEmpty) receivedEvents
        else filter(receivedEvents, dispatchTriggers.get)

      Art.receiveInput(eventInPortIds, dataInPortIds)

      for(portId <- dispatchableEventPorts) {
        if(portId == Alarm_Id){
          val Some(PCA_Types.Alarm_Type_Payload(value)) = Art.getValue(Alarm_Id)
          component.handleAlarm(operational_api, value)
        }
        else if(portId == Warning_Id){
          val Some(PCA_Types.Warning_Type_Payload(value)) = Art.getValue(Warning_Id)
          component.handleWarning(operational_api, value)
        }
        else if(portId == CP_Bolus_Duration_Id){
          val Some(ICE_Types.Minute_imp_Payload(value)) = Art.getValue(CP_Bolus_Duration_Id)
          component.handleCP_Bolus_Duration(operational_api, value)
        }
        else if(portId == Rx_Okay_Id) {
          component.handleRx_Okay(operational_api)
        }
        else if(portId == Patient_Request_Not_Too_Soon_Id) {
          component.handlePatient_Request_Not_Too_Soon(operational_api)
        }
        else if(portId == Patient_Request_Too_Soon_Id) {
          component.handlePatient_Request_Too_Soon(operational_api)
        }
        else if(portId == HW_Detected_Failure_Id) {
          component.handleHW_Detected_Failure(operational_api)
        }
        else if(portId == Stop_Pump_Completely_Id) {
          component.handleStop_Pump_Completely(operational_api)
        }
        else if(portId == Pump_At_KVO_Rate_Id) {
          component.handlePump_At_KVO_Rate(operational_api)
        }
        else if(portId == CP_Clinician_Request_Bolus_Id) {
          component.handleCP_Clinician_Request_Bolus(operational_api)
        }
        else if(portId == Halt_Infusion_Id) {
          component.handleHalt_Infusion(operational_api)
        }
        else if(portId == Begin_Infusion_Id) {
          component.handleBegin_Infusion(operational_api)
        }
        else if(portId == Near_Max_Drug_Per_Hour_Id) {
          component.handleNear_Max_Drug_Per_Hour(operational_api)
        }
        else if(portId == Over_Max_Drug_Per_Hour_Id) {
          component.handleOver_Max_Drug_Per_Hour(operational_api)
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