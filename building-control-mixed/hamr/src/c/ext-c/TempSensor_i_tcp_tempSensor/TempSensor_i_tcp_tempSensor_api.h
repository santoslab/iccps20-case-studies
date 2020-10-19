#ifndef TEMPSENSOR_I_TCP_TEMPSENSOR_API_H
#define TEMPSENSOR_I_TCP_TEMPSENSOR_API_H

#include <all.h>

// This file was auto-generated.  Do not edit

void api_send_currentTemp__building_control_mixed_BuildingControl_TempSensor_i_tcp_tempSensor(
  STACK_FRAME
  building_control_mixed_BuildingControl_Temperature_i value);

void api_send_tempChanged__building_control_mixed_BuildingControl_TempSensor_i_tcp_tempSensor(STACK_FRAME_ONLY);

void api_logInfo__building_control_mixed_BuildingControl_TempSensor_i_tcp_tempSensor(
  STACK_FRAME
  String str);

void api_logDebug__building_control_mixed_BuildingControl_TempSensor_i_tcp_tempSensor(
  STACK_FRAME
  String str);

void api_logError__building_control_mixed_BuildingControl_TempSensor_i_tcp_tempSensor(
  STACK_FRAME
  String str);

#endif
