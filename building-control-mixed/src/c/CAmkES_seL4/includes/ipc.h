#ifndef IPC_H
#define IPC_H
#include <all.h>

static const int seed = 1;

// transfer data from CAmkES to ART
void camkes_In_Port_Data_Transfer (Z destPortId, art_DataContent payload);

// transfer data from ART to CAmkES
void camkes_sendAsync(Z destPortId, art_DataContent payload);

#endif