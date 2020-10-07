#ifndef CONVERSIONS_H
#define CONVERSIONS_H

#include <all.h>
#include <sb_proc_types.h>

void convertTo_BuildingControl__FanCmd(building_control_gen_mixed_BuildingControl_FanCmd_Payload, 
                                       BuildingControl__FanCmd *);

void convertTo_BuildingControl__FanAck(building_control_gen_mixed_BuildingControl_FanAck_Payload, 
                                       BuildingControl__FanAck *);
   
void convertTo_BuildingControl__Temperature_impl(building_control_gen_mixed_BuildingControl_Temperature_impl_Payload,
                                                 BuildingControl__Temperature_impl *);

void convertTo_building_control_gen_mixed_BuildingControl_Temperature_impl_Payload(BuildingControl__Temperature_impl, 
                                                                                   building_control_gen_mixed_BuildingControl_Temperature_impl_Payload);

void convertTo_building_control_gen_mixed_BuildingControl_FanAck_Payload(BuildingControl__FanAck, 
                                                                         building_control_gen_mixed_BuildingControl_FanAck_Payload);

void convertTo_building_control_gen_mixed_BuildingControl_FanCmd_Payload(BuildingControl__FanCmd,
                                                                         building_control_gen_mixed_BuildingControl_FanCmd_Payload);

#endif