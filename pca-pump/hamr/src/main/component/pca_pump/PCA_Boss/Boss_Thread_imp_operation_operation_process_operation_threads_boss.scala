// #Sireum

package pca_pump.PCA_Boss

import org.sireum._
import pca_pump._

// This file will not be overwritten so is safe to edit
object Boss_Thread_imp_operation_operation_process_operation_threads_boss {

  def initialise(api: Boss_Thread_imp_Initialization_Api): Unit = {
    // example api usage

    api.logInfo("Example info logging")
    api.logDebug("Example debug logging")
    api.logError("Example error logging")

    api.sendDisplay_Message(PCA_Types.Message.byOrdinal(0).get)
    api.sendSound_Type(PCA_Types.Sound.byOrdinal(0).get)
    api.sendLog_Event(PCA_Types.Event_Record.empty())
    api.sendDo_Scan()
    api.sendAuthenticate_Clinician()
    api.sendAuthenticate_Patient()
    api.sendAuthenticate_Prescription()
    api.sendCheck_Rx()
    api.sendBegin_Priming()
    api.sendEnd_Priming()
    api.sendPrime_Failure()
    api.sendBegin_Infusion()
    api.sendHalt_Infusion()
  }

  def handlePOST_done(api: Boss_Thread_imp_Operational_Api): Unit = {
    api.logInfo("example handlePOST_done implementation")
    api.logInfo("received POST_done")
  }

  def handlePOST_fail(api: Boss_Thread_imp_Operational_Api): Unit = {
    api.logInfo("example handlePOST_fail implementation")
    api.logInfo("received POST_fail")
  }

  def handleStop_Button_Pressed(api: Boss_Thread_imp_Operational_Api): Unit = {
    api.logInfo("example handleStop_Button_Pressed implementation")
    api.logInfo("received Stop_Button_Pressed")
  }

  def handleStart_Button_Pressed(api: Boss_Thread_imp_Operational_Api): Unit = {
    api.logInfo("example handleStart_Button_Pressed implementation")
    api.logInfo("received Start_Button_Pressed")
  }

  def handleScan_Done(api: Boss_Thread_imp_Operational_Api): Unit = {
    api.logInfo("example handleScan_Done implementation")
    api.logInfo("received Scan_Done")
  }

  def handleAuthentication_fail(api: Boss_Thread_imp_Operational_Api): Unit = {
    api.logInfo("example handleAuthentication_fail implementation")
    api.logInfo("received Authentication_fail")
  }

  def handleAuthentication_pass(api: Boss_Thread_imp_Operational_Api): Unit = {
    api.logInfo("example handleAuthentication_pass implementation")
    api.logInfo("received Authentication_pass")
  }

  def handleDrug_Not_In_Library(api: Boss_Thread_imp_Operational_Api): Unit = {
    api.logInfo("example handleDrug_Not_In_Library implementation")
    api.logInfo("received Drug_Not_In_Library")
  }

  def handleHard_Limit_Violated(api: Boss_Thread_imp_Operational_Api): Unit = {
    api.logInfo("example handleHard_Limit_Violated implementation")
    api.logInfo("received Hard_Limit_Violated")
  }

  def handleReject_Soft_Limit_Exception(api: Boss_Thread_imp_Operational_Api): Unit = {
    api.logInfo("example handleReject_Soft_Limit_Exception implementation")
    api.logInfo("received Reject_Soft_Limit_Exception")
  }

  def handleConfirm_Soft_Limit_Exception(api: Boss_Thread_imp_Operational_Api): Unit = {
    api.logInfo("example handleConfirm_Soft_Limit_Exception implementation")
    api.logInfo("received Confirm_Soft_Limit_Exception")
  }

  def handleRx_Okay(api: Boss_Thread_imp_Operational_Api): Unit = {
    api.logInfo("example handleRx_Okay implementation")
    api.logInfo("received Rx_Okay")
  }

  def handleDoor_Closed(api: Boss_Thread_imp_Operational_Api): Unit = {
    api.logInfo("example handleDoor_Closed implementation")
    api.logInfo("received Door_Closed")
  }

  def handleTurn_Off(api: Boss_Thread_imp_Operational_Api): Unit = {
    api.logInfo("example handleTurn_Off implementation")
    api.logInfo("received Turn_Off")
  }

  def activate(api: Boss_Thread_imp_Operational_Api): Unit = { }

  def deactivate(api: Boss_Thread_imp_Operational_Api): Unit = { }

  def finalise(api: Boss_Thread_imp_Operational_Api): Unit = { }

  def recover(api: Boss_Thread_imp_Operational_Api): Unit = { }
}
