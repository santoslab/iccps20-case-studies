// #Sireum

package pca_pump.PCA_Control_Panel

import org.sireum._
import pca_pump._

@ext object PCAInputGUI {
  def init(): Unit = $
  def finalise(): Unit = $

  // MODS BELOW

  def setAlarm(s: String): Unit = $
  def setMessage(s: String): Unit = $
  def setSystemStatus(s: String): Unit = $
  def setDrugName(s: String): Unit = $
  def setConcentration(s: String) : Unit = $
  def setInfusedAmount(s: String) : Unit = $
  def setFlowRate(s: String): Unit = $
  def setSound(s: PCA_Types.Sound.Type): Unit = $

  def addStartButtonPressedListener(f: () => Unit): Unit = $
  def addStopButtonPressedListener(f: () => Unit): Unit = $
  def addClearButtonPressedListener(f: () => Unit): Unit = $
  def addClinicianRequestBolusPressedListener(f: () => Unit): Unit = $
  def addUpButtonPressedListener(f: () => Unit): Unit = $
  def addDownButtonPressedListener(f: () => Unit): Unit = $
}