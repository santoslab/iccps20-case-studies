#include <config.h>
#include <object/structures.h>
#include <model/statedata.h>

// this file will not be overwritten and is safe to edit

/************************************************************

   This is a kernel data structure containing an example schedule.
   The length is in seL4 ticks (2 ms).
   This schedule should be generated from the AADL model
   using execution time and data flow latency specifications.

   Pacer runs at highest rate and should always be in domain 1

   Properties from AADL Model
   --------------------------

     Timing_Properties::Clock_Period : 2 ms
     Timing_Properties::Frame_Period : 1000 ms

     mrit
     ----

       CASE_Scheduling::Domain : 5
       Timing_Properties::Compute_Execution_Time : 6 ms
       Timing_Properties::Period : 1000 ms

     mhst
     ----

       CASE_Scheduling::Domain : 6
       Timing_Properties::Compute_Execution_Time : 6 ms
       Timing_Properties::Period : 1000 ms

     mrmt
     ----

       CASE_Scheduling::Domain : 4
       Timing_Properties::Compute_Execution_Time : 6 ms
       Timing_Properties::Period : 1000 ms

     mat
     ---

       CASE_Scheduling::Domain : 9
       Timing_Properties::Compute_Execution_Time : 6 ms
       Timing_Properties::Period : 1000 ms

     mmit
     ----

       CASE_Scheduling::Domain : 8
       Timing_Properties::Compute_Execution_Time : 6 ms
       Timing_Properties::Period : 1000 ms

     mmmt
     ----

       CASE_Scheduling::Domain : 7
       Timing_Properties::Compute_Execution_Time : 6 ms
       Timing_Properties::Period : 1000 ms

     oit
     ---

       CASE_Scheduling::Domain : 2
       Timing_Properties::Compute_Execution_Time : 6 ms
       Timing_Properties::Period : 1000 ms

     thermostat
     ----------

       CASE_Scheduling::Domain : 3
       Timing_Properties::Compute_Execution_Time : 6 ms
       Timing_Properties::Period : 1000 ms

     heat_controller
     ---------------

       CASE_Scheduling::Domain : 10
       Timing_Properties::Compute_Execution_Time : 6 ms
       Timing_Properties::Period : 1000 ms

 *********************************************************/

const dschedule_t ksDomSchedule[] = {
  { .domain = 0, .length = 100 },  // all other seL4 threads, init, 200ms
  { .domain = 5, .length = 3 },  // mrit  6ms
  { .domain = 6, .length = 3 },  // mhst  6ms
  { .domain = 4, .length = 3 },  // mrmt  6ms
  { .domain = 9, .length = 3 },  // mat  6ms
  { .domain = 8, .length = 3 },  // mmit  6ms
  { .domain = 7, .length = 3 },  // mmmt  6ms
  { .domain = 2, .length = 3 },  // oit  6ms
  { .domain = 3, .length = 3 },  // thermostat  6ms
  { .domain = 10, .length = 3 },  // heat_controller  6ms
  { .domain = 0, .length = 368 },  // pad rest of frame period
};

const word_t ksDomScheduleLength = sizeof(ksDomSchedule) / sizeof(dschedule_t);
