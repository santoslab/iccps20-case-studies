// #Sireum

package pca_pump.PCA_Alarm

import org.sireum._
import art._
import pca_pump._

@sig trait alarm_thread_imp_Api {
  def id: Art.BridgeId
  def Alarm_Id : Art.PortId
  def Warning_Id : Art.PortId
  def ICE_Alarm_Signal_Id : Art.PortId
  def Log_Fault_Id : Art.PortId
  def ICE_Immediate_Id : Art.PortId
  def ICE_Prompt_Id : Art.PortId
  def ICE_Delayed_Id : Art.PortId
  def ICE_Malfunction_Id : Art.PortId
  def ICE_Reset_Alarm_Id : Art.PortId
  def Stop_Pump_Completely_Id : Art.PortId
  def Pump_At_KVO_Rate_Id : Art.PortId
  def Max_Dose_Warning_Id : Art.PortId
  def Hard_Limit_Violation_Id : Art.PortId
  def Empty_Res_Id : Art.PortId
  def Low_Res_Id : Art.PortId
  def Pump_Hot_Id : Art.PortId
  def Upstream_Occlusion_Id : Art.PortId
  def Downstream_Occlusion_Id : Art.PortId
  def Bubble_Id : Art.PortId
  def Prime_Failure_Id : Art.PortId
  def CP_Reset_Alarm_Id : Art.PortId
  def Drug_Not_In_Library_Id : Art.PortId
  def Defective_Btty_Id : Art.PortId
  def Low_Battery_Warning_Id : Art.PortId
  def Voltage_OOR_Id : Art.PortId
  def Basal_Overinfusion_Id : Art.PortId
  def Bolus_Overinfusion_Id : Art.PortId
  def Square_Bolus_Overinfusion_Id : Art.PortId
  def Basal_Underinfusion_Id : Art.PortId
  def Bolus_Underinfusion_Id : Art.PortId
  def Square_Bolus_Underinfusion_Id : Art.PortId
  def Security_Fault_Id : Art.PortId

  def sendAlarm(value : PCA_Types.Alarm_Type.Type) : Unit = {
    Art.putValue(Alarm_Id, PCA_Types.Alarm_Type_Payload(value))
  }

  def sendWarning(value : PCA_Types.Warning_Type.Type) : Unit = {
    Art.putValue(Warning_Id, PCA_Types.Warning_Type_Payload(value))
  }

  def sendLog_Fault(value : PCA_Types.Fault_Record_imp) : Unit = {
    Art.putValue(Log_Fault_Id, PCA_Types.Fault_Record_imp_Payload(value))
  }

  def sendICE_Immediate() : Unit = {
    Art.putValue(ICE_Immediate_Id, art.Empty())
  }

  def sendICE_Prompt() : Unit = {
    Art.putValue(ICE_Prompt_Id, art.Empty())
  }

  def sendICE_Delayed() : Unit = {
    Art.putValue(ICE_Delayed_Id, art.Empty())
  }

  def sendICE_Malfunction() : Unit = {
    Art.putValue(ICE_Malfunction_Id, art.Empty())
  }

  def sendStop_Pump_Completely() : Unit = {
    Art.putValue(Stop_Pump_Completely_Id, art.Empty())
  }

  def sendPump_At_KVO_Rate() : Unit = {
    Art.putValue(Pump_At_KVO_Rate_Id, art.Empty())
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

@datatype class alarm_thread_imp_Initialization_Api (
  val id: Art.BridgeId,
  val Alarm_Id : Art.PortId,
  val Warning_Id : Art.PortId,
  val ICE_Alarm_Signal_Id : Art.PortId,
  val Log_Fault_Id : Art.PortId,
  val ICE_Immediate_Id : Art.PortId,
  val ICE_Prompt_Id : Art.PortId,
  val ICE_Delayed_Id : Art.PortId,
  val ICE_Malfunction_Id : Art.PortId,
  val ICE_Reset_Alarm_Id : Art.PortId,
  val Stop_Pump_Completely_Id : Art.PortId,
  val Pump_At_KVO_Rate_Id : Art.PortId,
  val Max_Dose_Warning_Id : Art.PortId,
  val Hard_Limit_Violation_Id : Art.PortId,
  val Empty_Res_Id : Art.PortId,
  val Low_Res_Id : Art.PortId,
  val Pump_Hot_Id : Art.PortId,
  val Upstream_Occlusion_Id : Art.PortId,
  val Downstream_Occlusion_Id : Art.PortId,
  val Bubble_Id : Art.PortId,
  val Prime_Failure_Id : Art.PortId,
  val CP_Reset_Alarm_Id : Art.PortId,
  val Drug_Not_In_Library_Id : Art.PortId,
  val Defective_Btty_Id : Art.PortId,
  val Low_Battery_Warning_Id : Art.PortId,
  val Voltage_OOR_Id : Art.PortId,
  val Basal_Overinfusion_Id : Art.PortId,
  val Bolus_Overinfusion_Id : Art.PortId,
  val Square_Bolus_Overinfusion_Id : Art.PortId,
  val Basal_Underinfusion_Id : Art.PortId,
  val Bolus_Underinfusion_Id : Art.PortId,
  val Square_Bolus_Underinfusion_Id : Art.PortId,
  val Security_Fault_Id : Art.PortId) extends alarm_thread_imp_Api

@datatype class alarm_thread_imp_Operational_Api (
  val id: Art.BridgeId,
  val Alarm_Id : Art.PortId,
  val Warning_Id : Art.PortId,
  val ICE_Alarm_Signal_Id : Art.PortId,
  val Log_Fault_Id : Art.PortId,
  val ICE_Immediate_Id : Art.PortId,
  val ICE_Prompt_Id : Art.PortId,
  val ICE_Delayed_Id : Art.PortId,
  val ICE_Malfunction_Id : Art.PortId,
  val ICE_Reset_Alarm_Id : Art.PortId,
  val Stop_Pump_Completely_Id : Art.PortId,
  val Pump_At_KVO_Rate_Id : Art.PortId,
  val Max_Dose_Warning_Id : Art.PortId,
  val Hard_Limit_Violation_Id : Art.PortId,
  val Empty_Res_Id : Art.PortId,
  val Low_Res_Id : Art.PortId,
  val Pump_Hot_Id : Art.PortId,
  val Upstream_Occlusion_Id : Art.PortId,
  val Downstream_Occlusion_Id : Art.PortId,
  val Bubble_Id : Art.PortId,
  val Prime_Failure_Id : Art.PortId,
  val CP_Reset_Alarm_Id : Art.PortId,
  val Drug_Not_In_Library_Id : Art.PortId,
  val Defective_Btty_Id : Art.PortId,
  val Low_Battery_Warning_Id : Art.PortId,
  val Voltage_OOR_Id : Art.PortId,
  val Basal_Overinfusion_Id : Art.PortId,
  val Bolus_Overinfusion_Id : Art.PortId,
  val Square_Bolus_Overinfusion_Id : Art.PortId,
  val Basal_Underinfusion_Id : Art.PortId,
  val Bolus_Underinfusion_Id : Art.PortId,
  val Square_Bolus_Underinfusion_Id : Art.PortId,
  val Security_Fault_Id : Art.PortId) extends alarm_thread_imp_Api {

  def getICE_Alarm_Signal() : Option[ICE_Types.Alarm_Signal.Type] = {
    val value : Option[ICE_Types.Alarm_Signal.Type] = Art.getValue(ICE_Alarm_Signal_Id) match {
      case Some(ICE_Types.Alarm_Signal_Payload(v)) => Some(v)
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port ICE_Alarm_Signal.  Expecting 'ICE_Types.Alarm_Signal_Payload' but received ${v}")
        None[ICE_Types.Alarm_Signal.Type]()
      case _ => None[ICE_Types.Alarm_Signal.Type]()
    }
    return value
  }

  def getICE_Reset_Alarm() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(ICE_Reset_Alarm_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port ICE_Reset_Alarm.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  def getMax_Dose_Warning() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(Max_Dose_Warning_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Max_Dose_Warning.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  def getHard_Limit_Violation() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(Hard_Limit_Violation_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Hard_Limit_Violation.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  def getEmpty_Res() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(Empty_Res_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Empty_Res.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  def getLow_Res() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(Low_Res_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Low_Res.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  def getPump_Hot() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(Pump_Hot_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Pump_Hot.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  def getUpstream_Occlusion() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(Upstream_Occlusion_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Upstream_Occlusion.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  def getDownstream_Occlusion() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(Downstream_Occlusion_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Downstream_Occlusion.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  def getBubble() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(Bubble_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Bubble.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  def getPrime_Failure() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(Prime_Failure_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Prime_Failure.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  def getCP_Reset_Alarm() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(CP_Reset_Alarm_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port CP_Reset_Alarm.  Expecting 'Empty' but received ${v}")
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

  def getDefective_Btty() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(Defective_Btty_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Defective_Btty.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  def getLow_Battery_Warning() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(Low_Battery_Warning_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Low_Battery_Warning.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  def getVoltage_OOR() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(Voltage_OOR_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Voltage_OOR.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  def getBasal_Overinfusion() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(Basal_Overinfusion_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Basal_Overinfusion.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  def getBolus_Overinfusion() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(Bolus_Overinfusion_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Bolus_Overinfusion.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  def getSquare_Bolus_Overinfusion() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(Square_Bolus_Overinfusion_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Square_Bolus_Overinfusion.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  def getBasal_Underinfusion() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(Basal_Underinfusion_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Basal_Underinfusion.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  def getBolus_Underinfusion() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(Bolus_Underinfusion_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Bolus_Underinfusion.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  def getSquare_Bolus_Underinfusion() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(Square_Bolus_Underinfusion_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Square_Bolus_Underinfusion.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  def getSecurity_Fault() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(Security_Fault_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Security_Fault.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }
}
