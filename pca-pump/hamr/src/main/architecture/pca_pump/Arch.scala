// #Sireum

package pca_pump

import org.sireum._
import art._
import art.PortMode._
import art.DispatchPropertyProtocol._

// This file was auto-generated.  Do not edit

object Arch {
  val wrap_pca_imp_Instance_maint : pca_pump.PCA_System.maintenance_imp_maint_Bridge = {
    val The_Fault_Log = Port[PCA_Types.Fault_Log] (id = 0, name = "wrap_pca_imp_Instance_maint_The_Fault_Log", mode = EventIn)
    val The_Event_Log = Port[PCA_Types.Event_Log] (id = 1, name = "wrap_pca_imp_Instance_maint_The_Event_Log", mode = EventIn)
    val Load_Drug_Library = Port[PCA_Types.Drug_Library] (id = 2, name = "wrap_pca_imp_Instance_maint_Load_Drug_Library", mode = EventOut)
    val Get_Fault_Log = Port[art.Empty] (id = 3, name = "wrap_pca_imp_Instance_maint_Get_Fault_Log", mode = EventOut)
    val Get_Event_Log = Port[art.Empty] (id = 4, name = "wrap_pca_imp_Instance_maint_Get_Event_Log", mode = EventOut)

    pca_pump.PCA_System.maintenance_imp_maint_Bridge(
      id = 0,
      name = "wrap_pca_imp_Instance_maint",
      dispatchProtocol = Periodic(period = 1),
      dispatchTriggers = None(),

      The_Fault_Log = The_Fault_Log,
      The_Event_Log = The_Event_Log,
      Load_Drug_Library = Load_Drug_Library,
      Get_Fault_Log = Get_Fault_Log,
      Get_Event_Log = Get_Event_Log
    )
  }
  val wrap_pca_imp_Instance_pump_safety_error_detect : pca_pump.PCA_Safety.error_detector_imp_pump_safety_error_detect_Bridge = {
    val Software_Stop_Pump = Port[art.Empty] (id = 5, name = "wrap_pca_imp_Instance_pump_safety_error_detect_Software_Stop_Pump", mode = EventIn)
    val Stop_Pump_Completely = Port[art.Empty] (id = 6, name = "wrap_pca_imp_Instance_pump_safety_error_detect_Stop_Pump_Completely", mode = EventOut)
    val POST_Failure = Port[art.Empty] (id = 7, name = "wrap_pca_imp_Instance_pump_safety_error_detect_POST_Failure", mode = EventOut)
    val POST_Done = Port[art.Empty] (id = 8, name = "wrap_pca_imp_Instance_pump_safety_error_detect_POST_Done", mode = EventOut)
    val RAM_Failure = Port[art.Empty] (id = 9, name = "wrap_pca_imp_Instance_pump_safety_error_detect_RAM_Failure", mode = EventOut)
    val ROM_failure = Port[art.Empty] (id = 10, name = "wrap_pca_imp_Instance_pump_safety_error_detect_ROM_failure", mode = EventOut)
    val CPU_Failure = Port[art.Empty] (id = 11, name = "wrap_pca_imp_Instance_pump_safety_error_detect_CPU_Failure", mode = EventOut)
    val Thread_Monitor_Failure = Port[art.Empty] (id = 12, name = "wrap_pca_imp_Instance_pump_safety_error_detect_Thread_Monitor_Failure", mode = EventOut)
    val HW_Detected_Failure = Port[art.Empty] (id = 13, name = "wrap_pca_imp_Instance_pump_safety_error_detect_HW_Detected_Failure", mode = EventOut)

    pca_pump.PCA_Safety.error_detector_imp_pump_safety_error_detect_Bridge(
      id = 1,
      name = "wrap_pca_imp_Instance_pump_safety_error_detect",
      dispatchProtocol = Sporadic(min = 5),
      dispatchTriggers = None(),

      Software_Stop_Pump = Software_Stop_Pump,
      Stop_Pump_Completely = Stop_Pump_Completely,
      POST_Failure = POST_Failure,
      POST_Done = POST_Done,
      RAM_Failure = RAM_Failure,
      ROM_failure = ROM_failure,
      CPU_Failure = CPU_Failure,
      Thread_Monitor_Failure = Thread_Monitor_Failure,
      HW_Detected_Failure = HW_Detected_Failure
    )
  }
  val wrap_pca_imp_Instance_pump_safety_fault_log : pca_pump.PCA_Safety.fault_logger_imp_pump_safety_fault_log_Bridge = {
    val Log_Fault = Port[PCA_Types.Fault_Record_imp] (id = 14, name = "wrap_pca_imp_Instance_pump_safety_fault_log_Log_Fault", mode = EventIn)
    val The_Log = Port[PCA_Types.Fault_Log] (id = 15, name = "wrap_pca_imp_Instance_pump_safety_fault_log_The_Log", mode = EventOut)
    val Get_Log = Port[art.Empty] (id = 16, name = "wrap_pca_imp_Instance_pump_safety_fault_log_Get_Log", mode = EventIn)
    val POST_Failure = Port[art.Empty] (id = 17, name = "wrap_pca_imp_Instance_pump_safety_fault_log_POST_Failure", mode = EventIn)
    val RAM_Failure = Port[art.Empty] (id = 18, name = "wrap_pca_imp_Instance_pump_safety_fault_log_RAM_Failure", mode = EventIn)
    val ROM_Failure = Port[art.Empty] (id = 19, name = "wrap_pca_imp_Instance_pump_safety_fault_log_ROM_Failure", mode = EventIn)
    val CPU_Failure = Port[art.Empty] (id = 20, name = "wrap_pca_imp_Instance_pump_safety_fault_log_CPU_Failure", mode = EventIn)
    val Thread_Monitor_Failure = Port[art.Empty] (id = 21, name = "wrap_pca_imp_Instance_pump_safety_fault_log_Thread_Monitor_Failure", mode = EventIn)
    val Voltage_OOR = Port[art.Empty] (id = 22, name = "wrap_pca_imp_Instance_pump_safety_fault_log_Voltage_OOR", mode = EventIn)

    pca_pump.PCA_Safety.fault_logger_imp_pump_safety_fault_log_Bridge(
      id = 2,
      name = "wrap_pca_imp_Instance_pump_safety_fault_log",
      dispatchProtocol = Sporadic(min = 5),
      dispatchTriggers = None(),

      Log_Fault = Log_Fault,
      The_Log = The_Log,
      Get_Log = Get_Log,
      POST_Failure = POST_Failure,
      RAM_Failure = RAM_Failure,
      ROM_Failure = ROM_Failure,
      CPU_Failure = CPU_Failure,
      Thread_Monitor_Failure = Thread_Monitor_Failure,
      Voltage_OOR = Voltage_OOR
    )
  }
  val wrap_pca_imp_Instance_pump_safety_led : pca_pump.PCA_Safety.failure_led_imp_pump_safety_led_Bridge = {
    val Light = Port[Base_Types.Boolean] (id = 23, name = "wrap_pca_imp_Instance_pump_safety_led_Light", mode = DataOut)
    val Illuminate = Port[art.Empty] (id = 24, name = "wrap_pca_imp_Instance_pump_safety_led_Illuminate", mode = EventIn)

    pca_pump.PCA_Safety.failure_led_imp_pump_safety_led_Bridge(
      id = 3,
      name = "wrap_pca_imp_Instance_pump_safety_led",
      dispatchProtocol = Sporadic(min = 5),
      dispatchTriggers = None(),

      Light = Light,
      Illuminate = Illuminate
    )
  }
  val wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr : pca_pump.PCA_Alarm.alarm_thread_imp_pump_safety_alarm_process_alarm_thr_Bridge = {
    val Alarm = Port[PCA_Types.Alarm_Type.Type] (id = 25, name = "wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr_Alarm", mode = EventOut)
    val Warning = Port[PCA_Types.Warning_Type.Type] (id = 26, name = "wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr_Warning", mode = EventOut)
    val ICE_Alarm_Signal = Port[ICE_Types.Alarm_Signal.Type] (id = 27, name = "wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr_ICE_Alarm_Signal", mode = EventIn)
    val Log_Fault = Port[PCA_Types.Fault_Record_imp] (id = 28, name = "wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr_Log_Fault", mode = EventOut)
    val ICE_Immediate = Port[art.Empty] (id = 29, name = "wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr_ICE_Immediate", mode = EventOut)
    val ICE_Prompt = Port[art.Empty] (id = 30, name = "wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr_ICE_Prompt", mode = EventOut)
    val ICE_Delayed = Port[art.Empty] (id = 31, name = "wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr_ICE_Delayed", mode = EventOut)
    val ICE_Malfunction = Port[art.Empty] (id = 32, name = "wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr_ICE_Malfunction", mode = EventOut)
    val ICE_Reset_Alarm = Port[art.Empty] (id = 33, name = "wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr_ICE_Reset_Alarm", mode = EventIn)
    val Stop_Pump_Completely = Port[art.Empty] (id = 34, name = "wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr_Stop_Pump_Completely", mode = EventOut)
    val Pump_At_KVO_Rate = Port[art.Empty] (id = 35, name = "wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr_Pump_At_KVO_Rate", mode = EventOut)
    val Max_Dose_Warning = Port[art.Empty] (id = 36, name = "wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr_Max_Dose_Warning", mode = EventIn)
    val Hard_Limit_Violation = Port[art.Empty] (id = 37, name = "wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr_Hard_Limit_Violation", mode = EventIn)
    val Empty_Res = Port[art.Empty] (id = 38, name = "wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr_Empty_Res", mode = EventIn)
    val Low_Res = Port[art.Empty] (id = 39, name = "wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr_Low_Res", mode = EventIn)
    val Pump_Hot = Port[art.Empty] (id = 40, name = "wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr_Pump_Hot", mode = EventIn)
    val Upstream_Occlusion = Port[art.Empty] (id = 41, name = "wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr_Upstream_Occlusion", mode = EventIn)
    val Downstream_Occlusion = Port[art.Empty] (id = 42, name = "wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr_Downstream_Occlusion", mode = EventIn)
    val Bubble = Port[art.Empty] (id = 43, name = "wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr_Bubble", mode = EventIn)
    val Prime_Failure = Port[art.Empty] (id = 44, name = "wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr_Prime_Failure", mode = EventIn)
    val CP_Reset_Alarm = Port[art.Empty] (id = 45, name = "wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr_CP_Reset_Alarm", mode = EventIn)
    val Drug_Not_In_Library = Port[art.Empty] (id = 46, name = "wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr_Drug_Not_In_Library", mode = EventIn)
    val Defective_Btty = Port[art.Empty] (id = 47, name = "wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr_Defective_Btty", mode = EventIn)
    val Low_Battery_Warning = Port[art.Empty] (id = 48, name = "wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr_Low_Battery_Warning", mode = EventIn)
    val Voltage_OOR = Port[art.Empty] (id = 49, name = "wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr_Voltage_OOR", mode = EventIn)
    val Basal_Overinfusion = Port[art.Empty] (id = 50, name = "wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr_Basal_Overinfusion", mode = EventIn)
    val Bolus_Overinfusion = Port[art.Empty] (id = 51, name = "wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr_Bolus_Overinfusion", mode = EventIn)
    val Square_Bolus_Overinfusion = Port[art.Empty] (id = 52, name = "wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr_Square_Bolus_Overinfusion", mode = EventIn)
    val Basal_Underinfusion = Port[art.Empty] (id = 53, name = "wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr_Basal_Underinfusion", mode = EventIn)
    val Bolus_Underinfusion = Port[art.Empty] (id = 54, name = "wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr_Bolus_Underinfusion", mode = EventIn)
    val Square_Bolus_Underinfusion = Port[art.Empty] (id = 55, name = "wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr_Square_Bolus_Underinfusion", mode = EventIn)
    val Security_Fault = Port[art.Empty] (id = 56, name = "wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr_Security_Fault", mode = EventIn)

    pca_pump.PCA_Alarm.alarm_thread_imp_pump_safety_alarm_process_alarm_thr_Bridge(
      id = 4,
      name = "wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr",
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
  val wrap_pca_imp_Instance_pump_safety_alarm_process_flow_rate : pca_pump.PCA_Alarm.Flow_Rate_Checker_imp_pump_safety_alarm_process_flow_rate_Bridge = {
    val System_Status = Port[PCA_Types.Status_Type.Type] (id = 57, name = "wrap_pca_imp_Instance_pump_safety_alarm_process_flow_rate_System_Status", mode = DataIn)
    val Infusion_Flow_Rate = Port[PCA_Types.Flow_Rate_imp] (id = 58, name = "wrap_pca_imp_Instance_pump_safety_alarm_process_flow_rate_Infusion_Flow_Rate", mode = DataIn)
    val Upstream_Flow_Rate = Port[PCA_Types.Flow_Rate_imp] (id = 59, name = "wrap_pca_imp_Instance_pump_safety_alarm_process_flow_rate_Upstream_Flow_Rate", mode = DataIn)
    val Downstream_Flow_Rate = Port[PCA_Types.Flow_Rate_imp] (id = 60, name = "wrap_pca_imp_Instance_pump_safety_alarm_process_flow_rate_Downstream_Flow_Rate", mode = DataIn)
    val Basal_Overinfusion = Port[art.Empty] (id = 61, name = "wrap_pca_imp_Instance_pump_safety_alarm_process_flow_rate_Basal_Overinfusion", mode = EventOut)
    val Bolus_Overinfusion = Port[art.Empty] (id = 62, name = "wrap_pca_imp_Instance_pump_safety_alarm_process_flow_rate_Bolus_Overinfusion", mode = EventOut)
    val Square_Bolus_Overinfusion = Port[art.Empty] (id = 63, name = "wrap_pca_imp_Instance_pump_safety_alarm_process_flow_rate_Square_Bolus_Overinfusion", mode = EventOut)
    val Basal_Underinfusion = Port[art.Empty] (id = 64, name = "wrap_pca_imp_Instance_pump_safety_alarm_process_flow_rate_Basal_Underinfusion", mode = EventOut)
    val Bolus_Underinfusion = Port[art.Empty] (id = 65, name = "wrap_pca_imp_Instance_pump_safety_alarm_process_flow_rate_Bolus_Underinfusion", mode = EventOut)
    val Square_Bolus_Underinfusion = Port[art.Empty] (id = 66, name = "wrap_pca_imp_Instance_pump_safety_alarm_process_flow_rate_Square_Bolus_Underinfusion", mode = EventOut)

    pca_pump.PCA_Alarm.Flow_Rate_Checker_imp_pump_safety_alarm_process_flow_rate_Bridge(
      id = 5,
      name = "wrap_pca_imp_Instance_pump_safety_alarm_process_flow_rate",
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
  val wrap_pca_imp_Instance_pump_power_pwr : pca_pump.PCA_Power.power_control_imp_pump_power_pwr_Bridge = {
    val Battery_Voltage = Port[Physical_Types.Voltage_imp] (id = 67, name = "wrap_pca_imp_Instance_pump_power_pwr_Battery_Voltage", mode = DataIn)
    val Battery_Current = Port[Physical_Types.Current_imp] (id = 68, name = "wrap_pca_imp_Instance_pump_power_pwr_Battery_Current", mode = DataIn)
    val Power_Voltage = Port[Physical_Types.Voltage_imp] (id = 69, name = "wrap_pca_imp_Instance_pump_power_pwr_Power_Voltage", mode = DataIn)
    val Using_Battery_Power = Port[Base_Types.Boolean] (id = 70, name = "wrap_pca_imp_Instance_pump_power_pwr_Using_Battery_Power", mode = DataOut)
    val Remaining_Battery_Time = Port[BLESS_Types.Time] (id = 71, name = "wrap_pca_imp_Instance_pump_power_pwr_Remaining_Battery_Time", mode = DataOut)
    val Low_Battery_Warning = Port[art.Empty] (id = 72, name = "wrap_pca_imp_Instance_pump_power_pwr_Low_Battery_Warning", mode = EventOut)
    val Defective_Battery = Port[art.Empty] (id = 73, name = "wrap_pca_imp_Instance_pump_power_pwr_Defective_Battery", mode = EventOut)
    val Voltage_OOR = Port[art.Empty] (id = 74, name = "wrap_pca_imp_Instance_pump_power_pwr_Voltage_OOR", mode = EventOut)

    pca_pump.PCA_Power.power_control_imp_pump_power_pwr_Bridge(
      id = 6,
      name = "wrap_pca_imp_Instance_pump_power_pwr",
      dispatchProtocol = Periodic(period = 60000),
      dispatchTriggers = None(),

      Battery_Voltage = Battery_Voltage,
      Battery_Current = Battery_Current,
      Power_Voltage = Power_Voltage,
      Using_Battery_Power = Using_Battery_Power,
      Remaining_Battery_Time = Remaining_Battery_Time,
      Low_Battery_Warning = Low_Battery_Warning,
      Defective_Battery = Defective_Battery,
      Voltage_OOR = Voltage_OOR
    )
  }
  val wrap_pca_imp_Instance_pump_power_btty : pca_pump.PCA_Power.battery_imp_pump_power_btty_Bridge = {
    val Battery_Voltage = Port[Physical_Types.Voltage_imp] (id = 75, name = "wrap_pca_imp_Instance_pump_power_btty_Battery_Voltage", mode = DataOut)
    val Battery_Current = Port[Physical_Types.Current_imp] (id = 76, name = "wrap_pca_imp_Instance_pump_power_btty_Battery_Current", mode = DataOut)

    pca_pump.PCA_Power.battery_imp_pump_power_btty_Bridge(
      id = 7,
      name = "wrap_pca_imp_Instance_pump_power_btty",
      dispatchProtocol = Periodic(period = 5),
      dispatchTriggers = None(),

      Battery_Voltage = Battery_Voltage,
      Battery_Current = Battery_Current
    )
  }
  val wrap_pca_imp_Instance_pump_power_vcc : pca_pump.PCA_Power.power_supply_imp_pump_power_vcc_Bridge = {
    val Power_Voltage = Port[Physical_Types.Voltage_imp] (id = 77, name = "wrap_pca_imp_Instance_pump_power_vcc_Power_Voltage", mode = DataOut)

    pca_pump.PCA_Power.power_supply_imp_pump_power_vcc_Bridge(
      id = 8,
      name = "wrap_pca_imp_Instance_pump_power_vcc",
      dispatchProtocol = Periodic(period = 5),
      dispatchTriggers = None(),

      Power_Voltage = Power_Voltage
    )
  }
  val wrap_pca_imp_Instance_pump_operation_patient_button : pca_pump.PCA_Mechanical.patient_button_imp_pump_operation_patient_button_Bridge = {
    val Button_Press = Port[art.Empty] (id = 78, name = "wrap_pca_imp_Instance_pump_operation_patient_button_Button_Press", mode = EventIn)
    val Request_Bolus = Port[art.Empty] (id = 79, name = "wrap_pca_imp_Instance_pump_operation_patient_button_Request_Bolus", mode = EventOut)

    pca_pump.PCA_Mechanical.patient_button_imp_pump_operation_patient_button_Bridge(
      id = 9,
      name = "wrap_pca_imp_Instance_pump_operation_patient_button",
      dispatchProtocol = Sporadic(min = 5),
      dispatchTriggers = None(),

      Button_Press = Button_Press,
      Request_Bolus = Request_Bolus
    )
  }
  val wrap_pca_imp_Instance_pump_operation_scanner : pca_pump.PCA_Mechanical.scanner_imp_pump_operation_scanner_Bridge = {
    val Scan_Data = Port[PCA_Types.Scan_Data_Type] (id = 80, name = "wrap_pca_imp_Instance_pump_operation_scanner_Scan_Data", mode = EventOut)
    val Do_Scan = Port[art.Empty] (id = 81, name = "wrap_pca_imp_Instance_pump_operation_scanner_Do_Scan", mode = EventIn)
    val Scan_Done = Port[art.Empty] (id = 82, name = "wrap_pca_imp_Instance_pump_operation_scanner_Scan_Done", mode = EventOut)

    pca_pump.PCA_Mechanical.scanner_imp_pump_operation_scanner_Bridge(
      id = 10,
      name = "wrap_pca_imp_Instance_pump_operation_scanner",
      dispatchProtocol = Sporadic(min = 5),
      dispatchTriggers = None(),

      Scan_Data = Scan_Data,
      Do_Scan = Do_Scan,
      Scan_Done = Scan_Done
    )
  }
  val wrap_pca_imp_Instance_pump_operation_operation_process_drug_library : pca_pump.PCA_Drug_Library.drug_library_thread_imp_pump_operation_operation_process_drug_library_Bridge = {
    val Load_Drug_Library = Port[PCA_Types.Drug_Library] (id = 83, name = "wrap_pca_imp_Instance_pump_operation_operation_process_drug_library_Load_Drug_Library", mode = EventIn)
    val Get_Drug_Record = Port[PCA_Types.Drug_Code_imp] (id = 84, name = "wrap_pca_imp_Instance_pump_operation_operation_process_drug_library_Get_Drug_Record", mode = EventIn)
    val The_Drug_Record = Port[PCA_Types.Drug_Record_imp] (id = 85, name = "wrap_pca_imp_Instance_pump_operation_operation_process_drug_library_The_Drug_Record", mode = EventOut)
    val No_Drug_Found = Port[art.Empty] (id = 86, name = "wrap_pca_imp_Instance_pump_operation_operation_process_drug_library_No_Drug_Found", mode = EventOut)

    pca_pump.PCA_Drug_Library.drug_library_thread_imp_pump_operation_operation_process_drug_library_Bridge(
      id = 11,
      name = "wrap_pca_imp_Instance_pump_operation_operation_process_drug_library",
      dispatchProtocol = Sporadic(min = 5),
      dispatchTriggers = None(),

      Load_Drug_Library = Load_Drug_Library,
      Get_Drug_Record = Get_Drug_Record,
      The_Drug_Record = The_Drug_Record,
      No_Drug_Found = No_Drug_Found
    )
  }
  val wrap_pca_imp_Instance_pump_operation_operation_process_event_logger : pca_pump.PCA_Operation.event_logger_thread_imp_pump_operation_operation_process_event_logger_Bridge = {
    val Log_Event = Port[PCA_Types.Event_Record] (id = 87, name = "wrap_pca_imp_Instance_pump_operation_operation_process_event_logger_Log_Event", mode = EventIn)
    val The_Event_Log = Port[PCA_Types.Event_Log] (id = 88, name = "wrap_pca_imp_Instance_pump_operation_operation_process_event_logger_The_Event_Log", mode = EventOut)
    val Get_Event_Log = Port[art.Empty] (id = 89, name = "wrap_pca_imp_Instance_pump_operation_operation_process_event_logger_Get_Event_Log", mode = EventIn)

    pca_pump.PCA_Operation.event_logger_thread_imp_pump_operation_operation_process_event_logger_Bridge(
      id = 12,
      name = "wrap_pca_imp_Instance_pump_operation_operation_process_event_logger",
      dispatchProtocol = Sporadic(min = 5),
      dispatchTriggers = None(),

      Log_Event = Log_Event,
      The_Event_Log = The_Event_Log,
      Get_Event_Log = Get_Event_Log
    )
  }
  val wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_boss : pca_pump.PCA_Boss.Boss_Thread_imp_pump_operation_operation_process_operation_threads_boss_Bridge = {
    val Display_Message = Port[PCA_Types.Message.Type] (id = 90, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_boss_Display_Message", mode = EventOut)
    val Sound_Type = Port[PCA_Types.Sound.Type] (id = 91, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_boss_Sound_Type", mode = EventOut)
    val Log_Event = Port[PCA_Types.Event_Record] (id = 92, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_boss_Log_Event", mode = EventOut)
    val POST_done = Port[art.Empty] (id = 93, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_boss_POST_done", mode = EventIn)
    val POST_fail = Port[art.Empty] (id = 94, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_boss_POST_fail", mode = EventIn)
    val Stop_Button_Pressed = Port[art.Empty] (id = 95, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_boss_Stop_Button_Pressed", mode = EventIn)
    val Start_Button_Pressed = Port[art.Empty] (id = 96, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_boss_Start_Button_Pressed", mode = EventIn)
    val Do_Scan = Port[art.Empty] (id = 97, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_boss_Do_Scan", mode = EventOut)
    val Scan_Done = Port[art.Empty] (id = 98, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_boss_Scan_Done", mode = EventIn)
    val Authenticate_Clinician = Port[art.Empty] (id = 99, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_boss_Authenticate_Clinician", mode = EventOut)
    val Authenticate_Patient = Port[art.Empty] (id = 100, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_boss_Authenticate_Patient", mode = EventOut)
    val Authenticate_Prescription = Port[art.Empty] (id = 101, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_boss_Authenticate_Prescription", mode = EventOut)
    val Authentication_fail = Port[art.Empty] (id = 102, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_boss_Authentication_fail", mode = EventIn)
    val Authentication_pass = Port[art.Empty] (id = 103, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_boss_Authentication_pass", mode = EventIn)
    val Check_Rx = Port[art.Empty] (id = 104, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_boss_Check_Rx", mode = EventOut)
    val Drug_Not_In_Library = Port[art.Empty] (id = 105, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_boss_Drug_Not_In_Library", mode = EventIn)
    val Hard_Limit_Violated = Port[art.Empty] (id = 106, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_boss_Hard_Limit_Violated", mode = EventIn)
    val Reject_Soft_Limit_Exception = Port[art.Empty] (id = 107, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_boss_Reject_Soft_Limit_Exception", mode = EventIn)
    val Confirm_Soft_Limit_Exception = Port[art.Empty] (id = 108, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_boss_Confirm_Soft_Limit_Exception", mode = EventIn)
    val Rx_Okay = Port[art.Empty] (id = 109, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_boss_Rx_Okay", mode = EventIn)
    val Door_Closed = Port[art.Empty] (id = 110, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_boss_Door_Closed", mode = EventIn)
    val Begin_Priming = Port[art.Empty] (id = 111, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_boss_Begin_Priming", mode = EventOut)
    val End_Priming = Port[art.Empty] (id = 112, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_boss_End_Priming", mode = EventOut)
    val Prime_Failure = Port[art.Empty] (id = 113, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_boss_Prime_Failure", mode = EventOut)
    val Begin_Infusion = Port[art.Empty] (id = 114, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_boss_Begin_Infusion", mode = EventOut)
    val Halt_Infusion = Port[art.Empty] (id = 115, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_boss_Halt_Infusion", mode = EventOut)
    val Turn_Off = Port[art.Empty] (id = 116, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_boss_Turn_Off", mode = EventIn)

    pca_pump.PCA_Boss.Boss_Thread_imp_pump_operation_operation_process_operation_threads_boss_Bridge(
      id = 13,
      name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_boss",
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
  val wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_rate_controller : pca_pump.PCA_Operation_Threads.Rate_Controller_imp_pump_operation_operation_process_operation_threads_rate_controller_Bridge = {
    val Infusion_Flow_Rate = Port[PCA_Types.Flow_Rate_imp] (id = 117, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_rate_controller_Infusion_Flow_Rate", mode = DataOut)
    val Square_Bolus_Rate = Port[PCA_Types.Flow_Rate_imp] (id = 118, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_rate_controller_Square_Bolus_Rate", mode = DataIn)
    val Patient_Bolus_Rate = Port[PCA_Types.Flow_Rate_imp] (id = 119, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_rate_controller_Patient_Bolus_Rate", mode = DataIn)
    val Basal_Rate = Port[PCA_Types.Flow_Rate_imp] (id = 120, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_rate_controller_Basal_Rate", mode = DataIn)
    val VTBI = Port[PCA_Types.Drug_Volume_imp] (id = 121, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_rate_controller_VTBI", mode = DataIn)
    val Door_Open = Port[Base_Types.Boolean] (id = 122, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_rate_controller_Door_Open", mode = DataIn)
    val System_Status = Port[PCA_Types.Status_Type.Type] (id = 123, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_rate_controller_System_Status", mode = EventOut)
    val Alarm = Port[PCA_Types.Alarm_Type.Type] (id = 124, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_rate_controller_Alarm", mode = EventIn)
    val Warning = Port[PCA_Types.Warning_Type.Type] (id = 125, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_rate_controller_Warning", mode = EventIn)
    val CP_Bolus_Duration = Port[ICE_Types.Minute_imp] (id = 126, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_rate_controller_CP_Bolus_Duration", mode = EventIn)
    val Begin_Infusion = Port[art.Empty] (id = 127, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_rate_controller_Begin_Infusion", mode = EventIn)
    val Begin_Priming = Port[art.Empty] (id = 128, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_rate_controller_Begin_Priming", mode = EventIn)
    val End_Priming = Port[art.Empty] (id = 129, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_rate_controller_End_Priming", mode = EventIn)
    val Halt_Infusion = Port[art.Empty] (id = 130, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_rate_controller_Halt_Infusion", mode = EventIn)
    val HW_Detected_Failure = Port[art.Empty] (id = 131, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_rate_controller_HW_Detected_Failure", mode = EventIn)
    val Stop_Pump_Completely = Port[art.Empty] (id = 132, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_rate_controller_Stop_Pump_Completely", mode = EventIn)
    val Pump_At_KVO_Rate = Port[art.Empty] (id = 133, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_rate_controller_Pump_At_KVO_Rate", mode = EventIn)
    val Patient_Request_Not_Too_Soon = Port[art.Empty] (id = 134, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_rate_controller_Patient_Request_Not_Too_Soon", mode = EventIn)
    val Pause_Infusion = Port[art.Empty] (id = 135, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_rate_controller_Pause_Infusion", mode = EventIn)
    val Resume_Infusion = Port[art.Empty] (id = 136, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_rate_controller_Resume_Infusion", mode = EventIn)
    val CP_Clinician_Request_Bolus = Port[art.Empty] (id = 137, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_rate_controller_CP_Clinician_Request_Bolus", mode = EventIn)
    val Near_Max_Drug_Per_Hour = Port[art.Empty] (id = 138, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_rate_controller_Near_Max_Drug_Per_Hour", mode = EventIn)
    val Over_Max_Drug_Per_Hour = Port[art.Empty] (id = 139, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_rate_controller_Over_Max_Drug_Per_Hour", mode = EventIn)
    val ICE_Stop_Pump = Port[art.Empty] (id = 140, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_rate_controller_ICE_Stop_Pump", mode = EventIn)

    pca_pump.PCA_Operation_Threads.Rate_Controller_imp_pump_operation_operation_process_operation_threads_rate_controller_Bridge(
      id = 14,
      name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_rate_controller",
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
  val wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_prescription_checker : pca_pump.PCA_Operation_Threads.Prescription_Checker_imp_pump_operation_operation_process_operation_threads_prescription_checker_Bridge = {
    val Prescription = Port[PCA_Types.Prescription_imp] (id = 141, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_prescription_checker_Prescription", mode = DataIn)
    val VTBI = Port[PCA_Types.Drug_Volume_imp] (id = 142, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_prescription_checker_VTBI", mode = DataOut)
    val Square_Bolus_Rate = Port[PCA_Types.Flow_Rate_imp] (id = 143, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_prescription_checker_Square_Bolus_Rate", mode = DataOut)
    val Patient_Bolus_Rate = Port[PCA_Types.Flow_Rate_imp] (id = 144, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_prescription_checker_Patient_Bolus_Rate", mode = DataOut)
    val Basal_Rate = Port[PCA_Types.Flow_Rate_imp] (id = 145, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_prescription_checker_Basal_Rate", mode = DataOut)
    val Minimum_Time_Between_Bolus = Port[ICE_Types.Minute_imp] (id = 146, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_prescription_checker_Minimum_Time_Between_Bolus", mode = DataOut)
    val Max_Drug_Per_Hour = Port[PCA_Types.Drug_Volume_imp] (id = 147, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_prescription_checker_Max_Drug_Per_Hour", mode = DataOut)
    val Get_Drug_Record = Port[PCA_Types.Drug_Code_imp] (id = 148, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_prescription_checker_Get_Drug_Record", mode = EventOut)
    val The_Drug_Record = Port[PCA_Types.Drug_Record_imp] (id = 149, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_prescription_checker_The_Drug_Record", mode = EventIn)
    val Check_Rx = Port[art.Empty] (id = 150, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_prescription_checker_Check_Rx", mode = EventIn)
    val Rx_Okay = Port[art.Empty] (id = 151, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_prescription_checker_Rx_Okay", mode = EventOut)
    val Drug_Not_In_Library = Port[art.Empty] (id = 152, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_prescription_checker_Drug_Not_In_Library", mode = EventIn)
    val Confirm_Soft_Limit_Exception = Port[art.Empty] (id = 153, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_prescription_checker_Confirm_Soft_Limit_Exception", mode = EventIn)
    val Reject_Soft_Limit_Exception = Port[art.Empty] (id = 154, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_prescription_checker_Reject_Soft_Limit_Exception", mode = EventIn)
    val Soft_Limit_Warning = Port[art.Empty] (id = 155, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_prescription_checker_Soft_Limit_Warning", mode = EventOut)
    val Hard_Limit_Violated = Port[art.Empty] (id = 156, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_prescription_checker_Hard_Limit_Violated", mode = EventOut)

    pca_pump.PCA_Operation_Threads.Prescription_Checker_imp_pump_operation_operation_process_operation_threads_prescription_checker_Bridge(
      id = 15,
      name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_prescription_checker",
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
  val wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_ice_thread : pca_pump.PCA_Operation_Threads.ICE_Thread_imp_pump_operation_operation_process_operation_threads_ice_thread_Bridge = {
    val Infusion_Flow_Rate = Port[PCA_Types.Flow_Rate_imp] (id = 157, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_ice_thread_Infusion_Flow_Rate", mode = DataIn)
    val Patient_Bolus_Rate = Port[PCA_Types.Flow_Rate_imp] (id = 158, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_ice_thread_Patient_Bolus_Rate", mode = DataIn)
    val Square_Bolus_Rate = Port[PCA_Types.Flow_Rate_imp] (id = 159, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_ice_thread_Square_Bolus_Rate", mode = DataIn)
    val Basal_Rate = Port[PCA_Types.Flow_Rate_imp] (id = 160, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_ice_thread_Basal_Rate", mode = DataIn)
    val VTBI = Port[PCA_Types.Drug_Volume_imp] (id = 161, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_ice_thread_VTBI", mode = DataIn)
    val Door_Open = Port[Base_Types.Boolean] (id = 162, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_ice_thread_Door_Open", mode = DataIn)
    val Alarm_Inactivation = Port[ICE_Types.Alarm_Signal.Type] (id = 163, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_ice_thread_Alarm_Inactivation", mode = DataIn)
    val Alarm = Port[PCA_Types.Alarm_Type.Type] (id = 164, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_ice_thread_Alarm", mode = EventIn)
    val Warning = Port[PCA_Types.Warning_Type.Type] (id = 165, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_ice_thread_Warning", mode = EventIn)
    val CP_Bolus_Duration = Port[ICE_Types.Minute_imp] (id = 166, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_ice_thread_CP_Bolus_Duration", mode = EventIn)
    val ICE_Stop_Pump = Port[art.Empty] (id = 167, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_ice_thread_ICE_Stop_Pump", mode = EventOut)
    val Rx_Okay = Port[art.Empty] (id = 168, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_ice_thread_Rx_Okay", mode = EventIn)
    val Patient_Request_Not_Too_Soon = Port[art.Empty] (id = 169, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_ice_thread_Patient_Request_Not_Too_Soon", mode = EventIn)
    val Patient_Request_Too_Soon = Port[art.Empty] (id = 170, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_ice_thread_Patient_Request_Too_Soon", mode = EventIn)
    val HW_Detected_Failure = Port[art.Empty] (id = 171, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_ice_thread_HW_Detected_Failure", mode = EventIn)
    val Stop_Pump_Completely = Port[art.Empty] (id = 172, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_ice_thread_Stop_Pump_Completely", mode = EventIn)
    val Pump_At_KVO_Rate = Port[art.Empty] (id = 173, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_ice_thread_Pump_At_KVO_Rate", mode = EventIn)
    val CP_Clinician_Request_Bolus = Port[art.Empty] (id = 174, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_ice_thread_CP_Clinician_Request_Bolus", mode = EventIn)
    val Halt_Infusion = Port[art.Empty] (id = 175, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_ice_thread_Halt_Infusion", mode = EventIn)
    val Begin_Infusion = Port[art.Empty] (id = 176, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_ice_thread_Begin_Infusion", mode = EventIn)
    val Near_Max_Drug_Per_Hour = Port[art.Empty] (id = 177, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_ice_thread_Near_Max_Drug_Per_Hour", mode = EventIn)
    val Over_Max_Drug_Per_Hour = Port[art.Empty] (id = 178, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_ice_thread_Over_Max_Drug_Per_Hour", mode = EventIn)

    pca_pump.PCA_Operation_Threads.ICE_Thread_imp_pump_operation_operation_process_operation_threads_ice_thread_Bridge(
      id = 16,
      name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_ice_thread",
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
  val wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_max_drug_watcher : pca_pump.PCA_Operation_Threads.Max_Drug_Per_Hour_Watcher_imp_pump_operation_operation_process_operation_threads_max_drug_watcher_Bridge = {
    val Infusion_Flow_Rate = Port[PCA_Types.Flow_Rate_imp] (id = 179, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_max_drug_watcher_Infusion_Flow_Rate", mode = DataIn)
    val Max_Drug_Per_Hour = Port[PCA_Types.Drug_Volume_imp] (id = 180, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_max_drug_watcher_Max_Drug_Per_Hour", mode = DataIn)
    val Near_Max_Drug_Per_Hour = Port[art.Empty] (id = 181, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_max_drug_watcher_Near_Max_Drug_Per_Hour", mode = EventOut)
    val Over_Max_Drug_Per_Hour = Port[art.Empty] (id = 182, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_max_drug_watcher_Over_Max_Drug_Per_Hour", mode = EventOut)

    pca_pump.PCA_Operation_Threads.Max_Drug_Per_Hour_Watcher_imp_pump_operation_operation_process_operation_threads_max_drug_watcher_Bridge(
      id = 17,
      name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_max_drug_watcher",
      dispatchProtocol = Periodic(period = 1000),
      dispatchTriggers = None(),

      Infusion_Flow_Rate = Infusion_Flow_Rate,
      Max_Drug_Per_Hour = Max_Drug_Per_Hour,
      Near_Max_Drug_Per_Hour = Near_Max_Drug_Per_Hour,
      Over_Max_Drug_Per_Hour = Over_Max_Drug_Per_Hour
    )
  }
  val wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_patient_bolus_checker : pca_pump.PCA_Operation_Threads.Patient_Bolus_Checker_imp_pump_operation_operation_process_operation_threads_patient_bolus_checker_Bridge = {
    val Minimum_Time_Between_Bolus = Port[ICE_Types.Minute_imp] (id = 183, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_patient_bolus_checker_Minimum_Time_Between_Bolus", mode = DataIn)
    val Patient_Button_Request = Port[art.Empty] (id = 184, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_patient_bolus_checker_Patient_Button_Request", mode = EventIn)
    val Patient_Request_Not_Too_Soon = Port[art.Empty] (id = 185, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_patient_bolus_checker_Patient_Request_Not_Too_Soon", mode = EventOut)
    val Patient_Request_Too_Soon = Port[art.Empty] (id = 186, name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_patient_bolus_checker_Patient_Request_Too_Soon", mode = EventOut)

    pca_pump.PCA_Operation_Threads.Patient_Bolus_Checker_imp_pump_operation_operation_process_operation_threads_patient_bolus_checker_Bridge(
      id = 18,
      name = "wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_patient_bolus_checker",
      dispatchProtocol = Sporadic(min = 5),
      dispatchTriggers = None(),

      Minimum_Time_Between_Bolus = Minimum_Time_Between_Bolus,
      Patient_Button_Request = Patient_Button_Request,
      Patient_Request_Not_Too_Soon = Patient_Request_Not_Too_Soon,
      Patient_Request_Too_Soon = Patient_Request_Too_Soon
    )
  }
  val wrap_pca_imp_Instance_pump_operation_security_subsystem_security_process_security_thread : pca_pump.PCA_Security.Security_Thread_imp_pump_operation_security_subsystem_security_process_security_thread_Bridge = {
    val Clinician_Name = Port[Base_Types.String] (id = 187, name = "wrap_pca_imp_Instance_pump_operation_security_subsystem_security_process_security_thread_Clinician_Name", mode = DataOut)
    val Patient_Name = Port[Base_Types.String] (id = 188, name = "wrap_pca_imp_Instance_pump_operation_security_subsystem_security_process_security_thread_Patient_Name", mode = DataOut)
    val Prescription = Port[PCA_Types.Prescription_imp] (id = 189, name = "wrap_pca_imp_Instance_pump_operation_security_subsystem_security_process_security_thread_Prescription", mode = DataOut)
    val Scan_Data = Port[PCA_Types.Scan_Data_Type] (id = 190, name = "wrap_pca_imp_Instance_pump_operation_security_subsystem_security_process_security_thread_Scan_Data", mode = EventIn)
    val Authenticate_Clinician = Port[art.Empty] (id = 191, name = "wrap_pca_imp_Instance_pump_operation_security_subsystem_security_process_security_thread_Authenticate_Clinician", mode = EventIn)
    val Authenticate_Patient = Port[art.Empty] (id = 192, name = "wrap_pca_imp_Instance_pump_operation_security_subsystem_security_process_security_thread_Authenticate_Patient", mode = EventIn)
    val Authenticate_Prescription = Port[art.Empty] (id = 193, name = "wrap_pca_imp_Instance_pump_operation_security_subsystem_security_process_security_thread_Authenticate_Prescription", mode = EventIn)
    val Authentication_fail = Port[art.Empty] (id = 194, name = "wrap_pca_imp_Instance_pump_operation_security_subsystem_security_process_security_thread_Authentication_fail", mode = EventOut)
    val Authentication_pass = Port[art.Empty] (id = 195, name = "wrap_pca_imp_Instance_pump_operation_security_subsystem_security_process_security_thread_Authentication_pass", mode = EventOut)
    val Security_Fault = Port[art.Empty] (id = 196, name = "wrap_pca_imp_Instance_pump_operation_security_subsystem_security_process_security_thread_Security_Fault", mode = EventOut)

    pca_pump.PCA_Security.Security_Thread_imp_pump_operation_security_subsystem_security_process_security_thread_Bridge(
      id = 19,
      name = "wrap_pca_imp_Instance_pump_operation_security_subsystem_security_process_security_thread",
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
  val wrap_pca_imp_Instance_pump_operation_control_panel_display : pca_pump.PCA_Control_Panel.pca_screen_imp_pump_operation_control_panel_display_Bridge = {
    val Image = Port[PCA_Types.Image] (id = 197, name = "wrap_pca_imp_Instance_pump_operation_control_panel_display_Image", mode = DataIn)
    val LightToEye = Port[Base_Types.Boolean] (id = 198, name = "wrap_pca_imp_Instance_pump_operation_control_panel_display_LightToEye", mode = DataOut)
    val Touch = Port[PCA_Types.Touch] (id = 199, name = "wrap_pca_imp_Instance_pump_operation_control_panel_display_Touch", mode = EventOut)
    val Finger_Press = Port[Base_Types.Boolean] (id = 200, name = "wrap_pca_imp_Instance_pump_operation_control_panel_display_Finger_Press", mode = EventIn)

    pca_pump.PCA_Control_Panel.pca_screen_imp_pump_operation_control_panel_display_Bridge(
      id = 20,
      name = "wrap_pca_imp_Instance_pump_operation_control_panel_display",
      dispatchProtocol = Periodic(period = 1),
      dispatchTriggers = None(),

      Image = Image,
      LightToEye = LightToEye,
      Touch = Touch,
      Finger_Press = Finger_Press
    )
  }
  val wrap_pca_imp_Instance_pump_operation_control_panel_audible : pca_pump.PCA_Control_Panel.pca_speaker_imp_pump_operation_control_panel_audible_Bridge = {
    val AudioSignal = Port[PCA_Types.Sound.Type] (id = 201, name = "wrap_pca_imp_Instance_pump_operation_control_panel_audible_AudioSignal", mode = DataIn)
    val Sound = Port[PCA_Types.Sound.Type] (id = 202, name = "wrap_pca_imp_Instance_pump_operation_control_panel_audible_Sound", mode = DataOut)

    pca_pump.PCA_Control_Panel.pca_speaker_imp_pump_operation_control_panel_audible_Bridge(
      id = 21,
      name = "wrap_pca_imp_Instance_pump_operation_control_panel_audible",
      dispatchProtocol = Periodic(period = 5),
      dispatchTriggers = None(),

      AudioSignal = AudioSignal,
      Sound = Sound
    )
  }
  val wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread : pca_pump.PCA_Control_Panel.ui_thread_imp_pump_operation_control_panel_ui_process_ui_thread_Bridge = {
    val Image = Port[PCA_Types.Image] (id = 203, name = "wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread_Image", mode = DataOut)
    val AudioSignal = Port[PCA_Types.Sound.Type] (id = 204, name = "wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread_AudioSignal", mode = DataOut)
    val Alarm_Inactivation = Port[ICE_Types.Alarm_Signal.Type] (id = 205, name = "wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread_Alarm_Inactivation", mode = DataOut)
    val Remaining_Battery_Time = Port[BLESS_Types.Time] (id = 206, name = "wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread_Remaining_Battery_Time", mode = DataIn)
    val Using_Battery_Power = Port[Base_Types.Boolean] (id = 207, name = "wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread_Using_Battery_Power", mode = DataIn)
    val Prescription = Port[PCA_Types.Prescription_imp] (id = 208, name = "wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread_Prescription", mode = DataIn)
    val Infusion_Flow_Rate = Port[PCA_Types.Flow_Rate_imp] (id = 209, name = "wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread_Infusion_Flow_Rate", mode = DataIn)
    val Clinician_Name = Port[Base_Types.String] (id = 210, name = "wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread_Clinician_Name", mode = DataIn)
    val Patient_Name = Port[Base_Types.String] (id = 211, name = "wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread_Patient_Name", mode = DataIn)
    val Touch = Port[PCA_Types.Touch] (id = 212, name = "wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread_Touch", mode = EventIn)
    val Alarm = Port[PCA_Types.Alarm_Type.Type] (id = 213, name = "wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread_Alarm", mode = EventIn)
    val Warning = Port[PCA_Types.Warning_Type.Type] (id = 214, name = "wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread_Warning", mode = EventIn)
    val System_Status = Port[PCA_Types.Status_Type.Type] (id = 215, name = "wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread_System_Status", mode = EventIn)
    val Display_Message = Port[PCA_Types.Message.Type] (id = 216, name = "wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread_Display_Message", mode = EventIn)
    val Sound_Type = Port[PCA_Types.Sound.Type] (id = 217, name = "wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread_Sound_Type", mode = EventIn)
    val Bolus_Duration = Port[ICE_Types.Minute_imp] (id = 218, name = "wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread_Bolus_Duration", mode = EventOut)
    val CP_Reset_Alarm = Port[art.Empty] (id = 219, name = "wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread_CP_Reset_Alarm", mode = EventOut)
    val Low_Battery_Warning = Port[art.Empty] (id = 220, name = "wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread_Low_Battery_Warning", mode = EventIn)
    val Hard_Limit_Violated = Port[art.Empty] (id = 221, name = "wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread_Hard_Limit_Violated", mode = EventIn)
    val Soft_Limit_Warning = Port[art.Empty] (id = 222, name = "wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread_Soft_Limit_Warning", mode = EventIn)
    val Confirm_Soft_Limit_Exception = Port[art.Empty] (id = 223, name = "wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread_Confirm_Soft_Limit_Exception", mode = EventOut)
    val Reject_Soft_Limit_Exception = Port[art.Empty] (id = 224, name = "wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread_Reject_Soft_Limit_Exception", mode = EventOut)
    val Stop_Button_Pressed = Port[art.Empty] (id = 225, name = "wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread_Stop_Button_Pressed", mode = EventOut)
    val Start_Button_Pressed = Port[art.Empty] (id = 226, name = "wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread_Start_Button_Pressed", mode = EventOut)
    val Clinician_Request_Bolus = Port[art.Empty] (id = 227, name = "wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread_Clinician_Request_Bolus", mode = EventOut)
    val Pause_Infusion = Port[art.Empty] (id = 228, name = "wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread_Pause_Infusion", mode = EventOut)
    val Resume_Infusion = Port[art.Empty] (id = 229, name = "wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread_Resume_Infusion", mode = EventOut)
    val Turn_Off = Port[art.Empty] (id = 230, name = "wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread_Turn_Off", mode = EventOut)
    val Patient_Request_Not_Too_Soon = Port[art.Empty] (id = 231, name = "wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread_Patient_Request_Not_Too_Soon", mode = EventIn)
    val Patient_Request_Too_Soon = Port[art.Empty] (id = 232, name = "wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread_Patient_Request_Too_Soon", mode = EventIn)

    pca_pump.PCA_Control_Panel.ui_thread_imp_pump_operation_control_panel_ui_process_ui_thread_Bridge(
      id = 22,
      name = "wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread",
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
  val wrap_pca_imp_Instance_pump_fluid_mech_pump : pca_pump.PCA_Mechanical.pump_imp_pump_fluid_mech_pump_Bridge = {
    val Drug_Intake = Port[Physical_Types.Fluid_Flow_imp] (id = 233, name = "wrap_pca_imp_Instance_pump_fluid_mech_pump_Drug_Intake", mode = DataIn)
    val Rate = Port[PCA_Types.Flow_Rate_imp] (id = 234, name = "wrap_pca_imp_Instance_pump_fluid_mech_pump_Rate", mode = DataIn)
    val Drug_Outlet = Port[Physical_Types.Fluid_Flow_imp] (id = 235, name = "wrap_pca_imp_Instance_pump_fluid_mech_pump_Drug_Outlet", mode = DataOut)
    val Halt = Port[art.Empty] (id = 236, name = "wrap_pca_imp_Instance_pump_fluid_mech_pump_Halt", mode = EventIn)
    val Pump_Too_Hot = Port[art.Empty] (id = 237, name = "wrap_pca_imp_Instance_pump_fluid_mech_pump_Pump_Too_Hot", mode = EventOut)

    pca_pump.PCA_Mechanical.pump_imp_pump_fluid_mech_pump_Bridge(
      id = 23,
      name = "wrap_pca_imp_Instance_pump_fluid_mech_pump",
      dispatchProtocol = Sporadic(min = 5),
      dispatchTriggers = None(),

      Drug_Intake = Drug_Intake,
      Rate = Rate,
      Drug_Outlet = Drug_Outlet,
      Halt = Halt,
      Pump_Too_Hot = Pump_Too_Hot
    )
  }
  val wrap_pca_imp_Instance_pump_fluid_upstream_mon : pca_pump.PCA_Mechanical.upstream_monitor_imp_pump_fluid_upstream_mon_Bridge = {
    val Drug_Intake = Port[Physical_Types.Fluid_Flow_imp] (id = 238, name = "wrap_pca_imp_Instance_pump_fluid_upstream_mon_Drug_Intake", mode = DataIn)
    val Drug_Outlet = Port[Physical_Types.Fluid_Flow_imp] (id = 239, name = "wrap_pca_imp_Instance_pump_fluid_upstream_mon_Drug_Outlet", mode = DataOut)
    val Upstream_Flow_Rate = Port[PCA_Types.Flow_Rate_imp] (id = 240, name = "wrap_pca_imp_Instance_pump_fluid_upstream_mon_Upstream_Flow_Rate", mode = DataOut)
    val Occlusion = Port[art.Empty] (id = 241, name = "wrap_pca_imp_Instance_pump_fluid_upstream_mon_Occlusion", mode = EventOut)

    pca_pump.PCA_Mechanical.upstream_monitor_imp_pump_fluid_upstream_mon_Bridge(
      id = 24,
      name = "wrap_pca_imp_Instance_pump_fluid_upstream_mon",
      dispatchProtocol = Periodic(period = 5),
      dispatchTriggers = None(),

      Drug_Intake = Drug_Intake,
      Drug_Outlet = Drug_Outlet,
      Upstream_Flow_Rate = Upstream_Flow_Rate,
      Occlusion = Occlusion
    )
  }
  val wrap_pca_imp_Instance_pump_fluid_downstream_mon : pca_pump.PCA_Mechanical.downstream_monitor_imp_pump_fluid_downstream_mon_Bridge = {
    val Drug_Intake = Port[Physical_Types.Fluid_Flow_imp] (id = 242, name = "wrap_pca_imp_Instance_pump_fluid_downstream_mon_Drug_Intake", mode = DataIn)
    val Drug_Outlet = Port[Physical_Types.Fluid_Flow_imp] (id = 243, name = "wrap_pca_imp_Instance_pump_fluid_downstream_mon_Drug_Outlet", mode = DataOut)
    val Downstream_Flow_Rate = Port[PCA_Types.Flow_Rate_imp] (id = 244, name = "wrap_pca_imp_Instance_pump_fluid_downstream_mon_Downstream_Flow_Rate", mode = DataOut)
    val Occlusion = Port[art.Empty] (id = 245, name = "wrap_pca_imp_Instance_pump_fluid_downstream_mon_Occlusion", mode = EventOut)
    val Bubble = Port[art.Empty] (id = 246, name = "wrap_pca_imp_Instance_pump_fluid_downstream_mon_Bubble", mode = EventOut)

    pca_pump.PCA_Mechanical.downstream_monitor_imp_pump_fluid_downstream_mon_Bridge(
      id = 25,
      name = "wrap_pca_imp_Instance_pump_fluid_downstream_mon",
      dispatchProtocol = Periodic(period = 5),
      dispatchTriggers = None(),

      Drug_Intake = Drug_Intake,
      Drug_Outlet = Drug_Outlet,
      Downstream_Flow_Rate = Downstream_Flow_Rate,
      Occlusion = Occlusion,
      Bubble = Bubble
    )
  }
  val wrap_pca_imp_Instance_pump_fluid_reservoir : pca_pump.PCA_Mechanical.drug_reservoir_imp_pump_fluid_reservoir_Bridge = {
    val Fill_Reservoir = Port[Physical_Types.Fluid_Volume_imp] (id = 247, name = "wrap_pca_imp_Instance_pump_fluid_reservoir_Fill_Reservoir", mode = DataIn)
    val Drug_Outlet = Port[Physical_Types.Fluid_Flow_imp] (id = 248, name = "wrap_pca_imp_Instance_pump_fluid_reservoir_Drug_Outlet", mode = DataOut)
    val Door_Open = Port[Base_Types.Boolean] (id = 249, name = "wrap_pca_imp_Instance_pump_fluid_reservoir_Door_Open", mode = DataOut)
    val Door_Closed = Port[art.Empty] (id = 250, name = "wrap_pca_imp_Instance_pump_fluid_reservoir_Door_Closed", mode = EventOut)
    val Low_Reservoir = Port[art.Empty] (id = 251, name = "wrap_pca_imp_Instance_pump_fluid_reservoir_Low_Reservoir", mode = EventOut)
    val Empty_Reservoir = Port[art.Empty] (id = 252, name = "wrap_pca_imp_Instance_pump_fluid_reservoir_Empty_Reservoir", mode = EventOut)

    pca_pump.PCA_Mechanical.drug_reservoir_imp_pump_fluid_reservoir_Bridge(
      id = 26,
      name = "wrap_pca_imp_Instance_pump_fluid_reservoir",
      dispatchProtocol = Periodic(period = 5),
      dispatchTriggers = None(),

      Fill_Reservoir = Fill_Reservoir,
      Drug_Outlet = Drug_Outlet,
      Door_Open = Door_Open,
      Door_Closed = Door_Closed,
      Low_Reservoir = Low_Reservoir,
      Empty_Reservoir = Empty_Reservoir
    )
  }

  val ad : ArchitectureDescription = {

    ArchitectureDescription(
      components = MSZ (wrap_pca_imp_Instance_maint, wrap_pca_imp_Instance_pump_safety_error_detect, wrap_pca_imp_Instance_pump_safety_fault_log, wrap_pca_imp_Instance_pump_safety_led, wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr, wrap_pca_imp_Instance_pump_safety_alarm_process_flow_rate, wrap_pca_imp_Instance_pump_power_pwr, wrap_pca_imp_Instance_pump_power_btty, wrap_pca_imp_Instance_pump_power_vcc, wrap_pca_imp_Instance_pump_operation_patient_button, wrap_pca_imp_Instance_pump_operation_scanner, wrap_pca_imp_Instance_pump_operation_operation_process_drug_library, wrap_pca_imp_Instance_pump_operation_operation_process_event_logger, wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_boss, wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_rate_controller, wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_prescription_checker, wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_ice_thread, wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_max_drug_watcher, wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_patient_bolus_checker, wrap_pca_imp_Instance_pump_operation_security_subsystem_security_process_security_thread, wrap_pca_imp_Instance_pump_operation_control_panel_display, wrap_pca_imp_Instance_pump_operation_control_panel_audible, wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread, wrap_pca_imp_Instance_pump_fluid_mech_pump, wrap_pca_imp_Instance_pump_fluid_upstream_mon, wrap_pca_imp_Instance_pump_fluid_downstream_mon, wrap_pca_imp_Instance_pump_fluid_reservoir),

      connections = ISZ (Connection(from = wrap_pca_imp_Instance_pump_safety_alarm_process_flow_rate.Basal_Overinfusion, to = wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr.Basal_Overinfusion),
                         Connection(from = wrap_pca_imp_Instance_pump_safety_alarm_process_flow_rate.Bolus_Overinfusion, to = wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr.Bolus_Overinfusion),
                         Connection(from = wrap_pca_imp_Instance_pump_safety_alarm_process_flow_rate.Square_Bolus_Overinfusion, to = wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr.Square_Bolus_Overinfusion),
                         Connection(from = wrap_pca_imp_Instance_pump_safety_alarm_process_flow_rate.Basal_Underinfusion, to = wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr.Basal_Underinfusion),
                         Connection(from = wrap_pca_imp_Instance_pump_safety_alarm_process_flow_rate.Bolus_Underinfusion, to = wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr.Bolus_Underinfusion),
                         Connection(from = wrap_pca_imp_Instance_pump_safety_alarm_process_flow_rate.Square_Bolus_Underinfusion, to = wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr.Square_Bolus_Underinfusion),
                         Connection(from = wrap_pca_imp_Instance_pump_safety_error_detect.POST_Failure, to = wrap_pca_imp_Instance_pump_safety_fault_log.POST_Failure),
                         Connection(from = wrap_pca_imp_Instance_pump_safety_error_detect.RAM_Failure, to = wrap_pca_imp_Instance_pump_safety_fault_log.RAM_Failure),
                         Connection(from = wrap_pca_imp_Instance_pump_safety_error_detect.ROM_failure, to = wrap_pca_imp_Instance_pump_safety_fault_log.ROM_Failure),
                         Connection(from = wrap_pca_imp_Instance_pump_safety_error_detect.CPU_Failure, to = wrap_pca_imp_Instance_pump_safety_fault_log.CPU_Failure),
                         Connection(from = wrap_pca_imp_Instance_pump_safety_error_detect.Thread_Monitor_Failure, to = wrap_pca_imp_Instance_pump_safety_fault_log.Thread_Monitor_Failure),
                         Connection(from = wrap_pca_imp_Instance_pump_safety_error_detect.HW_Detected_Failure, to = wrap_pca_imp_Instance_pump_safety_led.Illuminate),
                         Connection(from = wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr.Log_Fault, to = wrap_pca_imp_Instance_pump_safety_fault_log.Log_Fault),
                         Connection(from = wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr.Stop_Pump_Completely, to = wrap_pca_imp_Instance_pump_safety_error_detect.Software_Stop_Pump),
                         Connection(from = wrap_pca_imp_Instance_pump_power_btty.Battery_Voltage, to = wrap_pca_imp_Instance_pump_power_pwr.Battery_Voltage),
                         Connection(from = wrap_pca_imp_Instance_pump_power_btty.Battery_Current, to = wrap_pca_imp_Instance_pump_power_pwr.Battery_Current),
                         Connection(from = wrap_pca_imp_Instance_pump_power_vcc.Power_Voltage, to = wrap_pca_imp_Instance_pump_power_pwr.Power_Voltage),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_boss.Check_Rx, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_prescription_checker.Check_Rx),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_boss.Begin_Priming, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_rate_controller.Begin_Priming),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_boss.End_Priming, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_rate_controller.End_Priming),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_boss.Begin_Infusion, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_rate_controller.Begin_Infusion),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_boss.Begin_Infusion, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_ice_thread.Begin_Infusion),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_boss.Halt_Infusion, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_rate_controller.Halt_Infusion),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_boss.Halt_Infusion, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_ice_thread.Halt_Infusion),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_rate_controller.Infusion_Flow_Rate, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_max_drug_watcher.Infusion_Flow_Rate),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_rate_controller.Infusion_Flow_Rate, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_ice_thread.Infusion_Flow_Rate),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_prescription_checker.VTBI, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_rate_controller.VTBI),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_prescription_checker.VTBI, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_ice_thread.VTBI),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_prescription_checker.Square_Bolus_Rate, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_rate_controller.Square_Bolus_Rate),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_prescription_checker.Square_Bolus_Rate, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_ice_thread.Square_Bolus_Rate),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_prescription_checker.Patient_Bolus_Rate, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_rate_controller.Patient_Bolus_Rate),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_prescription_checker.Patient_Bolus_Rate, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_ice_thread.Patient_Bolus_Rate),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_prescription_checker.Basal_Rate, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_rate_controller.Basal_Rate),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_prescription_checker.Basal_Rate, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_ice_thread.Basal_Rate),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_prescription_checker.Minimum_Time_Between_Bolus, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_patient_bolus_checker.Minimum_Time_Between_Bolus),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_prescription_checker.Max_Drug_Per_Hour, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_max_drug_watcher.Max_Drug_Per_Hour),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_prescription_checker.Rx_Okay, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_boss.Rx_Okay),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_prescription_checker.Rx_Okay, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_ice_thread.Rx_Okay),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_prescription_checker.Hard_Limit_Violated, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_boss.Hard_Limit_Violated),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_ice_thread.ICE_Stop_Pump, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_rate_controller.ICE_Stop_Pump),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_max_drug_watcher.Near_Max_Drug_Per_Hour, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_rate_controller.Near_Max_Drug_Per_Hour),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_max_drug_watcher.Near_Max_Drug_Per_Hour, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_ice_thread.Near_Max_Drug_Per_Hour),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_max_drug_watcher.Over_Max_Drug_Per_Hour, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_rate_controller.Over_Max_Drug_Per_Hour),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_max_drug_watcher.Over_Max_Drug_Per_Hour, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_ice_thread.Over_Max_Drug_Per_Hour),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_patient_bolus_checker.Patient_Request_Not_Too_Soon, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_rate_controller.Patient_Request_Not_Too_Soon),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_patient_bolus_checker.Patient_Request_Not_Too_Soon, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_ice_thread.Patient_Request_Not_Too_Soon),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_patient_bolus_checker.Patient_Request_Too_Soon, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_ice_thread.Patient_Request_Too_Soon),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_operation_process_drug_library.The_Drug_Record, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_prescription_checker.The_Drug_Record),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_operation_process_drug_library.No_Drug_Found, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_boss.Drug_Not_In_Library),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_operation_process_drug_library.No_Drug_Found, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_prescription_checker.Drug_Not_In_Library),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_boss.Log_Event, to = wrap_pca_imp_Instance_pump_operation_operation_process_event_logger.Log_Event),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_prescription_checker.Get_Drug_Record, to = wrap_pca_imp_Instance_pump_operation_operation_process_drug_library.Get_Drug_Record),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_control_panel_display.Touch, to = wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread.Touch),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread.Image, to = wrap_pca_imp_Instance_pump_operation_control_panel_display.Image),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread.AudioSignal, to = wrap_pca_imp_Instance_pump_operation_control_panel_audible.AudioSignal),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_patient_button.Request_Bolus, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_patient_bolus_checker.Patient_Button_Request),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_scanner.Scan_Data, to = wrap_pca_imp_Instance_pump_operation_security_subsystem_security_process_security_thread.Scan_Data),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_scanner.Scan_Done, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_boss.Scan_Done),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_boss.Display_Message, to = wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread.Display_Message),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_boss.Sound_Type, to = wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread.Sound_Type),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_boss.Do_Scan, to = wrap_pca_imp_Instance_pump_operation_scanner.Do_Scan),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_boss.Authenticate_Clinician, to = wrap_pca_imp_Instance_pump_operation_security_subsystem_security_process_security_thread.Authenticate_Clinician),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_boss.Authenticate_Patient, to = wrap_pca_imp_Instance_pump_operation_security_subsystem_security_process_security_thread.Authenticate_Patient),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_boss.Authenticate_Prescription, to = wrap_pca_imp_Instance_pump_operation_security_subsystem_security_process_security_thread.Authenticate_Prescription),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_rate_controller.Infusion_Flow_Rate, to = wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread.Infusion_Flow_Rate),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_rate_controller.System_Status, to = wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread.System_Status),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_prescription_checker.Soft_Limit_Warning, to = wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread.Soft_Limit_Warning),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_prescription_checker.Hard_Limit_Violated, to = wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread.Hard_Limit_Violated),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_patient_bolus_checker.Patient_Request_Not_Too_Soon, to = wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread.Patient_Request_Not_Too_Soon),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_patient_bolus_checker.Patient_Request_Too_Soon, to = wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread.Patient_Request_Too_Soon),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_security_subsystem_security_process_security_thread.Clinician_Name, to = wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread.Clinician_Name),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_security_subsystem_security_process_security_thread.Patient_Name, to = wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread.Patient_Name),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_security_subsystem_security_process_security_thread.Prescription, to = wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread.Prescription),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_security_subsystem_security_process_security_thread.Prescription, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_prescription_checker.Prescription),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_security_subsystem_security_process_security_thread.Authentication_fail, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_boss.Authentication_fail),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_security_subsystem_security_process_security_thread.Authentication_pass, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_boss.Authentication_pass),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread.Alarm_Inactivation, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_ice_thread.Alarm_Inactivation),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread.Bolus_Duration, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_rate_controller.CP_Bolus_Duration),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread.Bolus_Duration, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_ice_thread.CP_Bolus_Duration),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread.Confirm_Soft_Limit_Exception, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_boss.Confirm_Soft_Limit_Exception),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread.Confirm_Soft_Limit_Exception, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_prescription_checker.Confirm_Soft_Limit_Exception),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread.Reject_Soft_Limit_Exception, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_boss.Reject_Soft_Limit_Exception),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread.Reject_Soft_Limit_Exception, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_prescription_checker.Reject_Soft_Limit_Exception),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread.Stop_Button_Pressed, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_boss.Stop_Button_Pressed),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread.Start_Button_Pressed, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_boss.Start_Button_Pressed),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread.Clinician_Request_Bolus, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_rate_controller.CP_Clinician_Request_Bolus),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread.Clinician_Request_Bolus, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_ice_thread.CP_Clinician_Request_Bolus),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread.Pause_Infusion, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_rate_controller.Pause_Infusion),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread.Resume_Infusion, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_rate_controller.Resume_Infusion),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread.Turn_Off, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_boss.Turn_Off),
                         Connection(from = wrap_pca_imp_Instance_pump_fluid_mech_pump.Drug_Outlet, to = wrap_pca_imp_Instance_pump_fluid_downstream_mon.Drug_Intake),
                         Connection(from = wrap_pca_imp_Instance_pump_fluid_upstream_mon.Drug_Outlet, to = wrap_pca_imp_Instance_pump_fluid_mech_pump.Drug_Intake),
                         Connection(from = wrap_pca_imp_Instance_pump_fluid_reservoir.Drug_Outlet, to = wrap_pca_imp_Instance_pump_fluid_upstream_mon.Drug_Intake),
                         Connection(from = wrap_pca_imp_Instance_pump_safety_error_detect.Stop_Pump_Completely, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_rate_controller.Stop_Pump_Completely),
                         Connection(from = wrap_pca_imp_Instance_pump_safety_error_detect.Stop_Pump_Completely, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_ice_thread.Stop_Pump_Completely),
                         Connection(from = wrap_pca_imp_Instance_pump_safety_error_detect.Stop_Pump_Completely, to = wrap_pca_imp_Instance_pump_fluid_mech_pump.Halt),
                         Connection(from = wrap_pca_imp_Instance_pump_safety_error_detect.POST_Failure, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_boss.POST_fail),
                         Connection(from = wrap_pca_imp_Instance_pump_safety_error_detect.POST_Done, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_boss.POST_done),
                         Connection(from = wrap_pca_imp_Instance_pump_safety_error_detect.HW_Detected_Failure, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_rate_controller.HW_Detected_Failure),
                         Connection(from = wrap_pca_imp_Instance_pump_safety_error_detect.HW_Detected_Failure, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_ice_thread.HW_Detected_Failure),
                         Connection(from = wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr.Alarm, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_rate_controller.Alarm),
                         Connection(from = wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr.Alarm, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_ice_thread.Alarm),
                         Connection(from = wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr.Alarm, to = wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread.Alarm),
                         Connection(from = wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr.Warning, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_rate_controller.Warning),
                         Connection(from = wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr.Warning, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_ice_thread.Warning),
                         Connection(from = wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr.Warning, to = wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread.Warning),
                         Connection(from = wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr.Pump_At_KVO_Rate, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_rate_controller.Pump_At_KVO_Rate),
                         Connection(from = wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr.Pump_At_KVO_Rate, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_ice_thread.Pump_At_KVO_Rate),
                         Connection(from = wrap_pca_imp_Instance_pump_power_pwr.Using_Battery_Power, to = wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread.Using_Battery_Power),
                         Connection(from = wrap_pca_imp_Instance_pump_power_pwr.Remaining_Battery_Time, to = wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread.Remaining_Battery_Time),
                         Connection(from = wrap_pca_imp_Instance_pump_power_pwr.Low_Battery_Warning, to = wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr.Low_Battery_Warning),
                         Connection(from = wrap_pca_imp_Instance_pump_power_pwr.Low_Battery_Warning, to = wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread.Low_Battery_Warning),
                         Connection(from = wrap_pca_imp_Instance_pump_power_pwr.Defective_Battery, to = wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr.Defective_Btty),
                         Connection(from = wrap_pca_imp_Instance_pump_power_pwr.Voltage_OOR, to = wrap_pca_imp_Instance_pump_safety_fault_log.Voltage_OOR),
                         Connection(from = wrap_pca_imp_Instance_pump_power_pwr.Voltage_OOR, to = wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr.Voltage_OOR),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_operation_process_drug_library.No_Drug_Found, to = wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr.Drug_Not_In_Library),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_boss.Prime_Failure, to = wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr.Prime_Failure),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_rate_controller.Infusion_Flow_Rate, to = wrap_pca_imp_Instance_pump_safety_alarm_process_flow_rate.Infusion_Flow_Rate),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_rate_controller.Infusion_Flow_Rate, to = wrap_pca_imp_Instance_pump_fluid_mech_pump.Rate),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_rate_controller.System_Status, to = wrap_pca_imp_Instance_pump_safety_alarm_process_flow_rate.System_Status),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_prescription_checker.Hard_Limit_Violated, to = wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr.Hard_Limit_Violation),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_max_drug_watcher.Over_Max_Drug_Per_Hour, to = wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr.Max_Dose_Warning),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_security_subsystem_security_process_security_thread.Security_Fault, to = wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr.Security_Fault),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_control_panel_ui_process_ui_thread.CP_Reset_Alarm, to = wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr.CP_Reset_Alarm),
                         Connection(from = wrap_pca_imp_Instance_pump_fluid_mech_pump.Pump_Too_Hot, to = wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr.Pump_Hot),
                         Connection(from = wrap_pca_imp_Instance_pump_fluid_upstream_mon.Upstream_Flow_Rate, to = wrap_pca_imp_Instance_pump_safety_alarm_process_flow_rate.Upstream_Flow_Rate),
                         Connection(from = wrap_pca_imp_Instance_pump_fluid_upstream_mon.Occlusion, to = wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr.Upstream_Occlusion),
                         Connection(from = wrap_pca_imp_Instance_pump_fluid_downstream_mon.Downstream_Flow_Rate, to = wrap_pca_imp_Instance_pump_safety_alarm_process_flow_rate.Downstream_Flow_Rate),
                         Connection(from = wrap_pca_imp_Instance_pump_fluid_downstream_mon.Occlusion, to = wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr.Downstream_Occlusion),
                         Connection(from = wrap_pca_imp_Instance_pump_fluid_downstream_mon.Bubble, to = wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr.Bubble),
                         Connection(from = wrap_pca_imp_Instance_pump_fluid_reservoir.Door_Open, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_rate_controller.Door_Open),
                         Connection(from = wrap_pca_imp_Instance_pump_fluid_reservoir.Door_Open, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_ice_thread.Door_Open),
                         Connection(from = wrap_pca_imp_Instance_pump_fluid_reservoir.Door_Closed, to = wrap_pca_imp_Instance_pump_operation_operation_process_operation_threads_boss.Door_Closed),
                         Connection(from = wrap_pca_imp_Instance_pump_fluid_reservoir.Low_Reservoir, to = wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr.Low_Res),
                         Connection(from = wrap_pca_imp_Instance_pump_fluid_reservoir.Empty_Reservoir, to = wrap_pca_imp_Instance_pump_safety_alarm_process_alarm_thr.Empty_Res),
                         Connection(from = wrap_pca_imp_Instance_maint.Load_Drug_Library, to = wrap_pca_imp_Instance_pump_operation_operation_process_drug_library.Load_Drug_Library),
                         Connection(from = wrap_pca_imp_Instance_maint.Get_Fault_Log, to = wrap_pca_imp_Instance_pump_safety_fault_log.Get_Log),
                         Connection(from = wrap_pca_imp_Instance_maint.Get_Event_Log, to = wrap_pca_imp_Instance_pump_operation_operation_process_event_logger.Get_Event_Log),
                         Connection(from = wrap_pca_imp_Instance_pump_safety_fault_log.The_Log, to = wrap_pca_imp_Instance_maint.The_Fault_Log),
                         Connection(from = wrap_pca_imp_Instance_pump_operation_operation_process_event_logger.The_Event_Log, to = wrap_pca_imp_Instance_maint.The_Event_Log))
    )
  }
}