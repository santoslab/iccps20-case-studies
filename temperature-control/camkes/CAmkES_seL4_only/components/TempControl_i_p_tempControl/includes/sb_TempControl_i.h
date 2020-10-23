// This file will be regenerated, do not edit

#ifndef SB_TEMPCONTROL_I_H
#define SB_TEMPCONTROL_I_H

#include <sb_types.h>

bool sb_currentTemp_read(TemperatureControl__Temperature_i * value);

bool sb_fanAck_dequeue(TemperatureControl__FanAck *);

bool sb_fanCmd_enqueue(const TemperatureControl__FanCmd *);

bool sb_tempChanged_dequeue(void);

#endif // SB_TEMPCONTROL_I_H
