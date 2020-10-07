// #Sireum

package pca_pump.PCA_Types

import org.sireum._
import pca_pump._

object Event_Record {
  def empty(): PCA_Types.Event_Record = {
    return PCA_Types.Event_Record()
  }
}

@datatype class Event_Record() // type skeleton

object Event_Record_Payload {
  def empty(): Event_Record_Payload = {
    return Event_Record_Payload(PCA_Types.Event_Record.empty())
  }
}

@datatype class Event_Record_Payload(value: PCA_Types.Event_Record) extends art.DataContent
