// This file will be regenerated, do not edit

#include <sb_Manage_Heat_Source_impl.h>
#include <Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_mhst_adapter.h>
#include <string.h>
#include <camkes.h>

seqNum_t sb_heat_control_seqNum;

seqNum_t sb_regulator_mode_seqNum;

seqNum_t sb_upper_desired_temp_seqNum;

seqNum_t sb_lower_desired_temp_seqNum;

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
 * sb_lower_desired_temp_is_empty:
 *
 * Helper method to determine if the data infrastructure port has
 * received data
 *
 ****************************************************************/
bool sb_lower_desired_temp_is_empty() {
  return is_empty_sp_union_art_DataContent(sb_lower_desired_temp);
}

bool sb_lower_desired_temp_read(union_art_DataContent * value) {
  seqNum_t new_seqNum;
  if ( read_sp_union_art_DataContent(sb_lower_desired_temp, value, &new_seqNum) ) {
    sb_lower_desired_temp_seqNum = new_seqNum;
    return true;
  } else {
    return false;
  } 
}

/*****************************************************************
 * sb_upper_desired_temp_is_empty:
 *
 * Helper method to determine if the data infrastructure port has
 * received data
 *
 ****************************************************************/
bool sb_upper_desired_temp_is_empty() {
  return is_empty_sp_union_art_DataContent(sb_upper_desired_temp);
}

bool sb_upper_desired_temp_read(union_art_DataContent * value) {
  seqNum_t new_seqNum;
  if ( read_sp_union_art_DataContent(sb_upper_desired_temp, value, &new_seqNum) ) {
    sb_upper_desired_temp_seqNum = new_seqNum;
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

bool sb_heat_control_write(const union_art_DataContent * value) {
  return write_sp_union_art_DataContent(sb_heat_control, value, &sb_heat_control_seqNum);
}

// send heat_control: Out DataPort Isolette_Data_Model__On_Off
Unit isolette_Regulate_Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_mhst_seL4Nix_heat_control_Send(
  STACK_FRAME
  art_DataContent d) {
  DeclNewStackFrame(caller, "sb_Manage_Heat_Source_impl.c", "", "isolette_Regulate_Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_mhst_seL4Nix_heat_control_Send", 0);

  sb_heat_control_write(d);
}

// is_empty current_tempWstatus: In DataPort
B isolette_Regulate_Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_mhst_seL4Nix_current_tempWstatus_IsEmpty(STACK_FRAME_ONLY) {
  return sb_current_tempWstatus_is_empty();
}

// receive current_tempWstatus: In DataPort union_art_DataContent
Unit isolette_Regulate_Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_mhst_seL4Nix_current_tempWstatus_Receive(
  STACK_FRAME
  Option_8E9F45 result) {
  DeclNewStackFrame(caller, "sb_Manage_Heat_Source_impl.c", "", "isolette_Regulate_Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_mhst_seL4Nix_current_tempWstatus_Receive", 0);

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


// is_empty lower_desired_temp: In DataPort
B isolette_Regulate_Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_mhst_seL4Nix_lower_desired_temp_IsEmpty(STACK_FRAME_ONLY) {
  return sb_lower_desired_temp_is_empty();
}

// receive lower_desired_temp: In DataPort union_art_DataContent
Unit isolette_Regulate_Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_mhst_seL4Nix_lower_desired_temp_Receive(
  STACK_FRAME
  Option_8E9F45 result) {
  DeclNewStackFrame(caller, "sb_Manage_Heat_Source_impl.c", "", "isolette_Regulate_Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_mhst_seL4Nix_lower_desired_temp_Receive", 0);

  union_art_DataContent val;
  if(sb_lower_desired_temp_read((union_art_DataContent *) &val)) {
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


// is_empty upper_desired_temp: In DataPort
B isolette_Regulate_Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_mhst_seL4Nix_upper_desired_temp_IsEmpty(STACK_FRAME_ONLY) {
  return sb_upper_desired_temp_is_empty();
}

// receive upper_desired_temp: In DataPort union_art_DataContent
Unit isolette_Regulate_Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_mhst_seL4Nix_upper_desired_temp_Receive(
  STACK_FRAME
  Option_8E9F45 result) {
  DeclNewStackFrame(caller, "sb_Manage_Heat_Source_impl.c", "", "isolette_Regulate_Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_mhst_seL4Nix_upper_desired_temp_Receive", 0);

  union_art_DataContent val;
  if(sb_upper_desired_temp_read((union_art_DataContent *) &val)) {
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
B isolette_Regulate_Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_mhst_seL4Nix_regulator_mode_IsEmpty(STACK_FRAME_ONLY) {
  return sb_regulator_mode_is_empty();
}

// receive regulator_mode: In DataPort union_art_DataContent
Unit isolette_Regulate_Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_mhst_seL4Nix_regulator_mode_Receive(
  STACK_FRAME
  Option_8E9F45 result) {
  DeclNewStackFrame(caller, "sb_Manage_Heat_Source_impl.c", "", "isolette_Regulate_Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_mhst_seL4Nix_regulator_mode_Receive", 0);

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
  DeclNewStackFrame(NULL, "sb_Manage_Heat_Source_impl.c", "", "pre_init", 0);

  printf("Entering pre-init of Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_mhst\n");

  // initialise data structure for data port current_tempWstatus
  init_sp_union_art_DataContent(sb_current_tempWstatus, &sb_current_tempWstatus_seqNum);

  // initialise data structure for data port lower_desired_temp
  init_sp_union_art_DataContent(sb_lower_desired_temp, &sb_lower_desired_temp_seqNum);

  // initialise data structure for data port upper_desired_temp
  init_sp_union_art_DataContent(sb_upper_desired_temp, &sb_upper_desired_temp_seqNum);

  // initialise data structure for data port regulator_mode
  init_sp_union_art_DataContent(sb_regulator_mode, &sb_regulator_mode_seqNum);

  // initialise data structure for data port heat_control
  init_sp_union_art_DataContent(sb_heat_control, &sb_heat_control_seqNum);

  // initialise slang-embedded components/ports
  isolette_Regulate_Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_mhst_adapter_initialiseArchitecture(SF_LAST);

  // call the component's initialise entrypoint
  isolette_Regulate_Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_mhst_adapter_initialiseEntryPoint(SF_LAST);

  printf("Leaving pre-init of Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_mhst\n");
}

/************************************************************************
 * int run(void)
 * Main active thread function.
 ************************************************************************/
int run(void) {
  DeclNewStackFrame(NULL, "sb_Manage_Heat_Source_impl.c", "", "run", 0);

  sb_self_pacer_tick_emit();
  for(;;) {
    sb_self_pacer_tock_wait();
    // call the component's compute entrypoint
    isolette_Regulate_Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_mhst_adapter_computeEntryPoint(SF_LAST);
    sb_self_pacer_tick_emit();
  }
  return 0;
}
