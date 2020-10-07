// #Sireum

package pca_pump.PCA_Alarm

import org.sireum._
import art.Art
import pca_pump.PCA_Types.Status_Type
import pca_pump._
import pca_pump.util.{ArtSystem, PCA_Properties}

/* req: EC7 - Over-Flow Rate Alarm                       {@link https://www.smarturl.it/IPCA#page=38}
 * req: EC8 - Under-Flow Rate Warning                    {@link https://www.smarturl.it/IPCA#page=39}
 * req: R5.4.0(2) - basal over-infusion alarm            {@link https://www.smarturl.it/IPCA#page=51}
 * req: R5.4.0(3) - basal under-infusion warning         {@link https://www.smarturl.it/IPCA#page=52}
 * req: R5.4.0(4) - bolus over-infusion alarm            {@link https://www.smarturl.it/IPCA#page=52}
 * req: R5.4.0(5) - bolus under-infusion warning         {@link https://www.smarturl.it/IPCA#page=52}
 * req: R5.4.0(6) - square bolus over-infusion alarm     {@link https://www.smarturl.it/IPCA#page=52}
 * req: R5.4.0(7) - square bolus under-infusion warning  {@link https://www.smarturl.it/IPCA#page=52}
 */

// This file will not be overwritten so is safe to edit
object Flow_Rate_Checker_imp_pump_safety_alarm_process_flow_rate {

  var infusionFlowRate: Option[PCA_Types.Flow_Rate_imp] = None[PCA_Types.Flow_Rate_imp]()

  var currentPumpingMode: Status_Type.Type = Status_Type.Stopped

  var infusionStatus : InfusionStatus.Type = InfusionStatus.Normal

  var startOfTrendingStatus : Art.Time = z"0"

  var exceptionCaseHandled : B = F

  def timeTriggered(api: Flow_Rate_Checker_imp_Operational_Api): Unit = {
    if(pumpingModeChanged(api)) {
      // reset everything
      // FIXME: if pump was trending over/under infusing then should that be
      // factored into the new time frame.  e.g. pump was over infusing during
      // square bolus and continues to over infuse when it switches to basal
      //currentPumpingModeStartTime = 0
      startOfTrendingStatus = z"0"
      infusionStatus = InfusionStatus.Normal
      exceptionCaseHandled = F
    }

    val prevStatus : InfusionStatus.Type = infusionStatus


    (api.getInfusion_Flow_Rate(), api.getDownstream_Flow_Rate()) match {
      case (Some(prescribed), Some(measured)) =>
        val p = s16ToF(prescribed.value)
        val m = s16ToF(measured.value)

        // FIXME: what should the tolerances be for bolus and square?
        if(m - p > 0.5f) {
          infusionStatus = InfusionStatus.Over
        } else if (m - p < -0.5f) {
          infusionStatus = InfusionStatus.Under
        } else {
          infusionStatus = InfusionStatus.Normal
        }

        if(infusionStatus != prevStatus) {
          // FIXME: what if trending was over infusion and current infusionStatus is under infusion
          api.logInfo(s"Detected status change from ${prevStatus} to ${infusionStatus}")
          //api.logInfo(s"Prescribed = ${p}  vs  Measured = ${m}  ${m - p}")
          startOfTrendingStatus = Art.time()
        }

      case (x, y) =>
        // should there be a delay to allow the pump to increase/decrease
        // the flow rate after a mode change?
        if(currentPumpingMode != PCA_Types.Status_Type.Stopped) {
          api.logError(s"Error:  Prescribed and/or measured flow rate is None.  Presribed: ${x}, Measured: ${y}")
        }
    }

    val elapsedTime: Art.Time = Art.time() - startOfTrendingStatus

    if(infusionStatus != InfusionStatus.Normal && !exceptionCaseHandled) {
      currentPumpingMode match {
        case Status_Type.Basal =>
          if(infusionStatus == InfusionStatus.Over) {
            if(elapsedTime > PCA_Properties.Basal_Over_Infusion_Duration){
              api.logInfo(s"sending Basal_Overinfusion elapsedTime:${elapsedTime} ${PCA_Properties.Basal_Over_Infusion_Duration}")
              api.sendBasal_Overinfusion()
              exceptionCaseHandled = T
            }
          } else {
            if(elapsedTime > PCA_Properties.Basal_Under_Infusion_Duration){
              api.logInfo(s"sending Basal_Underinfusion elapsedTime:${elapsedTime} ${PCA_Properties.Basal_Over_Infusion_Duration}")
              api.sendBasal_Underinfusion()
              exceptionCaseHandled = T
            }
          }
        case Status_Type.Bolus =>
          if(infusionStatus == InfusionStatus.Over) {
            if(elapsedTime > PCA_Properties.Patient_Bolus_Over_Infusion_Duration){
              api.sendBolus_Overinfusion()
              exceptionCaseHandled = T
            }
          } else {
            if(elapsedTime > PCA_Properties.Patient_Bolus_Under_Infusion_Duration){
              api.sendBolus_Underinfusion()
              exceptionCaseHandled = T
            }
          }
        case Status_Type.Square_Bolus =>
          if(infusionStatus == InfusionStatus.Over) {
            if(elapsedTime > PCA_Properties.Clinician_Bolus_Over_Infusion_Duration){
              api.sendSquare_Bolus_Overinfusion()
              exceptionCaseHandled = T
            }
          } else {
            if(elapsedTime > PCA_Properties.Clinician_Bolus_Under_Infusion_Duration){
              api.sendSquare_Bolus_Underinfusion()
              exceptionCaseHandled = T
            }
          }
        case Status_Type.Stopped =>
        // FIXME: prescribed and measured flow rates should be 0
        case Status_Type.Priming =>
        // FIXME: is there any tolerance wrt priming?
        case Status_Type.Paused =>
        // FIXME
        case Status_Type.KVO =>
        // FIXME: what if measured flow rate is not equal to KVO rate?
      }
    }
  }

  def pumpingModeChanged(api: Flow_Rate_Checker_imp_Operational_Api): B = {
    if(api.getSystem_Status().nonEmpty && api.getSystem_Status().get != currentPumpingMode) {
      api.logInfo(s"System status changed from ${currentPumpingMode} to ${api.getSystem_Status().get}")
      currentPumpingMode = api.getSystem_Status().get
      return T
    }
    return F
  }

  def s16ToF(s : S16) : F32 = {
    return ArtSystem.zToF(conversions.S16.toZ(s))
  }

  def initialise(api: Flow_Rate_Checker_imp_Initialization_Api): Unit = { }

  def activate(api: Flow_Rate_Checker_imp_Operational_Api): Unit = { }

  def deactivate(api: Flow_Rate_Checker_imp_Operational_Api): Unit = { }

  def finalise(api: Flow_Rate_Checker_imp_Operational_Api): Unit = { }

  def recover(api: Flow_Rate_Checker_imp_Operational_Api): Unit = { }
}

@enum object InfusionStatus {
  'Normal
  'Over
  'Under
}