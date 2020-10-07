// #Sireum

package pca_pump.PCA_Security

import org.sireum._
import art._
import pca_pump._

@sig trait Security_Thread_imp_Api {
  def id: Art.BridgeId
  def Clinician_Name_Id : Art.PortId
  def Patient_Name_Id : Art.PortId
  def Prescription_Id : Art.PortId
  def Scan_Data_Id : Art.PortId
  def Authenticate_Clinician_Id : Art.PortId
  def Authenticate_Patient_Id : Art.PortId
  def Authenticate_Prescription_Id : Art.PortId
  def Authentication_fail_Id : Art.PortId
  def Authentication_pass_Id : Art.PortId
  def Security_Fault_Id : Art.PortId

  def setClinician_Name(value : Base_Types.String) : Unit = {
    Art.putValue(Clinician_Name_Id, Base_Types.String_Payload(value))
  }

  def setPatient_Name(value : Base_Types.String) : Unit = {
    Art.putValue(Patient_Name_Id, Base_Types.String_Payload(value))
  }

  def setPrescription(value : PCA_Types.Prescription_imp) : Unit = {
    Art.putValue(Prescription_Id, PCA_Types.Prescription_imp_Payload(value))
  }

  def sendAuthentication_fail() : Unit = {
    Art.putValue(Authentication_fail_Id, art.Empty())
  }

  def sendAuthentication_pass() : Unit = {
    Art.putValue(Authentication_pass_Id, art.Empty())
  }

  def sendSecurity_Fault() : Unit = {
    Art.putValue(Security_Fault_Id, art.Empty())
  }

  def logInfo(msg: String): Unit = {
    Art.logInfo(id, msg)
  }

  def logDebug(msg: String): Unit = {
    Art.logDebug(id, msg)
  }

  def logError(msg: String): Unit = {
    Art.logError(id, msg)
  }
}

@datatype class Security_Thread_imp_Initialization_Api (
  val id: Art.BridgeId,
  val Clinician_Name_Id : Art.PortId,
  val Patient_Name_Id : Art.PortId,
  val Prescription_Id : Art.PortId,
  val Scan_Data_Id : Art.PortId,
  val Authenticate_Clinician_Id : Art.PortId,
  val Authenticate_Patient_Id : Art.PortId,
  val Authenticate_Prescription_Id : Art.PortId,
  val Authentication_fail_Id : Art.PortId,
  val Authentication_pass_Id : Art.PortId,
  val Security_Fault_Id : Art.PortId) extends Security_Thread_imp_Api

@datatype class Security_Thread_imp_Operational_Api (
  val id: Art.BridgeId,
  val Clinician_Name_Id : Art.PortId,
  val Patient_Name_Id : Art.PortId,
  val Prescription_Id : Art.PortId,
  val Scan_Data_Id : Art.PortId,
  val Authenticate_Clinician_Id : Art.PortId,
  val Authenticate_Patient_Id : Art.PortId,
  val Authenticate_Prescription_Id : Art.PortId,
  val Authentication_fail_Id : Art.PortId,
  val Authentication_pass_Id : Art.PortId,
  val Security_Fault_Id : Art.PortId) extends Security_Thread_imp_Api {

  def getScan_Data() : Option[PCA_Types.Scan_Data_Type] = {
    val value : Option[PCA_Types.Scan_Data_Type] = Art.getValue(Scan_Data_Id) match {
      case Some(PCA_Types.Scan_Data_Type_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Scan_Data.  Expecting 'PCA_Types.Scan_Data_Type_Payload' but received ${v}")
        None[PCA_Types.Scan_Data_Type]()
      case _ => None[PCA_Types.Scan_Data_Type]()
    }
    return value
  }

  def getAuthenticate_Clinician() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(Authenticate_Clinician_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Authenticate_Clinician.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  def getAuthenticate_Patient() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(Authenticate_Patient_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Authenticate_Patient.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  def getAuthenticate_Prescription() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(Authenticate_Prescription_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Authenticate_Prescription.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }
}
