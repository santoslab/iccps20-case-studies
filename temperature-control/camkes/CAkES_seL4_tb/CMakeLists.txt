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
  SOURCES components/TempSensor_i_p_tempSensor/src/sb_TempSensor_i.c
  INCLUDES components/TempSensor_i_p_tempSensor/includes/ types/includes
)

DeclareCAmkESComponent(TempControl_i_p_tempControl
  SOURCES components/TempControl_i_p_tempControl/src/sb_TempControl_i.c
  INCLUDES components/TempControl_i_p_tempControl/includes/ types/includes
)

DeclareCAmkESComponent(Fan_i_p_fan
  SOURCES components/Fan_i_p_fan/src/sb_Fan_i.c
  INCLUDES components/Fan_i_p_fan/includes/ types/includes
)

DeclareCAmkESComponent(dispatch_periodic
  SOURCES components/dispatch_periodic/src/sb_dispatch_periodic.c
  LIBS SB_Type_Library
)

DeclareCAmkESComponent(sb_tempControl_currentTemp_Monitor
  SOURCES components/sb_Monitors/sb_tempControl_currentTemp_Monitor/src/sb_tempControl_currentTemp_Monitor.c
  INCLUDES components/sb_Monitors/sb_tempControl_currentTemp_Monitor/includes/ types/includes
)

DeclareCAmkESComponent(sb_tempControl_tempChanged_Monitor
  SOURCES components/sb_Monitors/sb_tempControl_tempChanged_Monitor/src/sb_tempControl_tempChanged_Monitor.c
  INCLUDES components/sb_Monitors/sb_tempControl_tempChanged_Monitor/includes/ types/includes
)

DeclareCAmkESComponent(sb_fan_fanCmd_Monitor
  SOURCES components/sb_Monitors/sb_fan_fanCmd_Monitor/src/sb_fan_fanCmd_Monitor.c
  INCLUDES components/sb_Monitors/sb_fan_fanCmd_Monitor/includes/ types/includes
)

DeclareCAmkESComponent(sb_tempControl_fanAck_Monitor
  SOURCES components/sb_Monitors/sb_tempControl_fanAck_Monitor/src/sb_tempControl_fanAck_Monitor.c
  INCLUDES components/sb_Monitors/sb_tempControl_fanAck_Monitor/includes/ types/includes
)

DeclareCAmkESRootserver(TempControlSystem_i_Instance.camkes)
