#include <TempSensor_i_tsp_tempSensor_adapter.h>

Unit b_TemperatureControl_TempSensor_i_tsp_tempSensor_adapter_initialiseArchitecture(STACK_FRAME_ONLY) {
  DeclNewStackFrame(caller, "TempSensor_i_tsp_tempSensor_adapter.c", "", "b_TemperatureControl_TempSensor_i_tsp_tempSensor_adapter_initialiseArchitecture", 0);

  b_TempSensor_i_tsp_tempSensor_tempSensor_initialiseArchitecture(SF_LAST);
}

Unit b_TemperatureControl_TempSensor_i_tsp_tempSensor_adapter_initialiseEntryPoint(STACK_FRAME_ONLY) {
  DeclNewStackFrame(caller, "TempSensor_i_tsp_tempSensor_adapter.c", "", "b_TemperatureControl_TempSensor_i_tsp_tempSensor_adapter_initialiseEntryPoint", 0);

  b_TempSensor_i_tsp_tempSensor_tempSensor_initialiseEntryPoint(SF_LAST);
}

Unit b_TemperatureControl_TempSensor_i_tsp_tempSensor_adapter_computeEntryPoint(STACK_FRAME_ONLY) {
  DeclNewStackFrame(caller, "TempSensor_i_tsp_tempSensor_adapter.c", "", "b_TemperatureControl_TempSensor_i_tsp_tempSensor_adapter_computeEntryPoint", 0);

  b_TempSensor_i_tsp_tempSensor_tempSensor_computeEntryPoint(SF_LAST);
}

art_Bridge_EntryPoints b_TemperatureControl_TempSensor_i_tsp_tempSensor_adapter_entryPoints(STACK_FRAME_ONLY) {
  DeclNewStackFrame(caller, "TempSensor_i_tsp_tempSensor_adapter.c", "", "b_TemperatureControl_TempSensor_i_tsp_tempSensor_adapter_entryPoints", 0);

  return b_TempSensor_i_tsp_tempSensor_tempSensor_entryPoints(SF_LAST);
}
