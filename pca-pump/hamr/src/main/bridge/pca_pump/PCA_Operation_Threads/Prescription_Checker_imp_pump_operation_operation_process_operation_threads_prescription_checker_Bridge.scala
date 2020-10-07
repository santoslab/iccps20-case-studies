// #Sireum

package pca_pump.PCA_Operation_Threads

import org.sireum._
import art._
import pca_pump._
import pca_pump.PCA_Operation_Threads.{Prescription_Checker_imp_pump_operation_operation_process_operation_threads_prescription_checker => component}

// This file was auto-generated.  Do not edit

@record class Prescription_Checker_imp_pump_operation_operation_process_operation_threads_prescription_checker_Bridge(
  val id: Art.BridgeId,
  val name: String,
  val dispatchProtocol: DispatchPropertyProtocol,
  val dispatchTriggers: Option[ISZ[Art.PortId]],

  Prescription: Port[PCA_Types.Prescription_imp],
  VTBI: Port[PCA_Types.Drug_Volume_imp],
  Square_Bolus_Rate: Port[PCA_Types.Flow_Rate_imp],
  Patient_Bolus_Rate: Port[PCA_Types.Flow_Rate_imp],
  Basal_Rate: Port[PCA_Types.Flow_Rate_imp],
  Minimum_Time_Between_Bolus: Port[ICE_Types.Minute_imp],
  Max_Drug_Per_Hour: Port[PCA_Types.Drug_Volume_imp],
  Get_Drug_Record: Port[PCA_Types.Drug_Code_imp],
  The_Drug_Record: Port[PCA_Types.Drug_Record_imp],
  Check_Rx: Port[art.Empty],
  Rx_Okay: Port[art.Empty],
  Drug_Not_In_Library: Port[art.Empty],
  Confirm_Soft_Limit_Exception: Port[art.Empty],
  Reject_Soft_Limit_Exception: Port[art.Empty],
  Soft_Limit_Warning: Port[art.Empty],
  Hard_Limit_Violated: Port[art.Empty]
  ) extends Bridge {

  val ports : Bridge.Ports = Bridge.Ports(
    all = ISZ(Prescription,
              VTBI,
              Square_Bolus_Rate,
              Patient_Bolus_Rate,
              Basal_Rate,
              Minimum_Time_Between_Bolus,
              Max_Drug_Per_Hour,
              Get_Drug_Record,
              The_Drug_Record,
              Check_Rx,
              Rx_Okay,
              Drug_Not_In_Library,
              Confirm_Soft_Limit_Exception,
              Reject_Soft_Limit_Exception,
              Soft_Limit_Warning,
              Hard_Limit_Violated),

    dataIns = ISZ(Prescription),

    dataOuts = ISZ(VTBI,
                   Square_Bolus_Rate,
                   Patient_Bolus_Rate,
                   Basal_Rate,
                   Minimum_Time_Between_Bolus,
                   Max_Drug_Per_Hour),

    eventIns = ISZ(The_Drug_Record,
                   Check_Rx,
                   Drug_Not_In_Library,
                   Confirm_Soft_Limit_Exception,
                   Reject_Soft_Limit_Exception),

    eventOuts = ISZ(Get_Drug_Record,
                    Rx_Okay,
                    Soft_Limit_Warning,
                    Hard_Limit_Violated)
  )

  val initialization_api : Prescription_Checker_imp_Initialization_Api = {
    val api = Prescription_Checker_imp_Initialization_Api(
      id,
      Prescription.id,
      VTBI.id,
      Square_Bolus_Rate.id,
      Patient_Bolus_Rate.id,
      Basal_Rate.id,
      Minimum_Time_Between_Bolus.id,
      Max_Drug_Per_Hour.id,
      Get_Drug_Record.id,
      The_Drug_Record.id,
      Check_Rx.id,
      Rx_Okay.id,
      Drug_Not_In_Library.id,
      Confirm_Soft_Limit_Exception.id,
      Reject_Soft_Limit_Exception.id,
      Soft_Limit_Warning.id,
      Hard_Limit_Violated.id
    )
    Prescription_Checker_imp_pump_operation_operation_process_operation_threads_prescription_checker_Bridge.c_initialization_api = Some(api)
    api
  }

  val operational_api : Prescription_Checker_imp_Operational_Api = {
    val api = Prescription_Checker_imp_Operational_Api(
      id,
      Prescription.id,
      VTBI.id,
      Square_Bolus_Rate.id,
      Patient_Bolus_Rate.id,
      Basal_Rate.id,
      Minimum_Time_Between_Bolus.id,
      Max_Drug_Per_Hour.id,
      Get_Drug_Record.id,
      The_Drug_Record.id,
      Check_Rx.id,
      Rx_Okay.id,
      Drug_Not_In_Library.id,
      Confirm_Soft_Limit_Exception.id,
      Reject_Soft_Limit_Exception.id,
      Soft_Limit_Warning.id,
      Hard_Limit_Violated.id
    )
    Prescription_Checker_imp_pump_operation_operation_process_operation_threads_prescription_checker_Bridge.c_operational_api = Some(api)
    api
  }

  val entryPoints : Bridge.EntryPoints =
    Prescription_Checker_imp_pump_operation_operation_process_operation_threads_prescription_checker_Bridge.EntryPoints(
      id,

      Prescription.id,
      VTBI.id,
      Square_Bolus_Rate.id,
      Patient_Bolus_Rate.id,
      Basal_Rate.id,
      Minimum_Time_Between_Bolus.id,
      Max_Drug_Per_Hour.id,
      Get_Drug_Record.id,
      The_Drug_Record.id,
      Check_Rx.id,
      Rx_Okay.id,
      Drug_Not_In_Library.id,
      Confirm_Soft_Limit_Exception.id,
      Reject_Soft_Limit_Exception.id,
      Soft_Limit_Warning.id,
      Hard_Limit_Violated.id,

      dispatchTriggers,

      initialization_api,
      operational_api)
}

object Prescription_Checker_imp_pump_operation_operation_process_operation_threads_prescription_checker_Bridge {

  var c_initialization_api: Option[Prescription_Checker_imp_Initialization_Api] = None()
  var c_operational_api: Option[Prescription_Checker_imp_Operational_Api] = None()

  @record class EntryPoints(
    Prescription_Checker_imp_pump_operation_operation_process_operation_threads_prescription_checker_BridgeId : Art.BridgeId,

    Prescription_Id : Art.PortId,
    VTBI_Id : Art.PortId,
    Square_Bolus_Rate_Id : Art.PortId,
    Patient_Bolus_Rate_Id : Art.PortId,
    Basal_Rate_Id : Art.PortId,
    Minimum_Time_Between_Bolus_Id : Art.PortId,
    Max_Drug_Per_Hour_Id : Art.PortId,
    Get_Drug_Record_Id : Art.PortId,
    The_Drug_Record_Id : Art.PortId,
    Check_Rx_Id : Art.PortId,
    Rx_Okay_Id : Art.PortId,
    Drug_Not_In_Library_Id : Art.PortId,
    Confirm_Soft_Limit_Exception_Id : Art.PortId,
    Reject_Soft_Limit_Exception_Id : Art.PortId,
    Soft_Limit_Warning_Id : Art.PortId,
    Hard_Limit_Violated_Id : Art.PortId,

    dispatchTriggers : Option[ISZ[Art.PortId]],

    initialization_api: Prescription_Checker_imp_Initialization_Api,
    operational_api: Prescription_Checker_imp_Operational_Api) extends Bridge.EntryPoints {

    val dataInPortIds: ISZ[Art.PortId] = ISZ(Prescription_Id)

    val eventInPortIds: ISZ[Art.PortId] = ISZ(The_Drug_Record_Id,
                                              Check_Rx_Id,
                                              Drug_Not_In_Library_Id,
                                              Confirm_Soft_Limit_Exception_Id,
                                              Reject_Soft_Limit_Exception_Id)

    val dataOutPortIds: ISZ[Art.PortId] = ISZ(VTBI_Id,
                                              Square_Bolus_Rate_Id,
                                              Patient_Bolus_Rate_Id,
                                              Basal_Rate_Id,
                                              Minimum_Time_Between_Bolus_Id,
                                              Max_Drug_Per_Hour_Id)

    val eventOutPortIds: ISZ[Art.PortId] = ISZ(Get_Drug_Record_Id,
                                               Rx_Okay_Id,
                                               Soft_Limit_Warning_Id,
                                               Hard_Limit_Violated_Id)

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
      val EventTriggered(receivedEvents) = Art.dispatchStatus(Prescription_Checker_imp_pump_operation_operation_process_operation_threads_prescription_checker_BridgeId)

      // remove non-dispatching event ports
      val dispatchableEventPorts: ISZ[Art.PortId] =
        if(dispatchTriggers.isEmpty) receivedEvents
        else filter(receivedEvents, dispatchTriggers.get)

      Art.receiveInput(eventInPortIds, dataInPortIds)

      for(portId <- dispatchableEventPorts) {
        if(portId == The_Drug_Record_Id){
          val Some(PCA_Types.Drug_Record_imp_Payload(value)) = Art.getValue(The_Drug_Record_Id)
          component.handleThe_Drug_Record(operational_api, value)
        }
        else if(portId == Check_Rx_Id) {
          component.handleCheck_Rx(operational_api)
        }
        else if(portId == Drug_Not_In_Library_Id) {
          component.handleDrug_Not_In_Library(operational_api)
        }
        else if(portId == Confirm_Soft_Limit_Exception_Id) {
          component.handleConfirm_Soft_Limit_Exception(operational_api)
        }
        else if(portId == Reject_Soft_Limit_Exception_Id) {
          component.handleReject_Soft_Limit_Exception(operational_api)
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
      val EventTriggered(receivedEvents) = Art.dispatchStatus(Prescription_Checker_imp_pump_operation_operation_process_operation_threads_prescription_checker_BridgeId)

      // remove non-dispatching event ports
      val dispatchableEventPorts: ISZ[Art.PortId] =
        if(dispatchTriggers.isEmpty) receivedEvents
        else filter(receivedEvents, dispatchTriggers.get)

      Art.receiveInput(eventInPortIds, dataInPortIds)

      for(portId <- dispatchableEventPorts) {
        if(portId == The_Drug_Record_Id){
          val Some(PCA_Types.Drug_Record_imp_Payload(value)) = Art.getValue(The_Drug_Record_Id)
          component.handleThe_Drug_Record(operational_api, value)
        }
        else if(portId == Check_Rx_Id) {
          component.handleCheck_Rx(operational_api)
        }
        else if(portId == Drug_Not_In_Library_Id) {
          component.handleDrug_Not_In_Library(operational_api)
        }
        else if(portId == Confirm_Soft_Limit_Exception_Id) {
          component.handleConfirm_Soft_Limit_Exception(operational_api)
        }
        else if(portId == Reject_Soft_Limit_Exception_Id) {
          component.handleReject_Soft_Limit_Exception(operational_api)
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