add_definitions(-DCAMKES)

if(TARGET muslc)
  target_link_libraries(TempControl_i_p_tempControl
                        muslc)
endif()