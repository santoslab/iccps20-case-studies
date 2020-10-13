add_definitions(-DCAMKES)

if(TARGET muslc)
  target_link_libraries(Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode_mrmt
                        muslc)
endif()