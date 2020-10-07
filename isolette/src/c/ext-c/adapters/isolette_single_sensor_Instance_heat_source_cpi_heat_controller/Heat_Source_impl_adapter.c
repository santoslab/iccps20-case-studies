#include <Heat_Source_impl_adapter.h>

Unit isolette_Devices_Heat_Source_impl_adapter_initialiseArchitecture(STACK_FRAME_ONLY) {
  DeclNewStackFrame(caller, "Heat_Source_impl_adapter.c", "", "isolette_Devices_Heat_Source_impl_adapter_initialiseArchitecture", 0);

  isolette_isolette_single_sensor_Instance_heat_source_cpi_heat_controller_heat_controller_initialiseArchitecture(SF_LAST);
}

Unit isolette_Devices_Heat_Source_impl_adapter_initialiseEntryPoint(STACK_FRAME_ONLY) {
  DeclNewStackFrame(caller, "Heat_Source_impl_adapter.c", "", "isolette_Devices_Heat_Source_impl_adapter_initialiseEntryPoint", 0);

  isolette_isolette_single_sensor_Instance_heat_source_cpi_heat_controller_heat_controller_initialiseEntryPoint(SF_LAST);
}

Unit isolette_Devices_Heat_Source_impl_adapter_computeEntryPoint(STACK_FRAME_ONLY) {
  DeclNewStackFrame(caller, "Heat_Source_impl_adapter.c", "", "isolette_Devices_Heat_Source_impl_adapter_computeEntryPoint", 0);

  isolette_isolette_single_sensor_Instance_heat_source_cpi_heat_controller_heat_controller_computeEntryPoint(SF_LAST);
}

art_Bridge_EntryPoints isolette_Devices_Heat_Source_impl_adapter_entryPoints(STACK_FRAME_ONLY) {
  DeclNewStackFrame(caller, "Heat_Source_impl_adapter.c", "", "isolette_Devices_Heat_Source_impl_adapter_entryPoints", 0);

  return isolette_isolette_single_sensor_Instance_heat_source_cpi_heat_controller_heat_controller_entryPoints(SF_LAST);
}
