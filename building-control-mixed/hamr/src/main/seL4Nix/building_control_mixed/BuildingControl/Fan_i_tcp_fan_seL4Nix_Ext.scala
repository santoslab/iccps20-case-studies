package building_control_mixed.BuildingControl

import org.sireum._
import art._

object Fan_i_tcp_fan_seL4Nix_Ext {
  def fanCmd_IsEmpty(): B = halt("stub")

  def fanCmd_Receive(): Option[DataContent] = halt("stub")

  def fanAck_Send(d: DataContent): Unit = halt("stub")
}
