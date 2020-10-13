// #Sireum

package isolette.Isolette

import org.sireum._
import art._

@ext object operator_interface_thread_impl_operator_interface_oip_oit_seL4Nix {
  // returns T if seL4's regulator_status port is empty, F otherwise 
  def regulator_status_IsEmpty(): B = $

  // returns result of dequeuing seL4's regulator_status port 
  def regulator_status_Receive(): Option[DataContent] = $

  // returns T if seL4's monitor_status port is empty, F otherwise 
  def monitor_status_IsEmpty(): B = $

  // returns result of dequeuing seL4's monitor_status port 
  def monitor_status_Receive(): Option[DataContent] = $

  // returns T if seL4's display_temperature port is empty, F otherwise 
  def display_temperature_IsEmpty(): B = $

  // returns result of dequeuing seL4's display_temperature port 
  def display_temperature_Receive(): Option[DataContent] = $

  // returns T if seL4's alarm_control port is empty, F otherwise 
  def alarm_control_IsEmpty(): B = $

  // returns result of dequeuing seL4's alarm_control port 
  def alarm_control_Receive(): Option[DataContent] = $

  // send payload 'd' to components connected to seL4's lower_desired_tempWstatus port
  def lower_desired_tempWstatus_Send(d: DataContent): Unit = $

  // send payload 'd' to components connected to seL4's upper_desired_tempWstatus port
  def upper_desired_tempWstatus_Send(d: DataContent): Unit = $

  // send payload 'd' to components connected to seL4's lower_alarm_tempWstatus port
  def lower_alarm_tempWstatus_Send(d: DataContent): Unit = $

  // send payload 'd' to components connected to seL4's upper_alarm_tempWstatus port
  def upper_alarm_tempWstatus_Send(d: DataContent): Unit = $
}
