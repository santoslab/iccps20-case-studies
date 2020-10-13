// #Sireum

package building_control_mixed.BuildingControl

import org.sireum._
import building_control_mixed._

// This file will not be overwritten so is safe to edit
object TempSensor_i_tcp_tempSensor {

  def initialise(api: TempSensor_i_Initialization_Api): Unit = {
    val temp = TempSensorNative.currentTempGet()
    api.setcurrentTemp(temp)
  }

  def timeTriggered(api: TempSensor_i_Operational_Api): Unit = {
    val temp = TempSensorNative.currentTempGet()
    api.setcurrentTemp(temp)
    api.sendtempChanged()
    val degree = Util.toFahrenheit(temp).degrees
    api.logInfo(s"Sensed temperature: $degree F")
  }

  def activate(api: TempSensor_i_Operational_Api): Unit = { }

  def deactivate(api: TempSensor_i_Operational_Api): Unit = { }

  def finalise(api: TempSensor_i_Operational_Api): Unit = { }

  def recover(api: TempSensor_i_Operational_Api): Unit = { }
}

@ext object TempSensorNative {
  def currentTempGet(): Temperature_i = $
}