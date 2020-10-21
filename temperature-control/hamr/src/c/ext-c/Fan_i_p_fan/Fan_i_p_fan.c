#include <Fan_i_p_fan_api.h>
#include <Fan_i_p_fan.h>
#include <ext.h>

// This file will not be overwritten so is safe to edit

Unit b_TemperatureControl_Fan_i_p_fan_initialise_(STACK_FRAME_ONLY) {
 DeclNewStackFrame(caller, "Fan_i_p_fan.c", "", "b_TemperatureControl_Fan_i_p_fan_initialise_", 0);

 // do nothing
}

Unit b_TemperatureControl_Fan_i_p_fan_handlefanCmd_(
  STACK_FRAME
  b_TemperatureControl_FanCmd_Type value) {
  DeclNewStackFrame(caller, "Fan_i_p_fan.c", "", "b_TemperatureControl_Fan_i_p_fan_handlefanCmd_", 0);

  DeclNewString(_str1);
  String str = (String) &_str1;
  String__append(str, string("received fanCmd "));
  b_TemperatureControl_FanCmd_Type_string_(SF str, value);
  api_logInfo__b_TemperatureControl_Fan_i_p_fan(SF str);

  // always return 'Ok'
  b_TemperatureControl_FanAck_Type ack = 
    b_TemperatureControl_FanAck_Type_Ok;
    
  api_send_fanAck__b_TemperatureControl_Fan_i_p_fan(SF ack);

  DeclNewString(_str2);
  str = (String) &_str2;
  String__append(str, string("Actuation result: "));
  b_TemperatureControl_FanAck_Type_string_(SF str, ack);
  api_logInfo__b_TemperatureControl_Fan_i_p_fan(SF str);
}

Unit b_TemperatureControl_Fan_i_p_fan_finalise_(STACK_FRAME_ONLY) {
  DeclNewStackFrame(caller, "Fan_i_p_fan.c", "", "b_TemperatureControl_Fan_i_p_fan_finalise_", 0);

  // do nothing
}