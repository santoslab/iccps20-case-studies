// #Sireum

package pca_pump.PCA_Control_Panel

import org.sireum._
import pca_pump._

@ext object CP_Shared_Object {

  // send to GUI
  def setAlarm(s: String): Unit = $
  def setMessage(s: String): Unit = $
  def setSystemStatus(s: String): Unit = $
  def setDrugName(s: String): Unit = $
  def setConcentration(s: String) : Unit = $
  def setInfusedAmount(s: String) : Unit = $
  def setFlowRate(s: String): Unit = $
  def setSound(s: PCA_Types.Sound.Type): Unit = $

  // get from GUI
  def pullGUI(): Option[GuiData] = $
}

@datatype class GuiData(val buttonId: PCA_Types.Button_Id.Type,
                        val squareBolusDuration: Option[U16])