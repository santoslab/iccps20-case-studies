add_definitions(-DCAMKES)

if(TARGET muslc)
  target_link_libraries(isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_t
                        muslc)
endif()