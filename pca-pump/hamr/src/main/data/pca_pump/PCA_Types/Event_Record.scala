// #Sireum

package pca_pump.PCA_Types

import org.sireum._
import pca_pump._


object Event_Record {
  def empty(): Event_Record = {
    return Generic_Event(0, "")
  }
}

// Each log entry shall have a time stamp with its time of occurrence.
@sig trait Event_Record {
  def occurrence_time: Z
}

// {@link https://www.smarturl.it/OPCA#subsec_logging}
// (1) The PCA pump shall maintain an electronic event log to record each action taken by the pump
//     and each event sensed of its environment. (no UC or EC specific to logging)

@datatype class Generic_Event(val occurrence_time: Z, msg: String) extends Event_Record

/*
// {@link https://www.smarturl.it/OPCA#ec_druglibrarysoftlimit}
@datatype class Soft_Limit_Violation(val occurence_time: BLESS_Types.Time) extends Event_Record
@datatype class Soft_Limit_Violation_Approved(val occurence_time: BLESS_Types.Time) extends Event_Record
@datatype class Soft_Limit_Violation_Rejected(val occurence_time: BLESS_Types.Time) extends Event_Record
// {@link https://www.smarturl.it/OPCA#ec_maxdose}
@datatype class Max_Safe_Dose_Violation(val occurence_time: BLESS_Types.Time) extends Event_Record
// {@link https://www.smarturl.it/OPCA#ec_clinicianauthenticationfailure}
@datatype class Clinician_Authentication_Failure(val occurence_time: BLESS_Types.Time) extends Event_Record
// {@link https://www.smarturl.it/OPCA#ec_patientauthenticationfailure}
@datatype class Patient_Authentication_Failure(val occurence_time: BLESS_Types.Time) extends Event_Record
// {@link https://www.smarturl.it/OPCA#ec_prescriptionauthenticationfailure}
@datatype class Prescription_Authentication_Failure(val occurence_time: BLESS_Types.Time) extends Event_Record
// {@link https://www.smarturl.it/OPCA#ec_soundfailure}
@datatype class Sound_Failure(val occurence_time: BLESS_Types.Time) extends Event_Record
*/

@datatype class Event_Record_Payload(value: Event_Record) extends art.DataContent
