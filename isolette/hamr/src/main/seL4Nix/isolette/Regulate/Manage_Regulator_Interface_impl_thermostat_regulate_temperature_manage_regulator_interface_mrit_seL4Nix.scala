// #Sireum

package isolette.Regulate

import org.sireum._
import art._

@ext object Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_seL4Nix {
  // returns T if seL4's current_tempWstatus port is empty, F otherwise 
  def current_tempWstatus_IsEmpty(): B = $

  // returns result of dequeuing seL4's current_tempWstatus port 
  def current_tempWstatus_Receive(): Option[DataContent] = $

  // returns T if seL4's lower_desired_tempWstatus port is empty, F otherwise 
  def lower_desired_tempWstatus_IsEmpty(): B = $

  // returns result of dequeuing seL4's lower_desired_tempWstatus port 
  def lower_desired_tempWstatus_Receive(): Option[DataContent] = $

  // returns T if seL4's upper_desired_tempWstatus port is empty, F otherwise 
  def upper_desired_tempWstatus_IsEmpty(): B = $

  // returns result of dequeuing seL4's upper_desired_tempWstatus port 
  def upper_desired_tempWstatus_Receive(): Option[DataContent] = $

  // returns T if seL4's regulator_mode port is empty, F otherwise 
  def regulator_mode_IsEmpty(): B = $

  // returns result of dequeuing seL4's regulator_mode port 
  def regulator_mode_Receive(): Option[DataContent] = $

  // send payload 'd' to components connected to seL4's upper_desired_temp port
  def upper_desired_temp_Send(d: DataContent): Unit = $

  // send payload 'd' to components connected to seL4's lower_desired_temp port
  def lower_desired_temp_Send(d: DataContent): Unit = $

  // send payload 'd' to components connected to seL4's displayed_temp port
  def displayed_temp_Send(d: DataContent): Unit = $

  // send payload 'd' to components connected to seL4's regulator_status port
  def regulator_status_Send(d: DataContent): Unit = $

  // send payload 'd' to components connected to seL4's interface_failure port
  def interface_failure_Send(d: DataContent): Unit = $
}
