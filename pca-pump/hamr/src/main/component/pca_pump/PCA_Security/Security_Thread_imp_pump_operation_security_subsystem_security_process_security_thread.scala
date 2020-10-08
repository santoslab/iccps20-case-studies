// #Sireum

package pca_pump.PCA_Security

import org.sireum._
import pca_pump._
import pca_pump.util.AuxLibrary

// This file will not be overwritten so is safe to edit
object Security_Thread_imp_pump_operation_security_subsystem_security_process_security_thread {

  var currentClinician: Option[String] = None[String]()
  var currentPatient: Option[String] = None[String]()
  var currentPrescription: Option[PCA_Types.Prescription_imp] = None[PCA_Types.Prescription_imp]()

  def initialise(api: Security_Thread_imp_Initialization_Api): Unit = {}

  // data from scanner
  def handleScan_Data(api: Security_Thread_imp_Operational_Api, value : PCA_Types.Scan_Data_Type): Unit = {
    api.logInfo(s"received Scan_Data ${value}")

    value match {
      case PCA_Types.Scan_Clinican_Badge(clinicianName) =>
        currentClinician = Some(clinicianName)

      case PCA_Types.Scan_Patient_Wristband(patientName) =>
        currentPatient = Some(patientName)

      case PCA_Types.Scan_Prescription_Vial(patientName, drugName) =>
        // find the prescription that contains patientName and drugName

        // FIXME:
        //val prescription = AuxLibrary.getPrescriptions().withFilter(p => p.patient == patientName && p.drugName == drugName)
        var prescription: Option[PCA_Types.Prescription_imp] = None[PCA_Types.Prescription_imp]()
        for(p <- AuxLibrary.getPrescriptions() if p.patient == patientName && p.drugName == drugName) {
          prescription = Some(p)
        }

        if (prescription.nonEmpty){
          currentPrescription = Some(prescription.get)
          api.setPrescription(prescription.get)
        } else {
          api.logInfo(s"Could not locate a prescription of ${drugName} for ${patientName}")

          api.sendSecurity_Fault()
        }
      case _ => halt(s"Unhandled $value")
    }
  }

  def handleAuthenticate_Clinician(api: Security_Thread_imp_Operational_Api): Unit = {
    /* req: Exception Case: Clinician Authentication Failure (EC14) {@link https://www.smarturl.it/OPCA#ec_clinicianauthenticationfailure}
     */
    api.logInfo("received Authenticate_Clinician")

    api.logInfo(s"Simulating authentication of clinician: ${currentClinician}")

    currentClinician match {
      case Some(clinicianName) =>
        // FIXME:
        //val authenticated = (AuxLibrary.getClinicians().withFilter(n => n == clinicianName)).size == 1
        var authenticated: B = F
        for(c <- AuxLibrary.getClinicians() if c == clinicianName) {
          authenticated = T
        }

        if (authenticated) {
          api.sendAuthentication_pass()
        } else {
          api.sendAuthentication_fail()
        }
      case _ =>
        api.logError("clinician badge never scanned")
        api.sendSecurity_Fault()
    }
  }

  def handleAuthenticate_Patient(api: Security_Thread_imp_Operational_Api): Unit = {
    /* req: Exception Case: Patient Authentication Failure (EC14) {@link https://www.smarturl.it/OPCA#ec_patientauthenticationfailure}
     */
    api.logInfo("received Authenticate_Patient")

    api.logInfo(s"Simulating authentication of patient: ${currentPatient}")

    currentPatient match {
      case Some(patientName) =>
        // FIXME:
        //val authenticated = (AuxLibrary.getPatients().withFilter(n => n == patientName)).size == 1
        var authenticated: B = F
        for(p <- AuxLibrary.getPatients() if p == patientName) {
          authenticated = T
        }

        if (authenticated) {
          api.sendAuthentication_pass()
        } else {
          api.sendAuthentication_fail()
        }
      case _ =>
        api.logError("patient wristband never scanned")
        api.sendSecurity_Fault()
    }
  }

  def handleAuthenticate_Prescription(api: Security_Thread_imp_Operational_Api): Unit = {
    /* req: Exception Case: Prescription Authentication Failure (EC14) {@link https://www.smarturl.it/OPCA#ec_prescriptionauthenticationfailure}
     */
    api.logInfo("received Authenticate_Prescription")

    api.logInfo(s"Simulating authentication of prescription: ${currentPrescription}")

    (currentPrescription, currentPatient) match {
      case (Some(prescription), Some(patientName)) =>
        val authenticated = true

        if (prescription.patient == patientName) {
          api.sendAuthentication_pass()
        } else {
          api.sendAuthentication_fail()
        }
      case (_, _) =>
        api.logError("vial and/or patient wristband never scanned")
        api.sendSecurity_Fault()
    }
  }

  def activate(api: Security_Thread_imp_Operational_Api): Unit = { }

  def deactivate(api: Security_Thread_imp_Operational_Api): Unit = { }

  def finalise(api: Security_Thread_imp_Operational_Api): Unit = { }

  def recover(api: Security_Thread_imp_Operational_Api): Unit = { }
}
