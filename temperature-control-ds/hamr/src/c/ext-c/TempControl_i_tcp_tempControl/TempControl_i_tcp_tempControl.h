#ifndef TEMPCONTROL_I_TCP_TEMPCONTROL_H
#define TEMPCONTROL_I_TCP_TEMPCONTROL_H

#include <all.h>

Unit b_TemperatureControl_TempControl_i_tcp_tempControl_initialise_(STACK_FRAME_ONLY);

Unit b_TemperatureControl_TempControl_i_tcp_tempControl_finalise_(STACK_FRAME_ONLY);

Unit b_TemperatureControl_TempControl_i_tcp_tempControl_handlefanAck_(
  STACK_FRAME
  b_TemperatureControl_FanAck_Type value);

Unit b_TemperatureControl_TempControl_i_tcp_tempControl_handlesetPoint_(
  STACK_FRAME
  b_TemperatureControl_SetPoint_i value);

Unit b_TemperatureControl_TempControl_i_tcp_tempControl_handletempChanged_(STACK_FRAME_ONLY);

#endif