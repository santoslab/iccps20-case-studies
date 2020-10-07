// #Sireum

package pca_pump.PCA_Operation_Threads

import org.sireum._
import pca_pump._

// This file will not be overwritten so is safe to edit
object ICE_Thread_imp_operation_operation_process_operation_threads_ice_thread {

  def initialise(api: ICE_Thread_imp_Initialization_Api): Unit = {
    // example api usage

    api.logInfo("Example info logging")
    api.logDebug("Example debug logging")
    api.logError("Example error logging")

    api.sendICE_Stop_Pump()
  }

  def handleAlarm(api: ICE_Thread_imp_Operational_Api, value : PCA_Types.Alarm_Type.Type): Unit = {
    api.logInfo("example handleAlarm implementation")
    api.logInfo(s"received ${value}")
  }

  def handleWarning(api: ICE_Thread_imp_Operational_Api, value : PCA_Types.Warning_Type.Type): Unit = {
    api.logInfo("example handleWarning implementation")
    api.logInfo(s"received ${value}")
  }

  def handleCP_Bolus_Duration(api: ICE_Thread_imp_Operational_Api, value : ICE_Types.Minute): Unit = {
    api.logInfo("example handleCP_Bolus_Duration implementation")
    api.logInfo(s"received ${value}")
  }

  def handleRx_Okay(api: ICE_Thread_imp_Operational_Api): Unit = {
    api.logInfo("example handleRx_Okay implementation")
    api.logInfo("received Rx_Okay")
  }

  def handlePatient_Request_Not_Too_Soon(api: ICE_Thread_imp_Operational_Api): Unit = {
    api.logInfo("example handlePatient_Request_Not_Too_Soon implementation")
    api.logInfo("received Patient_Request_Not_Too_Soon")
  }

  def handlePatient_Request_Too_Soon(api: ICE_Thread_imp_Operational_Api): Unit = {
    api.logInfo("example handlePatient_Request_Too_Soon implementation")
    api.logInfo("received Patient_Request_Too_Soon")
  }

  def handleHW_Detected_Failure(api: ICE_Thread_imp_Operational_Api): Unit = {
    api.logInfo("example handleHW_Detected_Failure implementation")
    api.logInfo("received HW_Detected_Failure")
  }

  def handleStop_Pump_Completely(api: ICE_Thread_imp_Operational_Api): Unit = {
    api.logInfo("example handleStop_Pump_Completely implementation")
    api.logInfo("received Stop_Pump_Completely")
  }

  def handlePump_At_KVO_Rate(api: ICE_Thread_imp_Operational_Api): Unit = {
    api.logInfo("example handlePump_At_KVO_Rate implementation")
    api.logInfo("received Pump_At_KVO_Rate")
  }

  def handleCP_Clinician_Request_Bolus(api: ICE_Thread_imp_Operational_Api): Unit = {
    api.logInfo("example handleCP_Clinician_Request_Bolus implementation")
    api.logInfo("received CP_Clinician_Request_Bolus")
  }

  def handleHalt_Infusion(api: ICE_Thread_imp_Operational_Api): Unit = {
    api.logInfo("example handleHalt_Infusion implementation")
    api.logInfo("received Halt_Infusion")
  }

  def handleBegin_Infusion(api: ICE_Thread_imp_Operational_Api): Unit = {
    api.logInfo("example handleBegin_Infusion implementation")
    api.logInfo("received Begin_Infusion")
  }

  def handleNear_Max_Drug_Per_Hour(api: ICE_Thread_imp_Operational_Api): Unit = {
    api.logInfo("example handleNear_Max_Drug_Per_Hour implementation")
    api.logInfo("received Near_Max_Drug_Per_Hour")
  }

  def handleOver_Max_Drug_Per_Hour(api: ICE_Thread_imp_Operational_Api): Unit = {
    api.logInfo("example handleOver_Max_Drug_Per_Hour implementation")
    api.logInfo("received Over_Max_Drug_Per_Hour")
  }

  def activate(api: ICE_Thread_imp_Operational_Api): Unit = { }

  def deactivate(api: ICE_Thread_imp_Operational_Api): Unit = { }

  def finalise(api: ICE_Thread_imp_Operational_Api): Unit = { }

  def recover(api: ICE_Thread_imp_Operational_Api): Unit = { }
}
