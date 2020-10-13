// This file will be regenerated, do not edit

#include <sb_Heat_Source_impl.h>
#include <Heat_Source_impl_heat_source_cpi_heat_controller_adapter.h>
#include <string.h>
#include <camkes.h>

seqNum_t sb_heat_control_seqNum;

/*****************************************************************
 * sb_heat_control_is_empty:
 *
 * Helper method to determine if the data infrastructure port has
 * received data
 *
 ****************************************************************/
bool sb_heat_control_is_empty() {
  return is_empty_sp_union_art_DataContent(sb_heat_control);
}

bool sb_heat_control_read(union_art_DataContent * value) {
  seqNum_t new_seqNum;
  if ( read_sp_union_art_DataContent(sb_heat_control, value, &new_seqNum) ) {
    sb_heat_control_seqNum = new_seqNum;
    return true;
  } else {
    return false;
  } 
}

// FIXME: dummy implementation for unconnected outgoing port
Unit isolette_Devices_Heat_Source_impl_heat_source_cpi_heat_controller_seL4Nix_heat_out_Send(
  STACK_FRAME
  art_DataContent d) {
  DeclNewStackFrame(caller, "sb_Heat_Source_impl.c", "", "isolette_Devices_Heat_Source_impl_heat_source_cpi_heat_controller_seL4Nix_heat_out_Send", 0);
  // FIXME: dummy implementation
}

// is_empty heat_control: In DataPort
B isolette_Devices_Heat_Source_impl_heat_source_cpi_heat_controller_seL4Nix_heat_control_IsEmpty(STACK_FRAME_ONLY) {
  return sb_heat_control_is_empty();
}

// receive heat_control: In DataPort union_art_DataContent
Unit isolette_Devices_Heat_Source_impl_heat_source_cpi_heat_controller_seL4Nix_heat_control_Receive(
  STACK_FRAME
  Option_8E9F45 result) {
  DeclNewStackFrame(caller, "sb_Heat_Source_impl.c", "", "isolette_Devices_Heat_Source_impl_heat_source_cpi_heat_controller_seL4Nix_heat_control_Receive", 0);

  union_art_DataContent val;
  if(sb_heat_control_read((union_art_DataContent *) &val)) {
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
  DeclNewStackFrame(NULL, "sb_Heat_Source_impl.c", "", "pre_init", 0);

  printf("Entering pre-init of Heat_Source_impl_heat_source_cpi_heat_controller\n");

  // initialise data structure for data port heat_control
  init_sp_union_art_DataContent(sb_heat_control, &sb_heat_control_seqNum);

  // initialise slang-embedded components/ports
  isolette_Devices_Heat_Source_impl_heat_source_cpi_heat_controller_adapter_initialiseArchitecture(SF_LAST);

  // call the component's initialise entrypoint
  isolette_Devices_Heat_Source_impl_heat_source_cpi_heat_controller_adapter_initialiseEntryPoint(SF_LAST);

  printf("Leaving pre-init of Heat_Source_impl_heat_source_cpi_heat_controller\n");
}

/************************************************************************
 * int run(void)
 * Main active thread function.
 ************************************************************************/
int run(void) {
  DeclNewStackFrame(NULL, "sb_Heat_Source_impl.c", "", "run", 0);

  sb_self_pacer_tick_emit();
  for(;;) {
    sb_self_pacer_tock_wait();
    // call the component's compute entrypoint
    isolette_Devices_Heat_Source_impl_heat_source_cpi_heat_controller_adapter_computeEntryPoint(SF_LAST);
    sb_self_pacer_tick_emit();
  }
  return 0;
}
