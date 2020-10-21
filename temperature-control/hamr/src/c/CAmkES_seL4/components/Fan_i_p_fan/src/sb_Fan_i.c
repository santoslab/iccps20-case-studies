// This file will be regenerated, do not edit

#include <sb_Fan_i.h>
#include <sb_queue_union_art_DataContent_1.h>
#include <sb_event_counter.h>
#include <sb_queue_union_art_DataContent_1.h>
#include <Fan_i_p_fan_adapter.h>
#include <string.h>
#include <camkes.h>

sb_queue_union_art_DataContent_1_Recv_t sb_fanCmd_recv_queue;

/************************************************************************
 * sb_fanCmd_dequeue_poll:
 ************************************************************************/
bool sb_fanCmd_dequeue_poll(sb_event_counter_t *numDropped, union_art_DataContent *data) {
  return sb_queue_union_art_DataContent_1_dequeue(&sb_fanCmd_recv_queue, numDropped, data);
}

/************************************************************************
 * sb_fanCmd_dequeue:
 ************************************************************************/
bool sb_fanCmd_dequeue(union_art_DataContent *data) {
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
  return sb_queue_union_art_DataContent_1_is_empty(&sb_fanCmd_recv_queue);
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

bool sb_fanAck_enqueue(const union_art_DataContent *data) {
  sb_queue_union_art_DataContent_1_enqueue(sb_fanAck_queue_1, (union_art_DataContent*) data);
  sb_fanAck_1_notification_emit();

  return true;
}

// send fanAck: Out EventDataPort TemperatureControl__FanAck
Unit b_TemperatureControl_Fan_i_p_fan_seL4Nix_fanAck_Send(
  STACK_FRAME
  art_DataContent d) {
  DeclNewStackFrame(caller, "sb_Fan_i.c", "", "b_TemperatureControl_Fan_i_p_fan_seL4Nix_fanAck_Send", 0);

  sb_fanAck_enqueue(d);
}

// is_empty fanCmd: In EventDataPort
B b_TemperatureControl_Fan_i_p_fan_seL4Nix_fanCmd_IsEmpty(STACK_FRAME_ONLY) {
  return sb_fanCmd_is_empty();
}

// receive fanCmd: In EventDataPort union_art_DataContent
Unit b_TemperatureControl_Fan_i_p_fan_seL4Nix_fanCmd_Receive(
  STACK_FRAME
  Option_8E9F45 result) {
  DeclNewStackFrame(caller, "sb_Fan_i.c", "", "b_TemperatureControl_Fan_i_p_fan_seL4Nix_fanCmd_Receive", 0);

  union_art_DataContent val;
  if(sb_fanCmd_dequeue((union_art_DataContent *) &val)) {
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
  DeclNewStackFrame(NULL, "sb_Fan_i.c", "", "pre_init", 0);

  printf("Entering pre-init of Fan_i_p_fan\n");

  // initialise data structure for incoming event data port fanCmd
  sb_queue_union_art_DataContent_1_Recv_init(&sb_fanCmd_recv_queue, sb_fanCmd_queue);

  // initialise data structure for outgoing event data port fanAck
  sb_queue_union_art_DataContent_1_init(sb_fanAck_queue_1);

  // initialise slang-embedded components/ports
  b_TemperatureControl_Fan_i_p_fan_adapter_initialiseArchitecture(SF_LAST);

  // call the component's initialise entrypoint
  b_TemperatureControl_Fan_i_p_fan_adapter_initialiseEntryPoint(SF_LAST);

  printf("Leaving pre-init of Fan_i_p_fan\n");
}

void post_init(void) {
  DeclNewStackFrame(NULL, "sb_Fan_i.c", "", "post_init", 0);

  // register callback for EventDataPort port fanCmd
  CALLBACKOP(sb_fanCmd_notification_reg_callback(sb_fanCmd_notification_handler, NULL));
}

/************************************************************************
 * int run(void)
 * Main active thread function.
 ************************************************************************/
int run(void) {
  DeclNewStackFrame(NULL, "sb_Fan_i.c", "", "run", 0);

  MUTEXOP(sb_dispatch_sem_wait())
  for(;;) {
    MUTEXOP(sb_dispatch_sem_wait())
    // call the component's compute entrypoint
    b_TemperatureControl_Fan_i_p_fan_adapter_computeEntryPoint(SF_LAST);
  }
  return 0;
}
