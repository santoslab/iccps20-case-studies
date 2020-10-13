package isolette.Regulate

import org.sireum._
import art._

object Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_seL4Nix_Ext {
  def current_tempWstatus_IsEmpty(): B = halt("stub")

  def current_tempWstatus_Receive(): Option[DataContent] = halt("stub")

  def lower_desired_tempWstatus_IsEmpty(): B = halt("stub")

  def lower_desired_tempWstatus_Receive(): Option[DataContent] = halt("stub")

  def upper_desired_tempWstatus_IsEmpty(): B = halt("stub")

  def upper_desired_tempWstatus_Receive(): Option[DataContent] = halt("stub")

  def regulator_mode_IsEmpty(): B = halt("stub")

  def regulator_mode_Receive(): Option[DataContent] = halt("stub")

  def upper_desired_temp_Send(d: DataContent): Unit = halt("stub")

  def lower_desired_temp_Send(d: DataContent): Unit = halt("stub")

  def displayed_temp_Send(d: DataContent): Unit = halt("stub")

  def regulator_status_Send(d: DataContent): Unit = halt("stub")

  def interface_failure_Send(d: DataContent): Unit = halt("stub")
}
