package pca_pump.PCA_Control_Panel

import org.sireum._
import pca_pump._

object CP_Shared_Object_Ext {

  PCAInputGUI.addStartButtonPressedListener(startButtonCallBack _)

  PCAInputGUI.addStopButtonPressedListener(stopButtonCallBack _)

  PCAInputGUI.addClearButtonPressedListener(clearButtonCallBack _)

  PCAInputGUI.addClinicianRequestBolusPressedListener(squareBolusCallBack _)

  PCAInputGUI.addUpButtonPressedListener(upButtonCallBack _)

  PCAInputGUI.addDownButtonPressedListener(downButtonCallBack _)

  private var data: Option[GuiData] = None[GuiData]()


  def pullGUI(): Option[GuiData] = {
    val r = data
    if(data.nonEmpty) {
      // reset data
      data = None[GuiData]()
    }
    return r
  }

  def startButtonCallBack(): Unit = {
    setSimpleButtonPress(PCA_Types.Button_Id.Start_Button_Pressed)
  }

  def stopButtonCallBack(): Unit = {
    setSimpleButtonPress(PCA_Types.Button_Id.Stop_Button_Pressed)
  }

  def clearButtonCallBack(): Unit = {
    setSimpleButtonPress(PCA_Types.Button_Id.CP_Reset_Alarm)
  }

  def squareBolusCallBack(): Unit = {
    setSimpleButtonPress(PCA_Types.Button_Id.Clinician_Request_Bolus)
  }

  def upButtonCallBack(): Unit = {
    setSimpleButtonPress(PCA_Types.Button_Id.Up)
  }

  def downButtonCallBack(): Unit = {
    setSimpleButtonPress(PCA_Types.Button_Id.Down)
  }

  def setSimpleButtonPress(id: PCA_Types.Button_Id.Type): Unit = {
    data = Some(GuiData(id, None[U16]()))
  }


  // To GUI

  def setAlarm(s: String): Unit = PCAInputGUI.setAlarm(s)

  def setMessage(s: String): Unit = PCAInputGUI.setMessage(s)

  def setSystemStatus(s: String): Unit = PCAInputGUI.setSystemStatus(s)

  def setDrugName(s: String): Unit = PCAInputGUI.setDrugName(s)

  def setConcentration(s: String) : Unit = PCAInputGUI.setConcentration(s)

  def setInfusedAmount(s: String) : Unit = PCAInputGUI.setInfusedAmount(s)

  def setFlowRate(s: String): Unit = PCAInputGUI.setFlowRate(s)

  def setSound(s: PCA_Types.Sound.Type): Unit = PCAInputGUI.setSound(s)
}