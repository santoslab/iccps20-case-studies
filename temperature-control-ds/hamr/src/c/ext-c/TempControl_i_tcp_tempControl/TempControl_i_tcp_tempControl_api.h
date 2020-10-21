#ifndef TEMPCONTROL_I_TCP_TEMPCONTROL_API_H
#define TEMPCONTROL_I_TCP_TEMPCONTROL_API_H

#include <all.h>

// This file was auto-generated.  Do not edit

bool api_get_currentTemp__b_TemperatureControl_TempControl_i_tcp_tempControl(
  STACK_FRAME
  b_TemperatureControl_Temperature_i value);

bool api_get_fanAck__b_TemperatureControl_TempControl_i_tcp_tempControl(
  STACK_FRAME
  b_TemperatureControl_FanAck_Type *value);

bool api_get_setPoint__b_TemperatureControl_TempControl_i_tcp_tempControl(
  STACK_FRAME
  b_TemperatureControl_SetPoint_i value);

void api_send_fanCmd__b_TemperatureControl_TempControl_i_tcp_tempControl(
  STACK_FRAME
  b_TemperatureControl_FanCmd_Type value);

bool api_get_tempChanged__b_TemperatureControl_TempControl_i_tcp_tempControl(STACK_FRAME_ONLY);

void api_logInfo__b_TemperatureControl_TempControl_i_tcp_tempControl(
  STACK_FRAME
  String str);

void api_logDebug__b_TemperatureControl_TempControl_i_tcp_tempControl(
  STACK_FRAME
  String str);

void api_logError__b_TemperatureControl_TempControl_i_tcp_tempControl(
  STACK_FRAME
  String str);

#endif
