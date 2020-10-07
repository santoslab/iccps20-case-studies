// #Sireum

package pca_pump.PCA_Types

import org.sireum._
import pca_pump._

// This file was auto-generated.  Do not edit

object Drug_Code_imp {
  def empty(): PCA_Types.Drug_Code_imp = {
    return PCA_Types.Drug_Code_imp(Base_Types.String_empty())
  }
}

@datatype class Drug_Code_imp(
  code : Base_Types.String) {
}

object Drug_Code_imp_Payload {
  def empty(): Drug_Code_imp_Payload = {
    return Drug_Code_imp_Payload(PCA_Types.Drug_Code_imp.empty())
  }
}

@datatype class Drug_Code_imp_Payload(value: PCA_Types.Drug_Code_imp) extends art.DataContent
