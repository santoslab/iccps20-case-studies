// #Sireum

package isolette

import org.sireum._
import art._

// This file was auto-generated.  Do not edit

object IPCPorts {
  val Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_App: Art.PortId = 47
  val Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_mhst_App: Art.PortId = 48
  val Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode_mrmt_App: Art.PortId = 49
  val Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_mat_App: Art.PortId = 50
  val Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_mmit_App: Art.PortId = 51
  val Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_mmmt_App: Art.PortId = 52
  val operator_interface_thread_impl_operator_interface_oip_oit_App: Art.PortId = 53
  val Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_App: Art.PortId = 54
  val Heat_Source_impl_heat_source_cpi_heat_controller_App: Art.PortId = 55
  val Main: Art.PortId = 56

  def emptyReceiveOut: MBox2[Art.PortId, DataContent] = {
    return MBox2(-1, art.Empty())
  }

  def emptyReceiveAsyncOut: MBox2[Art.PortId, Option[DataContent]] = {
    return MBox2(-1, None())
  }
}
