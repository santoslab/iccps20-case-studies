#ifndef EXT_H
#define EXT_H

static F32 MIN_TEMP = 55.0;
static F32 MAX_TEMP = 100.0;

struct b_TemperatureControl_Temperature_i convertTemperatureToFahrenheit(
  b_TemperatureControl_Temperature_i t);

struct b_TemperatureControl_SetPoint_i convertSetPointToFahrenheit(
  b_TemperatureControl_SetPoint_i t);

struct b_TemperatureControl_Temperature_i createTempInFahrenheit(F32 value);

#endif