// #Sireum

package pca_pump.PCA_Types

import org.sireum._
import pca_pump._

// This file was auto-generated.  Do not edit

object Drug_Volume_imp {
  def empty(): PCA_Types.Drug_Volume_imp = {
    return PCA_Types.Drug_Volume_imp(Base_Types.Integer_16_empty())
  }
}

@datatype class Drug_Volume_imp(
  value : Base_Types.Integer_16) {
}

object Drug_Volume_imp_Payload {
  def empty(): Drug_Volume_imp_Payload = {
    return Drug_Volume_imp_Payload(PCA_Types.Drug_Volume_imp.empty())
  }
}

@datatype class Drug_Volume_imp_Payload(value: PCA_Types.Drug_Volume_imp) extends art.DataContent
