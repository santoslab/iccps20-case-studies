// #Sireum

package pca_pump.PCA_Types

import org.sireum._
import pca_pump._

// This file was auto-generated.  Do not edit

object Event_Log {
  def empty(): PCA_Types.Event_Log = {
    return PCA_Types.Event_Log(ISZ.create(1500, PCA_Types.Event_Record.empty()))
  }
}

@datatype class Event_Log(
  value : ISZ[PCA_Types.Event_Record]) {
  //{  assert (value.size == 1500) }
}

object Event_Log_Payload {
  def empty(): Event_Log_Payload = {
    return Event_Log_Payload(PCA_Types.Event_Log.empty())
  }
}

@datatype class Event_Log_Payload(value: PCA_Types.Event_Log) extends art.DataContent
