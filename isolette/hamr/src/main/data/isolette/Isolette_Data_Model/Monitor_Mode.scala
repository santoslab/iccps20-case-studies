// #Sireum

package isolette.Isolette_Data_Model

import org.sireum._
import isolette._

// This file was auto-generated.  Do not edit

@enum object Monitor_Mode {
  'Init_Monitor_Mode
  'Normal_Monitor_Mode
  'Failed_Monitor_Mode
}

object Monitor_Mode_Payload {
  def empty(): Monitor_Mode_Payload = {
    return Monitor_Mode_Payload(Isolette_Data_Model.Monitor_Mode.byOrdinal(0).get)
  }
}

@datatype class Monitor_Mode_Payload(value: Isolette_Data_Model.Monitor_Mode.Type) extends art.DataContent
