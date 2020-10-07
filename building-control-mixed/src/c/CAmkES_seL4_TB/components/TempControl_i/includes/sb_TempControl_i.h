#ifndef __sb_AADL_TempControl_i_types__H
#define __sb_AADL_TempControl_i_types__H

#include <sb_proc_types.h>

bool sb_currentTemp_read(BuildingControl__Temperature_impl * sb_currentTemp);

bool sb_fanAck_dequeue(BuildingControl__FanAck * sb_fanAck);

bool sb_setPoint_dequeue(BuildingControl__SetPoint_impl * sb_setPoint);

bool sb_fanCmd_enqueue(const BuildingControl__FanCmd * sb_fanCmd);

bool sb_tempChanged_read(void);

#endif // __sb_AADL_TempControl_i_types__H
