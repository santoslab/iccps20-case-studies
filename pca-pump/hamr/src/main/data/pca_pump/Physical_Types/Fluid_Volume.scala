// #Sireum

package pca_pump.Physical_Types

import org.sireum._
import pca_pump._

object Fluid_Volume {
  def empty(): Physical_Types.Fluid_Volume = {
    return Physical_Types.Fluid_Volume()
  }
}

@datatype class Fluid_Volume() // type skeleton

object Fluid_Volume_Payload {
  def empty(): Fluid_Volume_Payload = {
    return Fluid_Volume_Payload(Physical_Types.Fluid_Volume.empty())
  }
}

@datatype class Fluid_Volume_Payload(value: Physical_Types.Fluid_Volume) extends art.DataContent
