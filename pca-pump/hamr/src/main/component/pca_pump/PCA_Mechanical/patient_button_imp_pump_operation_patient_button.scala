// #Sireum

package pca_pump.PCA_Mechanical

import org.sireum._
import pca_pump._

// This file will not be overwritten so is safe to edit
object patient_button_imp_pump_operation_patient_button {

  def initialise(api: patient_button_imp_Initialization_Api): Unit = {}

  def handleButton_Press(api: patient_button_imp_Operational_Api): Unit = {
    api.logInfo("received Button_Press")

    api.sendRequest_Bolus()
  }

  def activate(api: patient_button_imp_Operational_Api): Unit = { }

  def deactivate(api: patient_button_imp_Operational_Api): Unit = { }

  def finalise(api: patient_button_imp_Operational_Api): Unit = { }

  def recover(api: patient_button_imp_Operational_Api): Unit = { }
}
