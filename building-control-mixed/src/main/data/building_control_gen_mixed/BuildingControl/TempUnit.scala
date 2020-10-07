// #Sireum

package building_control_gen_mixed.BuildingControl

import org.sireum._
import building_control_gen_mixed._

// This file was auto-generated.  Do not edit

@enum object TempUnit {
  'Fahrenheit
  'Celsius
  'Kelvin
}

object TempUnit_Payload {
  def empty(): TempUnit_Payload = {
    return TempUnit_Payload(BuildingControl.TempUnit.byOrdinal(0).get)
  }
}

@datatype class TempUnit_Payload(value: BuildingControl.TempUnit.Type) extends art.DataContent
