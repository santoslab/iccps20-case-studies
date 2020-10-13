add_definitions(-DCAMKES)

if(TARGET muslc)
  target_link_libraries(Temperature_Sensor_impl_temperature_sensor_cpi_thermostat
                        muslc)
endif()