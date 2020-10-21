add_definitions(-DCAMKES)

if(TARGET muslc)
  target_link_libraries(TempSensor_i_tsp_tempSensor
                        muslc)
endif()