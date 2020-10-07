// #Sireum

package pca_pump.PCA_Safety

import org.sireum._
import pca_pump._

// This file will not be overwritten so is safe to edit
object fault_logger_imp_pump_safety_fault_log {

  def initialise(api: fault_logger_imp_Initialization_Api): Unit = {
    // example api usage

    api.logInfo("Example info logging")
    api.logDebug("Example debug logging")
    api.logError("Example error logging")

    api.sendThe_Log(PCA_Types.Fault_Log.empty())
  }

  def handleLog_Fault(api: fault_logger_imp_Operational_Api, value : PCA_Types.Fault_Record_imp): Unit = {
    api.logInfo("example handleLog_Fault implementation")
    api.logInfo(s"received ${value}")
  }

  def handleGet_Log(api: fault_logger_imp_Operational_Api): Unit = {
    api.logInfo("example handleGet_Log implementation")
    api.logInfo("received Get_Log")
  }

  def handlePOST_Failure(api: fault_logger_imp_Operational_Api): Unit = {
    api.logInfo("example handlePOST_Failure implementation")
    api.logInfo("received POST_Failure")
  }

  def handleRAM_Failure(api: fault_logger_imp_Operational_Api): Unit = {
    api.logInfo("example handleRAM_Failure implementation")
    api.logInfo("received RAM_Failure")
  }

  def handleROM_Failure(api: fault_logger_imp_Operational_Api): Unit = {
    api.logInfo("example handleROM_Failure implementation")
    api.logInfo("received ROM_Failure")
  }

  def handleCPU_Failure(api: fault_logger_imp_Operational_Api): Unit = {
    api.logInfo("example handleCPU_Failure implementation")
    api.logInfo("received CPU_Failure")
  }

  def handleThread_Monitor_Failure(api: fault_logger_imp_Operational_Api): Unit = {
    api.logInfo("example handleThread_Monitor_Failure implementation")
    api.logInfo("received Thread_Monitor_Failure")
  }

  def handleVoltage_OOR(api: fault_logger_imp_Operational_Api): Unit = {
    api.logInfo("example handleVoltage_OOR implementation")
    api.logInfo("received Voltage_OOR")
  }

  def activate(api: fault_logger_imp_Operational_Api): Unit = { }

  def deactivate(api: fault_logger_imp_Operational_Api): Unit = { }

  def finalise(api: fault_logger_imp_Operational_Api): Unit = { }

  def recover(api: fault_logger_imp_Operational_Api): Unit = { }
}
