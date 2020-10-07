// #Sireum

package pca_pump.PCA_System

import org.sireum._
import pca_pump._

// This file will not be overwritten so is safe to edit
object maintenance_imp_maint {

  def initialise(api: maintenance_imp_Initialization_Api): Unit = {
    // example api usage

    api.logInfo("Example info logging")
    api.logDebug("Example debug logging")
    api.logError("Example error logging")

    api.sendLoad_Drug_Library(PCA_Types.Drug_Library.empty())
    api.sendGet_Fault_Log()
    api.sendGet_Event_Log()
  }

  def timeTriggered(api: maintenance_imp_Operational_Api): Unit = {
    // example api usage

    val apiUsage_The_Fault_Log: Option[PCA_Types.Fault_Log] = api.getThe_Fault_Log()
    val apiUsage_The_Event_Log: Option[PCA_Types.Event_Log] = api.getThe_Event_Log()
    api.sendLoad_Drug_Library(PCA_Types.Drug_Library.empty())
    api.sendGet_Fault_Log()
    api.sendGet_Event_Log()
  }

  def activate(api: maintenance_imp_Operational_Api): Unit = { }

  def deactivate(api: maintenance_imp_Operational_Api): Unit = { }

  def finalise(api: maintenance_imp_Operational_Api): Unit = { }

  def recover(api: maintenance_imp_Operational_Api): Unit = { }
}
