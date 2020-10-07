// #Sireum

package pca_pump.PCA_Types

import org.sireum._
import pca_pump._

// This file was auto-generated.  Do not edit

object Drug_Record_imp {
  def empty(): PCA_Types.Drug_Record_imp = {
    return PCA_Types.Drug_Record_imp(PCA_Types.Drug_Code_imp.empty(), Base_Types.String_empty(), Base_Types.String_empty(), PCA_Types.Dose_Rate_Unit_imp.empty(), PCA_Types.Infusion_Unit_imp.empty(), PCA_Types.Drug_Weight_imp.empty(), PCA_Types.Drug_Concentration_imp.empty(), PCA_Types.Drug_Volume_imp.empty(), PCA_Types.Drug_Volume_imp.empty(), PCA_Types.Drug_Volume_imp.empty(), PCA_Types.Drug_Volume_imp.empty(), PCA_Types.Drug_Volume_imp.empty(), PCA_Types.Flow_Rate_imp.empty(), PCA_Types.Flow_Rate_imp.empty(), PCA_Types.Flow_Rate_imp.empty(), PCA_Types.Flow_Rate_imp.empty(), PCA_Types.Flow_Rate_imp.empty(), PCA_Types.Drug_Volume_imp.empty(), PCA_Types.Flow_Rate_imp.empty())
  }
}

@datatype class Drug_Record_imp(
  code : PCA_Types.Drug_Code_imp,
  name : Base_Types.String,
  location : Base_Types.String,
  dose_rate_unit : PCA_Types.Dose_Rate_Unit_imp,
  vtbi_unit : PCA_Types.Infusion_Unit_imp,
  amount : PCA_Types.Drug_Weight_imp,
  concentration : PCA_Types.Drug_Concentration_imp,
  vtbiLowerSoft : PCA_Types.Drug_Volume_imp,
  vtbiLowerHard : PCA_Types.Drug_Volume_imp,
  vtbiTypical : PCA_Types.Drug_Volume_imp,
  vtbiUpperSoft : PCA_Types.Drug_Volume_imp,
  vtbiUpperHard : PCA_Types.Drug_Volume_imp,
  basalRateLowerSoft : PCA_Types.Flow_Rate_imp,
  basalRateLowerHard : PCA_Types.Flow_Rate_imp,
  basalRateTypical : PCA_Types.Flow_Rate_imp,
  basalRateUpperSoft : PCA_Types.Flow_Rate_imp,
  basalRateUpperHard : PCA_Types.Flow_Rate_imp,
  bolusTypical : PCA_Types.Drug_Volume_imp,
  squareBolusRateTypical : PCA_Types.Flow_Rate_imp) {
}

object Drug_Record_imp_Payload {
  def empty(): Drug_Record_imp_Payload = {
    return Drug_Record_imp_Payload(PCA_Types.Drug_Record_imp.empty())
  }
}

@datatype class Drug_Record_imp_Payload(value: PCA_Types.Drug_Record_imp) extends art.DataContent
