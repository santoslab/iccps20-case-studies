#include <sb_types.h>
#include <sb_tempControl_currentTemp_Monitor.h>

int monsig_emit(void);

static TemperatureControl__Temperature_i contents;
bool receivedData = false;

bool mon_is_empty() {
  return !receivedData;
}

bool mon_read(TemperatureControl__Temperature_i * m) {
  *m = contents;
  return receivedData;
}

bool mon_write(const TemperatureControl__Temperature_i * m) {
  receivedData = true;
  contents = *m;
  monsig_emit();
  return receivedData;
}