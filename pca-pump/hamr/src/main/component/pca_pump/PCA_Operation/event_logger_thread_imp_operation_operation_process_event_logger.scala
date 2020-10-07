// #Sireum

package pca_pump.PCA_Operation

import org.sireum._
import pca_pump._

// This file will not be overwritten so is safe to edit
object event_logger_thread_imp_operation_operation_process_event_logger {

  def initialise(api: event_logger_thread_imp_Initialization_Api): Unit = {
    // example api usage

    api.logInfo("Example info logging")
    api.logDebug("Example debug logging")
    api.logError("Example error logging")

    api.sendThe_Event_Log(PCA_Types.Event_Log.empty())
  }

  def handleLog_Event(api: event_logger_thread_imp_Operational_Api, value : PCA_Types.Event_Record): Unit = {
    api.logInfo("example handleLog_Event implementation")
    api.logInfo(s"received ${value}")
  }

  def handleGet_Event_Log(api: event_logger_thread_imp_Operational_Api): Unit = {
    api.logInfo("example handleGet_Event_Log implementation")
    api.logInfo("received Get_Event_Log")
  }

  def activate(api: event_logger_thread_imp_Operational_Api): Unit = { }

  def deactivate(api: event_logger_thread_imp_Operational_Api): Unit = { }

  def finalise(api: event_logger_thread_imp_Operational_Api): Unit = { }

  def recover(api: event_logger_thread_imp_Operational_Api): Unit = { }
}
