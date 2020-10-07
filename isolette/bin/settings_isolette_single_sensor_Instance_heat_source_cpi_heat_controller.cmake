add_definitions(-DCAMKES)

if(TARGET muslc)
  target_link_libraries(isolette_single_sensor_Instance_heat_source_cpi_heat_controller
                        muslc)
endif()