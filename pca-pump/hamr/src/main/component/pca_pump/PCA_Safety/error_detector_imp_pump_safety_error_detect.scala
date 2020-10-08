// #Sireum

package pca_pump.PCA_Safety

import org.sireum._
import pca_pump._

// This file will not be overwritten so is safe to edit
object error_detector_imp_pump_safety_error_detect {

  def initialise(api: error_detector_imp_Initialization_Api): Unit = {}

  def handleSoftware_Stop_Pump(api: error_detector_imp_Operational_Api): Unit = {}

  def activate(api: error_detector_imp_Operational_Api): Unit = { }

  def deactivate(api: error_detector_imp_Operational_Api): Unit = { }

  def finalise(api: error_detector_imp_Operational_Api): Unit = { }

  def recover(api: error_detector_imp_Operational_Api): Unit = { }
}
