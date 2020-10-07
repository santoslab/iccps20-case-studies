// #Sireum

package pca_pump.PCA_Types

import org.sireum._
import pca_pump._

object Infusion_Unit {
  def empty(): PCA_Types.Infusion_Unit = {
    return PCA_Types.Infusion_Unit()
  }
}

@datatype class Infusion_Unit() // type skeleton

object Infusion_Unit_Payload {
  def empty(): Infusion_Unit_Payload = {
    return Infusion_Unit_Payload(PCA_Types.Infusion_Unit.empty())
  }
}

@datatype class Infusion_Unit_Payload(value: PCA_Types.Infusion_Unit) extends art.DataContent
