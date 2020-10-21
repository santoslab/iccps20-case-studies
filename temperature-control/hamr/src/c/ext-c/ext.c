#include <all.h>
#include <ext.h>

// add c extension code here

struct b_TemperatureControl_Temperature_i convertTemperatureToFahrenheit(
  b_TemperatureControl_Temperature_i t){

  struct b_TemperatureControl_Temperature_i ret = *t;

  if(t->unit == b_TemperatureControl_TempUnit_Type_Celsius) {
    ret.degrees = t->degrees * 9.0 / 5.0 + 32.0;
  }
  else if(t->unit == b_TemperatureControl_TempUnit_Type_Kelvin) {
    ret.degrees = t->degrees * 9.0 / 5.0 - 459.67;
  }

  ret.unit = b_TemperatureControl_TempUnit_Type_Fahrenheit;

  return ret;
}

struct b_TemperatureControl_SetPoint_i convertSetPointToFahrenheit(
  b_TemperatureControl_SetPoint_i t){

  struct b_TemperatureControl_Temperature_i low = convertTemperatureToFahrenheit(&t->low);
  struct b_TemperatureControl_Temperature_i high = convertTemperatureToFahrenheit(&t->high);

  DeclNewb_TemperatureControl_SetPoint_i(ret);
  ret.low = low;
  ret.high = high;

  return *t;
}

struct b_TemperatureControl_Temperature_i createTempInFahrenheit(F32 value) {
  DeclNewb_TemperatureControl_Temperature_i(ret);
  ret.degrees = value;
  ret.unit = b_TemperatureControl_TempUnit_Type_Fahrenheit;
  return ret;
}