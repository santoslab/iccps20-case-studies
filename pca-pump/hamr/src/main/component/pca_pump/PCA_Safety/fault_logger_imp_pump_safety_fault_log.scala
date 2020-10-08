// #Sireum

package pca_pump.PCA_Safety

import org.sireum._
import pca_pump._

// This file will not be overwritten so is safe to edit
object fault_logger_imp_pump_safety_fault_log {

  def initialise(api: fault_logger_imp_Initialization_Api): Unit = {}

  def handleLog_Fault(api: fault_logger_imp_Operational_Api, value : PCA_Types.Fault_Record_imp): Unit = {}

  def handleGet_Log(api: fault_logger_imp_Operational_Api): Unit = {}

  def handlePOST_Failure(api: fault_logger_imp_Operational_Api): Unit = {}

  def handleRAM_Failure(api: fault_logger_imp_Operational_Api): Unit = {}

  def handleROM_Failure(api: fault_logger_imp_Operational_Api): Unit = {}

  def handleCPU_Failure(api: fault_logger_imp_Operational_Api): Unit = {}

  def handleThread_Monitor_Failure(api: fault_logger_imp_Operational_Api): Unit = {}

  def handleVoltage_OOR(api: fault_logger_imp_Operational_Api): Unit = {}

  def activate(api: fault_logger_imp_Operational_Api): Unit = { }

  def deactivate(api: fault_logger_imp_Operational_Api): Unit = { }

  def finalise(api: fault_logger_imp_Operational_Api): Unit = { }

  def recover(api: fault_logger_imp_Operational_Api): Unit = { }
}
