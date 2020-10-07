// #Sireum

package pca_pump.Physical_Types

import org.sireum._
import pca_pump._

// This file was auto-generated.  Do not edit

object Fluid_Volume_imp {
  def empty(): Physical_Types.Fluid_Volume_imp = {
    return Physical_Types.Fluid_Volume_imp(Base_Types.Float_32_empty())
  }
}

@datatype class Fluid_Volume_imp(
  value : Base_Types.Float_32) {
}

object Fluid_Volume_imp_Payload {
  def empty(): Fluid_Volume_imp_Payload = {
    return Fluid_Volume_imp_Payload(Physical_Types.Fluid_Volume_imp.empty())
  }
}

@datatype class Fluid_Volume_imp_Payload(value: Physical_Types.Fluid_Volume_imp) extends art.DataContent
