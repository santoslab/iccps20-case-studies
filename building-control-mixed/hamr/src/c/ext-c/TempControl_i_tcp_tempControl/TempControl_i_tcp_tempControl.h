#ifndef TEMPCONTROL_I_TCP_TEMPCONTROL_H
#define TEMPCONTROL_I_TCP_TEMPCONTROL_H

#include <all.h>

Unit building_control_mixed_BuildingControl_TempControl_i_tcp_tempControl_initialise_(STACK_FRAME_ONLY);

Unit building_control_mixed_BuildingControl_TempControl_i_tcp_tempControl_finalise_(STACK_FRAME_ONLY);

Unit building_control_mixed_BuildingControl_TempControl_i_tcp_tempControl_handlefanAck_(
  STACK_FRAME
  building_control_mixed_BuildingControl_FanAck_Type value);

Unit building_control_mixed_BuildingControl_TempControl_i_tcp_tempControl_handlesetPoint_(
  STACK_FRAME
  building_control_mixed_BuildingControl_SetPoint_i value);

Unit building_control_mixed_BuildingControl_TempControl_i_tcp_tempControl_handletempChanged_(STACK_FRAME_ONLY);

#endif
