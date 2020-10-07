// #Sireum

package pca_pump.PCA_Types

import org.sireum._
import pca_pump._

// This file was auto-generated.  Do not edit

@enum object Alarm_Type {
  'Basal_Overinfusion
  'Bolus_Overinfusion
  'Square_Bolus_Overinfusion
  'Air_In_Line
  'Empty_Reservoir
  'Pump_Overheated
  'Downstream_Occlusion
  'Upstream_Occlusion
  'POST_Failure
  'RAM_Failure
  'ROM_Failure
  'CPU_Failure
  'Thread_Monitor_Failure
  'Defective_Battery
  'Low_Battery
  'No_Alarm
  'Priming_Failure
}

object Alarm_Type_Payload {
  def empty(): Alarm_Type_Payload = {
    return Alarm_Type_Payload(PCA_Types.Alarm_Type.byOrdinal(0).get)
  }
}

@datatype class Alarm_Type_Payload(value: PCA_Types.Alarm_Type.Type) extends art.DataContent
