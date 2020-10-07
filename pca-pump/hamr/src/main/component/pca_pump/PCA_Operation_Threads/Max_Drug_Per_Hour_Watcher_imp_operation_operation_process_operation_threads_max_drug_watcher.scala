// #Sireum

package pca_pump.PCA_Operation_Threads

import org.sireum._
import pca_pump._

// This file will not be overwritten so is safe to edit
object Max_Drug_Per_Hour_Watcher_imp_operation_operation_process_operation_threads_max_drug_watcher {

  def initialise(api: Max_Drug_Per_Hour_Watcher_imp_Initialization_Api): Unit = {
    // example api usage

    api.logInfo("Example info logging")
    api.logDebug("Example debug logging")
    api.logError("Example error logging")

    api.sendNear_Max_Drug_Per_Hour()
    api.sendOver_Max_Drug_Per_Hour()
  }

  def timeTriggered(api: Max_Drug_Per_Hour_Watcher_imp_Operational_Api): Unit = {
    // example api usage

    val apiUsage_Infusion_Flow_Rate: Option[PCA_Types.Flow_Rate] = api.getInfusion_Flow_Rate()
    val apiUsage_Max_Drug_Per_Hour: Option[PCA_Types.Drug_Volume] = api.getMax_Drug_Per_Hour()
    api.sendNear_Max_Drug_Per_Hour()
    api.sendOver_Max_Drug_Per_Hour()
  }

  def activate(api: Max_Drug_Per_Hour_Watcher_imp_Operational_Api): Unit = { }

  def deactivate(api: Max_Drug_Per_Hour_Watcher_imp_Operational_Api): Unit = { }

  def finalise(api: Max_Drug_Per_Hour_Watcher_imp_Operational_Api): Unit = { }

  def recover(api: Max_Drug_Per_Hour_Watcher_imp_Operational_Api): Unit = { }
}
