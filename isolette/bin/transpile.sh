#!/usr/bin/env bash
#
# This file is autogenerated.  Do not edit
#
set -e

if [ -z "${SIREUM_HOME}" ]; then
  echo "SIREUM_HOME not set. Refer to https://github.com/sireum/kekinian/#installing"
  exit 1
fi

PATH_SEP=":"
if [ -n "$COMSPEC" -a -x "$COMSPEC" ]; then
  PATH_SEP=";"
fi

SCRIPT_HOME=$( cd "$( dirname "$0" )" &> /dev/null && pwd )
OUTPUT_DIR="${SCRIPT_HOME}/../src/c/nix"

${SIREUM_HOME}/bin/sireum slang transpilers c \
  --sourcepath "${SCRIPT_HOME}/../src/main" \
  --output-dir "${OUTPUT_DIR}" \
  --name "main" \
  --apps "isolette.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit_App,isolette.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_heat_source_mhst_App,isolette.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_mode_mrmt_App,isolette.isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_alarm_mat_App,isolette.isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_interface_mmit_App,isolette.isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_mode_mmmt_App,isolette.isolette_single_sensor_Instance_operator_interface_oip_oit_App,isolette.isolette_single_sensor_Instance_temperature_sensor_cpi_thermostat_App,isolette.isolette_single_sensor_Instance_heat_source_cpi_heat_controller_App,isolette.Main" \
  --fingerprint 3 \
  --bits 32 \
  --string-size 250 \
  --sequence-size 57 \
  --sequence "MS[Z,art.Bridge]=9;MS[Z,MOption[art.Bridge]]=9;IS[Z,art.UPort]=9;IS[Z,art.UConnection]=25" \
  --constants "art.Art.maxComponents=9;art.Art.maxPorts=57" \
  --forward "art.ArtNative=isolette.ArtNix,isolette.Platform=isolette.PlatformNix" \
  --stack-size "217088" \
  --stable-type-id \
  --exts "${SCRIPT_HOME}/../src/c/ext-c/ext.c${PATH_SEP}${SCRIPT_HOME}/../src/c/ext-c/ext.h${PATH_SEP}${SCRIPT_HOME}/../src/c/ext-c/ipc.c" \
  --verbose