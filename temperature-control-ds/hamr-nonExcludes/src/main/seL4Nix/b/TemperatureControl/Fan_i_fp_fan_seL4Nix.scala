// #Sireum

package b.TemperatureControl

import org.sireum._
import art._

@ext object Fan_i_fp_fan_seL4Nix {
  // returns T if seL4's fanCmd port is empty, F otherwise 
  def fanCmd_IsEmpty(): B = $

  // returns result of dequeuing seL4's fanCmd port 
  def fanCmd_Receive(): Option[DataContent] = $

  // send payload 'd' to components connected to seL4's fanAck port
  def fanAck_Send(d: DataContent): Unit = $
}
