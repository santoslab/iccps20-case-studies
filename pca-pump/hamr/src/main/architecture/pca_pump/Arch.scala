// #Sireum

package pca_pump

import org.sireum._
import art._
import art.PortMode._
import art.DispatchPropertyProtocol._

// This file was auto-generated.  Do not edit

object Arch {
  val pca_imp_Instance_safety_alarm_process_alarm_thr : pca_pump.PCA_Alarm.alarm_thread_imp_safety_alarm_process_alarm_thr_Bridge = {
    val Alarm = Port[PCA_Types.Alarm_Type.Type] (id = 0, name = "pca_imp_Instance_safety_alarm_process_alarm_thr_Alarm", mode = EventOut)
    val Warning = Port[PCA_Types.Warning_Type.Type] (id = 1, name = "pca_imp_Instance_safety_alarm_process_alarm_thr_Warning", mode = EventOut)
    val ICE_Alarm_Signal = Port[ICE_Types.Alarm_Signal.Type] (id = 2, name = "pca_imp_Instance_safety_alarm_process_alarm_thr_ICE_Alarm_Signal", mode = EventIn)
    val Log_Fault = Port[PCA_Types.Fault_Record] (id = 3, name = "pca_imp_Instance_safety_alarm_process_alarm_thr_Log_Fault", mode = EventOut)
    val ICE_Immediate = Port[art.Empty] (id = 4, name = "pca_imp_Instance_safety_alarm_process_alarm_thr_ICE_Immediate", mode = EventOut)
    val ICE_Prompt = Port[art.Empty] (id = 5, name = "pca_imp_Instance_safety_alarm_process_alarm_thr_ICE_Prompt", mode = EventOut)
    val ICE_Delayed = Port[art.Empty] (id = 6, name = "pca_imp_Instance_safety_alarm_process_alarm_thr_ICE_Delayed", mode = EventOut)
    val ICE_Malfunction = Port[art.Empty] (id = 7, name = "pca_imp_Instance_safety_alarm_process_alarm_thr_ICE_Malfunction", mode = EventOut)
    val ICE_Reset_Alarm = Port[art.Empty] (id = 8, name = "pca_imp_Instance_safety_alarm_process_alarm_thr_ICE_Reset_Alarm", mode = EventIn)
    val Stop_Pump_Completely = Port[art.Empty] (id = 9, name = "pca_imp_Instance_safety_alarm_process_alarm_thr_Stop_Pump_Completely", mode = EventOut)
    val Pump_At_KVO_Rate = Port[art.Empty] (id = 10, name = "pca_imp_Instance_safety_alarm_process_alarm_thr_Pump_At_KVO_Rate", mode = EventOut)
    val Max_Dose_Warning = Port[art.Empty] (id = 11, name = "pca_imp_Instance_safety_alarm_process_alarm_thr_Max_Dose_Warning", mode = EventIn)
    val Hard_Limit_Violation = Port[art.Empty] (id = 12, name = "pca_imp_Instance_safety_alarm_process_alarm_thr_Hard_Limit_Violation", mode = EventIn)
    val Empty_Res = Port[art.Empty] (id = 13, name = "pca_imp_Instance_safety_alarm_process_alarm_thr_Empty_Res", mode = EventIn)
    val Low_Res = Port[art.Empty] (id = 14, name = "pca_imp_Instance_safety_alarm_process_alarm_thr_Low_Res", mode = EventIn)
    val Pump_Hot = Port[art.Empty] (id = 15, name = "pca_imp_Instance_safety_alarm_process_alarm_thr_Pump_Hot", mode = EventIn)
    val Upstream_Occlusion = Port[art.Empty] (id = 16, name = "pca_imp_Instance_safety_alarm_process_alarm_thr_Upstream_Occlusion", mode = EventIn)
    val Downstream_Occlusion = Port[art.Empty] (id = 17, name = "pca_imp_Instance_safety_alarm_process_alarm_thr_Downstream_Occlusion", mode = EventIn)
    val Bubble = Port[art.Empty] (id = 18, name = "pca_imp_Instance_safety_alarm_process_alarm_thr_Bubble", mode = EventIn)
    val Prime_Failure = Port[art.Empty] (id = 19, name = "pca_imp_Instance_safety_alarm_process_alarm_thr_Prime_Failure", mode = EventIn)
    val CP_Reset_Alarm = Port[art.Empty] (id = 20, name = "pca_imp_Instance_safety_alarm_process_alarm_thr_CP_Reset_Alarm", mode = EventIn)
    val Drug_Not_In_Library = Port[art.Empty] (id = 21, name = "pca_imp_Instance_safety_alarm_process_alarm_thr_Drug_Not_In_Library", mode = EventIn)
    val Defective_Btty = Port[art.Empty] (id = 22, name = "pca_imp_Instance_safety_alarm_process_alarm_thr_Defective_Btty", mode = EventIn)
    val Low_Battery_Warning = Port[art.Empty] (id = 23, name = "pca_imp_Instance_safety_alarm_process_alarm_thr_Low_Battery_Warning", mode = EventIn)
    val Voltage_OOR = Port[art.Empty] (id = 24, name = "pca_imp_Instance_safety_alarm_process_alarm_thr_Voltage_OOR", mode = EventIn)
    val Basal_Overinfusion = Port[art.Empty] (id = 25, name = "pca_imp_Instance_safety_alarm_process_alarm_thr_Basal_Overinfusion", mode = EventIn)
    val Bolus_Overinfusion = Port[art.Empty] (id = 26, name = "pca_imp_Instance_safety_alarm_process_alarm_thr_Bolus_Overinfusion", mode = EventIn)
    val Square_Bolus_Overinfusion = Port[art.Empty] (id = 27, name = "pca_imp_Instance_safety_alarm_process_alarm_thr_Square_Bolus_Overinfusion", mode = EventIn)
    val Basal_Underinfusion = Port[art.Empty] (id = 28, name = "pca_imp_Instance_safety_alarm_process_alarm_thr_Basal_Underinfusion", mode = EventIn)
    val Bolus_Underinfusion = Port[art.Empty] (id = 29, name = "pca_imp_Instance_safety_alarm_process_alarm_thr_Bolus_Underinfusion", mode = EventIn)
    val Square_Bolus_Underinfusion = Port[art.Empty] (id = 30, name = "pca_imp_Instance_safety_alarm_process_alarm_thr_Square_Bolus_Underinfusion", mode = EventIn)
    val Security_Fault = Port[art.Empty] (id = 31, name = "pca_imp_Instance_safety_alarm_process_alarm_thr_Security_Fault", mode = EventIn)

    pca_pump.PCA_Alarm.alarm_thread_imp_safety_alarm_process_alarm_thr_Bridge(
      id = 0,
      name = "pca_imp_Instance_safety_alarm_process_alarm_thr",
      dispatchProtocol = Sporadic(min = 5),
      dispatchTriggers = None(),

      Alarm = Alarm,
      Warning = Warning,
      ICE_Alarm_Signal = ICE_Alarm_Signal,
      Log_Fault = Log_Fault,
      ICE_Immediate = ICE_Immediate,
      ICE_Prompt = ICE_Prompt,
      ICE_Delayed = ICE_Delayed,
      ICE_Malfunction = ICE_Malfunction,
      ICE_Reset_Alarm = ICE_Reset_Alarm,
      Stop_Pump_Completely = Stop_Pump_Completely,
      Pump_At_KVO_Rate = Pump_At_KVO_Rate,
      Max_Dose_Warning = Max_Dose_Warning,
      Hard_Limit_Violation = Hard_Limit_Violation,
      Empty_Res = Empty_Res,
      Low_Res = Low_Res,
      Pump_Hot = Pump_Hot,
      Upstream_Occlusion = Upstream_Occlusion,
      Downstream_Occlusion = Downstream_Occlusion,
      Bubble = Bubble,
      Prime_Failure = Prime_Failure,
      CP_Reset_Alarm = CP_Reset_Alarm,
      Drug_Not_In_Library = Drug_Not_In_Library,
      Defective_Btty = Defective_Btty,
      Low_Battery_Warning = Low_Battery_Warning,
      Voltage_OOR = Voltage_OOR,
      Basal_Overinfusion = Basal_Overinfusion,
      Bolus_Overinfusion = Bolus_Overinfusion,
      Square_Bolus_Overinfusion = Square_Bolus_Overinfusion,
      Basal_Underinfusion = Basal_Underinfusion,
      Bolus_Underinfusion = Bolus_Underinfusion,
      Square_Bolus_Underinfusion = Square_Bolus_Underinfusion,
      Security_Fault = Security_Fault
    )
  }
  val pca_imp_Instance_safety_alarm_process_flow_rate : pca_pump.PCA_Alarm.Flow_Rate_Checker_imp_safety_alarm_process_flow_rate_Bridge = {
    val System_Status = Port[PCA_Types.Status_Type.Type] (id = 32, name = "pca_imp_Instance_safety_alarm_process_flow_rate_System_Status", mode = DataIn)
    val Infusion_Flow_Rate = Port[PCA_Types.Flow_Rate] (id = 33, name = "pca_imp_Instance_safety_alarm_process_flow_rate_Infusion_Flow_Rate", mode = DataIn)
    val Upstream_Flow_Rate = Port[PCA_Types.Flow_Rate] (id = 34, name = "pca_imp_Instance_safety_alarm_process_flow_rate_Upstream_Flow_Rate", mode = DataIn)
    val Downstream_Flow_Rate = Port[PCA_Types.Flow_Rate] (id = 35, name = "pca_imp_Instance_safety_alarm_process_flow_rate_Downstream_Flow_Rate", mode = DataIn)
    val Basal_Overinfusion = Port[art.Empty] (id = 36, name = "pca_imp_Instance_safety_alarm_process_flow_rate_Basal_Overinfusion", mode = EventOut)
    val Bolus_Overinfusion = Port[art.Empty] (id = 37, name = "pca_imp_Instance_safety_alarm_process_flow_rate_Bolus_Overinfusion", mode = EventOut)
    val Square_Bolus_Overinfusion = Port[art.Empty] (id = 38, name = "pca_imp_Instance_safety_alarm_process_flow_rate_Square_Bolus_Overinfusion", mode = EventOut)
    val Basal_Underinfusion = Port[art.Empty] (id = 39, name = "pca_imp_Instance_safety_alarm_process_flow_rate_Basal_Underinfusion", mode = EventOut)
    val Bolus_Underinfusion = Port[art.Empty] (id = 40, name = "pca_imp_Instance_safety_alarm_process_flow_rate_Bolus_Underinfusion", mode = EventOut)
    val Square_Bolus_Underinfusion = Port[art.Empty] (id = 41, name = "pca_imp_Instance_safety_alarm_process_flow_rate_Square_Bolus_Underinfusion", mode = EventOut)

    pca_pump.PCA_Alarm.Flow_Rate_Checker_imp_safety_alarm_process_flow_rate_Bridge(
      id = 1,
      name = "pca_imp_Instance_safety_alarm_process_flow_rate",
      dispatchProtocol = Periodic(period = 5),
      dispatchTriggers = None(),

      System_Status = System_Status,
      Infusion_Flow_Rate = Infusion_Flow_Rate,
      Upstream_Flow_Rate = Upstream_Flow_Rate,
      Downstream_Flow_Rate = Downstream_Flow_Rate,
      Basal_Overinfusion = Basal_Overinfusion,
      Bolus_Overinfusion = Bolus_Overinfusion,
      Square_Bolus_Overinfusion = Square_Bolus_Overinfusion,
      Basal_Underinfusion = Basal_Underinfusion,
      Bolus_Underinfusion = Bolus_Underinfusion,
      Square_Bolus_Underinfusion = Square_Bolus_Underinfusion
    )
  }
  val pca_imp_Instance_operation_operation_process_drug_library : pca_pump.PCA_Drug_Library.drug_library_thread_imp_operation_operation_process_drug_library_Bridge = {
    val Load_Drug_Library = Port[PCA_Types.Drug_Library] (id = 42, name = "pca_imp_Instance_operation_operation_process_drug_library_Load_Drug_Library", mode = EventIn)
    val Get_Drug_Record = Port[PCA_Types.Drug_Code] (id = 43, name = "pca_imp_Instance_operation_operation_process_drug_library_Get_Drug_Record", mode = EventIn)
    val The_Drug_Record = Port[PCA_Types.Drug_Record] (id = 44, name = "pca_imp_Instance_operation_operation_process_drug_library_The_Drug_Record", mode = EventOut)
    val No_Drug_Found = Port[art.Empty] (id = 45, name = "pca_imp_Instance_operation_operation_process_drug_library_No_Drug_Found", mode = EventOut)

    pca_pump.PCA_Drug_Library.drug_library_thread_imp_operation_operation_process_drug_library_Bridge(
      id = 2,
      name = "pca_imp_Instance_operation_operation_process_drug_library",
      dispatchProtocol = Sporadic(min = 5),
      dispatchTriggers = None(),

      Load_Drug_Library = Load_Drug_Library,
      Get_Drug_Record = Get_Drug_Record,
      The_Drug_Record = The_Drug_Record,
      No_Drug_Found = No_Drug_Found
    )
  }
  val pca_imp_Instance_operation_operation_process_event_logger : pca_pump.PCA_Operation.event_logger_thread_imp_operation_operation_process_event_logger_Bridge = {
    val Log_Event = Port[PCA_Types.Event_Record] (id = 46, name = "pca_imp_Instance_operation_operation_process_event_logger_Log_Event", mode = EventIn)
    val The_Event_Log = Port[PCA_Types.Event_Log] (id = 47, name = "pca_imp_Instance_operation_operation_process_event_logger_The_Event_Log", mode = EventOut)
    val Get_Event_Log = Port[art.Empty] (id = 48, name = "pca_imp_Instance_operation_operation_process_event_logger_Get_Event_Log", mode = EventIn)

    pca_pump.PCA_Operation.event_logger_thread_imp_operation_operation_process_event_logger_Bridge(
      id = 3,
      name = "pca_imp_Instance_operation_operation_process_event_logger",
      dispatchProtocol = Sporadic(min = 5),
      dispatchTriggers = None(),

      Log_Event = Log_Event,
      The_Event_Log = The_Event_Log,
      Get_Event_Log = Get_Event_Log
    )
  }
  val pca_imp_Instance_operation_operation_process_operation_threads_boss : pca_pump.PCA_Boss.Boss_Thread_imp_operation_operation_process_operation_threads_boss_Bridge = {
    val Display_Message = Port[PCA_Types.Message.Type] (id = 49, name = "pca_imp_Instance_operation_operation_process_operation_threads_boss_Display_Message", mode = EventOut)
    val Sound_Type = Port[PCA_Types.Sound.Type] (id = 50, name = "pca_imp_Instance_operation_operation_process_operation_threads_boss_Sound_Type", mode = EventOut)
    val Log_Event = Port[PCA_Types.Event_Record] (id = 51, name = "pca_imp_Instance_operation_operation_process_operation_threads_boss_Log_Event", mode = EventOut)
    val POST_done = Port[art.Empty] (id = 52, name = "pca_imp_Instance_operation_operation_process_operation_threads_boss_POST_done", mode = EventIn)
    val POST_fail = Port[art.Empty] (id = 53, name = "pca_imp_Instance_operation_operation_process_operation_threads_boss_POST_fail", mode = EventIn)
    val Stop_Button_Pressed = Port[art.Empty] (id = 54, name = "pca_imp_Instance_operation_operation_process_operation_threads_boss_Stop_Button_Pressed", mode = EventIn)
    val Start_Button_Pressed = Port[art.Empty] (id = 55, name = "pca_imp_Instance_operation_operation_process_operation_threads_boss_Start_Button_Pressed", mode = EventIn)
    val Do_Scan = Port[art.Empty] (id = 56, name = "pca_imp_Instance_operation_operation_process_operation_threads_boss_Do_Scan", mode = EventOut)
    val Scan_Done = Port[art.Empty] (id = 57, name = "pca_imp_Instance_operation_operation_process_operation_threads_boss_Scan_Done", mode = EventIn)
    val Authenticate_Clinician = Port[art.Empty] (id = 58, name = "pca_imp_Instance_operation_operation_process_operation_threads_boss_Authenticate_Clinician", mode = EventOut)
    val Authenticate_Patient = Port[art.Empty] (id = 59, name = "pca_imp_Instance_operation_operation_process_operation_threads_boss_Authenticate_Patient", mode = EventOut)
    val Authenticate_Prescription = Port[art.Empty] (id = 60, name = "pca_imp_Instance_operation_operation_process_operation_threads_boss_Authenticate_Prescription", mode = EventOut)
    val Authentication_fail = Port[art.Empty] (id = 61, name = "pca_imp_Instance_operation_operation_process_operation_threads_boss_Authentication_fail", mode = EventIn)
    val Authentication_pass = Port[art.Empty] (id = 62, name = "pca_imp_Instance_operation_operation_process_operation_threads_boss_Authentication_pass", mode = EventIn)
    val Check_Rx = Port[art.Empty] (id = 63, name = "pca_imp_Instance_operation_operation_process_operation_threads_boss_Check_Rx", mode = EventOut)
    val Drug_Not_In_Library = Port[art.Empty] (id = 64, name = "pca_imp_Instance_operation_operation_process_operation_threads_boss_Drug_Not_In_Library", mode = EventIn)
    val Hard_Limit_Violated = Port[art.Empty] (id = 65, name = "pca_imp_Instance_operation_operation_process_operation_threads_boss_Hard_Limit_Violated", mode = EventIn)
    val Reject_Soft_Limit_Exception = Port[art.Empty] (id = 66, name = "pca_imp_Instance_operation_operation_process_operation_threads_boss_Reject_Soft_Limit_Exception", mode = EventIn)
    val Confirm_Soft_Limit_Exception = Port[art.Empty] (id = 67, name = "pca_imp_Instance_operation_operation_process_operation_threads_boss_Confirm_Soft_Limit_Exception", mode = EventIn)
    val Rx_Okay = Port[art.Empty] (id = 68, name = "pca_imp_Instance_operation_operation_process_operation_threads_boss_Rx_Okay", mode = EventIn)
    val Door_Closed = Port[art.Empty] (id = 69, name = "pca_imp_Instance_operation_operation_process_operation_threads_boss_Door_Closed", mode = EventIn)
    val Begin_Priming = Port[art.Empty] (id = 70, name = "pca_imp_Instance_operation_operation_process_operation_threads_boss_Begin_Priming", mode = EventOut)
    val End_Priming = Port[art.Empty] (id = 71, name = "pca_imp_Instance_operation_operation_process_operation_threads_boss_End_Priming", mode = EventOut)
    val Prime_Failure = Port[art.Empty] (id = 72, name = "pca_imp_Instance_operation_operation_process_operation_threads_boss_Prime_Failure", mode = EventOut)
    val Begin_Infusion = Port[art.Empty] (id = 73, name = "pca_imp_Instance_operation_operation_process_operation_threads_boss_Begin_Infusion", mode = EventOut)
    val Halt_Infusion = Port[art.Empty] (id = 74, name = "pca_imp_Instance_operation_operation_process_operation_threads_boss_Halt_Infusion", mode = EventOut)
    val Turn_Off = Port[art.Empty] (id = 75, name = "pca_imp_Instance_operation_operation_process_operation_threads_boss_Turn_Off", mode = EventIn)

    pca_pump.PCA_Boss.Boss_Thread_imp_operation_operation_process_operation_threads_boss_Bridge(
      id = 4,
      name = "pca_imp_Instance_operation_operation_process_operation_threads_boss",
      dispatchProtocol = Sporadic(min = 5),
      dispatchTriggers = None(),

      Display_Message = Display_Message,
      Sound_Type = Sound_Type,
      Log_Event = Log_Event,
      POST_done = POST_done,
      POST_fail = POST_fail,
      Stop_Button_Pressed = Stop_Button_Pressed,
      Start_Button_Pressed = Start_Button_Pressed,
      Do_Scan = Do_Scan,
      Scan_Done = Scan_Done,
      Authenticate_Clinician = Authenticate_Clinician,
      Authenticate_Patient = Authenticate_Patient,
      Authenticate_Prescription = Authenticate_Prescription,
      Authentication_fail = Authentication_fail,
      Authentication_pass = Authentication_pass,
      Check_Rx = Check_Rx,
      Drug_Not_In_Library = Drug_Not_In_Library,
      Hard_Limit_Violated = Hard_Limit_Violated,
      Reject_Soft_Limit_Exception = Reject_Soft_Limit_Exception,
      Confirm_Soft_Limit_Exception = Confirm_Soft_Limit_Exception,
      Rx_Okay = Rx_Okay,
      Door_Closed = Door_Closed,
      Begin_Priming = Begin_Priming,
      End_Priming = End_Priming,
      Prime_Failure = Prime_Failure,
      Begin_Infusion = Begin_Infusion,
      Halt_Infusion = Halt_Infusion,
      Turn_Off = Turn_Off
    )
  }
  val pca_imp_Instance_operation_operation_process_operation_threads_rate_controller : pca_pump.PCA_Operation_Threads.Rate_Controller_imp_operation_operation_process_operation_threads_rate_controller_Bridge = {
    val Infusion_Flow_Rate = Port[PCA_Types.Flow_Rate] (id = 76, name = "pca_imp_Instance_operation_operation_process_operation_threads_rate_controller_Infusion_Flow_Rate", mode = DataOut)
    val Square_Bolus_Rate = Port[PCA_Types.Flow_Rate] (id = 77, name = "pca_imp_Instance_operation_operation_process_operation_threads_rate_controller_Square_Bolus_Rate", mode = DataIn)
    val Patient_Bolus_Rate = Port[PCA_Types.Flow_Rate] (id = 78, name = "pca_imp_Instance_operation_operation_process_operation_threads_rate_controller_Patient_Bolus_Rate", mode = DataIn)
    val Basal_Rate = Port[PCA_Types.Flow_Rate] (id = 79, name = "pca_imp_Instance_operation_operation_process_operation_threads_rate_controller_Basal_Rate", mode = DataIn)
    val VTBI = Port[PCA_Types.Drug_Volume] (id = 80, name = "pca_imp_Instance_operation_operation_process_operation_threads_rate_controller_VTBI", mode = DataIn)
    val Door_Open = Port[Base_Types.Boolean] (id = 81, name = "pca_imp_Instance_operation_operation_process_operation_threads_rate_controller_Door_Open", mode = DataIn)
    val System_Status = Port[PCA_Types.Status_Type.Type] (id = 82, name = "pca_imp_Instance_operation_operation_process_operation_threads_rate_controller_System_Status", mode = EventOut)
    val Alarm = Port[PCA_Types.Alarm_Type.Type] (id = 83, name = "pca_imp_Instance_operation_operation_process_operation_threads_rate_controller_Alarm", mode = EventIn)
    val Warning = Port[PCA_Types.Warning_Type.Type] (id = 84, name = "pca_imp_Instance_operation_operation_process_operation_threads_rate_controller_Warning", mode = EventIn)
    val CP_Bolus_Duration = Port[ICE_Types.Minute] (id = 85, name = "pca_imp_Instance_operation_operation_process_operation_threads_rate_controller_CP_Bolus_Duration", mode = EventIn)
    val Begin_Infusion = Port[art.Empty] (id = 86, name = "pca_imp_Instance_operation_operation_process_operation_threads_rate_controller_Begin_Infusion", mode = EventIn)
    val Begin_Priming = Port[art.Empty] (id = 87, name = "pca_imp_Instance_operation_operation_process_operation_threads_rate_controller_Begin_Priming", mode = EventIn)
    val End_Priming = Port[art.Empty] (id = 88, name = "pca_imp_Instance_operation_operation_process_operation_threads_rate_controller_End_Priming", mode = EventIn)
    val Halt_Infusion = Port[art.Empty] (id = 89, name = "pca_imp_Instance_operation_operation_process_operation_threads_rate_controller_Halt_Infusion", mode = EventIn)
    val HW_Detected_Failure = Port[art.Empty] (id = 90, name = "pca_imp_Instance_operation_operation_process_operation_threads_rate_controller_HW_Detected_Failure", mode = EventIn)
    val Stop_Pump_Completely = Port[art.Empty] (id = 91, name = "pca_imp_Instance_operation_operation_process_operation_threads_rate_controller_Stop_Pump_Completely", mode = EventIn)
    val Pump_At_KVO_Rate = Port[art.Empty] (id = 92, name = "pca_imp_Instance_operation_operation_process_operation_threads_rate_controller_Pump_At_KVO_Rate", mode = EventIn)
    val Patient_Request_Not_Too_Soon = Port[art.Empty] (id = 93, name = "pca_imp_Instance_operation_operation_process_operation_threads_rate_controller_Patient_Request_Not_Too_Soon", mode = EventIn)
    val Pause_Infusion = Port[art.Empty] (id = 94, name = "pca_imp_Instance_operation_operation_process_operation_threads_rate_controller_Pause_Infusion", mode = EventIn)
    val Resume_Infusion = Port[art.Empty] (id = 95, name = "pca_imp_Instance_operation_operation_process_operation_threads_rate_controller_Resume_Infusion", mode = EventIn)
    val CP_Clinician_Request_Bolus = Port[art.Empty] (id = 96, name = "pca_imp_Instance_operation_operation_process_operation_threads_rate_controller_CP_Clinician_Request_Bolus", mode = EventIn)
    val Near_Max_Drug_Per_Hour = Port[art.Empty] (id = 97, name = "pca_imp_Instance_operation_operation_process_operation_threads_rate_controller_Near_Max_Drug_Per_Hour", mode = EventIn)
    val Over_Max_Drug_Per_Hour = Port[art.Empty] (id = 98, name = "pca_imp_Instance_operation_operation_process_operation_threads_rate_controller_Over_Max_Drug_Per_Hour", mode = EventIn)
    val ICE_Stop_Pump = Port[art.Empty] (id = 99, name = "pca_imp_Instance_operation_operation_process_operation_threads_rate_controller_ICE_Stop_Pump", mode = EventIn)

    pca_pump.PCA_Operation_Threads.Rate_Controller_imp_operation_operation_process_operation_threads_rate_controller_Bridge(
      id = 5,
      name = "pca_imp_Instance_operation_operation_process_operation_threads_rate_controller",
      dispatchProtocol = Sporadic(min = 5),
      dispatchTriggers = None(),

      Infusion_Flow_Rate = Infusion_Flow_Rate,
      Square_Bolus_Rate = Square_Bolus_Rate,
      Patient_Bolus_Rate = Patient_Bolus_Rate,
      Basal_Rate = Basal_Rate,
      VTBI = VTBI,
      Door_Open = Door_Open,
      System_Status = System_Status,
      Alarm = Alarm,
      Warning = Warning,
      CP_Bolus_Duration = CP_Bolus_Duration,
      Begin_Infusion = Begin_Infusion,
      Begin_Priming = Begin_Priming,
      End_Priming = End_Priming,
      Halt_Infusion = Halt_Infusion,
      HW_Detected_Failure = HW_Detected_Failure,
      Stop_Pump_Completely = Stop_Pump_Completely,
      Pump_At_KVO_Rate = Pump_At_KVO_Rate,
      Patient_Request_Not_Too_Soon = Patient_Request_Not_Too_Soon,
      Pause_Infusion = Pause_Infusion,
      Resume_Infusion = Resume_Infusion,
      CP_Clinician_Request_Bolus = CP_Clinician_Request_Bolus,
      Near_Max_Drug_Per_Hour = Near_Max_Drug_Per_Hour,
      Over_Max_Drug_Per_Hour = Over_Max_Drug_Per_Hour,
      ICE_Stop_Pump = ICE_Stop_Pump
    )
  }
  val pca_imp_Instance_operation_operation_process_operation_threads_prescription_checker : pca_pump.PCA_Operation_Threads.Prescription_Checker_imp_operation_operation_process_operation_threads_prescription_checker_Bridge = {
    val Prescription = Port[PCA_Types.Prescription] (id = 100, name = "pca_imp_Instance_operation_operation_process_operation_threads_prescription_checker_Prescription", mode = DataIn)
    val VTBI = Port[PCA_Types.Drug_Volume] (id = 101, name = "pca_imp_Instance_operation_operation_process_operation_threads_prescription_checker_VTBI", mode = DataOut)
    val Square_Bolus_Rate = Port[PCA_Types.Flow_Rate] (id = 102, name = "pca_imp_Instance_operation_operation_process_operation_threads_prescription_checker_Square_Bolus_Rate", mode = DataOut)
    val Patient_Bolus_Rate = Port[PCA_Types.Flow_Rate] (id = 103, name = "pca_imp_Instance_operation_operation_process_operation_threads_prescription_checker_Patient_Bolus_Rate", mode = DataOut)
    val Basal_Rate = Port[PCA_Types.Flow_Rate] (id = 104, name = "pca_imp_Instance_operation_operation_process_operation_threads_prescription_checker_Basal_Rate", mode = DataOut)
    val Minimum_Time_Between_Bolus = Port[ICE_Types.Minute] (id = 105, name = "pca_imp_Instance_operation_operation_process_operation_threads_prescription_checker_Minimum_Time_Between_Bolus", mode = DataOut)
    val Max_Drug_Per_Hour = Port[PCA_Types.Drug_Volume] (id = 106, name = "pca_imp_Instance_operation_operation_process_operation_threads_prescription_checker_Max_Drug_Per_Hour", mode = DataOut)
    val Get_Drug_Record = Port[PCA_Types.Drug_Code] (id = 107, name = "pca_imp_Instance_operation_operation_process_operation_threads_prescription_checker_Get_Drug_Record", mode = EventOut)
    val The_Drug_Record = Port[PCA_Types.Drug_Record] (id = 108, name = "pca_imp_Instance_operation_operation_process_operation_threads_prescription_checker_The_Drug_Record", mode = EventIn)
    val Check_Rx = Port[art.Empty] (id = 109, name = "pca_imp_Instance_operation_operation_process_operation_threads_prescription_checker_Check_Rx", mode = EventIn)
    val Rx_Okay = Port[art.Empty] (id = 110, name = "pca_imp_Instance_operation_operation_process_operation_threads_prescription_checker_Rx_Okay", mode = EventOut)
    val Drug_Not_In_Library = Port[art.Empty] (id = 111, name = "pca_imp_Instance_operation_operation_process_operation_threads_prescription_checker_Drug_Not_In_Library", mode = EventIn)
    val Confirm_Soft_Limit_Exception = Port[art.Empty] (id = 112, name = "pca_imp_Instance_operation_operation_process_operation_threads_prescription_checker_Confirm_Soft_Limit_Exception", mode = EventIn)
    val Reject_Soft_Limit_Exception = Port[art.Empty] (id = 113, name = "pca_imp_Instance_operation_operation_process_operation_threads_prescription_checker_Reject_Soft_Limit_Exception", mode = EventIn)
    val Soft_Limit_Warning = Port[art.Empty] (id = 114, name = "pca_imp_Instance_operation_operation_process_operation_threads_prescription_checker_Soft_Limit_Warning", mode = EventOut)
    val Hard_Limit_Violated = Port[art.Empty] (id = 115, name = "pca_imp_Instance_operation_operation_process_operation_threads_prescription_checker_Hard_Limit_Violated", mode = EventOut)

    pca_pump.PCA_Operation_Threads.Prescription_Checker_imp_operation_operation_process_operation_threads_prescription_checker_Bridge(
      id = 6,
      name = "pca_imp_Instance_operation_operation_process_operation_threads_prescription_checker",
      dispatchProtocol = Sporadic(min = 5),
      dispatchTriggers = None(),

      Prescription = Prescription,
      VTBI = VTBI,
      Square_Bolus_Rate = Square_Bolus_Rate,
      Patient_Bolus_Rate = Patient_Bolus_Rate,
      Basal_Rate = Basal_Rate,
      Minimum_Time_Between_Bolus = Minimum_Time_Between_Bolus,
      Max_Drug_Per_Hour = Max_Drug_Per_Hour,
      Get_Drug_Record = Get_Drug_Record,
      The_Drug_Record = The_Drug_Record,
      Check_Rx = Check_Rx,
      Rx_Okay = Rx_Okay,
      Drug_Not_In_Library = Drug_Not_In_Library,
      Confirm_Soft_Limit_Exception = Confirm_Soft_Limit_Exception,
      Reject_Soft_Limit_Exception = Reject_Soft_Limit_Exception,
      Soft_Limit_Warning = Soft_Limit_Warning,
      Hard_Limit_Violated = Hard_Limit_Violated
    )
  }
  val pca_imp_Instance_operation_operation_process_operation_threads_ice_thread : pca_pump.PCA_Operation_Threads.ICE_Thread_imp_operation_operation_process_operation_threads_ice_thread_Bridge = {
    val Infusion_Flow_Rate = Port[PCA_Types.Flow_Rate] (id = 116, name = "pca_imp_Instance_operation_operation_process_operation_threads_ice_thread_Infusion_Flow_Rate", mode = DataIn)
    val Patient_Bolus_Rate = Port[PCA_Types.Flow_Rate] (id = 117, name = "pca_imp_Instance_operation_operation_process_operation_threads_ice_thread_Patient_Bolus_Rate", mode = DataIn)
    val Square_Bolus_Rate = Port[PCA_Types.Flow_Rate] (id = 118, name = "pca_imp_Instance_operation_operation_process_operation_threads_ice_thread_Square_Bolus_Rate", mode = DataIn)
    val Basal_Rate = Port[PCA_Types.Flow_Rate] (id = 119, name = "pca_imp_Instance_operation_operation_process_operation_threads_ice_thread_Basal_Rate", mode = DataIn)
    val VTBI = Port[PCA_Types.Drug_Volume] (id = 120, name = "pca_imp_Instance_operation_operation_process_operation_threads_ice_thread_VTBI", mode = DataIn)
    val Door_Open = Port[Base_Types.Boolean] (id = 121, name = "pca_imp_Instance_operation_operation_process_operation_threads_ice_thread_Door_Open", mode = DataIn)
    val Alarm_Inactivation = Port[ICE_Types.Alarm_Signal.Type] (id = 122, name = "pca_imp_Instance_operation_operation_process_operation_threads_ice_thread_Alarm_Inactivation", mode = DataIn)
    val Alarm = Port[PCA_Types.Alarm_Type.Type] (id = 123, name = "pca_imp_Instance_operation_operation_process_operation_threads_ice_thread_Alarm", mode = EventIn)
    val Warning = Port[PCA_Types.Warning_Type.Type] (id = 124, name = "pca_imp_Instance_operation_operation_process_operation_threads_ice_thread_Warning", mode = EventIn)
    val CP_Bolus_Duration = Port[ICE_Types.Minute] (id = 125, name = "pca_imp_Instance_operation_operation_process_operation_threads_ice_thread_CP_Bolus_Duration", mode = EventIn)
    val ICE_Stop_Pump = Port[art.Empty] (id = 126, name = "pca_imp_Instance_operation_operation_process_operation_threads_ice_thread_ICE_Stop_Pump", mode = EventOut)
    val Rx_Okay = Port[art.Empty] (id = 127, name = "pca_imp_Instance_operation_operation_process_operation_threads_ice_thread_Rx_Okay", mode = EventIn)
    val Patient_Request_Not_Too_Soon = Port[art.Empty] (id = 128, name = "pca_imp_Instance_operation_operation_process_operation_threads_ice_thread_Patient_Request_Not_Too_Soon", mode = EventIn)
    val Patient_Request_Too_Soon = Port[art.Empty] (id = 129, name = "pca_imp_Instance_operation_operation_process_operation_threads_ice_thread_Patient_Request_Too_Soon", mode = EventIn)
    val HW_Detected_Failure = Port[art.Empty] (id = 130, name = "pca_imp_Instance_operation_operation_process_operation_threads_ice_thread_HW_Detected_Failure", mode = EventIn)
    val Stop_Pump_Completely = Port[art.Empty] (id = 131, name = "pca_imp_Instance_operation_operation_process_operation_threads_ice_thread_Stop_Pump_Completely", mode = EventIn)
    val Pump_At_KVO_Rate = Port[art.Empty] (id = 132, name = "pca_imp_Instance_operation_operation_process_operation_threads_ice_thread_Pump_At_KVO_Rate", mode = EventIn)
    val CP_Clinician_Request_Bolus = Port[art.Empty] (id = 133, name = "pca_imp_Instance_operation_operation_process_operation_threads_ice_thread_CP_Clinician_Request_Bolus", mode = EventIn)
    val Halt_Infusion = Port[art.Empty] (id = 134, name = "pca_imp_Instance_operation_operation_process_operation_threads_ice_thread_Halt_Infusion", mode = EventIn)
    val Begin_Infusion = Port[art.Empty] (id = 135, name = "pca_imp_Instance_operation_operation_process_operation_threads_ice_thread_Begin_Infusion", mode = EventIn)
    val Near_Max_Drug_Per_Hour = Port[art.Empty] (id = 136, name = "pca_imp_Instance_operation_operation_process_operation_threads_ice_thread_Near_Max_Drug_Per_Hour", mode = EventIn)
    val Over_Max_Drug_Per_Hour = Port[art.Empty] (id = 137, name = "pca_imp_Instance_operation_operation_process_operation_threads_ice_thread_Over_Max_Drug_Per_Hour", mode = EventIn)

    pca_pump.PCA_Operation_Threads.ICE_Thread_imp_operation_operation_process_operation_threads_ice_thread_Bridge(
      id = 7,
      name = "pca_imp_Instance_operation_operation_process_operation_threads_ice_thread",
      dispatchProtocol = Sporadic(min = 5),
      dispatchTriggers = None(),

      Infusion_Flow_Rate = Infusion_Flow_Rate,
      Patient_Bolus_Rate = Patient_Bolus_Rate,
      Square_Bolus_Rate = Square_Bolus_Rate,
      Basal_Rate = Basal_Rate,
      VTBI = VTBI,
      Door_Open = Door_Open,
      Alarm_Inactivation = Alarm_Inactivation,
      Alarm = Alarm,
      Warning = Warning,
      CP_Bolus_Duration = CP_Bolus_Duration,
      ICE_Stop_Pump = ICE_Stop_Pump,
      Rx_Okay = Rx_Okay,
      Patient_Request_Not_Too_Soon = Patient_Request_Not_Too_Soon,
      Patient_Request_Too_Soon = Patient_Request_Too_Soon,
      HW_Detected_Failure = HW_Detected_Failure,
      Stop_Pump_Completely = Stop_Pump_Completely,
      Pump_At_KVO_Rate = Pump_At_KVO_Rate,
      CP_Clinician_Request_Bolus = CP_Clinician_Request_Bolus,
      Halt_Infusion = Halt_Infusion,
      Begin_Infusion = Begin_Infusion,
      Near_Max_Drug_Per_Hour = Near_Max_Drug_Per_Hour,
      Over_Max_Drug_Per_Hour = Over_Max_Drug_Per_Hour
    )
  }
  val pca_imp_Instance_operation_operation_process_operation_threads_max_drug_watcher : pca_pump.PCA_Operation_Threads.Max_Drug_Per_Hour_Watcher_imp_operation_operation_process_operation_threads_max_drug_watcher_Bridge = {
    val Infusion_Flow_Rate = Port[PCA_Types.Flow_Rate] (id = 138, name = "pca_imp_Instance_operation_operation_process_operation_threads_max_drug_watcher_Infusion_Flow_Rate", mode = DataIn)
    val Max_Drug_Per_Hour = Port[PCA_Types.Drug_Volume] (id = 139, name = "pca_imp_Instance_operation_operation_process_operation_threads_max_drug_watcher_Max_Drug_Per_Hour", mode = DataIn)
    val Near_Max_Drug_Per_Hour = Port[art.Empty] (id = 140, name = "pca_imp_Instance_operation_operation_process_operation_threads_max_drug_watcher_Near_Max_Drug_Per_Hour", mode = EventOut)
    val Over_Max_Drug_Per_Hour = Port[art.Empty] (id = 141, name = "pca_imp_Instance_operation_operation_process_operation_threads_max_drug_watcher_Over_Max_Drug_Per_Hour", mode = EventOut)

    pca_pump.PCA_Operation_Threads.Max_Drug_Per_Hour_Watcher_imp_operation_operation_process_operation_threads_max_drug_watcher_Bridge(
      id = 8,
      name = "pca_imp_Instance_operation_operation_process_operation_threads_max_drug_watcher",
      dispatchProtocol = Periodic(period = 1000),
      dispatchTriggers = None(),

      Infusion_Flow_Rate = Infusion_Flow_Rate,
      Max_Drug_Per_Hour = Max_Drug_Per_Hour,
      Near_Max_Drug_Per_Hour = Near_Max_Drug_Per_Hour,
      Over_Max_Drug_Per_Hour = Over_Max_Drug_Per_Hour
    )
  }
  val pca_imp_Instance_operation_operation_process_operation_threads_patient_bolus_checker : pca_pump.PCA_Operation_Threads.Patient_Bolus_Checker_imp_operation_operation_process_operation_threads_patient_bolus_checker_Bridge = {
    val Minimum_Time_Between_Bolus = Port[ICE_Types.Minute] (id = 142, name = "pca_imp_Instance_operation_operation_process_operation_threads_patient_bolus_checker_Minimum_Time_Between_Bolus", mode = DataIn)
    val Patient_Button_Request = Port[art.Empty] (id = 143, name = "pca_imp_Instance_operation_operation_process_operation_threads_patient_bolus_checker_Patient_Button_Request", mode = EventIn)
    val Patient_Request_Not_Too_Soon = Port[art.Empty] (id = 144, name = "pca_imp_Instance_operation_operation_process_operation_threads_patient_bolus_checker_Patient_Request_Not_Too_Soon", mode = EventOut)
    val Patient_Request_Too_Soon = Port[art.Empty] (id = 145, name = "pca_imp_Instance_operation_operation_process_operation_threads_patient_bolus_checker_Patient_Request_Too_Soon", mode = EventOut)

    pca_pump.PCA_Operation_Threads.Patient_Bolus_Checker_imp_operation_operation_process_operation_threads_patient_bolus_checker_Bridge(
      id = 9,
      name = "pca_imp_Instance_operation_operation_process_operation_threads_patient_bolus_checker",
      dispatchProtocol = Sporadic(min = 5),
      dispatchTriggers = None(),

      Minimum_Time_Between_Bolus = Minimum_Time_Between_Bolus,
      Patient_Button_Request = Patient_Button_Request,
      Patient_Request_Not_Too_Soon = Patient_Request_Not_Too_Soon,
      Patient_Request_Too_Soon = Patient_Request_Too_Soon
    )
  }
  val pca_imp_Instance_operation_security_subsystem_security_process_security_thread : pca_pump.PCA_Security.Security_Thread_imp_operation_security_subsystem_security_process_security_thread_Bridge = {
    val Clinician_Name = Port[Base_Types.String] (id = 146, name = "pca_imp_Instance_operation_security_subsystem_security_process_security_thread_Clinician_Name", mode = DataOut)
    val Patient_Name = Port[Base_Types.String] (id = 147, name = "pca_imp_Instance_operation_security_subsystem_security_process_security_thread_Patient_Name", mode = DataOut)
    val Prescription = Port[PCA_Types.Prescription] (id = 148, name = "pca_imp_Instance_operation_security_subsystem_security_process_security_thread_Prescription", mode = DataOut)
    val Scan_Data = Port[PCA_Types.Scan_Data_Type] (id = 149, name = "pca_imp_Instance_operation_security_subsystem_security_process_security_thread_Scan_Data", mode = EventIn)
    val Authenticate_Clinician = Port[art.Empty] (id = 150, name = "pca_imp_Instance_operation_security_subsystem_security_process_security_thread_Authenticate_Clinician", mode = EventIn)
    val Authenticate_Patient = Port[art.Empty] (id = 151, name = "pca_imp_Instance_operation_security_subsystem_security_process_security_thread_Authenticate_Patient", mode = EventIn)
    val Authenticate_Prescription = Port[art.Empty] (id = 152, name = "pca_imp_Instance_operation_security_subsystem_security_process_security_thread_Authenticate_Prescription", mode = EventIn)
    val Authentication_fail = Port[art.Empty] (id = 153, name = "pca_imp_Instance_operation_security_subsystem_security_process_security_thread_Authentication_fail", mode = EventOut)
    val Authentication_pass = Port[art.Empty] (id = 154, name = "pca_imp_Instance_operation_security_subsystem_security_process_security_thread_Authentication_pass", mode = EventOut)
    val Security_Fault = Port[art.Empty] (id = 155, name = "pca_imp_Instance_operation_security_subsystem_security_process_security_thread_Security_Fault", mode = EventOut)

    pca_pump.PCA_Security.Security_Thread_imp_operation_security_subsystem_security_process_security_thread_Bridge(
      id = 10,
      name = "pca_imp_Instance_operation_security_subsystem_security_process_security_thread",
      dispatchProtocol = Sporadic(min = 1000),
      dispatchTriggers = None(),

      Clinician_Name = Clinician_Name,
      Patient_Name = Patient_Name,
      Prescription = Prescription,
      Scan_Data = Scan_Data,
      Authenticate_Clinician = Authenticate_Clinician,
      Authenticate_Patient = Authenticate_Patient,
      Authenticate_Prescription = Authenticate_Prescription,
      Authentication_fail = Authentication_fail,
      Authentication_pass = Authentication_pass,
      Security_Fault = Security_Fault
    )
  }
  val pca_imp_Instance_operation_control_panel_ui_process_ui_thread : pca_pump.PCA_Control_Panel.ui_thread_imp_operation_control_panel_ui_process_ui_thread_Bridge = {
    val Image = Port[PCA_Types.Image] (id = 156, name = "pca_imp_Instance_operation_control_panel_ui_process_ui_thread_Image", mode = DataOut)
    val AudioSignal = Port[PCA_Types.Sound.Type] (id = 157, name = "pca_imp_Instance_operation_control_panel_ui_process_ui_thread_AudioSignal", mode = DataOut)
    val Alarm_Inactivation = Port[ICE_Types.Alarm_Signal.Type] (id = 158, name = "pca_imp_Instance_operation_control_panel_ui_process_ui_thread_Alarm_Inactivation", mode = DataOut)
    val Remaining_Battery_Time = Port[BLESS_Types.Time] (id = 159, name = "pca_imp_Instance_operation_control_panel_ui_process_ui_thread_Remaining_Battery_Time", mode = DataIn)
    val Using_Battery_Power = Port[Base_Types.Boolean] (id = 160, name = "pca_imp_Instance_operation_control_panel_ui_process_ui_thread_Using_Battery_Power", mode = DataIn)
    val Prescription = Port[PCA_Types.Prescription] (id = 161, name = "pca_imp_Instance_operation_control_panel_ui_process_ui_thread_Prescription", mode = DataIn)
    val Infusion_Flow_Rate = Port[PCA_Types.Flow_Rate] (id = 162, name = "pca_imp_Instance_operation_control_panel_ui_process_ui_thread_Infusion_Flow_Rate", mode = DataIn)
    val Clinician_Name = Port[Base_Types.String] (id = 163, name = "pca_imp_Instance_operation_control_panel_ui_process_ui_thread_Clinician_Name", mode = DataIn)
    val Patient_Name = Port[Base_Types.String] (id = 164, name = "pca_imp_Instance_operation_control_panel_ui_process_ui_thread_Patient_Name", mode = DataIn)
    val Touch = Port[PCA_Types.Touch] (id = 165, name = "pca_imp_Instance_operation_control_panel_ui_process_ui_thread_Touch", mode = EventIn)
    val Alarm = Port[PCA_Types.Alarm_Type.Type] (id = 166, name = "pca_imp_Instance_operation_control_panel_ui_process_ui_thread_Alarm", mode = EventIn)
    val Warning = Port[PCA_Types.Warning_Type.Type] (id = 167, name = "pca_imp_Instance_operation_control_panel_ui_process_ui_thread_Warning", mode = EventIn)
    val System_Status = Port[PCA_Types.Status_Type.Type] (id = 168, name = "pca_imp_Instance_operation_control_panel_ui_process_ui_thread_System_Status", mode = EventIn)
    val Display_Message = Port[PCA_Types.Message.Type] (id = 169, name = "pca_imp_Instance_operation_control_panel_ui_process_ui_thread_Display_Message", mode = EventIn)
    val Sound_Type = Port[PCA_Types.Sound.Type] (id = 170, name = "pca_imp_Instance_operation_control_panel_ui_process_ui_thread_Sound_Type", mode = EventIn)
    val Bolus_Duration = Port[ICE_Types.Minute] (id = 171, name = "pca_imp_Instance_operation_control_panel_ui_process_ui_thread_Bolus_Duration", mode = EventOut)
    val CP_Reset_Alarm = Port[art.Empty] (id = 172, name = "pca_imp_Instance_operation_control_panel_ui_process_ui_thread_CP_Reset_Alarm", mode = EventOut)
    val Low_Battery_Warning = Port[art.Empty] (id = 173, name = "pca_imp_Instance_operation_control_panel_ui_process_ui_thread_Low_Battery_Warning", mode = EventIn)
    val Hard_Limit_Violated = Port[art.Empty] (id = 174, name = "pca_imp_Instance_operation_control_panel_ui_process_ui_thread_Hard_Limit_Violated", mode = EventIn)
    val Soft_Limit_Warning = Port[art.Empty] (id = 175, name = "pca_imp_Instance_operation_control_panel_ui_process_ui_thread_Soft_Limit_Warning", mode = EventIn)
    val Confirm_Soft_Limit_Exception = Port[art.Empty] (id = 176, name = "pca_imp_Instance_operation_control_panel_ui_process_ui_thread_Confirm_Soft_Limit_Exception", mode = EventOut)
    val Reject_Soft_Limit_Exception = Port[art.Empty] (id = 177, name = "pca_imp_Instance_operation_control_panel_ui_process_ui_thread_Reject_Soft_Limit_Exception", mode = EventOut)
    val Stop_Button_Pressed = Port[art.Empty] (id = 178, name = "pca_imp_Instance_operation_control_panel_ui_process_ui_thread_Stop_Button_Pressed", mode = EventOut)
    val Start_Button_Pressed = Port[art.Empty] (id = 179, name = "pca_imp_Instance_operation_control_panel_ui_process_ui_thread_Start_Button_Pressed", mode = EventOut)
    val Clinician_Request_Bolus = Port[art.Empty] (id = 180, name = "pca_imp_Instance_operation_control_panel_ui_process_ui_thread_Clinician_Request_Bolus", mode = EventOut)
    val Pause_Infusion = Port[art.Empty] (id = 181, name = "pca_imp_Instance_operation_control_panel_ui_process_ui_thread_Pause_Infusion", mode = EventOut)
    val Resume_Infusion = Port[art.Empty] (id = 182, name = "pca_imp_Instance_operation_control_panel_ui_process_ui_thread_Resume_Infusion", mode = EventOut)
    val Turn_Off = Port[art.Empty] (id = 183, name = "pca_imp_Instance_operation_control_panel_ui_process_ui_thread_Turn_Off", mode = EventOut)
    val Patient_Request_Not_Too_Soon = Port[art.Empty] (id = 184, name = "pca_imp_Instance_operation_control_panel_ui_process_ui_thread_Patient_Request_Not_Too_Soon", mode = EventIn)
    val Patient_Request_Too_Soon = Port[art.Empty] (id = 185, name = "pca_imp_Instance_operation_control_panel_ui_process_ui_thread_Patient_Request_Too_Soon", mode = EventIn)

    pca_pump.PCA_Control_Panel.ui_thread_imp_operation_control_panel_ui_process_ui_thread_Bridge(
      id = 11,
      name = "pca_imp_Instance_operation_control_panel_ui_process_ui_thread",
      dispatchProtocol = Sporadic(min = 5),
      dispatchTriggers = None(),

      Image = Image,
      AudioSignal = AudioSignal,
      Alarm_Inactivation = Alarm_Inactivation,
      Remaining_Battery_Time = Remaining_Battery_Time,
      Using_Battery_Power = Using_Battery_Power,
      Prescription = Prescription,
      Infusion_Flow_Rate = Infusion_Flow_Rate,
      Clinician_Name = Clinician_Name,
      Patient_Name = Patient_Name,
      Touch = Touch,
      Alarm = Alarm,
      Warning = Warning,
      System_Status = System_Status,
      Display_Message = Display_Message,
      Sound_Type = Sound_Type,
      Bolus_Duration = Bolus_Duration,
      CP_Reset_Alarm = CP_Reset_Alarm,
      Low_Battery_Warning = Low_Battery_Warning,
      Hard_Limit_Violated = Hard_Limit_Violated,
      Soft_Limit_Warning = Soft_Limit_Warning,
      Confirm_Soft_Limit_Exception = Confirm_Soft_Limit_Exception,
      Reject_Soft_Limit_Exception = Reject_Soft_Limit_Exception,
      Stop_Button_Pressed = Stop_Button_Pressed,
      Start_Button_Pressed = Start_Button_Pressed,
      Clinician_Request_Bolus = Clinician_Request_Bolus,
      Pause_Infusion = Pause_Infusion,
      Resume_Infusion = Resume_Infusion,
      Turn_Off = Turn_Off,
      Patient_Request_Not_Too_Soon = Patient_Request_Not_Too_Soon,
      Patient_Request_Too_Soon = Patient_Request_Too_Soon
    )
  }

  val ad : ArchitectureDescription = {

    ArchitectureDescription(
      components = MSZ (pca_imp_Instance_safety_alarm_process_alarm_thr, pca_imp_Instance_safety_alarm_process_flow_rate, pca_imp_Instance_operation_operation_process_drug_library, pca_imp_Instance_operation_operation_process_event_logger, pca_imp_Instance_operation_operation_process_operation_threads_boss, pca_imp_Instance_operation_operation_process_operation_threads_rate_controller, pca_imp_Instance_operation_operation_process_operation_threads_prescription_checker, pca_imp_Instance_operation_operation_process_operation_threads_ice_thread, pca_imp_Instance_operation_operation_process_operation_threads_max_drug_watcher, pca_imp_Instance_operation_operation_process_operation_threads_patient_bolus_checker, pca_imp_Instance_operation_security_subsystem_security_process_security_thread, pca_imp_Instance_operation_control_panel_ui_process_ui_thread),

      connections = ISZ (Connection(from = pca_imp_Instance_safety_alarm_process_flow_rate.Basal_Overinfusion, to = pca_imp_Instance_safety_alarm_process_alarm_thr.Basal_Overinfusion),
                         Connection(from = pca_imp_Instance_safety_alarm_process_flow_rate.Bolus_Overinfusion, to = pca_imp_Instance_safety_alarm_process_alarm_thr.Bolus_Overinfusion),
                         Connection(from = pca_imp_Instance_safety_alarm_process_flow_rate.Square_Bolus_Overinfusion, to = pca_imp_Instance_safety_alarm_process_alarm_thr.Square_Bolus_Overinfusion),
                         Connection(from = pca_imp_Instance_safety_alarm_process_flow_rate.Basal_Underinfusion, to = pca_imp_Instance_safety_alarm_process_alarm_thr.Basal_Underinfusion),
                         Connection(from = pca_imp_Instance_safety_alarm_process_flow_rate.Bolus_Underinfusion, to = pca_imp_Instance_safety_alarm_process_alarm_thr.Bolus_Underinfusion),
                         Connection(from = pca_imp_Instance_safety_alarm_process_flow_rate.Square_Bolus_Underinfusion, to = pca_imp_Instance_safety_alarm_process_alarm_thr.Square_Bolus_Underinfusion),
                         Connection(from = pca_imp_Instance_operation_operation_process_operation_threads_boss.Check_Rx, to = pca_imp_Instance_operation_operation_process_operation_threads_prescription_checker.Check_Rx),
                         Connection(from = pca_imp_Instance_operation_operation_process_operation_threads_boss.Begin_Priming, to = pca_imp_Instance_operation_operation_process_operation_threads_rate_controller.Begin_Priming),
                         Connection(from = pca_imp_Instance_operation_operation_process_operation_threads_boss.End_Priming, to = pca_imp_Instance_operation_operation_process_operation_threads_rate_controller.End_Priming),
                         Connection(from = pca_imp_Instance_operation_operation_process_operation_threads_boss.Begin_Infusion, to = pca_imp_Instance_operation_operation_process_operation_threads_rate_controller.Begin_Infusion),
                         Connection(from = pca_imp_Instance_operation_operation_process_operation_threads_boss.Begin_Infusion, to = pca_imp_Instance_operation_operation_process_operation_threads_ice_thread.Begin_Infusion),
                         Connection(from = pca_imp_Instance_operation_operation_process_operation_threads_boss.Halt_Infusion, to = pca_imp_Instance_operation_operation_process_operation_threads_rate_controller.Halt_Infusion),
                         Connection(from = pca_imp_Instance_operation_operation_process_operation_threads_boss.Halt_Infusion, to = pca_imp_Instance_operation_operation_process_operation_threads_ice_thread.Halt_Infusion),
                         Connection(from = pca_imp_Instance_operation_operation_process_operation_threads_rate_controller.Infusion_Flow_Rate, to = pca_imp_Instance_operation_operation_process_operation_threads_max_drug_watcher.Infusion_Flow_Rate),
                         Connection(from = pca_imp_Instance_operation_operation_process_operation_threads_rate_controller.Infusion_Flow_Rate, to = pca_imp_Instance_operation_operation_process_operation_threads_ice_thread.Infusion_Flow_Rate),
                         Connection(from = pca_imp_Instance_operation_operation_process_operation_threads_prescription_checker.VTBI, to = pca_imp_Instance_operation_operation_process_operation_threads_rate_controller.VTBI),
                         Connection(from = pca_imp_Instance_operation_operation_process_operation_threads_prescription_checker.VTBI, to = pca_imp_Instance_operation_operation_process_operation_threads_ice_thread.VTBI),
                         Connection(from = pca_imp_Instance_operation_operation_process_operation_threads_prescription_checker.Square_Bolus_Rate, to = pca_imp_Instance_operation_operation_process_operation_threads_rate_controller.Square_Bolus_Rate),
                         Connection(from = pca_imp_Instance_operation_operation_process_operation_threads_prescription_checker.Square_Bolus_Rate, to = pca_imp_Instance_operation_operation_process_operation_threads_ice_thread.Square_Bolus_Rate),
                         Connection(from = pca_imp_Instance_operation_operation_process_operation_threads_prescription_checker.Patient_Bolus_Rate, to = pca_imp_Instance_operation_operation_process_operation_threads_rate_controller.Patient_Bolus_Rate),
                         Connection(from = pca_imp_Instance_operation_operation_process_operation_threads_prescription_checker.Patient_Bolus_Rate, to = pca_imp_Instance_operation_operation_process_operation_threads_ice_thread.Patient_Bolus_Rate),
                         Connection(from = pca_imp_Instance_operation_operation_process_operation_threads_prescription_checker.Basal_Rate, to = pca_imp_Instance_operation_operation_process_operation_threads_rate_controller.Basal_Rate),
                         Connection(from = pca_imp_Instance_operation_operation_process_operation_threads_prescription_checker.Basal_Rate, to = pca_imp_Instance_operation_operation_process_operation_threads_ice_thread.Basal_Rate),
                         Connection(from = pca_imp_Instance_operation_operation_process_operation_threads_prescription_checker.Minimum_Time_Between_Bolus, to = pca_imp_Instance_operation_operation_process_operation_threads_patient_bolus_checker.Minimum_Time_Between_Bolus),
                         Connection(from = pca_imp_Instance_operation_operation_process_operation_threads_prescription_checker.Max_Drug_Per_Hour, to = pca_imp_Instance_operation_operation_process_operation_threads_max_drug_watcher.Max_Drug_Per_Hour),
                         Connection(from = pca_imp_Instance_operation_operation_process_operation_threads_prescription_checker.Rx_Okay, to = pca_imp_Instance_operation_operation_process_operation_threads_boss.Rx_Okay),
                         Connection(from = pca_imp_Instance_operation_operation_process_operation_threads_prescription_checker.Rx_Okay, to = pca_imp_Instance_operation_operation_process_operation_threads_ice_thread.Rx_Okay),
                         Connection(from = pca_imp_Instance_operation_operation_process_operation_threads_prescription_checker.Hard_Limit_Violated, to = pca_imp_Instance_operation_operation_process_operation_threads_boss.Hard_Limit_Violated),
                         Connection(from = pca_imp_Instance_operation_operation_process_operation_threads_ice_thread.ICE_Stop_Pump, to = pca_imp_Instance_operation_operation_process_operation_threads_rate_controller.ICE_Stop_Pump),
                         Connection(from = pca_imp_Instance_operation_operation_process_operation_threads_max_drug_watcher.Near_Max_Drug_Per_Hour, to = pca_imp_Instance_operation_operation_process_operation_threads_rate_controller.Near_Max_Drug_Per_Hour),
                         Connection(from = pca_imp_Instance_operation_operation_process_operation_threads_max_drug_watcher.Near_Max_Drug_Per_Hour, to = pca_imp_Instance_operation_operation_process_operation_threads_ice_thread.Near_Max_Drug_Per_Hour),
                         Connection(from = pca_imp_Instance_operation_operation_process_operation_threads_max_drug_watcher.Over_Max_Drug_Per_Hour, to = pca_imp_Instance_operation_operation_process_operation_threads_rate_controller.Over_Max_Drug_Per_Hour),
                         Connection(from = pca_imp_Instance_operation_operation_process_operation_threads_max_drug_watcher.Over_Max_Drug_Per_Hour, to = pca_imp_Instance_operation_operation_process_operation_threads_ice_thread.Over_Max_Drug_Per_Hour),
                         Connection(from = pca_imp_Instance_operation_operation_process_operation_threads_patient_bolus_checker.Patient_Request_Not_Too_Soon, to = pca_imp_Instance_operation_operation_process_operation_threads_rate_controller.Patient_Request_Not_Too_Soon),
                         Connection(from = pca_imp_Instance_operation_operation_process_operation_threads_patient_bolus_checker.Patient_Request_Not_Too_Soon, to = pca_imp_Instance_operation_operation_process_operation_threads_ice_thread.Patient_Request_Not_Too_Soon),
                         Connection(from = pca_imp_Instance_operation_operation_process_operation_threads_patient_bolus_checker.Patient_Request_Too_Soon, to = pca_imp_Instance_operation_operation_process_operation_threads_ice_thread.Patient_Request_Too_Soon),
                         Connection(from = pca_imp_Instance_operation_operation_process_drug_library.The_Drug_Record, to = pca_imp_Instance_operation_operation_process_operation_threads_prescription_checker.The_Drug_Record),
                         Connection(from = pca_imp_Instance_operation_operation_process_drug_library.No_Drug_Found, to = pca_imp_Instance_operation_operation_process_operation_threads_boss.Drug_Not_In_Library),
                         Connection(from = pca_imp_Instance_operation_operation_process_drug_library.No_Drug_Found, to = pca_imp_Instance_operation_operation_process_operation_threads_prescription_checker.Drug_Not_In_Library),
                         Connection(from = pca_imp_Instance_operation_operation_process_operation_threads_boss.Log_Event, to = pca_imp_Instance_operation_operation_process_event_logger.Log_Event),
                         Connection(from = pca_imp_Instance_operation_operation_process_operation_threads_prescription_checker.Get_Drug_Record, to = pca_imp_Instance_operation_operation_process_drug_library.Get_Drug_Record),
                         Connection(from = pca_imp_Instance_operation_operation_process_operation_threads_boss.Display_Message, to = pca_imp_Instance_operation_control_panel_ui_process_ui_thread.Display_Message),
                         Connection(from = pca_imp_Instance_operation_operation_process_operation_threads_boss.Sound_Type, to = pca_imp_Instance_operation_control_panel_ui_process_ui_thread.Sound_Type),
                         Connection(from = pca_imp_Instance_operation_operation_process_operation_threads_boss.Authenticate_Clinician, to = pca_imp_Instance_operation_security_subsystem_security_process_security_thread.Authenticate_Clinician),
                         Connection(from = pca_imp_Instance_operation_operation_process_operation_threads_boss.Authenticate_Patient, to = pca_imp_Instance_operation_security_subsystem_security_process_security_thread.Authenticate_Patient),
                         Connection(from = pca_imp_Instance_operation_operation_process_operation_threads_boss.Authenticate_Prescription, to = pca_imp_Instance_operation_security_subsystem_security_process_security_thread.Authenticate_Prescription),
                         Connection(from = pca_imp_Instance_operation_operation_process_operation_threads_rate_controller.Infusion_Flow_Rate, to = pca_imp_Instance_operation_control_panel_ui_process_ui_thread.Infusion_Flow_Rate),
                         Connection(from = pca_imp_Instance_operation_operation_process_operation_threads_rate_controller.System_Status, to = pca_imp_Instance_operation_control_panel_ui_process_ui_thread.System_Status),
                         Connection(from = pca_imp_Instance_operation_operation_process_operation_threads_prescription_checker.Soft_Limit_Warning, to = pca_imp_Instance_operation_control_panel_ui_process_ui_thread.Soft_Limit_Warning),
                         Connection(from = pca_imp_Instance_operation_operation_process_operation_threads_prescription_checker.Hard_Limit_Violated, to = pca_imp_Instance_operation_control_panel_ui_process_ui_thread.Hard_Limit_Violated),
                         Connection(from = pca_imp_Instance_operation_operation_process_operation_threads_patient_bolus_checker.Patient_Request_Not_Too_Soon, to = pca_imp_Instance_operation_control_panel_ui_process_ui_thread.Patient_Request_Not_Too_Soon),
                         Connection(from = pca_imp_Instance_operation_operation_process_operation_threads_patient_bolus_checker.Patient_Request_Too_Soon, to = pca_imp_Instance_operation_control_panel_ui_process_ui_thread.Patient_Request_Too_Soon),
                         Connection(from = pca_imp_Instance_operation_security_subsystem_security_process_security_thread.Clinician_Name, to = pca_imp_Instance_operation_control_panel_ui_process_ui_thread.Clinician_Name),
                         Connection(from = pca_imp_Instance_operation_security_subsystem_security_process_security_thread.Patient_Name, to = pca_imp_Instance_operation_control_panel_ui_process_ui_thread.Patient_Name),
                         Connection(from = pca_imp_Instance_operation_security_subsystem_security_process_security_thread.Prescription, to = pca_imp_Instance_operation_control_panel_ui_process_ui_thread.Prescription),
                         Connection(from = pca_imp_Instance_operation_security_subsystem_security_process_security_thread.Prescription, to = pca_imp_Instance_operation_operation_process_operation_threads_prescription_checker.Prescription),
                         Connection(from = pca_imp_Instance_operation_security_subsystem_security_process_security_thread.Authentication_fail, to = pca_imp_Instance_operation_operation_process_operation_threads_boss.Authentication_fail),
                         Connection(from = pca_imp_Instance_operation_security_subsystem_security_process_security_thread.Authentication_pass, to = pca_imp_Instance_operation_operation_process_operation_threads_boss.Authentication_pass),
                         Connection(from = pca_imp_Instance_operation_control_panel_ui_process_ui_thread.Alarm_Inactivation, to = pca_imp_Instance_operation_operation_process_operation_threads_ice_thread.Alarm_Inactivation),
                         Connection(from = pca_imp_Instance_operation_control_panel_ui_process_ui_thread.Bolus_Duration, to = pca_imp_Instance_operation_operation_process_operation_threads_rate_controller.CP_Bolus_Duration),
                         Connection(from = pca_imp_Instance_operation_control_panel_ui_process_ui_thread.Bolus_Duration, to = pca_imp_Instance_operation_operation_process_operation_threads_ice_thread.CP_Bolus_Duration),
                         Connection(from = pca_imp_Instance_operation_control_panel_ui_process_ui_thread.Confirm_Soft_Limit_Exception, to = pca_imp_Instance_operation_operation_process_operation_threads_boss.Confirm_Soft_Limit_Exception),
                         Connection(from = pca_imp_Instance_operation_control_panel_ui_process_ui_thread.Confirm_Soft_Limit_Exception, to = pca_imp_Instance_operation_operation_process_operation_threads_prescription_checker.Confirm_Soft_Limit_Exception),
                         Connection(from = pca_imp_Instance_operation_control_panel_ui_process_ui_thread.Reject_Soft_Limit_Exception, to = pca_imp_Instance_operation_operation_process_operation_threads_boss.Reject_Soft_Limit_Exception),
                         Connection(from = pca_imp_Instance_operation_control_panel_ui_process_ui_thread.Reject_Soft_Limit_Exception, to = pca_imp_Instance_operation_operation_process_operation_threads_prescription_checker.Reject_Soft_Limit_Exception),
                         Connection(from = pca_imp_Instance_operation_control_panel_ui_process_ui_thread.Stop_Button_Pressed, to = pca_imp_Instance_operation_operation_process_operation_threads_boss.Stop_Button_Pressed),
                         Connection(from = pca_imp_Instance_operation_control_panel_ui_process_ui_thread.Start_Button_Pressed, to = pca_imp_Instance_operation_operation_process_operation_threads_boss.Start_Button_Pressed),
                         Connection(from = pca_imp_Instance_operation_control_panel_ui_process_ui_thread.Clinician_Request_Bolus, to = pca_imp_Instance_operation_operation_process_operation_threads_rate_controller.CP_Clinician_Request_Bolus),
                         Connection(from = pca_imp_Instance_operation_control_panel_ui_process_ui_thread.Clinician_Request_Bolus, to = pca_imp_Instance_operation_operation_process_operation_threads_ice_thread.CP_Clinician_Request_Bolus),
                         Connection(from = pca_imp_Instance_operation_control_panel_ui_process_ui_thread.Pause_Infusion, to = pca_imp_Instance_operation_operation_process_operation_threads_rate_controller.Pause_Infusion),
                         Connection(from = pca_imp_Instance_operation_control_panel_ui_process_ui_thread.Resume_Infusion, to = pca_imp_Instance_operation_operation_process_operation_threads_rate_controller.Resume_Infusion),
                         Connection(from = pca_imp_Instance_operation_control_panel_ui_process_ui_thread.Turn_Off, to = pca_imp_Instance_operation_operation_process_operation_threads_boss.Turn_Off),
                         Connection(from = pca_imp_Instance_safety_alarm_process_alarm_thr.Alarm, to = pca_imp_Instance_operation_operation_process_operation_threads_rate_controller.Alarm),
                         Connection(from = pca_imp_Instance_safety_alarm_process_alarm_thr.Alarm, to = pca_imp_Instance_operation_operation_process_operation_threads_ice_thread.Alarm),
                         Connection(from = pca_imp_Instance_safety_alarm_process_alarm_thr.Alarm, to = pca_imp_Instance_operation_control_panel_ui_process_ui_thread.Alarm),
                         Connection(from = pca_imp_Instance_safety_alarm_process_alarm_thr.Warning, to = pca_imp_Instance_operation_operation_process_operation_threads_rate_controller.Warning),
                         Connection(from = pca_imp_Instance_safety_alarm_process_alarm_thr.Warning, to = pca_imp_Instance_operation_operation_process_operation_threads_ice_thread.Warning),
                         Connection(from = pca_imp_Instance_safety_alarm_process_alarm_thr.Warning, to = pca_imp_Instance_operation_control_panel_ui_process_ui_thread.Warning),
                         Connection(from = pca_imp_Instance_safety_alarm_process_alarm_thr.Pump_At_KVO_Rate, to = pca_imp_Instance_operation_operation_process_operation_threads_rate_controller.Pump_At_KVO_Rate),
                         Connection(from = pca_imp_Instance_safety_alarm_process_alarm_thr.Pump_At_KVO_Rate, to = pca_imp_Instance_operation_operation_process_operation_threads_ice_thread.Pump_At_KVO_Rate),
                         Connection(from = pca_imp_Instance_operation_operation_process_drug_library.No_Drug_Found, to = pca_imp_Instance_safety_alarm_process_alarm_thr.Drug_Not_In_Library),
                         Connection(from = pca_imp_Instance_operation_operation_process_operation_threads_boss.Prime_Failure, to = pca_imp_Instance_safety_alarm_process_alarm_thr.Prime_Failure),
                         Connection(from = pca_imp_Instance_operation_operation_process_operation_threads_rate_controller.Infusion_Flow_Rate, to = pca_imp_Instance_safety_alarm_process_flow_rate.Infusion_Flow_Rate),
                         Connection(from = pca_imp_Instance_operation_operation_process_operation_threads_rate_controller.System_Status, to = pca_imp_Instance_safety_alarm_process_flow_rate.System_Status),
                         Connection(from = pca_imp_Instance_operation_operation_process_operation_threads_prescription_checker.Hard_Limit_Violated, to = pca_imp_Instance_safety_alarm_process_alarm_thr.Hard_Limit_Violation),
                         Connection(from = pca_imp_Instance_operation_operation_process_operation_threads_max_drug_watcher.Over_Max_Drug_Per_Hour, to = pca_imp_Instance_safety_alarm_process_alarm_thr.Max_Dose_Warning),
                         Connection(from = pca_imp_Instance_operation_security_subsystem_security_process_security_thread.Security_Fault, to = pca_imp_Instance_safety_alarm_process_alarm_thr.Security_Fault),
                         Connection(from = pca_imp_Instance_operation_control_panel_ui_process_ui_thread.CP_Reset_Alarm, to = pca_imp_Instance_safety_alarm_process_alarm_thr.CP_Reset_Alarm))
    )
  }
}