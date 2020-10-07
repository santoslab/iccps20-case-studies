#!/usr/bin/env bash
#
# This file is autogenerated.  Do not edit
#
set -e

if [ -z "${SIREUM_HOME}" ]; then
  echo "SIREUM_HOME not set. Refer to https://github.com/sireum/kekinian/#installing"
  exit 1
fi

SCRIPT_HOME=$( cd "$( dirname "$0" )" &> /dev/null && pwd )

PATH_SEP=":"
if [ -n "$COMSPEC" -a -x "$COMSPEC" ]; then
  PATH_SEP=";"
fi

OUTPUT_DIR="${SCRIPT_HOME}/../src/c/CAmkES_seL4/slang_libraries/isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit"

${SIREUM_HOME}/bin/sireum slang transpilers c \
  --sourcepath "${SCRIPT_HOME}/../src/main/bridge${PATH_SEP}${SCRIPT_HOME}/../src/main/component${PATH_SEP}${SCRIPT_HOME}/../src/main/seL4Nix/isolette/Regulate${PATH_SEP}${SCRIPT_HOME}/../src/main/art${PATH_SEP}${SCRIPT_HOME}/../src/main/data${PATH_SEP}${SCRIPT_HOME}/../src/main/seL4Nix/isolette/isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit" \
  --output-dir "${OUTPUT_DIR}" \
  --name "isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit" \
  --apps "isolette.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit.mrit" \
  --fingerprint 3 \
  --bits 32 \
  --string-size 250 \
  --sequence-size 9 \
  --sequence "MS[Z,art.Bridge]=1;MS[Z,MOption[art.Bridge]]=1;IS[Z,art.UPort]=9;IS[Z,art.UConnection]=1" \
  --constants "art.Art.maxComponents=1;art.Art.maxPorts=9" \
  --cmake-includes "+${SCRIPT_HOME}/settings_isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit.cmake" \
  --forward "art.ArtNative=isolette.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit.mrit" \
  --stack-size "217088" \
  --stable-type-id \
  --exts "${SCRIPT_HOME}/../src/c/ext-c/ext.c${PATH_SEP}${SCRIPT_HOME}/../src/c/ext-c/ext.h${PATH_SEP}${SCRIPT_HOME}/../src/c/ext-c/adapters/isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit/Manage_Regulator_Interface_impl_adapter.h${PATH_SEP}${SCRIPT_HOME}/../src/c/ext-c/adapters/isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit/Manage_Regulator_Interface_impl_adapter.c" \
  --lib-only \
  --verbose

OUTPUT_DIR="${SCRIPT_HOME}/../src/c/CAmkES_seL4/slang_libraries/isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_heat_source_mhst"

${SIREUM_HOME}/bin/sireum slang transpilers c \
  --sourcepath "${SCRIPT_HOME}/../src/main/bridge${PATH_SEP}${SCRIPT_HOME}/../src/main/component${PATH_SEP}${SCRIPT_HOME}/../src/main/seL4Nix/isolette/Regulate${PATH_SEP}${SCRIPT_HOME}/../src/main/art${PATH_SEP}${SCRIPT_HOME}/../src/main/data${PATH_SEP}${SCRIPT_HOME}/../src/main/seL4Nix/isolette/isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_heat_source_mhst" \
  --output-dir "${OUTPUT_DIR}" \
  --name "isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_heat_source_mhst" \
  --apps "isolette.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_heat_source_mhst.mhst" \
  --fingerprint 3 \
  --bits 32 \
  --string-size 250 \
  --sequence-size 5 \
  --sequence "MS[Z,art.Bridge]=1;MS[Z,MOption[art.Bridge]]=1;IS[Z,art.UPort]=5;IS[Z,art.UConnection]=1" \
  --constants "art.Art.maxComponents=1;art.Art.maxPorts=5" \
  --cmake-includes "+${SCRIPT_HOME}/settings_isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_heat_source_mhst.cmake" \
  --forward "art.ArtNative=isolette.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_heat_source_mhst.mhst" \
  --stack-size "217088" \
  --stable-type-id \
  --exts "${SCRIPT_HOME}/../src/c/ext-c/ext.c${PATH_SEP}${SCRIPT_HOME}/../src/c/ext-c/ext.h${PATH_SEP}${SCRIPT_HOME}/../src/c/ext-c/adapters/isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_heat_source_mhst/Manage_Heat_Source_impl_adapter.h${PATH_SEP}${SCRIPT_HOME}/../src/c/ext-c/adapters/isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_heat_source_mhst/Manage_Heat_Source_impl_adapter.c" \
  --lib-only \
  --verbose

OUTPUT_DIR="${SCRIPT_HOME}/../src/c/CAmkES_seL4/slang_libraries/isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_mode_mrmt"

${SIREUM_HOME}/bin/sireum slang transpilers c \
  --sourcepath "${SCRIPT_HOME}/../src/main/bridge${PATH_SEP}${SCRIPT_HOME}/../src/main/component${PATH_SEP}${SCRIPT_HOME}/../src/main/seL4Nix/isolette/Regulate${PATH_SEP}${SCRIPT_HOME}/../src/main/art${PATH_SEP}${SCRIPT_HOME}/../src/main/data${PATH_SEP}${SCRIPT_HOME}/../src/main/seL4Nix/isolette/isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_mode_mrmt" \
  --output-dir "${OUTPUT_DIR}" \
  --name "isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_mode_mrmt" \
  --apps "isolette.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_mode_mrmt.mrmt" \
  --fingerprint 3 \
  --bits 32 \
  --string-size 250 \
  --sequence-size 4 \
  --sequence "MS[Z,art.Bridge]=1;MS[Z,MOption[art.Bridge]]=1;IS[Z,art.UPort]=4;IS[Z,art.UConnection]=1" \
  --constants "art.Art.maxComponents=1;art.Art.maxPorts=4" \
  --cmake-includes "+${SCRIPT_HOME}/settings_isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_mode_mrmt.cmake" \
  --forward "art.ArtNative=isolette.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_mode_mrmt.mrmt" \
  --stack-size "217088" \
  --stable-type-id \
  --exts "${SCRIPT_HOME}/../src/c/ext-c/ext.c${PATH_SEP}${SCRIPT_HOME}/../src/c/ext-c/ext.h${PATH_SEP}${SCRIPT_HOME}/../src/c/ext-c/adapters/isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_mode_mrmt/Manage_Regulator_Mode_impl_adapter.h${PATH_SEP}${SCRIPT_HOME}/../src/c/ext-c/adapters/isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_mode_mrmt/Manage_Regulator_Mode_impl_adapter.c" \
  --lib-only \
  --verbose

OUTPUT_DIR="${SCRIPT_HOME}/../src/c/CAmkES_seL4/slang_libraries/isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_alarm_mat"

${SIREUM_HOME}/bin/sireum slang transpilers c \
  --sourcepath "${SCRIPT_HOME}/../src/main/bridge${PATH_SEP}${SCRIPT_HOME}/../src/main/component${PATH_SEP}${SCRIPT_HOME}/../src/main/seL4Nix/isolette/Monitor${PATH_SEP}${SCRIPT_HOME}/../src/main/art${PATH_SEP}${SCRIPT_HOME}/../src/main/data${PATH_SEP}${SCRIPT_HOME}/../src/main/seL4Nix/isolette/isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_alarm_mat" \
  --output-dir "${OUTPUT_DIR}" \
  --name "isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_alarm_mat" \
  --apps "isolette.isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_alarm_mat.mat" \
  --fingerprint 3 \
  --bits 32 \
  --string-size 250 \
  --sequence-size 5 \
  --sequence "MS[Z,art.Bridge]=1;MS[Z,MOption[art.Bridge]]=1;IS[Z,art.UPort]=5;IS[Z,art.UConnection]=1" \
  --constants "art.Art.maxComponents=1;art.Art.maxPorts=5" \
  --cmake-includes "+${SCRIPT_HOME}/settings_isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_alarm_mat.cmake" \
  --forward "art.ArtNative=isolette.isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_alarm_mat.mat" \
  --stack-size "217088" \
  --stable-type-id \
  --exts "${SCRIPT_HOME}/../src/c/ext-c/ext.c${PATH_SEP}${SCRIPT_HOME}/../src/c/ext-c/ext.h${PATH_SEP}${SCRIPT_HOME}/../src/c/ext-c/adapters/isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_alarm_mat/Manage_Alarm_impl_adapter.h${PATH_SEP}${SCRIPT_HOME}/../src/c/ext-c/adapters/isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_alarm_mat/Manage_Alarm_impl_adapter.c" \
  --lib-only \
  --verbose

OUTPUT_DIR="${SCRIPT_HOME}/../src/c/CAmkES_seL4/slang_libraries/isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_interface_mmit"

${SIREUM_HOME}/bin/sireum slang transpilers c \
  --sourcepath "${SCRIPT_HOME}/../src/main/bridge${PATH_SEP}${SCRIPT_HOME}/../src/main/component${PATH_SEP}${SCRIPT_HOME}/../src/main/seL4Nix/isolette/Monitor${PATH_SEP}${SCRIPT_HOME}/../src/main/art${PATH_SEP}${SCRIPT_HOME}/../src/main/data${PATH_SEP}${SCRIPT_HOME}/../src/main/seL4Nix/isolette/isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_interface_mmit" \
  --output-dir "${OUTPUT_DIR}" \
  --name "isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_interface_mmit" \
  --apps "isolette.isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_interface_mmit.mmit" \
  --fingerprint 3 \
  --bits 32 \
  --string-size 250 \
  --sequence-size 8 \
  --sequence "MS[Z,art.Bridge]=1;MS[Z,MOption[art.Bridge]]=1;IS[Z,art.UPort]=8;IS[Z,art.UConnection]=1" \
  --constants "art.Art.maxComponents=1;art.Art.maxPorts=8" \
  --cmake-includes "+${SCRIPT_HOME}/settings_isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_interface_mmit.cmake" \
  --forward "art.ArtNative=isolette.isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_interface_mmit.mmit" \
  --stack-size "217088" \
  --stable-type-id \
  --exts "${SCRIPT_HOME}/../src/c/ext-c/ext.c${PATH_SEP}${SCRIPT_HOME}/../src/c/ext-c/ext.h${PATH_SEP}${SCRIPT_HOME}/../src/c/ext-c/adapters/isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_interface_mmit/Manage_Monitor_Interface_impl_adapter.h${PATH_SEP}${SCRIPT_HOME}/../src/c/ext-c/adapters/isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_interface_mmit/Manage_Monitor_Interface_impl_adapter.c" \
  --lib-only \
  --verbose

OUTPUT_DIR="${SCRIPT_HOME}/../src/c/CAmkES_seL4/slang_libraries/isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_mode_mmmt"

${SIREUM_HOME}/bin/sireum slang transpilers c \
  --sourcepath "${SCRIPT_HOME}/../src/main/bridge${PATH_SEP}${SCRIPT_HOME}/../src/main/component${PATH_SEP}${SCRIPT_HOME}/../src/main/seL4Nix/isolette/Monitor${PATH_SEP}${SCRIPT_HOME}/../src/main/art${PATH_SEP}${SCRIPT_HOME}/../src/main/data${PATH_SEP}${SCRIPT_HOME}/../src/main/seL4Nix/isolette/isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_mode_mmmt" \
  --output-dir "${OUTPUT_DIR}" \
  --name "isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_mode_mmmt" \
  --apps "isolette.isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_mode_mmmt.mmmt" \
  --fingerprint 3 \
  --bits 32 \
  --string-size 250 \
  --sequence-size 4 \
  --sequence "MS[Z,art.Bridge]=1;MS[Z,MOption[art.Bridge]]=1;IS[Z,art.UPort]=4;IS[Z,art.UConnection]=1" \
  --constants "art.Art.maxComponents=1;art.Art.maxPorts=4" \
  --cmake-includes "+${SCRIPT_HOME}/settings_isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_mode_mmmt.cmake" \
  --forward "art.ArtNative=isolette.isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_mode_mmmt.mmmt" \
  --stack-size "217088" \
  --stable-type-id \
  --exts "${SCRIPT_HOME}/../src/c/ext-c/ext.c${PATH_SEP}${SCRIPT_HOME}/../src/c/ext-c/ext.h${PATH_SEP}${SCRIPT_HOME}/../src/c/ext-c/adapters/isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_mode_mmmt/Manage_Monitor_Mode_impl_adapter.h${PATH_SEP}${SCRIPT_HOME}/../src/c/ext-c/adapters/isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_mode_mmmt/Manage_Monitor_Mode_impl_adapter.c" \
  --lib-only \
  --verbose

OUTPUT_DIR="${SCRIPT_HOME}/../src/c/CAmkES_seL4/slang_libraries/isolette_single_sensor_Instance_operator_interface_oip_oit"

${SIREUM_HOME}/bin/sireum slang transpilers c \
  --sourcepath "${SCRIPT_HOME}/../src/main/bridge${PATH_SEP}${SCRIPT_HOME}/../src/main/component${PATH_SEP}${SCRIPT_HOME}/../src/main/seL4Nix/isolette/Isolette${PATH_SEP}${SCRIPT_HOME}/../src/main/art${PATH_SEP}${SCRIPT_HOME}/../src/main/data${PATH_SEP}${SCRIPT_HOME}/../src/main/seL4Nix/isolette/isolette_single_sensor_Instance_operator_interface_oip_oit" \
  --output-dir "${OUTPUT_DIR}" \
  --name "isolette_single_sensor_Instance_operator_interface_oip_oit" \
  --apps "isolette.isolette_single_sensor_Instance_operator_interface_oip_oit.oit" \
  --fingerprint 3 \
  --bits 32 \
  --string-size 250 \
  --sequence-size 8 \
  --sequence "MS[Z,art.Bridge]=1;MS[Z,MOption[art.Bridge]]=1;IS[Z,art.UPort]=8;IS[Z,art.UConnection]=1" \
  --constants "art.Art.maxComponents=1;art.Art.maxPorts=8" \
  --cmake-includes "+${SCRIPT_HOME}/settings_isolette_single_sensor_Instance_operator_interface_oip_oit.cmake" \
  --forward "art.ArtNative=isolette.isolette_single_sensor_Instance_operator_interface_oip_oit.oit" \
  --stack-size "217088" \
  --stable-type-id \
  --exts "${SCRIPT_HOME}/../src/c/ext-c/ext.c${PATH_SEP}${SCRIPT_HOME}/../src/c/ext-c/ext.h${PATH_SEP}${SCRIPT_HOME}/../src/c/ext-c/adapters/isolette_single_sensor_Instance_operator_interface_oip_oit/operator_interface_thread_impl_adapter.h${PATH_SEP}${SCRIPT_HOME}/../src/c/ext-c/adapters/isolette_single_sensor_Instance_operator_interface_oip_oit/operator_interface_thread_impl_adapter.c" \
  --lib-only \
  --verbose

OUTPUT_DIR="${SCRIPT_HOME}/../src/c/CAmkES_seL4/slang_libraries/isolette_single_sensor_Instance_temperature_sensor_cpi_thermostat"

${SIREUM_HOME}/bin/sireum slang transpilers c \
  --sourcepath "${SCRIPT_HOME}/../src/main/bridge${PATH_SEP}${SCRIPT_HOME}/../src/main/component${PATH_SEP}${SCRIPT_HOME}/../src/main/seL4Nix/isolette/Devices${PATH_SEP}${SCRIPT_HOME}/../src/main/art${PATH_SEP}${SCRIPT_HOME}/../src/main/data${PATH_SEP}${SCRIPT_HOME}/../src/main/seL4Nix/isolette/isolette_single_sensor_Instance_temperature_sensor_cpi_thermostat" \
  --output-dir "${OUTPUT_DIR}" \
  --name "isolette_single_sensor_Instance_temperature_sensor_cpi_thermostat" \
  --apps "isolette.isolette_single_sensor_Instance_temperature_sensor_cpi_thermostat.thermostat" \
  --fingerprint 3 \
  --bits 32 \
  --string-size 250 \
  --sequence-size 2 \
  --sequence "MS[Z,art.Bridge]=1;MS[Z,MOption[art.Bridge]]=1;IS[Z,art.UPort]=2;IS[Z,art.UConnection]=1" \
  --constants "art.Art.maxComponents=1;art.Art.maxPorts=2" \
  --cmake-includes "+${SCRIPT_HOME}/settings_isolette_single_sensor_Instance_temperature_sensor_cpi_thermostat.cmake" \
  --forward "art.ArtNative=isolette.isolette_single_sensor_Instance_temperature_sensor_cpi_thermostat.thermostat" \
  --stack-size "217088" \
  --stable-type-id \
  --exts "${SCRIPT_HOME}/../src/c/ext-c/ext.c${PATH_SEP}${SCRIPT_HOME}/../src/c/ext-c/ext.h${PATH_SEP}${SCRIPT_HOME}/../src/c/ext-c/adapters/isolette_single_sensor_Instance_temperature_sensor_cpi_thermostat/Temperature_Sensor_impl_adapter.h${PATH_SEP}${SCRIPT_HOME}/../src/c/ext-c/adapters/isolette_single_sensor_Instance_temperature_sensor_cpi_thermostat/Temperature_Sensor_impl_adapter.c" \
  --lib-only \
  --verbose

OUTPUT_DIR="${SCRIPT_HOME}/../src/c/CAmkES_seL4/slang_libraries/isolette_single_sensor_Instance_heat_source_cpi_heat_controller"

${SIREUM_HOME}/bin/sireum slang transpilers c \
  --sourcepath "${SCRIPT_HOME}/../src/main/bridge${PATH_SEP}${SCRIPT_HOME}/../src/main/component${PATH_SEP}${SCRIPT_HOME}/../src/main/seL4Nix/isolette/Devices${PATH_SEP}${SCRIPT_HOME}/../src/main/art${PATH_SEP}${SCRIPT_HOME}/../src/main/data${PATH_SEP}${SCRIPT_HOME}/../src/main/seL4Nix/isolette/isolette_single_sensor_Instance_heat_source_cpi_heat_controller" \
  --output-dir "${OUTPUT_DIR}" \
  --name "isolette_single_sensor_Instance_heat_source_cpi_heat_controller" \
  --apps "isolette.isolette_single_sensor_Instance_heat_source_cpi_heat_controller.heat_controller" \
  --fingerprint 3 \
  --bits 32 \
  --string-size 250 \
  --sequence-size 2 \
  --sequence "MS[Z,art.Bridge]=1;MS[Z,MOption[art.Bridge]]=1;IS[Z,art.UPort]=2;IS[Z,art.UConnection]=1" \
  --constants "art.Art.maxComponents=1;art.Art.maxPorts=2" \
  --cmake-includes "+${SCRIPT_HOME}/settings_isolette_single_sensor_Instance_heat_source_cpi_heat_controller.cmake" \
  --forward "art.ArtNative=isolette.isolette_single_sensor_Instance_heat_source_cpi_heat_controller.heat_controller" \
  --stack-size "217088" \
  --stable-type-id \
  --exts "${SCRIPT_HOME}/../src/c/ext-c/ext.c${PATH_SEP}${SCRIPT_HOME}/../src/c/ext-c/ext.h${PATH_SEP}${SCRIPT_HOME}/../src/c/ext-c/adapters/isolette_single_sensor_Instance_heat_source_cpi_heat_controller/Heat_Source_impl_adapter.h${PATH_SEP}${SCRIPT_HOME}/../src/c/ext-c/adapters/isolette_single_sensor_Instance_heat_source_cpi_heat_controller/Heat_Source_impl_adapter.c" \
  --lib-only \
  --verbose

OUTPUT_DIR="${SCRIPT_HOME}/../src/c/CAmkES_seL4/slang_libraries/SlangTypeLibrary"

${SIREUM_HOME}/bin/sireum slang transpilers c \
  --sourcepath "${SCRIPT_HOME}/../src/main/art${PATH_SEP}${SCRIPT_HOME}/../src/main/data${PATH_SEP}${SCRIPT_HOME}/../src/main/seL4Nix/isolette/SlangTypeLibrary" \
  --output-dir "${OUTPUT_DIR}" \
  --name "SlangTypeLibrary" \
  --apps "isolette.SlangTypeLibrary.SlangTypeLibrary" \
  --fingerprint 3 \
  --bits 32 \
  --string-size 250 \
  --sequence-size 1 \
  --cmake-includes "+${SCRIPT_HOME}/settings_SlangTypeLibrary.cmake" \
  --forward "art.ArtNative=isolette.SlangTypeLibrary.SlangTypeLibrary" \
  --stack-size "16777216" \
  --stable-type-id \
  --lib-only \
  --verbose