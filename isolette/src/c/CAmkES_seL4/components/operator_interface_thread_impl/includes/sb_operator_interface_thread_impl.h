// This file will be regenerated, do not edit

#ifndef SB_OPERATOR_INTERFACE_THREAD_IMPL_H
#define SB_OPERATOR_INTERFACE_THREAD_IMPL_H

#include <sb_types.h>

bool sb_regulator_status_read(union_art_DataContent * value);

bool sb_monitor_status_read(union_art_DataContent * value);

bool sb_display_temperature_read(union_art_DataContent * value);

bool sb_alarm_control_read(union_art_DataContent * value);

bool sb_lower_desired_tempWstatus_write(const union_art_DataContent * value);

bool sb_upper_desired_tempWstatus_write(const union_art_DataContent * value);

bool sb_upper_alarm_tempWstatus_write(const union_art_DataContent * value);

#endif // SB_OPERATOR_INTERFACE_THREAD_IMPL_H
