// #Sireum

package pca_pump.PCA_Types

import org.sireum._
import pca_pump._

// This file was auto-generated.  Do not edit

@enum object Warning_Type {
  'Voltage_OOR
  'Over_Max_Drug_Per_Hour
  'Basal_Underinfusion
  'Bolus_Underinfusion
  'Square_Bolus_Underinfusion
  'Low_Reservoir
  'Long_Pause
  'Drug_Not_In_Library
  'Soft_Limit
  'Hard_Limit_Violated
  'Priming_Failure
  'Input_Needed
  'No_Warning
  'Low_Battery
}

object Warning_Type_Payload {
  def empty(): Warning_Type_Payload = {
    return Warning_Type_Payload(PCA_Types.Warning_Type.byOrdinal(0).get)
  }
}

@datatype class Warning_Type_Payload(value: PCA_Types.Warning_Type.Type) extends art.DataContent
