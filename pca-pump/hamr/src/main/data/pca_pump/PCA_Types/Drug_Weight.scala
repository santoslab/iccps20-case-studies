// #Sireum

package pca_pump.PCA_Types

import org.sireum._
import pca_pump._

object Drug_Weight {
  def empty(): PCA_Types.Drug_Weight = {
    return PCA_Types.Drug_Weight()
  }
}

@datatype class Drug_Weight() // type skeleton

object Drug_Weight_Payload {
  def empty(): Drug_Weight_Payload = {
    return Drug_Weight_Payload(PCA_Types.Drug_Weight.empty())
  }
}

@datatype class Drug_Weight_Payload(value: PCA_Types.Drug_Weight) extends art.DataContent
