#include <all.h>
#include <ext.h>

struct building_control_mixed_BuildingControl_Temperature_i convertTemperatureToFahrenheit(
  building_control_mixed_BuildingControl_Temperature_i t){
  
  struct building_control_mixed_BuildingControl_Temperature_i ret = *t;
  
  if(t->unit == building_control_mixed_BuildingControl_TempUnit_Type_Celsius) {
    ret.degrees = t->degrees * 9.0 / 5.0 + 32.0;
  }
  else if(t->unit == building_control_mixed_BuildingControl_TempUnit_Type_Kelvin) {
    ret.degrees = t->degrees * 9.0 / 5.0 - 459.67;
  }
  
  ret.unit = building_control_mixed_BuildingControl_TempUnit_Type_Fahrenheit;
  
  return ret;
}

struct building_control_mixed_BuildingControl_SetPoint_i convertSetPointToFahrenheit(
  building_control_mixed_BuildingControl_SetPoint_i t){
  
  struct building_control_mixed_BuildingControl_Temperature_i low = convertTemperatureToFahrenheit(&t->low);
  struct building_control_mixed_BuildingControl_Temperature_i high = convertTemperatureToFahrenheit(&t->high);
  
  DeclNewbuilding_control_mixed_BuildingControl_SetPoint_i(ret);
  ret.low = low;
  ret.high = high;
  
  return *t;
}

struct building_control_mixed_BuildingControl_Temperature_i createTempInFahrenheit(F32 value) {
  DeclNewbuilding_control_mixed_BuildingControl_Temperature_i(ret);
  ret.degrees = value;
  ret.unit = building_control_mixed_BuildingControl_TempUnit_Type_Fahrenheit;
  return ret;
}