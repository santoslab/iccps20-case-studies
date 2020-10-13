// #Sireum

package isolette.Devices

import org.sireum._
import isolette._

// This file will not be overwritten so is safe to edit
object Heat_Source_impl_heat_source_cpi_heat_controller {

  // TODO:  Since initialization now guarantees that this is never NONE,
  //   should we represent the internal state as an Isolette_Data_Model.On_Off.Type value?
  var heater_state : Option[Isolette_Data_Model.On_Off.Type] = None[Isolette_Data_Model.On_Off.Type]()

  def initialise(api: Heat_Source_impl_Initialization_Api): Unit = { }

  def timeTriggered(api: Heat_Source_impl_Operational_Api): Unit = {
    if(api.getheat_control().nonEmpty){
      if(heater_state != api.getheat_control()) {
        heater_state = api.getheat_control()
        api.logInfo(s"Received command: ${heater_state.get}")
        Heat_Source_Native.setState(heater_state.get)
      }
    }
  }

  def activate(api: Heat_Source_impl_Operational_Api): Unit = { }

  def deactivate(api: Heat_Source_impl_Operational_Api): Unit = { }

  def finalise(api: Heat_Source_impl_Operational_Api): Unit = { }

  def recover(api: Heat_Source_impl_Operational_Api): Unit = { }
}

@ext object Heat_Source_Native {
  def setState(value: Isolette_Data_Model.On_Off.Type): Unit = $
}

