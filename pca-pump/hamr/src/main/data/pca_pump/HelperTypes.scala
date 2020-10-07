// #Sireum

package pca_pump

import org.sireum._
import pca_pump.PCA_Types.Prescription_imp

@datatype class PrescriptionList(list: ISZ[Prescription_imp])

@datatype class StringList(list: ISZ[String])