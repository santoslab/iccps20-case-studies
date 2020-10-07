// #Sireum

package pca_pump.PCA_Types

import org.sireum._
import pca_pump._

// This file was auto-generated.  Do not edit

object Drug_Concentration_imp {
  def empty(): PCA_Types.Drug_Concentration_imp = {
    return PCA_Types.Drug_Concentration_imp(Base_Types.Float_32_empty())
  }
}

@datatype class Drug_Concentration_imp(
  value : Base_Types.Float_32) {
}

object Drug_Concentration_imp_Payload {
  def empty(): Drug_Concentration_imp_Payload = {
    return Drug_Concentration_imp_Payload(PCA_Types.Drug_Concentration_imp.empty())
  }
}

@datatype class Drug_Concentration_imp_Payload(value: PCA_Types.Drug_Concentration_imp) extends art.DataContent
