add_definitions(-DCAMKES)

if(TARGET muslc)
  target_link_libraries(Heat_Source_impl_heat_source_cpi_heat_controller
                        muslc)
endif()