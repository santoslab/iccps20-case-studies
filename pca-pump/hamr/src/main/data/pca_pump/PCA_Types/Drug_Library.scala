// #Sireum

package pca_pump.PCA_Types

import org.sireum._
import pca_pump._

// This file was auto-generated.  Do not edit

object Drug_Library {
  def empty(): PCA_Types.Drug_Library = {
    return PCA_Types.Drug_Library(ISZ.create(500, PCA_Types.Drug_Record_imp.empty()))
  }
}

@datatype class Drug_Library(
  value : ISZ[PCA_Types.Drug_Record_imp]) {
  //{  assert (value.size == 500) }
}

object Drug_Library_Payload {
  def empty(): Drug_Library_Payload = {
    return Drug_Library_Payload(PCA_Types.Drug_Library.empty())
  }
}

@datatype class Drug_Library_Payload(value: PCA_Types.Drug_Library) extends art.DataContent
