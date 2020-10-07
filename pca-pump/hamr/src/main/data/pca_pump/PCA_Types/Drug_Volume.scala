// #Sireum

package pca_pump.PCA_Types

import org.sireum._
import pca_pump._

object Drug_Volume {
  def empty(): PCA_Types.Drug_Volume = {
    return PCA_Types.Drug_Volume()
  }
}

@datatype class Drug_Volume() // type skeleton

object Drug_Volume_Payload {
  def empty(): Drug_Volume_Payload = {
    return Drug_Volume_Payload(PCA_Types.Drug_Volume.empty())
  }
}

@datatype class Drug_Volume_Payload(value: PCA_Types.Drug_Volume) extends art.DataContent
