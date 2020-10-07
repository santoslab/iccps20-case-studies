// #Sireum

package pca_pump.PCA_Security

import org.sireum._
import art._
import pca_pump._
import pca_pump.PCA_Security.{Security_Thread_imp_pump_operation_security_subsystem_security_process_security_thread => component}

// This file was auto-generated.  Do not edit

@record class Security_Thread_imp_pump_operation_security_subsystem_security_process_security_thread_Bridge(
  val id: Art.BridgeId,
  val name: String,
  val dispatchProtocol: DispatchPropertyProtocol,
  val dispatchTriggers: Option[ISZ[Art.PortId]],

  Clinician_Name: Port[Base_Types.String],
  Patient_Name: Port[Base_Types.String],
  Prescription: Port[PCA_Types.Prescription_imp],
  Scan_Data: Port[PCA_Types.Scan_Data_Type],
  Authenticate_Clinician: Port[art.Empty],
  Authenticate_Patient: Port[art.Empty],
  Authenticate_Prescription: Port[art.Empty],
  Authentication_fail: Port[art.Empty],
  Authentication_pass: Port[art.Empty],
  Security_Fault: Port[art.Empty]
  ) extends Bridge {

  val ports : Bridge.Ports = Bridge.Ports(
    all = ISZ(Clinician_Name,
              Patient_Name,
              Prescription,
              Scan_Data,
              Authenticate_Clinician,
              Authenticate_Patient,
              Authenticate_Prescription,
              Authentication_fail,
              Authentication_pass,
              Security_Fault),

    dataIns = ISZ(),

    dataOuts = ISZ(Clinician_Name,
                   Patient_Name,
                   Prescription),

    eventIns = ISZ(Scan_Data,
                   Authenticate_Clinician,
                   Authenticate_Patient,
                   Authenticate_Prescription),

    eventOuts = ISZ(Authentication_fail,
                    Authentication_pass,
                    Security_Fault)
  )

  val initialization_api : Security_Thread_imp_Initialization_Api = {
    val api = Security_Thread_imp_Initialization_Api(
      id,
      Clinician_Name.id,
      Patient_Name.id,
      Prescription.id,
      Scan_Data.id,
      Authenticate_Clinician.id,
      Authenticate_Patient.id,
      Authenticate_Prescription.id,
      Authentication_fail.id,
      Authentication_pass.id,
      Security_Fault.id
    )
    Security_Thread_imp_pump_operation_security_subsystem_security_process_security_thread_Bridge.c_initialization_api = Some(api)
    api
  }

  val operational_api : Security_Thread_imp_Operational_Api = {
    val api = Security_Thread_imp_Operational_Api(
      id,
      Clinician_Name.id,
      Patient_Name.id,
      Prescription.id,
      Scan_Data.id,
      Authenticate_Clinician.id,
      Authenticate_Patient.id,
      Authenticate_Prescription.id,
      Authentication_fail.id,
      Authentication_pass.id,
      Security_Fault.id
    )
    Security_Thread_imp_pump_operation_security_subsystem_security_process_security_thread_Bridge.c_operational_api = Some(api)
    api
  }

  val entryPoints : Bridge.EntryPoints =
    Security_Thread_imp_pump_operation_security_subsystem_security_process_security_thread_Bridge.EntryPoints(
      id,

      Clinician_Name.id,
      Patient_Name.id,
      Prescription.id,
      Scan_Data.id,
      Authenticate_Clinician.id,
      Authenticate_Patient.id,
      Authenticate_Prescription.id,
      Authentication_fail.id,
      Authentication_pass.id,
      Security_Fault.id,

      dispatchTriggers,

      initialization_api,
      operational_api)
}

object Security_Thread_imp_pump_operation_security_subsystem_security_process_security_thread_Bridge {

  var c_initialization_api: Option[Security_Thread_imp_Initialization_Api] = None()
  var c_operational_api: Option[Security_Thread_imp_Operational_Api] = None()

  @record class EntryPoints(
    Security_Thread_imp_pump_operation_security_subsystem_security_process_security_thread_BridgeId : Art.BridgeId,

    Clinician_Name_Id : Art.PortId,
    Patient_Name_Id : Art.PortId,
    Prescription_Id : Art.PortId,
    Scan_Data_Id : Art.PortId,
    Authenticate_Clinician_Id : Art.PortId,
    Authenticate_Patient_Id : Art.PortId,
    Authenticate_Prescription_Id : Art.PortId,
    Authentication_fail_Id : Art.PortId,
    Authentication_pass_Id : Art.PortId,
    Security_Fault_Id : Art.PortId,

    dispatchTriggers : Option[ISZ[Art.PortId]],

    initialization_api: Security_Thread_imp_Initialization_Api,
    operational_api: Security_Thread_imp_Operational_Api) extends Bridge.EntryPoints {

    val dataInPortIds: ISZ[Art.PortId] = ISZ()

    val eventInPortIds: ISZ[Art.PortId] = ISZ(Scan_Data_Id,
                                              Authenticate_Clinician_Id,
                                              Authenticate_Patient_Id,
                                              Authenticate_Prescription_Id)

    val dataOutPortIds: ISZ[Art.PortId] = ISZ(Clinician_Name_Id,
                                              Patient_Name_Id,
                                              Prescription_Id)

    val eventOutPortIds: ISZ[Art.PortId] = ISZ(Authentication_fail_Id,
                                               Authentication_pass_Id,
                                               Security_Fault_Id)

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
      val EventTriggered(receivedEvents) = Art.dispatchStatus(Security_Thread_imp_pump_operation_security_subsystem_security_process_security_thread_BridgeId)

      // remove non-dispatching event ports
      val dispatchableEventPorts: ISZ[Art.PortId] =
        if(dispatchTriggers.isEmpty) receivedEvents
        else filter(receivedEvents, dispatchTriggers.get)

      Art.receiveInput(eventInPortIds, dataInPortIds)

      for(portId <- dispatchableEventPorts) {
        if(portId == Scan_Data_Id){
          val Some(PCA_Types.Scan_Data_Type_Payload(value)) = Art.getValue(Scan_Data_Id)
          component.handleScan_Data(operational_api, value)
        }
        else if(portId == Authenticate_Clinician_Id) {
          component.handleAuthenticate_Clinician(operational_api)
        }
        else if(portId == Authenticate_Patient_Id) {
          component.handleAuthenticate_Patient(operational_api)
        }
        else if(portId == Authenticate_Prescription_Id) {
          component.handleAuthenticate_Prescription(operational_api)
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
      val EventTriggered(receivedEvents) = Art.dispatchStatus(Security_Thread_imp_pump_operation_security_subsystem_security_process_security_thread_BridgeId)

      // remove non-dispatching event ports
      val dispatchableEventPorts: ISZ[Art.PortId] =
        if(dispatchTriggers.isEmpty) receivedEvents
        else filter(receivedEvents, dispatchTriggers.get)

      Art.receiveInput(eventInPortIds, dataInPortIds)

      for(portId <- dispatchableEventPorts) {
        if(portId == Scan_Data_Id){
          val Some(PCA_Types.Scan_Data_Type_Payload(value)) = Art.getValue(Scan_Data_Id)
          component.handleScan_Data(operational_api, value)
        }
        else if(portId == Authenticate_Clinician_Id) {
          component.handleAuthenticate_Clinician(operational_api)
        }
        else if(portId == Authenticate_Patient_Id) {
          component.handleAuthenticate_Patient(operational_api)
        }
        else if(portId == Authenticate_Prescription_Id) {
          component.handleAuthenticate_Prescription(operational_api)
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