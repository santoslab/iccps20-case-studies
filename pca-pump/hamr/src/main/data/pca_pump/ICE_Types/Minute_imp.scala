// #Sireum

package pca_pump.ICE_Types

import org.sireum._
import pca_pump._

// This file was auto-generated.  Do not edit

object Minute_imp {
  def empty(): ICE_Types.Minute_imp = {
    return ICE_Types.Minute_imp(Base_Types.Unsigned_16_empty())
  }
}

@datatype class Minute_imp(
  value : Base_Types.Unsigned_16) {
}

object Minute_imp_Payload {
  def empty(): Minute_imp_Payload = {
    return Minute_imp_Payload(ICE_Types.Minute_imp.empty())
  }
}

@datatype class Minute_imp_Payload(value: ICE_Types.Minute_imp) extends art.DataContent
