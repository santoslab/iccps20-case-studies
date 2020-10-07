// #Sireum

package pca_pump.PCA_Types

import org.sireum._
import pca_pump._

// This file was auto-generated.  Do not edit

object Prescription_imp {
  def empty(): PCA_Types.Prescription_imp = {
    return PCA_Types.Prescription_imp(Base_Types.String_empty(), Base_Types.String_empty(), PCA_Types.Drug_Code_imp.empty(), PCA_Types.Drug_Concentration_imp.empty(), PCA_Types.Drug_Volume_imp.empty(), PCA_Types.Flow_Rate_imp.empty(), PCA_Types.Flow_Rate_imp.empty(), PCA_Types.Drug_Volume_imp.empty(), PCA_Types.Drug_Volume_imp.empty(), ICE_Types.Minute_imp.empty(), Base_Types.String_empty(), Base_Types.String_empty(), Base_Types.String_empty())
  }
}

@datatype class Prescription_imp(
  patient : Base_Types.String,
  drugName : Base_Types.String,
  code : PCA_Types.Drug_Code_imp,
  concentration : PCA_Types.Drug_Concentration_imp,
  initialVolume : PCA_Types.Drug_Volume_imp,
  basalFlowRate : PCA_Types.Flow_Rate_imp,
  patientBolusRate : PCA_Types.Flow_Rate_imp,
  vtbi : PCA_Types.Drug_Volume_imp,
  maxDrugPerHour : PCA_Types.Drug_Volume_imp,
  minimumTimeBetweenBolus : ICE_Types.Minute_imp,
  dateRxFilled : Base_Types.String,
  prescriber : Base_Types.String,
  pharmacist : Base_Types.String) {
}

object Prescription_imp_Payload {
  def empty(): Prescription_imp_Payload = {
    return Prescription_imp_Payload(PCA_Types.Prescription_imp.empty())
  }
}

@datatype class Prescription_imp_Payload(value: PCA_Types.Prescription_imp) extends art.DataContent
