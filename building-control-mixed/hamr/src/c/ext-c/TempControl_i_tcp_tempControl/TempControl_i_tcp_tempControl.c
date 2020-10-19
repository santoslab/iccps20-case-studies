#include <TempControl_i_tcp_tempControl_api.h>
#include <TempControl_i_tcp_tempControl.h>
#include <ext.h>

// This file will not be overwritten so is safe to edit

struct building_control_mixed_BuildingControl_SetPoint_i setPoint;

Unit building_control_mixed_BuildingControl_TempControl_i_tcp_tempControl_initialise_(STACK_FRAME_ONLY) {
  DeclNewStackFrame(caller, "TempControl_i_tcp_tempControl.c", "", "building_control_mixed_BuildingControl_TempControl_i_tcp_tempControl_initialise_", 0);

  // setPoint port not currently hooked up so create default value 
  DeclNewbuilding_control_mixed_BuildingControl_Temperature_i(low);
  low.degrees = 55.0;
  low.unit = building_control_mixed_BuildingControl_TempUnit_Type_Fahrenheit;
   
  DeclNewbuilding_control_mixed_BuildingControl_Temperature_i(high);
  high.degrees = 100.0;
  high.unit = building_control_mixed_BuildingControl_TempUnit_Type_Fahrenheit;
  
  setPoint.low = low;
  setPoint.high = high;
  
  api_send_fanCmd__building_control_mixed_BuildingControl_TempControl_i_tcp_tempControl(SF
    building_control_mixed_BuildingControl_FanCmd_Type_Off);
}

Unit building_control_mixed_BuildingControl_TempControl_i_tcp_tempControl_handlefanAck_(
  STACK_FRAME
  building_control_mixed_BuildingControl_FanAck_Type value) {
  DeclNewStackFrame(caller, "TempControl_i_tcp_tempControl.c", "", "building_control_mixed_BuildingControl_TempControl_i_tcp_tempControl_handlefanAck_", 0);

  String str = string("received fanAck ");
  building_control_mixed_BuildingControl_FanAck_Type_string_(SF str, value);
  api_logInfo__building_control_mixed_BuildingControl_TempControl_i_tcp_tempControl(SF
    str);
    
  if(value == building_control_mixed_BuildingControl_FanAck_Type_Error) {
    str = string("Actuation failed!");
  } else {
    str = string("Actuation worked!");
  } 
  api_logInfo__building_control_mixed_BuildingControl_TempControl_i_tcp_tempControl(SF str);
}

Unit building_control_mixed_BuildingControl_TempControl_i_tcp_tempControl_handlesetPoint_(
  STACK_FRAME
  building_control_mixed_BuildingControl_SetPoint_i value) {
  DeclNewStackFrame(caller, "TempControl_i_tcp_tempControl.c", "", "building_control_mixed_BuildingControl_TempControl_i_tcp_tempControl_handlesetPoint_", 0);

  String str = string("received setPoint ");
  building_control_mixed_BuildingControl_SetPoint_i_string_(SF str, value);
  api_logInfo__building_control_mixed_BuildingControl_TempControl_i_tcp_tempControl(SF str);
  
  setPoint = convertSetPointToFahrenheit(value);
}

void api_logInfo(STACK_FRAME String str) {
  api_logInfo__building_control_mixed_BuildingControl_TempControl_i_tcp_tempControl(CALLER str);
}

void api_send_fanCmd(STACK_FRAME building_control_mixed_BuildingControl_FanCmd_Type value){
  api_send_fanCmd__building_control_mixed_BuildingControl_TempControl_i_tcp_tempControl(CALLER value);
}

bool api_get_currentTemp(STACK_FRAME building_control_mixed_BuildingControl_Temperature_i currentTemp) {
  return api_get_currentTemp__building_control_mixed_BuildingControl_TempControl_i_tcp_tempControl(CALLER currentTemp);
}

building_control_mixed_BuildingControl_FanCmd_Type FanCmd_Type_On = building_control_mixed_BuildingControl_FanCmd_Type_On;
building_control_mixed_BuildingControl_FanCmd_Type FanCmd_Type_Off = building_control_mixed_BuildingControl_FanCmd_Type_Off;

Unit building_control_mixed_BuildingControl_TempControl_i_tcp_tempControl_handletempChanged_(STACK_FRAME_ONLY) {
  DeclNewStackFrame(caller, "TempControl_i_tcp_tempControl.c", "", "building_control_mixed_BuildingControl_TempControl_i_tcp_tempControl_handletempChanged_", 0);

  DeclNewbuilding_control_mixed_BuildingControl_Temperature_i(currentTemp);
  if(api_get_currentTemp(SF &currentTemp)){
    struct building_control_mixed_BuildingControl_Temperature_i currentTempInF = 
      convertTemperatureToFahrenheit(&currentTemp);
    
    String str = string("received ");
    building_control_mixed_BuildingControl_Temperature_i_string_(SF str, &currentTemp);
    api_logInfo(SF str);
    
    str = string("Sent fan command: ");
    if(currentTemp.degrees > setPoint.high.degrees) {
      api_send_fanCmd(SF FanCmd_Type_On);
      building_control_mixed_BuildingControl_FanCmd_Type_string_(SF str, 
        FanCmd_Type_On);
    }
    else if(currentTemp.degrees < setPoint.low.degrees) {
      api_send_fanCmd(SF FanCmd_Type_Off);
      building_control_mixed_BuildingControl_FanCmd_Type_string_(SF str, 
       FanCmd_Type_Off);
    } else {
      str = string("Temperature ok:");
    }
    
    api_logInfo(SF str);
  } 
}

Unit building_control_mixed_BuildingControl_TempControl_i_tcp_tempControl_finalise_(STACK_FRAME_ONLY) {
  DeclNewStackFrame(caller, "TempControl_i_tcp_tempControl.c", "", "building_control_mixed_BuildingControl_TempControl_i_tcp_tempControl_finalise_", 0);

  // example finalise method
}
