// #Sireum

package pca_pump.ICE_Types

import org.sireum._
import pca_pump._

object Milliliter_Per_Hour {
  def empty(): ICE_Types.Milliliter_Per_Hour = {
    return ICE_Types.Milliliter_Per_Hour()
  }
}

@datatype class Milliliter_Per_Hour() // type skeleton

object Milliliter_Per_Hour_Payload {
  def empty(): Milliliter_Per_Hour_Payload = {
    return Milliliter_Per_Hour_Payload(ICE_Types.Milliliter_Per_Hour.empty())
  }
}

@datatype class Milliliter_Per_Hour_Payload(value: ICE_Types.Milliliter_Per_Hour) extends art.DataContent
