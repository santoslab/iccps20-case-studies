// #Sireum

package isolette.Regulate

import org.sireum._
import isolette._

// This file will not be overwritten so is safe to edit
object Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_mhst {

  //======================================
  // Persistent component state
  //======================================

  // FIXME: confirm that having "lastCmd" for heat source set to "Off" is OK
  var lastCmd: Isolette_Data_Model.On_Off.Type = Isolette_Data_Model.On_Off.Off

  //======================================
  // Initialize Entry Point
  //======================================

  def initialise(api: Manage_Heat_Source_impl_Initialization_Api): Unit = {
    // TODO: There is a bit of a conceptual glitch here since following the
    //   AADL model of computation we should initialize all values here --
    //   There should be no notion of initializing execution outside of the
    //   initialise method.  However, Scala/Slang requires that all variables
    //   are required to be initialized at the point of declaration,
    //   so we must have initialization elsewhere, which probably leads
    //   to some notion of initializing code outside of the AADL computational
    //   model.   We should check the implications of that.
    lastCmd = Isolette_Data_Model.On_Off.Off
    // REQ-MHS-1: If the Regulator Mode is INIT, the Heat Control shall be
    // set to Off
    val currentCmd = Isolette_Data_Model.On_Off.Off
    api.setheat_control(currentCmd)
  }

  //======================================
  // Compute Entry Point
  //======================================

  def timeTriggered(api: Manage_Heat_Source_impl_Operational_Api): Unit = {

    // Requirements for Manage Heat Source (MHS)
    //
    // REQ-MHS-1: If the Regulator Mode is INIT, the Heat Control shall be
    // set to Off.

    // REQ-MHS-2: If the Regulator Mode is NORMAL and the Current Temperature is less than
    // the Lower Desired Temperature, the Heat Control shall be set to On.

    // REQ-MHS-3: If the Regulator Mode is NORMAL and the Current Temperature is greater than
    // the Upper Desired Temperature, the Heat Control shall be set to Off.

    // REQ-MHS-4: If the Regulator Mode is NORMAL and the Current
    // Temperature is greater than or equal to the Lower Desired Temperature
    // and less than or equal to the Upper Desired Temperature, the value of
    // the Heat Control shall not be changed.

    // REQ-MHS-5: If the Regulator Mode is FAILED, the Heat Control shall be
    // set to Off.

    //  Latency: < Allowed Heat Source Latency

    // -------------- Get values of input ports ------------------

    // lower desired temperature
    val lower: Isolette_Data_Model.Temp_impl =
      api.getlower_desired_temp().get

    // upper desired temperature
    val upper: Isolette_Data_Model.Temp_impl =
      api.getupper_desired_temp().get

    // regulator mode
    val regulator_mode : Isolette_Data_Model.Regulator_Mode.Type =
      api.getregulator_mode().get

    // current temperature with status
    val currentTemp : Isolette_Data_Model.TempWstatus_impl =
      api.getcurrent_tempWstatus().get

    //================ compute / control logic ===========================

    // current command defaults to value of last command (REQ-MHS-4)
    var currentCmd: Isolette_Data_Model.On_Off.Type = lastCmd

    regulator_mode match {

      // ----- INIT Mode --------
      case Isolette_Data_Model.Regulator_Mode.Init_Regulator_Mode =>
        // REQ-MHS-1
        currentCmd = Isolette_Data_Model.On_Off.Off

      // ------ NORMAL Mode -------
      case Isolette_Data_Model.Regulator_Mode.Normal_Regulator_Mode =>

        if (currentTemp.value > upper.value) {
          // REQ-MHS-2
          currentCmd = Isolette_Data_Model.On_Off.Off
        } else if (currentTemp.value < lower.value) {
          // REQ-MHS-3
          currentCmd = Isolette_Data_Model.On_Off.Onn
        }

      // otherwise currentCmd defaults to lastCmd (REQ-MHS-4)

      // ------ FAILED Mode -------
      case Isolette_Data_Model.Regulator_Mode.Failed_Regulator_Mode =>
        // REQ-MHS-5
        currentCmd = Isolette_Data_Model.On_Off.Off
    }

    // -------------- Set values of output ports ------------------

    api.setheat_control(currentCmd)
    lastCmd = currentCmd
  }

  def activate(api: Manage_Heat_Source_impl_Operational_Api): Unit = { }

  def deactivate(api: Manage_Heat_Source_impl_Operational_Api): Unit = { }

  def finalise(api: Manage_Heat_Source_impl_Operational_Api): Unit = { }

  def recover(api: Manage_Heat_Source_impl_Operational_Api): Unit = { }
}
