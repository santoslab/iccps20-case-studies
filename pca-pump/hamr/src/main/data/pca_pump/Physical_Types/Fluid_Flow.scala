// #Sireum

package pca_pump.Physical_Types

import org.sireum._
import pca_pump._

object Fluid_Flow {
  def empty(): Physical_Types.Fluid_Flow = {
    return Physical_Types.Fluid_Flow()
  }
}

@datatype class Fluid_Flow() // type skeleton

object Fluid_Flow_Payload {
  def empty(): Fluid_Flow_Payload = {
    return Fluid_Flow_Payload(Physical_Types.Fluid_Flow.empty())
  }
}

@datatype class Fluid_Flow_Payload(value: Physical_Types.Fluid_Flow) extends art.DataContent
