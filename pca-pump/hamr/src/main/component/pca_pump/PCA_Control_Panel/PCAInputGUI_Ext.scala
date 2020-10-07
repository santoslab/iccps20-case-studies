package pca_pump.PCA_Control_Panel

import org.sireum._
import java.util.concurrent.atomic.AtomicReference
import pca_pump._

object PCAInputGUI_Ext {
  val form: PCAInputForm = new PCAInputForm()

  def init(): Unit = {
    form.init()
  }

  def finalise(): Unit = {
    form.dispose()
  }

  // MODS BELOW
  def setAlarm(s: String): Unit = form.setAlarm(s)
  def setMessage(s: String): Unit = form.setMessage(s)
  def setSystemStatus(s: String): Unit = form.setSystemStatus(s)
  def setDrugName(s: String): Unit = form.setDrugName(s)
  def setConcentration(s: String) : Unit = form.setConcentration(s)
  def setInfusedAmount(s: String) : Unit = form.setInfusedAmount(s)
  def setFlowRate(s: String): Unit = form.setFlowRate(s)
  def setSound(s: PCA_Types.Sound.Type) = form.setSound(s)

  def addStartButtonPressedListener(f: () => Unit): Unit = {
    form.registerListener(PCA_Types.Button_Id.Start_Button_Pressed, f)
  }

  def addStopButtonPressedListener(f: () => Unit): Unit = {
    form.registerListener(PCA_Types.Button_Id.Stop_Button_Pressed, f)
  }

  def addClearButtonPressedListener(f: () => Unit): Unit = {
    form.registerListener(PCA_Types.Button_Id.CP_Reset_Alarm, f)
  }

  def addClinicianRequestBolusPressedListener(f: () => Unit) = {
    form.registerListener(PCA_Types.Button_Id.Clinician_Request_Bolus, f)
  }

  def addUpButtonPressedListener(f: () => Unit): Unit = {
    form.registerListener(PCA_Types.Button_Id.Up, f)
  }

  def addDownButtonPressedListener(f: () => Unit): Unit = {
    form.registerListener(PCA_Types.Button_Id.Down, f)
  }
}