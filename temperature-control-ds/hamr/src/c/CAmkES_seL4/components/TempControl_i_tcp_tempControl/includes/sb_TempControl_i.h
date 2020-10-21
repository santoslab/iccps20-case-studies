// This file will be regenerated, do not edit

#ifndef SB_TEMPCONTROL_I_H
#define SB_TEMPCONTROL_I_H

#include <sb_types.h>

bool sb_currentTemp_read(union_art_DataContent * value);

bool sb_fanAck_dequeue(union_art_DataContent *);

bool sb_fanCmd_enqueue(const union_art_DataContent *);

bool sb_tempChanged_dequeue(void);

#endif // SB_TEMPCONTROL_I_H
