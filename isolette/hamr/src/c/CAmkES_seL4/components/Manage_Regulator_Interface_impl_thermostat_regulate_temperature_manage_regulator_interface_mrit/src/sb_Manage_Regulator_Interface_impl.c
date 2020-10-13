// This file will be regenerated, do not edit

#include <sb_Manage_Regulator_Interface_impl.h>
#include <Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_adapter.h>
#include <string.h>
#include <camkes.h>

seqNum_t sb_interface_failure_seqNum;

seqNum_t sb_regulator_status_seqNum;

seqNum_t sb_displayed_temp_seqNum;

seqNum_t sb_lower_desired_temp_seqNum;

seqNum_t sb_upper_desired_temp_seqNum;

seqNum_t sb_regulator_mode_seqNum;

seqNum_t sb_upper_desired_tempWstatus_seqNum;

seqNum_t sb_lower_desired_tempWstatus_seqNum;

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
 * sb_lower_desired_tempWstatus_is_empty:
 *
 * Helper method to determine if the data infrastructure port has
 * received data
 *
 ****************************************************************/
bool sb_lower_desired_tempWstatus_is_empty() {
  return is_empty_sp_union_art_DataContent(sb_lower_desired_tempWstatus);
}

bool sb_lower_desired_tempWstatus_read(union_art_DataContent * value) {
  seqNum_t new_seqNum;
  if ( read_sp_union_art_DataContent(sb_lower_desired_tempWstatus, value, &new_seqNum) ) {
    sb_lower_desired_tempWstatus_seqNum = new_seqNum;
    return true;
  } else {
    return false;
  } 
}

/*****************************************************************
 * sb_upper_desired_tempWstatus_is_empty:
 *
 * Helper method to determine if the data infrastructure port has
 * received data
 *
 ****************************************************************/
bool sb_upper_desired_tempWstatus_is_empty() {
  return is_empty_sp_union_art_DataContent(sb_upper_desired_tempWstatus);
}

bool sb_upper_desired_tempWstatus_read(union_art_DataContent * value) {
  seqNum_t new_seqNum;
  if ( read_sp_union_art_DataContent(sb_upper_desired_tempWstatus, value, &new_seqNum) ) {
    sb_upper_desired_tempWstatus_seqNum = new_seqNum;
    return true;
  } else {
    return false;
  } 
}

/*****************************************************************
 * sb_regulator_mode_is_empty:
 *
 * Helper method to determine if the data infrastructure port has
 * received data
 *
 ****************************************************************/
bool sb_regulator_mode_is_empty() {
  return is_empty_sp_union_art_DataContent(sb_regulator_mode);
}

bool sb_regulator_mode_read(union_art_DataContent * value) {
  seqNum_t new_seqNum;
  if ( read_sp_union_art_DataContent(sb_regulator_mode, value, &new_seqNum) ) {
    sb_regulator_mode_seqNum = new_seqNum;
    return true;
  } else {
    return false;
  } 
}

bool sb_upper_desired_temp_write(const union_art_DataContent * value) {
  return write_sp_union_art_DataContent(sb_upper_desired_temp, value, &sb_upper_desired_temp_seqNum);
}

bool sb_lower_desired_temp_write(const union_art_DataContent * value) {
  return write_sp_union_art_DataContent(sb_lower_desired_temp, value, &sb_lower_desired_temp_seqNum);
}

bool sb_displayed_temp_write(const union_art_DataContent * value) {
  return write_sp_union_art_DataContent(sb_displayed_temp, value, &sb_displayed_temp_seqNum);
}

bool sb_regulator_status_write(const union_art_DataContent * value) {
  return write_sp_union_art_DataContent(sb_regulator_status, value, &sb_regulator_status_seqNum);
}

bool sb_interface_failure_write(const union_art_DataContent * value) {
  return write_sp_union_art_DataContent(sb_interface_failure, value, &sb_interface_failure_seqNum);
}

// send upper_desired_temp: Out DataPort Isolette_Data_Model__Temp_impl
Unit isolette_Regulate_Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_seL4Nix_upper_desired_temp_Send(
  STACK_FRAME
  art_DataContent d) {
  DeclNewStackFrame(caller, "sb_Manage_Regulator_Interface_impl.c", "", "isolette_Regulate_Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_seL4Nix_upper_desired_temp_Send", 0);

  sb_upper_desired_temp_write(d);
}

// send lower_desired_temp: Out DataPort Isolette_Data_Model__Temp_impl
Unit isolette_Regulate_Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_seL4Nix_lower_desired_temp_Send(
  STACK_FRAME
  art_DataContent d) {
  DeclNewStackFrame(caller, "sb_Manage_Regulator_Interface_impl.c", "", "isolette_Regulate_Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_seL4Nix_lower_desired_temp_Send", 0);

  sb_lower_desired_temp_write(d);
}

// send displayed_temp: Out DataPort Isolette_Data_Model__Temp_impl
Unit isolette_Regulate_Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_seL4Nix_displayed_temp_Send(
  STACK_FRAME
  art_DataContent d) {
  DeclNewStackFrame(caller, "sb_Manage_Regulator_Interface_impl.c", "", "isolette_Regulate_Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_seL4Nix_displayed_temp_Send", 0);

  sb_displayed_temp_write(d);
}

// send regulator_status: Out DataPort Isolette_Data_Model__Status
Unit isolette_Regulate_Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_seL4Nix_regulator_status_Send(
  STACK_FRAME
  art_DataContent d) {
  DeclNewStackFrame(caller, "sb_Manage_Regulator_Interface_impl.c", "", "isolette_Regulate_Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_seL4Nix_regulator_status_Send", 0);

  sb_regulator_status_write(d);
}

// send interface_failure: Out DataPort Isolette_Data_Model__Failure_Flag_impl
Unit isolette_Regulate_Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_seL4Nix_interface_failure_Send(
  STACK_FRAME
  art_DataContent d) {
  DeclNewStackFrame(caller, "sb_Manage_Regulator_Interface_impl.c", "", "isolette_Regulate_Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_seL4Nix_interface_failure_Send", 0);

  sb_interface_failure_write(d);
}

// is_empty current_tempWstatus: In DataPort
B isolette_Regulate_Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_seL4Nix_current_tempWstatus_IsEmpty(STACK_FRAME_ONLY) {
  return sb_current_tempWstatus_is_empty();
}

// receive current_tempWstatus: In DataPort union_art_DataContent
Unit isolette_Regulate_Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_seL4Nix_current_tempWstatus_Receive(
  STACK_FRAME
  Option_8E9F45 result) {
  DeclNewStackFrame(caller, "sb_Manage_Regulator_Interface_impl.c", "", "isolette_Regulate_Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_seL4Nix_current_tempWstatus_Receive", 0);

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


// is_empty lower_desired_tempWstatus: In DataPort
B isolette_Regulate_Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_seL4Nix_lower_desired_tempWstatus_IsEmpty(STACK_FRAME_ONLY) {
  return sb_lower_desired_tempWstatus_is_empty();
}

// receive lower_desired_tempWstatus: In DataPort union_art_DataContent
Unit isolette_Regulate_Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_seL4Nix_lower_desired_tempWstatus_Receive(
  STACK_FRAME
  Option_8E9F45 result) {
  DeclNewStackFrame(caller, "sb_Manage_Regulator_Interface_impl.c", "", "isolette_Regulate_Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_seL4Nix_lower_desired_tempWstatus_Receive", 0);

  union_art_DataContent val;
  if(sb_lower_desired_tempWstatus_read((union_art_DataContent *) &val)) {
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


// is_empty upper_desired_tempWstatus: In DataPort
B isolette_Regulate_Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_seL4Nix_upper_desired_tempWstatus_IsEmpty(STACK_FRAME_ONLY) {
  return sb_upper_desired_tempWstatus_is_empty();
}

// receive upper_desired_tempWstatus: In DataPort union_art_DataContent
Unit isolette_Regulate_Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_seL4Nix_upper_desired_tempWstatus_Receive(
  STACK_FRAME
  Option_8E9F45 result) {
  DeclNewStackFrame(caller, "sb_Manage_Regulator_Interface_impl.c", "", "isolette_Regulate_Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_seL4Nix_upper_desired_tempWstatus_Receive", 0);

  union_art_DataContent val;
  if(sb_upper_desired_tempWstatus_read((union_art_DataContent *) &val)) {
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


// is_empty regulator_mode: In DataPort
B isolette_Regulate_Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_seL4Nix_regulator_mode_IsEmpty(STACK_FRAME_ONLY) {
  return sb_regulator_mode_is_empty();
}

// receive regulator_mode: In DataPort union_art_DataContent
Unit isolette_Regulate_Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_seL4Nix_regulator_mode_Receive(
  STACK_FRAME
  Option_8E9F45 result) {
  DeclNewStackFrame(caller, "sb_Manage_Regulator_Interface_impl.c", "", "isolette_Regulate_Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_seL4Nix_regulator_mode_Receive", 0);

  union_art_DataContent val;
  if(sb_regulator_mode_read((union_art_DataContent *) &val)) {
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
  DeclNewStackFrame(NULL, "sb_Manage_Regulator_Interface_impl.c", "", "pre_init", 0);

  printf("Entering pre-init of Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit\n");

  // initialise data structure for data port current_tempWstatus
  init_sp_union_art_DataContent(sb_current_tempWstatus, &sb_current_tempWstatus_seqNum);

  // initialise data structure for data port lower_desired_tempWstatus
  init_sp_union_art_DataContent(sb_lower_desired_tempWstatus, &sb_lower_desired_tempWstatus_seqNum);

  // initialise data structure for data port upper_desired_tempWstatus
  init_sp_union_art_DataContent(sb_upper_desired_tempWstatus, &sb_upper_desired_tempWstatus_seqNum);

  // initialise data structure for data port regulator_mode
  init_sp_union_art_DataContent(sb_regulator_mode, &sb_regulator_mode_seqNum);

  // initialise data structure for data port upper_desired_temp
  init_sp_union_art_DataContent(sb_upper_desired_temp, &sb_upper_desired_temp_seqNum);

  // initialise data structure for data port lower_desired_temp
  init_sp_union_art_DataContent(sb_lower_desired_temp, &sb_lower_desired_temp_seqNum);

  // initialise data structure for data port displayed_temp
  init_sp_union_art_DataContent(sb_displayed_temp, &sb_displayed_temp_seqNum);

  // initialise data structure for data port regulator_status
  init_sp_union_art_DataContent(sb_regulator_status, &sb_regulator_status_seqNum);

  // initialise data structure for data port interface_failure
  init_sp_union_art_DataContent(sb_interface_failure, &sb_interface_failure_seqNum);

  // initialise slang-embedded components/ports
  isolette_Regulate_Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_adapter_initialiseArchitecture(SF_LAST);

  // call the component's initialise entrypoint
  isolette_Regulate_Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_adapter_initialiseEntryPoint(SF_LAST);

  printf("Leaving pre-init of Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit\n");
}

/************************************************************************
 * int run(void)
 * Main active thread function.
 ************************************************************************/
int run(void) {
  DeclNewStackFrame(NULL, "sb_Manage_Regulator_Interface_impl.c", "", "run", 0);

  sb_self_pacer_tick_emit();
  for(;;) {
    sb_self_pacer_tock_wait();
    // call the component's compute entrypoint
    isolette_Regulate_Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_adapter_computeEntryPoint(SF_LAST);
    sb_self_pacer_tick_emit();
  }
  return 0;
}
