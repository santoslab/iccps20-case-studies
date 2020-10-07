// #Sireum

package isolette.Devices

import org.sireum._
import isolette._

@record class Heat_Source_impl_Impl (val api : Heat_Source_impl_Bridge.Api) extends Heat_Source_impl {

  // TODO:  Since initialization now guarantees that this is never NONE,
  //   should we represent the internal state as an Isolette_Data_Model.On_Off.Type value?
  var heater_state : Option[Isolette_Data_Model.On_Off.Type] = None[Isolette_Data_Model.On_Off.Type]()

  override def timeTriggered() : Unit = {
    if(api.getheat_control().nonEmpty){
      if(heater_state != api.getheat_control()) {
        heater_state = api.getheat_control()
        api.logInfo(s"Received command: ${heater_state.get}")
        Heat_Source_Native.setState(heater_state.get)
      }
    }
  }
}

@ext object Heat_Source_Native {
  def setState(value: Isolette_Data_Model.On_Off.Type): Unit = $
}
