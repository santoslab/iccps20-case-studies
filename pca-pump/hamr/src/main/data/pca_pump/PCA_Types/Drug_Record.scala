// #Sireum

package pca_pump.PCA_Types

import org.sireum._
import pca_pump._

object Drug_Record {
  def empty(): PCA_Types.Drug_Record = {
    return PCA_Types.Drug_Record()
  }
}

@datatype class Drug_Record() // type skeleton

object Drug_Record_Payload {
  def empty(): Drug_Record_Payload = {
    return Drug_Record_Payload(PCA_Types.Drug_Record.empty())
  }
}

@datatype class Drug_Record_Payload(value: PCA_Types.Drug_Record) extends art.DataContent
