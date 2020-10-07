// #Sireum

package pca_pump.PCA_Types

import org.sireum._
import pca_pump._

object Dose_Rate_Unit {
  def empty(): PCA_Types.Dose_Rate_Unit = {
    return PCA_Types.Dose_Rate_Unit()
  }
}

@datatype class Dose_Rate_Unit() // type skeleton

object Dose_Rate_Unit_Payload {
  def empty(): Dose_Rate_Unit_Payload = {
    return Dose_Rate_Unit_Payload(PCA_Types.Dose_Rate_Unit.empty())
  }
}

@datatype class Dose_Rate_Unit_Payload(value: PCA_Types.Dose_Rate_Unit) extends art.DataContent
