#include <all.h>
#include <ipc.h>

static union Option_8E9F45 camkes_buffer[14] = { 0 };

Z building_control_gen_mixed_SharedMemory_create(STACK_FRAME Z id) {
  //printf("building_control_gen_mixed_Shared_Memory_create called with id %i\n", id);

  DeclNewNone_964667(t_0);
  None_964667_apply(CALLER &t_0);
  Type_assign((camkes_buffer + id), (&t_0), sizeof(union Option_8E9F45));

  return -1;
}

void building_control_gen_mixed_SharedMemory_receive(STACK_FRAME art_DataContent result, Z port) {
  printf("building_control_gen_mixed_SharedMemory_receive called with port %i -- NOT IMPLEMENTED\n", port);
}

void building_control_gen_mixed_SharedMemory_receiveAsync(STACK_FRAME Option_8E9F45 result, Z port) {
  union Option_8E9F45 p = camkes_buffer[port];

  if (p.type == TSome_D29615) {
      Type_assign(result, &p, sizeOf((Type) &p));
      memset(camkes_buffer + port, 0, sizeof(union Option_8E9F45));
  } else {
      result->type = TNone_964667;
  }
}

Unit building_control_gen_mixed_SharedMemory_send(STACK_FRAME Z destAppid, Z destPortId, art_DataContent d) {
  printf("building_control_gen_mixed_SharedMemory_send called with port %i -- NOT IMPLEMENTED\n", destPortId);
}

B building_control_gen_mixed_SharedMemory_sendAsync(STACK_FRAME Z destAppId, Z destPortId, art_DataContent d) {
  // printf("building_control_gen_mixed_SharedMemory_sendAsync called with destPortId %i\n", destPortId);

  camkes_sendAsync(destPortId, d);

  return T;
}

Unit building_control_gen_mixed_SharedMemory_remove(STACK_FRAME Z id) {
  printf("building_control_gen_mixed_SharedMemory_remove called with %i -- NOT IMPLEMENTED\n", id);
}

Unit building_control_gen_mixed_Process_sleep(STACK_FRAME Z n) {}

void camkes_In_Port_Data_Transfer (Z port, art_DataContent d) {
  union Option_8E9F45 p = camkes_buffer[port];
  camkes_buffer[port].type = TSome_D29615;
  Type_assign(&(camkes_buffer[port].Some_D29615.value), d, sizeOf((Type) d));
}
