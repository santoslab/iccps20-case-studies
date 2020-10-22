#include <all.h>
#include <ext.h>

// add c extension code here

#define MIN_TEMP 55
#define MAX_TEMP 100

static int temp = 0;
static int delta = 4;

b_TemperatureControl_FanAck_Type b_TemperatureControl_FanNative_fanCmdActuate(STACK_FRAME b_TemperatureControl_FanCmd_Type cmd){
  return b_TemperatureControl_FanAck_Type_Ok;
}

void b_TemperatureControl_TempSensorNative_currentTempGet(STACK_FRAME b_TemperatureControl_Temperature_i result){
  // simulate
  if (temp == 0) {
    temp = MIN_TEMP;
  }
  temp += delta;
  if (temp < MIN_TEMP) delta = 4;
  else if (temp > MAX_TEMP) delta = -4;
  result->degrees = (F32) temp;
  result->unit = b_TemperatureControl_TempUnit_Type_Fahrenheit;
}