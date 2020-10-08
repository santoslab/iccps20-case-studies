// #Sireum

package pca_pump.PCA_Power

import org.sireum._
import pca_pump._

// This file will not be overwritten so is safe to edit
object power_supply_imp_pump_power_vcc {

  def initialise(api: power_supply_imp_Initialization_Api): Unit = {}

  def timeTriggered(api: power_supply_imp_Operational_Api): Unit = {}

  def activate(api: power_supply_imp_Operational_Api): Unit = { }

  def deactivate(api: power_supply_imp_Operational_Api): Unit = { }

  def finalise(api: power_supply_imp_Operational_Api): Unit = { }

  def recover(api: power_supply_imp_Operational_Api): Unit = { }
}
