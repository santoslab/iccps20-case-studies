// #Sireum
package building_control_gen_mixed.BuildingControl

import org.sireum._
import building_control_gen_mixed._

object BuildingControlDemo_i_Instance_tcp_tempSensor {
  val api : TempSensor_i_Bridge.Api = TempSensor_i_Bridge.Api(
    id = Arch.BuildingControlDemo_i_Instance_tcp_tempSensor.id,
    currentTemp_Id = Arch.BuildingControlDemo_i_Instance_tcp_tempSensor.currentTemp.id,
    tempChanged_Id = Arch.BuildingControlDemo_i_Instance_tcp_tempSensor.tempChanged.id)

  def timeTriggered() : Unit = {
    val temp = TempSensorNative.currentTempGet()
    api.setcurrentTemp(temp)
    api.sendtempChanged()
    val degree = Util.toFahrenheit(temp).degrees
    api.logInfo(s"Sensed temperature: $degree F")
  }

  def activate(): Unit = {}

  def deactivate(): Unit = {}

  def finalise(): Unit = {}

  def initialise(): Unit = {}

  def recover(): Unit = {}
}

@ext object TempSensorNative {
  def currentTempGet(): Temperature_i = $
}
