// #Sireum

package isolette.Monitor

import org.sireum._
import isolette._

// This file will not be overwritten so is safe to edit
object Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_mmmt {
  // Inputs
  //   interface_failure
  //   internal_failure
  //   current_temperature
  //
  // Outputs
  //   monitor_mode

  // Define function capturing init mode time out condition as defined in FAA REMH
  //   Figure A-4 and Table A-9
  //
  // FIXME: simulate check of Manage_Alarm_Mode initial value timeout constraint
  def timeout_condition_satisfied(): B = {return false}

  //======================================
  // Persistent component state
  //======================================

  // REQ-MMM-1: Upon the first dispatch of the thread, the monitor mode is Init.
  var monitor_mode : Isolette_Data_Model.Monitor_Mode.Type = Isolette_Data_Model.Monitor_Mode.Init_Monitor_Mode

  //======================================
  // Initialize Entry Point
  //======================================

  def initialise(api: Manage_Monitor_Mode_impl_Initialization_Api): Unit = {
    // TODO: There is a bit of a conceptual glitch here since following the
    //   AADL model of computation we should initialize all values here --
    //   There should be no notion of initializing execution outside of the
    //   initialise method.  However, Scala/Slang requires that all variables
    //   are required to be initialized at the point of declaration,
    //   so we must have initialization elsewhere, which probably leads
    //   to some notion of initializing code outside of the AADL computational
    //   model.   We should check the implications of that.
    monitor_mode = Isolette_Data_Model.Monitor_Mode.Init_Monitor_Mode;
    api.setmonitor_mode(monitor_mode)
  }

  def timeTriggered(api: Manage_Monitor_Mode_impl_Operational_Api): Unit = {

    // Requirements for Manage Regulator Mode (MMM)
    //
    //   These requirements are what is implied by the mode transition diagram in
    //   the FAA REMH Figure A-6
    //
    // == Initial Mode ==
    //
    // REQ-MMM-1: Upon the first dispatch of the thread, the monitor mode is Init.
    //
    // == Transitions from Init mode ==
    //
    // REQ-MMM-2: If the current mode is Init, then
    //   the mode is set to NORMAL iff the monitor status is true (valid) (see Table A-15), i.e.,
    //     if  NOT (Monitor Interface Failure OR Monitor Internal Failure)
    //         AND Current Temperature.Status = Valid
    //
    // REQ-MMM-3: If the current mode is Init, then
    //     the mode is set to Failed iff the time during
    //     which the thread has been in Init mode exceeds the
    //     Regulator Init Timeout value.
    //
    // ==  Transitions from Normal mode ==
    //
    // REQ-MMM-4: If the current regulator mode is Normal, then
    //     the regulator mode is set to Failed iff
    //     the regulator status is false, i.e.,
    //       if  (Monitor Interface Failure OR Monitor Internal Failure)
    //           OR NOT(Current Temperature.Status = Valid)

    // -------------- Get values of input ports ------------------

    val current_tempWstatus: Isolette_Data_Model.TempWstatus_impl =
      api.getcurrent_tempWstatus().get
    //  -- old code used before initialization methods
    // api.getcurrent_tempWstatus().getOrElseEager(DEFAULT_TEMPWSTATUS)
    val  current_temperature_status: Isolette_Data_Model.ValueStatus.Type =
    current_tempWstatus.status

    val interface_failure: Isolette_Data_Model.Failure_Flag_impl =
      api.getinterface_failure().get
    //  -- old code used before initialization methods
    // api.getinterface_failure().getOrElseEager(DEFAULT_INTERFACE_FAILURE)

    // FIXME: hack of initial data port values (monitor mode)
    val internal_failure : Isolette_Data_Model.Failure_Flag_impl =
    // api.getinternal_failure().get() // fails due to a missing connection
      api.getinternal_failure().getOrElseEager(
        Isolette_Data_Model.Failure_Flag_impl(InitialValues.DEFAULT_MONITOR_INTERNAL_FAILURE_FLAG))

    //==============================================================================


    // determine monitor status as specified in FAA REMH Table A-15
    //  monitor_status = NOT (Monitor Interface Failure OR Monitor Internal Failure)
    //                          AND Current Temperature.Status = Valid
    val monitor_status : B =
    (!(interface_failure.value || internal_failure.value)
      && (current_temperature_status == Isolette_Data_Model.ValueStatus.Valid))

    monitor_mode match {

      // Transitions from INIT Mode
      case Isolette_Data_Model.Monitor_Mode.Init_Monitor_Mode =>

        // REQ-MMM-2: If the current monitor mode is Init, then
        //   the monitor mode is set to NORMAL iff the monitor status is true, i.e.,
        //     if  NOT (Monitor Interface Failure OR Monitor Internal Failure)
        //         AND Current Temperature.Status = Valid
        if (monitor_status) {
          monitor_mode = Isolette_Data_Model.Monitor_Mode.Normal_Monitor_Mode
        }

        // REQ-MMM-3: If the current monitor mode is Init, then
        //     the monitor mode is set to Failed iff the time during
        //     which the thread has been in Init mode exceeds the
        //     Monitor Init Timeout value.
        if (!monitor_status && timeout_condition_satisfied()) {
          monitor_mode = Isolette_Data_Model.Monitor_Mode.Failed_Monitor_Mode
        }

      // otherwise we stay in Init mode

      // Transitions from NORMAL Mode
      case Isolette_Data_Model.Monitor_Mode.Normal_Monitor_Mode =>

        // REQ-MMM-4: If the current monitor mode is Normal, then
        //     the monitor mode is set to Failed iff
        //     the monitor status is false, i.e.,
        //       if  (Monitor Interface Failure OR Monitor Internal Failure)
        //           OR NOT(Current Temperature.Status = Valid)

        if (!monitor_status) {
          monitor_mode = Isolette_Data_Model.Monitor_Mode.Failed_Monitor_Mode
        }

      // Transitions from FAILED Mode (do nothing -- system must be rebooted)
      case Isolette_Data_Model.Monitor_Mode.Failed_Monitor_Mode =>
      // do nothing
    }

    api.setmonitor_mode(monitor_mode)
  }

  def activate(api: Manage_Monitor_Mode_impl_Operational_Api): Unit = { }

  def deactivate(api: Manage_Monitor_Mode_impl_Operational_Api): Unit = { }

  def finalise(api: Manage_Monitor_Mode_impl_Operational_Api): Unit = { }

  def recover(api: Manage_Monitor_Mode_impl_Operational_Api): Unit = { }
}
