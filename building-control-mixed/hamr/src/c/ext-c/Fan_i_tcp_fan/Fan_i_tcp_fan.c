#include <Fan_i_tcp_fan_api.h>
#include <Fan_i_tcp_fan.h>
#include <ext.h>

// This file will not be overwritten so is safe to edit

Unit building_control_mixed_BuildingControl_Fan_i_tcp_fan_initialise_(STACK_FRAME_ONLY) {
  DeclNewStackFrame(caller, "Fan_i_tcp_fan.c", "", "building_control_mixed_BuildingControl_Fan_i_tcp_fan_initialise_", 0);

  api_send_fanAck__building_control_mixed_BuildingControl_Fan_i_tcp_fan(SF 
    building_control_mixed_BuildingControl_FanAck_Type_Ok);
}

Unit building_control_mixed_BuildingControl_Fan_i_tcp_fan_handlefanCmd_(
  STACK_FRAME
  building_control_mixed_BuildingControl_FanCmd_Type value) {
  DeclNewStackFrame(caller, "Fan_i_tcp_fan.c", "", "building_control_mixed_BuildingControl_Fan_i_tcp_fan_handlefanCmd_", 0);

  String str = string("received fanCmd "); 
  building_control_mixed_BuildingControl_FanCmd_Type_string_(SF str, value);
  api_logInfo__building_control_mixed_BuildingControl_Fan_i_tcp_fan(SF
    str);

  // always return 'Ok'
  building_control_mixed_BuildingControl_FanAck_Type ack = 
    building_control_mixed_BuildingControl_FanAck_Type_Ok;
    
  api_send_fanAck__building_control_mixed_BuildingControl_Fan_i_tcp_fan(SF 
    ack);
  
  str = string("Actuation result: "); 
  building_control_mixed_BuildingControl_FanAck_Type_string_(SF str, ack);
}

Unit building_control_mixed_BuildingControl_Fan_i_tcp_fan_finalise_(STACK_FRAME_ONLY) {
  DeclNewStackFrame(caller, "Fan_i_tcp_fan.c", "", "building_control_mixed_BuildingControl_Fan_i_tcp_fan_finalise_", 0);
  
  // example finalise method
}