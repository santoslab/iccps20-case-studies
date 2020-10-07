// This file will be regenerated, do not edit

#ifndef SB_MANAGE_REGULATOR_INTERFACE_IMPL_H
#define SB_MANAGE_REGULATOR_INTERFACE_IMPL_H

#include <sb_types.h>

bool sb_current_tempWstatus_read(union_art_DataContent * value);

bool sb_lower_desired_tempWstatus_read(union_art_DataContent * value);

bool sb_upper_desired_tempWstatus_read(union_art_DataContent * value);

bool sb_regulator_mode_read(union_art_DataContent * value);

bool sb_upper_desired_temp_write(const union_art_DataContent * value);

bool sb_lower_desired_temp_write(const union_art_DataContent * value);

bool sb_displayed_temp_write(const union_art_DataContent * value);

bool sb_regulator_status_write(const union_art_DataContent * value);

bool sb_interface_failure_write(const union_art_DataContent * value);

#endif // SB_MANAGE_REGULATOR_INTERFACE_IMPL_H
