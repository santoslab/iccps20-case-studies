package isolette.Monitor

import org.sireum._
import art._

object Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_mmit_seL4Nix_Ext {
  def upper_alarm_tempWstatus_IsEmpty(): B = halt("stub")

  def upper_alarm_tempWstatus_Receive(): Option[DataContent] = halt("stub")

  def lower_alarm_tempWstatus_IsEmpty(): B = halt("stub")

  def lower_alarm_tempWstatus_Receive(): Option[DataContent] = halt("stub")

  def current_tempWstatus_IsEmpty(): B = halt("stub")

  def current_tempWstatus_Receive(): Option[DataContent] = halt("stub")

  def monitor_mode_IsEmpty(): B = halt("stub")

  def monitor_mode_Receive(): Option[DataContent] = halt("stub")

  def upper_alarm_temp_Send(d: DataContent): Unit = halt("stub")

  def lower_alarm_temp_Send(d: DataContent): Unit = halt("stub")

  def monitor_status_Send(d: DataContent): Unit = halt("stub")

  def interface_failure_Send(d: DataContent): Unit = halt("stub")
}
