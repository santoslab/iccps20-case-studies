// #Sireum

package b.TemperatureControl

import org.sireum._
import b._

// This file was auto-generated.  Do not edit

object SetPoint_i {
  def empty(): TemperatureControl.SetPoint_i = {
    return TemperatureControl.SetPoint_i(TemperatureControl.Temperature_i.empty(), TemperatureControl.Temperature_i.empty())
  }
}

@datatype class SetPoint_i(
  low : TemperatureControl.Temperature_i,
  high : TemperatureControl.Temperature_i) {
}

object SetPoint_i_Payload {
  def empty(): SetPoint_i_Payload = {
    return SetPoint_i_Payload(TemperatureControl.SetPoint_i.empty())
  }
}

@datatype class SetPoint_i_Payload(value: TemperatureControl.SetPoint_i) extends art.DataContent
