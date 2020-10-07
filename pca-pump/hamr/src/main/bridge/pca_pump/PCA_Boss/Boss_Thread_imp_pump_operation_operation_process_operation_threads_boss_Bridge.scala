// #Sireum

package pca_pump.PCA_Boss

import org.sireum._
import art._
import pca_pump._
import pca_pump.PCA_Boss.{Boss_Thread_imp_pump_operation_operation_process_operation_threads_boss => component}

// This file was auto-generated.  Do not edit

@record class Boss_Thread_imp_pump_operation_operation_process_operation_threads_boss_Bridge(
  val id: Art.BridgeId,
  val name: String,
  val dispatchProtocol: DispatchPropertyProtocol,
  val dispatchTriggers: Option[ISZ[Art.PortId]],

  Display_Message: Port[PCA_Types.Message.Type],
  Sound_Type: Port[PCA_Types.Sound.Type],
  Log_Event: Port[PCA_Types.Event_Record],
  POST_done: Port[art.Empty],
  POST_fail: Port[art.Empty],
  Stop_Button_Pressed: Port[art.Empty],
  Start_Button_Pressed: Port[art.Empty],
  Do_Scan: Port[art.Empty],
  Scan_Done: Port[art.Empty],
  Authenticate_Clinician: Port[art.Empty],
  Authenticate_Patient: Port[art.Empty],
  Authenticate_Prescription: Port[art.Empty],
  Authentication_fail: Port[art.Empty],
  Authentication_pass: Port[art.Empty],
  Check_Rx: Port[art.Empty],
  Drug_Not_In_Library: Port[art.Empty],
  Hard_Limit_Violated: Port[art.Empty],
  Reject_Soft_Limit_Exception: Port[art.Empty],
  Confirm_Soft_Limit_Exception: Port[art.Empty],
  Rx_Okay: Port[art.Empty],
  Door_Closed: Port[art.Empty],
  Begin_Priming: Port[art.Empty],
  End_Priming: Port[art.Empty],
  Prime_Failure: Port[art.Empty],
  Begin_Infusion: Port[art.Empty],
  Halt_Infusion: Port[art.Empty],
  Turn_Off: Port[art.Empty]
  ) extends Bridge {

  val ports : Bridge.Ports = Bridge.Ports(
    all = ISZ(Display_Message,
              Sound_Type,
              Log_Event,
              POST_done,
              POST_fail,
              Stop_Button_Pressed,
              Start_Button_Pressed,
              Do_Scan,
              Scan_Done,
              Authenticate_Clinician,
              Authenticate_Patient,
              Authenticate_Prescription,
              Authentication_fail,
              Authentication_pass,
              Check_Rx,
              Drug_Not_In_Library,
              Hard_Limit_Violated,
              Reject_Soft_Limit_Exception,
              Confirm_Soft_Limit_Exception,
              Rx_Okay,
              Door_Closed,
              Begin_Priming,
              End_Priming,
              Prime_Failure,
              Begin_Infusion,
              Halt_Infusion,
              Turn_Off),

    dataIns = ISZ(),

    dataOuts = ISZ(),

    eventIns = ISZ(POST_done,
                   POST_fail,
                   Stop_Button_Pressed,
                   Start_Button_Pressed,
                   Scan_Done,
                   Authentication_fail,
                   Authentication_pass,
                   Drug_Not_In_Library,
                   Hard_Limit_Violated,
                   Reject_Soft_Limit_Exception,
                   Confirm_Soft_Limit_Exception,
                   Rx_Okay,
                   Door_Closed,
                   Turn_Off),

    eventOuts = ISZ(Display_Message,
                    Sound_Type,
                    Log_Event,
                    Do_Scan,
                    Authenticate_Clinician,
                    Authenticate_Patient,
                    Authenticate_Prescription,
                    Check_Rx,
                    Begin_Priming,
                    End_Priming,
                    Prime_Failure,
                    Begin_Infusion,
                    Halt_Infusion)
  )

  val initialization_api : Boss_Thread_imp_Initialization_Api = {
    val api = Boss_Thread_imp_Initialization_Api(
      id,
      Display_Message.id,
      Sound_Type.id,
      Log_Event.id,
      POST_done.id,
      POST_fail.id,
      Stop_Button_Pressed.id,
      Start_Button_Pressed.id,
      Do_Scan.id,
      Scan_Done.id,
      Authenticate_Clinician.id,
      Authenticate_Patient.id,
      Authenticate_Prescription.id,
      Authentication_fail.id,
      Authentication_pass.id,
      Check_Rx.id,
      Drug_Not_In_Library.id,
      Hard_Limit_Violated.id,
      Reject_Soft_Limit_Exception.id,
      Confirm_Soft_Limit_Exception.id,
      Rx_Okay.id,
      Door_Closed.id,
      Begin_Priming.id,
      End_Priming.id,
      Prime_Failure.id,
      Begin_Infusion.id,
      Halt_Infusion.id,
      Turn_Off.id
    )
    Boss_Thread_imp_pump_operation_operation_process_operation_threads_boss_Bridge.c_initialization_api = Some(api)
    api
  }

  val operational_api : Boss_Thread_imp_Operational_Api = {
    val api = Boss_Thread_imp_Operational_Api(
      id,
      Display_Message.id,
      Sound_Type.id,
      Log_Event.id,
      POST_done.id,
      POST_fail.id,
      Stop_Button_Pressed.id,
      Start_Button_Pressed.id,
      Do_Scan.id,
      Scan_Done.id,
      Authenticate_Clinician.id,
      Authenticate_Patient.id,
      Authenticate_Prescription.id,
      Authentication_fail.id,
      Authentication_pass.id,
      Check_Rx.id,
      Drug_Not_In_Library.id,
      Hard_Limit_Violated.id,
      Reject_Soft_Limit_Exception.id,
      Confirm_Soft_Limit_Exception.id,
      Rx_Okay.id,
      Door_Closed.id,
      Begin_Priming.id,
      End_Priming.id,
      Prime_Failure.id,
      Begin_Infusion.id,
      Halt_Infusion.id,
      Turn_Off.id
    )
    Boss_Thread_imp_pump_operation_operation_process_operation_threads_boss_Bridge.c_operational_api = Some(api)
    api
  }

  val entryPoints : Bridge.EntryPoints =
    Boss_Thread_imp_pump_operation_operation_process_operation_threads_boss_Bridge.EntryPoints(
      id,

      Display_Message.id,
      Sound_Type.id,
      Log_Event.id,
      POST_done.id,
      POST_fail.id,
      Stop_Button_Pressed.id,
      Start_Button_Pressed.id,
      Do_Scan.id,
      Scan_Done.id,
      Authenticate_Clinician.id,
      Authenticate_Patient.id,
      Authenticate_Prescription.id,
      Authentication_fail.id,
      Authentication_pass.id,
      Check_Rx.id,
      Drug_Not_In_Library.id,
      Hard_Limit_Violated.id,
      Reject_Soft_Limit_Exception.id,
      Confirm_Soft_Limit_Exception.id,
      Rx_Okay.id,
      Door_Closed.id,
      Begin_Priming.id,
      End_Priming.id,
      Prime_Failure.id,
      Begin_Infusion.id,
      Halt_Infusion.id,
      Turn_Off.id,

      dispatchTriggers,

      initialization_api,
      operational_api)
}

object Boss_Thread_imp_pump_operation_operation_process_operation_threads_boss_Bridge {

  var c_initialization_api: Option[Boss_Thread_imp_Initialization_Api] = None()
  var c_operational_api: Option[Boss_Thread_imp_Operational_Api] = None()

  @record class EntryPoints(
    Boss_Thread_imp_pump_operation_operation_process_operation_threads_boss_BridgeId : Art.BridgeId,

    Display_Message_Id : Art.PortId,
    Sound_Type_Id : Art.PortId,
    Log_Event_Id : Art.PortId,
    POST_done_Id : Art.PortId,
    POST_fail_Id : Art.PortId,
    Stop_Button_Pressed_Id : Art.PortId,
    Start_Button_Pressed_Id : Art.PortId,
    Do_Scan_Id : Art.PortId,
    Scan_Done_Id : Art.PortId,
    Authenticate_Clinician_Id : Art.PortId,
    Authenticate_Patient_Id : Art.PortId,
    Authenticate_Prescription_Id : Art.PortId,
    Authentication_fail_Id : Art.PortId,
    Authentication_pass_Id : Art.PortId,
    Check_Rx_Id : Art.PortId,
    Drug_Not_In_Library_Id : Art.PortId,
    Hard_Limit_Violated_Id : Art.PortId,
    Reject_Soft_Limit_Exception_Id : Art.PortId,
    Confirm_Soft_Limit_Exception_Id : Art.PortId,
    Rx_Okay_Id : Art.PortId,
    Door_Closed_Id : Art.PortId,
    Begin_Priming_Id : Art.PortId,
    End_Priming_Id : Art.PortId,
    Prime_Failure_Id : Art.PortId,
    Begin_Infusion_Id : Art.PortId,
    Halt_Infusion_Id : Art.PortId,
    Turn_Off_Id : Art.PortId,

    dispatchTriggers : Option[ISZ[Art.PortId]],

    initialization_api: Boss_Thread_imp_Initialization_Api,
    operational_api: Boss_Thread_imp_Operational_Api) extends Bridge.EntryPoints {

    val dataInPortIds: ISZ[Art.PortId] = ISZ()

    val eventInPortIds: ISZ[Art.PortId] = ISZ(POST_done_Id,
                                              POST_fail_Id,
                                              Stop_Button_Pressed_Id,
                                              Start_Button_Pressed_Id,
                                              Scan_Done_Id,
                                              Authentication_fail_Id,
                                              Authentication_pass_Id,
                                              Drug_Not_In_Library_Id,
                                              Hard_Limit_Violated_Id,
                                              Reject_Soft_Limit_Exception_Id,
                                              Confirm_Soft_Limit_Exception_Id,
                                              Rx_Okay_Id,
                                              Door_Closed_Id,
                                              Turn_Off_Id)

    val dataOutPortIds: ISZ[Art.PortId] = ISZ()

    val eventOutPortIds: ISZ[Art.PortId] = ISZ(Display_Message_Id,
                                               Sound_Type_Id,
                                               Log_Event_Id,
                                               Do_Scan_Id,
                                               Authenticate_Clinician_Id,
                                               Authenticate_Patient_Id,
                                               Authenticate_Prescription_Id,
                                               Check_Rx_Id,
                                               Begin_Priming_Id,
                                               End_Priming_Id,
                                               Prime_Failure_Id,
                                               Begin_Infusion_Id,
                                               Halt_Infusion_Id)

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
      val EventTriggered(receivedEvents) = Art.dispatchStatus(Boss_Thread_imp_pump_operation_operation_process_operation_threads_boss_BridgeId)

      // remove non-dispatching event ports
      val dispatchableEventPorts: ISZ[Art.PortId] =
        if(dispatchTriggers.isEmpty) receivedEvents
        else filter(receivedEvents, dispatchTriggers.get)

      Art.receiveInput(eventInPortIds, dataInPortIds)

      for(portId <- dispatchableEventPorts) {
        if(portId == POST_done_Id) {
          component.handlePOST_done(operational_api)
        }
        else if(portId == POST_fail_Id) {
          component.handlePOST_fail(operational_api)
        }
        else if(portId == Stop_Button_Pressed_Id) {
          component.handleStop_Button_Pressed(operational_api)
        }
        else if(portId == Start_Button_Pressed_Id) {
          component.handleStart_Button_Pressed(operational_api)
        }
        else if(portId == Scan_Done_Id) {
          component.handleScan_Done(operational_api)
        }
        else if(portId == Authentication_fail_Id) {
          component.handleAuthentication_fail(operational_api)
        }
        else if(portId == Authentication_pass_Id) {
          component.handleAuthentication_pass(operational_api)
        }
        else if(portId == Drug_Not_In_Library_Id) {
          component.handleDrug_Not_In_Library(operational_api)
        }
        else if(portId == Hard_Limit_Violated_Id) {
          component.handleHard_Limit_Violated(operational_api)
        }
        else if(portId == Reject_Soft_Limit_Exception_Id) {
          component.handleReject_Soft_Limit_Exception(operational_api)
        }
        else if(portId == Confirm_Soft_Limit_Exception_Id) {
          component.handleConfirm_Soft_Limit_Exception(operational_api)
        }
        else if(portId == Rx_Okay_Id) {
          component.handleRx_Okay(operational_api)
        }
        else if(portId == Door_Closed_Id) {
          component.handleDoor_Closed(operational_api)
        }
        else if(portId == Turn_Off_Id) {
          component.handleTurn_Off(operational_api)
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
      val EventTriggered(receivedEvents) = Art.dispatchStatus(Boss_Thread_imp_pump_operation_operation_process_operation_threads_boss_BridgeId)

      // remove non-dispatching event ports
      val dispatchableEventPorts: ISZ[Art.PortId] =
        if(dispatchTriggers.isEmpty) receivedEvents
        else filter(receivedEvents, dispatchTriggers.get)

      Art.receiveInput(eventInPortIds, dataInPortIds)

      for(portId <- dispatchableEventPorts) {
        if(portId == POST_done_Id) {
          component.handlePOST_done(operational_api)
        }
        else if(portId == POST_fail_Id) {
          component.handlePOST_fail(operational_api)
        }
        else if(portId == Stop_Button_Pressed_Id) {
          component.handleStop_Button_Pressed(operational_api)
        }
        else if(portId == Start_Button_Pressed_Id) {
          component.handleStart_Button_Pressed(operational_api)
        }
        else if(portId == Scan_Done_Id) {
          component.handleScan_Done(operational_api)
        }
        else if(portId == Authentication_fail_Id) {
          component.handleAuthentication_fail(operational_api)
        }
        else if(portId == Authentication_pass_Id) {
          component.handleAuthentication_pass(operational_api)
        }
        else if(portId == Drug_Not_In_Library_Id) {
          component.handleDrug_Not_In_Library(operational_api)
        }
        else if(portId == Hard_Limit_Violated_Id) {
          component.handleHard_Limit_Violated(operational_api)
        }
        else if(portId == Reject_Soft_Limit_Exception_Id) {
          component.handleReject_Soft_Limit_Exception(operational_api)
        }
        else if(portId == Confirm_Soft_Limit_Exception_Id) {
          component.handleConfirm_Soft_Limit_Exception(operational_api)
        }
        else if(portId == Rx_Okay_Id) {
          component.handleRx_Okay(operational_api)
        }
        else if(portId == Door_Closed_Id) {
          component.handleDoor_Closed(operational_api)
        }
        else if(portId == Turn_Off_Id) {
          component.handleTurn_Off(operational_api)
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