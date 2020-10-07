// #Sireum

package pca_pump.PCA_Types

import org.sireum._
import pca_pump._

object Start_Patient_Bolus_Event {
  def empty(): PCA_Types.Start_Patient_Bolus_Event = {
    return PCA_Types.Start_Patient_Bolus_Event()
  }
}

@datatype class Start_Patient_Bolus_Event() // type skeleton

object Start_Patient_Bolus_Event_Payload {
  def empty(): Start_Patient_Bolus_Event_Payload = {
    return Start_Patient_Bolus_Event_Payload(PCA_Types.Start_Patient_Bolus_Event.empty())
  }
}

@datatype class Start_Patient_Bolus_Event_Payload(value: PCA_Types.Start_Patient_Bolus_Event) extends art.DataContent
