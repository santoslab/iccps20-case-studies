// #Sireum

package pca_pump.PCA_Types

import org.sireum._
import pca_pump._

object Drug_Concentration {
  def empty(): PCA_Types.Drug_Concentration = {
    return PCA_Types.Drug_Concentration()
  }
}

@datatype class Drug_Concentration() // type skeleton

object Drug_Concentration_Payload {
  def empty(): Drug_Concentration_Payload = {
    return Drug_Concentration_Payload(PCA_Types.Drug_Concentration.empty())
  }
}

@datatype class Drug_Concentration_Payload(value: PCA_Types.Drug_Concentration) extends art.DataContent
