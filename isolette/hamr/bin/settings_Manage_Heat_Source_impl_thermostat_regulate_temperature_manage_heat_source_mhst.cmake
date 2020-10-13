add_definitions(-DCAMKES)

if(TARGET muslc)
  target_link_libraries(Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_mhst
                        muslc)
endif()