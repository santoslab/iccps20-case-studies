// #Sireum

package pca_pump.PCA_Control_Panel

import org.sireum._
import pca_pump._

// This file will not be overwritten so is safe to edit
object pca_screen_imp_pump_operation_control_panel_display {

  var lastImage: Option[PCA_Types.Image] = None[PCA_Types.Image]()
  var firstInvocation : B = T

  def initialise(api: pca_screen_imp_Initialization_Api): Unit = {}

  def timeTriggered(api: pca_screen_imp_Operational_Api): Unit = {
    if(firstInvocation) {
      // NOTE: need to finish the initialization phase for components
      // before initializing objects like the GUI
      PCAInputGUI.init()
      firstInvocation = F
    }


    // check if new input from GUI
    CP_Shared_Object.pullGUI() match {
      case Some(d) =>
        d.buttonId match {
          case PCA_Types.Button_Id.Start_Button_Pressed =>
            api.sendTouch(PCA_Types.SimpleButton_Touch(d.buttonId))

          case PCA_Types.Button_Id.Stop_Button_Pressed =>
            api.sendTouch(PCA_Types.SimpleButton_Touch(d.buttonId))

          case PCA_Types.Button_Id.CP_Reset_Alarm =>
            api.sendTouch(PCA_Types.SimpleButton_Touch(d.buttonId))

          case PCA_Types.Button_Id.Clinician_Request_Bolus =>
            api.sendTouch(PCA_Types.SimpleButton_Touch(d.buttonId))

          case PCA_Types.Button_Id.Up =>
            api.sendTouch(PCA_Types.SimpleButton_Touch(d.buttonId))

          case PCA_Types.Button_Id.Down =>
            api.sendTouch(PCA_Types.SimpleButton_Touch(d.buttonId))

          case _ =>
            api.logInfo(s"Button ${d} not handled")
        }
      case _ =>
    }


    val image: Option[PCA_Types.Image] = api.getImage()

    // check if control panel sent a new 'image'
    if(image != lastImage) {
      handleImage(image.get)
      lastImage = image
    }
  }

  def handleImage(image: PCA_Types.Image) : Unit = {
    for (i <- image.l) {
      i match {
        case p: PCA_Types.Alarm_Image => CP_Shared_Object.setAlarm(p.s)
        case p: PCA_Types.Message_Image => CP_Shared_Object.setMessage(p.s)
        case p: PCA_Types.SystemStatus_Image => CP_Shared_Object.setSystemStatus(p.s)
        case p: PCA_Types.DrugName_Image => CP_Shared_Object.setDrugName(p.s)
        case p: PCA_Types.DrugConcentration_Image => CP_Shared_Object.setConcentration(p.s)
        case p: PCA_Types.InfusionFlowRate_Image => CP_Shared_Object.setFlowRate(p.s)
      }
    }
  }

  def activate(api: pca_screen_imp_Operational_Api): Unit = { }

  def deactivate(api: pca_screen_imp_Operational_Api): Unit = { }

  def finalise(api: pca_screen_imp_Operational_Api): Unit = {
    PCAInputGUI.finalise()
  }

  def recover(api: pca_screen_imp_Operational_Api): Unit = { }
}
