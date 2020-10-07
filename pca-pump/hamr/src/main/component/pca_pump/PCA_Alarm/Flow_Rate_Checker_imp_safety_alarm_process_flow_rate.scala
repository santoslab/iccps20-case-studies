// #Sireum

package pca_pump.PCA_Alarm

import org.sireum._
import pca_pump._

// This file will not be overwritten so is safe to edit
object Flow_Rate_Checker_imp_safety_alarm_process_flow_rate {

  def initialise(api: Flow_Rate_Checker_imp_Initialization_Api): Unit = {
    // example api usage

    api.logInfo("Example info logging")
    api.logDebug("Example debug logging")
    api.logError("Example error logging")

    api.sendBasal_Overinfusion()
    api.sendBolus_Overinfusion()
    api.sendSquare_Bolus_Overinfusion()
    api.sendBasal_Underinfusion()
    api.sendBolus_Underinfusion()
    api.sendSquare_Bolus_Underinfusion()
  }

  def timeTriggered(api: Flow_Rate_Checker_imp_Operational_Api): Unit = {
    // example api usage

    val apiUsage_System_Status: Option[PCA_Types.Status_Type.Type] = api.getSystem_Status()
    val apiUsage_Infusion_Flow_Rate: Option[PCA_Types.Flow_Rate] = api.getInfusion_Flow_Rate()
    val apiUsage_Upstream_Flow_Rate: Option[PCA_Types.Flow_Rate] = api.getUpstream_Flow_Rate()
    val apiUsage_Downstream_Flow_Rate: Option[PCA_Types.Flow_Rate] = api.getDownstream_Flow_Rate()
    api.sendBasal_Overinfusion()
    api.sendBolus_Overinfusion()
    api.sendSquare_Bolus_Overinfusion()
    api.sendBasal_Underinfusion()
    api.sendBolus_Underinfusion()
    api.sendSquare_Bolus_Underinfusion()
  }

  def activate(api: Flow_Rate_Checker_imp_Operational_Api): Unit = { }

  def deactivate(api: Flow_Rate_Checker_imp_Operational_Api): Unit = { }

  def finalise(api: Flow_Rate_Checker_imp_Operational_Api): Unit = { }

  def recover(api: Flow_Rate_Checker_imp_Operational_Api): Unit = { }
}
