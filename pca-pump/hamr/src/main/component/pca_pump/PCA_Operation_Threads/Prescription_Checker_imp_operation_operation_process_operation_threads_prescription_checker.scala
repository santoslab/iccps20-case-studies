// #Sireum

package pca_pump.PCA_Operation_Threads

import org.sireum._
import pca_pump._

// This file will not be overwritten so is safe to edit
object Prescription_Checker_imp_operation_operation_process_operation_threads_prescription_checker {

  def initialise(api: Prescription_Checker_imp_Initialization_Api): Unit = {
    // example api usage

    api.logInfo("Example info logging")
    api.logDebug("Example debug logging")
    api.logError("Example error logging")

    api.setVTBI(PCA_Types.Drug_Volume.empty())
    api.setSquare_Bolus_Rate(PCA_Types.Flow_Rate.empty())
    api.setPatient_Bolus_Rate(PCA_Types.Flow_Rate.empty())
    api.setBasal_Rate(PCA_Types.Flow_Rate.empty())
    api.setMinimum_Time_Between_Bolus(ICE_Types.Minute.empty())
    api.setMax_Drug_Per_Hour(PCA_Types.Drug_Volume.empty())
    api.sendGet_Drug_Record(PCA_Types.Drug_Code.empty())
    api.sendRx_Okay()
    api.sendSoft_Limit_Warning()
    api.sendHard_Limit_Violated()
  }

  def handleThe_Drug_Record(api: Prescription_Checker_imp_Operational_Api, value : PCA_Types.Drug_Record): Unit = {
    api.logInfo("example handleThe_Drug_Record implementation")
    api.logInfo(s"received ${value}")
  }

  def handleCheck_Rx(api: Prescription_Checker_imp_Operational_Api): Unit = {
    api.logInfo("example handleCheck_Rx implementation")
    api.logInfo("received Check_Rx")
  }

  def handleDrug_Not_In_Library(api: Prescription_Checker_imp_Operational_Api): Unit = {
    api.logInfo("example handleDrug_Not_In_Library implementation")
    api.logInfo("received Drug_Not_In_Library")
  }

  def handleConfirm_Soft_Limit_Exception(api: Prescription_Checker_imp_Operational_Api): Unit = {
    api.logInfo("example handleConfirm_Soft_Limit_Exception implementation")
    api.logInfo("received Confirm_Soft_Limit_Exception")
  }

  def handleReject_Soft_Limit_Exception(api: Prescription_Checker_imp_Operational_Api): Unit = {
    api.logInfo("example handleReject_Soft_Limit_Exception implementation")
    api.logInfo("received Reject_Soft_Limit_Exception")
  }

  def activate(api: Prescription_Checker_imp_Operational_Api): Unit = { }

  def deactivate(api: Prescription_Checker_imp_Operational_Api): Unit = { }

  def finalise(api: Prescription_Checker_imp_Operational_Api): Unit = { }

  def recover(api: Prescription_Checker_imp_Operational_Api): Unit = { }
}
