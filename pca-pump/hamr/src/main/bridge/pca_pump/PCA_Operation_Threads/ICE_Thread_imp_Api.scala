// #Sireum

package pca_pump.PCA_Operation_Threads

import org.sireum._
import art._
import pca_pump._

@sig trait ICE_Thread_imp_Api {
  def id: Art.BridgeId
  def Infusion_Flow_Rate_Id : Art.PortId
  def Patient_Bolus_Rate_Id : Art.PortId
  def Square_Bolus_Rate_Id : Art.PortId
  def Basal_Rate_Id : Art.PortId
  def VTBI_Id : Art.PortId
  def Door_Open_Id : Art.PortId
  def Alarm_Inactivation_Id : Art.PortId
  def Alarm_Id : Art.PortId
  def Warning_Id : Art.PortId
  def CP_Bolus_Duration_Id : Art.PortId
  def ICE_Stop_Pump_Id : Art.PortId
  def Rx_Okay_Id : Art.PortId
  def Patient_Request_Not_Too_Soon_Id : Art.PortId
  def Patient_Request_Too_Soon_Id : Art.PortId
  def HW_Detected_Failure_Id : Art.PortId
  def Stop_Pump_Completely_Id : Art.PortId
  def Pump_At_KVO_Rate_Id : Art.PortId
  def CP_Clinician_Request_Bolus_Id : Art.PortId
  def Halt_Infusion_Id : Art.PortId
  def Begin_Infusion_Id : Art.PortId
  def Near_Max_Drug_Per_Hour_Id : Art.PortId
  def Over_Max_Drug_Per_Hour_Id : Art.PortId

  def sendICE_Stop_Pump() : Unit = {
    Art.putValue(ICE_Stop_Pump_Id, art.Empty())
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

@datatype class ICE_Thread_imp_Initialization_Api (
  val id: Art.BridgeId,
  val Infusion_Flow_Rate_Id : Art.PortId,
  val Patient_Bolus_Rate_Id : Art.PortId,
  val Square_Bolus_Rate_Id : Art.PortId,
  val Basal_Rate_Id : Art.PortId,
  val VTBI_Id : Art.PortId,
  val Door_Open_Id : Art.PortId,
  val Alarm_Inactivation_Id : Art.PortId,
  val Alarm_Id : Art.PortId,
  val Warning_Id : Art.PortId,
  val CP_Bolus_Duration_Id : Art.PortId,
  val ICE_Stop_Pump_Id : Art.PortId,
  val Rx_Okay_Id : Art.PortId,
  val Patient_Request_Not_Too_Soon_Id : Art.PortId,
  val Patient_Request_Too_Soon_Id : Art.PortId,
  val HW_Detected_Failure_Id : Art.PortId,
  val Stop_Pump_Completely_Id : Art.PortId,
  val Pump_At_KVO_Rate_Id : Art.PortId,
  val CP_Clinician_Request_Bolus_Id : Art.PortId,
  val Halt_Infusion_Id : Art.PortId,
  val Begin_Infusion_Id : Art.PortId,
  val Near_Max_Drug_Per_Hour_Id : Art.PortId,
  val Over_Max_Drug_Per_Hour_Id : Art.PortId) extends ICE_Thread_imp_Api

@datatype class ICE_Thread_imp_Operational_Api (
  val id: Art.BridgeId,
  val Infusion_Flow_Rate_Id : Art.PortId,
  val Patient_Bolus_Rate_Id : Art.PortId,
  val Square_Bolus_Rate_Id : Art.PortId,
  val Basal_Rate_Id : Art.PortId,
  val VTBI_Id : Art.PortId,
  val Door_Open_Id : Art.PortId,
  val Alarm_Inactivation_Id : Art.PortId,
  val Alarm_Id : Art.PortId,
  val Warning_Id : Art.PortId,
  val CP_Bolus_Duration_Id : Art.PortId,
  val ICE_Stop_Pump_Id : Art.PortId,
  val Rx_Okay_Id : Art.PortId,
  val Patient_Request_Not_Too_Soon_Id : Art.PortId,
  val Patient_Request_Too_Soon_Id : Art.PortId,
  val HW_Detected_Failure_Id : Art.PortId,
  val Stop_Pump_Completely_Id : Art.PortId,
  val Pump_At_KVO_Rate_Id : Art.PortId,
  val CP_Clinician_Request_Bolus_Id : Art.PortId,
  val Halt_Infusion_Id : Art.PortId,
  val Begin_Infusion_Id : Art.PortId,
  val Near_Max_Drug_Per_Hour_Id : Art.PortId,
  val Over_Max_Drug_Per_Hour_Id : Art.PortId) extends ICE_Thread_imp_Api {

  def getInfusion_Flow_Rate() : Option[PCA_Types.Flow_Rate] = {
    val value : Option[PCA_Types.Flow_Rate] = Art.getValue(Infusion_Flow_Rate_Id) match {
      case Some(PCA_Types.Flow_Rate_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Infusion_Flow_Rate.  Expecting 'PCA_Types.Flow_Rate_Payload' but received ${v}")
        None[PCA_Types.Flow_Rate]()
      case _ => None[PCA_Types.Flow_Rate]()
    }
    return value
  }

  def getPatient_Bolus_Rate() : Option[PCA_Types.Flow_Rate] = {
    val value : Option[PCA_Types.Flow_Rate] = Art.getValue(Patient_Bolus_Rate_Id) match {
      case Some(PCA_Types.Flow_Rate_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Patient_Bolus_Rate.  Expecting 'PCA_Types.Flow_Rate_Payload' but received ${v}")
        None[PCA_Types.Flow_Rate]()
      case _ => None[PCA_Types.Flow_Rate]()
    }
    return value
  }

  def getSquare_Bolus_Rate() : Option[PCA_Types.Flow_Rate] = {
    val value : Option[PCA_Types.Flow_Rate] = Art.getValue(Square_Bolus_Rate_Id) match {
      case Some(PCA_Types.Flow_Rate_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Square_Bolus_Rate.  Expecting 'PCA_Types.Flow_Rate_Payload' but received ${v}")
        None[PCA_Types.Flow_Rate]()
      case _ => None[PCA_Types.Flow_Rate]()
    }
    return value
  }

  def getBasal_Rate() : Option[PCA_Types.Flow_Rate] = {
    val value : Option[PCA_Types.Flow_Rate] = Art.getValue(Basal_Rate_Id) match {
      case Some(PCA_Types.Flow_Rate_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Basal_Rate.  Expecting 'PCA_Types.Flow_Rate_Payload' but received ${v}")
        None[PCA_Types.Flow_Rate]()
      case _ => None[PCA_Types.Flow_Rate]()
    }
    return value
  }

  def getVTBI() : Option[PCA_Types.Drug_Volume] = {
    val value : Option[PCA_Types.Drug_Volume] = Art.getValue(VTBI_Id) match {
      case Some(PCA_Types.Drug_Volume_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port VTBI.  Expecting 'PCA_Types.Drug_Volume_Payload' but received ${v}")
        None[PCA_Types.Drug_Volume]()
      case _ => None[PCA_Types.Drug_Volume]()
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

  def getAlarm_Inactivation() : Option[ICE_Types.Alarm_Signal.Type] = {
    val value : Option[ICE_Types.Alarm_Signal.Type] = Art.getValue(Alarm_Inactivation_Id) match {
      case Some(ICE_Types.Alarm_Signal_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Alarm_Inactivation.  Expecting 'ICE_Types.Alarm_Signal_Payload' but received ${v}")
        None[ICE_Types.Alarm_Signal.Type]()
      case _ => None[ICE_Types.Alarm_Signal.Type]()
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

  def getCP_Bolus_Duration() : Option[ICE_Types.Minute] = {
    val value : Option[ICE_Types.Minute] = Art.getValue(CP_Bolus_Duration_Id) match {
      case Some(ICE_Types.Minute_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port CP_Bolus_Duration.  Expecting 'ICE_Types.Minute_Payload' but received ${v}")
        None[ICE_Types.Minute]()
      case _ => None[ICE_Types.Minute]()
    }
    return value
  }

  def getRx_Okay() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(Rx_Okay_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Rx_Okay.  Expecting 'Empty' but received ${v}")
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

  def getPatient_Request_Too_Soon() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(Patient_Request_Too_Soon_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Patient_Request_Too_Soon.  Expecting 'Empty' but received ${v}")
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
}
