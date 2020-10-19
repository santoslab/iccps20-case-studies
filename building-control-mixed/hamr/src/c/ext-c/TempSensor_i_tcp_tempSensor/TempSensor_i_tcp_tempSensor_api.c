#include <TempSensor_i_tcp_tempSensor_api.h>
#include <TempSensor_i_tcp_tempSensor.h>

// This file was auto-generated.  Do not edit

void api_send_currentTemp__building_control_mixed_BuildingControl_TempSensor_i_tcp_tempSensor(
  STACK_FRAME
  building_control_mixed_BuildingControl_Temperature_i value) {
  DeclNewStackFrame(caller, "TempSensor_i_tcp_tempSensor_api.c", "", "api_send_currentTemp__building_control_mixed_BuildingControl_TempSensor_i_tcp_tempSensor", 0);

  // Option_A4741E = Option[building_control_mixed.BuildingControl.TempSensor_i_Initialization_Api]
  DeclNewbuilding_control_mixed_BuildingControl_TempSensor_i_Initialization_Api(api);
  Option_A4741E_get_(SF (building_control_mixed_BuildingControl_TempSensor_i_Initialization_Api) &api, building_control_mixed_BuildingControl_TempSensor_i_tcp_tempSensor_Bridge_c_initialization_api(SF_LAST));

  building_control_mixed_BuildingControl_TempSensor_i_Initialization_Api_setcurrentTemp_(
    SF
    &api,
    value);
}

void api_send_tempChanged__building_control_mixed_BuildingControl_TempSensor_i_tcp_tempSensor(STACK_FRAME_ONLY) {
  DeclNewStackFrame(caller, "TempSensor_i_tcp_tempSensor_api.c", "", "api_send_tempChanged__building_control_mixed_BuildingControl_TempSensor_i_tcp_tempSensor", 0);

  // Option_A4741E = Option[building_control_mixed.BuildingControl.TempSensor_i_Initialization_Api]
  DeclNewbuilding_control_mixed_BuildingControl_TempSensor_i_Initialization_Api(api);
  Option_A4741E_get_(SF (building_control_mixed_BuildingControl_TempSensor_i_Initialization_Api) &api, building_control_mixed_BuildingControl_TempSensor_i_tcp_tempSensor_Bridge_c_initialization_api(SF_LAST));

  building_control_mixed_BuildingControl_TempSensor_i_Initialization_Api_sendtempChanged_(
    SF
    &api);
}

void api_logInfo__building_control_mixed_BuildingControl_TempSensor_i_tcp_tempSensor(
  STACK_FRAME
  String str) {
  DeclNewStackFrame(caller, "TempSensor_i_tcp_tempSensor_api.c", "", "api_logInfo__building_control_mixed_BuildingControl_TempSensor_i_tcp_tempSensor", 0);

  // Option_A4741E = Option[building_control_mixed.BuildingControl.TempSensor_i_Initialization_Api]
  DeclNewbuilding_control_mixed_BuildingControl_TempSensor_i_Initialization_Api(api);
  Option_A4741E_get_(SF (building_control_mixed_BuildingControl_TempSensor_i_Initialization_Api) &api, building_control_mixed_BuildingControl_TempSensor_i_tcp_tempSensor_Bridge_c_initialization_api(SF_LAST));

  building_control_mixed_BuildingControl_TempSensor_i_Initialization_Api_logInfo_(
    SF
    &api,
    str);
}

void api_logDebug__building_control_mixed_BuildingControl_TempSensor_i_tcp_tempSensor(
  STACK_FRAME
  String str) {
  DeclNewStackFrame(caller, "TempSensor_i_tcp_tempSensor_api.c", "", "api_logDebug__building_control_mixed_BuildingControl_TempSensor_i_tcp_tempSensor", 0);

  // Option_A4741E = Option[building_control_mixed.BuildingControl.TempSensor_i_Initialization_Api]
  DeclNewbuilding_control_mixed_BuildingControl_TempSensor_i_Initialization_Api(api);
  Option_A4741E_get_(SF (building_control_mixed_BuildingControl_TempSensor_i_Initialization_Api) &api, building_control_mixed_BuildingControl_TempSensor_i_tcp_tempSensor_Bridge_c_initialization_api(SF_LAST));

  building_control_mixed_BuildingControl_TempSensor_i_Initialization_Api_logDebug_(
    SF
    &api,
    str);
}

void api_logError__building_control_mixed_BuildingControl_TempSensor_i_tcp_tempSensor(
  STACK_FRAME
  String str) {
  DeclNewStackFrame(caller, "TempSensor_i_tcp_tempSensor_api.c", "", "api_logError__building_control_mixed_BuildingControl_TempSensor_i_tcp_tempSensor", 0);

  // Option_A4741E = Option[building_control_mixed.BuildingControl.TempSensor_i_Initialization_Api]
  DeclNewbuilding_control_mixed_BuildingControl_TempSensor_i_Initialization_Api(api);
  Option_A4741E_get_(SF (building_control_mixed_BuildingControl_TempSensor_i_Initialization_Api) &api, building_control_mixed_BuildingControl_TempSensor_i_tcp_tempSensor_Bridge_c_initialization_api(SF_LAST));

  building_control_mixed_BuildingControl_TempSensor_i_Initialization_Api_logError_(
    SF
    &api,
    str);
}

Unit building_control_mixed_BuildingControl_TempSensor_i_tcp_tempSensor_initialise(
  STACK_FRAME
  building_control_mixed_BuildingControl_TempSensor_i_Initialization_Api api) {
  DeclNewStackFrame(caller, "TempSensor_i_tcp_tempSensor_api.c", "", "building_control_mixed_BuildingControl_TempSensor_i_tcp_tempSensor_initialise", 0);

  building_control_mixed_BuildingControl_TempSensor_i_tcp_tempSensor_initialise_(SF_LAST);
}

Unit building_control_mixed_BuildingControl_TempSensor_i_tcp_tempSensor_finalise(
  STACK_FRAME
  building_control_mixed_BuildingControl_TempSensor_i_Operational_Api api) {
  DeclNewStackFrame(caller, "TempSensor_i_tcp_tempSensor_api.c", "", "building_control_mixed_BuildingControl_TempSensor_i_tcp_tempSensor_finalise", 0);

  building_control_mixed_BuildingControl_TempSensor_i_tcp_tempSensor_finalise_(SF_LAST);
}

Unit building_control_mixed_BuildingControl_TempSensor_i_tcp_tempSensor_timeTriggered(
  STACK_FRAME
  building_control_mixed_BuildingControl_TempSensor_i_Operational_Api api) {
  DeclNewStackFrame(caller, "TempSensor_i_tcp_tempSensor_api.c", "", "building_control_mixed_BuildingControl_TempSensor_i_tcp_tempSensor_timeTriggered", 0);

  building_control_mixed_BuildingControl_TempSensor_i_tcp_tempSensor_timeTriggered_(SF_LAST);
}
