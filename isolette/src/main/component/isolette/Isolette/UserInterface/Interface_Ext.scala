package isolette.Isolette.UserInterface

import isolette._
import org.sireum._

object Interface_Ext {

  // Alternatively could implement gui directly here rather than
  // doing pass-throughs

  val form: Gui = new Gui()

  var lowerDesiredTempWstatus: Isolette_Data_Model.TempWstatus_impl = _
  var upperDesiredTempWstatus: Isolette_Data_Model.TempWstatus_impl = _
  var lowerAlarmTempWstatus: Isolette_Data_Model.TempWstatus_impl = _
  var upperAlarmTempWstatus: Isolette_Data_Model.TempWstatus_impl = _

  def init(_lowerDesiredTempWstatus: Isolette_Data_Model.TempWstatus_impl,
           _upperDesiredTempWstatus: Isolette_Data_Model.TempWstatus_impl,
           _lowerAlarmTempWstatus: Isolette_Data_Model.TempWstatus_impl,
           _upperAlarmTempWstatus: Isolette_Data_Model.TempWstatus_impl): Unit = {
    lowerDesiredTempWstatus = _lowerDesiredTempWstatus
    upperDesiredTempWstatus = _upperDesiredTempWstatus
    lowerAlarmTempWstatus = _lowerAlarmTempWstatus
    upperAlarmTempWstatus = _upperAlarmTempWstatus

    form.init(
      lowerDesiredTempWstatus,
      upperDesiredTempWstatus,
      lowerAlarmTempWstatus,
      upperAlarmTempWstatus)
  }

  def setRegulatorStatus(v: Option[Isolette_Data_Model.Status.Type]): Unit = {
    form.setRegulatorStatus(v)
  }

  def setMonitorStatus(v: Option[Isolette_Data_Model.Status.Type]): Unit = {
    form.setMonitorStatus(v)
  }

  def setDispayTemperature(v: Option[Isolette_Data_Model.Temp_impl]): Unit = {
    form.setDisplayTemperature(v)
  }

  def setAlarmControl(v: Option[Isolette_Data_Model.On_Off.Type]): Unit = {
    form.setAlarmControl(v)
  }


  def getLowerDesiredTempWstatus(): Isolette_Data_Model.TempWstatus_impl = {
    return lowerDesiredTempWstatus
  }

  def getUpperDesiredTempWstatus(): Isolette_Data_Model.TempWstatus_impl = {
    return upperDesiredTempWstatus
  }

  def getLowerAlarmTempWstatus(): Isolette_Data_Model.TempWstatus_impl = {
    return lowerAlarmTempWstatus
  }

  def getUpperAlarmTempWstatus(): Isolette_Data_Model.TempWstatus_impl = {
    return upperAlarmTempWstatus
  }
}
