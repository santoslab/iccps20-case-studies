// #Sireum

package pca_pump.PCA_Types

import org.sireum._
import pca_pump._

object Stop_Patient_Bolus_Event {
  def empty(): PCA_Types.Stop_Patient_Bolus_Event = {
    return PCA_Types.Stop_Patient_Bolus_Event()
  }
}

@datatype class Stop_Patient_Bolus_Event() // type skeleton

object Stop_Patient_Bolus_Event_Payload {
  def empty(): Stop_Patient_Bolus_Event_Payload = {
    return Stop_Patient_Bolus_Event_Payload(PCA_Types.Stop_Patient_Bolus_Event.empty())
  }
}

@datatype class Stop_Patient_Bolus_Event_Payload(value: PCA_Types.Stop_Patient_Bolus_Event) extends art.DataContent
