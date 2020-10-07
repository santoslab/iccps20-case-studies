#ifndef __sb_AADL_TempSensor_i_types__H
#define __sb_AADL_TempSensor_i_types__H

#include <sb_proc_types.h>

bool sb_currentTemp_write(const BuildingControl__Temperature_impl * sb_currentTemp);

bool sb_tempChanged_write(void);

#endif // __sb_AADL_TempSensor_i_types__H
