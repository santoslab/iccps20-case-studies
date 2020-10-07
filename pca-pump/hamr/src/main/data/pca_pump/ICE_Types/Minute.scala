// #Sireum

package pca_pump.ICE_Types

import org.sireum._
import pca_pump._

object Minute {
  def empty(): ICE_Types.Minute = {
    return ICE_Types.Minute()
  }
}

@datatype class Minute() // type skeleton

object Minute_Payload {
  def empty(): Minute_Payload = {
    return Minute_Payload(ICE_Types.Minute.empty())
  }
}

@datatype class Minute_Payload(value: ICE_Types.Minute) extends art.DataContent
