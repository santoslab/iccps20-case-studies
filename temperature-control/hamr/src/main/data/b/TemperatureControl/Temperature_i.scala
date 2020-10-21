// #Sireum

package b.TemperatureControl

import org.sireum._
import b._

// This file was auto-generated.  Do not edit

object Temperature_i {
  def empty(): TemperatureControl.Temperature_i = {
    return TemperatureControl.Temperature_i(Base_Types.Float_32_empty(), TemperatureControl.TempUnit.byOrdinal(0).get)
  }
}

@datatype class Temperature_i(
  degrees : Base_Types.Float_32,
  unit : TemperatureControl.TempUnit.Type) {
}

object Temperature_i_Payload {
  def empty(): Temperature_i_Payload = {
    return Temperature_i_Payload(TemperatureControl.Temperature_i.empty())
  }
}

@datatype class Temperature_i_Payload(value: TemperatureControl.Temperature_i) extends art.DataContent
