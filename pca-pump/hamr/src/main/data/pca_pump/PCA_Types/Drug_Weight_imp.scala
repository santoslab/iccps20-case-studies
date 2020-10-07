// #Sireum

package pca_pump.PCA_Types

import org.sireum._
import pca_pump._

// This file was auto-generated.  Do not edit

object Drug_Weight_imp {
  def empty(): PCA_Types.Drug_Weight_imp = {
    return PCA_Types.Drug_Weight_imp(Base_Types.Integer_16_empty())
  }
}

@datatype class Drug_Weight_imp(
  value : Base_Types.Integer_16) {
}

object Drug_Weight_imp_Payload {
  def empty(): Drug_Weight_imp_Payload = {
    return Drug_Weight_imp_Payload(PCA_Types.Drug_Weight_imp.empty())
  }
}

@datatype class Drug_Weight_imp_Payload(value: PCA_Types.Drug_Weight_imp) extends art.DataContent
