# This file will be regenerated, do not edit

cmake_minimum_required(VERSION 3.8.2)

project (TempControlSystem_i_Instance C)

add_definitions(-DCAMKES)

if ("${CMAKE_CXX_COMPILER_ID}" MATCHES "(C|c?)lang")
  add_compile_options("$<$<CONFIG:Release>:-Oz>")
elseif ("${CMAKE_CXX_COMPILER_ID}" STREQUAL "GNU")
  add_compile_options(-fstack-usage)
  add_compile_options("$<$<CONFIG:Release>:-Os>")
endif()

includeGlobalComponents()

add_subdirectory(${CMAKE_CURRENT_LIST_DIR}/types)

DeclareCAmkESComponent(TempSensor_i_p_tempSensor
  SOURCES components/TempSensor_i_p_tempSensor/src/sb_TempSensor_i.c types/src/sp_TemperatureControl__Temperature_i.c
  INCLUDES components/TempSensor_i_p_tempSensor/includes/ types/includes types/includes
)

DeclareCAmkESComponent(TempControl_i_p_tempControl
  SOURCES components/TempControl_i_p_tempControl/src/sb_TempControl_i.c types/src/sp_TemperatureControl__Temperature_i.c types/src/sb_queue_TemperatureControl__FanAck_1.c types/src/sb_queue_TemperatureControl__FanCmd_1.c
  INCLUDES components/TempControl_i_p_tempControl/includes/ types/includes types/includes
)

DeclareCAmkESComponent(Fan_i_p_fan
  SOURCES components/Fan_i_p_fan/src/sb_Fan_i.c types/src/sb_queue_TemperatureControl__FanCmd_1.c types/src/sb_queue_TemperatureControl__FanAck_1.c
  INCLUDES components/Fan_i_p_fan/includes/ types/includes
)

DeclareCAmkESComponent(dispatch_periodic
  SOURCES components/dispatch_periodic/src/sb_dispatch_periodic.c
  LIBS SB_Type_Library
)

DeclareCAmkESRootserver(TempControlSystem_i_Instance.camkes)
