// #Sireum

package pca_pump.PCA_Types

import org.sireum._
import pca_pump._

// This file was auto-generated.  Do not edit

object Dose_Rate_Unit_imp {
  def empty(): PCA_Types.Dose_Rate_Unit_imp = {
    return PCA_Types.Dose_Rate_Unit_imp(Base_Types.String_empty())
  }
}

@datatype class Dose_Rate_Unit_imp(
  value : Base_Types.String) {
}

object Dose_Rate_Unit_imp_Payload {
  def empty(): Dose_Rate_Unit_imp_Payload = {
    return Dose_Rate_Unit_imp_Payload(PCA_Types.Dose_Rate_Unit_imp.empty())
  }
}

@datatype class Dose_Rate_Unit_imp_Payload(value: PCA_Types.Dose_Rate_Unit_imp) extends art.DataContent
