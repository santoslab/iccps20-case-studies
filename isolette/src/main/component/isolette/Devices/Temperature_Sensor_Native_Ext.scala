package isolette.Devices

import org.sireum._
import isolette._

object Temperature_Sensor_Native_Ext {

  var lastTemperature = Isolette_Data_Model.Temp_impl(InitialValues.DEFAULT_CURRENT_TEMPERATURE)
  var rand = new java.util.Random

  def getCurrentTemp(): Isolette_Data_Model.Temp_impl = {
    lastTemperature = if (rand.nextBoolean()) {
      val delta =
        F32((rand.nextGaussian() * 3).abs.min(2).toFloat *
          (if (Heat_Source_Native_Ext.isOn) 1 else -1))
      lastTemperature(lastTemperature.value + delta)
    } else lastTemperature
    lastTemperature
  }

}
