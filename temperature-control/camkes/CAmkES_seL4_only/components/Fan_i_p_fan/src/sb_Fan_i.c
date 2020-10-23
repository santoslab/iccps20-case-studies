// This file will be regenerated, do not edit

#include <sb_Fan_i.h>
#include <sb_queue_TemperatureControl__FanCmd_1.h>
#include <sb_event_counter.h>
#include <sb_queue_TemperatureControl__FanAck_1.h>
#include <string.h>
#include <camkes.h>

sb_queue_TemperatureControl__FanCmd_1_Recv_t sb_fanCmd_recv_queue;

/************************************************************************
 * sb_fanCmd_dequeue_poll:
 ************************************************************************/
bool sb_fanCmd_dequeue_poll(sb_event_counter_t *numDropped, TemperatureControl__FanCmd *data) {
  return sb_queue_TemperatureControl__FanCmd_1_dequeue(&sb_fanCmd_recv_queue, numDropped, data);
}

/************************************************************************
 * sb_fanCmd_dequeue:
 ************************************************************************/
bool sb_fanCmd_dequeue(TemperatureControl__FanCmd *data) {
  sb_event_counter_t numDropped;
  return sb_fanCmd_dequeue_poll(&numDropped, data);
}

/************************************************************************
 * sb_fanCmd_is_empty:
 *
 * Helper method to determine if infrastructure port has received new
 * events
 ************************************************************************/
bool sb_fanCmd_is_empty(){
  return sb_queue_TemperatureControl__FanCmd_1_is_empty(&sb_fanCmd_recv_queue);
}

/************************************************************************
 * sb_fanCmd_notification_handler:
 * Invoked by: seL4 notification callback
 *
 * This is the function invoked by an seL4 notification callback to 
 * dispatch the component due to the arrival of an event on port
 * sb_fanCmd
 *
 ************************************************************************/
static void sb_fanCmd_notification_handler(void * unused) {
  MUTEXOP(sb_dispatch_sem_post())
  CALLBACKOP(sb_fanCmd_notification_reg_callback(sb_fanCmd_notification_handler, NULL));
}

bool sb_fanAck_enqueue(const TemperatureControl__FanAck *data) {
  sb_queue_TemperatureControl__FanAck_1_enqueue(sb_fanAck_queue_1, (TemperatureControl__FanAck*) data);
  sb_fanAck_1_notification_emit();

  return true;
}

void pre_init(void) {
  // initialise data structure for incoming event data port fanCmd
  sb_queue_TemperatureControl__FanCmd_1_Recv_init(&sb_fanCmd_recv_queue, sb_fanCmd_queue);

  // initialise data structure for outgoing event data port fanAck
  sb_queue_TemperatureControl__FanAck_1_init(sb_fanAck_queue_1);
}

void post_init(void) {
  // register callback for EventDataPort port fanCmd
  CALLBACKOP(sb_fanCmd_notification_reg_callback(sb_fanCmd_notification_handler, NULL));
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
