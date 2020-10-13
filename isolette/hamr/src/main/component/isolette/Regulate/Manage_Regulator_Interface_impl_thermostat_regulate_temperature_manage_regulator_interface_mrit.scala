// #Sireum

package isolette.Regulate

import org.sireum._
import isolette._

// This file will not be overwritten so is safe to edit
object Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit {

  //   Inputs
  //    lower_desired_temp
  //    upper_desired_temp
  //    current_temperature
  //    regulator_mode
  //
  //   Outputs
  //     regulator_status
  //     displayed_temp
  //     interface_failure

  // FIXME: hack of initialization of data port values due lack of proper protocol for thread/port initialization
  // Default lower and upper desired temperatures.
  // Used as a hack because we don't have a proper method for initialization of thread states and port values yet
  val LOW: Isolette_Data_Model.TempWstatus_impl = Isolette_Data_Model.TempWstatus_impl(InitialValues.DEFAULT_LOWER_DESIRED_TEMPERATURE, Isolette_Data_Model.ValueStatus.Valid)
  val HIGH: Isolette_Data_Model.TempWstatus_impl = Isolette_Data_Model.TempWstatus_impl(InitialValues.DEFAULT_UPPER_DESIRED_TEMPERATURE, Isolette_Data_Model.ValueStatus.Valid)
  // val DEFAULT_MODE: Isolette_Data_Model.Regulator_Mode.Type = Isolette_Data_Model.Regulator_Mode.Init
  // val DEFAULT_TEMP: Isolette_Data_Model.TempWstatus = Isolette_Data_Model.TempWstatus(InitialValues.DEFAULT_CURRENT_TEMPERATURE, Isolette_Data_Model.ValueStatus.Valid)

  //======================================
  // Initialize Entry Point
  //======================================

  def initialise(api: Manage_Regulator_Interface_impl_Initialization_Api): Unit = {
    // set initial lower desired temp
    api.setlower_desired_temp(
      Isolette_Data_Model.Temp_impl(
        InitialValues.DEFAULT_LOWER_DESIRED_TEMPERATURE))
    // set initial upper desired temp
    api.setupper_desired_temp(
      Isolette_Data_Model.Temp_impl(
        InitialValues.DEFAULT_UPPER_DESIRED_TEMPERATURE))
    // set initial displayed temp
    api.setdisplayed_temp(
      Isolette_Data_Model.Temp_impl(
        InitialValues.DEFAULT_DISPLAYED_TEMPERATURE))
    // set initial regulator status
    api.setregulator_status(
      InitialValues.DEFAULT_REGULATOR_STATUS)
    // set initial regulator failure
    api.setinterface_failure(
      Isolette_Data_Model.Failure_Flag_impl(
        InitialValues.DEFAULT_REGULATOR_INTERNAL_FAILURE_FLAG))
  }

  //======================================
  // Compute Entry Point
  //======================================

  def timeTriggered(api: Manage_Regulator_Interface_impl_Operational_Api): Unit = {
    // place holder for global/component in/out declarations,
    // which should reference port variables defined in bridge and any user declared component persistent state

    // place holder for derives/info flow clauses, which should align with info flows at the AADL level

    // place holder for data policy clauses
    //   (for this component, we can illustrate this by validation of the desired temperature)
    //   by requiring desired temperature to be authorized.
    //   Other options might include some constraints on the temp sensor data, e.g., sufficient fidelity
    //
    // == Regulator Status ==
    //
    // REQ-MRI-1: If the Regulator Mode is INIT,
    //   the Regulator Status shall be set to Init.
    // REQ-MRI-2: If the Regulator Mode is NORMAL,
    //   the Regulator Status shall be set to On.
    // REQ-MRI-3: If the Regulator Mode is FAILED,
    //   the Regulator Status shall be set to Failed.
    //
    // Latency: < Max Operator Response Time
    // Tolerance: N/A

    // == Display Temperature ==
    //
    // REQ-MRI-4: If the Regulator Mode is NORMAL, the
    //  Display Temperature shall be set to the value of the
    //  Current Temperature rounded to the nearest integer.
    //
    // REQ-MRI-5:
    //  If the Regulator Mode is not NORMAL,
    //  the value of the Display Temperature is UNSPECIFIED.
    //
    // Latency: < Max Operator Response Time
    // Tolerance: +/- 0.6 degrees F
    //
    // == Regulator Interface Failure ==
    //
    // REQ-MRI-6: If the Status attribute of the Lower Desired Temperature
    // or the Upper Desired Temperature is Invalid,
    // the Regulator Interface Failure shall be set to True.
    //
    // REQ-MRI-7: If the Status attribute of the Lower Desired Temperature
    // and the Upper Desired Temperature is Valid,
    // the Regulator Interface Failure shall be set to False.
    //
    // == Desired Range ===
    //
    // REQ-MRI-8: If the Regulator Interface Failure is False,
    // the Desired Range shall be set to the Desired Temperature Range.
    //
    // REQ-MRI-9: If the Regulator Interface Failure is True,
    // the Desired Range is UNSPECIFIED.

    // -------------- Get values of input ports ------------------

    val lower: Isolette_Data_Model.TempWstatus_impl =
      api.getlower_desired_tempWstatus().get
    // remove code for old approach that lacked initializers
    // api.getlower_desired_tempWstatus().getOrElseEager(LOW)

    val upper: Isolette_Data_Model.TempWstatus_impl =
      api.getupper_desired_tempWstatus().get
    // remove code for old approach that lacked initializers
    // api.getupper_desired_tempWstatus().getOrElseEager(HIGH)

    val regulator_mode: Isolette_Data_Model.Regulator_Mode.Type =
      api.getregulator_mode().get
    // remove code for old approach that lacked initializers
    // api.getregulator_mode().getOrElseEager(DEFAULT_MODE)

    val currentTemp: Isolette_Data_Model.TempWstatus_impl =
      api.getcurrent_tempWstatus().get
    // remove code for old approach that lacked initializers
    // api.getcurrent_tempWstatus().getOrElseEager(DEFAULT_TEMP)

    // =============================================
    //  Set values for Regulator Status (Table A-6)
    // =============================================

    var regulator_status: Isolette_Data_Model.Status.Type = Isolette_Data_Model.Status.Init_Status

    regulator_mode match {


      // =============================================
      //  Set values for Regulator Status
      // =============================================

      // Note that this code computes a function that is independent of the other
      // aspects of this thread.  This should be reflected in flow declarations.

      // INIT Mode
      case Isolette_Data_Model.Regulator_Mode.Init_Regulator_Mode =>
        // REQ-MRI-1: If the Regulator Mode is INIT,
        //   the Regulator Status shall be set to Init.
        regulator_status = Isolette_Data_Model.Status.Init_Status

      // NORMAL Mode
      case Isolette_Data_Model.Regulator_Mode.Normal_Regulator_Mode =>
        // REQ-MRI-2: If the Regulator Mode is NORMAL,
        //   the Regulator Status shall be set to On.
        regulator_status = Isolette_Data_Model.Status.On_Status

      // FAILED Mode
      case Isolette_Data_Model.Regulator_Mode.Failed_Regulator_Mode =>
        // REQ-MRI-3: If the Regulator Mode is FAILED,
        //   the Regulator Status shall be set to Failed.
        regulator_status = Isolette_Data_Model.Status.Failed_Status
    }

    api.setregulator_status(regulator_status)

    // =============================================
    //  Set values for Display Temperature (Table A-6)
    // =============================================

    // Latency: < Max Operator Response Time
    // Tolerance: +/- 0.6 degrees F
    //

    // FIXME: Develop better way to assigning final value to display temperature that
    //        doesn't involve selecting an arbitrary default temperature.
    var display_temperature =
    Isolette_Data_Model.Temp_impl(InitialValues.DEFAULT_DISPLAYED_TEMPERATURE)

    regulator_mode match {
      // NORMAL Mode
      case Isolette_Data_Model.Regulator_Mode.Normal_Regulator_Mode =>
        // REQ-MRI-4: If the Regulator Mode is NORMAL, the
        //  Display Temperature shall be set to the value of the
        //  Current Temperature rounded to the nearest integer.
        // FIXME: add rounding, which is currently omitted
        display_temperature = Isolette_Data_Model.Temp_impl(currentTemp.value)

      // INIT, FAILED Modes

      // REQ-MRI-5:
      //  If the Regulator Mode is not NORMAL,
      //  the value of the Display Temperature is UNSPECIFIED.
      //
      // leave the current temperature set to the default temperature value above.
      // This fulfills the requirement since the value when the Regulator Mode is not NORMAL
      // is unspecified.

      case Isolette_Data_Model.Regulator_Mode.Init_Regulator_Mode =>    // Do nothing
      case Isolette_Data_Model.Regulator_Mode.Failed_Regulator_Mode =>  // Do nothing
    }

    api.setdisplayed_temp(display_temperature)

    // =============================================
    //  Set values for Regulator Interface Failure internal variable
    // =============================================


    //
    // REQ-MRI-7: If the Status attribute of the Lower Desired Temperature
    // and the Upper Desired Temperature is Valid,
    // the Regulator Interface Failure shall be set to False.

    // FIXME:
    //  I [JMH] believe that these requirements reflect poor design.
    //  I don't even see why desired temperature values should have a status value.
    //  Input validation should be performed on these values in the operator interface.
    //  Improper values (i.e., values with bad status), should never even be passed here.

    // The interface_failure status defaults to TRUE (i.e., failing), which is the safe modality.
    var interface_failure: B = true

    // Extract the value status from both the upper and lower alarm range
    val upper_desired_temp_status: Isolette_Data_Model.ValueStatus.Type = upper.status
    val lower_desired_temp_status: Isolette_Data_Model.ValueStatus.Type = lower.status

    // Set the Monitor Interface Failure value based on the status values of the
    //   upper and lower temperature
    if (!(upper_desired_temp_status == Isolette_Data_Model.ValueStatus.Valid) ||
      !(lower_desired_temp_status == Isolette_Data_Model.ValueStatus.Valid)) {
      // REQ-MRI-6: If the Status attribute of the Lower Desired Temperature
      // or the Upper Desired Temperature is Invalid,
      // the Regulator Interface Failure shall be set to True.
      interface_failure = true
    } else {
      // REQ-MRI-7: If the Status attribute of the Lower Desired Temperature
      // and the Upper Desired Temperature is Valid,
      // the Regulator Interface Failure shall be set to False.
      interface_failure = false
    }

    // create the appropriately typed value to send on the output port and set the port value
    var interface_failure_flag =  Isolette_Data_Model.Failure_Flag_impl(interface_failure)
    api.setinterface_failure(interface_failure_flag)


    // =============================================
    //  Set values for Desired Range internal variable
    // =============================================

    // REQ-MRI-9: If the Regulator Interface Failure is True,
    // the Desired Range is UNSPECIFIED.

    // FIXME:
    //   What to do for unspecified case

    if (!interface_failure) {
      // REQ-MRI-8: If the Regulator Interface Failure is False,
      // the Desired Range shall be set to the Desired Temperature Range.
      api.setlower_desired_temp(Isolette_Data_Model.Temp_impl(lower.value))
      api.setupper_desired_temp(Isolette_Data_Model.Temp_impl(upper.value))
    }
  }

  def activate(api: Manage_Regulator_Interface_impl_Operational_Api): Unit = { }

  def deactivate(api: Manage_Regulator_Interface_impl_Operational_Api): Unit = { }

  def finalise(api: Manage_Regulator_Interface_impl_Operational_Api): Unit = { }

  def recover(api: Manage_Regulator_Interface_impl_Operational_Api): Unit = { }
}
