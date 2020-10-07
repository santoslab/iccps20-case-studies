// #Sireum

package pca_pump.PCA_Types

import org.sireum._
import pca_pump._

object Drug_Code {
  def empty(): PCA_Types.Drug_Code = {
    return PCA_Types.Drug_Code()
  }
}

@datatype class Drug_Code() // type skeleton

object Drug_Code_Payload {
  def empty(): Drug_Code_Payload = {
    return Drug_Code_Payload(PCA_Types.Drug_Code.empty())
  }
}

@datatype class Drug_Code_Payload(value: PCA_Types.Drug_Code) extends art.DataContent
