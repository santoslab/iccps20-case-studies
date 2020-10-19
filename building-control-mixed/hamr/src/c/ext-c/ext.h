#ifndef EXT_H
#define EXT_H

static F32 MIN_TEMP = 55.0;
static F32 MAX_TEMP = 100.0;

struct building_control_mixed_BuildingControl_Temperature_i convertTemperatureToFahrenheit(
  building_control_mixed_BuildingControl_Temperature_i t);

struct building_control_mixed_BuildingControl_SetPoint_i convertSetPointToFahrenheit(
  building_control_mixed_BuildingControl_SetPoint_i t);

struct building_control_mixed_BuildingControl_Temperature_i createTempInFahrenheit(F32 value);

#endif