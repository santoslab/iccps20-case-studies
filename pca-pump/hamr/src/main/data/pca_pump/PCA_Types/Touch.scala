// #Sireum

package pca_pump.PCA_Types

import org.sireum._
import pca_pump._

object Touch {
  def empty(): PCA_Types.Touch = {
    return PCA_Types.Touch()
  }
}

@datatype class Touch() // type skeleton

object Touch_Payload {
  def empty(): Touch_Payload = {
    return Touch_Payload(PCA_Types.Touch.empty())
  }
}

@datatype class Touch_Payload(value: PCA_Types.Touch) extends art.DataContent
