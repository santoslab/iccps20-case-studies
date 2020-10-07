// #Sireum

package pca_pump.PCA_Types

import org.sireum._
import pca_pump._

object Scan_Data_Type {
  def empty(): PCA_Types.Scan_Data_Type = {
    return PCA_Types.Scan_Data_Type()
  }
}

@datatype class Scan_Data_Type() // type skeleton

object Scan_Data_Type_Payload {
  def empty(): Scan_Data_Type_Payload = {
    return Scan_Data_Type_Payload(PCA_Types.Scan_Data_Type.empty())
  }
}

@datatype class Scan_Data_Type_Payload(value: PCA_Types.Scan_Data_Type) extends art.DataContent
