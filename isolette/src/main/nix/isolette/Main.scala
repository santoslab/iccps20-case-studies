// #Sireum

package isolette

import org.sireum._
import art._

// This file was auto-generated.  Do not edit

object Main extends App {
  def main(args: ISZ[String]): Z = {

    val seed: Z = if (args.size == z"1") {
      val n = Z(args(0)).get
      if (n == z"0") 1 else n
    } else {
      1
    }

    Platform.initialise(seed, None())

    val empty = art.Empty()

    Platform.sendAsync(IPCPorts.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit_App, IPCPorts.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit_App, empty)
    Platform.sendAsync(IPCPorts.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_heat_source_mhst_App, IPCPorts.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_heat_source_mhst_App, empty)
    Platform.sendAsync(IPCPorts.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_mode_mrmt_App, IPCPorts.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_mode_mrmt_App, empty)
    Platform.sendAsync(IPCPorts.isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_alarm_mat_App, IPCPorts.isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_alarm_mat_App, empty)
    Platform.sendAsync(IPCPorts.isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_interface_mmit_App, IPCPorts.isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_interface_mmit_App, empty)
    Platform.sendAsync(IPCPorts.isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_mode_mmmt_App, IPCPorts.isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_mode_mmmt_App, empty)
    Platform.sendAsync(IPCPorts.isolette_single_sensor_Instance_operator_interface_oip_oit_App, IPCPorts.isolette_single_sensor_Instance_operator_interface_oip_oit_App, empty)
    Platform.sendAsync(IPCPorts.isolette_single_sensor_Instance_temperature_sensor_cpi_thermostat_App, IPCPorts.isolette_single_sensor_Instance_temperature_sensor_cpi_thermostat_App, empty)
    Platform.sendAsync(IPCPorts.isolette_single_sensor_Instance_heat_source_cpi_heat_controller_App, IPCPorts.isolette_single_sensor_Instance_heat_source_cpi_heat_controller_App, empty)

    Platform.finalise()
    return 0
  }
}
