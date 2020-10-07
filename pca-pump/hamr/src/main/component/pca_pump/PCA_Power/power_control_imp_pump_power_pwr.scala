// #Sireum

package pca_pump.PCA_Power

import org.sireum._
import pca_pump._

// This file will not be overwritten so is safe to edit
object power_control_imp_pump_power_pwr {

  def initialise(api: power_control_imp_Initialization_Api): Unit = {
    // example api usage

    api.logInfo("Example info logging")
    api.logDebug("Example debug logging")
    api.logError("Example error logging")

    api.setUsing_Battery_Power(Base_Types.Boolean_empty())
    api.setRemaining_Battery_Time(BLESS_Types.Time.empty())
    api.sendLow_Battery_Warning()
    api.sendDefective_Battery()
    api.sendVoltage_OOR()
  }

  def timeTriggered(api: power_control_imp_Operational_Api): Unit = {
    // example api usage

    val apiUsage_Battery_Voltage: Option[Physical_Types.Voltage_imp] = api.getBattery_Voltage()
    val apiUsage_Battery_Current: Option[Physical_Types.Current_imp] = api.getBattery_Current()
    val apiUsage_Power_Voltage: Option[Physical_Types.Voltage_imp] = api.getPower_Voltage()
    api.setUsing_Battery_Power(Base_Types.Boolean_empty())
    api.setRemaining_Battery_Time(BLESS_Types.Time.empty())
    api.sendLow_Battery_Warning()
    api.sendDefective_Battery()
    api.sendVoltage_OOR()
  }

  def activate(api: power_control_imp_Operational_Api): Unit = { }

  def deactivate(api: power_control_imp_Operational_Api): Unit = { }

  def finalise(api: power_control_imp_Operational_Api): Unit = { }

  def recover(api: power_control_imp_Operational_Api): Unit = { }
}
