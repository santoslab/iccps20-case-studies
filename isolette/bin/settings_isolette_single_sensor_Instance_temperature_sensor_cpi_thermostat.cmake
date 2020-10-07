add_definitions(-DCAMKES)

if(TARGET muslc)
  target_link_libraries(isolette_single_sensor_Instance_temperature_sensor_cpi_thermostat
                        muslc)
endif()