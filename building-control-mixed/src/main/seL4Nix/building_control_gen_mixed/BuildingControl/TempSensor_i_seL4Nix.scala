// #Sireum

package building_control_gen_mixed.BuildingControl

import org.sireum._
import art._

@ext object TempSensor_i_seL4Nix {
  // send payload 'd' to components connected to seL4's currentTemp port
  def currentTemp_Send(d: DataContent): Unit = $

  // send payload 'd' to components connected to seL4's tempChanged port
  def tempChanged_Send(d: DataContent): Unit = $
}
