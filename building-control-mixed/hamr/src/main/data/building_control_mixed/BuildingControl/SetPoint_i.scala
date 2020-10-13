// #Sireum

package building_control_mixed.BuildingControl

import org.sireum._
import building_control_mixed._

// This file was auto-generated.  Do not edit

object SetPoint_i {
  def empty(): BuildingControl.SetPoint_i = {
    return BuildingControl.SetPoint_i(BuildingControl.Temperature_i.empty(), BuildingControl.Temperature_i.empty())
  }
}

@datatype class SetPoint_i(
  low : BuildingControl.Temperature_i,
  high : BuildingControl.Temperature_i) {
}

object SetPoint_i_Payload {
  def empty(): SetPoint_i_Payload = {
    return SetPoint_i_Payload(BuildingControl.SetPoint_i.empty())
  }
}

@datatype class SetPoint_i_Payload(value: BuildingControl.SetPoint_i) extends art.DataContent
