// #Sireum

package isolette.Devices

import org.sireum._
import isolette._

@record class Temperature_Sensor_impl_Impl (val api : Temperature_Sensor_impl_Bridge.Api) extends Temperature_Sensor_impl {

  override def initialise() : Unit = {
    val defaultTemp: Isolette_Data_Model.Temp_impl = Isolette_Data_Model.Temp_impl(InitialValues.DEFAULT_CURRENT_TEMPERATURE)
    val defaultTempWstatus = Isolette_Data_Model.TempWstatus_impl(defaultTemp.value, Isolette_Data_Model.ValueStatus.Valid)
    api.setcurrent_tempWstatus(defaultTempWstatus)
  }

  override def timeTriggered() : Unit = {
    val t = api.getair() // simulating this via extension

    val temp : Isolette_Data_Model.Temp_impl = Temperature_Sensor_Native.getCurrentTemp()
    // TODO:
    //  Status value (Valid, Invalid) of sensed temperature.
    //  Determine what meaningful approach should followed to choose a status value.
    //  As of now, the status value is always set to "Valid"
    val current_tempWstatus = Isolette_Data_Model.TempWstatus_impl(temp.value, Isolette_Data_Model.ValueStatus.Valid)
    api.setcurrent_tempWstatus(current_tempWstatus)
    api.logInfo(s"Sensed temperature: $temp")
  }
}

@ext object Temperature_Sensor_Native {
  def getCurrentTemp(): Isolette_Data_Model.Temp_impl = $
}
