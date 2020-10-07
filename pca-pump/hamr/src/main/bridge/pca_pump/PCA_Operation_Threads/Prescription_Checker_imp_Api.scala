// #Sireum

package pca_pump.PCA_Operation_Threads

import org.sireum._
import art._
import pca_pump._

@sig trait Prescription_Checker_imp_Api {
  def id: Art.BridgeId
  def Prescription_Id : Art.PortId
  def VTBI_Id : Art.PortId
  def Square_Bolus_Rate_Id : Art.PortId
  def Patient_Bolus_Rate_Id : Art.PortId
  def Basal_Rate_Id : Art.PortId
  def Minimum_Time_Between_Bolus_Id : Art.PortId
  def Max_Drug_Per_Hour_Id : Art.PortId
  def Get_Drug_Record_Id : Art.PortId
  def The_Drug_Record_Id : Art.PortId
  def Check_Rx_Id : Art.PortId
  def Rx_Okay_Id : Art.PortId
  def Drug_Not_In_Library_Id : Art.PortId
  def Confirm_Soft_Limit_Exception_Id : Art.PortId
  def Reject_Soft_Limit_Exception_Id : Art.PortId
  def Soft_Limit_Warning_Id : Art.PortId
  def Hard_Limit_Violated_Id : Art.PortId

  def setVTBI(value : PCA_Types.Drug_Volume_imp) : Unit = {
    Art.putValue(VTBI_Id, PCA_Types.Drug_Volume_imp_Payload(value))
  }

  def setSquare_Bolus_Rate(value : PCA_Types.Flow_Rate_imp) : Unit = {
    Art.putValue(Square_Bolus_Rate_Id, PCA_Types.Flow_Rate_imp_Payload(value))
  }

  def setPatient_Bolus_Rate(value : PCA_Types.Flow_Rate_imp) : Unit = {
    Art.putValue(Patient_Bolus_Rate_Id, PCA_Types.Flow_Rate_imp_Payload(value))
  }

  def setBasal_Rate(value : PCA_Types.Flow_Rate_imp) : Unit = {
    Art.putValue(Basal_Rate_Id, PCA_Types.Flow_Rate_imp_Payload(value))
  }

  def setMinimum_Time_Between_Bolus(value : ICE_Types.Minute_imp) : Unit = {
    Art.putValue(Minimum_Time_Between_Bolus_Id, ICE_Types.Minute_imp_Payload(value))
  }

  def setMax_Drug_Per_Hour(value : PCA_Types.Drug_Volume_imp) : Unit = {
    Art.putValue(Max_Drug_Per_Hour_Id, PCA_Types.Drug_Volume_imp_Payload(value))
  }

  def sendGet_Drug_Record(value : PCA_Types.Drug_Code_imp) : Unit = {
    Art.putValue(Get_Drug_Record_Id, PCA_Types.Drug_Code_imp_Payload(value))
  }

  def sendRx_Okay() : Unit = {
    Art.putValue(Rx_Okay_Id, art.Empty())
  }

  def sendSoft_Limit_Warning() : Unit = {
    Art.putValue(Soft_Limit_Warning_Id, art.Empty())
  }

  def sendHard_Limit_Violated() : Unit = {
    Art.putValue(Hard_Limit_Violated_Id, art.Empty())
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

@datatype class Prescription_Checker_imp_Initialization_Api (
  val id: Art.BridgeId,
  val Prescription_Id : Art.PortId,
  val VTBI_Id : Art.PortId,
  val Square_Bolus_Rate_Id : Art.PortId,
  val Patient_Bolus_Rate_Id : Art.PortId,
  val Basal_Rate_Id : Art.PortId,
  val Minimum_Time_Between_Bolus_Id : Art.PortId,
  val Max_Drug_Per_Hour_Id : Art.PortId,
  val Get_Drug_Record_Id : Art.PortId,
  val The_Drug_Record_Id : Art.PortId,
  val Check_Rx_Id : Art.PortId,
  val Rx_Okay_Id : Art.PortId,
  val Drug_Not_In_Library_Id : Art.PortId,
  val Confirm_Soft_Limit_Exception_Id : Art.PortId,
  val Reject_Soft_Limit_Exception_Id : Art.PortId,
  val Soft_Limit_Warning_Id : Art.PortId,
  val Hard_Limit_Violated_Id : Art.PortId) extends Prescription_Checker_imp_Api

@datatype class Prescription_Checker_imp_Operational_Api (
  val id: Art.BridgeId,
  val Prescription_Id : Art.PortId,
  val VTBI_Id : Art.PortId,
  val Square_Bolus_Rate_Id : Art.PortId,
  val Patient_Bolus_Rate_Id : Art.PortId,
  val Basal_Rate_Id : Art.PortId,
  val Minimum_Time_Between_Bolus_Id : Art.PortId,
  val Max_Drug_Per_Hour_Id : Art.PortId,
  val Get_Drug_Record_Id : Art.PortId,
  val The_Drug_Record_Id : Art.PortId,
  val Check_Rx_Id : Art.PortId,
  val Rx_Okay_Id : Art.PortId,
  val Drug_Not_In_Library_Id : Art.PortId,
  val Confirm_Soft_Limit_Exception_Id : Art.PortId,
  val Reject_Soft_Limit_Exception_Id : Art.PortId,
  val Soft_Limit_Warning_Id : Art.PortId,
  val Hard_Limit_Violated_Id : Art.PortId) extends Prescription_Checker_imp_Api {

  def getPrescription() : Option[PCA_Types.Prescription_imp] = {
    val value : Option[PCA_Types.Prescription_imp] = Art.getValue(Prescription_Id) match {
      case Some(PCA_Types.Prescription_imp_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Prescription.  Expecting 'PCA_Types.Prescription_imp_Payload' but received ${v}")
        None[PCA_Types.Prescription_imp]()
      case _ => None[PCA_Types.Prescription_imp]()
    }
    return value
  }

  def getThe_Drug_Record() : Option[PCA_Types.Drug_Record_imp] = {
    val value : Option[PCA_Types.Drug_Record_imp] = Art.getValue(The_Drug_Record_Id) match {
      case Some(PCA_Types.Drug_Record_imp_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port The_Drug_Record.  Expecting 'PCA_Types.Drug_Record_imp_Payload' but received ${v}")
        None[PCA_Types.Drug_Record_imp]()
      case _ => None[PCA_Types.Drug_Record_imp]()
    }
    return value
  }

  def getCheck_Rx() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(Check_Rx_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Check_Rx.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  def getDrug_Not_In_Library() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(Drug_Not_In_Library_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Drug_Not_In_Library.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  def getConfirm_Soft_Limit_Exception() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(Confirm_Soft_Limit_Exception_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Confirm_Soft_Limit_Exception.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  def getReject_Soft_Limit_Exception() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(Reject_Soft_Limit_Exception_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Reject_Soft_Limit_Exception.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }
}
