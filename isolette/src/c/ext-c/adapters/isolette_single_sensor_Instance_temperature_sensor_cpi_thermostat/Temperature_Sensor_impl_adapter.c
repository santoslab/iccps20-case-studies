#include <Temperature_Sensor_impl_adapter.h>

Unit isolette_Devices_Temperature_Sensor_impl_adapter_initialiseArchitecture(STACK_FRAME_ONLY) {
  DeclNewStackFrame(caller, "Temperature_Sensor_impl_adapter.c", "", "isolette_Devices_Temperature_Sensor_impl_adapter_initialiseArchitecture", 0);

  isolette_isolette_single_sensor_Instance_temperature_sensor_cpi_thermostat_thermostat_initialiseArchitecture(SF_LAST);
}

Unit isolette_Devices_Temperature_Sensor_impl_adapter_initialiseEntryPoint(STACK_FRAME_ONLY) {
  DeclNewStackFrame(caller, "Temperature_Sensor_impl_adapter.c", "", "isolette_Devices_Temperature_Sensor_impl_adapter_initialiseEntryPoint", 0);

  isolette_isolette_single_sensor_Instance_temperature_sensor_cpi_thermostat_thermostat_initialiseEntryPoint(SF_LAST);
}

Unit isolette_Devices_Temperature_Sensor_impl_adapter_computeEntryPoint(STACK_FRAME_ONLY) {
  DeclNewStackFrame(caller, "Temperature_Sensor_impl_adapter.c", "", "isolette_Devices_Temperature_Sensor_impl_adapter_computeEntryPoint", 0);

  isolette_isolette_single_sensor_Instance_temperature_sensor_cpi_thermostat_thermostat_computeEntryPoint(SF_LAST);
}

art_Bridge_EntryPoints isolette_Devices_Temperature_Sensor_impl_adapter_entryPoints(STACK_FRAME_ONLY) {
  DeclNewStackFrame(caller, "Temperature_Sensor_impl_adapter.c", "", "isolette_Devices_Temperature_Sensor_impl_adapter_entryPoints", 0);

  return isolette_isolette_single_sensor_Instance_temperature_sensor_cpi_thermostat_thermostat_entryPoints(SF_LAST);
}
