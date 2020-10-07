// #Sireum

package pca_pump.Physical_Types

import org.sireum._
import pca_pump._

// This file was auto-generated.  Do not edit

object Voltage_imp {
  def empty(): Physical_Types.Voltage_imp = {
    return Physical_Types.Voltage_imp(Base_Types.Integer_16_empty())
  }
}

@datatype class Voltage_imp(
  value : Base_Types.Integer_16) {
}

object Voltage_imp_Payload {
  def empty(): Voltage_imp_Payload = {
    return Voltage_imp_Payload(Physical_Types.Voltage_imp.empty())
  }
}

@datatype class Voltage_imp_Payload(value: Physical_Types.Voltage_imp) extends art.DataContent
