// This file will be regenerated, do not edit

#include <sb_TempSensor_i.h>
#include <sb_event_counter.h>
#include <TempSensor_i_tsp_tempSensor_adapter.h>
#include <string.h>
#include <camkes.h>

seqNum_t sb_currentTemp_seqNum;

bool sb_currentTemp_write(const union_art_DataContent * value) {
  return write_sp_union_art_DataContent(sb_currentTemp, value, &sb_currentTemp_seqNum);
}

/************************************************************************
 * sb_tempChanged_enqueue
 * Invoked from user code in the local thread.
 *
 * This is the function invoked by the local thread to make a
 * call to send to a remote event port.
 *
 ************************************************************************/
bool sb_tempChanged_enqueue(void) {
  // sb_tempChanged_counter is a dataport (shared memory) that is written by the sender
  // and read by the receiver(s). This counter is monotonicly increasing,
  // but can wrap.
  (*sb_tempChanged_counter)++;

  // Release memory fence - ensure subsequent write occurs after any preceeding read or write
  sb_tempChanged_counter_release();

  sb_tempChanged_emit();

  return true;
}


// send currentTemp: Out DataPort TemperatureControl__Temperature_i
Unit b_TemperatureControl_TempSensor_i_tsp_tempSensor_seL4Nix_currentTemp_Send(
  STACK_FRAME
  art_DataContent d) {
  DeclNewStackFrame(caller, "sb_TempSensor_i.c", "", "b_TemperatureControl_TempSensor_i_tsp_tempSensor_seL4Nix_currentTemp_Send", 0);

  sb_currentTemp_write(d);
}

// send tempChanged: Out EventPort
Unit b_TemperatureControl_TempSensor_i_tsp_tempSensor_seL4Nix_tempChanged_Send(
  STACK_FRAME
  art_DataContent d) {
  DeclNewStackFrame(caller, "sb_TempSensor_i.c", "", "b_TemperatureControl_TempSensor_i_tsp_tempSensor_seL4Nix_tempChanged_Send", 0);

  // event port - can ignore the Slang Empty payload
  art_Empty payload = (art_Empty) d;

  // send event via CAmkES
  sb_tempChanged_enqueue();
}

void pre_init(void) {
  DeclNewStackFrame(NULL, "sb_TempSensor_i.c", "", "pre_init", 0);

  printf("Entering pre-init of TempSensor_i_tsp_tempSensor\n");

  // initialise data structure for data port currentTemp
  init_sp_union_art_DataContent(sb_currentTemp, &sb_currentTemp_seqNum);

  // initialise shared counter for event port tempChanged
  *sb_tempChanged_counter = 0;

  // initialise slang-embedded components/ports
  b_TemperatureControl_TempSensor_i_tsp_tempSensor_adapter_initialiseArchitecture(SF_LAST);

  // call the component's initialise entrypoint
  b_TemperatureControl_TempSensor_i_tsp_tempSensor_adapter_initialiseEntryPoint(SF_LAST);

  printf("Leaving pre-init of TempSensor_i_tsp_tempSensor\n");
}

/************************************************************************
 * int run(void)
 * Main active thread function.
 ************************************************************************/
int run(void) {
  DeclNewStackFrame(NULL, "sb_TempSensor_i.c", "", "run", 0);


  sb_self_pacer_tick_emit();
  for(;;) {
    sb_self_pacer_tock_wait();
    // call the component's compute entrypoint
    b_TemperatureControl_TempSensor_i_tsp_tempSensor_adapter_computeEntryPoint(SF_LAST);
    sb_self_pacer_tick_emit();
  }
  return 0;
}
