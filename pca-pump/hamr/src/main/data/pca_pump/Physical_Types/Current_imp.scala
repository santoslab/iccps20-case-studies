// #Sireum

package pca_pump.Physical_Types

import org.sireum._
import pca_pump._

// This file was auto-generated.  Do not edit

object Current_imp {
  def empty(): Physical_Types.Current_imp = {
    return Physical_Types.Current_imp(Base_Types.Integer_16_empty())
  }
}

@datatype class Current_imp(
  value : Base_Types.Integer_16) {
}

object Current_imp_Payload {
  def empty(): Current_imp_Payload = {
    return Current_imp_Payload(Physical_Types.Current_imp.empty())
  }
}

@datatype class Current_imp_Payload(value: Physical_Types.Current_imp) extends art.DataContent
