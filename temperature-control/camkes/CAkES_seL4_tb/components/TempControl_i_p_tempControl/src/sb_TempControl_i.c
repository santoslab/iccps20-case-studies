// This file will be regenerated, do not edit

#include <sb_TempControl_i.h>
#include <string.h>
#include <camkes.h>

/************************************************************************
 * sb_fanCmd_enqueue:
 * Invoked from user code in the local thread.
 *
 * This is the function invoked by the local thread to make a
 * call to write to a remote event data port.
 *
 * XXX: When simulating fan out, the caller of this function will only
 * receive a positive response when all enqueues are successful. When a
 * negative response is received it only indicates that at least one
 * enqueue attempt failed.
 *
 ************************************************************************/
bool sb_fanCmd_enqueue(const TemperatureControl__FanCmd * sb_fanCmd){
  bool sb_result = true;
  sb_result &= sb_fanCmd0_enqueue((TemperatureControl__FanCmd *) sb_fanCmd);
  return sb_result;
}

/************************************************************************
 * sb_tempChanged_handler:
 * Invoked by: seL4 notification callback
 *
 * This is the function invoked by an seL4 notification callback that
 * dispatches the active-thread due to the arrival of an event on
 * its tempChanged event port
 *
 ************************************************************************/
static void sb_tempChanged_handler(void *_ UNUSED){
  MUTEXOP(sb_dispatch_sem_post());
  CALLBACKOP(sb_tempChanged_notification_reg_callback(sb_tempChanged_handler, NULL));
}

void pre_init(void) {
  CALLBACKOP(sb_tempChanged_notification_reg_callback(sb_tempChanged_handler, NULL));
}

/************************************************************************
 * int run(void)
 * Main active thread function.
 ************************************************************************/
int run(void) {
  MUTEXOP(sb_dispatch_sem_wait())
  for(;;) {
    MUTEXOP(sb_dispatch_sem_wait())
  }
  return 0;
}
