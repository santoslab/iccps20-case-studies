// This file will be regenerated, do not edit

#include <sb_TempSensor_i.h>
#include <sb_event_counter.h>
#include <TempSensor_i_p_tempSensor_adapter.h>
#include <string.h>
#include <camkes.h>

static bool sb_occurred_periodic_dispatcher;
static int64_t sb_time_periodic_dispatcher;

/************************************************************************
 * periodic_dispatcher_write_int64_t
 * Invoked from remote periodic dispatch thread.
 *
 * This function records the current time and triggers the active thread
 * dispatch from a periodic event.  Note that the periodic dispatch
 * thread is the *only* thread that triggers a dispatch, so we do not
 * mutex lock the function.
 *
 ************************************************************************/

bool periodic_dispatcher_write_int64_t(const int64_t * arg) {
    sb_occurred_periodic_dispatcher = true;
    sb_time_periodic_dispatcher = *arg;
    MUTEXOP(sb_dispatch_sem_post());
    return true;
}

void sb_periodic_dispatch_notification_callback(void *_ UNUSED) {
   // we want time in microseconds, not nanoseconds, so we divide by 1000.
   int64_t sb_time_periodic_dispatcher = 0; // sb_timer_time() / 1000LL -- timer connection disabled;
   (void)periodic_dispatcher_write_int64_t(&sb_time_periodic_dispatcher);
   CALLBACKOP(sb_periodic_dispatch_notification_reg_callback(sb_periodic_dispatch_notification_callback, NULL));
}


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
Unit b_TemperatureControl_TempSensor_i_p_tempSensor_seL4Nix_currentTemp_Send(
  STACK_FRAME
  art_DataContent d) {
  DeclNewStackFrame(caller, "sb_TempSensor_i.c", "", "b_TemperatureControl_TempSensor_i_p_tempSensor_seL4Nix_currentTemp_Send", 0);

  sb_currentTemp_write(d);
}

// send tempChanged: Out EventPort
Unit b_TemperatureControl_TempSensor_i_p_tempSensor_seL4Nix_tempChanged_Send(
  STACK_FRAME
  art_DataContent d) {
  DeclNewStackFrame(caller, "sb_TempSensor_i.c", "", "b_TemperatureControl_TempSensor_i_p_tempSensor_seL4Nix_tempChanged_Send", 0);

  // event port - can ignore the Slang Empty payload
  art_Empty payload = (art_Empty) d;

  // send event via CAmkES
  sb_tempChanged_enqueue();
}

void pre_init(void) {
  DeclNewStackFrame(NULL, "sb_TempSensor_i.c", "", "pre_init", 0);

  printf("Entering pre-init of TempSensor_i_p_tempSensor\n");

  // initialise data structure for data port currentTemp
  init_sp_union_art_DataContent(sb_currentTemp, &sb_currentTemp_seqNum);

  // initialise shared counter for event port tempChanged
  *sb_tempChanged_counter = 0;

  // initialise slang-embedded components/ports
  b_TemperatureControl_TempSensor_i_p_tempSensor_adapter_initialiseArchitecture(SF_LAST);

  // call the component's initialise entrypoint
  b_TemperatureControl_TempSensor_i_p_tempSensor_adapter_initialiseEntryPoint(SF_LAST);

  printf("Leaving pre-init of TempSensor_i_p_tempSensor\n");
}

/************************************************************************
 * int run(void)
 * Main active thread function.
 ************************************************************************/
int run(void) {
  DeclNewStackFrame(NULL, "sb_TempSensor_i.c", "", "run", 0);


  CALLBACKOP(sb_periodic_dispatch_notification_reg_callback(sb_periodic_dispatch_notification_callback, NULL));
  MUTEXOP(sb_dispatch_sem_wait())
  for(;;) {
    MUTEXOP(sb_dispatch_sem_wait())
    // call the component's compute entrypoint
    b_TemperatureControl_TempSensor_i_p_tempSensor_adapter_computeEntryPoint(SF_LAST);
  }
  return 0;
}
