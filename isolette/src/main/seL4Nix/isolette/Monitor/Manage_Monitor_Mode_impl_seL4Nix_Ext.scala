package isolette.Monitor

import org.sireum._
import art._

object Manage_Monitor_Mode_impl_seL4Nix_Ext {
  def current_tempWstatus_IsEmpty(): B = halt("stub")

  def current_tempWstatus_Receive(): Option[DataContent] = halt("stub")

  def interface_failure_IsEmpty(): B = halt("stub")

  def interface_failure_Receive(): Option[DataContent] = halt("stub")

  def internal_failure_IsEmpty(): B = halt("stub")

  def internal_failure_Receive(): Option[DataContent] = halt("stub")

  def monitor_mode_Send(d: DataContent): Unit = halt("stub")
}
