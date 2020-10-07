// #Sireum

package pca_pump.PCA_Control_Panel

import org.sireum._
import pca_pump._

// This file will not be overwritten so is safe to edit
object ui_thread_imp_operation_control_panel_ui_process_ui_thread {

  def initialise(api: ui_thread_imp_Initialization_Api): Unit = {
    // example api usage

    api.logInfo("Example info logging")
    api.logDebug("Example debug logging")
    api.logError("Example error logging")

    api.setImage(PCA_Types.Image.empty())
    api.setAudioSignal(PCA_Types.Sound.byOrdinal(0).get)
    api.setAlarm_Inactivation(ICE_Types.Alarm_Signal.byOrdinal(0).get)
    api.sendBolus_Duration(ICE_Types.Minute.empty())
    api.sendCP_Reset_Alarm()
    api.sendConfirm_Soft_Limit_Exception()
    api.sendReject_Soft_Limit_Exception()
    api.sendStop_Button_Pressed()
    api.sendStart_Button_Pressed()
    api.sendClinician_Request_Bolus()
    api.sendPause_Infusion()
    api.sendResume_Infusion()
    api.sendTurn_Off()
  }

  def handleTouch(api: ui_thread_imp_Operational_Api, value : PCA_Types.Touch): Unit = {
    api.logInfo("example handleTouch implementation")
    api.logInfo(s"received ${value}")
  }

  def handleAlarm(api: ui_thread_imp_Operational_Api, value : PCA_Types.Alarm_Type.Type): Unit = {
    api.logInfo("example handleAlarm implementation")
    api.logInfo(s"received ${value}")
  }

  def handleWarning(api: ui_thread_imp_Operational_Api, value : PCA_Types.Warning_Type.Type): Unit = {
    api.logInfo("example handleWarning implementation")
    api.logInfo(s"received ${value}")
  }

  def handleSystem_Status(api: ui_thread_imp_Operational_Api, value : PCA_Types.Status_Type.Type): Unit = {
    api.logInfo("example handleSystem_Status implementation")
    api.logInfo(s"received ${value}")
  }

  def handleDisplay_Message(api: ui_thread_imp_Operational_Api, value : PCA_Types.Message.Type): Unit = {
    api.logInfo("example handleDisplay_Message implementation")
    api.logInfo(s"received ${value}")
  }

  def handleSound_Type(api: ui_thread_imp_Operational_Api, value : PCA_Types.Sound.Type): Unit = {
    api.logInfo("example handleSound_Type implementation")
    api.logInfo(s"received ${value}")
  }

  def handleLow_Battery_Warning(api: ui_thread_imp_Operational_Api): Unit = {
    api.logInfo("example handleLow_Battery_Warning implementation")
    api.logInfo("received Low_Battery_Warning")
  }

  def handleHard_Limit_Violated(api: ui_thread_imp_Operational_Api): Unit = {
    api.logInfo("example handleHard_Limit_Violated implementation")
    api.logInfo("received Hard_Limit_Violated")
  }

  def handleSoft_Limit_Warning(api: ui_thread_imp_Operational_Api): Unit = {
    api.logInfo("example handleSoft_Limit_Warning implementation")
    api.logInfo("received Soft_Limit_Warning")
  }

  def handlePatient_Request_Not_Too_Soon(api: ui_thread_imp_Operational_Api): Unit = {
    api.logInfo("example handlePatient_Request_Not_Too_Soon implementation")
    api.logInfo("received Patient_Request_Not_Too_Soon")
  }

  def handlePatient_Request_Too_Soon(api: ui_thread_imp_Operational_Api): Unit = {
    api.logInfo("example handlePatient_Request_Too_Soon implementation")
    api.logInfo("received Patient_Request_Too_Soon")
  }

  def activate(api: ui_thread_imp_Operational_Api): Unit = { }

  def deactivate(api: ui_thread_imp_Operational_Api): Unit = { }

  def finalise(api: ui_thread_imp_Operational_Api): Unit = { }

  def recover(api: ui_thread_imp_Operational_Api): Unit = { }
}
