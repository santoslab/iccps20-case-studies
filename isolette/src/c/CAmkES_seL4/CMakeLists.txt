# This file will be regenerated, do not edit

cmake_minimum_required(VERSION 3.8.2)

project (isolette_single_sensor_Instance C)

add_definitions(-DCAMKES)

include(${CMAKE_CURRENT_LIST_DIR}/CMake_TranspilerOptions.cmake)

if ("${CMAKE_CXX_COMPILER_ID}" MATCHES "(C|c?)lang")
  add_compile_options("$<$<CONFIG:Release>:-Oz>")
elseif ("${CMAKE_CXX_COMPILER_ID}" STREQUAL "GNU")
  add_compile_options(-fstack-usage)
  add_compile_options("$<$<CONFIG:Release>:-Os>")
endif()

add_subdirectory(${CMAKE_CURRENT_LIST_DIR}/slang_libraries/isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit)

add_subdirectory(${CMAKE_CURRENT_LIST_DIR}/slang_libraries/isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_heat_source_mhst)

add_subdirectory(${CMAKE_CURRENT_LIST_DIR}/slang_libraries/isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_mode_mrmt)

add_subdirectory(${CMAKE_CURRENT_LIST_DIR}/slang_libraries/isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_alarm_mat)

add_subdirectory(${CMAKE_CURRENT_LIST_DIR}/slang_libraries/isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_interface_mmit)

add_subdirectory(${CMAKE_CURRENT_LIST_DIR}/slang_libraries/isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_mode_mmmt)

add_subdirectory(${CMAKE_CURRENT_LIST_DIR}/slang_libraries/isolette_single_sensor_Instance_operator_interface_oip_oit)

add_subdirectory(${CMAKE_CURRENT_LIST_DIR}/slang_libraries/isolette_single_sensor_Instance_temperature_sensor_cpi_thermostat)

add_subdirectory(${CMAKE_CURRENT_LIST_DIR}/slang_libraries/isolette_single_sensor_Instance_heat_source_cpi_heat_controller)

add_subdirectory(${CMAKE_CURRENT_LIST_DIR}/slang_libraries/SlangTypeLibrary)

add_subdirectory(${CMAKE_CURRENT_LIST_DIR}/types)

DeclareCAmkESComponent(Manage_Regulator_Interface_impl
  SOURCES components/Manage_Regulator_Interface_impl/src/sb_Manage_Regulator_Interface_impl.c types/src/sp_union_art_DataContent.c types/src/sp_union_art_DataContent.c types/src/sp_union_art_DataContent.c types/src/sp_union_art_DataContent.c types/src/sp_union_art_DataContent.c types/src/sp_union_art_DataContent.c types/src/sp_union_art_DataContent.c types/src/sp_union_art_DataContent.c types/src/sp_union_art_DataContent.c
  INCLUDES components/Manage_Regulator_Interface_impl/includes/ types/includes types/includes types/includes types/includes types/includes types/includes types/includes types/includes types/includes types/includes
  LIBS isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit
)

DeclareCAmkESComponent(Manage_Heat_Source_impl
  SOURCES components/Manage_Heat_Source_impl/src/sb_Manage_Heat_Source_impl.c types/src/sp_union_art_DataContent.c types/src/sp_union_art_DataContent.c types/src/sp_union_art_DataContent.c types/src/sp_union_art_DataContent.c types/src/sp_union_art_DataContent.c
  INCLUDES components/Manage_Heat_Source_impl/includes/ types/includes types/includes types/includes types/includes types/includes types/includes
  LIBS isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_heat_source_mhst
)

DeclareCAmkESComponent(Manage_Regulator_Mode_impl
  SOURCES components/Manage_Regulator_Mode_impl/src/sb_Manage_Regulator_Mode_impl.c types/src/sp_union_art_DataContent.c types/src/sp_union_art_DataContent.c types/src/sp_union_art_DataContent.c
  INCLUDES components/Manage_Regulator_Mode_impl/includes/ types/includes types/includes types/includes types/includes
  LIBS isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_mode_mrmt
)

DeclareCAmkESComponent(Manage_Alarm_impl
  SOURCES components/Manage_Alarm_impl/src/sb_Manage_Alarm_impl.c types/src/sp_union_art_DataContent.c types/src/sp_union_art_DataContent.c types/src/sp_union_art_DataContent.c types/src/sp_union_art_DataContent.c types/src/sp_union_art_DataContent.c
  INCLUDES components/Manage_Alarm_impl/includes/ types/includes types/includes types/includes types/includes types/includes types/includes
  LIBS isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_alarm_mat
)

DeclareCAmkESComponent(Manage_Monitor_Interface_impl
  SOURCES components/Manage_Monitor_Interface_impl/src/sb_Manage_Monitor_Interface_impl.c types/src/sp_union_art_DataContent.c types/src/sp_union_art_DataContent.c types/src/sp_union_art_DataContent.c types/src/sp_union_art_DataContent.c types/src/sp_union_art_DataContent.c types/src/sp_union_art_DataContent.c types/src/sp_union_art_DataContent.c types/src/sp_union_art_DataContent.c
  INCLUDES components/Manage_Monitor_Interface_impl/includes/ types/includes types/includes types/includes types/includes types/includes types/includes types/includes types/includes types/includes
  LIBS isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_interface_mmit
)

DeclareCAmkESComponent(Manage_Monitor_Mode_impl
  SOURCES components/Manage_Monitor_Mode_impl/src/sb_Manage_Monitor_Mode_impl.c types/src/sp_union_art_DataContent.c types/src/sp_union_art_DataContent.c types/src/sp_union_art_DataContent.c
  INCLUDES components/Manage_Monitor_Mode_impl/includes/ types/includes types/includes types/includes types/includes
  LIBS isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_mode_mmmt
)

DeclareCAmkESComponent(operator_interface_thread_impl
  SOURCES components/operator_interface_thread_impl/src/sb_operator_interface_thread_impl.c types/src/sp_union_art_DataContent.c types/src/sp_union_art_DataContent.c types/src/sp_union_art_DataContent.c types/src/sp_union_art_DataContent.c types/src/sp_union_art_DataContent.c types/src/sp_union_art_DataContent.c types/src/sp_union_art_DataContent.c
  INCLUDES components/operator_interface_thread_impl/includes/ types/includes types/includes types/includes types/includes types/includes types/includes types/includes types/includes
  LIBS isolette_single_sensor_Instance_operator_interface_oip_oit
)

DeclareCAmkESComponent(Temperature_Sensor_impl
  SOURCES components/Temperature_Sensor_impl/src/sb_Temperature_Sensor_impl.c types/src/sp_union_art_DataContent.c
  INCLUDES components/Temperature_Sensor_impl/includes/ types/includes types/includes
  LIBS isolette_single_sensor_Instance_temperature_sensor_cpi_thermostat
)

DeclareCAmkESComponent(Heat_Source_impl
  SOURCES components/Heat_Source_impl/src/sb_Heat_Source_impl.c types/src/sp_union_art_DataContent.c
  INCLUDES components/Heat_Source_impl/includes/ types/includes types/includes
  LIBS isolette_single_sensor_Instance_heat_source_cpi_heat_controller
)

DeclareCAmkESComponent(Life_Cycle_Manager
  SOURCES components/Life_Cycle_Manager/src/Life_Cycle_Manager.c
)

DeclareCAmkESRootserver(isolette_single_sensor_Instance.camkes)
