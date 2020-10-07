// #Sireum

package pca_pump.PCA_Drug_Library

import org.sireum._
import pca_pump._

// This file will not be overwritten so is safe to edit
object drug_library_thread_imp_operation_operation_process_drug_library {

  def initialise(api: drug_library_thread_imp_Initialization_Api): Unit = {
    // example api usage

    api.logInfo("Example info logging")
    api.logDebug("Example debug logging")
    api.logError("Example error logging")

    api.sendThe_Drug_Record(PCA_Types.Drug_Record.empty())
    api.sendNo_Drug_Found()
  }

  def handleLoad_Drug_Library(api: drug_library_thread_imp_Operational_Api, value : PCA_Types.Drug_Library): Unit = {
    api.logInfo("example handleLoad_Drug_Library implementation")
    api.logInfo(s"received ${value}")
  }

  def handleGet_Drug_Record(api: drug_library_thread_imp_Operational_Api, value : PCA_Types.Drug_Code): Unit = {
    api.logInfo("example handleGet_Drug_Record implementation")
    api.logInfo(s"received ${value}")
  }

  def activate(api: drug_library_thread_imp_Operational_Api): Unit = { }

  def deactivate(api: drug_library_thread_imp_Operational_Api): Unit = { }

  def finalise(api: drug_library_thread_imp_Operational_Api): Unit = { }

  def recover(api: drug_library_thread_imp_Operational_Api): Unit = { }
}
