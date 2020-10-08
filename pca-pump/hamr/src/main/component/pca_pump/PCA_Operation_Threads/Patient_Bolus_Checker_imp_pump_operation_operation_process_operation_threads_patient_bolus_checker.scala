// #Sireum

package pca_pump.PCA_Operation_Threads

import org.sireum._
import art.Art
import pca_pump._

/* req: UC2 Patient-Requested Bolus {@link https://www.smarturl.it/opca#subsubsec_uc2}
 * req: EC1 Bolus Request Too Soon {@link https://www.smarturl.it/opca#ec_bolusrequesttoosoon}
 * req: PCA Pump Function: Patient-Requested Bolus {@link https://www.smarturl.it/opca#subsec_prbolus}
 * req: PCA Pump Interfaces: Drug Reservoir {@link https://www.smarturl.it/opca#subsec_drugreservoir}
 * req: Functional Architecture: Patient Bolus Checker {@link https://www.smarturl.it/opca#subsec_patientboluschecker}
 */

// This file will not be overwritten so is safe to edit
object Patient_Bolus_Checker_imp_pump_operation_operation_process_operation_threads_patient_bolus_checker {

  var lastPatientBolus: Art.Time = z"0"

  def initialise(api: Patient_Bolus_Checker_imp_Initialization_Api): Unit = { }

  def handlePatient_Button_Request(api: Patient_Bolus_Checker_imp_Operational_Api): Unit = {
    api.logInfo("received Patient_Button_Request")

    api.getMinimum_Time_Between_Bolus() match {
      case Some(ICE_Types.Minute_imp(value)) =>
        val minTimeBetweenBolusInMs: Z = conversions.U16.toZ(value) * z"1000" * z"60"

        val nowInMs : Art.Time = Art.time()

        val elapsedInMs: Art.Time = nowInMs - lastPatientBolus
        val isFirstButtonPress: B = lastPatientBolus == z"0"

        if(isFirstButtonPress || elapsedInMs > minTimeBetweenBolusInMs){
          api.logInfo("Patient button press not too soon")

          api.sendPatient_Request_Not_Too_Soon()

          lastPatientBolus = nowInMs
        } else {
          api.logInfo("Patient button press too soon")

          api.sendPatient_Request_Too_Soon()
        }
      case _ =>
        api.logError("Minimum_Time_Between_Bolus has not been received")
    }
  }

  def activate(api: Patient_Bolus_Checker_imp_Operational_Api): Unit = { }

  def deactivate(api: Patient_Bolus_Checker_imp_Operational_Api): Unit = { }

  def finalise(api: Patient_Bolus_Checker_imp_Operational_Api): Unit = { }

  def recover(api: Patient_Bolus_Checker_imp_Operational_Api): Unit = { }
}
