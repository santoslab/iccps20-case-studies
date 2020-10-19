#include <TempSensor_i_tcp_tempSensor_api.h>
#include <TempSensor_i_tcp_tempSensor.h>
#include <ext.h>

// This file will not be overwritten so is safe to edit

struct building_control_mixed_BuildingControl_Temperature_i lastTemperature;
int delta = 4;

Unit building_control_mixed_BuildingControl_TempSensor_i_tcp_tempSensor_initialise_(STACK_FRAME_ONLY) {
  DeclNewStackFrame(caller, "TempSensor_i_tcp_tempSensor.c", "", "building_control_mixed_BuildingControl_TempSensor_i_tcp_tempSensor_initialise_", 0);
    
  // just initialize outgoing data ports
  
  lastTemperature = createTempInFahrenheit(80.0);
    
  api_send_currentTemp__building_control_mixed_BuildingControl_TempSensor_i_tcp_tempSensor(SF
    &lastTemperature);
}

Unit building_control_mixed_BuildingControl_TempSensor_i_tcp_tempSensor_timeTriggered_(STACK_FRAME_ONLY) {
  DeclNewStackFrame(caller, "TempSensor_i_tcp_tempSensor.c", "", "building_control_mixed_BuildingControl_TempSensor_i_tcp_tempSensor_timeTriggered_", 0);

  lastTemperature.degrees = lastTemperature.degrees + delta;

  String str = string("Sensed: ");
  building_control_mixed_BuildingControl_Temperature_i_string_(SF str, &lastTemperature);
  
  api_logInfo__building_control_mixed_BuildingControl_TempSensor_i_tcp_tempSensor(SF str);
    
  if(lastTemperature.degrees < MIN_TEMP) delta = 4;
  else if(lastTemperature.degrees > MAX_TEMP) delta = -4;
    
  api_send_currentTemp__building_control_mixed_BuildingControl_TempSensor_i_tcp_tempSensor(SF
    &lastTemperature);
    
  api_send_tempChanged__building_control_mixed_BuildingControl_TempSensor_i_tcp_tempSensor(SF_LAST);
}

Unit building_control_mixed_BuildingControl_TempSensor_i_tcp_tempSensor_finalise_(STACK_FRAME_ONLY) {
  DeclNewStackFrame(caller, "TempSensor_i_tcp_tempSensor.c", "", "building_control_mixed_BuildingControl_TempSensor_i_tcp_tempSensor_finalise_", 0);

  // example finalise method
}
