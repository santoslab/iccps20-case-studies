// #Sireum

package pca_pump.PCA_Types

import org.sireum._
import pca_pump._

// This file was auto-generated.  Do not edit

@enum object Sound {
  'Silence
  'Beep
}

object Sound_Payload {
  def empty(): Sound_Payload = {
    return Sound_Payload(PCA_Types.Sound.byOrdinal(0).get)
  }
}

@datatype class Sound_Payload(value: PCA_Types.Sound.Type) extends art.DataContent
