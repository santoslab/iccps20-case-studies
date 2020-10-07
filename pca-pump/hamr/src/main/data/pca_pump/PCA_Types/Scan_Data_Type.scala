// #Sireum

package pca_pump.PCA_Types

import org.sireum._
import pca_pump._

object Scan_Data_Type {
  def empty(): Scan_Data_Type = {
    return Scan_Clinican_Badge("empty")
  }
}

@datatype trait Scan_Data_Type

@datatype class Scan_Clinican_Badge(value: String) extends  Scan_Data_Type

@datatype class Scan_Patient_Wristband(value: String) extends  Scan_Data_Type

@datatype class Scan_Prescription_Vial(patientName: String, drugName: String) extends  Scan_Data_Type

@datatype class Scan_Data_Type_Payload(value: Scan_Data_Type) extends art.DataContent