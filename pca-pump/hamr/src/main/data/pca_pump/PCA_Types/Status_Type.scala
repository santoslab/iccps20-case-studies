// #Sireum

package pca_pump.PCA_Types

import org.sireum._
import pca_pump._

// This file was auto-generated.  Do not edit

@enum object Status_Type {
  'Stopped
  'Priming
  'Paused
  'Bolus
  'Basal
  'KVO
  'Square_Bolus
}

object Status_Type_Payload {
  def empty(): Status_Type_Payload = {
    return Status_Type_Payload(PCA_Types.Status_Type.byOrdinal(0).get)
  }
}

@datatype class Status_Type_Payload(value: PCA_Types.Status_Type.Type) extends art.DataContent
