// #Sireum

package pca_pump.Physical_Types

import org.sireum._
import pca_pump._

object Voltage {
  def empty(): Physical_Types.Voltage = {
    return Physical_Types.Voltage()
  }
}

@datatype class Voltage() // type skeleton

object Voltage_Payload {
  def empty(): Voltage_Payload = {
    return Voltage_Payload(Physical_Types.Voltage.empty())
  }
}

@datatype class Voltage_Payload(value: Physical_Types.Voltage) extends art.DataContent
