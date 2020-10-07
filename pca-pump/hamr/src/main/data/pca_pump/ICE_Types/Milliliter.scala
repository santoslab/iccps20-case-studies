// #Sireum

package pca_pump.ICE_Types

import org.sireum._
import pca_pump._

object Milliliter {
  def empty(): ICE_Types.Milliliter = {
    return ICE_Types.Milliliter()
  }
}

@datatype class Milliliter() // type skeleton

object Milliliter_Payload {
  def empty(): Milliliter_Payload = {
    return Milliliter_Payload(ICE_Types.Milliliter.empty())
  }
}

@datatype class Milliliter_Payload(value: ICE_Types.Milliliter) extends art.DataContent
