add_definitions(-DCAMKES)

if(TARGET muslc)
  target_link_libraries(Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_mmit
                        muslc)
endif()