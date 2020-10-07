// #Sireum

package pca_pump.PCA_Types

import org.sireum._
import pca_pump._

@enum object Button_Id {
  'CP_Reset_Alarm
  'Confirm_Soft_Limit_Exception
  'Reject_Soft_Limit_Exception
  'Stop_Button_Pressed
  'Start_Button_Pressed
  'Clinician_Request_Bolus
  'Pause_Infusion
  'Resume_Infusion
  'Turn_Off

  'Up
  'Down
}

@datatype class Button_Id_Payload(value: Button_Id.Type) extends art.DataContent