#include <TempControl_i_tcp_tempControl_api.h>
#include <TempControl_i_tcp_tempControl.h>

// This file was auto-generated.  Do not edit

bool api_get_currentTemp__b_TemperatureControl_TempControl_i_tcp_tempControl(
  STACK_FRAME
  b_TemperatureControl_Temperature_i value){
  DeclNewStackFrame(caller, "TempControl_i_tcp_tempControl_api.c", "", "api_get_currentTemp__b_TemperatureControl_TempControl_i_tcp_tempControl", 0);

  // Option_1CE5DA = Option[b.TemperatureControl.TempControl_i_Operational_Api]
  DeclNewb_TemperatureControl_TempControl_i_Operational_Api(api);
  Option_1CE5DA_get_(SF (b_TemperatureControl_TempControl_i_Operational_Api) &api, b_TemperatureControl_TempControl_i_tcp_tempControl_Bridge_c_operational_api(SF_LAST));

  // Option_FF9A57 = Option[b.TemperatureControl.Temperature_i]
  // Some_53A5E3 = Some[b.TemperatureControl.Temperature_i]
  DeclNewOption_FF9A57(t_0);
  b_TemperatureControl_TempControl_i_Operational_Api_getcurrentTemp_(
    SF
    (Option_FF9A57) &t_0,
    &api);

  if(t_0.type == TSome_53A5E3){
    Type_assign(value, &t_0.Some_53A5E3.value, sizeof(struct b_TemperatureControl_Temperature_i));
    return true;
  } else {
    return false;
  }
}

bool api_get_fanAck__b_TemperatureControl_TempControl_i_tcp_tempControl(
  STACK_FRAME
  b_TemperatureControl_FanAck_Type *value){
  DeclNewStackFrame(caller, "TempControl_i_tcp_tempControl_api.c", "", "api_get_fanAck__b_TemperatureControl_TempControl_i_tcp_tempControl", 0);

  // Option_1CE5DA = Option[b.TemperatureControl.TempControl_i_Operational_Api]
  DeclNewb_TemperatureControl_TempControl_i_Operational_Api(api);
  Option_1CE5DA_get_(SF (b_TemperatureControl_TempControl_i_Operational_Api) &api, b_TemperatureControl_TempControl_i_tcp_tempControl_Bridge_c_operational_api(SF_LAST));

  // Option_E6F918 = Option[b.TemperatureControl.FanAck.Type]
  // Some_7B0150 = Some[b.TemperatureControl.FanAck.Type]
  DeclNewOption_E6F918(t_0);
  b_TemperatureControl_TempControl_i_Operational_Api_getfanAck_(
    SF
    (Option_E6F918) &t_0,
    &api);

  if(t_0.type == TSome_7B0150){
    Type_assign(value, &t_0.Some_7B0150.value, sizeof(b_TemperatureControl_FanAck_Type));
    return true;
  } else {
    return false;
  }
}

bool api_get_setPoint__b_TemperatureControl_TempControl_i_tcp_tempControl(
  STACK_FRAME
  b_TemperatureControl_SetPoint_i value){
  DeclNewStackFrame(caller, "TempControl_i_tcp_tempControl_api.c", "", "api_get_setPoint__b_TemperatureControl_TempControl_i_tcp_tempControl", 0);

  // Option_1CE5DA = Option[b.TemperatureControl.TempControl_i_Operational_Api]
  DeclNewb_TemperatureControl_TempControl_i_Operational_Api(api);
  Option_1CE5DA_get_(SF (b_TemperatureControl_TempControl_i_Operational_Api) &api, b_TemperatureControl_TempControl_i_tcp_tempControl_Bridge_c_operational_api(SF_LAST));

  // Option_1531BB = Option[b.TemperatureControl.SetPoint_i]
  // Some_1E347C = Some[b.TemperatureControl.SetPoint_i]
  DeclNewOption_1531BB(t_0);
  b_TemperatureControl_TempControl_i_Operational_Api_getsetPoint_(
    SF
    (Option_1531BB) &t_0,
    &api);

  if(t_0.type == TSome_1E347C){
    Type_assign(value, &t_0.Some_1E347C.value, sizeof(struct b_TemperatureControl_SetPoint_i));
    return true;
  } else {
    return false;
  }
}

void api_send_fanCmd__b_TemperatureControl_TempControl_i_tcp_tempControl(
  STACK_FRAME
  b_TemperatureControl_FanCmd_Type value) {
  DeclNewStackFrame(caller, "TempControl_i_tcp_tempControl_api.c", "", "api_send_fanCmd__b_TemperatureControl_TempControl_i_tcp_tempControl", 0);

  // Option_8F5254 = Option[b.TemperatureControl.TempControl_i_Initialization_Api]
  DeclNewb_TemperatureControl_TempControl_i_Initialization_Api(api);
  Option_8F5254_get_(SF (b_TemperatureControl_TempControl_i_Initialization_Api) &api, b_TemperatureControl_TempControl_i_tcp_tempControl_Bridge_c_initialization_api(SF_LAST));

  b_TemperatureControl_TempControl_i_Initialization_Api_sendfanCmd_(
    SF
    &api,
    value);
}

bool api_get_tempChanged__b_TemperatureControl_TempControl_i_tcp_tempControl(STACK_FRAME_ONLY){
  DeclNewStackFrame(caller, "TempControl_i_tcp_tempControl_api.c", "", "api_get_tempChanged__b_TemperatureControl_TempControl_i_tcp_tempControl", 0);

  // Option_1CE5DA = Option[b.TemperatureControl.TempControl_i_Operational_Api]
  DeclNewb_TemperatureControl_TempControl_i_Operational_Api(api);
  Option_1CE5DA_get_(SF (b_TemperatureControl_TempControl_i_Operational_Api) &api, b_TemperatureControl_TempControl_i_tcp_tempControl_Bridge_c_operational_api(SF_LAST));

  // Option_C622DB = Option[art.Empty]
  // Some_4782C6 = Some[art.Empty]
  DeclNewOption_C622DB(t_0);
  b_TemperatureControl_TempControl_i_Operational_Api_gettempChanged_(
    SF
    (Option_C622DB) &t_0,
    &api);

  if(t_0.type == TSome_4782C6){
    return true;
  } else {
    return false;
  }
}

void api_logInfo__b_TemperatureControl_TempControl_i_tcp_tempControl(
  STACK_FRAME
  String str) {
  DeclNewStackFrame(caller, "TempControl_i_tcp_tempControl_api.c", "", "api_logInfo__b_TemperatureControl_TempControl_i_tcp_tempControl", 0);

  // Option_8F5254 = Option[b.TemperatureControl.TempControl_i_Initialization_Api]
  DeclNewb_TemperatureControl_TempControl_i_Initialization_Api(api);
  Option_8F5254_get_(SF (b_TemperatureControl_TempControl_i_Initialization_Api) &api, b_TemperatureControl_TempControl_i_tcp_tempControl_Bridge_c_initialization_api(SF_LAST));

  b_TemperatureControl_TempControl_i_Initialization_Api_logInfo_(
    SF
    &api,
    str);
}

void api_logDebug__b_TemperatureControl_TempControl_i_tcp_tempControl(
  STACK_FRAME
  String str) {
  DeclNewStackFrame(caller, "TempControl_i_tcp_tempControl_api.c", "", "api_logDebug__b_TemperatureControl_TempControl_i_tcp_tempControl", 0);

  // Option_8F5254 = Option[b.TemperatureControl.TempControl_i_Initialization_Api]
  DeclNewb_TemperatureControl_TempControl_i_Initialization_Api(api);
  Option_8F5254_get_(SF (b_TemperatureControl_TempControl_i_Initialization_Api) &api, b_TemperatureControl_TempControl_i_tcp_tempControl_Bridge_c_initialization_api(SF_LAST));

  b_TemperatureControl_TempControl_i_Initialization_Api_logDebug_(
    SF
    &api,
    str);
}

void api_logError__b_TemperatureControl_TempControl_i_tcp_tempControl(
  STACK_FRAME
  String str) {
  DeclNewStackFrame(caller, "TempControl_i_tcp_tempControl_api.c", "", "api_logError__b_TemperatureControl_TempControl_i_tcp_tempControl", 0);

  // Option_8F5254 = Option[b.TemperatureControl.TempControl_i_Initialization_Api]
  DeclNewb_TemperatureControl_TempControl_i_Initialization_Api(api);
  Option_8F5254_get_(SF (b_TemperatureControl_TempControl_i_Initialization_Api) &api, b_TemperatureControl_TempControl_i_tcp_tempControl_Bridge_c_initialization_api(SF_LAST));

  b_TemperatureControl_TempControl_i_Initialization_Api_logError_(
    SF
    &api,
    str);
}

Unit b_TemperatureControl_TempControl_i_tcp_tempControl_initialise(
  STACK_FRAME
  b_TemperatureControl_TempControl_i_Initialization_Api api) {
  DeclNewStackFrame(caller, "TempControl_i_tcp_tempControl_api.c", "", "b_TemperatureControl_TempControl_i_tcp_tempControl_initialise", 0);

  b_TemperatureControl_TempControl_i_tcp_tempControl_initialise_(SF_LAST);
}

Unit b_TemperatureControl_TempControl_i_tcp_tempControl_finalise(
  STACK_FRAME
  b_TemperatureControl_TempControl_i_Operational_Api api) {
  DeclNewStackFrame(caller, "TempControl_i_tcp_tempControl_api.c", "", "b_TemperatureControl_TempControl_i_tcp_tempControl_finalise", 0);

  b_TemperatureControl_TempControl_i_tcp_tempControl_finalise_(SF_LAST);
}

Unit b_TemperatureControl_TempControl_i_tcp_tempControl_handlefanAck(
  STACK_FRAME
  b_TemperatureControl_TempControl_i_Operational_Api api,
  b_TemperatureControl_FanAck_Type value) {
  DeclNewStackFrame(caller, "TempControl_i_tcp_tempControl_api.c", "", "b_TemperatureControl_TempControl_i_tcp_tempControl_handlefanAck", 0);

  b_TemperatureControl_TempControl_i_tcp_tempControl_handlefanAck_(SF value);
}

Unit b_TemperatureControl_TempControl_i_tcp_tempControl_handlesetPoint(
  STACK_FRAME
  b_TemperatureControl_TempControl_i_Operational_Api api,
  b_TemperatureControl_SetPoint_i value) {
  DeclNewStackFrame(caller, "TempControl_i_tcp_tempControl_api.c", "", "b_TemperatureControl_TempControl_i_tcp_tempControl_handlesetPoint", 0);

  b_TemperatureControl_TempControl_i_tcp_tempControl_handlesetPoint_(SF value);
}

Unit b_TemperatureControl_TempControl_i_tcp_tempControl_handletempChanged(
  STACK_FRAME
  b_TemperatureControl_TempControl_i_Operational_Api api) {
  DeclNewStackFrame(caller, "TempControl_i_tcp_tempControl_api.c", "", "b_TemperatureControl_TempControl_i_tcp_tempControl_handletempChanged", 0);

  b_TemperatureControl_TempControl_i_tcp_tempControl_handletempChanged_(SF_LAST);
}
