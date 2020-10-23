// This file will be regenerated, do not edit

#ifndef SB_TEMPCONTROL_I_H
#define SB_TEMPCONTROL_I_H

#include <sb_types.h>

bool sb_currentTemp_read(TemperatureControl__Temperature_i * sb_currentTemp);

bool sb_fanAck_dequeue(TemperatureControl__FanAck * sb_fanAck);

bool sb_fanCmd_enqueue(const TemperatureControl__FanCmd * sb_fanCmd);

bool sb_tempChanged_dequeue(void);

#endif // SB_TEMPCONTROL_I_H
