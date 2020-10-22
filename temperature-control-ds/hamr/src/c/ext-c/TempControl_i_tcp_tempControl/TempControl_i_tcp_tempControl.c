#include <TempControl_i_tcp_tempControl_api.h>
#include <TempControl_i_tcp_tempControl.h>
#include <ext.h>

// This file will not be overwritten so is safe to edit

struct b_TemperatureControl_SetPoint_i setPoint;

Unit b_TemperatureControl_TempControl_i_tcp_tempControl_initialise_(STACK_FRAME_ONLY) {
  DeclNewStackFrame(caller, "TempControl_i_tcp_tempControl.c", "", "b_TemperatureControl_TempControl_i_tcp_tempControl_initialise_", 0);

  // setPoint port not currently hooked up so create default value
  DeclNewb_TemperatureControl_Temperature_i(low);
  low.degrees = MIN_TEMP;
  low.unit = b_TemperatureControl_TempUnit_Type_Fahrenheit;

  DeclNewb_TemperatureControl_Temperature_i(high);
  high.degrees = MAX_TEMP;
  high.unit = b_TemperatureControl_TempUnit_Type_Fahrenheit;

  setPoint.low = low;
  setPoint.high = high;
}

Unit b_TemperatureControl_TempControl_i_tcp_tempControl_handlefanAck_(
  STACK_FRAME
  b_TemperatureControl_FanAck_Type value) {
  DeclNewStackFrame(caller, "TempControl_i_tcp_tempControl.c", "", "b_TemperatureControl_TempControl_i_tcp_tempControl_handlefanAck_", 0);

  DeclNewString(_str);
  String str = (String) & _str;
  String__append(str, string("received fanAck "));
  b_TemperatureControl_FanAck_Type_string_(SF str, value);
  api_logInfo__b_TemperatureControl_TempControl_i_tcp_tempControl(SF
    str);

  if(value == b_TemperatureControl_FanAck_Type_Error) {
    str = string("Actuation failed!");
  } else {
    str = string("Actuation worked!");
  }
  api_logInfo__b_TemperatureControl_TempControl_i_tcp_tempControl(SF str);
}

Unit b_TemperatureControl_TempControl_i_tcp_tempControl_handlesetPoint_(
  STACK_FRAME
  b_TemperatureControl_SetPoint_i value) {
  DeclNewStackFrame(caller, "TempControl_i_tcp_tempControl.c", "", "b_TemperatureControl_TempControl_i_tcp_tempControl_handlesetPoint_", 0);

  DeclNewString(_str);
  String str = (String) &_str;
  String__append(str, string("received setPoint "));
  b_TemperatureControl_SetPoint_i_string_(SF str, value);
  api_logInfo__b_TemperatureControl_TempControl_i_tcp_tempControl(SF str);

  setPoint = convertSetPointToFahrenheit(value);
}

Unit b_TemperatureControl_TempControl_i_tcp_tempControl_handletempChanged_(STACK_FRAME_ONLY) {
  DeclNewStackFrame(caller, "TempControl_i_tcp_tempControl.c", "", "b_TemperatureControl_TempControl_i_tcp_tempControl_handletempChanged_", 0);

  DeclNewb_TemperatureControl_Temperature_i(currTemp);
  if(api_get_currentTemp__b_TemperatureControl_TempControl_i_tcp_tempControl(SF &currTemp)){
    struct b_TemperatureControl_Temperature_i currTempInF =
      convertTemperatureToFahrenheit(&currTemp);

    DeclNewString(_str1);
    String str = (String) &_str1;
    String__append(str, string("Received: "));
    b_TemperatureControl_Temperature_i_string_(SF str, &currTempInF);
    api_logInfo__b_TemperatureControl_TempControl_i_tcp_tempControl(SF str);

    DeclNewString(_str2);
    str = (String) &_str2;
    if(currTempInF.degrees > setPoint.high.degrees) {
      String__append(str, string("Sent fan command: "));
      api_send_fanCmd__b_TemperatureControl_TempControl_i_tcp_tempControl(SF
      b_TemperatureControl_FanCmd_Type_On);
      b_TemperatureControl_FanCmd_Type_string_(SF str,
        b_TemperatureControl_FanCmd_Type_On);
    }
    else if(currTempInF.degrees < setPoint.low.degrees) {
      String__append(str, string("Sent fan command: "));
      api_send_fanCmd__b_TemperatureControl_TempControl_i_tcp_tempControl(SF
      b_TemperatureControl_FanCmd_Type_Off);
      b_TemperatureControl_FanCmd_Type_string_(SF str,
       b_TemperatureControl_FanCmd_Type_Off);
    } else {
      String__append(str, string("Temperature ok:"));
    }

    api_logInfo__b_TemperatureControl_TempControl_i_tcp_tempControl(SF str);
  }
}


Unit b_TemperatureControl_TempControl_i_tcp_tempControl_finalise_(STACK_FRAME_ONLY) {
  DeclNewStackFrame(caller, "TempControl_i_tcp_tempControl.c", "", "b_TemperatureControl_TempControl_i_tcp_tempControl_finalise_", 0);

  // do nothing
}
