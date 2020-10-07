// #Sireum

package pca_pump.PCA_Types

import org.sireum._
import pca_pump._

// This file was auto-generated.  Do not edit

object Fault_Record_imp {
  def empty(): PCA_Types.Fault_Record_imp = {
    return PCA_Types.Fault_Record_imp(PCA_Types.Alarm_Type.byOrdinal(0).get, PCA_Types.Warning_Type.byOrdinal(0).get, Base_Types.Integer_empty())
  }
}

@datatype class Fault_Record_imp(
  alarm : PCA_Types.Alarm_Type.Type,
  warning : PCA_Types.Warning_Type.Type,
  occurrence_time : Base_Types.Integer) {
}

object Fault_Record_imp_Payload {
  def empty(): Fault_Record_imp_Payload = {
    return Fault_Record_imp_Payload(PCA_Types.Fault_Record_imp.empty())
  }
}

@datatype class Fault_Record_imp_Payload(value: PCA_Types.Fault_Record_imp) extends art.DataContent
