# This file will be regenerated, do not edit

cmake_minimum_required(VERSION 3.8.2)

project (BuildingControlDemo_i_Instance C)

add_definitions(-DCAMKES)

include(${CMAKE_CURRENT_LIST_DIR}/CMake_TranspilerOptions.cmake)

if ("${CMAKE_CXX_COMPILER_ID}" MATCHES "(C|c?)lang")
  add_compile_options("$<$<CONFIG:Release>:-Oz>")
elseif ("${CMAKE_CXX_COMPILER_ID}" STREQUAL "GNU")
  add_compile_options(-fstack-usage)
  add_compile_options("$<$<CONFIG:Release>:-Os>")
endif()

includeGlobalComponents()

add_subdirectory(${CMAKE_CURRENT_LIST_DIR}/slang_libraries/BuildingControlDemo_i_Instance_tcp_tempSensor)

add_subdirectory(${CMAKE_CURRENT_LIST_DIR}/slang_libraries/BuildingControlDemo_i_Instance_tcp_tempControl)

add_subdirectory(${CMAKE_CURRENT_LIST_DIR}/slang_libraries/BuildingControlDemo_i_Instance_tcp_fan)

add_subdirectory(${CMAKE_CURRENT_LIST_DIR}/slang_libraries/SlangTypeLibrary)

add_subdirectory(${CMAKE_CURRENT_LIST_DIR}/types)

set(AUX_C_SOURCES aux_code/conversions.c)
set(AUX_C_INCLUDES aux_code)

DeclareCAmkESComponent(TempSensor_i
  SOURCES ${AUX_C_SOURCES} components/TempSensor_i/src/sb_TempSensor_i.c types/src/sp_union_art_DataContent.c
  INCLUDES ${AUX_C_INCLUDES} components/TempSensor_i/includes/ types/includes types/includes
  LIBS BuildingControlDemo_i_Instance_tcp_tempSensor
)

DeclareCAmkESComponent(TempControl_i
  SOURCES ${AUX_C_SOURCES} components/TempControl_i/src/sb_TempControl_i.c types/src/sp_union_art_DataContent.c types/src/sb_queue_union_art_DataContent_1.c types/src/sb_queue_union_art_DataContent_1.c
  INCLUDES ${AUX_C_INCLUDES} components/TempControl_i/includes/ types/includes types/includes
  LIBS BuildingControlDemo_i_Instance_tcp_tempControl
)

DeclareCAmkESComponent(Fan_i
  SOURCES ${AUX_C_SOURCES} components/Fan_i/src/sb_Fan_i.c types/src/sb_queue_union_art_DataContent_1.c types/src/sb_queue_union_art_DataContent_1.c
  INCLUDES ${AUX_C_INCLUDES} components/Fan_i/includes/ types/includes
  LIBS BuildingControlDemo_i_Instance_tcp_fan
)

DeclareCAmkESComponent(dispatch_periodic
  SOURCES components/dispatch_periodic/src/sb_dispatch_periodic.c
  LIBS SB_Type_Library SlangTypeLibrary
)

DeclareCAmkESRootserver(BuildingControlDemo_i_Instance.camkes)
