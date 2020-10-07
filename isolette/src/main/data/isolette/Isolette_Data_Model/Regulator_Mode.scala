// #Sireum

package isolette.Isolette_Data_Model

import org.sireum._
import isolette._

// This file was auto-generated.  Do not edit

@enum object Regulator_Mode {
  'Init_Regulator_Mode
  'Normal_Regulator_Mode
  'Failed_Regulator_Mode
}

object Regulator_Mode_Payload {
  def empty(): Regulator_Mode_Payload = {
    return Regulator_Mode_Payload(Isolette_Data_Model.Regulator_Mode.byOrdinal(0).get)
  }
}

@datatype class Regulator_Mode_Payload(value: Isolette_Data_Model.Regulator_Mode.Type) extends art.DataContent
