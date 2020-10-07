// #Sireum

package pca_pump.PCA_Types

import org.sireum._
import pca_pump._

object Fault_Record {
  def empty(): PCA_Types.Fault_Record = {
    return PCA_Types.Fault_Record()
  }
}

@datatype class Fault_Record() // type skeleton

object Fault_Record_Payload {
  def empty(): Fault_Record_Payload = {
    return Fault_Record_Payload(PCA_Types.Fault_Record.empty())
  }
}

@datatype class Fault_Record_Payload(value: PCA_Types.Fault_Record) extends art.DataContent
