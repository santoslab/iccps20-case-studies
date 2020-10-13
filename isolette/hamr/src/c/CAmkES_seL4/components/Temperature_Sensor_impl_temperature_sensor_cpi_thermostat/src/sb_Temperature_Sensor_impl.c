// This file will be regenerated, do not edit

#include <sb_Temperature_Sensor_impl.h>
#include <Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_adapter.h>
#include <string.h>
#include <camkes.h>

seqNum_t sb_current_tempWstatus_seqNum;

bool sb_current_tempWstatus_write(const union_art_DataContent * value) {
  return write_sp_union_art_DataContent(sb_current_tempWstatus, value, &sb_current_tempWstatus_seqNum);
}

// send current_tempWstatus: Out DataPort Isolette_Data_Model__TempWstatus_impl
Unit isolette_Devices_Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_seL4Nix_current_tempWstatus_Send(
  STACK_FRAME
  art_DataContent d) {
  DeclNewStackFrame(caller, "sb_Temperature_Sensor_impl.c", "", "isolette_Devices_Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_seL4Nix_current_tempWstatus_Send", 0);

  sb_current_tempWstatus_write(d);
}

// FIXME: dummy implementation for unconnected incoming port
B isolette_Devices_Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_seL4Nix_air_IsEmpty(STACK_FRAME_ONLY) {
  return T;
}

// FIXME: dummy implementation for unconnected incoming port
Unit isolette_Devices_Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_seL4Nix_air_Receive(
  STACK_FRAME
  Option_8E9F45 result) {
  DeclNewStackFrame(caller, "sb_Temperature_Sensor_impl.c", "", "isolette_Devices_Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_seL4Nix_air_Receive", 0);

  // FIXME: dummy implementation

  // put None in result
  DeclNewNone_964667(none);
  Type_assign(result, &none, sizeof(union Option_8E9F45));
}

void pre_init(void) {
  DeclNewStackFrame(NULL, "sb_Temperature_Sensor_impl.c", "", "pre_init", 0);

  printf("Entering pre-init of Temperature_Sensor_impl_temperature_sensor_cpi_thermostat\n");

  // initialise data structure for data port current_tempWstatus
  init_sp_union_art_DataContent(sb_current_tempWstatus, &sb_current_tempWstatus_seqNum);

  // initialise slang-embedded components/ports
  isolette_Devices_Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_adapter_initialiseArchitecture(SF_LAST);

  // call the component's initialise entrypoint
  isolette_Devices_Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_adapter_initialiseEntryPoint(SF_LAST);

  printf("Leaving pre-init of Temperature_Sensor_impl_temperature_sensor_cpi_thermostat\n");
}

/************************************************************************
 * int run(void)
 * Main active thread function.
 ************************************************************************/
int run(void) {
  DeclNewStackFrame(NULL, "sb_Temperature_Sensor_impl.c", "", "run", 0);

  sb_self_pacer_tick_emit();
  for(;;) {
    sb_self_pacer_tock_wait();
    // call the component's compute entrypoint
    isolette_Devices_Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_adapter_computeEntryPoint(SF_LAST);
    sb_self_pacer_tick_emit();
  }
  return 0;
}
