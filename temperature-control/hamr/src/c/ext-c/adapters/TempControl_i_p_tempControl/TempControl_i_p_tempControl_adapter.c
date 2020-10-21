#include <TempControl_i_p_tempControl_adapter.h>

Unit b_TemperatureControl_TempControl_i_p_tempControl_adapter_initialiseArchitecture(STACK_FRAME_ONLY) {
  DeclNewStackFrame(caller, "TempControl_i_p_tempControl_adapter.c", "", "b_TemperatureControl_TempControl_i_p_tempControl_adapter_initialiseArchitecture", 0);

  b_TempControl_i_p_tempControl_tempControl_initialiseArchitecture(SF_LAST);
}

Unit b_TemperatureControl_TempControl_i_p_tempControl_adapter_initialiseEntryPoint(STACK_FRAME_ONLY) {
  DeclNewStackFrame(caller, "TempControl_i_p_tempControl_adapter.c", "", "b_TemperatureControl_TempControl_i_p_tempControl_adapter_initialiseEntryPoint", 0);

  b_TempControl_i_p_tempControl_tempControl_initialiseEntryPoint(SF_LAST);
}

Unit b_TemperatureControl_TempControl_i_p_tempControl_adapter_computeEntryPoint(STACK_FRAME_ONLY) {
  DeclNewStackFrame(caller, "TempControl_i_p_tempControl_adapter.c", "", "b_TemperatureControl_TempControl_i_p_tempControl_adapter_computeEntryPoint", 0);

  b_TempControl_i_p_tempControl_tempControl_computeEntryPoint(SF_LAST);
}

art_Bridge_EntryPoints b_TemperatureControl_TempControl_i_p_tempControl_adapter_entryPoints(STACK_FRAME_ONLY) {
  DeclNewStackFrame(caller, "TempControl_i_p_tempControl_adapter.c", "", "b_TemperatureControl_TempControl_i_p_tempControl_adapter_entryPoints", 0);

  return b_TempControl_i_p_tempControl_tempControl_entryPoints(SF_LAST);
}
