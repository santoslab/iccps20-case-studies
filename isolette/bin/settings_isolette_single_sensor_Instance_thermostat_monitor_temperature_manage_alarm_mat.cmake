add_definitions(-DCAMKES)

if(TARGET muslc)
  target_link_libraries(isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_alarm_mat
                        muslc)
endif()