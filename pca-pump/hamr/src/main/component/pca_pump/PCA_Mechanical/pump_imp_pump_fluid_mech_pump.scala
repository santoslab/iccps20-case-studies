// #Sireum

package pca_pump.PCA_Mechanical

import org.sireum._
import pca_pump._

// This file will not be overwritten so is safe to edit
object pump_imp_pump_fluid_mech_pump {

  def initialise(api: pump_imp_Initialization_Api): Unit = {}

  def handleHalt(api: pump_imp_Operational_Api): Unit = {}

  def activate(api: pump_imp_Operational_Api): Unit = { }

  def deactivate(api: pump_imp_Operational_Api): Unit = { }

  def finalise(api: pump_imp_Operational_Api): Unit = { }

  def recover(api: pump_imp_Operational_Api): Unit = { }
}
