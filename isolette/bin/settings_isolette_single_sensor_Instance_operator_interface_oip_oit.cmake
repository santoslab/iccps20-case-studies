add_definitions(-DCAMKES)

if(TARGET muslc)
  target_link_libraries(isolette_single_sensor_Instance_operator_interface_oip_oit
                        muslc)
endif()