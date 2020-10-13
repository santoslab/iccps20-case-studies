// #Sireum

package isolette.Monitor

import org.sireum._
import isolette._

// This file will not be overwritten so is safe to edit
object Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_mmit {

  // inputs
  //    current_temperature
  //    monitor_mode
  //    upper_alarm_temperature
  //    lower_alarm_temperature
  //
  // outputs
  //    monitor_status
  //    interface_failure


  //  === Monitor Status ===
  //
  //  REQ-MMI-1: If the Manage Monitor Interface mode is INIT,
  //  the Monitor Status shall be set to Init.
  //
  //  REQ-MMI-2: If the Manage Monitor Interface mode is NORMAL,
  //  the Monitor Status shall be set to On.
  //
  //  REQ-MMI-3: If the Manage Monitor Interface mode is FAILED,
  //  the Monitor Status shall be set to Failed.
  //  Latency: < Max Operator Response Time
  //  Tolerance: N/A
  //
  //
  //  === Monitor Interface Failure internal variable ===
  //
  //  REQ-MMI-4: If the Status attribute of the Lower Alarm Temperature
  //  or the Upper Alarm Temperature is Invalid,
  //  the Monitor Interface Failure shall be set to True.
  //
  //  REQ-MMI-5: If the Status attribute of the Lower Alarm Temperature
  //  and the Upper Alarm Temperature is Valid,
  //  the Monitor Interface Failure shall be set to False.
  //
  //  === Alarm Range Internal variable ===
  //
  //  REQ-MMI-6: If the Monitor Interface Failure is False,
  //  the Alarm Range variable shall be set to the Desired Temperature Range.
  //
  //  REQ-MMI-7: If the Monitor Interface Failure is True,
  //  the Alarm Range variable is UNSPECIFIED.
  //

  // Default values for input ports
  // Used as a hack because we don't have a proper method for initialization of thread states and port values yet
  // Fixme: refactor val names to better align with types, use "default" in names
  val LOW: Isolette_Data_Model.TempWstatus_impl = Isolette_Data_Model.TempWstatus_impl(InitialValues.DEFAULT_LOWER_ALARM_TEMPERATURE, Isolette_Data_Model.ValueStatus.Valid)
  val HIGH: Isolette_Data_Model.TempWstatus_impl = Isolette_Data_Model.TempWstatus_impl(InitialValues.DEFAULT_UPPER_ALARM_TEMPERATURE, Isolette_Data_Model.ValueStatus.Valid)

  //======================================
  // Initialize Entry Point
  //======================================

  def initialise(api: Manage_Monitor_Interface_impl_Initialization_Api): Unit = {
    // set initial lower desired temp
    api.setlower_alarm_temp(
      Isolette_Data_Model.Temp_impl(
        InitialValues.DEFAULT_LOWER_ALARM_TEMPERATURE))
    // set initial upper desired temp
    api.setupper_alarm_temp(
      Isolette_Data_Model.Temp_impl(
        InitialValues.DEFAULT_UPPER_ALARM_TEMPERATURE))
    // set initial regulator status
    api.setmonitor_status(InitialValues.DEFAULT_MONITOR_STATUS)
    // set initial regulator failure
    api.setinterface_failure(
      Isolette_Data_Model.Failure_Flag_impl(
        InitialValues.DEFAULT_MONITOR_INTERFACE_FAILURE_FLAG))
  }

  //======================================
  // Compute Entry Point
  //======================================

  def timeTriggered(api: Manage_Monitor_Interface_impl_Operational_Api): Unit = {

    // -------------- Get values of input ports ------------------

    val lower: Isolette_Data_Model.TempWstatus_impl =
      api.getlower_alarm_tempWstatus().get
    // remove code for old approach that lacked initializers
    // api.getlower_alarm_tempWstatus().getOrElseEager(LOW)

    // api.logInfo(s"   XXXXXXXXXXX  ${lower}")
    val upper: Isolette_Data_Model.TempWstatus_impl =
      api.getupper_alarm_tempWstatus().get
    // remove code for old approach that lacked initializers
    // api.getupper_alarm_tempWstatus().getOrElseEager(HIGH)

    val monitor_mode: Isolette_Data_Model.Monitor_Mode.Type =
      api.getmonitor_mode().get
    // remove code for old approach that lacked initializers
    // api.getmonitor_mode().getOrElseEager(DEFAULT_MODE)

    val currentTemp: Isolette_Data_Model.TempWstatus_impl =
      api.getcurrent_tempWstatus().get
    // remove code for old approach that lacked initializers
    // api.getcurrent_tempWstatus().getOrElseEager(DEFAULT_TEMP)


    // =============================================
    //  Set values for Monitor Status (Table A-6)
    // =============================================

    var monitor_status: Isolette_Data_Model.Status.Type = Isolette_Data_Model.Status.Init_Status

    monitor_mode match {

      // INIT Mode
      case Isolette_Data_Model.Monitor_Mode.Init_Monitor_Mode =>
        //  REQ-MMI-1: If the Manage Monitor Interface mode is INIT,
        //  the Monitor Status shall be set to Init.
        monitor_status = Isolette_Data_Model.Status.Init_Status

      // NORMAL Mode
      case Isolette_Data_Model.Monitor_Mode.Normal_Monitor_Mode =>
        //  REQ-MMI-2: If the Manage Monitor Interface mode is NORMAL,
        //  the Monitor Status shall be set to On.
        monitor_status = Isolette_Data_Model.Status.On_Status

      // FAILED Mode
      case Isolette_Data_Model.Monitor_Mode.Failed_Monitor_Mode =>
        //  REQ-MMI-3: If the Manage Monitor Interface mode is FAILED,
        //  the Monitor Status shall be set to Failed.
        monitor_status = Isolette_Data_Model.Status.Failed_Status
    }

    api.setmonitor_status(monitor_status)


    // =============================================
    //  Set values for Monitor Interface Failure internal variable
    // =============================================


    // FIXME: I [JMH] believe that these requirements reflect poor design.
    //  I don't even see why alarm temperature values should have a status value.
    //  Input validation should be performed on these values in the operator interface.
    //  Improper values (i.e., values with bad status), should never even be passed here.
    //

    // The interface_failure status defaults to TRUE, which is the safe modality.
    var interface_failure: B = true

    // Extract the value status from both the upper and lower alarm range
    val upper_alarm_status: Isolette_Data_Model.ValueStatus.Type = upper.status
    val lower_alarm_status: Isolette_Data_Model.ValueStatus.Type = lower.status

    // Set the Monitor Interface Failure value based on the status values of the
    //   upper and lower temperature
    if (!(upper_alarm_status == Isolette_Data_Model.ValueStatus.Valid) ||
      !(lower_alarm_status == Isolette_Data_Model.ValueStatus.Valid)) {
      //  REQ-MMI-4: If the Status attribute of the Lower Alarm Temperature
      //  or the Upper Alarm Temperature is Invalid,
      //  the Monitor Interface Failure shall be set to True.
      interface_failure = true
    } else {
      //  REQ-MMI-5: If the Status attribute of the Lower Alarm Temperature
      //  and the Upper Alarm Temperature is Valid,
      //  the Monitor Interface Failure shall be set to False.
      interface_failure = false
    }

    // create the appropriately typed value to send on the output port and set the port value
    var interface_failure_flag =  Isolette_Data_Model.Failure_Flag_impl(interface_failure)
    api.setinterface_failure(interface_failure_flag)


    // =============================================
    //  Set values for Alarm Range internal variable
    // =============================================

    if (!interface_failure) {
      //  REQ-MMI-6: If the Monitor Interface Failure is False,
      //  the Alarm Range variable shall be set to the Desired Temperature Range.
      api.setlower_alarm_temp(Isolette_Data_Model.Temp_impl(lower.value))
      api.setupper_alarm_temp(Isolette_Data_Model.Temp_impl(upper.value))
    }

    //  REQ-MMI-7: If the Monitor Interface Failure is True,
    //  the Alarm Range variable is UNSPECIFIED.

    // FIXME:
    //   What to do for unspecified case
  }

  def activate(api: Manage_Monitor_Interface_impl_Operational_Api): Unit = { }

  def deactivate(api: Manage_Monitor_Interface_impl_Operational_Api): Unit = { }

  def finalise(api: Manage_Monitor_Interface_impl_Operational_Api): Unit = { }

  def recover(api: Manage_Monitor_Interface_impl_Operational_Api): Unit = { }
}
