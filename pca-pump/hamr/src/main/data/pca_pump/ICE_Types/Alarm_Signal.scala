// #Sireum

package pca_pump.ICE_Types

import org.sireum._
import pca_pump._

// This file was auto-generated.  Do not edit

@enum object Alarm_Signal {
  'On
  'Alarm_Off
  'Alarm_Paused
  'Audio_Off
  'Audio_Paused
}

object Alarm_Signal_Payload {
  def empty(): Alarm_Signal_Payload = {
    return Alarm_Signal_Payload(ICE_Types.Alarm_Signal.byOrdinal(0).get)
  }
}

@datatype class Alarm_Signal_Payload(value: ICE_Types.Alarm_Signal.Type) extends art.DataContent
