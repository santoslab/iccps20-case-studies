// #Sireum

package building_control_mixed.BuildingControl

import org.sireum._
import building_control_mixed._

// This file will not be overwritten so is safe to edit
object TempControl_i_tcp_tempControl {

  var setPoint: SetPoint_i =
    SetPoint_i(
      Temperature_i(55f, TempUnit.Fahrenheit),
      Temperature_i(100f, TempUnit.Fahrenheit))

  def initialise(api: TempControl_i_Initialization_Api): Unit = {
    api.sendfanCmd(FanCmd.Off)
  }

  def handlefanAck(api: TempControl_i_Operational_Api, value : BuildingControl.FanAck.Type): Unit = {
    api.logInfo(s"received fanAck $value")
    if(value == FanAck.Error) {
      // mitigate
      api.logError("Actuation failed!")
    } else {
      api.logInfo("Actuation worked.")
    }
  }

  def handlesetPoint(api: TempControl_i_Operational_Api, value : BuildingControl.SetPoint_i): Unit = {
    api.logInfo(s"received setPoint $value")
    setPoint = value
  }

  def handletempChanged(api: TempControl_i_Operational_Api): Unit = {
    if(api.getcurrentTemp().isEmpty){
      api.logInfo("no life cycle manager for seL4 yet so need to guard against empty data ports")
      return
    }

    val tempInF = Util.toFahrenheit(api.getcurrentTemp().get)
    val setPointLowInF = Util.toFahrenheit(setPoint.low)
    val setPointHighInF = Util.toFahrenheit(setPoint.high)
    val cmdOpt: Option[FanCmd.Type] =
      if (tempInF.degrees > setPointHighInF.degrees) Some(FanCmd.On)
      else if (tempInF.degrees < setPointLowInF.degrees) Some(FanCmd.Off)
      else None[FanCmd.Type]()
    cmdOpt match {
      case Some(cmd) =>
        api.sendfanCmd(cmd)
        api.logInfo(s"Sent fan command: $cmd")
      case _ =>
        api.logInfo(s"Temperature ok: ${tempInF.degrees} F")
    }
  }

  def activate(api: TempControl_i_Operational_Api): Unit = { }

  def deactivate(api: TempControl_i_Operational_Api): Unit = { }

  def finalise(api: TempControl_i_Operational_Api): Unit = { }

  def recover(api: TempControl_i_Operational_Api): Unit = { }
}
