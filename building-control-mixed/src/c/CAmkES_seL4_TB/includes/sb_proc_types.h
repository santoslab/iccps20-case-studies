#ifndef __SB_AADL_sb_proc_types__H
#define __SB_AADL_sb_proc_types__H

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
  enum {Ok, Error} BuildingControl__FanAck;

typedef
  enum {On, Off} BuildingControl__FanCmd;

typedef
  enum {Fahrenheit, Celsius, Kelvin} BuildingControl__TempUnit;

typedef
  struct BuildingControl__Temperature_impl {
    double degrees;
    BuildingControl__TempUnit unit;
  } BuildingControl__Temperature_impl;

typedef
  struct BuildingControl__SetPoint_impl {
    BuildingControl__Temperature_impl low;
    BuildingControl__Temperature_impl high;
  } BuildingControl__SetPoint_impl;

#endif // __SB_AADL_sb_proc_types__H
