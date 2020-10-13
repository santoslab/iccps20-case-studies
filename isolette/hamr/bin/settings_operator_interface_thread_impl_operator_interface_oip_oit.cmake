add_definitions(-DCAMKES)

if(TARGET muslc)
  target_link_libraries(operator_interface_thread_impl_operator_interface_oip_oit
                        muslc)
endif()