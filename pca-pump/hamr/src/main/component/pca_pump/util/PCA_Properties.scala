// #Sireum

package pca_pump.util

import org.sireum._
import pca_pump._
import org.sireum.S16._
import art._

object PCA_Properties {

  // maximum flow rate for the pump.  F_max
  val MaxRate: PCA_Types.Flow_Rate_imp = PCA_Types.Flow_Rate_imp(s16"600") // ml/hr

  // FIXME: Prime_Rate is actually a Fluid_Flow_Rate with range 0 .. 10000
  // rate of infusion during pump priming
  val PrimeRate: PCA_Types.Flow_Rate_imp = MaxRate
  // duration of priming - clinician must stop priming within this timeframe
  val PrimeTime: Art.Time = 60000 // 60 secs

  // FIXME: KVO_Rate is a Fluid_Flow_Rate constant set at 1 mlPerHour
  // keep-vein-open rate
  val KVORate: PCA_Types.Flow_Rate_imp = PCA_Types.Flow_Rate_imp(s16"1") // ml/hr

  // Requirements bug:
  // 1) EC7 and EC8 mention tolerances for patient and clinician
  //    bolus but never defines their values

  // see 4.1.3
  val Basal_Infusion_Flow_Tolerance : F32 = 0.5f //; -- ml/hr
  val Patient_Bolus_Infusion_Flow_Tolerance : F32 = 0.5f //; -- ml/hr
  val Clinician_Bolus_Infusion_Flow_Tolerance : F32 = 0.5f //; -- ml/hr



  //jab: durations to use before issuing over/under infusion alarms.

  // see EC7 1 a), 5.4.2
  val Basal_Over_Infusion_Duration : Art.Time = 10000//300000 // ms; -- 5 min
  // see EC8 1 b), 5.4.5
  val Basal_Under_Infusion_Duration : Art.Time = 10000//300000 // ms; -- 5 min


  // Requirements bug:
  // 1) 5.4.4 and 5.4.5 states patient duration is '1 minutes' but
  //    EC7 and EC8 states it should be 10 seconds

  // see EC7 1 c), 5.4.4
  val Patient_Bolus_Over_Infusion_Duration : Art.Time = 60000 //ms; -- 1 min
  // see EC8 1 b), 5.4.5
  val Patient_Bolus_Under_Infusion_Duration : Art.Time = 60000 //ms; -- 1 min


  // Requirements bug:
  // 1) EC7 1 e) states the following
  //    "clinician-requested bolus flow rate exceeds the prescribed **patient-requested bolus** rate"
  // 2) 5.4.6 and 5.4.7 states square bolus duration is '5 min' but
  //    EC7 and EC8 states it should be '1 min'

  // see EC7	 1 e), 5.4.6
  val Clinician_Bolus_Over_Infusion_Duration : Art.Time = 300000 //ms; -- 5 min
  // see EC8 c), 5.4.7
  val Clinician_Bolus_Under_Infusion_Duration : Art.Time = 300000 //ms; -- 5 min
}