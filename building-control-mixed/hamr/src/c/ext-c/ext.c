#include <all.h>

#define MIN_TEMP 55
#define MAX_TEMP 100

static int temp = 0;
static int delta = 4;

building_control_mixed_BuildingControl_FanAck_Type building_control_mixed_BuildingControl_FanNative_fanCmdActuate(STACK_FRAME building_control_mixed_BuildingControl_FanCmd_Type cmd) {
  return building_control_mixed_BuildingControl_FanAck_Type_Ok;
}

void building_control_mixed_BuildingControl_TempSensorNative_currentTempGet(STACK_FRAME building_control_mixed_BuildingControl_Temperature_i result) {
  if (temp == 0) {
    temp = MIN_TEMP;
  }
  temp += delta;
  if (temp < MIN_TEMP) delta = 4;
  else if (temp > MAX_TEMP) delta = -4;
  result->degrees = (F32) temp;
  result->unit = building_control_mixed_BuildingControl_TempUnit_Type_Fahrenheit;
}