// #Sireum

package pca_pump.BLESS_Types

import org.sireum._
import pca_pump._

object Time {
  def empty(): BLESS_Types.Time = {
    return BLESS_Types.Time()
  }
}

@datatype class Time() // type skeleton

object Time_Payload {
  def empty(): Time_Payload = {
    return Time_Payload(BLESS_Types.Time.empty())
  }
}

@datatype class Time_Payload(value: BLESS_Types.Time) extends art.DataContent
