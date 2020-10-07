// #Sireum

package pca_pump.PCA_Operation_Threads

import org.sireum._
import pca_pump._

// This file will not be overwritten so is safe to edit
object Patient_Bolus_Checker_imp_operation_operation_process_operation_threads_patient_bolus_checker {

  def initialise(api: Patient_Bolus_Checker_imp_Initialization_Api): Unit = {
    // example api usage

    api.logInfo("Example info logging")
    api.logDebug("Example debug logging")
    api.logError("Example error logging")

    api.sendPatient_Request_Not_Too_Soon()
    api.sendPatient_Request_Too_Soon()
  }

  def handlePatient_Button_Request(api: Patient_Bolus_Checker_imp_Operational_Api): Unit = {
    api.logInfo("example handlePatient_Button_Request implementation")
    api.logInfo("received Patient_Button_Request")
  }

  def activate(api: Patient_Bolus_Checker_imp_Operational_Api): Unit = { }

  def deactivate(api: Patient_Bolus_Checker_imp_Operational_Api): Unit = { }

  def finalise(api: Patient_Bolus_Checker_imp_Operational_Api): Unit = { }

  def recover(api: Patient_Bolus_Checker_imp_Operational_Api): Unit = { }
}
