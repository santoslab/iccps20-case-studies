// #Sireum

package pca_pump.Physical_Types

import org.sireum._
import pca_pump._

object Current {
  def empty(): Physical_Types.Current = {
    return Physical_Types.Current()
  }
}

@datatype class Current() // type skeleton

object Current_Payload {
  def empty(): Current_Payload = {
    return Current_Payload(Physical_Types.Current.empty())
  }
}

@datatype class Current_Payload(value: Physical_Types.Current) extends art.DataContent
