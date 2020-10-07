// #Sireum

package pca_pump.PCA_Operation_Threads

import org.sireum._
import pca_pump._

// This file will not be overwritten so is safe to edit
object Rate_Controller_imp_operation_operation_process_operation_threads_rate_controller {

  def initialise(api: Rate_Controller_imp_Initialization_Api): Unit = {
    // example api usage

    api.logInfo("Example info logging")
    api.logDebug("Example debug logging")
    api.logError("Example error logging")

    api.setInfusion_Flow_Rate(PCA_Types.Flow_Rate.empty())
    api.sendSystem_Status(PCA_Types.Status_Type.byOrdinal(0).get)
  }

  def handleAlarm(api: Rate_Controller_imp_Operational_Api, value : PCA_Types.Alarm_Type.Type): Unit = {
    api.logInfo("example handleAlarm implementation")
    api.logInfo(s"received ${value}")
  }

  def handleWarning(api: Rate_Controller_imp_Operational_Api, value : PCA_Types.Warning_Type.Type): Unit = {
    api.logInfo("example handleWarning implementation")
    api.logInfo(s"received ${value}")
  }

  def handleCP_Bolus_Duration(api: Rate_Controller_imp_Operational_Api, value : ICE_Types.Minute): Unit = {
    api.logInfo("example handleCP_Bolus_Duration implementation")
    api.logInfo(s"received ${value}")
  }

  def handleBegin_Infusion(api: Rate_Controller_imp_Operational_Api): Unit = {
    api.logInfo("example handleBegin_Infusion implementation")
    api.logInfo("received Begin_Infusion")
  }

  def handleBegin_Priming(api: Rate_Controller_imp_Operational_Api): Unit = {
    api.logInfo("example handleBegin_Priming implementation")
    api.logInfo("received Begin_Priming")
  }

  def handleEnd_Priming(api: Rate_Controller_imp_Operational_Api): Unit = {
    api.logInfo("example handleEnd_Priming implementation")
    api.logInfo("received End_Priming")
  }

  def handleHalt_Infusion(api: Rate_Controller_imp_Operational_Api): Unit = {
    api.logInfo("example handleHalt_Infusion implementation")
    api.logInfo("received Halt_Infusion")
  }

  def handleHW_Detected_Failure(api: Rate_Controller_imp_Operational_Api): Unit = {
    api.logInfo("example handleHW_Detected_Failure implementation")
    api.logInfo("received HW_Detected_Failure")
  }

  def handleStop_Pump_Completely(api: Rate_Controller_imp_Operational_Api): Unit = {
    api.logInfo("example handleStop_Pump_Completely implementation")
    api.logInfo("received Stop_Pump_Completely")
  }

  def handlePump_At_KVO_Rate(api: Rate_Controller_imp_Operational_Api): Unit = {
    api.logInfo("example handlePump_At_KVO_Rate implementation")
    api.logInfo("received Pump_At_KVO_Rate")
  }

  def handlePatient_Request_Not_Too_Soon(api: Rate_Controller_imp_Operational_Api): Unit = {
    api.logInfo("example handlePatient_Request_Not_Too_Soon implementation")
    api.logInfo("received Patient_Request_Not_Too_Soon")
  }

  def handlePause_Infusion(api: Rate_Controller_imp_Operational_Api): Unit = {
    api.logInfo("example handlePause_Infusion implementation")
    api.logInfo("received Pause_Infusion")
  }

  def handleResume_Infusion(api: Rate_Controller_imp_Operational_Api): Unit = {
    api.logInfo("example handleResume_Infusion implementation")
    api.logInfo("received Resume_Infusion")
  }

  def handleCP_Clinician_Request_Bolus(api: Rate_Controller_imp_Operational_Api): Unit = {
    api.logInfo("example handleCP_Clinician_Request_Bolus implementation")
    api.logInfo("received CP_Clinician_Request_Bolus")
  }

  def handleNear_Max_Drug_Per_Hour(api: Rate_Controller_imp_Operational_Api): Unit = {
    api.logInfo("example handleNear_Max_Drug_Per_Hour implementation")
    api.logInfo("received Near_Max_Drug_Per_Hour")
  }

  def handleOver_Max_Drug_Per_Hour(api: Rate_Controller_imp_Operational_Api): Unit = {
    api.logInfo("example handleOver_Max_Drug_Per_Hour implementation")
    api.logInfo("received Over_Max_Drug_Per_Hour")
  }

  def handleICE_Stop_Pump(api: Rate_Controller_imp_Operational_Api): Unit = {
    api.logInfo("example handleICE_Stop_Pump implementation")
    api.logInfo("received ICE_Stop_Pump")
  }

  def activate(api: Rate_Controller_imp_Operational_Api): Unit = { }

  def deactivate(api: Rate_Controller_imp_Operational_Api): Unit = { }

  def finalise(api: Rate_Controller_imp_Operational_Api): Unit = { }

  def recover(api: Rate_Controller_imp_Operational_Api): Unit = { }
}
