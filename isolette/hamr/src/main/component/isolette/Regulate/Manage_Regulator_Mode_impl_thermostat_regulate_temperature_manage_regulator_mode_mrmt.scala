// #Sireum

package isolette.Regulate

import org.sireum._
import isolette._

// This file will not be overwritten so is safe to edit
object Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode_mrmt {

  // Define function capturing init mode time out condition as defined in FAA REMH
  //   Figure A-4 and Table A-9
  //
  // FIXME: simulate check of Manage_Regulator_Mode initial value timeout constraint
  def timeout_condition_satisfied(): B = {return false}

  //======================================
  // Persistent component state
  //======================================

  var regulator_mode : Isolette_Data_Model.Regulator_Mode.Type = Isolette_Data_Model.Regulator_Mode.Init_Regulator_Mode

  //======================================
  // Initialize Entry Point
  //======================================

  def initialise(api: Manage_Regulator_Mode_impl_Initialization_Api): Unit = {
    // TODO: There is a bit of a conceptual glitch here since following the
    //   AADL model of computation we should initialize all values here --
    //   There should be no notion of initializing execution outside of the
    //   initialise method.  However, Scala/Slang requires that all variables
    //   are required to be initialized at the point of declaration,
    //   so we must have initialization elsewhere, which probably leads
    //   to some notion of initializing code outside of the AADL computational
    //   model.   We should check the implications of that.
    regulator_mode = Isolette_Data_Model.Regulator_Mode.Init_Regulator_Mode;
    api.setregulator_mode(regulator_mode)
  }

  //======================================
  // Compute Entry Point
  //======================================

  def timeTriggered(api: Manage_Regulator_Mode_impl_Operational_Api): Unit = {

    // input ports:
    //   current_temperature
    //   interface_failure
    //   internal_failure
    // output ports:
    //   regulator_mode
    //
    // Requirements for Manage Regulator Mode (MRM)
    //
    //   These requirements are what is implied by the mode transition diagram in
    //   the FAA REMH Figure A-4
    //
    // == Initial Mode ==
    //
    // REQ-MRM-1: Upon the first dispatch of the thread, the regulator mode is Init.
    //
    // == Transitions from Init mode ==
    //
    // REQ-MRM-2: If the current regulator mode is Init, then
    //   the regulator mode is set to NORMAL iff the regulator status is valid (see Table A-10), i.e.,
    //     if  NOT (Regulator Interface Failure OR Regulator Internal Failure)
    //         AND Current Temperature.Status = Valid
    //
    // REQ-MRM-3: If the current regulator mode is Init, then
    //     the regulator mode is set to Failed iff the time during
    //     which the thread has been in Init mode exceeds the
    //     Regulator Init Timeout value.
    //
    // ==  Transitions from Normal mode ==
    //
    // REQ-MRM-4: If the current regulator mode is Normal, then
    //     the regulator mode is set to Failed iff
    //     the regulator status is false, i.e.,
    //       if  (Regulator Interface Failure OR Regulator Internal Failure)
    //           OR NOT(Current Temperature.Status = Valid)

    // -------------- Get values of input ports ------------------

    val current_tempWstatus: Isolette_Data_Model.TempWstatus_impl =
      api.getcurrent_tempWstatus().get
    //  -- old code used before initialization methods
    // api.getcurrent_tempWstatus().getOrElseEager(DEFAULT_TEMPWSTATUS)
    val  current_temperature_status: Isolette_Data_Model.ValueStatus.Type = current_tempWstatus.status

    val interface_failure: Isolette_Data_Model.Failure_Flag_impl =
      api.getinterface_failure().get
    //  -- old code used before initialization methods
    // api.getinterface_failure().getOrElseEager(DEFAULT_INTERFACE_FAILURE)

    // FIXME: hack to fix missing connection
    //  When connection is added, the initial value should be
    //  set in the initialize entry point for Detect_Regulator_Failure
    val internal_failure : Isolette_Data_Model.Failure_Flag_impl =
    // api.getinternal_failure().get() -- fails due to a missing connection
    api.getinternal_failure().getOrElseEager(
      Isolette_Data_Model.Failure_Flag_impl(InitialValues.DEFAULT_REGULATOR_INTERNAL_FAILURE_FLAG))

    //==============================================================================


    // determine regulator status as specified in FAA REMH Table A-10
    //  regulator_status = NOT (Monitor Interface Failure OR Monitor Internal Failure)
    //                          AND Current Temperature.Status = Valid
    val regulator_status : B =
    (!(interface_failure.value || internal_failure.value)
      && (current_temperature_status == Isolette_Data_Model.ValueStatus.Valid))

    regulator_mode match {

      // Transitions from INIT Mode
      case Isolette_Data_Model.Regulator_Mode.Init_Regulator_Mode =>

        // REQ-MRM-2: If the current regulator mode is Init, then
        //   the regulator mode is set to NORMAL iff the regulator status is true, i.e.,
        //     if  NOT (Monitor Interface Failure OR Monitor Internal Failure)
        //         AND Current Temperature.Status = Valid
        if (regulator_status) {
          regulator_mode = Isolette_Data_Model.Regulator_Mode.Normal_Regulator_Mode
        }

        // REQ-MRM-3: If the current regulator mode is Init, then
        //     the regulator mode is set to Failed iff the time during
        //     which the thread has been in Init mode exceeds the
        //     Regulator Init Timeout value.
        if (!regulator_status && timeout_condition_satisfied()) {
          regulator_mode = Isolette_Data_Model.Regulator_Mode.Failed_Regulator_Mode
        }

      // otherwise we stay in Init mode

      // Transitions from NORMAL Mode
      case Isolette_Data_Model.Regulator_Mode.Normal_Regulator_Mode =>

        // REQ-MRM-4: If the current regulator mode is Normal, then
        //     the regulator mode is set to Failed iff
        //     the regulator status is false, i.e.,
        //       if  (Monitor Interface Failure OR Monitor Internal Failure)
        //           OR NOT(Current Temperature.Status = Valid)

        if (!regulator_status) {
          regulator_mode = Isolette_Data_Model.Regulator_Mode.Failed_Regulator_Mode
        }

      // Transitions from FAILED Mode (do nothing -- system must be rebooted)
      case Isolette_Data_Model.Regulator_Mode.Failed_Regulator_Mode =>
      // do nothing
    }

    api.setregulator_mode(regulator_mode)
  }

  def activate(api: Manage_Regulator_Mode_impl_Operational_Api): Unit = { }

  def deactivate(api: Manage_Regulator_Mode_impl_Operational_Api): Unit = { }

  def finalise(api: Manage_Regulator_Mode_impl_Operational_Api): Unit = { }

  def recover(api: Manage_Regulator_Mode_impl_Operational_Api): Unit = { }
}
