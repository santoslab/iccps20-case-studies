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
  --apps "b.TempSensor_i_p_tempSensor_App,b.TempControl_i_p_tempControl_App,b.Fan_i_p_fan_App,b.Main" \
  --fingerprint 3 \
  --bits 32 \
  --string-size 256 \
  --sequence-size 13 \
  --sequence "MS[Z,art.Bridge]=3;MS[Z,MOption[art.Bridge]]=3;IS[Z,art.UPort]=5;IS[Z,art.UConnection]=4" \
  --constants "art.Art.maxComponents=3;art.Art.maxPorts=13" \
  --forward "art.ArtNative=b.ArtNix,b.Platform=b.PlatformNix" \
  --stack-size "110592" \
  --stable-type-id \
  --exts "${SCRIPT_HOME}/../src/c/ext-c/ext.c${PATH_SEP}${SCRIPT_HOME}/../src/c/ext-c/ext.h${PATH_SEP}${SCRIPT_HOME}/../src/c/ext-c/TempSensor_i_p_tempSensor/TempSensor_i_p_tempSensor.h${PATH_SEP}${SCRIPT_HOME}/../src/c/ext-c/TempSensor_i_p_tempSensor/TempSensor_i_p_tempSensor.c${PATH_SEP}${SCRIPT_HOME}/../src/c/ext-c/TempSensor_i_p_tempSensor/TempSensor_i_p_tempSensor_api.h${PATH_SEP}${SCRIPT_HOME}/../src/c/ext-c/TempSensor_i_p_tempSensor/TempSensor_i_p_tempSensor_api.c${PATH_SEP}${SCRIPT_HOME}/../src/c/ext-c/TempControl_i_p_tempControl/TempControl_i_p_tempControl.h${PATH_SEP}${SCRIPT_HOME}/../src/c/ext-c/TempControl_i_p_tempControl/TempControl_i_p_tempControl.c${PATH_SEP}${SCRIPT_HOME}/../src/c/ext-c/TempControl_i_p_tempControl/TempControl_i_p_tempControl_api.h${PATH_SEP}${SCRIPT_HOME}/../src/c/ext-c/TempControl_i_p_tempControl/TempControl_i_p_tempControl_api.c${PATH_SEP}${SCRIPT_HOME}/../src/c/ext-c/Fan_i_p_fan/Fan_i_p_fan.h${PATH_SEP}${SCRIPT_HOME}/../src/c/ext-c/Fan_i_p_fan/Fan_i_p_fan.c${PATH_SEP}${SCRIPT_HOME}/../src/c/ext-c/Fan_i_p_fan/Fan_i_p_fan_api.h${PATH_SEP}${SCRIPT_HOME}/../src/c/ext-c/Fan_i_p_fan/Fan_i_p_fan_api.c${PATH_SEP}${SCRIPT_HOME}/../src/c/ext-c/ipc.c" \
  --exclude-build "b.TemperatureControl.TempSensor_i_p_tempSensor,b.TemperatureControl.TempControl_i_p_tempControl,b.TemperatureControl.Fan_i_p_fan" \
  --verbose