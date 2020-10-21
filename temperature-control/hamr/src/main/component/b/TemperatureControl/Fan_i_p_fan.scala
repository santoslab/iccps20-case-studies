// #Sireum

package b.TemperatureControl

import org.sireum._
import b._

// This file will not be overwritten so is safe to edit
object Fan_i_p_fan {

  def initialise(api: Fan_i_Initialization_Api): Unit = {
    // example api usage

    api.logInfo("Example info logging")
    api.logDebug("Example debug logging")
    api.logError("Example error logging")

    api.sendfanAck(TemperatureControl.FanAck.byOrdinal(0).get)
  }

  def handlefanCmd(api: Fan_i_Operational_Api, value : TemperatureControl.FanCmd.Type): Unit = {
    api.logInfo("example handlefanCmd implementation")
    api.logInfo(s"received ${value}")
  }

  def activate(api: Fan_i_Operational_Api): Unit = { }

  def deactivate(api: Fan_i_Operational_Api): Unit = { }

  def finalise(api: Fan_i_Operational_Api): Unit = { }

  def recover(api: Fan_i_Operational_Api): Unit = { }
}
