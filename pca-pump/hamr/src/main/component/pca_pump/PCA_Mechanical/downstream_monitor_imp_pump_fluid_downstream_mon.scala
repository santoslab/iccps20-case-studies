// #Sireum

package pca_pump.PCA_Mechanical

import org.sireum._
import pca_pump._

// This file will not be overwritten so is safe to edit
object downstream_monitor_imp_pump_fluid_downstream_mon {

  def initialise(api: downstream_monitor_imp_Initialization_Api): Unit = {}

  def timeTriggered(api: downstream_monitor_imp_Operational_Api): Unit = {}

  def activate(api: downstream_monitor_imp_Operational_Api): Unit = { }

  def deactivate(api: downstream_monitor_imp_Operational_Api): Unit = { }

  def finalise(api: downstream_monitor_imp_Operational_Api): Unit = { }

  def recover(api: downstream_monitor_imp_Operational_Api): Unit = { }
}
