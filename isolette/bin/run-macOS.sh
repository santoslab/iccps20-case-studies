#!/usr/bin/env bash
#
# This file is autogenerated.  Do not edit
#
set -e
export SCRIPT_HOME=$( cd "$( dirname "$0" )" &> /dev/null && pwd )
cd $SCRIPT_HOME
open -a Terminal "macOS-build/isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit_App" &
open -a Terminal "macOS-build/isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_heat_source_mhst_App" &
open -a Terminal "macOS-build/isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_mode_mrmt_App" &
open -a Terminal "macOS-build/isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_alarm_mat_App" &
open -a Terminal "macOS-build/isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_interface_mmit_App" &
open -a Terminal "macOS-build/isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_mode_mmmt_App" &
open -a Terminal "macOS-build/isolette_single_sensor_Instance_operator_interface_oip_oit_App" &
open -a Terminal "macOS-build/isolette_single_sensor_Instance_temperature_sensor_cpi_thermostat_App" &
open -a Terminal "macOS-build/isolette_single_sensor_Instance_heat_source_cpi_heat_controller_App" &
read -p "Press enter to initialise components ..."
macOS-build/Main
read -p "Press enter again to start ..."
macOS-build/Main