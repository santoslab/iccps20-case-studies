// #Sireum

package isolette.Isolette.UserInterface

import org.sireum._
import isolette._

@ext object Interface {
  def init(_lowerDesiredTempWstatus: Isolette_Data_Model.TempWstatus_impl,
           _upperDesiredTempWstatus: Isolette_Data_Model.TempWstatus_impl,
           _lowerAlarmTempWstatus: Isolette_Data_Model.TempWstatus_impl,
           _upperAlarmTempWstatus: Isolette_Data_Model.TempWstatus_impl): Unit = $

  def setRegulatorStatus(v: Option[Isolette_Data_Model.Status.Type]): Unit = $
  def setMonitorStatus(v: Option[Isolette_Data_Model.Status.Type]): Unit = $
  def setDispayTemperature(v: Option[Isolette_Data_Model.Temp_impl]): Unit = $
  def setAlarmControl(v: Option[Isolette_Data_Model.On_Off.Type]): Unit = $

  def getLowerDesiredTempWstatus(): Isolette_Data_Model.TempWstatus_impl = $
  def getUpperDesiredTempWstatus(): Isolette_Data_Model.TempWstatus_impl = $
  def getLowerAlarmTempWstatus(): Isolette_Data_Model.TempWstatus_impl = $
  def getUpperAlarmTempWstatus(): Isolette_Data_Model.TempWstatus_impl = $
}