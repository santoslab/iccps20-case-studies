// #Sireum

package isolette.Regulate

import org.sireum._
import art._

@ext object Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode_mrmt_seL4Nix {
  // returns T if seL4's current_tempWstatus port is empty, F otherwise 
  def current_tempWstatus_IsEmpty(): B = $

  // returns result of dequeuing seL4's current_tempWstatus port 
  def current_tempWstatus_Receive(): Option[DataContent] = $

  // returns T if seL4's interface_failure port is empty, F otherwise 
  def interface_failure_IsEmpty(): B = $

  // returns result of dequeuing seL4's interface_failure port 
  def interface_failure_Receive(): Option[DataContent] = $

  // returns T if seL4's internal_failure port is empty, F otherwise 
  def internal_failure_IsEmpty(): B = $

  // returns result of dequeuing seL4's internal_failure port 
  def internal_failure_Receive(): Option[DataContent] = $

  // send payload 'd' to components connected to seL4's regulator_mode port
  def regulator_mode_Send(d: DataContent): Unit = $
}
