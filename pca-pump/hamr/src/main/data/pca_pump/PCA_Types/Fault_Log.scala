// #Sireum

package pca_pump.PCA_Types

import org.sireum._
import pca_pump._

// This file was auto-generated.  Do not edit

object Fault_Log {
  def empty(): PCA_Types.Fault_Log = {
    return PCA_Types.Fault_Log(ISZ.create(150, PCA_Types.Fault_Record_imp.empty()))
  }
}

@datatype class Fault_Log(
  value : ISZ[PCA_Types.Fault_Record_imp]) {
  //{  assert (value.size == 150) }
}

object Fault_Log_Payload {
  def empty(): Fault_Log_Payload = {
    return Fault_Log_Payload(PCA_Types.Fault_Log.empty())
  }
}

@datatype class Fault_Log_Payload(value: PCA_Types.Fault_Log) extends art.DataContent
