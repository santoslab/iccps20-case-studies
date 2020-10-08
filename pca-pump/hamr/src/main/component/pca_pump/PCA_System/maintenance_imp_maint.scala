// #Sireum

package pca_pump.PCA_System

import org.sireum._
import pca_pump._

// This file will not be overwritten so is safe to edit
object maintenance_imp_maint {

  def initialise(api: maintenance_imp_Initialization_Api): Unit = {}

  def timeTriggered(api: maintenance_imp_Operational_Api): Unit = {}

  def activate(api: maintenance_imp_Operational_Api): Unit = { }

  def deactivate(api: maintenance_imp_Operational_Api): Unit = { }

  def finalise(api: maintenance_imp_Operational_Api): Unit = { }

  def recover(api: maintenance_imp_Operational_Api): Unit = { }
}
