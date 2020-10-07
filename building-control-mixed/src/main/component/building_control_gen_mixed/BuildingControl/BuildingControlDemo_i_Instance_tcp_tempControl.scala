// #Sireum
package building_control_gen_mixed.BuildingControl

import org.sireum._
import building_control_gen_mixed._

object BuildingControlDemo_i_Instance_tcp_tempControl {
  val api : TempControl_i_Bridge.Api = TempControl_i_Bridge.Api(
    id = Arch.BuildingControlDemo_i_Instance_tcp_tempControl.id,
    currentTemp_Id = Arch.BuildingControlDemo_i_Instance_tcp_tempControl.currentTemp.id,
    fanAck_Id = Arch.BuildingControlDemo_i_Instance_tcp_tempControl.fanAck.id,
    setPoint_Id = Arch.BuildingControlDemo_i_Instance_tcp_tempControl.setPoint.id,
    fanCmd_Id = Arch.BuildingControlDemo_i_Instance_tcp_tempControl.fanCmd.id,
    tempChanged_Id = Arch.BuildingControlDemo_i_Instance_tcp_tempControl.tempChanged.id)

  var setPoint: SetPoint_i =
    SetPoint_i(
      Temperature_i(55f, TempUnit.Fahrenheit),
      Temperature_i(100f, TempUnit.Fahrenheit))

  def initialise(): Unit = {}

  def handlefanAck(value : BuildingControl.FanAck.Type): Unit = {
    api.logInfo(s"received fanAck $value")
    if(value == FanAck.Error) {
      // mitigate
      api.logError("Actuation failed!")
    } else {
      api.logInfo("Actuation worked.")
    }
  }

  def handlesetPoint(value : BuildingControl.SetPoint_i): Unit = {
    api.logInfo(s"received setPoint $value")
    setPoint = value
  }

  def handletempChanged(): Unit = {
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

  def activate(): Unit = {}

  def deactivate(): Unit = {}

  def finalise(): Unit = {}

  def recover(): Unit = {}
}

@ext object TempControlNative {
  def fanAckLog(success: FanAck.Type): Unit = $
}