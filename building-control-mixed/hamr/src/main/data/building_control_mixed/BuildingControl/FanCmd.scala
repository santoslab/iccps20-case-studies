// #Sireum

package building_control_mixed.BuildingControl

import org.sireum._
import building_control_mixed._

// This file was auto-generated.  Do not edit

@enum object FanCmd {
  'On
  'Off
}

object FanCmd_Payload {
  def empty(): FanCmd_Payload = {
    return FanCmd_Payload(BuildingControl.FanCmd.byOrdinal(0).get)
  }
}

@datatype class FanCmd_Payload(value: BuildingControl.FanCmd.Type) extends art.DataContent
