// #Sireum

package pca_pump.PCA_Types

import org.sireum._
import pca_pump._

// This file was auto-generated.  Do not edit

@enum object Message {
  'No_Message
  'POST_fail
  'Turn_Off
  'If_Beep_Press_Stop_Button
  'Scan_Badge
  'Scan_Wristband
  'Scan_Rx
  'Clinician_Not_Authenticated
  'Patient_Not_Authenticated
  'Prescription_Not_Authenticated
  'Hard_Limit_Violated
  'Soft_Limit_Rejected
  'Insert_Vial_and_Close_Door
  'Press_start_to_begin_priming
  'Press_stop_to_end_priming
  'Priming_Failure
  'Insert_Needle_Then_Press_Start
  'Press_Stop_Again_To_End_Infusion_Press_Start_To_Resume_Infusion
  'Drug_Not_In_Library
  'Sound_Failure
}

object Message_Payload {
  def empty(): Message_Payload = {
    return Message_Payload(PCA_Types.Message.byOrdinal(0).get)
  }
}

@datatype class Message_Payload(value: PCA_Types.Message.Type) extends art.DataContent
