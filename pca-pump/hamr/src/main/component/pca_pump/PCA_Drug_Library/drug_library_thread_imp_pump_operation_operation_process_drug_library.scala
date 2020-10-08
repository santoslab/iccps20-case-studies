// #Sireum

package pca_pump.PCA_Drug_Library

import org.sireum._
import pca_pump._
import pca_pump.util.AuxLibrary

// This file will not be overwritten so is safe to edit
object drug_library_thread_imp_pump_operation_operation_process_drug_library {

  var drugLibraryLoaded:B = false

  def initialise(api: drug_library_thread_imp_Initialization_Api): Unit = {
    api.logInfo("Initializing assuming that a drug library has been loaded")
    drugLibraryLoaded = true
  }

  def handleLoad_Drug_Library(api: drug_library_thread_imp_Operational_Api, value : PCA_Types.Drug_Library): Unit = {}

  def handleGet_Drug_Record(api: drug_library_thread_imp_Operational_Api, value : PCA_Types.Drug_Code_imp): Unit = {
    api.logInfo(s"received Get_Drug_Record ${value}")

    if(drugLibraryLoaded) {
      AuxLibrary.getDrugRecord(value) match {
        case Some(dr) =>
          api.sendThe_Drug_Record(dr)
          api.logInfo(s"sent The_Drug_Record $dr")
        case _ =>
          // No_Drug_Found aka Drug_Not_In_Library
          api.sendNo_Drug_Found()
          api.logInfo(s"sent No_Drug_Found")
      }
    } else {
      api.logError("Drug Library not loaded -- how to handle??")
    }
  }

  def activate(api: drug_library_thread_imp_Operational_Api): Unit = { }

  def deactivate(api: drug_library_thread_imp_Operational_Api): Unit = { }

  def finalise(api: drug_library_thread_imp_Operational_Api): Unit = { }

  def recover(api: drug_library_thread_imp_Operational_Api): Unit = { }
}
