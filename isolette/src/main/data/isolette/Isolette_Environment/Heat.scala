// #Sireum

package isolette.Isolette_Environment

import org.sireum._
import isolette._

// This file was auto-generated.  Do not edit

@enum object Heat {
  'Dummy_Head_Enum
}

object Heat_Payload {
  def empty(): Heat_Payload = {
    return Heat_Payload(Isolette_Environment.Heat.byOrdinal(0).get)
  }
}

@datatype class Heat_Payload(value: Isolette_Environment.Heat.Type) extends art.DataContent
