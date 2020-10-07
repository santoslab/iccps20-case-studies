#include <all.h>
#include <ext.h>

// add c extension code here

#define MIN_TEMP 55
#define MAX_TEMP 100

#define SLANG_DEBUG 0

static int temp = 0;
static int delta = 4;

static int isOn = 1;

struct isolette_Isolette_Data_Model_TempWstatus_impl lowerDesiredTempWstatus;
struct isolette_Isolette_Data_Model_TempWstatus_impl upperDesiredTempWstatus;
struct isolette_Isolette_Data_Model_TempWstatus_impl lowerAlarmTempWstatus;
struct isolette_Isolette_Data_Model_TempWstatus_impl upperAlarmTempWstatus;

/**********************************************************************
 *
 * USER INTERFACE
 *
 *********************************************************************/


Unit isolette_Isolette_UserInterface_Interface_init(STACK_FRAME
                                                    isolette_Isolette_Data_Model_TempWstatus_impl _lowerDesiredTempWstatus,
                                                    isolette_Isolette_Data_Model_TempWstatus_impl _upperDesiredTempWstatus,
                                                    isolette_Isolette_Data_Model_TempWstatus_impl _lowerAlarmTempWstatus,
                                                    isolette_Isolette_Data_Model_TempWstatus_impl _upperAlarmTempWstatus) {
    printf("isolette_Isolette_UserInterface_Interface_init called \n");

    lowerDesiredTempWstatus.value = _lowerDesiredTempWstatus->value;
    upperDesiredTempWstatus.value = _upperDesiredTempWstatus->value;
    lowerAlarmTempWstatus.value = _lowerAlarmTempWstatus->value;
    upperAlarmTempWstatus.value = _upperAlarmTempWstatus->value;
}

Unit isolette_Isolette_UserInterface_Interface_setRegulatorStatus(STACK_FRAME Option_3D6E5E v){
    DeclNewString(result);
    if(v->type == TSome_E2AA69){
        isolette_Isolette_Data_Model_Status_Type_name_((String) &result, v->Some_E2AA69.value);
    } else {
        String_assign((String) &result, string(""));
    }
    printf("isolette_Isolette_UserInterface_Interface_setRegulatorStatus called: %s\n", result.value);
}

Unit isolette_Isolette_UserInterface_Interface_setMonitorStatus(STACK_FRAME Option_3D6E5E v){
    DeclNewString(result);
    if(v->type == TSome_E2AA69) {
        isolette_Isolette_Data_Model_Status_Type_name_((String) &result, v->Some_E2AA69.value);
    } else {
        String_assign((String) &result, string(""));
    }
    printf("isolette_Isolette_UserInterface_Interface_setMonitorStatus called: %s\n", result.value);
}

Unit isolette_Isolette_UserInterface_Interface_setDispayTemperature(STACK_FRAME Option_0893BB v){
    DeclNewString(result);
    if(v->type == TSome_78BA16) {
        F32_string_(CALLER (String) &result, v->Some_78BA16.value.value);
    } else {
        String_assign((String) &result, string(""));
    }
    printf("isolette_Isolette_UserInterface_Interface_setDispayTemperature called: %s\n", result.value);
}

Unit isolette_Isolette_UserInterface_Interface_setAlarmControl(STACK_FRAME Option_8CD3A4 v){
    DeclNewString(result);
    if(v->type == TSome_B170F4){
        isolette_Isolette_Data_Model_On_Off_Type_name_((String) &result, v->Some_B170F4.value);
    } else {
        String_assign((String) &result, string(""));
    }
    printf("isolette_Isolette_UserInterface_Interface_setAlarmControl called: %s\n", result.value);
}

void isolette_Isolette_UserInterface_Interface_getLowerDesiredTempWstatus(STACK_FRAME isolette_Isolette_Data_Model_TempWstatus_impl result){
    result->value = lowerDesiredTempWstatus.value;

    printf("isolette_Isolette_UserInterface_Interface_getLowerDesiredTempWstatus called: %f\n", result->value);
}

void isolette_Isolette_UserInterface_Interface_getUpperDesiredTempWstatus(STACK_FRAME isolette_Isolette_Data_Model_TempWstatus_impl result){
    result->value = upperDesiredTempWstatus.value;

    printf("isolette_Isolette_UserInterface_Interface_getUpperDesiredTempWstatus called: %f\n", result->value);
}

void isolette_Isolette_UserInterface_Interface_getLowerAlarmTempWstatus(STACK_FRAME isolette_Isolette_Data_Model_TempWstatus_impl result){
    result->value = lowerAlarmTempWstatus.value;

    printf("isolette_Isolette_UserInterface_Interface_getLowerAlarmTempWstatus called: %f\n", result->value);
}

void isolette_Isolette_UserInterface_Interface_getUpperAlarmTempWstatus(STACK_FRAME isolette_Isolette_Data_Model_TempWstatus_impl result){
    result->value = upperAlarmTempWstatus.value;

    printf("isolette_Isolette_UserInterface_Interface_getUpperAlarmTempWstatus called: %f\n", result->value);
}


/**********************************************************************
 *
 * DEVICES HEAT SOURCE
 *
 *********************************************************************/

Unit isolette_Devices_Heat_Source_Native_setState(STACK_FRAME isolette_Isolette_Data_Model_On_Off_Type value){
    DeclNewString(result);
    isolette_Isolette_Data_Model_On_Off_Type_name_((String) &result, value);

    printf("isolette_Devices_Heat_Source_Native_setState called: %s\n", result.value);
}


/**********************************************************************
 *
 * DEVICES TEMP SENSOR
 *
 *********************************************************************/

void isolette_Devices_Temperature_Sensor_Native_getCurrentTemp(STACK_FRAME isolette_Isolette_Data_Model_Temp_impl result){
    printf("isolette_Devices_Temperature_Sensor_Native_getCurrentTemp called\n");

    if (temp == 0) {
        temp = MIN_TEMP;
    }
    temp += delta;
    if (temp < MIN_TEMP) delta = 4;
    else if (temp > MAX_TEMP) delta = -4;
    result->value = (F32) temp;
}