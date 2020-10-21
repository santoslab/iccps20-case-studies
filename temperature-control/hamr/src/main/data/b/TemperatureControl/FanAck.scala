// #Sireum

package b.TemperatureControl

import org.sireum._
import b._

// This file was auto-generated.  Do not edit

@enum object FanAck {
  'Ok
  'Error
}

object FanAck_Payload {
  def empty(): FanAck_Payload = {
    return FanAck_Payload(TemperatureControl.FanAck.byOrdinal(0).get)
  }
}

@datatype class FanAck_Payload(value: TemperatureControl.FanAck.Type) extends art.DataContent
