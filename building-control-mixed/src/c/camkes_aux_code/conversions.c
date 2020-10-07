#include "conversions.h"

/**
 .d8b.  d8888b. d888888b                   .d8888. d88888b db        j88D
d8' `8b 88  `8D `~~88~~'          Vb       88'  YP 88'     88       j8~88
88ooo88 88oobY'    88              `Vb     `8bo.   88ooooo 88      j8' 88
88~~~88 88`8b      88      C8888D    `V.     `Y8b. 88~~~~~ 88      V88888D
88   88 88 `88.    88                .d'   db   8D 88.     88booo.     88
YP   YP 88   YD    YP              .dP     `8888Y' Y88888P Y88888P     VP
                                  dP
**/

void convertTo_BuildingControl__FanAck(building_control_gen_mixed_BuildingControl_FanAck_Payload src, 
                                       BuildingControl__FanAck *dst){
  switch(src->value) {
    case building_control_gen_mixed_BuildingControl_FanAck_Ok:
      *dst = Ok;
      break;
    case building_control_gen_mixed_BuildingControl_FanAck_Error:
      *dst = Error;
      break;
  }                                       
}

void convertTo_BuildingControl__FanCmd(building_control_gen_mixed_BuildingControl_FanCmd_Payload src, 
                                       BuildingControl__FanCmd *dst){
  switch(src->value) {
    case building_control_gen_mixed_BuildingControl_FanCmd_On:
      *dst = On;
      break;
    case building_control_gen_mixed_BuildingControl_FanCmd_Off:
      *dst = Off;
      break;
  }
}

void convertTo_BuildingControl__Temperature_impl(building_control_gen_mixed_BuildingControl_Temperature_impl_Payload src,
                                                 BuildingControl__Temperature_impl *dst){
  dst->degrees = src->value.degrees;
  
  switch(src->value.unit) {
    case building_control_gen_mixed_BuildingControl_TempUnit_Fahrenheit:
      dst->unit = Fahrenheit;
      break;
    case building_control_gen_mixed_BuildingControl_TempUnit_Celsius:
      dst->unit = Celsius;
      break;
    case building_control_gen_mixed_BuildingControl_TempUnit_Kelvin:
      dst->unit = Kelvin;
      break;
  }
}


/**
.d8888. d88888b db        j88D                     .d8b.  d8888b. d888888b
88'  YP 88'     88       j8~88           Vb       d8' `8b 88  `8D `~~88~~'
`8bo.   88ooooo 88      j8' 88            `Vb     88ooo88 88oobY'    88
  `Y8b. 88~~~~~ 88      V88888D   C8888D    `V.   88~~~88 88`8b      88
db   8D 88.     88booo.     88              .d'   88   88 88 `88.    88
`8888Y' Y88888P Y88888P     VP            .dP     YP   YP 88   YD    YP
                                         dP
**/

void convertTo_building_control_gen_mixed_BuildingControl_FanAck_Payload(BuildingControl__FanAck src, 
                                                                         building_control_gen_mixed_BuildingControl_FanAck_Payload dst){
  switch(src) {
    case Ok:
      dst->value = building_control_gen_mixed_BuildingControl_FanAck_Ok;
      break;
    case Error:
      dst->value = building_control_gen_mixed_BuildingControl_FanAck_Error;
      break;
  }
}

void convertTo_building_control_gen_mixed_BuildingControl_FanCmd_Payload(BuildingControl__FanCmd src,
                                                                         building_control_gen_mixed_BuildingControl_FanCmd_Payload dst){
  switch(src) {
    case On:
      dst->value = building_control_gen_mixed_BuildingControl_FanCmd_On;
      break;
    case Off:
      dst->value = building_control_gen_mixed_BuildingControl_FanCmd_Off;
      break;
  }
}

void convertTo_building_control_gen_mixed_BuildingControl_Temperature_impl_Payload(BuildingControl__Temperature_impl src, 
                                                                                   building_control_gen_mixed_BuildingControl_Temperature_impl_Payload dst){
  DeclNewbuilding_control_gen_mixed_BuildingControl_Temperature_impl(value);
  value.degrees = src.degrees;
  
  switch(src.unit) {
    case Fahrenheit:
      value.unit = building_control_gen_mixed_BuildingControl_TempUnit_Fahrenheit;
      break;
    case Celsius:
      value.unit = building_control_gen_mixed_BuildingControl_TempUnit_Celsius;
      break;
    case Kelvin:
      value.unit = building_control_gen_mixed_BuildingControl_TempUnit_Kelvin;
      break;
  }
  
  building_control_gen_mixed_BuildingControl_Temperature_impl_Payload_apply(SF
    dst,
    (building_control_gen_mixed_BuildingControl_Temperature_impl) &value
  );
}
