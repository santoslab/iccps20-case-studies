// #Sireum

package pca_pump.PCA_Control_Panel

import org.sireum._
import art._
import pca_pump._
import pca_pump.PCA_Control_Panel.{ui_thread_imp_pump_operation_control_panel_ui_process_ui_thread => component}

// This file was auto-generated.  Do not edit

@record class ui_thread_imp_pump_operation_control_panel_ui_process_ui_thread_Bridge(
  val id: Art.BridgeId,
  val name: String,
  val dispatchProtocol: DispatchPropertyProtocol,
  val dispatchTriggers: Option[ISZ[Art.PortId]],

  Image: Port[PCA_Types.Image],
  AudioSignal: Port[PCA_Types.Sound.Type],
  Alarm_Inactivation: Port[ICE_Types.Alarm_Signal.Type],
  Remaining_Battery_Time: Port[BLESS_Types.Time],
  Using_Battery_Power: Port[Base_Types.Boolean],
  Prescription: Port[PCA_Types.Prescription_imp],
  Infusion_Flow_Rate: Port[PCA_Types.Flow_Rate_imp],
  Clinician_Name: Port[Base_Types.String],
  Patient_Name: Port[Base_Types.String],
  Touch: Port[PCA_Types.Touch],
  Alarm: Port[PCA_Types.Alarm_Type.Type],
  Warning: Port[PCA_Types.Warning_Type.Type],
  System_Status: Port[PCA_Types.Status_Type.Type],
  Display_Message: Port[PCA_Types.Message.Type],
  Sound_Type: Port[PCA_Types.Sound.Type],
  Bolus_Duration: Port[ICE_Types.Minute_imp],
  CP_Reset_Alarm: Port[art.Empty],
  Low_Battery_Warning: Port[art.Empty],
  Hard_Limit_Violated: Port[art.Empty],
  Soft_Limit_Warning: Port[art.Empty],
  Confirm_Soft_Limit_Exception: Port[art.Empty],
  Reject_Soft_Limit_Exception: Port[art.Empty],
  Stop_Button_Pressed: Port[art.Empty],
  Start_Button_Pressed: Port[art.Empty],
  Clinician_Request_Bolus: Port[art.Empty],
  Pause_Infusion: Port[art.Empty],
  Resume_Infusion: Port[art.Empty],
  Turn_Off: Port[art.Empty],
  Patient_Request_Not_Too_Soon: Port[art.Empty],
  Patient_Request_Too_Soon: Port[art.Empty]
  ) extends Bridge {

  val ports : Bridge.Ports = Bridge.Ports(
    all = ISZ(Image,
              AudioSignal,
              Alarm_Inactivation,
              Remaining_Battery_Time,
              Using_Battery_Power,
              Prescription,
              Infusion_Flow_Rate,
              Clinician_Name,
              Patient_Name,
              Touch,
              Alarm,
              Warning,
              System_Status,
              Display_Message,
              Sound_Type,
              Bolus_Duration,
              CP_Reset_Alarm,
              Low_Battery_Warning,
              Hard_Limit_Violated,
              Soft_Limit_Warning,
              Confirm_Soft_Limit_Exception,
              Reject_Soft_Limit_Exception,
              Stop_Button_Pressed,
              Start_Button_Pressed,
              Clinician_Request_Bolus,
              Pause_Infusion,
              Resume_Infusion,
              Turn_Off,
              Patient_Request_Not_Too_Soon,
              Patient_Request_Too_Soon),

    dataIns = ISZ(Remaining_Battery_Time,
                  Using_Battery_Power,
                  Prescription,
                  Infusion_Flow_Rate,
                  Clinician_Name,
                  Patient_Name),

    dataOuts = ISZ(Image,
                   AudioSignal,
                   Alarm_Inactivation),

    eventIns = ISZ(Touch,
                   Alarm,
                   Warning,
                   System_Status,
                   Display_Message,
                   Sound_Type,
                   Low_Battery_Warning,
                   Hard_Limit_Violated,
                   Soft_Limit_Warning,
                   Patient_Request_Not_Too_Soon,
                   Patient_Request_Too_Soon),

    eventOuts = ISZ(Bolus_Duration,
                    CP_Reset_Alarm,
                    Confirm_Soft_Limit_Exception,
                    Reject_Soft_Limit_Exception,
                    Stop_Button_Pressed,
                    Start_Button_Pressed,
                    Clinician_Request_Bolus,
                    Pause_Infusion,
                    Resume_Infusion,
                    Turn_Off)
  )

  val initialization_api : ui_thread_imp_Initialization_Api = {
    val api = ui_thread_imp_Initialization_Api(
      id,
      Image.id,
      AudioSignal.id,
      Alarm_Inactivation.id,
      Remaining_Battery_Time.id,
      Using_Battery_Power.id,
      Prescription.id,
      Infusion_Flow_Rate.id,
      Clinician_Name.id,
      Patient_Name.id,
      Touch.id,
      Alarm.id,
      Warning.id,
      System_Status.id,
      Display_Message.id,
      Sound_Type.id,
      Bolus_Duration.id,
      CP_Reset_Alarm.id,
      Low_Battery_Warning.id,
      Hard_Limit_Violated.id,
      Soft_Limit_Warning.id,
      Confirm_Soft_Limit_Exception.id,
      Reject_Soft_Limit_Exception.id,
      Stop_Button_Pressed.id,
      Start_Button_Pressed.id,
      Clinician_Request_Bolus.id,
      Pause_Infusion.id,
      Resume_Infusion.id,
      Turn_Off.id,
      Patient_Request_Not_Too_Soon.id,
      Patient_Request_Too_Soon.id
    )
    ui_thread_imp_pump_operation_control_panel_ui_process_ui_thread_Bridge.c_initialization_api = Some(api)
    api
  }

  val operational_api : ui_thread_imp_Operational_Api = {
    val api = ui_thread_imp_Operational_Api(
      id,
      Image.id,
      AudioSignal.id,
      Alarm_Inactivation.id,
      Remaining_Battery_Time.id,
      Using_Battery_Power.id,
      Prescription.id,
      Infusion_Flow_Rate.id,
      Clinician_Name.id,
      Patient_Name.id,
      Touch.id,
      Alarm.id,
      Warning.id,
      System_Status.id,
      Display_Message.id,
      Sound_Type.id,
      Bolus_Duration.id,
      CP_Reset_Alarm.id,
      Low_Battery_Warning.id,
      Hard_Limit_Violated.id,
      Soft_Limit_Warning.id,
      Confirm_Soft_Limit_Exception.id,
      Reject_Soft_Limit_Exception.id,
      Stop_Button_Pressed.id,
      Start_Button_Pressed.id,
      Clinician_Request_Bolus.id,
      Pause_Infusion.id,
      Resume_Infusion.id,
      Turn_Off.id,
      Patient_Request_Not_Too_Soon.id,
      Patient_Request_Too_Soon.id
    )
    ui_thread_imp_pump_operation_control_panel_ui_process_ui_thread_Bridge.c_operational_api = Some(api)
    api
  }

  val entryPoints : Bridge.EntryPoints =
    ui_thread_imp_pump_operation_control_panel_ui_process_ui_thread_Bridge.EntryPoints(
      id,

      Image.id,
      AudioSignal.id,
      Alarm_Inactivation.id,
      Remaining_Battery_Time.id,
      Using_Battery_Power.id,
      Prescription.id,
      Infusion_Flow_Rate.id,
      Clinician_Name.id,
      Patient_Name.id,
      Touch.id,
      Alarm.id,
      Warning.id,
      System_Status.id,
      Display_Message.id,
      Sound_Type.id,
      Bolus_Duration.id,
      CP_Reset_Alarm.id,
      Low_Battery_Warning.id,
      Hard_Limit_Violated.id,
      Soft_Limit_Warning.id,
      Confirm_Soft_Limit_Exception.id,
      Reject_Soft_Limit_Exception.id,
      Stop_Button_Pressed.id,
      Start_Button_Pressed.id,
      Clinician_Request_Bolus.id,
      Pause_Infusion.id,
      Resume_Infusion.id,
      Turn_Off.id,
      Patient_Request_Not_Too_Soon.id,
      Patient_Request_Too_Soon.id,

      dispatchTriggers,

      initialization_api,
      operational_api)
}

object ui_thread_imp_pump_operation_control_panel_ui_process_ui_thread_Bridge {

  var c_initialization_api: Option[ui_thread_imp_Initialization_Api] = None()
  var c_operational_api: Option[ui_thread_imp_Operational_Api] = None()

  @record class EntryPoints(
    ui_thread_imp_pump_operation_control_panel_ui_process_ui_thread_BridgeId : Art.BridgeId,

    Image_Id : Art.PortId,
    AudioSignal_Id : Art.PortId,
    Alarm_Inactivation_Id : Art.PortId,
    Remaining_Battery_Time_Id : Art.PortId,
    Using_Battery_Power_Id : Art.PortId,
    Prescription_Id : Art.PortId,
    Infusion_Flow_Rate_Id : Art.PortId,
    Clinician_Name_Id : Art.PortId,
    Patient_Name_Id : Art.PortId,
    Touch_Id : Art.PortId,
    Alarm_Id : Art.PortId,
    Warning_Id : Art.PortId,
    System_Status_Id : Art.PortId,
    Display_Message_Id : Art.PortId,
    Sound_Type_Id : Art.PortId,
    Bolus_Duration_Id : Art.PortId,
    CP_Reset_Alarm_Id : Art.PortId,
    Low_Battery_Warning_Id : Art.PortId,
    Hard_Limit_Violated_Id : Art.PortId,
    Soft_Limit_Warning_Id : Art.PortId,
    Confirm_Soft_Limit_Exception_Id : Art.PortId,
    Reject_Soft_Limit_Exception_Id : Art.PortId,
    Stop_Button_Pressed_Id : Art.PortId,
    Start_Button_Pressed_Id : Art.PortId,
    Clinician_Request_Bolus_Id : Art.PortId,
    Pause_Infusion_Id : Art.PortId,
    Resume_Infusion_Id : Art.PortId,
    Turn_Off_Id : Art.PortId,
    Patient_Request_Not_Too_Soon_Id : Art.PortId,
    Patient_Request_Too_Soon_Id : Art.PortId,

    dispatchTriggers : Option[ISZ[Art.PortId]],

    initialization_api: ui_thread_imp_Initialization_Api,
    operational_api: ui_thread_imp_Operational_Api) extends Bridge.EntryPoints {

    val dataInPortIds: ISZ[Art.PortId] = ISZ(Remaining_Battery_Time_Id,
                                             Using_Battery_Power_Id,
                                             Prescription_Id,
                                             Infusion_Flow_Rate_Id,
                                             Clinician_Name_Id,
                                             Patient_Name_Id)

    val eventInPortIds: ISZ[Art.PortId] = ISZ(Touch_Id,
                                              Alarm_Id,
                                              Warning_Id,
                                              System_Status_Id,
                                              Display_Message_Id,
                                              Sound_Type_Id,
                                              Low_Battery_Warning_Id,
                                              Hard_Limit_Violated_Id,
                                              Soft_Limit_Warning_Id,
                                              Patient_Request_Not_Too_Soon_Id,
                                              Patient_Request_Too_Soon_Id)

    val dataOutPortIds: ISZ[Art.PortId] = ISZ(Image_Id,
                                              AudioSignal_Id,
                                              Alarm_Inactivation_Id)

    val eventOutPortIds: ISZ[Art.PortId] = ISZ(Bolus_Duration_Id,
                                               CP_Reset_Alarm_Id,
                                               Confirm_Soft_Limit_Exception_Id,
                                               Reject_Soft_Limit_Exception_Id,
                                               Stop_Button_Pressed_Id,
                                               Start_Button_Pressed_Id,
                                               Clinician_Request_Bolus_Id,
                                               Pause_Infusion_Id,
                                               Resume_Infusion_Id,
                                               Turn_Off_Id)

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
      val EventTriggered(receivedEvents) = Art.dispatchStatus(ui_thread_imp_pump_operation_control_panel_ui_process_ui_thread_BridgeId)

      // remove non-dispatching event ports
      val dispatchableEventPorts: ISZ[Art.PortId] =
        if(dispatchTriggers.isEmpty) receivedEvents
        else filter(receivedEvents, dispatchTriggers.get)

      Art.receiveInput(eventInPortIds, dataInPortIds)

      for(portId <- dispatchableEventPorts) {
        if(portId == Touch_Id){
          val Some(PCA_Types.Touch_Payload(value)) = Art.getValue(Touch_Id)
          component.handleTouch(operational_api, value)
        }
        else if(portId == Alarm_Id){
          val Some(PCA_Types.Alarm_Type_Payload(value)) = Art.getValue(Alarm_Id)
          component.handleAlarm(operational_api, value)
        }
        else if(portId == Warning_Id){
          val Some(PCA_Types.Warning_Type_Payload(value)) = Art.getValue(Warning_Id)
          component.handleWarning(operational_api, value)
        }
        else if(portId == System_Status_Id){
          val Some(PCA_Types.Status_Type_Payload(value)) = Art.getValue(System_Status_Id)
          component.handleSystem_Status(operational_api, value)
        }
        else if(portId == Display_Message_Id){
          val Some(PCA_Types.Message_Payload(value)) = Art.getValue(Display_Message_Id)
          component.handleDisplay_Message(operational_api, value)
        }
        else if(portId == Sound_Type_Id){
          val Some(PCA_Types.Sound_Payload(value)) = Art.getValue(Sound_Type_Id)
          component.handleSound_Type(operational_api, value)
        }
        else if(portId == Low_Battery_Warning_Id) {
          component.handleLow_Battery_Warning(operational_api)
        }
        else if(portId == Hard_Limit_Violated_Id) {
          component.handleHard_Limit_Violated(operational_api)
        }
        else if(portId == Soft_Limit_Warning_Id) {
          component.handleSoft_Limit_Warning(operational_api)
        }
        else if(portId == Patient_Request_Not_Too_Soon_Id) {
          component.handlePatient_Request_Not_Too_Soon(operational_api)
        }
        else if(portId == Patient_Request_Too_Soon_Id) {
          component.handlePatient_Request_Too_Soon(operational_api)
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
      val EventTriggered(receivedEvents) = Art.dispatchStatus(ui_thread_imp_pump_operation_control_panel_ui_process_ui_thread_BridgeId)

      // remove non-dispatching event ports
      val dispatchableEventPorts: ISZ[Art.PortId] =
        if(dispatchTriggers.isEmpty) receivedEvents
        else filter(receivedEvents, dispatchTriggers.get)

      Art.receiveInput(eventInPortIds, dataInPortIds)

      for(portId <- dispatchableEventPorts) {
        if(portId == Touch_Id){
          val Some(PCA_Types.Touch_Payload(value)) = Art.getValue(Touch_Id)
          component.handleTouch(operational_api, value)
        }
        else if(portId == Alarm_Id){
          val Some(PCA_Types.Alarm_Type_Payload(value)) = Art.getValue(Alarm_Id)
          component.handleAlarm(operational_api, value)
        }
        else if(portId == Warning_Id){
          val Some(PCA_Types.Warning_Type_Payload(value)) = Art.getValue(Warning_Id)
          component.handleWarning(operational_api, value)
        }
        else if(portId == System_Status_Id){
          val Some(PCA_Types.Status_Type_Payload(value)) = Art.getValue(System_Status_Id)
          component.handleSystem_Status(operational_api, value)
        }
        else if(portId == Display_Message_Id){
          val Some(PCA_Types.Message_Payload(value)) = Art.getValue(Display_Message_Id)
          component.handleDisplay_Message(operational_api, value)
        }
        else if(portId == Sound_Type_Id){
          val Some(PCA_Types.Sound_Payload(value)) = Art.getValue(Sound_Type_Id)
          component.handleSound_Type(operational_api, value)
        }
        else if(portId == Low_Battery_Warning_Id) {
          component.handleLow_Battery_Warning(operational_api)
        }
        else if(portId == Hard_Limit_Violated_Id) {
          component.handleHard_Limit_Violated(operational_api)
        }
        else if(portId == Soft_Limit_Warning_Id) {
          component.handleSoft_Limit_Warning(operational_api)
        }
        else if(portId == Patient_Request_Not_Too_Soon_Id) {
          component.handlePatient_Request_Not_Too_Soon(operational_api)
        }
        else if(portId == Patient_Request_Too_Soon_Id) {
          component.handlePatient_Request_Too_Soon(operational_api)
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