// #Sireum

package building_control_gen_mixed.BuildingControl

import org.sireum._
import building_control_gen_mixed._

// This file will not be overwritten so is safe to edit
@record class TempControl_i_Impl (val api : TempControl_i_Bridge.Api) extends TempControl_i {

  override def initialise(): Unit = {
    // example api usage

    api.logInfo("Example info logging")
    api.logDebug("Example debug logging")
    api.logError("Example error logging")

    val apiUsage_currentTemp: Option[BuildingControl.Temperature_i] = api.getcurrentTemp()
    val apiUsage_fanAck: Option[BuildingControl.FanAck.Type] = api.getfanAck()
    val apiUsage_setPoint: Option[BuildingControl.SetPoint_i] = api.getsetPoint()
    api.sendfanCmd(BuildingControl.FanCmd.byOrdinal(0).get)
    val apiUsage_tempChanged: Option[art.Empty] = api.gettempChanged()
  }

  override def handlefanAck(value : BuildingControl.FanAck.Type): Unit = {
    api.logInfo("example handlefanAck implementation")
    api.logInfo(s"received ${value}")
  }

  override def handlesetPoint(value : BuildingControl.SetPoint_i): Unit = {
    api.logInfo("example handlesetPoint implementation")
    api.logInfo(s"received ${value}")
  }

  override def handletempChanged(): Unit = {
    api.logInfo("example handletempChanged implementation")
    api.logInfo("received tempChanged")
  }

  override def activate(): Unit = {
    // example override of activate
  }

  override def deactivate(): Unit = {
    // example override of deactivate
  }

  override def finalise(): Unit = {
    // example override of finalise
  }

  override def recover(): Unit = {
    // example override of recover
  }
}
