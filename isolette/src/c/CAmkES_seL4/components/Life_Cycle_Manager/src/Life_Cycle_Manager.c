#include <camkes.h>
#include <stdio.h>
#include <sel4/sel4.h>

int run(void) {

  int8_t tickCount = 0;

  while (1) {
    //printf("%s: Period tick %d\n", get_instance_name(), tickCount);

    tickCount++;

    tick_emit();

    if(tickCount % 2 == 0) {
      printf("Life_Cycle_Manager: Sending step\n");
      step_emit();
    }

    tock_wait();
  }

  return 0;
}