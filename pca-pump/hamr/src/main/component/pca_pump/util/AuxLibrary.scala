// #Sireum

package pca_pump.util

import org.sireum._
import pca_pump._

@ext object AuxLibrary {
  def getDrugRecord(code : PCA_Types.Drug_Code_imp) : Option[PCA_Types.Drug_Record_imp] = $

  // list of approved clinicians
  def getClinicians(): ISZ[String] = $

  // list of current patients
  def getPatients(): ISZ[String] = $

  // list of all approved prescriptions
  def getPrescriptions(): ISZ[PCA_Types.Prescription_imp] = $

  def getUnicodeCharacter(v: Z) : String = $
}