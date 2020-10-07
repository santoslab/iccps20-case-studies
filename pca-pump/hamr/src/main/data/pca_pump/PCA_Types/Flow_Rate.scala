// #Sireum

package pca_pump.PCA_Types

import org.sireum._
import pca_pump._

object Flow_Rate {
  def empty(): PCA_Types.Flow_Rate = {
    return PCA_Types.Flow_Rate()
  }
}

@datatype class Flow_Rate() // type skeleton

object Flow_Rate_Payload {
  def empty(): Flow_Rate_Payload = {
    return Flow_Rate_Payload(PCA_Types.Flow_Rate.empty())
  }
}

@datatype class Flow_Rate_Payload(value: PCA_Types.Flow_Rate) extends art.DataContent
