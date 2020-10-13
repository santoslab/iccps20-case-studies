// #Sireum

package isolette.Devices

import org.sireum._
import art._

@ext object Heat_Source_impl_heat_source_cpi_heat_controller_seL4Nix {
  // returns T if seL4's heat_control port is empty, F otherwise 
  def heat_control_IsEmpty(): B = $

  // returns result of dequeuing seL4's heat_control port 
  def heat_control_Receive(): Option[DataContent] = $

  // send payload 'd' to components connected to seL4's heat_out port
  def heat_out_Send(d: DataContent): Unit = $
}
