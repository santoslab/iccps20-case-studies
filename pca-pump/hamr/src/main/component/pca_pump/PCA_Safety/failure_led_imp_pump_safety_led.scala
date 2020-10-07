// #Sireum

package pca_pump.PCA_Safety

import org.sireum._
import pca_pump._

// This file will not be overwritten so is safe to edit
object failure_led_imp_pump_safety_led {

  def initialise(api: failure_led_imp_Initialization_Api): Unit = {
    // example api usage

    api.logInfo("Example info logging")
    api.logDebug("Example debug logging")
    api.logError("Example error logging")

    api.setLight(Base_Types.Boolean_empty())
  }

  def handleIlluminate(api: failure_led_imp_Operational_Api): Unit = {
    api.logInfo("example handleIlluminate implementation")
    api.logInfo("received Illuminate")
  }

  def activate(api: failure_led_imp_Operational_Api): Unit = { }

  def deactivate(api: failure_led_imp_Operational_Api): Unit = { }

  def finalise(api: failure_led_imp_Operational_Api): Unit = { }

  def recover(api: failure_led_imp_Operational_Api): Unit = { }
}
