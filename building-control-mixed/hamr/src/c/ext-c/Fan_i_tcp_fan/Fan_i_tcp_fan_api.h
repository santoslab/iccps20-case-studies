#ifndef FAN_I_TCP_FAN_API_H
#define FAN_I_TCP_FAN_API_H

#include <all.h>

// This file was auto-generated.  Do not edit

bool api_get_fanCmd__building_control_mixed_BuildingControl_Fan_i_tcp_fan(
  STACK_FRAME
  building_control_mixed_BuildingControl_FanCmd_Type *value);

void api_send_fanAck__building_control_mixed_BuildingControl_Fan_i_tcp_fan(
  STACK_FRAME
  building_control_mixed_BuildingControl_FanAck_Type value);

void api_logInfo__building_control_mixed_BuildingControl_Fan_i_tcp_fan(
  STACK_FRAME
  String str);

void api_logDebug__building_control_mixed_BuildingControl_Fan_i_tcp_fan(
  STACK_FRAME
  String str);

void api_logError__building_control_mixed_BuildingControl_Fan_i_tcp_fan(
  STACK_FRAME
  String str);

#endif
