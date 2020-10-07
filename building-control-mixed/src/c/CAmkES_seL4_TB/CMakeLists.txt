cmake_minimum_required(VERSION 3.8.2)

project (tcp C)

includeGlobalComponents()

DeclareCAmkESComponent(TempSensor_i
  SOURCES components/TempSensor_i/src/sb_TempSensor_i.c
  INCLUDES components/TempSensor_i/includes/ includes

)

DeclareCAmkESComponent(TempControl_i
  SOURCES components/TempControl_i/src/sb_TempControl_i.c
  INCLUDES components/TempControl_i/includes/ includes

)

DeclareCAmkESComponent(Fan_i
  SOURCES components/Fan_i/src/sb_Fan_i.c
  INCLUDES components/Fan_i/includes/ includes

)

DeclareCAmkESComponent(dispatch_periodic
  SOURCES components/dispatch_periodic/src/sb_dispatch_periodic.c
  INCLUDES includes

)

DeclareCAmkESComponent(sb_fan_fanCmd_Monitor
  SOURCES components/sb_Monitors/sb_fan_fanCmd_Monitor/src/sb_fan_fanCmd_Monitor.c
  INCLUDES components/sb_Monitors/sb_fan_fanCmd_Monitor/includes/ includes

)

DeclareCAmkESComponent(sb_tempControl_currentTemp_Monitor
  SOURCES components/sb_Monitors/sb_tempControl_currentTemp_Monitor/src/sb_tempControl_currentTemp_Monitor.c
  INCLUDES components/sb_Monitors/sb_tempControl_currentTemp_Monitor/includes/ includes

)

DeclareCAmkESComponent(sb_tempControl_fanAck_Monitor
  SOURCES components/sb_Monitors/sb_tempControl_fanAck_Monitor/src/sb_tempControl_fanAck_Monitor.c
  INCLUDES components/sb_Monitors/sb_tempControl_fanAck_Monitor/includes/ includes

)

DeclareCAmkESRootserver(tcp.camkes)
