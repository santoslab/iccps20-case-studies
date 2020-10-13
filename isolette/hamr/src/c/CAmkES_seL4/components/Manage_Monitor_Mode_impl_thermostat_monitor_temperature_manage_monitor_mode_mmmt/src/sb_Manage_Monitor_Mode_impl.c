// This file will be regenerated, do not edit

#include <sb_Manage_Monitor_Mode_impl.h>
#include <Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_mmmt_adapter.h>
#include <string.h>
#include <camkes.h>

seqNum_t sb_monitor_mode_seqNum;

seqNum_t sb_interface_failure_seqNum;

seqNum_t sb_current_tempWstatus_seqNum;

/*****************************************************************
 * sb_current_tempWstatus_is_empty:
 *
 * Helper method to determine if the data infrastructure port has
 * received data
 *
 ****************************************************************/
bool sb_current_tempWstatus_is_empty() {
  return is_empty_sp_union_art_DataContent(sb_current_tempWstatus);
}

bool sb_current_tempWstatus_read(union_art_DataContent * value) {
  seqNum_t new_seqNum;
  if ( read_sp_union_art_DataContent(sb_current_tempWstatus, value, &new_seqNum) ) {
    sb_current_tempWstatus_seqNum = new_seqNum;
    return true;
  } else {
    return false;
  } 
}

/*****************************************************************
 * sb_interface_failure_is_empty:
 *
 * Helper method to determine if the data infrastructure port has
 * received data
 *
 ****************************************************************/
bool sb_interface_failure_is_empty() {
  return is_empty_sp_union_art_DataContent(sb_interface_failure);
}

bool sb_interface_failure_read(union_art_DataContent * value) {
  seqNum_t new_seqNum;
  if ( read_sp_union_art_DataContent(sb_interface_failure, value, &new_seqNum) ) {
    sb_interface_failure_seqNum = new_seqNum;
    return true;
  } else {
    return false;
  } 
}

bool sb_monitor_mode_write(const union_art_DataContent * value) {
  return write_sp_union_art_DataContent(sb_monitor_mode, value, &sb_monitor_mode_seqNum);
}

// send monitor_mode: Out DataPort Isolette_Data_Model__Monitor_Mode
Unit isolette_Monitor_Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_mmmt_seL4Nix_monitor_mode_Send(
  STACK_FRAME
  art_DataContent d) {
  DeclNewStackFrame(caller, "sb_Manage_Monitor_Mode_impl.c", "", "isolette_Monitor_Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_mmmt_seL4Nix_monitor_mode_Send", 0);

  sb_monitor_mode_write(d);
}

// is_empty current_tempWstatus: In DataPort
B isolette_Monitor_Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_mmmt_seL4Nix_current_tempWstatus_IsEmpty(STACK_FRAME_ONLY) {
  return sb_current_tempWstatus_is_empty();
}

// receive current_tempWstatus: In DataPort union_art_DataContent
Unit isolette_Monitor_Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_mmmt_seL4Nix_current_tempWstatus_Receive(
  STACK_FRAME
  Option_8E9F45 result) {
  DeclNewStackFrame(caller, "sb_Manage_Monitor_Mode_impl.c", "", "isolette_Monitor_Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_mmmt_seL4Nix_current_tempWstatus_Receive", 0);

  union_art_DataContent val;
  if(sb_current_tempWstatus_read((union_art_DataContent *) &val)) {
    // wrap payload in Some and place in result
    DeclNewSome_D29615(some);
    Some_D29615_apply(SF &some, (art_DataContent) &val);
    Type_assign(result, &some, sizeof(union Option_8E9F45));
  } else {
    // put None in result
    DeclNewNone_964667(none);
    Type_assign(result, &none, sizeof(union Option_8E9F45));
  }
}


// is_empty interface_failure: In DataPort
B isolette_Monitor_Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_mmmt_seL4Nix_interface_failure_IsEmpty(STACK_FRAME_ONLY) {
  return sb_interface_failure_is_empty();
}

// receive interface_failure: In DataPort union_art_DataContent
Unit isolette_Monitor_Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_mmmt_seL4Nix_interface_failure_Receive(
  STACK_FRAME
  Option_8E9F45 result) {
  DeclNewStackFrame(caller, "sb_Manage_Monitor_Mode_impl.c", "", "isolette_Monitor_Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_mmmt_seL4Nix_interface_failure_Receive", 0);

  union_art_DataContent val;
  if(sb_interface_failure_read((union_art_DataContent *) &val)) {
    // wrap payload in Some and place in result
    DeclNewSome_D29615(some);
    Some_D29615_apply(SF &some, (art_DataContent) &val);
    Type_assign(result, &some, sizeof(union Option_8E9F45));
  } else {
    // put None in result
    DeclNewNone_964667(none);
    Type_assign(result, &none, sizeof(union Option_8E9F45));
  }
}


// FIXME: dummy implementation for unconnected incoming port
B isolette_Monitor_Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_mmmt_seL4Nix_internal_failure_IsEmpty(STACK_FRAME_ONLY) {
  return T;
}

// FIXME: dummy implementation for unconnected incoming port
Unit isolette_Monitor_Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_mmmt_seL4Nix_internal_failure_Receive(
  STACK_FRAME
  Option_8E9F45 result) {
  DeclNewStackFrame(caller, "sb_Manage_Monitor_Mode_impl.c", "", "isolette_Monitor_Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_mmmt_seL4Nix_internal_failure_Receive", 0);

  // FIXME: dummy implementation

  // put None in result
  DeclNewNone_964667(none);
  Type_assign(result, &none, sizeof(union Option_8E9F45));
}

void pre_init(void) {
  DeclNewStackFrame(NULL, "sb_Manage_Monitor_Mode_impl.c", "", "pre_init", 0);

  printf("Entering pre-init of Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_mmmt\n");

  // initialise data structure for data port current_tempWstatus
  init_sp_union_art_DataContent(sb_current_tempWstatus, &sb_current_tempWstatus_seqNum);

  // initialise data structure for data port interface_failure
  init_sp_union_art_DataContent(sb_interface_failure, &sb_interface_failure_seqNum);

  // initialise data structure for data port monitor_mode
  init_sp_union_art_DataContent(sb_monitor_mode, &sb_monitor_mode_seqNum);

  // initialise slang-embedded components/ports
  isolette_Monitor_Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_mmmt_adapter_initialiseArchitecture(SF_LAST);

  // call the component's initialise entrypoint
  isolette_Monitor_Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_mmmt_adapter_initialiseEntryPoint(SF_LAST);

  printf("Leaving pre-init of Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_mmmt\n");
}

/************************************************************************
 * int run(void)
 * Main active thread function.
 ************************************************************************/
int run(void) {
  DeclNewStackFrame(NULL, "sb_Manage_Monitor_Mode_impl.c", "", "run", 0);

  sb_self_pacer_tick_emit();
  for(;;) {
    sb_self_pacer_tock_wait();
    // call the component's compute entrypoint
    isolette_Monitor_Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_mmmt_adapter_computeEntryPoint(SF_LAST);
    sb_self_pacer_tick_emit();
  }
  return 0;
}
