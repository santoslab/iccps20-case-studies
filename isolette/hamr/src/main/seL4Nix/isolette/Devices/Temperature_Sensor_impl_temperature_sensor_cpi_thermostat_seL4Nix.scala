// #Sireum

package isolette.Devices

import org.sireum._
import art._

@ext object Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_seL4Nix {
  // returns T if seL4's air port is empty, F otherwise 
  def air_IsEmpty(): B = $

  // returns result of dequeuing seL4's air port 
  def air_Receive(): Option[DataContent] = $

  // send payload 'd' to components connected to seL4's current_tempWstatus port
  def current_tempWstatus_Send(d: DataContent): Unit = $
}
