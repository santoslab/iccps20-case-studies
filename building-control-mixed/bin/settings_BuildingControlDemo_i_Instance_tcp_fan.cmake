add_definitions(-DCAMKES)

if(TARGET muslc)
  target_link_libraries(BuildingControlDemo_i_Instance_tcp_fan
                        muslc)
endif()