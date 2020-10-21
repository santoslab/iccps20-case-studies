// #Sireum

package b.TemperatureControl

import org.sireum._
import art._

@ext object TempSensor_i_p_tempSensor_seL4Nix {
  // send payload 'd' to components connected to seL4's currentTemp port
  def currentTemp_Send(d: DataContent): Unit = $

  // send payload 'd' to components connected to seL4's tempChanged port
  def tempChanged_Send(d: DataContent): Unit = $
}
