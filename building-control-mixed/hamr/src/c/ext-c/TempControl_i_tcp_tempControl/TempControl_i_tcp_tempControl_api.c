#include <TempControl_i_tcp_tempControl_api.h>
#include <TempControl_i_tcp_tempControl.h>

// This file was auto-generated.  Do not edit

bool api_get_currentTemp__building_control_mixed_BuildingControl_TempControl_i_tcp_tempControl(
  STACK_FRAME
  building_control_mixed_BuildingControl_Temperature_i value){
  DeclNewStackFrame(caller, "TempControl_i_tcp_tempControl_api.c", "", "api_get_currentTemp__building_control_mixed_BuildingControl_TempControl_i_tcp_tempControl", 0);

  // Option_6B5A7C = Option[building_control_mixed.BuildingControl.TempControl_i_Operational_Api]
  DeclNewbuilding_control_mixed_BuildingControl_TempControl_i_Operational_Api(api);
  Option_6B5A7C_get_(SF (building_control_mixed_BuildingControl_TempControl_i_Operational_Api) &api, building_control_mixed_BuildingControl_TempControl_i_tcp_tempControl_Bridge_c_operational_api(SF_LAST));

  // Option_A1D4F4 = Option[building_control_mixed.BuildingControl.Temperature_i]
  // Some_2BA64D = Some[building_control_mixed.BuildingControl.Temperature_i]
  DeclNewOption_A1D4F4(t_0);
  building_control_mixed_BuildingControl_TempControl_i_Operational_Api_getcurrentTemp_(
    SF
    (Option_A1D4F4) &t_0,
    &api);

  if(t_0.type == TSome_2BA64D){
    Type_assign(value, &t_0.Some_2BA64D.value, sizeof(struct building_control_mixed_BuildingControl_Temperature_i));
    return true;
  } else {
    return false;
  }
}

bool api_get_fanAck__building_control_mixed_BuildingControl_TempControl_i_tcp_tempControl(
  STACK_FRAME
  building_control_mixed_BuildingControl_FanAck_Type *value){
  DeclNewStackFrame(caller, "TempControl_i_tcp_tempControl_api.c", "", "api_get_fanAck__building_control_mixed_BuildingControl_TempControl_i_tcp_tempControl", 0);

  // Option_6B5A7C = Option[building_control_mixed.BuildingControl.TempControl_i_Operational_Api]
  DeclNewbuilding_control_mixed_BuildingControl_TempControl_i_Operational_Api(api);
  Option_6B5A7C_get_(SF (building_control_mixed_BuildingControl_TempControl_i_Operational_Api) &api, building_control_mixed_BuildingControl_TempControl_i_tcp_tempControl_Bridge_c_operational_api(SF_LAST));

  // Option_CA7871 = Option[building_control_mixed.BuildingControl.FanAck.Type]
  // Some_AE9F04 = Some[building_control_mixed.BuildingControl.FanAck.Type]
  DeclNewOption_CA7871(t_0);
  building_control_mixed_BuildingControl_TempControl_i_Operational_Api_getfanAck_(
    SF
    (Option_CA7871) &t_0,
    &api);

  if(t_0.type == TSome_AE9F04){
    Type_assign(value, &t_0.Some_AE9F04.value, sizeof(building_control_mixed_BuildingControl_FanAck_Type));
    return true;
  } else {
    return false;
  }
}

bool api_get_setPoint__building_control_mixed_BuildingControl_TempControl_i_tcp_tempControl(
  STACK_FRAME
  building_control_mixed_BuildingControl_SetPoint_i value){
  DeclNewStackFrame(caller, "TempControl_i_tcp_tempControl_api.c", "", "api_get_setPoint__building_control_mixed_BuildingControl_TempControl_i_tcp_tempControl", 0);

  // Option_6B5A7C = Option[building_control_mixed.BuildingControl.TempControl_i_Operational_Api]
  DeclNewbuilding_control_mixed_BuildingControl_TempControl_i_Operational_Api(api);
  Option_6B5A7C_get_(SF (building_control_mixed_BuildingControl_TempControl_i_Operational_Api) &api, building_control_mixed_BuildingControl_TempControl_i_tcp_tempControl_Bridge_c_operational_api(SF_LAST));

  // Option_64AFD3 = Option[building_control_mixed.BuildingControl.SetPoint_i]
  // Some_6CCAC0 = Some[building_control_mixed.BuildingControl.SetPoint_i]
  DeclNewOption_64AFD3(t_0);
  building_control_mixed_BuildingControl_TempControl_i_Operational_Api_getsetPoint_(
    SF
    (Option_64AFD3) &t_0,
    &api);

  if(t_0.type == TSome_6CCAC0){
    Type_assign(value, &t_0.Some_6CCAC0.value, sizeof(struct building_control_mixed_BuildingControl_SetPoint_i));
    return true;
  } else {
    return false;
  }
}

void api_send_fanCmd__building_control_mixed_BuildingControl_TempControl_i_tcp_tempControl(
  STACK_FRAME
  building_control_mixed_BuildingControl_FanCmd_Type value) {
  DeclNewStackFrame(caller, "TempControl_i_tcp_tempControl_api.c", "", "api_send_fanCmd__building_control_mixed_BuildingControl_TempControl_i_tcp_tempControl", 0);

  // Option_E1FB31 = Option[building_control_mixed.BuildingControl.TempControl_i_Initialization_Api]
  DeclNewbuilding_control_mixed_BuildingControl_TempControl_i_Initialization_Api(api);
  Option_E1FB31_get_(SF (building_control_mixed_BuildingControl_TempControl_i_Initialization_Api) &api, building_control_mixed_BuildingControl_TempControl_i_tcp_tempControl_Bridge_c_initialization_api(SF_LAST));

  building_control_mixed_BuildingControl_TempControl_i_Initialization_Api_sendfanCmd_(
    SF
    &api,
    value);
}

bool api_get_tempChanged__building_control_mixed_BuildingControl_TempControl_i_tcp_tempControl(STACK_FRAME_ONLY){
  DeclNewStackFrame(caller, "TempControl_i_tcp_tempControl_api.c", "", "api_get_tempChanged__building_control_mixed_BuildingControl_TempControl_i_tcp_tempControl", 0);

  // Option_6B5A7C = Option[building_control_mixed.BuildingControl.TempControl_i_Operational_Api]
  DeclNewbuilding_control_mixed_BuildingControl_TempControl_i_Operational_Api(api);
  Option_6B5A7C_get_(SF (building_control_mixed_BuildingControl_TempControl_i_Operational_Api) &api, building_control_mixed_BuildingControl_TempControl_i_tcp_tempControl_Bridge_c_operational_api(SF_LAST));

  // Option_C622DB = Option[art.Empty]
  // Some_4782C6 = Some[art.Empty]
  DeclNewOption_C622DB(t_0);
  building_control_mixed_BuildingControl_TempControl_i_Operational_Api_gettempChanged_(
    SF
    (Option_C622DB) &t_0,
    &api);

  if(t_0.type == TSome_4782C6){
    return true;
  } else {
    return false;
  }
}

void api_logInfo__building_control_mixed_BuildingControl_TempControl_i_tcp_tempControl(
  STACK_FRAME
  String str) {
  DeclNewStackFrame(caller, "TempControl_i_tcp_tempControl_api.c", "", "api_logInfo__building_control_mixed_BuildingControl_TempControl_i_tcp_tempControl", 0);

  // Option_E1FB31 = Option[building_control_mixed.BuildingControl.TempControl_i_Initialization_Api]
  DeclNewbuilding_control_mixed_BuildingControl_TempControl_i_Initialization_Api(api);
  Option_E1FB31_get_(SF (building_control_mixed_BuildingControl_TempControl_i_Initialization_Api) &api, building_control_mixed_BuildingControl_TempControl_i_tcp_tempControl_Bridge_c_initialization_api(SF_LAST));

  building_control_mixed_BuildingControl_TempControl_i_Initialization_Api_logInfo_(
    SF
    &api,
    str);
}

void api_logDebug__building_control_mixed_BuildingControl_TempControl_i_tcp_tempControl(
  STACK_FRAME
  String str) {
  DeclNewStackFrame(caller, "TempControl_i_tcp_tempControl_api.c", "", "api_logDebug__building_control_mixed_BuildingControl_TempControl_i_tcp_tempControl", 0);

  // Option_E1FB31 = Option[building_control_mixed.BuildingControl.TempControl_i_Initialization_Api]
  DeclNewbuilding_control_mixed_BuildingControl_TempControl_i_Initialization_Api(api);
  Option_E1FB31_get_(SF (building_control_mixed_BuildingControl_TempControl_i_Initialization_Api) &api, building_control_mixed_BuildingControl_TempControl_i_tcp_tempControl_Bridge_c_initialization_api(SF_LAST));

  building_control_mixed_BuildingControl_TempControl_i_Initialization_Api_logDebug_(
    SF
    &api,
    str);
}

void api_logError__building_control_mixed_BuildingControl_TempControl_i_tcp_tempControl(
  STACK_FRAME
  String str) {
  DeclNewStackFrame(caller, "TempControl_i_tcp_tempControl_api.c", "", "api_logError__building_control_mixed_BuildingControl_TempControl_i_tcp_tempControl", 0);

  // Option_E1FB31 = Option[building_control_mixed.BuildingControl.TempControl_i_Initialization_Api]
  DeclNewbuilding_control_mixed_BuildingControl_TempControl_i_Initialization_Api(api);
  Option_E1FB31_get_(SF (building_control_mixed_BuildingControl_TempControl_i_Initialization_Api) &api, building_control_mixed_BuildingControl_TempControl_i_tcp_tempControl_Bridge_c_initialization_api(SF_LAST));

  building_control_mixed_BuildingControl_TempControl_i_Initialization_Api_logError_(
    SF
    &api,
    str);
}

Unit building_control_mixed_BuildingControl_TempControl_i_tcp_tempControl_initialise(
  STACK_FRAME
  building_control_mixed_BuildingControl_TempControl_i_Initialization_Api api) {
  DeclNewStackFrame(caller, "TempControl_i_tcp_tempControl_api.c", "", "building_control_mixed_BuildingControl_TempControl_i_tcp_tempControl_initialise", 0);

  building_control_mixed_BuildingControl_TempControl_i_tcp_tempControl_initialise_(SF_LAST);
}

Unit building_control_mixed_BuildingControl_TempControl_i_tcp_tempControl_finalise(
  STACK_FRAME
  building_control_mixed_BuildingControl_TempControl_i_Operational_Api api) {
  DeclNewStackFrame(caller, "TempControl_i_tcp_tempControl_api.c", "", "building_control_mixed_BuildingControl_TempControl_i_tcp_tempControl_finalise", 0);

  building_control_mixed_BuildingControl_TempControl_i_tcp_tempControl_finalise_(SF_LAST);
}

Unit building_control_mixed_BuildingControl_TempControl_i_tcp_tempControl_handlefanAck(
  STACK_FRAME
  building_control_mixed_BuildingControl_TempControl_i_Operational_Api api,
  building_control_mixed_BuildingControl_FanAck_Type value) {
  DeclNewStackFrame(caller, "TempControl_i_tcp_tempControl_api.c", "", "building_control_mixed_BuildingControl_TempControl_i_tcp_tempControl_handlefanAck", 0);

  building_control_mixed_BuildingControl_TempControl_i_tcp_tempControl_handlefanAck_(SF value);
}

Unit building_control_mixed_BuildingControl_TempControl_i_tcp_tempControl_handlesetPoint(
  STACK_FRAME
  building_control_mixed_BuildingControl_TempControl_i_Operational_Api api,
  building_control_mixed_BuildingControl_SetPoint_i value) {
  DeclNewStackFrame(caller, "TempControl_i_tcp_tempControl_api.c", "", "building_control_mixed_BuildingControl_TempControl_i_tcp_tempControl_handlesetPoint", 0);

  building_control_mixed_BuildingControl_TempControl_i_tcp_tempControl_handlesetPoint_(SF value);
}

Unit building_control_mixed_BuildingControl_TempControl_i_tcp_tempControl_handletempChanged(
  STACK_FRAME
  building_control_mixed_BuildingControl_TempControl_i_Operational_Api api) {
  DeclNewStackFrame(caller, "TempControl_i_tcp_tempControl_api.c", "", "building_control_mixed_BuildingControl_TempControl_i_tcp_tempControl_handletempChanged", 0);

  building_control_mixed_BuildingControl_TempControl_i_tcp_tempControl_handletempChanged_(SF_LAST);
}
