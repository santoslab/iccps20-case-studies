add_definitions(-DCAMKES)

if(TARGET muslc)
  target_link_libraries(Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_mmmt
                        muslc)
endif()