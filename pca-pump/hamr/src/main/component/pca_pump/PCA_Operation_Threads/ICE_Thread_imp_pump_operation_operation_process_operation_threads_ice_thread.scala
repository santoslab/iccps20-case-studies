// #Sireum

package pca_pump.PCA_Operation_Threads

import org.sireum._
import pca_pump._

// This file will not be overwritten so is safe to edit
object ICE_Thread_imp_pump_operation_operation_process_operation_threads_ice_thread {

  def initialise(api: ICE_Thread_imp_Initialization_Api): Unit = {  }

  def handleAlarm(api: ICE_Thread_imp_Operational_Api, value : PCA_Types.Alarm_Type.Type): Unit = {  }

  def handleWarning(api: ICE_Thread_imp_Operational_Api, value : PCA_Types.Warning_Type.Type): Unit = {  }

  def handleCP_Bolus_Duration(api: ICE_Thread_imp_Operational_Api, value : ICE_Types.Minute_imp): Unit = {  }

  def handleRx_Okay(api: ICE_Thread_imp_Operational_Api): Unit = {  }

  def handlePatient_Request_Not_Too_Soon(api: ICE_Thread_imp_Operational_Api): Unit = {  }

  def handlePatient_Request_Too_Soon(api: ICE_Thread_imp_Operational_Api): Unit = {  }

  def handleHW_Detected_Failure(api: ICE_Thread_imp_Operational_Api): Unit = {  }

  def handleStop_Pump_Completely(api: ICE_Thread_imp_Operational_Api): Unit = {  }

  def handlePump_At_KVO_Rate(api: ICE_Thread_imp_Operational_Api): Unit = {  }

  def handleCP_Clinician_Request_Bolus(api: ICE_Thread_imp_Operational_Api): Unit = {  }

  def handleHalt_Infusion(api: ICE_Thread_imp_Operational_Api): Unit = {  }

  def handleBegin_Infusion(api: ICE_Thread_imp_Operational_Api): Unit = {  }

  def handleNear_Max_Drug_Per_Hour(api: ICE_Thread_imp_Operational_Api): Unit = {  }

  def handleOver_Max_Drug_Per_Hour(api: ICE_Thread_imp_Operational_Api): Unit = {  }

  def activate(api: ICE_Thread_imp_Operational_Api): Unit = { }

  def deactivate(api: ICE_Thread_imp_Operational_Api): Unit = { }

  def finalise(api: ICE_Thread_imp_Operational_Api): Unit = { }

  def recover(api: ICE_Thread_imp_Operational_Api): Unit = { }
}
