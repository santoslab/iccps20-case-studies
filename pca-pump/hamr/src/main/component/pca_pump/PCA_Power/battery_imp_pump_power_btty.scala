// #Sireum

package pca_pump.PCA_Power

import org.sireum._
import pca_pump._

// This file will not be overwritten so is safe to edit
object battery_imp_pump_power_btty {

  def initialise(api: battery_imp_Initialization_Api): Unit = {
    // example api usage

    api.logInfo("Example info logging")
    api.logDebug("Example debug logging")
    api.logError("Example error logging")

    api.setBattery_Voltage(Physical_Types.Voltage_imp.empty())
    api.setBattery_Current(Physical_Types.Current_imp.empty())
  }

  def timeTriggered(api: battery_imp_Operational_Api): Unit = {
    // example api usage

    api.setBattery_Voltage(Physical_Types.Voltage_imp.empty())
    api.setBattery_Current(Physical_Types.Current_imp.empty())
  }

  def activate(api: battery_imp_Operational_Api): Unit = { }

  def deactivate(api: battery_imp_Operational_Api): Unit = { }

  def finalise(api: battery_imp_Operational_Api): Unit = { }

  def recover(api: battery_imp_Operational_Api): Unit = { }
}
