// This file will be regenerated, do not edit

#include <sb_Fan_i.h>
#include <string.h>
#include <camkes.h>

/************************************************************************
 * sb_fanAck_enqueue:
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
bool sb_fanAck_enqueue(const TemperatureControl__FanAck * sb_fanAck){
  bool sb_result = true;
  sb_result &= sb_fanAck0_enqueue((TemperatureControl__FanAck *) sb_fanAck);
  return sb_result;
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
