// #Sireum

package b.TemperatureControl

import org.sireum._
import art._

@ext object TempControl_i_p_tempControl_seL4Nix {
  // returns T if seL4's currentTemp port is empty, F otherwise 
  def currentTemp_IsEmpty(): B = $

  // returns result of dequeuing seL4's currentTemp port 
  def currentTemp_Receive(): Option[DataContent] = $

  // returns T if seL4's fanAck port is empty, F otherwise 
  def fanAck_IsEmpty(): B = $

  // returns result of dequeuing seL4's fanAck port 
  def fanAck_Receive(): Option[DataContent] = $

  // returns T if seL4's setPoint port is empty, F otherwise 
  def setPoint_IsEmpty(): B = $

  // returns result of dequeuing seL4's setPoint port 
  def setPoint_Receive(): Option[DataContent] = $

  // send payload 'd' to components connected to seL4's fanCmd port
  def fanCmd_Send(d: DataContent): Unit = $

  // returns T if seL4's tempChanged port is empty, F otherwise 
  def tempChanged_IsEmpty(): B = $

  // returns result of dequeuing seL4's tempChanged port 
  def tempChanged_Receive(): Option[DataContent] = $
}
