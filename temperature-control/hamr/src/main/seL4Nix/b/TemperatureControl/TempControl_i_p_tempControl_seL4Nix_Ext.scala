package b.TemperatureControl

import org.sireum._
import art._

object TempControl_i_p_tempControl_seL4Nix_Ext {
  def currentTemp_IsEmpty(): B = halt("stub")

  def currentTemp_Receive(): Option[DataContent] = halt("stub")

  def fanAck_IsEmpty(): B = halt("stub")

  def fanAck_Receive(): Option[DataContent] = halt("stub")

  def setPoint_IsEmpty(): B = halt("stub")

  def setPoint_Receive(): Option[DataContent] = halt("stub")

  def fanCmd_Send(d: DataContent): Unit = halt("stub")

  def tempChanged_IsEmpty(): B = halt("stub")

  def tempChanged_Receive(): Option[DataContent] = halt("stub")
}
