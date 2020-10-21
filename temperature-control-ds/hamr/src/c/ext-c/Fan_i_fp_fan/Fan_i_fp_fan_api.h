#ifndef FAN_I_FP_FAN_API_H
#define FAN_I_FP_FAN_API_H

#include <all.h>

// This file was auto-generated.  Do not edit

bool api_get_fanCmd__b_TemperatureControl_Fan_i_fp_fan(
  STACK_FRAME
  b_TemperatureControl_FanCmd_Type *value);

void api_send_fanAck__b_TemperatureControl_Fan_i_fp_fan(
  STACK_FRAME
  b_TemperatureControl_FanAck_Type value);

void api_logInfo__b_TemperatureControl_Fan_i_fp_fan(
  STACK_FRAME
  String str);

void api_logDebug__b_TemperatureControl_Fan_i_fp_fan(
  STACK_FRAME
  String str);

void api_logError__b_TemperatureControl_Fan_i_fp_fan(
  STACK_FRAME
  String str);

#endif
