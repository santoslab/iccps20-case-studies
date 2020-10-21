#include <TempSensor_i_p_tempSensor_api.h>
#include <TempSensor_i_p_tempSensor.h>
#include <ext.h>

// This file will not be overwritten so is safe to edit

struct b_TemperatureControl_Temperature_i lastTemperature;
int delta = 4;

Unit b_TemperatureControl_TempSensor_i_p_tempSensor_initialise_(STACK_FRAME_ONLY) {
 DeclNewStackFrame(caller, "TempSensor_i_p_tempSensor.c", "", "b_TemperatureControl_TempSensor_i_p_tempSensor_initialise_", 0);

  lastTemperature = createTempInFahrenheit(80.0);

  // initialize outgoing data port
  api_send_currentTemp__b_TemperatureControl_TempSensor_i_p_tempSensor(SF
    &lastTemperature);
}

Unit b_TemperatureControl_TempSensor_i_p_tempSensor_timeTriggered_(STACK_FRAME_ONLY) {
  DeclNewStackFrame(caller, "TempSensor_i_p_tempSensor.c", "", "b_TemperatureControl_TempSensor_i_p_tempSensor_timeTriggered_", 0);

  lastTemperature.degrees = lastTemperature.degrees + delta;

  DeclNewString(_str);
  String str = (String) &_str;
  String__append(str, string("Sensed: "));
  b_TemperatureControl_Temperature_i_string_(SF str, &lastTemperature);
  api_logInfo__b_TemperatureControl_TempSensor_i_p_tempSensor(SF str);

  if(lastTemperature.degrees < MIN_TEMP) delta = 4;
  else if(lastTemperature.degrees > MAX_TEMP) delta = -4;

  api_send_currentTemp__b_TemperatureControl_TempSensor_i_p_tempSensor(SF
    &lastTemperature);

  api_send_tempChanged__b_TemperatureControl_TempSensor_i_p_tempSensor(SF_LAST);
}

Unit b_TemperatureControl_TempSensor_i_p_tempSensor_finalise_(STACK_FRAME_ONLY) {
  DeclNewStackFrame(caller, "TempSensor_i_p_tempSensor.c", "", "b_TemperatureControl_TempSensor_i_p_tempSensor_finalise_", 0);

  // do nothing
}
