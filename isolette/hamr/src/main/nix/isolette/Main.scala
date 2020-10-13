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

    Platform.sendAsync(IPCPorts.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_App, IPCPorts.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_App, empty)
    Platform.sendAsync(IPCPorts.Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_mhst_App, IPCPorts.Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_mhst_App, empty)
    Platform.sendAsync(IPCPorts.Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode_mrmt_App, IPCPorts.Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode_mrmt_App, empty)
    Platform.sendAsync(IPCPorts.Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_mat_App, IPCPorts.Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_mat_App, empty)
    Platform.sendAsync(IPCPorts.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_mmit_App, IPCPorts.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_mmit_App, empty)
    Platform.sendAsync(IPCPorts.Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_mmmt_App, IPCPorts.Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_mmmt_App, empty)
    Platform.sendAsync(IPCPorts.operator_interface_thread_impl_operator_interface_oip_oit_App, IPCPorts.operator_interface_thread_impl_operator_interface_oip_oit_App, empty)
    Platform.sendAsync(IPCPorts.Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_App, IPCPorts.Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_App, empty)
    Platform.sendAsync(IPCPorts.Heat_Source_impl_heat_source_cpi_heat_controller_App, IPCPorts.Heat_Source_impl_heat_source_cpi_heat_controller_App, empty)

    Platform.finalise()
    return 0
  }
}
