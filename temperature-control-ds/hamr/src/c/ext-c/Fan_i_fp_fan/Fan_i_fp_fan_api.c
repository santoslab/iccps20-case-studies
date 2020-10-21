#include <Fan_i_fp_fan_api.h>
#include <Fan_i_fp_fan.h>

// This file was auto-generated.  Do not edit

bool api_get_fanCmd__b_TemperatureControl_Fan_i_fp_fan(
  STACK_FRAME
  b_TemperatureControl_FanCmd_Type *value){
  DeclNewStackFrame(caller, "Fan_i_fp_fan_api.c", "", "api_get_fanCmd__b_TemperatureControl_Fan_i_fp_fan", 0);

  // Option_159C1B = Option[b.TemperatureControl.Fan_i_Operational_Api]
  DeclNewb_TemperatureControl_Fan_i_Operational_Api(api);
  Option_159C1B_get_(SF (b_TemperatureControl_Fan_i_Operational_Api) &api, b_TemperatureControl_Fan_i_fp_fan_Bridge_c_operational_api(SF_LAST));

  // Option_FE9B9C = Option[b.TemperatureControl.FanCmd.Type]
  // Some_41305D = Some[b.TemperatureControl.FanCmd.Type]
  DeclNewOption_FE9B9C(t_0);
  b_TemperatureControl_Fan_i_Operational_Api_getfanCmd_(
    SF
    (Option_FE9B9C) &t_0,
    &api);

  if(t_0.type == TSome_41305D){
    Type_assign(value, &t_0.Some_41305D.value, sizeof(b_TemperatureControl_FanCmd_Type));
    return true;
  } else {
    return false;
  }
}

void api_send_fanAck__b_TemperatureControl_Fan_i_fp_fan(
  STACK_FRAME
  b_TemperatureControl_FanAck_Type value) {
  DeclNewStackFrame(caller, "Fan_i_fp_fan_api.c", "", "api_send_fanAck__b_TemperatureControl_Fan_i_fp_fan", 0);

  // Option_E1DF23 = Option[b.TemperatureControl.Fan_i_Initialization_Api]
  DeclNewb_TemperatureControl_Fan_i_Initialization_Api(api);
  Option_E1DF23_get_(SF (b_TemperatureControl_Fan_i_Initialization_Api) &api, b_TemperatureControl_Fan_i_fp_fan_Bridge_c_initialization_api(SF_LAST));

  b_TemperatureControl_Fan_i_Initialization_Api_sendfanAck_(
    SF
    &api,
    value);
}

void api_logInfo__b_TemperatureControl_Fan_i_fp_fan(
  STACK_FRAME
  String str) {
  DeclNewStackFrame(caller, "Fan_i_fp_fan_api.c", "", "api_logInfo__b_TemperatureControl_Fan_i_fp_fan", 0);

  // Option_E1DF23 = Option[b.TemperatureControl.Fan_i_Initialization_Api]
  DeclNewb_TemperatureControl_Fan_i_Initialization_Api(api);
  Option_E1DF23_get_(SF (b_TemperatureControl_Fan_i_Initialization_Api) &api, b_TemperatureControl_Fan_i_fp_fan_Bridge_c_initialization_api(SF_LAST));

  b_TemperatureControl_Fan_i_Initialization_Api_logInfo_(
    SF
    &api,
    str);
}

void api_logDebug__b_TemperatureControl_Fan_i_fp_fan(
  STACK_FRAME
  String str) {
  DeclNewStackFrame(caller, "Fan_i_fp_fan_api.c", "", "api_logDebug__b_TemperatureControl_Fan_i_fp_fan", 0);

  // Option_E1DF23 = Option[b.TemperatureControl.Fan_i_Initialization_Api]
  DeclNewb_TemperatureControl_Fan_i_Initialization_Api(api);
  Option_E1DF23_get_(SF (b_TemperatureControl_Fan_i_Initialization_Api) &api, b_TemperatureControl_Fan_i_fp_fan_Bridge_c_initialization_api(SF_LAST));

  b_TemperatureControl_Fan_i_Initialization_Api_logDebug_(
    SF
    &api,
    str);
}

void api_logError__b_TemperatureControl_Fan_i_fp_fan(
  STACK_FRAME
  String str) {
  DeclNewStackFrame(caller, "Fan_i_fp_fan_api.c", "", "api_logError__b_TemperatureControl_Fan_i_fp_fan", 0);

  // Option_E1DF23 = Option[b.TemperatureControl.Fan_i_Initialization_Api]
  DeclNewb_TemperatureControl_Fan_i_Initialization_Api(api);
  Option_E1DF23_get_(SF (b_TemperatureControl_Fan_i_Initialization_Api) &api, b_TemperatureControl_Fan_i_fp_fan_Bridge_c_initialization_api(SF_LAST));

  b_TemperatureControl_Fan_i_Initialization_Api_logError_(
    SF
    &api,
    str);
}

Unit b_TemperatureControl_Fan_i_fp_fan_initialise(
  STACK_FRAME
  b_TemperatureControl_Fan_i_Initialization_Api api) {
  DeclNewStackFrame(caller, "Fan_i_fp_fan_api.c", "", "b_TemperatureControl_Fan_i_fp_fan_initialise", 0);

  b_TemperatureControl_Fan_i_fp_fan_initialise_(SF_LAST);
}

Unit b_TemperatureControl_Fan_i_fp_fan_finalise(
  STACK_FRAME
  b_TemperatureControl_Fan_i_Operational_Api api) {
  DeclNewStackFrame(caller, "Fan_i_fp_fan_api.c", "", "b_TemperatureControl_Fan_i_fp_fan_finalise", 0);

  b_TemperatureControl_Fan_i_fp_fan_finalise_(SF_LAST);
}

Unit b_TemperatureControl_Fan_i_fp_fan_handlefanCmd(
  STACK_FRAME
  b_TemperatureControl_Fan_i_Operational_Api api,
  b_TemperatureControl_FanCmd_Type value) {
  DeclNewStackFrame(caller, "Fan_i_fp_fan_api.c", "", "b_TemperatureControl_Fan_i_fp_fan_handlefanCmd", 0);

  b_TemperatureControl_Fan_i_fp_fan_handlefanCmd_(SF value);
}
