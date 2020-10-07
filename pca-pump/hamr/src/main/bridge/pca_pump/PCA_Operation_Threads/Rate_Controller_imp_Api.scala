// #Sireum

package pca_pump.PCA_Operation_Threads

import org.sireum._
import art._
import pca_pump._

@sig trait Rate_Controller_imp_Api {
  def id: Art.BridgeId
  def Infusion_Flow_Rate_Id : Art.PortId
  def Square_Bolus_Rate_Id : Art.PortId
  def Patient_Bolus_Rate_Id : Art.PortId
  def Basal_Rate_Id : Art.PortId
  def VTBI_Id : Art.PortId
  def Door_Open_Id : Art.PortId
  def System_Status_Id : Art.PortId
  def Alarm_Id : Art.PortId
  def Warning_Id : Art.PortId
  def CP_Bolus_Duration_Id : Art.PortId
  def Begin_Infusion_Id : Art.PortId
  def Begin_Priming_Id : Art.PortId
  def End_Priming_Id : Art.PortId
  def Halt_Infusion_Id : Art.PortId
  def HW_Detected_Failure_Id : Art.PortId
  def Stop_Pump_Completely_Id : Art.PortId
  def Pump_At_KVO_Rate_Id : Art.PortId
  def Patient_Request_Not_Too_Soon_Id : Art.PortId
  def Pause_Infusion_Id : Art.PortId
  def Resume_Infusion_Id : Art.PortId
  def CP_Clinician_Request_Bolus_Id : Art.PortId
  def Near_Max_Drug_Per_Hour_Id : Art.PortId
  def Over_Max_Drug_Per_Hour_Id : Art.PortId
  def ICE_Stop_Pump_Id : Art.PortId

  def setInfusion_Flow_Rate(value : PCA_Types.Flow_Rate_imp) : Unit = {
    Art.putValue(Infusion_Flow_Rate_Id, PCA_Types.Flow_Rate_imp_Payload(value))
  }

  def sendSystem_Status(value : PCA_Types.Status_Type.Type) : Unit = {
    Art.putValue(System_Status_Id, PCA_Types.Status_Type_Payload(value))
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

@datatype class Rate_Controller_imp_Initialization_Api (
  val id: Art.BridgeId,
  val Infusion_Flow_Rate_Id : Art.PortId,
  val Square_Bolus_Rate_Id : Art.PortId,
  val Patient_Bolus_Rate_Id : Art.PortId,
  val Basal_Rate_Id : Art.PortId,
  val VTBI_Id : Art.PortId,
  val Door_Open_Id : Art.PortId,
  val System_Status_Id : Art.PortId,
  val Alarm_Id : Art.PortId,
  val Warning_Id : Art.PortId,
  val CP_Bolus_Duration_Id : Art.PortId,
  val Begin_Infusion_Id : Art.PortId,
  val Begin_Priming_Id : Art.PortId,
  val End_Priming_Id : Art.PortId,
  val Halt_Infusion_Id : Art.PortId,
  val HW_Detected_Failure_Id : Art.PortId,
  val Stop_Pump_Completely_Id : Art.PortId,
  val Pump_At_KVO_Rate_Id : Art.PortId,
  val Patient_Request_Not_Too_Soon_Id : Art.PortId,
  val Pause_Infusion_Id : Art.PortId,
  val Resume_Infusion_Id : Art.PortId,
  val CP_Clinician_Request_Bolus_Id : Art.PortId,
  val Near_Max_Drug_Per_Hour_Id : Art.PortId,
  val Over_Max_Drug_Per_Hour_Id : Art.PortId,
  val ICE_Stop_Pump_Id : Art.PortId) extends Rate_Controller_imp_Api

@datatype class Rate_Controller_imp_Operational_Api (
  val id: Art.BridgeId,
  val Infusion_Flow_Rate_Id : Art.PortId,
  val Square_Bolus_Rate_Id : Art.PortId,
  val Patient_Bolus_Rate_Id : Art.PortId,
  val Basal_Rate_Id : Art.PortId,
  val VTBI_Id : Art.PortId,
  val Door_Open_Id : Art.PortId,
  val System_Status_Id : Art.PortId,
  val Alarm_Id : Art.PortId,
  val Warning_Id : Art.PortId,
  val CP_Bolus_Duration_Id : Art.PortId,
  val Begin_Infusion_Id : Art.PortId,
  val Begin_Priming_Id : Art.PortId,
  val End_Priming_Id : Art.PortId,
  val Halt_Infusion_Id : Art.PortId,
  val HW_Detected_Failure_Id : Art.PortId,
  val Stop_Pump_Completely_Id : Art.PortId,
  val Pump_At_KVO_Rate_Id : Art.PortId,
  val Patient_Request_Not_Too_Soon_Id : Art.PortId,
  val Pause_Infusion_Id : Art.PortId,
  val Resume_Infusion_Id : Art.PortId,
  val CP_Clinician_Request_Bolus_Id : Art.PortId,
  val Near_Max_Drug_Per_Hour_Id : Art.PortId,
  val Over_Max_Drug_Per_Hour_Id : Art.PortId,
  val ICE_Stop_Pump_Id : Art.PortId) extends Rate_Controller_imp_Api {

  def getSquare_Bolus_Rate() : Option[PCA_Types.Flow_Rate_imp] = {
    val value : Option[PCA_Types.Flow_Rate_imp] = Art.getValue(Square_Bolus_Rate_Id) match {
      case Some(PCA_Types.Flow_Rate_imp_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Square_Bolus_Rate.  Expecting 'PCA_Types.Flow_Rate_imp_Payload' but received ${v}")
        None[PCA_Types.Flow_Rate_imp]()
      case _ => None[PCA_Types.Flow_Rate_imp]()
    }
    return value
  }

  def getPatient_Bolus_Rate() : Option[PCA_Types.Flow_Rate_imp] = {
    val value : Option[PCA_Types.Flow_Rate_imp] = Art.getValue(Patient_Bolus_Rate_Id) match {
      case Some(PCA_Types.Flow_Rate_imp_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Patient_Bolus_Rate.  Expecting 'PCA_Types.Flow_Rate_imp_Payload' but received ${v}")
        None[PCA_Types.Flow_Rate_imp]()
      case _ => None[PCA_Types.Flow_Rate_imp]()
    }
    return value
  }

  def getBasal_Rate() : Option[PCA_Types.Flow_Rate_imp] = {
    val value : Option[PCA_Types.Flow_Rate_imp] = Art.getValue(Basal_Rate_Id) match {
      case Some(PCA_Types.Flow_Rate_imp_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Basal_Rate.  Expecting 'PCA_Types.Flow_Rate_imp_Payload' but received ${v}")
        None[PCA_Types.Flow_Rate_imp]()
      case _ => None[PCA_Types.Flow_Rate_imp]()
    }
    return value
  }

  def getVTBI() : Option[PCA_Types.Drug_Volume_imp] = {
    val value : Option[PCA_Types.Drug_Volume_imp] = Art.getValue(VTBI_Id) match {
      case Some(PCA_Types.Drug_Volume_imp_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port VTBI.  Expecting 'PCA_Types.Drug_Volume_imp_Payload' but received ${v}")
        None[PCA_Types.Drug_Volume_imp]()
      case _ => None[PCA_Types.Drug_Volume_imp]()
    }
    return value
  }

  def getDoor_Open() : Option[Base_Types.Boolean] = {
    val value : Option[Base_Types.Boolean] = Art.getValue(Door_Open_Id) match {
      case Some(Base_Types.Boolean_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Door_Open.  Expecting 'Base_Types.Boolean_Payload' but received ${v}")
        None[Base_Types.Boolean]()
      case _ => None[Base_Types.Boolean]()
    }
    return value
  }

  def getAlarm() : Option[PCA_Types.Alarm_Type.Type] = {
    val value : Option[PCA_Types.Alarm_Type.Type] = Art.getValue(Alarm_Id) match {
      case Some(PCA_Types.Alarm_Type_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Alarm.  Expecting 'PCA_Types.Alarm_Type_Payload' but received ${v}")
        None[PCA_Types.Alarm_Type.Type]()
      case _ => None[PCA_Types.Alarm_Type.Type]()
    }
    return value
  }

  def getWarning() : Option[PCA_Types.Warning_Type.Type] = {
    val value : Option[PCA_Types.Warning_Type.Type] = Art.getValue(Warning_Id) match {
      case Some(PCA_Types.Warning_Type_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Warning.  Expecting 'PCA_Types.Warning_Type_Payload' but received ${v}")
        None[PCA_Types.Warning_Type.Type]()
      case _ => None[PCA_Types.Warning_Type.Type]()
    }
    return value
  }

  def getCP_Bolus_Duration() : Option[ICE_Types.Minute_imp] = {
    val value : Option[ICE_Types.Minute_imp] = Art.getValue(CP_Bolus_Duration_Id) match {
      case Some(ICE_Types.Minute_imp_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port CP_Bolus_Duration.  Expecting 'ICE_Types.Minute_imp_Payload' but received ${v}")
        None[ICE_Types.Minute_imp]()
      case _ => None[ICE_Types.Minute_imp]()
    }
    return value
  }

  def getBegin_Infusion() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(Begin_Infusion_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Begin_Infusion.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  def getBegin_Priming() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(Begin_Priming_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Begin_Priming.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  def getEnd_Priming() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(End_Priming_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port End_Priming.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  def getHalt_Infusion() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(Halt_Infusion_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Halt_Infusion.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  def getHW_Detected_Failure() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(HW_Detected_Failure_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port HW_Detected_Failure.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  def getStop_Pump_Completely() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(Stop_Pump_Completely_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Stop_Pump_Completely.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  def getPump_At_KVO_Rate() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(Pump_At_KVO_Rate_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Pump_At_KVO_Rate.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  def getPatient_Request_Not_Too_Soon() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(Patient_Request_Not_Too_Soon_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Patient_Request_Not_Too_Soon.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  def getPause_Infusion() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(Pause_Infusion_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Pause_Infusion.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  def getResume_Infusion() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(Resume_Infusion_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Resume_Infusion.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  def getCP_Clinician_Request_Bolus() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(CP_Clinician_Request_Bolus_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port CP_Clinician_Request_Bolus.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  def getNear_Max_Drug_Per_Hour() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(Near_Max_Drug_Per_Hour_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Near_Max_Drug_Per_Hour.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  def getOver_Max_Drug_Per_Hour() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(Over_Max_Drug_Per_Hour_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Over_Max_Drug_Per_Hour.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  def getICE_Stop_Pump() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(ICE_Stop_Pump_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port ICE_Stop_Pump.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }
}
