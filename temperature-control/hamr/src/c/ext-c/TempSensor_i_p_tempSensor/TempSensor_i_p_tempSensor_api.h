#ifndef TEMPSENSOR_I_P_TEMPSENSOR_API_H
#define TEMPSENSOR_I_P_TEMPSENSOR_API_H

#include <all.h>

// This file was auto-generated.  Do not edit

void api_send_currentTemp__b_TemperatureControl_TempSensor_i_p_tempSensor(
  STACK_FRAME
  b_TemperatureControl_Temperature_i value);

void api_send_tempChanged__b_TemperatureControl_TempSensor_i_p_tempSensor(STACK_FRAME_ONLY);

void api_logInfo__b_TemperatureControl_TempSensor_i_p_tempSensor(
  STACK_FRAME
  String str);

void api_logDebug__b_TemperatureControl_TempSensor_i_p_tempSensor(
  STACK_FRAME
  String str);

void api_logError__b_TemperatureControl_TempSensor_i_p_tempSensor(
  STACK_FRAME
  String str);

#endif
