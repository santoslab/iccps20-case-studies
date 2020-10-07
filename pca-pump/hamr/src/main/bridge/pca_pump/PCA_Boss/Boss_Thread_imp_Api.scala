// #Sireum

package pca_pump.PCA_Boss

import org.sireum._
import art._
import pca_pump._

@sig trait Boss_Thread_imp_Api {
  def id: Art.BridgeId
  def Display_Message_Id : Art.PortId
  def Sound_Type_Id : Art.PortId
  def Log_Event_Id : Art.PortId
  def POST_done_Id : Art.PortId
  def POST_fail_Id : Art.PortId
  def Stop_Button_Pressed_Id : Art.PortId
  def Start_Button_Pressed_Id : Art.PortId
  def Do_Scan_Id : Art.PortId
  def Scan_Done_Id : Art.PortId
  def Authenticate_Clinician_Id : Art.PortId
  def Authenticate_Patient_Id : Art.PortId
  def Authenticate_Prescription_Id : Art.PortId
  def Authentication_fail_Id : Art.PortId
  def Authentication_pass_Id : Art.PortId
  def Check_Rx_Id : Art.PortId
  def Drug_Not_In_Library_Id : Art.PortId
  def Hard_Limit_Violated_Id : Art.PortId
  def Reject_Soft_Limit_Exception_Id : Art.PortId
  def Confirm_Soft_Limit_Exception_Id : Art.PortId
  def Rx_Okay_Id : Art.PortId
  def Door_Closed_Id : Art.PortId
  def Begin_Priming_Id : Art.PortId
  def End_Priming_Id : Art.PortId
  def Prime_Failure_Id : Art.PortId
  def Begin_Infusion_Id : Art.PortId
  def Halt_Infusion_Id : Art.PortId
  def Turn_Off_Id : Art.PortId

  def sendDisplay_Message(value : PCA_Types.Message.Type) : Unit = {
    Art.putValue(Display_Message_Id, PCA_Types.Message_Payload(value))
  }

  def sendSound_Type(value : PCA_Types.Sound.Type) : Unit = {
    Art.putValue(Sound_Type_Id, PCA_Types.Sound_Payload(value))
  }

  def sendLog_Event(value : PCA_Types.Event_Record) : Unit = {
    Art.putValue(Log_Event_Id, PCA_Types.Event_Record_Payload(value))
  }

  def sendDo_Scan() : Unit = {
    Art.putValue(Do_Scan_Id, art.Empty())
  }

  def sendAuthenticate_Clinician() : Unit = {
    Art.putValue(Authenticate_Clinician_Id, art.Empty())
  }

  def sendAuthenticate_Patient() : Unit = {
    Art.putValue(Authenticate_Patient_Id, art.Empty())
  }

  def sendAuthenticate_Prescription() : Unit = {
    Art.putValue(Authenticate_Prescription_Id, art.Empty())
  }

  def sendCheck_Rx() : Unit = {
    Art.putValue(Check_Rx_Id, art.Empty())
  }

  def sendBegin_Priming() : Unit = {
    Art.putValue(Begin_Priming_Id, art.Empty())
  }

  def sendEnd_Priming() : Unit = {
    Art.putValue(End_Priming_Id, art.Empty())
  }

  def sendPrime_Failure() : Unit = {
    Art.putValue(Prime_Failure_Id, art.Empty())
  }

  def sendBegin_Infusion() : Unit = {
    Art.putValue(Begin_Infusion_Id, art.Empty())
  }

  def sendHalt_Infusion() : Unit = {
    Art.putValue(Halt_Infusion_Id, art.Empty())
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

@datatype class Boss_Thread_imp_Initialization_Api (
  val id: Art.BridgeId,
  val Display_Message_Id : Art.PortId,
  val Sound_Type_Id : Art.PortId,
  val Log_Event_Id : Art.PortId,
  val POST_done_Id : Art.PortId,
  val POST_fail_Id : Art.PortId,
  val Stop_Button_Pressed_Id : Art.PortId,
  val Start_Button_Pressed_Id : Art.PortId,
  val Do_Scan_Id : Art.PortId,
  val Scan_Done_Id : Art.PortId,
  val Authenticate_Clinician_Id : Art.PortId,
  val Authenticate_Patient_Id : Art.PortId,
  val Authenticate_Prescription_Id : Art.PortId,
  val Authentication_fail_Id : Art.PortId,
  val Authentication_pass_Id : Art.PortId,
  val Check_Rx_Id : Art.PortId,
  val Drug_Not_In_Library_Id : Art.PortId,
  val Hard_Limit_Violated_Id : Art.PortId,
  val Reject_Soft_Limit_Exception_Id : Art.PortId,
  val Confirm_Soft_Limit_Exception_Id : Art.PortId,
  val Rx_Okay_Id : Art.PortId,
  val Door_Closed_Id : Art.PortId,
  val Begin_Priming_Id : Art.PortId,
  val End_Priming_Id : Art.PortId,
  val Prime_Failure_Id : Art.PortId,
  val Begin_Infusion_Id : Art.PortId,
  val Halt_Infusion_Id : Art.PortId,
  val Turn_Off_Id : Art.PortId) extends Boss_Thread_imp_Api

@datatype class Boss_Thread_imp_Operational_Api (
  val id: Art.BridgeId,
  val Display_Message_Id : Art.PortId,
  val Sound_Type_Id : Art.PortId,
  val Log_Event_Id : Art.PortId,
  val POST_done_Id : Art.PortId,
  val POST_fail_Id : Art.PortId,
  val Stop_Button_Pressed_Id : Art.PortId,
  val Start_Button_Pressed_Id : Art.PortId,
  val Do_Scan_Id : Art.PortId,
  val Scan_Done_Id : Art.PortId,
  val Authenticate_Clinician_Id : Art.PortId,
  val Authenticate_Patient_Id : Art.PortId,
  val Authenticate_Prescription_Id : Art.PortId,
  val Authentication_fail_Id : Art.PortId,
  val Authentication_pass_Id : Art.PortId,
  val Check_Rx_Id : Art.PortId,
  val Drug_Not_In_Library_Id : Art.PortId,
  val Hard_Limit_Violated_Id : Art.PortId,
  val Reject_Soft_Limit_Exception_Id : Art.PortId,
  val Confirm_Soft_Limit_Exception_Id : Art.PortId,
  val Rx_Okay_Id : Art.PortId,
  val Door_Closed_Id : Art.PortId,
  val Begin_Priming_Id : Art.PortId,
  val End_Priming_Id : Art.PortId,
  val Prime_Failure_Id : Art.PortId,
  val Begin_Infusion_Id : Art.PortId,
  val Halt_Infusion_Id : Art.PortId,
  val Turn_Off_Id : Art.PortId) extends Boss_Thread_imp_Api {

  def getPOST_done() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(POST_done_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port POST_done.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  def getPOST_fail() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(POST_fail_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port POST_fail.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  def getStop_Button_Pressed() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(Stop_Button_Pressed_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Stop_Button_Pressed.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  def getStart_Button_Pressed() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(Start_Button_Pressed_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Start_Button_Pressed.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  def getScan_Done() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(Scan_Done_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Scan_Done.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  def getAuthentication_fail() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(Authentication_fail_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Authentication_fail.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  def getAuthentication_pass() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(Authentication_pass_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Authentication_pass.  Expecting 'Empty' but received ${v}")
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

  def getHard_Limit_Violated() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(Hard_Limit_Violated_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Hard_Limit_Violated.  Expecting 'Empty' but received ${v}")
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

  def getDoor_Closed() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(Door_Closed_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Door_Closed.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }

  def getTurn_Off() : Option[art.Empty] = {
    val value : Option[art.Empty] = Art.getValue(Turn_Off_Id) match {
      case Some(Empty()) => Some(Empty())
      case Some(v) =>
        Art.logError(id, s"Unexpected payload on port Turn_Off.  Expecting 'Empty' but received ${v}")
        None[art.Empty]()
      case _ => None[art.Empty]()
    }
    return value
  }
}
