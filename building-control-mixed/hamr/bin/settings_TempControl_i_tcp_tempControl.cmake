add_definitions(-DCAMKES)

if(TARGET muslc)
  target_link_libraries(TempControl_i_tcp_tempControl
                        muslc)
endif()