// #Sireum

package building_control_gen_mixed.BuildingControl

import org.sireum._
import building_control_gen_mixed._

// This file was auto-generated.  Do not edit

@enum object FanAck {
  'Ok
  'Error
}

object FanAck_Payload {
  def empty(): FanAck_Payload = {
    return FanAck_Payload(BuildingControl.FanAck.byOrdinal(0).get)
  }
}

@datatype class FanAck_Payload(value: BuildingControl.FanAck.Type) extends art.DataContent
