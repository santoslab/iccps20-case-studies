// #Sireum

package isolette.Isolette_Data_Model

import org.sireum._
import isolette._

// This file was auto-generated.  Do not edit

@enum object On_Off {
  'Onn
  'Off
}

object On_Off_Payload {
  def empty(): On_Off_Payload = {
    return On_Off_Payload(Isolette_Data_Model.On_Off.byOrdinal(0).get)
  }
}

@datatype class On_Off_Payload(value: Isolette_Data_Model.On_Off.Type) extends art.DataContent
