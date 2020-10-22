// #Sireum

package b.TemperatureControl

import org.sireum._
import b._

// This file was auto-generated.  Do not edit

@enum object TempUnit {
  'Fahrenheit
  'Celsius
  'Kelvin
}

object TempUnit_Payload {
  def empty(): TempUnit_Payload = {
    return TempUnit_Payload(TemperatureControl.TempUnit.byOrdinal(0).get)
  }
}

@datatype class TempUnit_Payload(value: TemperatureControl.TempUnit.Type) extends art.DataContent
