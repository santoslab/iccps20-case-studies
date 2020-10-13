add_definitions(-DCAMKES)

if(TARGET muslc)
  target_link_libraries(Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit
                        muslc)
endif()