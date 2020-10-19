#include <Fan_i_tcp_fan_api.h>
#include <Fan_i_tcp_fan.h>

// This file was auto-generated.  Do not edit

bool api_get_fanCmd__building_control_mixed_BuildingControl_Fan_i_tcp_fan(
  STACK_FRAME
  building_control_mixed_BuildingControl_FanCmd_Type *value){
  DeclNewStackFrame(caller, "Fan_i_tcp_fan_api.c", "", "api_get_fanCmd__building_control_mixed_BuildingControl_Fan_i_tcp_fan", 0);

  // Option_C79B3B = Option[building_control_mixed.BuildingControl.Fan_i_Operational_Api]
  DeclNewbuilding_control_mixed_BuildingControl_Fan_i_Operational_Api(api);
  Option_C79B3B_get_(SF (building_control_mixed_BuildingControl_Fan_i_Operational_Api) &api, building_control_mixed_BuildingControl_Fan_i_tcp_fan_Bridge_c_operational_api(SF_LAST));

  // Option_ABA69D = Option[building_control_mixed.BuildingControl.FanCmd.Type]
  // Some_8BE08A = Some[building_control_mixed.BuildingControl.FanCmd.Type]
  DeclNewOption_ABA69D(t_0);
  building_control_mixed_BuildingControl_Fan_i_Operational_Api_getfanCmd_(
    SF
    (Option_ABA69D) &t_0,
    &api);

  if(t_0.type == TSome_8BE08A){
    Type_assign(value, &t_0.Some_8BE08A.value, sizeof(building_control_mixed_BuildingControl_FanCmd_Type));
    return true;
  } else {
    return false;
  }
}

void api_send_fanAck__building_control_mixed_BuildingControl_Fan_i_tcp_fan(
  STACK_FRAME
  building_control_mixed_BuildingControl_FanAck_Type value) {
  DeclNewStackFrame(caller, "Fan_i_tcp_fan_api.c", "", "api_send_fanAck__building_control_mixed_BuildingControl_Fan_i_tcp_fan", 0);

  // Option_3F81C7 = Option[building_control_mixed.BuildingControl.Fan_i_Initialization_Api]
  DeclNewbuilding_control_mixed_BuildingControl_Fan_i_Initialization_Api(api);
  Option_3F81C7_get_(SF (building_control_mixed_BuildingControl_Fan_i_Initialization_Api) &api, building_control_mixed_BuildingControl_Fan_i_tcp_fan_Bridge_c_initialization_api(SF_LAST));

  building_control_mixed_BuildingControl_Fan_i_Initialization_Api_sendfanAck_(
    SF
    &api,
    value);
}

void api_logInfo__building_control_mixed_BuildingControl_Fan_i_tcp_fan(
  STACK_FRAME
  String str) {
  DeclNewStackFrame(caller, "Fan_i_tcp_fan_api.c", "", "api_logInfo__building_control_mixed_BuildingControl_Fan_i_tcp_fan", 0);

  // Option_3F81C7 = Option[building_control_mixed.BuildingControl.Fan_i_Initialization_Api]
  DeclNewbuilding_control_mixed_BuildingControl_Fan_i_Initialization_Api(api);
  Option_3F81C7_get_(SF (building_control_mixed_BuildingControl_Fan_i_Initialization_Api) &api, building_control_mixed_BuildingControl_Fan_i_tcp_fan_Bridge_c_initialization_api(SF_LAST));

  building_control_mixed_BuildingControl_Fan_i_Initialization_Api_logInfo_(
    SF
    &api,
    str);
}

void api_logDebug__building_control_mixed_BuildingControl_Fan_i_tcp_fan(
  STACK_FRAME
  String str) {
  DeclNewStackFrame(caller, "Fan_i_tcp_fan_api.c", "", "api_logDebug__building_control_mixed_BuildingControl_Fan_i_tcp_fan", 0);

  // Option_3F81C7 = Option[building_control_mixed.BuildingControl.Fan_i_Initialization_Api]
  DeclNewbuilding_control_mixed_BuildingControl_Fan_i_Initialization_Api(api);
  Option_3F81C7_get_(SF (building_control_mixed_BuildingControl_Fan_i_Initialization_Api) &api, building_control_mixed_BuildingControl_Fan_i_tcp_fan_Bridge_c_initialization_api(SF_LAST));

  building_control_mixed_BuildingControl_Fan_i_Initialization_Api_logDebug_(
    SF
    &api,
    str);
}

void api_logError__building_control_mixed_BuildingControl_Fan_i_tcp_fan(
  STACK_FRAME
  String str) {
  DeclNewStackFrame(caller, "Fan_i_tcp_fan_api.c", "", "api_logError__building_control_mixed_BuildingControl_Fan_i_tcp_fan", 0);

  // Option_3F81C7 = Option[building_control_mixed.BuildingControl.Fan_i_Initialization_Api]
  DeclNewbuilding_control_mixed_BuildingControl_Fan_i_Initialization_Api(api);
  Option_3F81C7_get_(SF (building_control_mixed_BuildingControl_Fan_i_Initialization_Api) &api, building_control_mixed_BuildingControl_Fan_i_tcp_fan_Bridge_c_initialization_api(SF_LAST));

  building_control_mixed_BuildingControl_Fan_i_Initialization_Api_logError_(
    SF
    &api,
    str);
}

Unit building_control_mixed_BuildingControl_Fan_i_tcp_fan_initialise(
  STACK_FRAME
  building_control_mixed_BuildingControl_Fan_i_Initialization_Api api) {
  DeclNewStackFrame(caller, "Fan_i_tcp_fan_api.c", "", "building_control_mixed_BuildingControl_Fan_i_tcp_fan_initialise", 0);

  building_control_mixed_BuildingControl_Fan_i_tcp_fan_initialise_(SF_LAST);
}

Unit building_control_mixed_BuildingControl_Fan_i_tcp_fan_finalise(
  STACK_FRAME
  building_control_mixed_BuildingControl_Fan_i_Operational_Api api) {
  DeclNewStackFrame(caller, "Fan_i_tcp_fan_api.c", "", "building_control_mixed_BuildingControl_Fan_i_tcp_fan_finalise", 0);

  building_control_mixed_BuildingControl_Fan_i_tcp_fan_finalise_(SF_LAST);
}

Unit building_control_mixed_BuildingControl_Fan_i_tcp_fan_handlefanCmd(
  STACK_FRAME
  building_control_mixed_BuildingControl_Fan_i_Operational_Api api,
  building_control_mixed_BuildingControl_FanCmd_Type value) {
  DeclNewStackFrame(caller, "Fan_i_tcp_fan_api.c", "", "building_control_mixed_BuildingControl_Fan_i_tcp_fan_handlefanCmd", 0);

  building_control_mixed_BuildingControl_Fan_i_tcp_fan_handlefanCmd_(SF value);
}
