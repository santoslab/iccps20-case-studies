// #Sireum

package isolette.Monitor

import org.sireum._
import art._
import isolette._

// This file was auto-generated.  Do not edit

@record class Manage_Alarm_impl_Bridge(
  val id: Art.BridgeId,
  val name: String,
  val dispatchProtocol: DispatchPropertyProtocol,
  val dispatchTriggers: Option[ISZ[Art.PortId]],

  current_tempWstatus: Port[Isolette_Data_Model.TempWstatus_impl],
  lower_alarm_temp: Port[Isolette_Data_Model.Temp_impl],
  upper_alarm_temp: Port[Isolette_Data_Model.Temp_impl],
  monitor_mode: Port[Isolette_Data_Model.Monitor_Mode.Type],
  alarm_control: Port[Isolette_Data_Model.On_Off.Type]
  ) extends Bridge {

  val ports : Bridge.Ports = Bridge.Ports(
    all = ISZ(current_tempWstatus,
              lower_alarm_temp,
              upper_alarm_temp,
              monitor_mode,
              alarm_control),

    dataIns = ISZ(current_tempWstatus,
                  lower_alarm_temp,
                  upper_alarm_temp,
                  monitor_mode),

    dataOuts = ISZ(alarm_control),

    eventIns = ISZ(),

    eventOuts = ISZ()
  )

  val api : Manage_Alarm_impl_Bridge.Api =
    Manage_Alarm_impl_Bridge.Api(
      id,
      current_tempWstatus.id,
      lower_alarm_temp.id,
      upper_alarm_temp.id,
      monitor_mode.id,
      alarm_control.id
    )

  val entryPoints : Bridge.EntryPoints =
    Manage_Alarm_impl_Bridge.EntryPoints(
      id,

      current_tempWstatus.id,
      lower_alarm_temp.id,
      upper_alarm_temp.id,
      monitor_mode.id,
      alarm_control.id,

      dispatchTriggers,

      Manage_Alarm_impl_Impl(api)
    )
}

object Manage_Alarm_impl_Bridge {

  @record class Api(
    id : Art.BridgeId,
    current_tempWstatus_Id : Art.PortId,
    lower_alarm_temp_Id : Art.PortId,
    upper_alarm_temp_Id : Art.PortId,
    monitor_mode_Id : Art.PortId,
    alarm_control_Id : Art.PortId) {


    def getcurrent_tempWstatus() : Option[Isolette_Data_Model.TempWstatus_impl] = {
      val value : Option[Isolette_Data_Model.TempWstatus_impl] = Art.getValue(current_tempWstatus_Id) match {
        case Some(Isolette_Data_Model.TempWstatus_impl_Payload(v)) => Some(v)
        case Some(v) =>
          Art.logError(id, s"Unexpected payload on port current_tempWstatus.  Expecting 'Isolette_Data_Model.TempWstatus_impl_Payload' but received ${v}")
          None[Isolette_Data_Model.TempWstatus_impl]()
        case _ => None[Isolette_Data_Model.TempWstatus_impl]()
      }
      return value
    }

    def getlower_alarm_temp() : Option[Isolette_Data_Model.Temp_impl] = {
      val value : Option[Isolette_Data_Model.Temp_impl] = Art.getValue(lower_alarm_temp_Id) match {
        case Some(Isolette_Data_Model.Temp_impl_Payload(v)) => Some(v)
        case Some(v) =>
          Art.logError(id, s"Unexpected payload on port lower_alarm_temp.  Expecting 'Isolette_Data_Model.Temp_impl_Payload' but received ${v}")
          None[Isolette_Data_Model.Temp_impl]()
        case _ => None[Isolette_Data_Model.Temp_impl]()
      }
      return value
    }

    def getupper_alarm_temp() : Option[Isolette_Data_Model.Temp_impl] = {
      val value : Option[Isolette_Data_Model.Temp_impl] = Art.getValue(upper_alarm_temp_Id) match {
        case Some(Isolette_Data_Model.Temp_impl_Payload(v)) => Some(v)
        case Some(v) =>
          Art.logError(id, s"Unexpected payload on port upper_alarm_temp.  Expecting 'Isolette_Data_Model.Temp_impl_Payload' but received ${v}")
          None[Isolette_Data_Model.Temp_impl]()
        case _ => None[Isolette_Data_Model.Temp_impl]()
      }
      return value
    }

    def getmonitor_mode() : Option[Isolette_Data_Model.Monitor_Mode.Type] = {
      val value : Option[Isolette_Data_Model.Monitor_Mode.Type] = Art.getValue(monitor_mode_Id) match {
        case Some(Isolette_Data_Model.Monitor_Mode_Payload(v)) => Some(v)
        case Some(v) =>
          Art.logError(id, s"Unexpected payload on port monitor_mode.  Expecting 'Isolette_Data_Model.Monitor_Mode_Payload' but received ${v}")
          None[Isolette_Data_Model.Monitor_Mode.Type]()
        case _ => None[Isolette_Data_Model.Monitor_Mode.Type]()
      }
      return value
    }

    def setalarm_control(value : Isolette_Data_Model.On_Off.Type) : Unit = {
      Art.putValue(alarm_control_Id, Isolette_Data_Model.On_Off_Payload(value))
    }

    def logInfo(msg: String): Unit = {
      Art.logInfo(id, msg)
    }

    def logDebug(msg: String): Unit = {
      Art.logDebug(id, msg)
    }

    def logError(msg: String): Unit = {
      Art.logError(id, msg)
    }
  }

  @record class EntryPoints(
    Manage_Alarm_impl_BridgeId : Art.BridgeId,

    current_tempWstatus_Id : Art.PortId,
    lower_alarm_temp_Id : Art.PortId,
    upper_alarm_temp_Id : Art.PortId,
    monitor_mode_Id : Art.PortId,
    alarm_control_Id : Art.PortId,

    dispatchTriggers : Option[ISZ[Art.PortId]],

    component : Manage_Alarm_impl_Impl ) extends Bridge.EntryPoints {

    val dataInPortIds: ISZ[Art.PortId] = ISZ(current_tempWstatus_Id,
                                             lower_alarm_temp_Id,
                                             upper_alarm_temp_Id,
                                             monitor_mode_Id)

    val eventInPortIds: ISZ[Art.PortId] = ISZ()

    val dataOutPortIds: ISZ[Art.PortId] = ISZ(alarm_control_Id)

    val eventOutPortIds: ISZ[Art.PortId] = ISZ()

    def compute(): Unit = {
      Art.receiveInput(eventInPortIds, dataInPortIds)
      component.timeTriggered()
      Art.sendOutput(eventOutPortIds, dataOutPortIds)
    }

    override
    def testCompute(): Unit = {
      Art.receiveInput(eventInPortIds, dataInPortIds)
      component.timeTriggered()
      Art.releaseOutput(eventOutPortIds, dataOutPortIds)
    }

    def activate: Unit = {
      component.activate()
    }

    def deactivate: Unit = {
      component.deactivate()
    }

    def finalise: Unit = {
      component.finalise()
    }

    def initialise: Unit = {
      component.initialise()
      Art.sendOutput(eventOutPortIds, dataOutPortIds)
    }

    def recover: Unit = {
      component.recover()
    }
  }
}