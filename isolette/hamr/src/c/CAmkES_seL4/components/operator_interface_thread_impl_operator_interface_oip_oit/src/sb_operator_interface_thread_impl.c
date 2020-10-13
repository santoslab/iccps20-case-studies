// This file will be regenerated, do not edit

#include <sb_operator_interface_thread_impl.h>
#include <operator_interface_thread_impl_operator_interface_oip_oit_adapter.h>
#include <string.h>
#include <camkes.h>

seqNum_t sb_upper_alarm_tempWstatus_seqNum;

seqNum_t sb_upper_desired_tempWstatus_seqNum;

seqNum_t sb_lower_desired_tempWstatus_seqNum;

seqNum_t sb_alarm_control_seqNum;

seqNum_t sb_display_temperature_seqNum;

seqNum_t sb_monitor_status_seqNum;

seqNum_t sb_regulator_status_seqNum;

/*****************************************************************
 * sb_regulator_status_is_empty:
 *
 * Helper method to determine if the data infrastructure port has
 * received data
 *
 ****************************************************************/
bool sb_regulator_status_is_empty() {
  return is_empty_sp_union_art_DataContent(sb_regulator_status);
}

bool sb_regulator_status_read(union_art_DataContent * value) {
  seqNum_t new_seqNum;
  if ( read_sp_union_art_DataContent(sb_regulator_status, value, &new_seqNum) ) {
    sb_regulator_status_seqNum = new_seqNum;
    return true;
  } else {
    return false;
  } 
}

/*****************************************************************
 * sb_monitor_status_is_empty:
 *
 * Helper method to determine if the data infrastructure port has
 * received data
 *
 ****************************************************************/
bool sb_monitor_status_is_empty() {
  return is_empty_sp_union_art_DataContent(sb_monitor_status);
}

bool sb_monitor_status_read(union_art_DataContent * value) {
  seqNum_t new_seqNum;
  if ( read_sp_union_art_DataContent(sb_monitor_status, value, &new_seqNum) ) {
    sb_monitor_status_seqNum = new_seqNum;
    return true;
  } else {
    return false;
  } 
}

/*****************************************************************
 * sb_display_temperature_is_empty:
 *
 * Helper method to determine if the data infrastructure port has
 * received data
 *
 ****************************************************************/
bool sb_display_temperature_is_empty() {
  return is_empty_sp_union_art_DataContent(sb_display_temperature);
}

bool sb_display_temperature_read(union_art_DataContent * value) {
  seqNum_t new_seqNum;
  if ( read_sp_union_art_DataContent(sb_display_temperature, value, &new_seqNum) ) {
    sb_display_temperature_seqNum = new_seqNum;
    return true;
  } else {
    return false;
  } 
}

/*****************************************************************
 * sb_alarm_control_is_empty:
 *
 * Helper method to determine if the data infrastructure port has
 * received data
 *
 ****************************************************************/
bool sb_alarm_control_is_empty() {
  return is_empty_sp_union_art_DataContent(sb_alarm_control);
}

bool sb_alarm_control_read(union_art_DataContent * value) {
  seqNum_t new_seqNum;
  if ( read_sp_union_art_DataContent(sb_alarm_control, value, &new_seqNum) ) {
    sb_alarm_control_seqNum = new_seqNum;
    return true;
  } else {
    return false;
  } 
}

bool sb_lower_desired_tempWstatus_write(const union_art_DataContent * value) {
  return write_sp_union_art_DataContent(sb_lower_desired_tempWstatus, value, &sb_lower_desired_tempWstatus_seqNum);
}

bool sb_upper_desired_tempWstatus_write(const union_art_DataContent * value) {
  return write_sp_union_art_DataContent(sb_upper_desired_tempWstatus, value, &sb_upper_desired_tempWstatus_seqNum);
}

bool sb_upper_alarm_tempWstatus_write(const union_art_DataContent * value) {
  return write_sp_union_art_DataContent(sb_upper_alarm_tempWstatus, value, &sb_upper_alarm_tempWstatus_seqNum);
}

// send lower_desired_tempWstatus: Out DataPort Isolette_Data_Model__TempWstatus_impl
Unit isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit_seL4Nix_lower_desired_tempWstatus_Send(
  STACK_FRAME
  art_DataContent d) {
  DeclNewStackFrame(caller, "sb_operator_interface_thread_impl.c", "", "isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit_seL4Nix_lower_desired_tempWstatus_Send", 0);

  sb_lower_desired_tempWstatus_write(d);
}

// send upper_desired_tempWstatus: Out DataPort Isolette_Data_Model__TempWstatus_impl
Unit isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit_seL4Nix_upper_desired_tempWstatus_Send(
  STACK_FRAME
  art_DataContent d) {
  DeclNewStackFrame(caller, "sb_operator_interface_thread_impl.c", "", "isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit_seL4Nix_upper_desired_tempWstatus_Send", 0);

  sb_upper_desired_tempWstatus_write(d);
}

// send upper_alarm_tempWstatus: Out DataPort Isolette_Data_Model__TempWstatus_impl
Unit isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit_seL4Nix_upper_alarm_tempWstatus_Send(
  STACK_FRAME
  art_DataContent d) {
  DeclNewStackFrame(caller, "sb_operator_interface_thread_impl.c", "", "isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit_seL4Nix_upper_alarm_tempWstatus_Send", 0);

  sb_upper_alarm_tempWstatus_write(d);
}

// FIXME: dummy implementation for unconnected outgoing port
Unit isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit_seL4Nix_lower_alarm_tempWstatus_Send(
  STACK_FRAME
  art_DataContent d) {
  DeclNewStackFrame(caller, "sb_operator_interface_thread_impl.c", "", "isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit_seL4Nix_lower_alarm_tempWstatus_Send", 0);
  // FIXME: dummy implementation
}

// is_empty regulator_status: In DataPort
B isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit_seL4Nix_regulator_status_IsEmpty(STACK_FRAME_ONLY) {
  return sb_regulator_status_is_empty();
}

// receive regulator_status: In DataPort union_art_DataContent
Unit isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit_seL4Nix_regulator_status_Receive(
  STACK_FRAME
  Option_8E9F45 result) {
  DeclNewStackFrame(caller, "sb_operator_interface_thread_impl.c", "", "isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit_seL4Nix_regulator_status_Receive", 0);

  union_art_DataContent val;
  if(sb_regulator_status_read((union_art_DataContent *) &val)) {
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


// is_empty monitor_status: In DataPort
B isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit_seL4Nix_monitor_status_IsEmpty(STACK_FRAME_ONLY) {
  return sb_monitor_status_is_empty();
}

// receive monitor_status: In DataPort union_art_DataContent
Unit isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit_seL4Nix_monitor_status_Receive(
  STACK_FRAME
  Option_8E9F45 result) {
  DeclNewStackFrame(caller, "sb_operator_interface_thread_impl.c", "", "isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit_seL4Nix_monitor_status_Receive", 0);

  union_art_DataContent val;
  if(sb_monitor_status_read((union_art_DataContent *) &val)) {
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


// is_empty display_temperature: In DataPort
B isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit_seL4Nix_display_temperature_IsEmpty(STACK_FRAME_ONLY) {
  return sb_display_temperature_is_empty();
}

// receive display_temperature: In DataPort union_art_DataContent
Unit isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit_seL4Nix_display_temperature_Receive(
  STACK_FRAME
  Option_8E9F45 result) {
  DeclNewStackFrame(caller, "sb_operator_interface_thread_impl.c", "", "isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit_seL4Nix_display_temperature_Receive", 0);

  union_art_DataContent val;
  if(sb_display_temperature_read((union_art_DataContent *) &val)) {
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


// is_empty alarm_control: In DataPort
B isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit_seL4Nix_alarm_control_IsEmpty(STACK_FRAME_ONLY) {
  return sb_alarm_control_is_empty();
}

// receive alarm_control: In DataPort union_art_DataContent
Unit isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit_seL4Nix_alarm_control_Receive(
  STACK_FRAME
  Option_8E9F45 result) {
  DeclNewStackFrame(caller, "sb_operator_interface_thread_impl.c", "", "isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit_seL4Nix_alarm_control_Receive", 0);

  union_art_DataContent val;
  if(sb_alarm_control_read((union_art_DataContent *) &val)) {
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


void pre_init(void) {
  DeclNewStackFrame(NULL, "sb_operator_interface_thread_impl.c", "", "pre_init", 0);

  printf("Entering pre-init of operator_interface_thread_impl_operator_interface_oip_oit\n");

  // initialise data structure for data port regulator_status
  init_sp_union_art_DataContent(sb_regulator_status, &sb_regulator_status_seqNum);

  // initialise data structure for data port monitor_status
  init_sp_union_art_DataContent(sb_monitor_status, &sb_monitor_status_seqNum);

  // initialise data structure for data port display_temperature
  init_sp_union_art_DataContent(sb_display_temperature, &sb_display_temperature_seqNum);

  // initialise data structure for data port alarm_control
  init_sp_union_art_DataContent(sb_alarm_control, &sb_alarm_control_seqNum);

  // initialise data structure for data port lower_desired_tempWstatus
  init_sp_union_art_DataContent(sb_lower_desired_tempWstatus, &sb_lower_desired_tempWstatus_seqNum);

  // initialise data structure for data port upper_desired_tempWstatus
  init_sp_union_art_DataContent(sb_upper_desired_tempWstatus, &sb_upper_desired_tempWstatus_seqNum);

  // initialise data structure for data port upper_alarm_tempWstatus
  init_sp_union_art_DataContent(sb_upper_alarm_tempWstatus, &sb_upper_alarm_tempWstatus_seqNum);

  // initialise slang-embedded components/ports
  isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit_adapter_initialiseArchitecture(SF_LAST);

  // call the component's initialise entrypoint
  isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit_adapter_initialiseEntryPoint(SF_LAST);

  printf("Leaving pre-init of operator_interface_thread_impl_operator_interface_oip_oit\n");
}

/************************************************************************
 * int run(void)
 * Main active thread function.
 ************************************************************************/
int run(void) {
  DeclNewStackFrame(NULL, "sb_operator_interface_thread_impl.c", "", "run", 0);

  sb_self_pacer_tick_emit();
  for(;;) {
    sb_self_pacer_tock_wait();
    // call the component's compute entrypoint
    isolette_Isolette_operator_interface_thread_impl_operator_interface_oip_oit_adapter_computeEntryPoint(SF_LAST);
    sb_self_pacer_tick_emit();
  }
  return 0;
}
