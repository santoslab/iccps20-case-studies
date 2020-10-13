add_definitions(-DCAMKES)

if(TARGET muslc)
  target_link_libraries(TempSensor_i_tcp_tempSensor
                        muslc)
endif()