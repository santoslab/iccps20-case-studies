// #Sireum

package isolette

import org.sireum._
import art._

// This file was auto-generated.  Do not edit

object IPCPorts {
  val isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit_App: Art.PortId = 47
  val isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_heat_source_mhst_App: Art.PortId = 48
  val isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_mode_mrmt_App: Art.PortId = 49
  val isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_alarm_mat_App: Art.PortId = 50
  val isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_interface_mmit_App: Art.PortId = 51
  val isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_mode_mmmt_App: Art.PortId = 52
  val isolette_single_sensor_Instance_operator_interface_oip_oit_App: Art.PortId = 53
  val isolette_single_sensor_Instance_temperature_sensor_cpi_thermostat_App: Art.PortId = 54
  val isolette_single_sensor_Instance_heat_source_cpi_heat_controller_App: Art.PortId = 55
  val Main: Art.PortId = 56

  def emptyReceiveOut: MBox2[Art.PortId, DataContent] = {
    return MBox2(-1, art.Empty())
  }

  def emptyReceiveAsyncOut: MBox2[Art.PortId, Option[DataContent]] = {
    return MBox2(-1, None())
  }
}
