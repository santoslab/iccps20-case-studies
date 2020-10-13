#include <Fan_i_tcp_fan_adapter.h>

Unit building_control_mixed_BuildingControl_Fan_i_tcp_fan_adapter_initialiseArchitecture(STACK_FRAME_ONLY) {
  DeclNewStackFrame(caller, "Fan_i_tcp_fan_adapter.c", "", "building_control_mixed_BuildingControl_Fan_i_tcp_fan_adapter_initialiseArchitecture", 0);

  building_control_mixed_Fan_i_tcp_fan_fan_initialiseArchitecture(SF_LAST);
}

Unit building_control_mixed_BuildingControl_Fan_i_tcp_fan_adapter_initialiseEntryPoint(STACK_FRAME_ONLY) {
  DeclNewStackFrame(caller, "Fan_i_tcp_fan_adapter.c", "", "building_control_mixed_BuildingControl_Fan_i_tcp_fan_adapter_initialiseEntryPoint", 0);

  building_control_mixed_Fan_i_tcp_fan_fan_initialiseEntryPoint(SF_LAST);
}

Unit building_control_mixed_BuildingControl_Fan_i_tcp_fan_adapter_computeEntryPoint(STACK_FRAME_ONLY) {
  DeclNewStackFrame(caller, "Fan_i_tcp_fan_adapter.c", "", "building_control_mixed_BuildingControl_Fan_i_tcp_fan_adapter_computeEntryPoint", 0);

  building_control_mixed_Fan_i_tcp_fan_fan_computeEntryPoint(SF_LAST);
}

art_Bridge_EntryPoints building_control_mixed_BuildingControl_Fan_i_tcp_fan_adapter_entryPoints(STACK_FRAME_ONLY) {
  DeclNewStackFrame(caller, "Fan_i_tcp_fan_adapter.c", "", "building_control_mixed_BuildingControl_Fan_i_tcp_fan_adapter_entryPoints", 0);

  return building_control_mixed_Fan_i_tcp_fan_fan_entryPoints(SF_LAST);
}
