// #Sireum

package isolette

import org.sireum._
import art._
import art.PortMode._
import art.DispatchPropertyProtocol._

// This file was auto-generated.  Do not edit

object Arch {
  val isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit : isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_Bridge = {
    val current_tempWstatus = Port[Isolette_Data_Model.TempWstatus_impl] (id = 0, name = "isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit_current_tempWstatus", mode = DataIn)
    val lower_desired_tempWstatus = Port[Isolette_Data_Model.TempWstatus_impl] (id = 1, name = "isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit_lower_desired_tempWstatus", mode = DataIn)
    val upper_desired_tempWstatus = Port[Isolette_Data_Model.TempWstatus_impl] (id = 2, name = "isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit_upper_desired_tempWstatus", mode = DataIn)
    val regulator_mode = Port[Isolette_Data_Model.Regulator_Mode.Type] (id = 3, name = "isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit_regulator_mode", mode = DataIn)
    val upper_desired_temp = Port[Isolette_Data_Model.Temp_impl] (id = 4, name = "isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit_upper_desired_temp", mode = DataOut)
    val lower_desired_temp = Port[Isolette_Data_Model.Temp_impl] (id = 5, name = "isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit_lower_desired_temp", mode = DataOut)
    val displayed_temp = Port[Isolette_Data_Model.Temp_impl] (id = 6, name = "isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit_displayed_temp", mode = DataOut)
    val regulator_status = Port[Isolette_Data_Model.Status.Type] (id = 7, name = "isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit_regulator_status", mode = DataOut)
    val interface_failure = Port[Isolette_Data_Model.Failure_Flag_impl] (id = 8, name = "isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit_interface_failure", mode = DataOut)

    isolette.Regulate.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_Bridge(
      id = 0,
      name = "isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit",
      dispatchProtocol = Periodic(period = 1000),
      dispatchTriggers = None(),

      current_tempWstatus = current_tempWstatus,
      lower_desired_tempWstatus = lower_desired_tempWstatus,
      upper_desired_tempWstatus = upper_desired_tempWstatus,
      regulator_mode = regulator_mode,
      upper_desired_temp = upper_desired_temp,
      lower_desired_temp = lower_desired_temp,
      displayed_temp = displayed_temp,
      regulator_status = regulator_status,
      interface_failure = interface_failure
    )
  }
  val isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_heat_source_mhst : isolette.Regulate.Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_mhst_Bridge = {
    val current_tempWstatus = Port[Isolette_Data_Model.TempWstatus_impl] (id = 9, name = "isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_heat_source_mhst_current_tempWstatus", mode = DataIn)
    val lower_desired_temp = Port[Isolette_Data_Model.Temp_impl] (id = 10, name = "isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_heat_source_mhst_lower_desired_temp", mode = DataIn)
    val upper_desired_temp = Port[Isolette_Data_Model.Temp_impl] (id = 11, name = "isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_heat_source_mhst_upper_desired_temp", mode = DataIn)
    val regulator_mode = Port[Isolette_Data_Model.Regulator_Mode.Type] (id = 12, name = "isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_heat_source_mhst_regulator_mode", mode = DataIn)
    val heat_control = Port[Isolette_Data_Model.On_Off.Type] (id = 13, name = "isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_heat_source_mhst_heat_control", mode = DataOut)

    isolette.Regulate.Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_mhst_Bridge(
      id = 1,
      name = "isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_heat_source_mhst",
      dispatchProtocol = Periodic(period = 1000),
      dispatchTriggers = None(),

      current_tempWstatus = current_tempWstatus,
      lower_desired_temp = lower_desired_temp,
      upper_desired_temp = upper_desired_temp,
      regulator_mode = regulator_mode,
      heat_control = heat_control
    )
  }
  val isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_mode_mrmt : isolette.Regulate.Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode_mrmt_Bridge = {
    val current_tempWstatus = Port[Isolette_Data_Model.TempWstatus_impl] (id = 14, name = "isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_mode_mrmt_current_tempWstatus", mode = DataIn)
    val interface_failure = Port[Isolette_Data_Model.Failure_Flag_impl] (id = 15, name = "isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_mode_mrmt_interface_failure", mode = DataIn)
    val internal_failure = Port[Isolette_Data_Model.Failure_Flag_impl] (id = 16, name = "isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_mode_mrmt_internal_failure", mode = DataIn)
    val regulator_mode = Port[Isolette_Data_Model.Regulator_Mode.Type] (id = 17, name = "isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_mode_mrmt_regulator_mode", mode = DataOut)

    isolette.Regulate.Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode_mrmt_Bridge(
      id = 2,
      name = "isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_mode_mrmt",
      dispatchProtocol = Periodic(period = 1000),
      dispatchTriggers = None(),

      current_tempWstatus = current_tempWstatus,
      interface_failure = interface_failure,
      internal_failure = internal_failure,
      regulator_mode = regulator_mode
    )
  }
  val isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_alarm_mat : isolette.Monitor.Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_mat_Bridge = {
    val current_tempWstatus = Port[Isolette_Data_Model.TempWstatus_impl] (id = 18, name = "isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_alarm_mat_current_tempWstatus", mode = DataIn)
    val lower_alarm_temp = Port[Isolette_Data_Model.Temp_impl] (id = 19, name = "isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_alarm_mat_lower_alarm_temp", mode = DataIn)
    val upper_alarm_temp = Port[Isolette_Data_Model.Temp_impl] (id = 20, name = "isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_alarm_mat_upper_alarm_temp", mode = DataIn)
    val monitor_mode = Port[Isolette_Data_Model.Monitor_Mode.Type] (id = 21, name = "isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_alarm_mat_monitor_mode", mode = DataIn)
    val alarm_control = Port[Isolette_Data_Model.On_Off.Type] (id = 22, name = "isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_alarm_mat_alarm_control", mode = DataOut)

    isolette.Monitor.Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_mat_Bridge(
      id = 3,
      name = "isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_alarm_mat",
      dispatchProtocol = Periodic(period = 1000),
      dispatchTriggers = None(),

      current_tempWstatus = current_tempWstatus,
      lower_alarm_temp = lower_alarm_temp,
      upper_alarm_temp = upper_alarm_temp,
      monitor_mode = monitor_mode,
      alarm_control = alarm_control
    )
  }
  val isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_interface_mmit : isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_mmit_Bridge = {
    val upper_alarm_tempWstatus = Port[Isolette_Data_Model.TempWstatus_impl] (id = 23, name = "isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_interface_mmit_upper_alarm_tempWstatus", mode = DataIn)
    val lower_alarm_tempWstatus = Port[Isolette_Data_Model.TempWstatus_impl] (id = 24, name = "isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_interface_mmit_lower_alarm_tempWstatus", mode = DataIn)
    val current_tempWstatus = Port[Isolette_Data_Model.TempWstatus_impl] (id = 25, name = "isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_interface_mmit_current_tempWstatus", mode = DataIn)
    val monitor_mode = Port[Isolette_Data_Model.Monitor_Mode.Type] (id = 26, name = "isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_interface_mmit_monitor_mode", mode = DataIn)
    val upper_alarm_temp = Port[Isolette_Data_Model.Temp_impl] (id = 27, name = "isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_interface_mmit_upper_alarm_temp", mode = DataOut)
    val lower_alarm_temp = Port[Isolette_Data_Model.Temp_impl] (id = 28, name = "isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_interface_mmit_lower_alarm_temp", mode = DataOut)
    val monitor_status = Port[Isolette_Data_Model.Status.Type] (id = 29, name = "isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_interface_mmit_monitor_status", mode = DataOut)
    val interface_failure = Port[Isolette_Data_Model.Failure_Flag_impl] (id = 30, name = "isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_interface_mmit_interface_failure", mode = DataOut)

    isolette.Monitor.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_mmit_Bridge(
      id = 4,
      name = "isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_interface_mmit",
      dispatchProtocol = Periodic(period = 1000),
      dispatchTriggers = None(),

      upper_alarm_tempWstatus = upper_alarm_tempWstatus,
      lower_alarm_tempWstatus = lower_alarm_tempWstatus,
      current_tempWstatus = current_tempWstatus,
      monitor_mode = monitor_mode,
      upper_alarm_temp = upper_alarm_temp,
      lower_alarm_temp = lower_alarm_temp,
      monitor_status = monitor_status,
      interface_failure = interface_failure
    )
  }
  val isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_mode_mmmt : isolette.Monitor.Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_mmmt_Bridge = {
    val current_tempWstatus = Port[Isolette_Data_Model.TempWstatus_impl] (id = 31, name = "isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_mode_mmmt_current_tempWstatus", mode = DataIn)
    val interface_failure = Port[Isolette_Data_Model.Failure_Flag_impl] (id = 32, name = "isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_mode_mmmt_interface_failure", mode = DataIn)
    val internal_failure = Port[Isolette_Data_Model.Failure_Flag_impl] (id = 33, name = "isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_mode_mmmt_internal_failure", mode = DataIn)
    val monitor_mode = Port[Isolette_Data_Model.Monitor_Mode.Type] (id = 34, name = "isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_mode_mmmt_monitor_mode", mode = DataOut)

    isolette.Monitor.Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_mmmt_Bridge(
      id = 5,
      name = "isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_mode_mmmt",
      dispatchProtocol = Periodic(period = 1000),
      dispatchTriggers = None(),

      current_tempWstatus = current_tempWstatus,
      interface_failure = interface_failure,
      internal_failure = internal_failure,
      monitor_mode = monitor_mode
    )
  }
  val isolette_single_sensor_Instance_operator_interface_oip_oit : isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit_Bridge = {
    val regulator_status = Port[Isolette_Data_Model.Status.Type] (id = 35, name = "isolette_single_sensor_Instance_operator_interface_oip_oit_regulator_status", mode = DataIn)
    val monitor_status = Port[Isolette_Data_Model.Status.Type] (id = 36, name = "isolette_single_sensor_Instance_operator_interface_oip_oit_monitor_status", mode = DataIn)
    val display_temperature = Port[Isolette_Data_Model.Temp_impl] (id = 37, name = "isolette_single_sensor_Instance_operator_interface_oip_oit_display_temperature", mode = DataIn)
    val alarm_control = Port[Isolette_Data_Model.On_Off.Type] (id = 38, name = "isolette_single_sensor_Instance_operator_interface_oip_oit_alarm_control", mode = DataIn)
    val lower_desired_tempWstatus = Port[Isolette_Data_Model.TempWstatus_impl] (id = 39, name = "isolette_single_sensor_Instance_operator_interface_oip_oit_lower_desired_tempWstatus", mode = DataOut)
    val upper_desired_tempWstatus = Port[Isolette_Data_Model.TempWstatus_impl] (id = 40, name = "isolette_single_sensor_Instance_operator_interface_oip_oit_upper_desired_tempWstatus", mode = DataOut)
    val lower_alarm_tempWstatus = Port[Isolette_Data_Model.TempWstatus_impl] (id = 41, name = "isolette_single_sensor_Instance_operator_interface_oip_oit_lower_alarm_tempWstatus", mode = DataOut)
    val upper_alarm_tempWstatus = Port[Isolette_Data_Model.TempWstatus_impl] (id = 42, name = "isolette_single_sensor_Instance_operator_interface_oip_oit_upper_alarm_tempWstatus", mode = DataOut)

    isolette.Isolette.operator_interface_thread_impl_operator_interface_oip_oit_Bridge(
      id = 6,
      name = "isolette_single_sensor_Instance_operator_interface_oip_oit",
      dispatchProtocol = Periodic(period = 1000),
      dispatchTriggers = None(),

      regulator_status = regulator_status,
      monitor_status = monitor_status,
      display_temperature = display_temperature,
      alarm_control = alarm_control,
      lower_desired_tempWstatus = lower_desired_tempWstatus,
      upper_desired_tempWstatus = upper_desired_tempWstatus,
      lower_alarm_tempWstatus = lower_alarm_tempWstatus,
      upper_alarm_tempWstatus = upper_alarm_tempWstatus
    )
  }
  val isolette_single_sensor_Instance_temperature_sensor_cpi_thermostat : isolette.Devices.Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_Bridge = {
    val air = Port[Isolette_Data_Model.PhysicalTemp_impl] (id = 43, name = "isolette_single_sensor_Instance_temperature_sensor_cpi_thermostat_air", mode = DataIn)
    val current_tempWstatus = Port[Isolette_Data_Model.TempWstatus_impl] (id = 44, name = "isolette_single_sensor_Instance_temperature_sensor_cpi_thermostat_current_tempWstatus", mode = DataOut)

    isolette.Devices.Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_Bridge(
      id = 7,
      name = "isolette_single_sensor_Instance_temperature_sensor_cpi_thermostat",
      dispatchProtocol = Periodic(period = 1000),
      dispatchTriggers = None(),

      air = air,
      current_tempWstatus = current_tempWstatus
    )
  }
  val isolette_single_sensor_Instance_heat_source_cpi_heat_controller : isolette.Devices.Heat_Source_impl_heat_source_cpi_heat_controller_Bridge = {
    val heat_control = Port[Isolette_Data_Model.On_Off.Type] (id = 45, name = "isolette_single_sensor_Instance_heat_source_cpi_heat_controller_heat_control", mode = DataIn)
    val heat_out = Port[Isolette_Environment.Heat.Type] (id = 46, name = "isolette_single_sensor_Instance_heat_source_cpi_heat_controller_heat_out", mode = DataOut)

    isolette.Devices.Heat_Source_impl_heat_source_cpi_heat_controller_Bridge(
      id = 8,
      name = "isolette_single_sensor_Instance_heat_source_cpi_heat_controller",
      dispatchProtocol = Periodic(period = 1000),
      dispatchTriggers = None(),

      heat_control = heat_control,
      heat_out = heat_out
    )
  }

  val ad : ArchitectureDescription = {

    ArchitectureDescription(
      components = MSZ (isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit, isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_heat_source_mhst, isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_mode_mrmt, isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_alarm_mat, isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_interface_mmit, isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_mode_mmmt, isolette_single_sensor_Instance_operator_interface_oip_oit, isolette_single_sensor_Instance_temperature_sensor_cpi_thermostat, isolette_single_sensor_Instance_heat_source_cpi_heat_controller),

      connections = ISZ (Connection(from = isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit.upper_desired_temp, to = isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_heat_source_mhst.upper_desired_temp),
                         Connection(from = isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit.lower_desired_temp, to = isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_heat_source_mhst.lower_desired_temp),
                         Connection(from = isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit.interface_failure, to = isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_mode_mrmt.interface_failure),
                         Connection(from = isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_mode_mrmt.regulator_mode, to = isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit.regulator_mode),
                         Connection(from = isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_mode_mrmt.regulator_mode, to = isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_heat_source_mhst.regulator_mode),
                         Connection(from = isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_interface_mmit.upper_alarm_temp, to = isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_alarm_mat.upper_alarm_temp),
                         Connection(from = isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_interface_mmit.lower_alarm_temp, to = isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_alarm_mat.lower_alarm_temp),
                         Connection(from = isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_interface_mmit.interface_failure, to = isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_mode_mmmt.interface_failure),
                         Connection(from = isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_mode_mmmt.monitor_mode, to = isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_interface_mmit.monitor_mode),
                         Connection(from = isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_mode_mmmt.monitor_mode, to = isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_alarm_mat.monitor_mode),
                         Connection(from = isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit.displayed_temp, to = isolette_single_sensor_Instance_operator_interface_oip_oit.display_temperature),
                         Connection(from = isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit.regulator_status, to = isolette_single_sensor_Instance_operator_interface_oip_oit.regulator_status),
                         Connection(from = isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_heat_source_mhst.heat_control, to = isolette_single_sensor_Instance_heat_source_cpi_heat_controller.heat_control),
                         Connection(from = isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_alarm_mat.alarm_control, to = isolette_single_sensor_Instance_operator_interface_oip_oit.alarm_control),
                         Connection(from = isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_interface_mmit.monitor_status, to = isolette_single_sensor_Instance_operator_interface_oip_oit.monitor_status),
                         Connection(from = isolette_single_sensor_Instance_operator_interface_oip_oit.lower_desired_tempWstatus, to = isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit.lower_desired_tempWstatus),
                         Connection(from = isolette_single_sensor_Instance_operator_interface_oip_oit.upper_desired_tempWstatus, to = isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit.upper_desired_tempWstatus),
                         Connection(from = isolette_single_sensor_Instance_operator_interface_oip_oit.upper_alarm_tempWstatus, to = isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_interface_mmit.upper_alarm_tempWstatus),
                         Connection(from = isolette_single_sensor_Instance_operator_interface_oip_oit.upper_alarm_tempWstatus, to = isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_interface_mmit.lower_alarm_tempWstatus),
                         Connection(from = isolette_single_sensor_Instance_temperature_sensor_cpi_thermostat.current_tempWstatus, to = isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_interface_mmit.current_tempWstatus),
                         Connection(from = isolette_single_sensor_Instance_temperature_sensor_cpi_thermostat.current_tempWstatus, to = isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_alarm_mat.current_tempWstatus),
                         Connection(from = isolette_single_sensor_Instance_temperature_sensor_cpi_thermostat.current_tempWstatus, to = isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_mode_mmmt.current_tempWstatus),
                         Connection(from = isolette_single_sensor_Instance_temperature_sensor_cpi_thermostat.current_tempWstatus, to = isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit.current_tempWstatus),
                         Connection(from = isolette_single_sensor_Instance_temperature_sensor_cpi_thermostat.current_tempWstatus, to = isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_heat_source_mhst.current_tempWstatus),
                         Connection(from = isolette_single_sensor_Instance_temperature_sensor_cpi_thermostat.current_tempWstatus, to = isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_mode_mrmt.current_tempWstatus))
    )
  }
}