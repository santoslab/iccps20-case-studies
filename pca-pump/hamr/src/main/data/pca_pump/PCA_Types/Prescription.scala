// #Sireum

package pca_pump.PCA_Types

import org.sireum._
import pca_pump._

object Prescription {
  def empty(): PCA_Types.Prescription = {
    return PCA_Types.Prescription()
  }
}

@datatype class Prescription() // type skeleton

object Prescription_Payload {
  def empty(): Prescription_Payload = {
    return Prescription_Payload(PCA_Types.Prescription.empty())
  }
}

@datatype class Prescription_Payload(value: PCA_Types.Prescription) extends art.DataContent
