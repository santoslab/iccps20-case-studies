// #Sireum

package pca_pump.PCA_Alarm

import org.sireum._
import pca_pump._

// This file will not be overwritten so is safe to edit
object alarm_thread_imp_safety_alarm_process_alarm_thr {

  def initialise(api: alarm_thread_imp_Initialization_Api): Unit = {
    // example api usage

    api.logInfo("Example info logging")
    api.logDebug("Example debug logging")
    api.logError("Example error logging")

    api.sendAlarm(PCA_Types.Alarm_Type.byOrdinal(0).get)
    api.sendWarning(PCA_Types.Warning_Type.byOrdinal(0).get)
    api.sendLog_Fault(PCA_Types.Fault_Record.empty())
    api.sendICE_Immediate()
    api.sendICE_Prompt()
    api.sendICE_Delayed()
    api.sendICE_Malfunction()
    api.sendStop_Pump_Completely()
    api.sendPump_At_KVO_Rate()
  }

  def handleICE_Alarm_Signal(api: alarm_thread_imp_Operational_Api, value : ICE_Types.Alarm_Signal.Type): Unit = {
    api.logInfo("example handleICE_Alarm_Signal implementation")
    api.logInfo(s"received ${value}")
  }

  def handleICE_Reset_Alarm(api: alarm_thread_imp_Operational_Api): Unit = {
    api.logInfo("example handleICE_Reset_Alarm implementation")
    api.logInfo("received ICE_Reset_Alarm")
  }

  def handleMax_Dose_Warning(api: alarm_thread_imp_Operational_Api): Unit = {
    api.logInfo("example handleMax_Dose_Warning implementation")
    api.logInfo("received Max_Dose_Warning")
  }

  def handleHard_Limit_Violation(api: alarm_thread_imp_Operational_Api): Unit = {
    api.logInfo("example handleHard_Limit_Violation implementation")
    api.logInfo("received Hard_Limit_Violation")
  }

  def handleEmpty_Res(api: alarm_thread_imp_Operational_Api): Unit = {
    api.logInfo("example handleEmpty_Res implementation")
    api.logInfo("received Empty_Res")
  }

  def handleLow_Res(api: alarm_thread_imp_Operational_Api): Unit = {
    api.logInfo("example handleLow_Res implementation")
    api.logInfo("received Low_Res")
  }

  def handlePump_Hot(api: alarm_thread_imp_Operational_Api): Unit = {
    api.logInfo("example handlePump_Hot implementation")
    api.logInfo("received Pump_Hot")
  }

  def handleUpstream_Occlusion(api: alarm_thread_imp_Operational_Api): Unit = {
    api.logInfo("example handleUpstream_Occlusion implementation")
    api.logInfo("received Upstream_Occlusion")
  }

  def handleDownstream_Occlusion(api: alarm_thread_imp_Operational_Api): Unit = {
    api.logInfo("example handleDownstream_Occlusion implementation")
    api.logInfo("received Downstream_Occlusion")
  }

  def handleBubble(api: alarm_thread_imp_Operational_Api): Unit = {
    api.logInfo("example handleBubble implementation")
    api.logInfo("received Bubble")
  }

  def handlePrime_Failure(api: alarm_thread_imp_Operational_Api): Unit = {
    api.logInfo("example handlePrime_Failure implementation")
    api.logInfo("received Prime_Failure")
  }

  def handleCP_Reset_Alarm(api: alarm_thread_imp_Operational_Api): Unit = {
    api.logInfo("example handleCP_Reset_Alarm implementation")
    api.logInfo("received CP_Reset_Alarm")
  }

  def handleDrug_Not_In_Library(api: alarm_thread_imp_Operational_Api): Unit = {
    api.logInfo("example handleDrug_Not_In_Library implementation")
    api.logInfo("received Drug_Not_In_Library")
  }

  def handleDefective_Btty(api: alarm_thread_imp_Operational_Api): Unit = {
    api.logInfo("example handleDefective_Btty implementation")
    api.logInfo("received Defective_Btty")
  }

  def handleLow_Battery_Warning(api: alarm_thread_imp_Operational_Api): Unit = {
    api.logInfo("example handleLow_Battery_Warning implementation")
    api.logInfo("received Low_Battery_Warning")
  }

  def handleVoltage_OOR(api: alarm_thread_imp_Operational_Api): Unit = {
    api.logInfo("example handleVoltage_OOR implementation")
    api.logInfo("received Voltage_OOR")
  }

  def handleBasal_Overinfusion(api: alarm_thread_imp_Operational_Api): Unit = {
    api.logInfo("example handleBasal_Overinfusion implementation")
    api.logInfo("received Basal_Overinfusion")
  }

  def handleBolus_Overinfusion(api: alarm_thread_imp_Operational_Api): Unit = {
    api.logInfo("example handleBolus_Overinfusion implementation")
    api.logInfo("received Bolus_Overinfusion")
  }

  def handleSquare_Bolus_Overinfusion(api: alarm_thread_imp_Operational_Api): Unit = {
    api.logInfo("example handleSquare_Bolus_Overinfusion implementation")
    api.logInfo("received Square_Bolus_Overinfusion")
  }

  def handleBasal_Underinfusion(api: alarm_thread_imp_Operational_Api): Unit = {
    api.logInfo("example handleBasal_Underinfusion implementation")
    api.logInfo("received Basal_Underinfusion")
  }

  def handleBolus_Underinfusion(api: alarm_thread_imp_Operational_Api): Unit = {
    api.logInfo("example handleBolus_Underinfusion implementation")
    api.logInfo("received Bolus_Underinfusion")
  }

  def handleSquare_Bolus_Underinfusion(api: alarm_thread_imp_Operational_Api): Unit = {
    api.logInfo("example handleSquare_Bolus_Underinfusion implementation")
    api.logInfo("received Square_Bolus_Underinfusion")
  }

  def handleSecurity_Fault(api: alarm_thread_imp_Operational_Api): Unit = {
    api.logInfo("example handleSecurity_Fault implementation")
    api.logInfo("received Security_Fault")
  }

  def activate(api: alarm_thread_imp_Operational_Api): Unit = { }

  def deactivate(api: alarm_thread_imp_Operational_Api): Unit = { }

  def finalise(api: alarm_thread_imp_Operational_Api): Unit = { }

  def recover(api: alarm_thread_imp_Operational_Api): Unit = { }
}
