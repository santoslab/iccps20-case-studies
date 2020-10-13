// #Sireum

package isolette.Isolette_Environment

import org.sireum._
import isolette._

// This file was auto-generated.  Do not edit

@enum object Interface_Interaction {
  'Dummy_Interface_Interaction_Enum
}

object Interface_Interaction_Payload {
  def empty(): Interface_Interaction_Payload = {
    return Interface_Interaction_Payload(Isolette_Environment.Interface_Interaction.byOrdinal(0).get)
  }
}

@datatype class Interface_Interaction_Payload(value: Isolette_Environment.Interface_Interaction.Type) extends art.DataContent
