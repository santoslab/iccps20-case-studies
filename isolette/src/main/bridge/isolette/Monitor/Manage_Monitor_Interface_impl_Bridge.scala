// #Sireum

package isolette.Monitor

import org.sireum._
import art._
import isolette._

// This file was auto-generated.  Do not edit

@record class Manage_Monitor_Interface_impl_Bridge(
  val id: Art.BridgeId,
  val name: String,
  val dispatchProtocol: DispatchPropertyProtocol,
  val dispatchTriggers: Option[ISZ[Art.PortId]],

  upper_alarm_tempWstatus: Port[Isolette_Data_Model.TempWstatus_impl],
  lower_alarm_tempWstatus: Port[Isolette_Data_Model.TempWstatus_impl],
  current_tempWstatus: Port[Isolette_Data_Model.TempWstatus_impl],
  monitor_mode: Port[Isolette_Data_Model.Monitor_Mode.Type],
  upper_alarm_temp: Port[Isolette_Data_Model.Temp_impl],
  lower_alarm_temp: Port[Isolette_Data_Model.Temp_impl],
  monitor_status: Port[Isolette_Data_Model.Status.Type],
  interface_failure: Port[Isolette_Data_Model.Failure_Flag_impl]
  ) extends Bridge {

  val ports : Bridge.Ports = Bridge.Ports(
    all = ISZ(upper_alarm_tempWstatus,
              lower_alarm_tempWstatus,
              current_tempWstatus,
              monitor_mode,
              upper_alarm_temp,
              lower_alarm_temp,
              monitor_status,
              interface_failure),

    dataIns = ISZ(upper_alarm_tempWstatus,
                  lower_alarm_tempWstatus,
                  current_tempWstatus,
                  monitor_mode),

    dataOuts = ISZ(upper_alarm_temp,
                   lower_alarm_temp,
                   monitor_status,
                   interface_failure),

    eventIns = ISZ(),

    eventOuts = ISZ()
  )

  val api : Manage_Monitor_Interface_impl_Bridge.Api =
    Manage_Monitor_Interface_impl_Bridge.Api(
      id,
      upper_alarm_tempWstatus.id,
      lower_alarm_tempWstatus.id,
      current_tempWstatus.id,
      monitor_mode.id,
      upper_alarm_temp.id,
      lower_alarm_temp.id,
      monitor_status.id,
      interface_failure.id
    )

  val entryPoints : Bridge.EntryPoints =
    Manage_Monitor_Interface_impl_Bridge.EntryPoints(
      id,

      upper_alarm_tempWstatus.id,
      lower_alarm_tempWstatus.id,
      current_tempWstatus.id,
      monitor_mode.id,
      upper_alarm_temp.id,
      lower_alarm_temp.id,
      monitor_status.id,
      interface_failure.id,

      dispatchTriggers,

      Manage_Monitor_Interface_impl_Impl(api)
    )
}

object Manage_Monitor_Interface_impl_Bridge {

  @record class Api(
    id : Art.BridgeId,
    upper_alarm_tempWstatus_Id : Art.PortId,
    lower_alarm_tempWstatus_Id : Art.PortId,
    current_tempWstatus_Id : Art.PortId,
    monitor_mode_Id : Art.PortId,
    upper_alarm_temp_Id : Art.PortId,
    lower_alarm_temp_Id : Art.PortId,
    monitor_status_Id : Art.PortId,
    interface_failure_Id : Art.PortId) {


    def getupper_alarm_tempWstatus() : Option[Isolette_Data_Model.TempWstatus_impl] = {
      val value : Option[Isolette_Data_Model.TempWstatus_impl] = Art.getValue(upper_alarm_tempWstatus_Id) match {
        case Some(Isolette_Data_Model.TempWstatus_impl_Payload(v)) => Some(v)
        case Some(v) =>
          Art.logError(id, s"Unexpected payload on port upper_alarm_tempWstatus.  Expecting 'Isolette_Data_Model.TempWstatus_impl_Payload' but received ${v}")
          None[Isolette_Data_Model.TempWstatus_impl]()
        case _ => None[Isolette_Data_Model.TempWstatus_impl]()
      }
      return value
    }

    def getlower_alarm_tempWstatus() : Option[Isolette_Data_Model.TempWstatus_impl] = {
      val value : Option[Isolette_Data_Model.TempWstatus_impl] = Art.getValue(lower_alarm_tempWstatus_Id) match {
        case Some(Isolette_Data_Model.TempWstatus_impl_Payload(v)) => Some(v)
        case Some(v) =>
          Art.logError(id, s"Unexpected payload on port lower_alarm_tempWstatus.  Expecting 'Isolette_Data_Model.TempWstatus_impl_Payload' but received ${v}")
          None[Isolette_Data_Model.TempWstatus_impl]()
        case _ => None[Isolette_Data_Model.TempWstatus_impl]()
      }
      return value
    }

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

    def setupper_alarm_temp(value : Isolette_Data_Model.Temp_impl) : Unit = {
      Art.putValue(upper_alarm_temp_Id, Isolette_Data_Model.Temp_impl_Payload(value))
    }

    def setlower_alarm_temp(value : Isolette_Data_Model.Temp_impl) : Unit = {
      Art.putValue(lower_alarm_temp_Id, Isolette_Data_Model.Temp_impl_Payload(value))
    }

    def setmonitor_status(value : Isolette_Data_Model.Status.Type) : Unit = {
      Art.putValue(monitor_status_Id, Isolette_Data_Model.Status_Payload(value))
    }

    def setinterface_failure(value : Isolette_Data_Model.Failure_Flag_impl) : Unit = {
      Art.putValue(interface_failure_Id, Isolette_Data_Model.Failure_Flag_impl_Payload(value))
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
    Manage_Monitor_Interface_impl_BridgeId : Art.BridgeId,

    upper_alarm_tempWstatus_Id : Art.PortId,
    lower_alarm_tempWstatus_Id : Art.PortId,
    current_tempWstatus_Id : Art.PortId,
    monitor_mode_Id : Art.PortId,
    upper_alarm_temp_Id : Art.PortId,
    lower_alarm_temp_Id : Art.PortId,
    monitor_status_Id : Art.PortId,
    interface_failure_Id : Art.PortId,

    dispatchTriggers : Option[ISZ[Art.PortId]],

    component : Manage_Monitor_Interface_impl_Impl ) extends Bridge.EntryPoints {

    val dataInPortIds: ISZ[Art.PortId] = ISZ(upper_alarm_tempWstatus_Id,
                                             lower_alarm_tempWstatus_Id,
                                             current_tempWstatus_Id,
                                             monitor_mode_Id)

    val eventInPortIds: ISZ[Art.PortId] = ISZ()

    val dataOutPortIds: ISZ[Art.PortId] = ISZ(upper_alarm_temp_Id,
                                              lower_alarm_temp_Id,
                                              monitor_status_Id,
                                              interface_failure_Id)

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