// #Sireum

package isolette.Isolette_Data_Model

import org.sireum._
import isolette._

// This file was auto-generated.  Do not edit

@enum object Status {
  'Init_Status
  'On_Status
  'Failed_Status
}

object Status_Payload {
  def empty(): Status_Payload = {
    return Status_Payload(Isolette_Data_Model.Status.byOrdinal(0).get)
  }
}

@datatype class Status_Payload(value: Isolette_Data_Model.Status.Type) extends art.DataContent
