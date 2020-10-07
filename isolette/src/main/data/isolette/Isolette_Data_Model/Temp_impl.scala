// #Sireum

package isolette.Isolette_Data_Model

import org.sireum._
import isolette._

// This file was auto-generated.  Do not edit

object Temp_impl {
  def empty(): Isolette_Data_Model.Temp_impl = {
    return Isolette_Data_Model.Temp_impl(Base_Types.Float_32_empty())
  }
}

@datatype class Temp_impl(
  value : Base_Types.Float_32) {
}

object Temp_impl_Payload {
  def empty(): Temp_impl_Payload = {
    return Temp_impl_Payload(Isolette_Data_Model.Temp_impl.empty())
  }
}

@datatype class Temp_impl_Payload(value: Isolette_Data_Model.Temp_impl) extends art.DataContent
