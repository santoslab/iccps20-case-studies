// #Sireum

package pca_pump.PCA_Operation_Threads

import org.sireum._
import pca_pump._

// This file will not be overwritten so is safe to edit
object Prescription_Checker_imp_pump_operation_operation_process_operation_threads_prescription_checker {

  var softLimitWarningIssued: B = false

  var myRx : Option[PCA_Types.Prescription_imp] = None[PCA_Types.Prescription_imp]()
  var myDrugRecord : Option[PCA_Types.Drug_Record_imp] = None[PCA_Types.Drug_Record_imp]()


  // FIXME
  val fixMe1: Option[PCA_Types.Dose_Rate_Unit_imp] = None[PCA_Types.Dose_Rate_Unit_imp]()
  val fixMe2: Option[PCA_Types.Infusion_Unit_imp] = None[PCA_Types.Infusion_Unit_imp]()
  val fixMe3: Option[PCA_Types.Drug_Weight_imp] = None[PCA_Types.Drug_Weight_imp]()

  def initialise(api: Prescription_Checker_imp_Initialization_Api): Unit = {}

  def handleThe_Drug_Record(api: Prescription_Checker_imp_Operational_Api, value : PCA_Types.Drug_Record_imp): Unit = {
    api.logInfo(s"received The_Drug_Record $value")

    assert(myRx.nonEmpty && myDrugRecord.isEmpty && !softLimitWarningIssued)

    myDrugRecord = Some(value)

    // check the prescription
    (myRx, myDrugRecord) match {
      case (Some(rx), Some(dr)) =>

        // check rx
        if(rx.code != dr.code ||
          rx.drugName != dr.name ||
          rx.concentration != dr.concentration) {
          // FIXME: how to proceed?  the Rx_Mismatch port is commented out in the aadl model
          api.logInfo("Rx_Mismatch case not handled")
          assert(false)
          return;
        }

        // presumably Rx_Valid

        if(// check hard limits
          rx.vtbi.value < dr.vtbiLowerHard.value ||               // less volume than VTBI Lower Hard limit
            rx.vtbi.value > dr.vtbiUpperHard.value ||               // more volume than VTBI Upper Hard limit
            rx.basalFlowRate.value < dr.basalRateLowerHard.value || // smaller infusion rate than Basal Rate Lower Hard limit
            rx.basalFlowRate.value > dr.basalRateUpperHard.value    // greater infusion rate than Basal Rate Upper Hard limit
        ){
          api.logInfo("Hard limits violated")
          api.sendHard_Limit_Violated()
          return
        } else {
          // FIXME: bless code indicates Hard_Limit_Okay should be sent but the port is commented out
          api.logInfo("bless code indicates Hard_Limit_Okay should be sent but the port is commented out")
        }

        if( // check soft limits
          rx.vtbi.value <= dr.vtbiLowerSoft.value ||                // less volume than VTBI Lower Soft limit
            rx.vtbi.value >= dr.vtbiUpperSoft.value ||                // more volume than VTBI Upper Soft limit
            rx.basalFlowRate.value <= dr.basalRateLowerSoft.value ||  // smaller infusion rate than Basal Rate Lower Soft limit
            rx.basalFlowRate.value >= dr.basalRateUpperSoft.value     // greater infusion rate than Basal Rate Upper Soft limit
        ){
          api.logInfo("Soft limits violated.  Warning issued")

          softLimitWarningIssued = true
          api.sendSoft_Limit_Warning()

          return
        } else {

          api.sendRx_Okay()
          api.logInfo("sent RxOkay")

          // everything passed
          emitPrescription(api)
        }
      case _ =>
        assert(false)
    }
  }

  def handleCheck_Rx(api: Prescription_Checker_imp_Operational_Api): Unit = {
    api.logInfo(s"received CheckRx")

    myRx = Some(api.getPrescription().get)

    assert(myRx.nonEmpty && myDrugRecord.isEmpty && !softLimitWarningIssued)

    myRx match {
      case Some(rx) =>
        api.logInfo(s"sending Get_Drug_Record for ${rx.code}  ----> $rx")
        api.sendGet_Drug_Record(rx.code)
      case _ =>
        assert(false)
    }
  }

  def handleDrug_Not_In_Library(api: Prescription_Checker_imp_Operational_Api): Unit = {
    api.logInfo(s"received Drug_Not_In_Library")

    assert(myRx.nonEmpty && myDrugRecord.isEmpty && !softLimitWarningIssued)
    // FIXME??
  }

  def handleConfirm_Soft_Limit_Exception(api: Prescription_Checker_imp_Operational_Api): Unit = {
    api.logInfo(s"received Confirm_Soft_Limit_Exception")

    assert(myRx.nonEmpty && myDrugRecord.nonEmpty && softLimitWarningIssued)

    softLimitWarningIssued = false

    emitPrescription(api)

    // NOTE: not sending Rx_Okay as is done in bless.  This is because Boss_Thread already contains the transition
    //    UC1_9_drug_check -[on dispatch Confirm_Soft_Limit_Exception]-> UC1_10_display_insert_vial
    // However, Boss_Thread does not contain the transition
    //    UC1_9_drug_check -[on dispatch Rx_Okay]-> UC1_10_display_insert_vial
    // which is needed in order to handle the case where a drug passes both the hard and soft limit checks.
  }

  def handleReject_Soft_Limit_Exception(api: Prescription_Checker_imp_Operational_Api): Unit = {
    api.logInfo(s"received Reject_Soft_Limit_Exception")

    assert(myRx.nonEmpty && myDrugRecord.nonEmpty && softLimitWarningIssued)

    myRx = None[PCA_Types.Prescription_imp]()
    softLimitWarningIssued = false
  }

  def emitPrescription(api: Prescription_Checker_imp_Api): Unit = {
    (myRx, myDrugRecord) match {
      case (Some(rx), Some(dr)) =>
        api.setVTBI(rx.vtbi)
        api.setSquare_Bolus_Rate(dr.squareBolusRateTypical)
        api.setPatient_Bolus_Rate(rx.patientBolusRate) // FIXME
        api.setBasal_Rate(rx.basalFlowRate)
        api.setMinimum_Time_Between_Bolus(rx.minimumTimeBetweenBolus)
        api.setMax_Drug_Per_Hour(rx.maxDrugPerHour)

        api.logInfo("sent rx info")
      case _ =>
        assert(false)
    }
  }

  def activate(api: Prescription_Checker_imp_Operational_Api): Unit = { }

  def deactivate(api: Prescription_Checker_imp_Operational_Api): Unit = { }

  def finalise(api: Prescription_Checker_imp_Operational_Api): Unit = { }

  def recover(api: Prescription_Checker_imp_Operational_Api): Unit = { }
}
