package pca_pump.util

import pca_pump._
import org.sireum.HashMap
import org.sireum.ISZ
import org.sireum.String
import org.sireum.Z

object AuxLibrary_Ext {
  var drugLibrary: HashMap[PCA_Types.Drug_Code_imp, PCA_Types.Drug_Record_imp] = {
    val _drugLibrary = scala.io.Source.fromInputStream(getClass.getResourceAsStream("drug_library.json")).mkString
    val drugLibrary = JSON.toPCA_TypesDrug_Library(_drugLibrary).left

    var m = HashMap.empty[PCA_Types.Drug_Code_imp, PCA_Types.Drug_Record_imp]
    drugLibrary.value.foreach(record => m = m + (record.code, record))
    m
  }

  def getDrugRecord(code: PCA_Types.Drug_Code_imp): org.sireum.Option[PCA_Types.Drug_Record_imp] = {
    return drugLibrary.get(code)
  }

  def getClinicians(): ISZ[String] = {
    val _clinicians = scala.io.Source.fromInputStream(getClass.getResourceAsStream("clinicians.json")).mkString
    return JSON.toStringList(_clinicians).left.list
  }

  def getPatients(): ISZ[String] = {
    val _patients = scala.io.Source.fromInputStream(getClass.getResourceAsStream("patients.json")).mkString
    return JSON.toStringList(_patients).left.list
  }

  def getPrescriptions(): ISZ[PCA_Types.Prescription_imp] = {
    val _prescriptions = scala.io.Source.fromInputStream(getClass.getResourceAsStream("prescriptions.json")).mkString
    return JSON.toPrescriptionList(_prescriptions).left.list
  }

  def getUnicodeCharacter(v: Z) : String = {
    return new Predef.String(Character.toChars(v.toInt))
  }
}