#include "../includes/sb_TempControl_i.h"
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
bool sb_fanCmd_enqueue(const BuildingControl__FanCmd * sb_fanCmd){
  bool sb_result = true;
  sb_result &= sb_fanCmd0_enqueue((BuildingControl__FanCmd *) sb_fanCmd);
  return sb_result;
}

/************************************************************************
 *
 * Static variables and queue management functions for event port:
 *     tempChanged
 *
 ************************************************************************/
static bool sb_tempChanged_index = false;

/************************************************************************
 * sb_tempChanged_handler:
 * Invoked by: seL4 notification callback
 *
 * This is the function invoked by an seL4 notification callback to 
 * write to an active-thread input event port.  It increments a count 
 * of received events.
 *
 ************************************************************************/
static void sb_tempChanged_handler(void *_ UNUSED){
  sb_tempChanged_index = true;
  MUTEXOP(sb_dispatch_sem_post());
  CALLBACKOP(sb_tempChanged_reg_callback(sb_tempChanged_handler, NULL));
}

/************************************************************************
 * sb_tempChanged_read:
 * Invoked from local active thread.
 *
 * This is the function invoked by the active thread to decrement the
 * input event index.
 *
 ************************************************************************/
bool sb_tempChanged_read(){
  bool result;
  result = sb_tempChanged_index;
  sb_tempChanged_index = false;
  return result;
}


void pre_init(void) {
}

/************************************************************************
 * int run(void)
 * Main active thread function.
 ************************************************************************/
int run(void) {

  for(;;) {
    MUTEXOP(sb_dispatch_sem_wait())

  }
  return 0;
}
