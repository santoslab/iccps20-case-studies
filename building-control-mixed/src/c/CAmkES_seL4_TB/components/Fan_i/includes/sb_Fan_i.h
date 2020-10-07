#ifndef __sb_AADL_Fan_i_types__H
#define __sb_AADL_Fan_i_types__H

#include <sb_proc_types.h>

bool sb_fanCmd_dequeue(BuildingControl__FanCmd * sb_fanCmd);

bool sb_fanAck_enqueue(const BuildingControl__FanAck * sb_fanAck);

#endif // __sb_AADL_Fan_i_types__H
