// #Sireum

package b.TemperatureControl

import org.sireum._
import b._

// This file was auto-generated.  Do not edit

@enum object FanCmd {
  'On
  'Off
}

object FanCmd_Payload {
  def empty(): FanCmd_Payload = {
    return FanCmd_Payload(TemperatureControl.FanCmd.byOrdinal(0).get)
  }
}

@datatype class FanCmd_Payload(value: TemperatureControl.FanCmd.Type) extends art.DataContent
