// #Sireum

package pca_pump.PCA_Security

import org.sireum._
import pca_pump._

// This file will not be overwritten so is safe to edit
object Security_Thread_imp_pump_operation_security_subsystem_security_process_security_thread {

  def initialise(api: Security_Thread_imp_Initialization_Api): Unit = {
    // example api usage

    api.logInfo("Example info logging")
    api.logDebug("Example debug logging")
    api.logError("Example error logging")

    api.setClinician_Name(Base_Types.String_empty())
    api.setPatient_Name(Base_Types.String_empty())
    api.setPrescription(PCA_Types.Prescription_imp.empty())
    api.sendAuthentication_fail()
    api.sendAuthentication_pass()
    api.sendSecurity_Fault()
  }

  def handleScan_Data(api: Security_Thread_imp_Operational_Api, value : PCA_Types.Scan_Data_Type): Unit = {
    api.logInfo("example handleScan_Data implementation")
    api.logInfo(s"received ${value}")
  }

  def handleAuthenticate_Clinician(api: Security_Thread_imp_Operational_Api): Unit = {
    api.logInfo("example handleAuthenticate_Clinician implementation")
    api.logInfo("received Authenticate_Clinician")
  }

  def handleAuthenticate_Patient(api: Security_Thread_imp_Operational_Api): Unit = {
    api.logInfo("example handleAuthenticate_Patient implementation")
    api.logInfo("received Authenticate_Patient")
  }

  def handleAuthenticate_Prescription(api: Security_Thread_imp_Operational_Api): Unit = {
    api.logInfo("example handleAuthenticate_Prescription implementation")
    api.logInfo("received Authenticate_Prescription")
  }

  def activate(api: Security_Thread_imp_Operational_Api): Unit = { }

  def deactivate(api: Security_Thread_imp_Operational_Api): Unit = { }

  def finalise(api: Security_Thread_imp_Operational_Api): Unit = { }

  def recover(api: Security_Thread_imp_Operational_Api): Unit = { }
}
