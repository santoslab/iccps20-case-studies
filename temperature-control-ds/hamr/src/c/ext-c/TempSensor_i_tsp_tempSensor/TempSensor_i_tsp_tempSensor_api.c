#include <TempSensor_i_tsp_tempSensor_api.h>
#include <TempSensor_i_tsp_tempSensor.h>

// This file was auto-generated.  Do not edit

void api_send_currentTemp__b_TemperatureControl_TempSensor_i_tsp_tempSensor(
  STACK_FRAME
  b_TemperatureControl_Temperature_i value) {
  DeclNewStackFrame(caller, "TempSensor_i_tsp_tempSensor_api.c", "", "api_send_currentTemp__b_TemperatureControl_TempSensor_i_tsp_tempSensor", 0);

  // Option_FBA42F = Option[b.TemperatureControl.TempSensor_i_Initialization_Api]
  DeclNewb_TemperatureControl_TempSensor_i_Initialization_Api(api);
  Option_FBA42F_get_(SF (b_TemperatureControl_TempSensor_i_Initialization_Api) &api, b_TemperatureControl_TempSensor_i_tsp_tempSensor_Bridge_c_initialization_api(SF_LAST));

  b_TemperatureControl_TempSensor_i_Initialization_Api_setcurrentTemp_(
    SF
    &api,
    value);
}

void api_send_tempChanged__b_TemperatureControl_TempSensor_i_tsp_tempSensor(STACK_FRAME_ONLY) {
  DeclNewStackFrame(caller, "TempSensor_i_tsp_tempSensor_api.c", "", "api_send_tempChanged__b_TemperatureControl_TempSensor_i_tsp_tempSensor", 0);

  // Option_FBA42F = Option[b.TemperatureControl.TempSensor_i_Initialization_Api]
  DeclNewb_TemperatureControl_TempSensor_i_Initialization_Api(api);
  Option_FBA42F_get_(SF (b_TemperatureControl_TempSensor_i_Initialization_Api) &api, b_TemperatureControl_TempSensor_i_tsp_tempSensor_Bridge_c_initialization_api(SF_LAST));

  b_TemperatureControl_TempSensor_i_Initialization_Api_sendtempChanged_(
    SF
    &api);
}

void api_logInfo__b_TemperatureControl_TempSensor_i_tsp_tempSensor(
  STACK_FRAME
  String str) {
  DeclNewStackFrame(caller, "TempSensor_i_tsp_tempSensor_api.c", "", "api_logInfo__b_TemperatureControl_TempSensor_i_tsp_tempSensor", 0);

  // Option_FBA42F = Option[b.TemperatureControl.TempSensor_i_Initialization_Api]
  DeclNewb_TemperatureControl_TempSensor_i_Initialization_Api(api);
  Option_FBA42F_get_(SF (b_TemperatureControl_TempSensor_i_Initialization_Api) &api, b_TemperatureControl_TempSensor_i_tsp_tempSensor_Bridge_c_initialization_api(SF_LAST));

  b_TemperatureControl_TempSensor_i_Initialization_Api_logInfo_(
    SF
    &api,
    str);
}

void api_logDebug__b_TemperatureControl_TempSensor_i_tsp_tempSensor(
  STACK_FRAME
  String str) {
  DeclNewStackFrame(caller, "TempSensor_i_tsp_tempSensor_api.c", "", "api_logDebug__b_TemperatureControl_TempSensor_i_tsp_tempSensor", 0);

  // Option_FBA42F = Option[b.TemperatureControl.TempSensor_i_Initialization_Api]
  DeclNewb_TemperatureControl_TempSensor_i_Initialization_Api(api);
  Option_FBA42F_get_(SF (b_TemperatureControl_TempSensor_i_Initialization_Api) &api, b_TemperatureControl_TempSensor_i_tsp_tempSensor_Bridge_c_initialization_api(SF_LAST));

  b_TemperatureControl_TempSensor_i_Initialization_Api_logDebug_(
    SF
    &api,
    str);
}

void api_logError__b_TemperatureControl_TempSensor_i_tsp_tempSensor(
  STACK_FRAME
  String str) {
  DeclNewStackFrame(caller, "TempSensor_i_tsp_tempSensor_api.c", "", "api_logError__b_TemperatureControl_TempSensor_i_tsp_tempSensor", 0);

  // Option_FBA42F = Option[b.TemperatureControl.TempSensor_i_Initialization_Api]
  DeclNewb_TemperatureControl_TempSensor_i_Initialization_Api(api);
  Option_FBA42F_get_(SF (b_TemperatureControl_TempSensor_i_Initialization_Api) &api, b_TemperatureControl_TempSensor_i_tsp_tempSensor_Bridge_c_initialization_api(SF_LAST));

  b_TemperatureControl_TempSensor_i_Initialization_Api_logError_(
    SF
    &api,
    str);
}

Unit b_TemperatureControl_TempSensor_i_tsp_tempSensor_initialise(
  STACK_FRAME
  b_TemperatureControl_TempSensor_i_Initialization_Api api) {
  DeclNewStackFrame(caller, "TempSensor_i_tsp_tempSensor_api.c", "", "b_TemperatureControl_TempSensor_i_tsp_tempSensor_initialise", 0);

  b_TemperatureControl_TempSensor_i_tsp_tempSensor_initialise_(SF_LAST);
}

Unit b_TemperatureControl_TempSensor_i_tsp_tempSensor_finalise(
  STACK_FRAME
  b_TemperatureControl_TempSensor_i_Operational_Api api) {
  DeclNewStackFrame(caller, "TempSensor_i_tsp_tempSensor_api.c", "", "b_TemperatureControl_TempSensor_i_tsp_tempSensor_finalise", 0);

  b_TemperatureControl_TempSensor_i_tsp_tempSensor_finalise_(SF_LAST);
}

Unit b_TemperatureControl_TempSensor_i_tsp_tempSensor_timeTriggered(
  STACK_FRAME
  b_TemperatureControl_TempSensor_i_Operational_Api api) {
  DeclNewStackFrame(caller, "TempSensor_i_tsp_tempSensor_api.c", "", "b_TemperatureControl_TempSensor_i_tsp_tempSensor_timeTriggered", 0);

  b_TemperatureControl_TempSensor_i_tsp_tempSensor_timeTriggered_(SF_LAST);
}
