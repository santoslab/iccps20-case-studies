// #Sireum

package pca_pump.PCA_Safety

import org.sireum._
import pca_pump._

// This file will not be overwritten so is safe to edit
object error_detector_imp_pump_safety_error_detect {

  def initialise(api: error_detector_imp_Initialization_Api): Unit = {
    // example api usage

    api.logInfo("Example info logging")
    api.logDebug("Example debug logging")
    api.logError("Example error logging")

    api.sendStop_Pump_Completely()
    api.sendPOST_Failure()
    api.sendPOST_Done()
    api.sendRAM_Failure()
    api.sendROM_failure()
    api.sendCPU_Failure()
    api.sendThread_Monitor_Failure()
    api.sendHW_Detected_Failure()
  }

  def handleSoftware_Stop_Pump(api: error_detector_imp_Operational_Api): Unit = {
    api.logInfo("example handleSoftware_Stop_Pump implementation")
    api.logInfo("received Software_Stop_Pump")
  }

  def activate(api: error_detector_imp_Operational_Api): Unit = { }

  def deactivate(api: error_detector_imp_Operational_Api): Unit = { }

  def finalise(api: error_detector_imp_Operational_Api): Unit = { }

  def recover(api: error_detector_imp_Operational_Api): Unit = { }
}
