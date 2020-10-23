// #Sireum

package b

import org.sireum._
import art._
import art.PortMode._
import art.DispatchPropertyProtocol._

// This file was auto-generated.  Do not edit

object Arch {
  val TempControlSystem_i_Instance_p_tempSensor : b.TemperatureControl.TempSensor_i_p_tempSensor_Bridge = {
    val currentTemp = Port[TemperatureControl.Temperature_i] (id = 0, name = "TempControlSystem_i_Instance_p_tempSensor_currentTemp", mode = DataOut)
    val tempChanged = Port[art.Empty] (id = 1, name = "TempControlSystem_i_Instance_p_tempSensor_tempChanged", mode = EventOut)

    b.TemperatureControl.TempSensor_i_p_tempSensor_Bridge(
      id = 0,
      name = "TempControlSystem_i_Instance_p_tempSensor",
      dispatchProtocol = Periodic(period = 1000),
      dispatchTriggers = None(),

      currentTemp = currentTemp,
      tempChanged = tempChanged
    )
  }
  val TempControlSystem_i_Instance_p_tempControl : b.TemperatureControl.TempControl_i_p_tempControl_Bridge = {
    val currentTemp = Port[TemperatureControl.Temperature_i] (id = 2, name = "TempControlSystem_i_Instance_p_tempControl_currentTemp", mode = DataIn)
    val fanAck = Port[TemperatureControl.FanAck.Type] (id = 3, name = "TempControlSystem_i_Instance_p_tempControl_fanAck", mode = EventIn)
    val setPoint = Port[TemperatureControl.SetPoint_i] (id = 4, name = "TempControlSystem_i_Instance_p_tempControl_setPoint", mode = EventIn)
    val fanCmd = Port[TemperatureControl.FanCmd.Type] (id = 5, name = "TempControlSystem_i_Instance_p_tempControl_fanCmd", mode = EventOut)
    val tempChanged = Port[art.Empty] (id = 6, name = "TempControlSystem_i_Instance_p_tempControl_tempChanged", mode = EventIn)

    b.TemperatureControl.TempControl_i_p_tempControl_Bridge(
      id = 1,
      name = "TempControlSystem_i_Instance_p_tempControl",
      dispatchProtocol = Sporadic(min = 1),
      dispatchTriggers = None(),

      currentTemp = currentTemp,
      fanAck = fanAck,
      setPoint = setPoint,
      fanCmd = fanCmd,
      tempChanged = tempChanged
    )
  }
  val TempControlSystem_i_Instance_p_fan : b.TemperatureControl.Fan_i_p_fan_Bridge = {
    val fanCmd = Port[TemperatureControl.FanCmd.Type] (id = 7, name = "TempControlSystem_i_Instance_p_fan_fanCmd", mode = EventIn)
    val fanAck = Port[TemperatureControl.FanAck.Type] (id = 8, name = "TempControlSystem_i_Instance_p_fan_fanAck", mode = EventOut)

    b.TemperatureControl.Fan_i_p_fan_Bridge(
      id = 2,
      name = "TempControlSystem_i_Instance_p_fan",
      dispatchProtocol = Sporadic(min = 1),
      dispatchTriggers = None(),

      fanCmd = fanCmd,
      fanAck = fanAck
    )
  }

  val ad : ArchitectureDescription = {

    ArchitectureDescription(
      components = MSZ (TempControlSystem_i_Instance_p_tempSensor, TempControlSystem_i_Instance_p_tempControl, TempControlSystem_i_Instance_p_fan),

      connections = ISZ (Connection(from = TempControlSystem_i_Instance_p_tempSensor.currentTemp, to = TempControlSystem_i_Instance_p_tempControl.currentTemp),
                         Connection(from = TempControlSystem_i_Instance_p_tempSensor.tempChanged, to = TempControlSystem_i_Instance_p_tempControl.tempChanged),
                         Connection(from = TempControlSystem_i_Instance_p_tempControl.fanCmd, to = TempControlSystem_i_Instance_p_fan.fanCmd),
                         Connection(from = TempControlSystem_i_Instance_p_fan.fanAck, to = TempControlSystem_i_Instance_p_tempControl.fanAck))
    )
  }
}