// #Sireum

package isolette.Isolette_Data_Model

import org.sireum._
import isolette._

// This file was auto-generated.  Do not edit

object PhysicalTemp_impl {
  def empty(): Isolette_Data_Model.PhysicalTemp_impl = {
    return Isolette_Data_Model.PhysicalTemp_impl(Base_Types.Float_32_empty())
  }
}

@datatype class PhysicalTemp_impl(
  value : Base_Types.Float_32) {
}

object PhysicalTemp_impl_Payload {
  def empty(): PhysicalTemp_impl_Payload = {
    return PhysicalTemp_impl_Payload(Isolette_Data_Model.PhysicalTemp_impl.empty())
  }
}

@datatype class PhysicalTemp_impl_Payload(value: Isolette_Data_Model.PhysicalTemp_impl) extends art.DataContent
