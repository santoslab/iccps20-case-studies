// This file will be regenerated, do not edit

#include <sb_TempControl_i.h>
#include <sb_queue_union_art_DataContent_1.h>
#include <sb_event_counter.h>
#include <sb_queue_union_art_DataContent_1.h>
#include <sb_event_counter.h>
#include <TempControl_i_p_tempControl_adapter.h>
#include <string.h>
#include <camkes.h>

seqNum_t sb_currentTemp_seqNum;

/*****************************************************************
 * sb_currentTemp_is_empty:
 *
 * Helper method to determine if the data infrastructure port has
 * received data
 *
 ****************************************************************/
bool sb_currentTemp_is_empty() {
  return is_empty_sp_union_art_DataContent(sb_currentTemp);
}

bool sb_currentTemp_read(union_art_DataContent * value) {
  seqNum_t new_seqNum;
  if ( read_sp_union_art_DataContent(sb_currentTemp, value, &new_seqNum) ) {
    sb_currentTemp_seqNum = new_seqNum;
    return true;
  } else {
    return false;
  } 
}

sb_queue_union_art_DataContent_1_Recv_t sb_fanAck_recv_queue;

/************************************************************************
 * sb_fanAck_dequeue_poll:
 ************************************************************************/
bool sb_fanAck_dequeue_poll(sb_event_counter_t *numDropped, union_art_DataContent *data) {
  return sb_queue_union_art_DataContent_1_dequeue(&sb_fanAck_recv_queue, numDropped, data);
}

/************************************************************************
 * sb_fanAck_dequeue:
 ************************************************************************/
bool sb_fanAck_dequeue(union_art_DataContent *data) {
  sb_event_counter_t numDropped;
  return sb_fanAck_dequeue_poll(&numDropped, data);
}

/************************************************************************
 * sb_fanAck_is_empty:
 *
 * Helper method to determine if infrastructure port has received new
 * events
 ************************************************************************/
bool sb_fanAck_is_empty(){
  return sb_queue_union_art_DataContent_1_is_empty(&sb_fanAck_recv_queue);
}

/************************************************************************
 * sb_fanAck_notification_handler:
 * Invoked by: seL4 notification callback
 *
 * This is the function invoked by an seL4 notification callback to 
 * dispatch the component due to the arrival of an event on port
 * sb_fanAck
 *
 ************************************************************************/
static void sb_fanAck_notification_handler(void * unused) {
  MUTEXOP(sb_dispatch_sem_post())
  CALLBACKOP(sb_fanAck_notification_reg_callback(sb_fanAck_notification_handler, NULL));
}

bool sb_fanCmd_enqueue(const union_art_DataContent *data) {
  sb_queue_union_art_DataContent_1_enqueue(sb_fanCmd_queue_1, (union_art_DataContent*) data);
  sb_fanCmd_1_notification_emit();

  return true;
}

/************************************************************************
 *
 * Static variables and queue management functions for event port:
 *     tempChanged
 *
 ************************************************************************/
static sb_event_counter_t sb_tempChanged_received_events = 0;
static sb_event_counter_t sb_tempChanged_last_counter = 0;

/************************************************************************
 * sb_tempChanged_dequeue:
 * Invoked from local active thread.
 *
 * This is the function invoked by the active thread to decrement the
 * input event index.
 *
 ************************************************************************/
bool sb_tempChanged_dequeue() {
  if(sb_tempChanged_received_events > 0) {
    sb_tempChanged_received_events--;
    return true;
  } else {
    return false;
  }
}

/************************************************************************
 * sb_tempChanged_is_empty;
 *
 * Helper method to determine if infrastructure port has not received
 * any new events since the last dispatch
 *
 ************************************************************************/
bool sb_tempChanged_is_empty() {
  return sb_tempChanged_received_events == 0;
}

void sb_freeze_event_port_tempChanged() {
  sb_event_counter_t current_sb_tempChanged_counter;

  sb_tempChanged_received_events = 0; // drop any events not handled during last dispatch

  // get current shared counter value
  current_sb_tempChanged_counter = *sb_tempChanged_counter;

  // Acquire memory fence - ensure preceding read occurs before any subsequent read or write
  sb_tempChanged_counter_acquire();

  // NOTE: Counters can wrap, so we must use != below instead of >
  while(current_sb_tempChanged_counter != sb_tempChanged_last_counter){
    sb_tempChanged_last_counter++;
    sb_tempChanged_received_events++;
  }

  if(sb_tempChanged_received_events > 0) {

    // tempChanged's queue size is 1
    if(sb_tempChanged_received_events > 1) {
      //printf("TempControl_i: dropping %i event(s) from incoming event port tempChanged\n", (sb_tempChanged_received_events - 1));

      // drop events
      sb_tempChanged_received_events = 1;
    }
  }
}

/************************************************************************
 * sb_tempChanged_handler:
 * Invoked by: seL4 notification callback
 *
 * This is the function invoked by an seL4 notification callback to 
 * dispatch the component due to the arrival of an event on port
 * tempChanged
 *
 ************************************************************************/
static void sb_tempChanged_handler(void * unused) {
  MUTEXOP(sb_dispatch_sem_post())
  CALLBACKOP(sb_tempChanged_reg_callback(sb_tempChanged_handler, NULL));
}

// send fanCmd: Out EventDataPort TemperatureControl__FanCmd
Unit b_TemperatureControl_TempControl_i_p_tempControl_seL4Nix_fanCmd_Send(
  STACK_FRAME
  art_DataContent d) {
  DeclNewStackFrame(caller, "sb_TempControl_i.c", "", "b_TemperatureControl_TempControl_i_p_tempControl_seL4Nix_fanCmd_Send", 0);

  sb_fanCmd_enqueue(d);
}

// is_empty currentTemp: In DataPort
B b_TemperatureControl_TempControl_i_p_tempControl_seL4Nix_currentTemp_IsEmpty(STACK_FRAME_ONLY) {
  return sb_currentTemp_is_empty();
}

// receive currentTemp: In DataPort union_art_DataContent
Unit b_TemperatureControl_TempControl_i_p_tempControl_seL4Nix_currentTemp_Receive(
  STACK_FRAME
  Option_8E9F45 result) {
  DeclNewStackFrame(caller, "sb_TempControl_i.c", "", "b_TemperatureControl_TempControl_i_p_tempControl_seL4Nix_currentTemp_Receive", 0);

  union_art_DataContent val;
  if(sb_currentTemp_read((union_art_DataContent *) &val)) {
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


// is_empty fanAck: In EventDataPort
B b_TemperatureControl_TempControl_i_p_tempControl_seL4Nix_fanAck_IsEmpty(STACK_FRAME_ONLY) {
  return sb_fanAck_is_empty();
}

// receive fanAck: In EventDataPort union_art_DataContent
Unit b_TemperatureControl_TempControl_i_p_tempControl_seL4Nix_fanAck_Receive(
  STACK_FRAME
  Option_8E9F45 result) {
  DeclNewStackFrame(caller, "sb_TempControl_i.c", "", "b_TemperatureControl_TempControl_i_p_tempControl_seL4Nix_fanAck_Receive", 0);

  union_art_DataContent val;
  if(sb_fanAck_dequeue((union_art_DataContent *) &val)) {
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


// is_empty tempChanged: In EventPort
B b_TemperatureControl_TempControl_i_p_tempControl_seL4Nix_tempChanged_IsEmpty(STACK_FRAME_ONLY) {
  return sb_tempChanged_is_empty();
}

// receive tempChanged: In EventPort
Unit b_TemperatureControl_TempControl_i_p_tempControl_seL4Nix_tempChanged_Receive(STACK_FRAME
  Option_8E9F45 result) {
  DeclNewStackFrame(caller, "sb_TempControl_i.c", "", "b_TemperatureControl_TempControl_i_p_tempControl_seL4Nix_tempChanged_Receive", 0);

  if(sb_tempChanged_dequeue()) {
    // event port - ART requires an Empty payload be sent
    DeclNewart_Empty(payload);

    // wrap it in Some and place in result
    DeclNewSome_D29615(some);
    Some_D29615_apply(SF &some, (art_DataContent) &payload);
    Type_assign(result, &some, sizeof(union Option_8E9F45));
  } else {
    // put None in result
    DeclNewNone_964667(none);
    Type_assign(result, &none, sizeof(union Option_8E9F45));
  }
} 

// FIXME: dummy implementation for unconnected incoming port
B b_TemperatureControl_TempControl_i_p_tempControl_seL4Nix_setPoint_IsEmpty(STACK_FRAME_ONLY) {
  return T;
}

// FIXME: dummy implementation for unconnected incoming port
Unit b_TemperatureControl_TempControl_i_p_tempControl_seL4Nix_setPoint_Receive(
  STACK_FRAME
  Option_8E9F45 result) {
  DeclNewStackFrame(caller, "sb_TempControl_i.c", "", "b_TemperatureControl_TempControl_i_p_tempControl_seL4Nix_setPoint_Receive", 0);

  // FIXME: dummy implementation

  // put None in result
  DeclNewNone_964667(none);
  Type_assign(result, &none, sizeof(union Option_8E9F45));
}

void pre_init(void) {
  DeclNewStackFrame(NULL, "sb_TempControl_i.c", "", "pre_init", 0);

  printf("Entering pre-init of TempControl_i_p_tempControl\n");

  // initialise data structure for data port currentTemp
  init_sp_union_art_DataContent(sb_currentTemp, &sb_currentTemp_seqNum);

  // initialise data structure for incoming event data port fanAck
  sb_queue_union_art_DataContent_1_Recv_init(&sb_fanAck_recv_queue, sb_fanAck_queue);

  // initialise data structure for outgoing event data port fanCmd
  sb_queue_union_art_DataContent_1_init(sb_fanCmd_queue_1);

  // initialise slang-embedded components/ports
  b_TemperatureControl_TempControl_i_p_tempControl_adapter_initialiseArchitecture(SF_LAST);

  // call the component's initialise entrypoint
  b_TemperatureControl_TempControl_i_p_tempControl_adapter_initialiseEntryPoint(SF_LAST);

  printf("Leaving pre-init of TempControl_i_p_tempControl\n");
}

void post_init(void) {
  DeclNewStackFrame(NULL, "sb_TempControl_i.c", "", "post_init", 0);

  // register callback for EventDataPort port fanAck
  CALLBACKOP(sb_fanAck_notification_reg_callback(sb_fanAck_notification_handler, NULL));

  // register callback for EventPort port tempChanged
  CALLBACKOP(sb_tempChanged_reg_callback(sb_tempChanged_handler, NULL));
}

/************************************************************************
 * int run(void)
 * Main active thread function.
 ************************************************************************/
int run(void) {
  DeclNewStackFrame(NULL, "sb_TempControl_i.c", "", "run", 0);


  MUTEXOP(sb_dispatch_sem_wait())
  for(;;) {
    MUTEXOP(sb_dispatch_sem_wait())
    sb_freeze_event_port_tempChanged();
    // call the component's compute entrypoint
    b_TemperatureControl_TempControl_i_p_tempControl_adapter_computeEntryPoint(SF_LAST);
  }
  return 0;
}
