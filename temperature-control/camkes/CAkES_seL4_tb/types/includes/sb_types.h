#ifndef SB_TYPES_H
#define SB_TYPES_H

#include <stdio.h>
#include <stdbool.h>
#include <stdint.h>

#ifndef SB_VERIFY
#include <stddef.h>
#endif // SB_VERIFY

#define __SB_OS_CAMKES__

#ifndef SB_VERIFY
#define MUTEXOP(OP)\
if((OP) != 0) {\
  fprintf(stderr,"Operation " #OP " failed in %s at %d.\n",__FILE__,__LINE__);\
  *((int*)0)=0xdeadbeef;\
}
#else
#define MUTEXOP(OP) OP
#endif // SB_VERIFY
#ifndef SB_VERIFY
#define CALLBACKOP(OP)\
if((OP) != 0) {\
  fprintf(stderr,"Operation " #OP " failed in %s at %d.\n",__FILE__,__LINE__);\
  *((int*)0)=0xdeadbeef;\
}
#else
#define CALLBACKOP(OP) OP
#endif // SB_VERIFY

typedef
  enum {Ok, Error} TemperatureControl__FanAck;

typedef
  enum {On, Off} TemperatureControl__FanCmd;

typedef
  enum {Fahrenheit, Celsius, Kelvin} TemperatureControl__TempUnit;

typedef
  struct TemperatureControl__Temperature_i {
    double degrees;
    TemperatureControl__TempUnit unit;
  } TemperatureControl__Temperature_i;

typedef
  struct TemperatureControl__SetPoint_i {
    TemperatureControl__Temperature_i low;
    TemperatureControl__Temperature_i high;
  } TemperatureControl__SetPoint_i;

#endif // SB_TYPES_H
