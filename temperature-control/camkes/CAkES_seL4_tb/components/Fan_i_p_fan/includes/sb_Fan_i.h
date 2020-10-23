// This file will be regenerated, do not edit

#ifndef SB_FAN_I_H
#define SB_FAN_I_H

#include <sb_types.h>

bool sb_fanCmd_dequeue(TemperatureControl__FanCmd * sb_fanCmd);

bool sb_fanAck_enqueue(const TemperatureControl__FanAck * sb_fanAck);

#endif // SB_FAN_I_H
