#ifndef FAN_I_P_FAN_H
#define FAN_I_P_FAN_H

#include <all.h>

Unit b_TemperatureControl_Fan_i_p_fan_initialise_(STACK_FRAME_ONLY);

Unit b_TemperatureControl_Fan_i_p_fan_finalise_(STACK_FRAME_ONLY);

Unit b_TemperatureControl_Fan_i_p_fan_handlefanCmd_(
  STACK_FRAME
  b_TemperatureControl_FanCmd_Type value);

#endif
