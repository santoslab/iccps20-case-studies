#include <sb_proc_types.h>
#include "../includes/sb_tempControl_currentTemp_Monitor.h"

int monsig_emit(void);

static BuildingControl__Temperature_impl contents;
bool receivedData = false;

bool mon_read(BuildingControl__Temperature_impl * m) {
  *m = contents;
  return receivedData;
}

bool mon_write(const BuildingControl__Temperature_impl * m) {
  receivedData = true;
  contents = *m;
  monsig_emit();
  return receivedData;
}