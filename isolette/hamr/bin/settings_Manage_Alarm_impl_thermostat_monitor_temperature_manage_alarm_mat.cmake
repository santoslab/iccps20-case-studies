add_definitions(-DCAMKES)

if(TARGET muslc)
  target_link_libraries(Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_mat
                        muslc)
endif()