// #Sireum

package b.TemperatureControl

import org.sireum._
import b._

// This file will not be overwritten so is safe to edit
object TempControl_i_tcp_tempControl {

  def initialise(api: TempControl_i_Initialization_Api): Unit = {
    // example api usage

    api.logInfo("Example info logging")
    api.logDebug("Example debug logging")
    api.logError("Example error logging")

    api.sendfanCmd(TemperatureControl.FanCmd.byOrdinal(0).get)
  }

  def handlefanAck(api: TempControl_i_Operational_Api, value : TemperatureControl.FanAck.Type): Unit = {
    api.logInfo("example handlefanAck implementation")
    api.logInfo(s"received ${value}")
  }

  def handlesetPoint(api: TempControl_i_Operational_Api, value : TemperatureControl.SetPoint_i): Unit = {
    api.logInfo("example handlesetPoint implementation")
    api.logInfo(s"received ${value}")
  }

  def handletempChanged(api: TempControl_i_Operational_Api): Unit = {
    api.logInfo("example handletempChanged implementation")
    api.logInfo("received tempChanged")
  }

  def activate(api: TempControl_i_Operational_Api): Unit = { }

  def deactivate(api: TempControl_i_Operational_Api): Unit = { }

  def finalise(api: TempControl_i_Operational_Api): Unit = { }

  def recover(api: TempControl_i_Operational_Api): Unit = { }
}
