add_definitions(-DCAMKES)

if(TARGET muslc)
  target_link_libraries(TempSensor_i_p_tempSensor
                        muslc)
endif()