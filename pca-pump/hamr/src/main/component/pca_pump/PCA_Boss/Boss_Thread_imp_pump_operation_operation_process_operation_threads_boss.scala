// #Sireum

package pca_pump.PCA_Boss

import org.sireum._
import pca_pump.PCA_Types.Generic_Event
import pca_pump._
import pca_pump.util.PCA_Properties

// This file will not be overwritten so is safe to edit
object Boss_Thread_imp_pump_operation_operation_process_operation_threads_boss {

  val errorCaseTimeoutEvent: String = "errorCaseTimeoutEvent"
  val makeSoundTimeoutEvent: String = "makeSoundTimeoutEvent"
  val primingTimeoutEvent: String = "primingTimeoutEvent"
  val postFailTimeoutEvent: String = "postFailTimeoutEvent"

  var currentMode: BossMode.Type = BossMode.UC1_1_press_power_switch

  def initialise(api: Boss_Thread_imp_Initialization_Api): Unit = {
    setMode(api, BossMode.EC4_POST)
  }

  def handlePOST_done(api: Boss_Thread_imp_Operational_Api): Unit = {
    api.logInfo("received POST_done")

    currentMode match {
      case BossMode.EC4_POST =>

        // audio check
        setMode(api, BossMode.UC1_2_make_sound)
        api.sendDisplay_Message(PCA_Types.Message.If_Beep_Press_Stop_Button)
        api.sendSound_Type(PCA_Types.Sound.Beep)

        def cb(): Unit = {
          // button not pressed in time, show sound failure
          api.sendDisplay_Message(PCA_Types.Message.Sound_Failure)
          api.sendSound_Type(PCA_Types.Sound.Silence)

          setMode(api, BossMode.EC17_audio_fail)

          transitionToUC1_19_display_turn_off_pump(api, 15000)
        }
      // clinician has 10 seconds to press the stop button
      art.ArtTimer.setTimeout(api.id, makeSoundTimeoutEvent, 10000, true, cb _)

      case _ =>
        api.logError(s"Wasn't expecting POST_done while mode is $currentMode")
    }
  }

  def handlePOST_fail(api: Boss_Thread_imp_Operational_Api): Unit = {
    api.logInfo("received POST_fail")

    currentMode match {
      case BossMode.EC4_POST =>

        setMode(api, BossMode.EC4_POST_fail)
        api.sendDisplay_Message(PCA_Types.Message.POST_fail)
        api.sendSound_Type(PCA_Types.Sound.Beep)

        def cb(): Unit = {
          api.sendSound_Type(PCA_Types.Sound.Silence)
          UC1_19_display_turn_off_pump(api)
        }
      // pump will beep for 2 seconds before displaying turn off message
      art.ArtTimer.setTimeout(api.id, postFailTimeoutEvent, 2000, true, cb _)
      case _ =>
        api.logError(s"Wasn't expecting POST_fail while mode is $currentMode")
    }
  }

  def handleStop_Button_Pressed(api: Boss_Thread_imp_Operational_Api): Unit = {
    api.logInfo(s"received Stop_Button_Pressed")

    def fail(): Unit = {
      api.logInfo("Stop button pressed in time while in error case")
      art.ArtTimer.clearTimeout(errorCaseTimeoutEvent) // cancel the timeout event

      UC1_19_display_turn_off_pump(api)
    }

    currentMode match {

      case BossMode.UC1_9_drug_not_in_library => fail()
      case BossMode.EC2_soft_limit_rejected => fail()
      case BossMode.EC3_hard_limit_fail => fail()
      case BossMode.EC6_display_priming_fail => fail()
      case BossMode.EC14_clinician_authentication_fail => fail()
      case BossMode.EC15_patient_authentication_fail => fail()
      case BossMode.EC16_Rx_authentication_fail => fail()
      case BossMode.EC17_audio_fail => fail()

      case BossMode.UC1_2_make_sound =>
        api.logInfo("Stop button pressed after sound test")

        art.ArtTimer.clearTimeout(makeSoundTimeoutEvent)

        setMode(api, BossMode.UC1_3_display_scan_badge)
        setMode(api, BossMode.UC1_3_do_scan)

        api.sendDisplay_Message(PCA_Types.Message.Scan_Badge)
        api.sendSound_Type(PCA_Types.Sound.Silence)

      case BossMode.UC1_12_prime_start =>
        api.logInfo("Stop button pressed in time after priming start")

        art.ArtTimer.clearTimeout(primingTimeoutEvent)

        setMode(api, BossMode.UC1_13_display_insert_needle)

        api.sendDisplay_Message(PCA_Types.Message.Insert_Needle_Then_Press_Start)

        api.sendEnd_Priming()

      case BossMode.UC1_15_continue_basal =>
        setMode(api, BossMode.UC1_16_stop_button_pressed)

        api.sendHalt_Infusion()

      case _ =>
        api.logError(s"Wasn't expecting Stop_Button_Pressed while mode is $currentMode")
    }
  }

  def handleStart_Button_Pressed(api: Boss_Thread_imp_Operational_Api): Unit = {
    api.logInfo(s"received Start_Button_Pressed")

    currentMode match {
      case BossMode.UC1_12_display_prime_pump =>
        api.logInfo(s"start button pressed after prime pump message")

        setMode(api, BossMode.UC1_12_prime_start)

        api.sendBegin_Priming()

        api.sendDisplay_Message(PCA_Types.Message.Press_stop_to_end_priming)

        // Begin_Priming will cause the rate controller to begin
        // pumping at PrimeRate.  Boss thread waits until
        //   a) clinician presses the stop button OR
        //   b) a timeout occurs in which case we go into an EC6_display_priming_fail

        def timeoutHandler(): Unit = {
          api.logInfo("Timeout occurred before Stop button pressed")

          // send prime_failure to alarm_thr
          api.sendPrime_Failure()

          api.sendEnd_Priming()

          setMode(api, BossMode.EC6_display_priming_fail)

          transitionToUC1_19_display_turn_off_pump(api, 90000)
        }

      // clinican has 'PrimeTime' ms to press the stop button once priming starts
      art.ArtTimer.setTimeout(api.id, primingTimeoutEvent, PCA_Properties.PrimeTime, true, timeoutHandler _)

      case BossMode.UC1_13_display_insert_needle =>
        api.logInfo("start button pressed after needle inserted")

        setMode(api, BossMode.UC1_15_continue_basal)

        api.sendBegin_Infusion()

        api.sendDisplay_Message(PCA_Types.Message.No_Message)

      case BossMode.UC1_16_stop_button_pressed =>
        api.logInfo("resuming infusion")

        setMode(api, BossMode.UC1_15_continue_basal)

        api.sendBegin_Infusion()

        api.sendDisplay_Message(PCA_Types.Message.No_Message)

      case BossMode.UC1_15_continue_basal =>

        api.sendBegin_Infusion()

        api.sendDisplay_Message(PCA_Types.Message.No_Message)

      case _ =>
        api.logError(s"Wasn't expecting Start_Button_Pressed while mode is $currentMode")
    }
  }

  def handleScan_Done(api: Boss_Thread_imp_Operational_Api): Unit = {
    api.logInfo(s"received Scan_Done")

    currentMode match {
      case BossMode.UC1_3_do_scan =>
        api.sendAuthenticate_Clinician()

        setMode(api, BossMode.UC1_4_authenticate_clinician)

      case BossMode.UC1_5_display_scan_wristband =>
        api.sendAuthenticate_Patient()

        setMode(api, BossMode.UC1_6_authenticate_patient)

      case BossMode.UC1_7_display_scan_Rx =>
        api.sendAuthenticate_Prescription()

        setMode(api, BossMode.UC1_8_authenticate_Rx)

      case _ =>
        api.logError(s"Wasn't expecting Scan_Done while in mode $currentMode")
    }
  }

  def handleAuthentication_fail(api: Boss_Thread_imp_Operational_Api): Unit = {
    api.logInfo("received Authentication_fail")

    currentMode match {
      case BossMode.UC1_4_authenticate_clinician =>
        api.sendLog_Event(Generic_Event(art.Art.time(), "Clinician authentication failure"))

        api.sendDisplay_Message(PCA_Types.Message.Clinician_Not_Authenticated)

        setMode(api, BossMode.EC14_clinician_authentication_fail)

        transitionToUC1_19_display_turn_off_pump(api, 90000)

      case BossMode.UC1_6_authenticate_patient =>
        api.sendLog_Event(Generic_Event(art.Art.time(), "Patient authentication failure"))

        api.sendDisplay_Message(PCA_Types.Message.Patient_Not_Authenticated)

        setMode(api, BossMode.EC15_patient_authentication_fail)

        transitionToUC1_19_display_turn_off_pump(api, 90000)

      case BossMode.UC1_8_authenticate_Rx =>
        api.sendDisplay_Message(PCA_Types.Message.Prescription_Not_Authenticated)

        setMode(api, BossMode.EC16_Rx_authentication_fail)

        transitionToUC1_19_display_turn_off_pump(api, 90000)

      case _ =>
        api.logError(s"Wasn't expecting Authentication_fail while mode is $currentMode")
    }
  }

  def handleAuthentication_pass(api: Boss_Thread_imp_Operational_Api): Unit = {
    api.logInfo("received Authentication_pass")

    currentMode match {
      case BossMode.UC1_4_authenticate_clinician =>
        api.logInfo("Clinician authenticated")

        api.sendDisplay_Message(PCA_Types.Message.Scan_Wristband)
        api.sendDo_Scan()

        setMode(api, BossMode.UC1_5_display_scan_wristband)

      case BossMode.UC1_6_authenticate_patient =>
        api.logInfo("Patient authenticated")

        api.sendDisplay_Message(PCA_Types.Message.Scan_Rx)
        api.sendDo_Scan()

        setMode(api, BossMode.UC1_7_display_scan_Rx)

      case BossMode.UC1_8_authenticate_Rx =>
        api.logInfo("Prescription authenticated")

        api.sendCheck_Rx()
        api.logInfo("sent Check_Rx")

        setMode(api, BossMode.UC1_9_drug_check)

      case _ =>
        api.logError(s"Wasn't expecting Authentication_pass while mode is $currentMode")
    }
  }

  def handleDrug_Not_In_Library(api: Boss_Thread_imp_Operational_Api): Unit = {
    // this event is sent by the drug library thread and is received by both
    // the boss thread and the prescription checker thread

    api.logInfo("received Drug_Not_In_Library")

    currentMode match {
      case BossMode.UC1_9_drug_check =>

        api.sendDisplay_Message(PCA_Types.Message.Drug_Not_In_Library)

        setMode(api, BossMode.UC1_9_drug_not_in_library)

        transitionToUC1_19_display_turn_off_pump(api, 90000)

      case _ =>
        api.logError(s"Wasn't expecting Drug_Not_In_Library while mode is $currentMode")
    }
  }

  def handleHard_Limit_Violated(api: Boss_Thread_imp_Operational_Api): Unit = {
    api.logInfo("received Hard_Limit_Violated")

    currentMode match {
      case BossMode.UC1_9_drug_check =>

        api.sendDisplay_Message(PCA_Types.Message.Hard_Limit_Violated)

        setMode(api, BossMode.EC3_hard_limit_fail)
        transitionToUC1_19_display_turn_off_pump(api, 90000)

      case _ =>
        api.logError(s"Wasn't expecting Hard_Limit_Violated while mode is $currentMode")

    }
  }

  def handleReject_Soft_Limit_Exception(api: Boss_Thread_imp_Operational_Api): Unit = {
    api.logInfo("received Reject_Soft_Limit_Exception")

    currentMode match {
      case BossMode.UC1_9_drug_check =>

        api.sendDisplay_Message(PCA_Types.Message.Soft_Limit_Rejected)

        setMode(api, BossMode.EC2_soft_limit_rejected)
        transitionToUC1_19_display_turn_off_pump(api, 90000)

      case _ =>
        api.logError(s"Wasn't expecting Soft_Limit_Violated while mode is $currentMode")

    }
  }

  def handleConfirm_Soft_Limit_Exception(api: Boss_Thread_imp_Operational_Api): Unit = {
    api.logInfo("received Confirm_Soft_Limit_Exception")

    currentMode match {
      case BossMode.UC1_9_drug_check =>
        api.sendDisplay_Message(PCA_Types.Message.Insert_Vial_and_Close_Door)

        setMode(api, BossMode.UC1_10_display_insert_vial)
      case _ =>
        api.logError(s"Wasn't expecting Soft_Limit_Violated while mode is $currentMode")
    }
  }

  def handleRx_Okay(api: Boss_Thread_imp_Operational_Api): Unit = {
    api.logInfo("received Rx_Okay")

    currentMode match {
      case BossMode.UC1_9_drug_check =>
        api.sendDisplay_Message(PCA_Types.Message.Insert_Vial_and_Close_Door)

        setMode(api, BossMode.UC1_10_display_insert_vial)

      case _ =>
        api.logError(s"Wasn't expecting Rx_Okay while mode is $currentMode")
    }
  }

  def handleDoor_Closed(api: Boss_Thread_imp_Operational_Api): Unit = {
    api.logInfo("received Door_Closed")

    currentMode match {
      case BossMode.UC1_10_display_insert_vial =>
        // FIXME: Clinician needs to attach tube after the door is closed.
        //        Should the clinician press a 'Next' button after this is done
        //        or should there just be a timeout like in the BLESS code?

        // FIXME: PCA_Types.Message in AADL model does not contain Attach_Tube
        //api.Display_Message.send(PCA_Types.Message.Attach_Tube)

        setMode(api, BossMode.UC1_11_display_attach_tube)

        api.sendDisplay_Message(PCA_Types.Message.Press_start_to_begin_priming)
        setMode(api, BossMode.UC1_12_display_prime_pump)

      case _ =>
        api.logError(s"Wasn't expecting Door_Closed while mode is $currentMode")
    }
  }

  def handleTurn_Off(api: Boss_Thread_imp_Operational_Api): Unit = {
    api.logInfo("received Turn_Off")

    currentMode match {
      case BossMode.UC1_16_stop_button_pressed =>
        api.logInfo("Powering down")
        setMode(api, BossMode.Power_Down)

      case _ =>
        api.logError(s"Wasn't expecting Turn_Off while mode is $currentMode")
    }
  }



  def setMode(api: Boss_Thread_imp_Api, v : BossMode.Type) : Unit = {
    api.logInfo(s"Mode change: $currentMode --> $v")
    currentMode = v
  }

  def UC1_19_display_turn_off_pump(api: Boss_Thread_imp_Api): Unit = {
    setMode(api, BossMode.UC1_19_display_turn_off_pump)

    api.sendDisplay_Message(PCA_Types.Message.Turn_Off)
  }

  def transitionToUC1_19_display_turn_off_pump(api: Boss_Thread_imp_Api, timeoutInMilliseconds: Z): Unit = {
    def errorCaseTimeoutHandler(): Unit = {
      api.logInfo("Timeout occurred while waiting for clinician to press the Stop button while in an error case")

      UC1_19_display_turn_off_pump(api)
    }

    art.ArtTimer.setTimeout(api.id, errorCaseTimeoutEvent, timeoutInMilliseconds, true, errorCaseTimeoutHandler _)
  }

  def activate(api: Boss_Thread_imp_Operational_Api): Unit = { }

  def deactivate(api: Boss_Thread_imp_Operational_Api): Unit = { }

  def finalise(api: Boss_Thread_imp_Operational_Api): Unit = { }

  def recover(api: Boss_Thread_imp_Operational_Api): Unit = { }
}

// NOTE: commented out modes are not used in BLESS transition system
@enum object BossMode {
  'UC1_1_press_power_switch
  'EC4_POST
  'EC4_POST_fail
  'UC1_2_make_sound
  'EC17_audio_fail
  'UC1_3_display_scan_badge
  'UC1_3_do_scan
  'UC1_4_authenticate_clinician
  'EC14_clinician_authentication_fail
  'UC1_5_display_scan_wristband
  'UC1_6_authenticate_patient
  'EC15_patient_authentication_fail
  'UC1_7_display_scan_Rx
  'UC1_8_authenticate_Rx
  'EC16_Rx_authentication_fail
  'UC1_9_drug_check
  'UC1_9_drug_not_in_library
  'EC3_hard_limit_fail
  'EC2_soft_limit_rejected
  'UC1_10_display_insert_vial
  'UC1_11_display_attach_tube
  'UC1_12_display_prime_pump
  'UC1_12_prime_start
  //'UC1_12_prime_stop
  'EC6_display_priming_fail
  'UC1_13_display_insert_needle
  //'UC1_14_display_press_start
  'UC1_15_continue_basal
  //'UC2_1_patient_button_pressed
  //'UC2_2_check_last_bolus_time
  //'EC1_1_patient_button_too_soon
  //'EC1_2_3_announce_and_log
  //'UC2_3_infuse_vtbi
  //'UC2_4_infusion_done
  //'UC3_1_clinician_chooses_duration
  //'UC3_2_clinician_requests_bolus
  //'UC3_3_square_bolus_infusion
  //'UC3_4_square_bolus_done
  'UC1_16_stop_button_pressed
  //'UC7_resume_infusion_after_stop
  //'UC1_17_dislay_remove_needle
  //'UC1_18_display_remove_vial
  'UC1_19_display_turn_off_pump
  //'Initialization_fail

  'Power_Down
}