package isolette.Regulate

import org.sireum._
import art._

object Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_mhst_seL4Nix_Ext {
  def current_tempWstatus_IsEmpty(): B = halt("stub")

  def current_tempWstatus_Receive(): Option[DataContent] = halt("stub")

  def lower_desired_temp_IsEmpty(): B = halt("stub")

  def lower_desired_temp_Receive(): Option[DataContent] = halt("stub")

  def upper_desired_temp_IsEmpty(): B = halt("stub")

  def upper_desired_temp_Receive(): Option[DataContent] = halt("stub")

  def regulator_mode_IsEmpty(): B = halt("stub")

  def regulator_mode_Receive(): Option[DataContent] = halt("stub")

  def heat_control_Send(d: DataContent): Unit = halt("stub")
}
