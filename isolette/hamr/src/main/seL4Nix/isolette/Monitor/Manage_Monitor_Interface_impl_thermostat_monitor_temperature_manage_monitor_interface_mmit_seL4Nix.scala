// #Sireum

package isolette.Monitor

import org.sireum._
import art._

@ext object Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_mmit_seL4Nix {
  // returns T if seL4's upper_alarm_tempWstatus port is empty, F otherwise 
  def upper_alarm_tempWstatus_IsEmpty(): B = $

  // returns result of dequeuing seL4's upper_alarm_tempWstatus port 
  def upper_alarm_tempWstatus_Receive(): Option[DataContent] = $

  // returns T if seL4's lower_alarm_tempWstatus port is empty, F otherwise 
  def lower_alarm_tempWstatus_IsEmpty(): B = $

  // returns result of dequeuing seL4's lower_alarm_tempWstatus port 
  def lower_alarm_tempWstatus_Receive(): Option[DataContent] = $

  // returns T if seL4's current_tempWstatus port is empty, F otherwise 
  def current_tempWstatus_IsEmpty(): B = $

  // returns result of dequeuing seL4's current_tempWstatus port 
  def current_tempWstatus_Receive(): Option[DataContent] = $

  // returns T if seL4's monitor_mode port is empty, F otherwise 
  def monitor_mode_IsEmpty(): B = $

  // returns result of dequeuing seL4's monitor_mode port 
  def monitor_mode_Receive(): Option[DataContent] = $

  // send payload 'd' to components connected to seL4's upper_alarm_temp port
  def upper_alarm_temp_Send(d: DataContent): Unit = $

  // send payload 'd' to components connected to seL4's lower_alarm_temp port
  def lower_alarm_temp_Send(d: DataContent): Unit = $

  // send payload 'd' to components connected to seL4's monitor_status port
  def monitor_status_Send(d: DataContent): Unit = $

  // send payload 'd' to components connected to seL4's interface_failure port
  def interface_failure_Send(d: DataContent): Unit = $
}
