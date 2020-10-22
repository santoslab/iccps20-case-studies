// #Sireum

package b.TemperatureControl

import org.sireum._

object Util {
  @pure def toFahrenheit(value: Temperature_i) : Temperature_i = {
    if(value.unit == TempUnit.Fahrenheit) {
      return value
    } else if (value.unit == TempUnit.Celsius) {
      return Temperature_i(value.degrees * 9f / 5f + 32f, TempUnit.Fahrenheit)
    } else {
      return Temperature_i(value.degrees * 9f / 5f - 459.67f, TempUnit.Fahrenheit)
    }
  }
}