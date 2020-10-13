// #Sireum

package isolette.Monitor

import org.sireum._
import isolette._

// This file will not be overwritten so is safe to edit
object Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_mat {

  //  Input ports:
  //    monitor_mode
  //    lower_alarm_temperature
  //    upper_alarm_temperature
  //    current_temperature
  //
  //  Output ports:
  //    alarm_control
  //
  //  Flows
  //    [Function: Manage Alarm]
  //

  //======================================
  // Persistent component state
  //======================================

  // FIXME: confirm that having "lastCmd" for alarm set default to "Off" is OK
  var lastCmd: Isolette_Data_Model.On_Off.Type = Isolette_Data_Model.On_Off.Off

  //======================================
  // Initialize Entry Point
  //======================================

  def initialise(api: Manage_Alarm_impl_Initialization_Api): Unit = {
    // TODO: There is a bit of a conceptual glitch here since following the
    //   AADL model of computation we should initialize all values here --
    //   There should be no notion of initializing execution outside of the
    //   initialise method.  However, Scala/Slang requires that all variables
    //   are required to be initialized at the point of declaration,
    //   so we must have initialization elsewhere, which probably leads
    //   to some notion of initializing code outside of the AADL computational
    //   model.   We should check the implications of that.
    lastCmd = Isolette_Data_Model.On_Off.Off
    //  REQ-MA-1: If the Monitor Mode is INIT, the Alarm Control shall be set
    //    to Off.
    api.setalarm_control(Isolette_Data_Model.On_Off.Off)
  }

  def timeTriggered(api: Manage_Alarm_impl_Operational_Api): Unit = {

    // Requirements for Manage Alarm (MA)
    //
    //
    //  REQ-MA-1: If the Monitor Mode is INIT, the Alarm Control shall be set
    //    to Off.
    //
    //  REQ-MA-2: If the Monitor Mode is NORMAL and the Current Temperature is
    //  less than the Lower Alarm Temperature or greater than the Upper Alarm
    //    Temperature, the Alarm Control shall be set to On.
    //
    //  REQ-MA-3: If the Monitor Mode is NORMAL and the Current Temperature
    //    is greater than or equal to the Lower Alarm Temperature and less than
    //  the Lower Alarm Temperature +0.5 degrees, or the Current Temperature is
    //  greater than the Upper Alarm Temperature -0.5 degrees and less than or equal
    //  to the Upper Alarm Temperature, the value of the Alarm Control shall
    //  not be changed.
    //
    //    REQ-MA-4: If the Monitor Mode is NORMAL and the value of the Current
    //    Temperature is greater than or equal to the Lower Alarm Temperature
    //  +0.5 degrees and less than or equal to the Upper Alarm Temperature
    //    -0.5 degrees, the Alarm Control shall be set to Off.
    //
    //  REQ-MA-5: If the Monitor Mode is FAILED, the Alarm Control shall be
    //  set to On.
    //
    //    Latency: < 5 seconds
    //  Tolerance: N/A

    // -------------- Get values of input ports ------------------

    val lower: Isolette_Data_Model.Temp_impl =
      api.getlower_alarm_temp().get
    // remove code for old approach that lacked initializers
    // api.getlower_alarm_temp().getOrElseEager(LOW)

    val upper: Isolette_Data_Model.Temp_impl =
      api.getupper_alarm_temp().get
    // remove code for old approach that lacked initializers
    // api.getupper_alarm_temp().getOrElseEager(HIGH)

    val monitor_mode: Isolette_Data_Model.Monitor_Mode.Type =
      api.getmonitor_mode().get
    // remove code for old approach that lacked initializers
    // api.getmonitor_mode().getOrElseEager(DEFAULT_MODE)

    val currentTemp: Isolette_Data_Model.TempWstatus_impl =
      api.getcurrent_tempWstatus().get
    // remove code for old approach that lacked initializers
    // api.getcurrent_tempWstatus().getOrElseEager(DEFAULT_TEMP)

    //==============================================================================

    // current command defaults to value of last command
    var currentCmd: Isolette_Data_Model.On_Off.Type = lastCmd

    // address all cases of monitor_mode: Init, Normal, Failed
    monitor_mode match {

      // INIT Mode
      case Isolette_Data_Model.Monitor_Mode.Init_Monitor_Mode =>
        //  REQ-MA-1: If the Monitor Mode is INIT, the Alarm Control shall be set
        //    to Off
        currentCmd = Isolette_Data_Model.On_Off.Off

      // NORMAL Mode
      case Isolette_Data_Model.Monitor_Mode.Normal_Monitor_Mode =>
        //  REQ-MA-2: If the Monitor Mode is NORMAL and the Current Temperature is
        //  less than the Lower Alarm Temperature or greater than the Upper Alarm
        //    Temperature, the Alarm Control shall be set to On.
        if ((currentTemp.value < lower.value) || currentTemp.value > upper.value) {
          currentCmd = Isolette_Data_Model.On_Off.Onn
        } else
        //  REQ-MA-3: If the Monitor Mode is NORMAL and the
        //    [cond1]
        //      Current Temperature is greater than or equal to the Lower Alarm Temperature
        //      and less than the Lower Alarm Temperature +0.5 degrees,
        //   or [cond2]
        //      the Current Temperature is greater than the Upper Alarm Temperature -0.5 degrees
        //      and less than or equal to the Upper Alarm Temperature,
        //   the value of the Alarm Control shall not be changed.
          if (   ((currentTemp.value >= lower.value) && (currentTemp.value < lower.value + 0.5f))   // [cond1]
            || ((currentTemp.value > upper.value + 0.5f) && (currentTemp.value <= upper.value + 0.5f))) // [cond2]
          {
            currentCmd = lastCmd
          } else
          //    REQ-MA-4: If the Monitor Mode is NORMAL and the value of the Current Temperature is
          //       [cond3] >= to the Lower Alarm Temperature +0.5 degrees
          //   and [cond4] <= to the Upper Alarm Temperature -0.5 degrees,
          //   the Alarm Control shall be set to Off.
            if (   (currentTemp.value >= (lower.value + 0.5f))
              && (currentTemp.value <= (upper.value - 0.5f))
            ) {
              currentCmd = Isolette_Data_Model.On_Off.Off
            }
      // Note: there are probably going to be issues in proving the exhaustiveness of these cases above due
      // floating point rounding issues, and I don't know how to handle that.

      // FAILED Mode
      case Isolette_Data_Model.Monitor_Mode.Failed_Monitor_Mode =>
        //  REQ-MA-5: If the Monitor Mode is FAILED, the Alarm Control shall be
        //  set to On.
        currentCmd = Isolette_Data_Model.On_Off.Onn
    }

    api.setalarm_control(currentCmd)
    lastCmd = currentCmd
  }

  def activate(api: Manage_Alarm_impl_Operational_Api): Unit = { }

  def deactivate(api: Manage_Alarm_impl_Operational_Api): Unit = { }

  def finalise(api: Manage_Alarm_impl_Operational_Api): Unit = { }

  def recover(api: Manage_Alarm_impl_Operational_Api): Unit = { }
}
