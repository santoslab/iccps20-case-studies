// #Sireum

package pca_pump.PCA_Mechanical

import org.sireum._
import pca_pump._

// This file will not be overwritten so is safe to edit
object upstream_monitor_imp_pump_fluid_upstream_mon {

  def initialise(api: upstream_monitor_imp_Initialization_Api): Unit = {}

  def timeTriggered(api: upstream_monitor_imp_Operational_Api): Unit = {}

  def activate(api: upstream_monitor_imp_Operational_Api): Unit = { }

  def deactivate(api: upstream_monitor_imp_Operational_Api): Unit = { }

  def finalise(api: upstream_monitor_imp_Operational_Api): Unit = { }

  def recover(api: upstream_monitor_imp_Operational_Api): Unit = { }
}
