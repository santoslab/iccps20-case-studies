// #Sireum

package pca_pump.PCA_Types

import org.sireum._
import pca_pump._

// This file was auto-generated.  Do not edit

object Flow_Rate_imp {
  def empty(): PCA_Types.Flow_Rate_imp = {
    return PCA_Types.Flow_Rate_imp(Base_Types.Integer_16_empty())
  }
}

@datatype class Flow_Rate_imp(
  value : Base_Types.Integer_16) {
}

object Flow_Rate_imp_Payload {
  def empty(): Flow_Rate_imp_Payload = {
    return Flow_Rate_imp_Payload(PCA_Types.Flow_Rate_imp.empty())
  }
}

@datatype class Flow_Rate_imp_Payload(value: PCA_Types.Flow_Rate_imp) extends art.DataContent
