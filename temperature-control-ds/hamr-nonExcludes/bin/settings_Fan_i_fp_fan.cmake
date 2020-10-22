add_definitions(-DCAMKES)

if(TARGET muslc)
  target_link_libraries(Fan_i_fp_fan
                        muslc)
endif()