// #Sireum

package isolette.Monitor

import org.sireum._
import art._
import isolette._

// This file was auto-generated.  Do not edit

@record class Manage_Monitor_Mode_impl_Bridge(
  val id: Art.BridgeId,
  val name: String,
  val dispatchProtocol: DispatchPropertyProtocol,
  val dispatchTriggers: Option[ISZ[Art.PortId]],

  current_tempWstatus: Port[Isolette_Data_Model.TempWstatus_impl],
  interface_failure: Port[Isolette_Data_Model.Failure_Flag_impl],
  internal_failure: Port[Isolette_Data_Model.Failure_Flag_impl],
  monitor_mode: Port[Isolette_Data_Model.Monitor_Mode.Type]
  ) extends Bridge {

  val ports : Bridge.Ports = Bridge.Ports(
    all = ISZ(current_tempWstatus,
              interface_failure,
              internal_failure,
              monitor_mode),

    dataIns = ISZ(current_tempWstatus,
                  interface_failure,
                  internal_failure),

    dataOuts = ISZ(monitor_mode),

    eventIns = ISZ(),

    eventOuts = ISZ()
  )

  val api : Manage_Monitor_Mode_impl_Bridge.Api =
    Manage_Monitor_Mode_impl_Bridge.Api(
      id,
      current_tempWstatus.id,
      interface_failure.id,
      internal_failure.id,
      monitor_mode.id
    )

  val entryPoints : Bridge.EntryPoints =
    Manage_Monitor_Mode_impl_Bridge.EntryPoints(
      id,

      current_tempWstatus.id,
      interface_failure.id,
      internal_failure.id,
      monitor_mode.id,

      dispatchTriggers,

      Manage_Monitor_Mode_impl_Impl(api)
    )
}

object Manage_Monitor_Mode_impl_Bridge {

  @record class Api(
    id : Art.BridgeId,
    current_tempWstatus_Id : Art.PortId,
    interface_failure_Id : Art.PortId,
    internal_failure_Id : Art.PortId,
    monitor_mode_Id : Art.PortId) {


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

    def getinterface_failure() : Option[Isolette_Data_Model.Failure_Flag_impl] = {
      val value : Option[Isolette_Data_Model.Failure_Flag_impl] = Art.getValue(interface_failure_Id) match {
        case Some(Isolette_Data_Model.Failure_Flag_impl_Payload(v)) => Some(v)
        case Some(v) =>
          Art.logError(id, s"Unexpected payload on port interface_failure.  Expecting 'Isolette_Data_Model.Failure_Flag_impl_Payload' but received ${v}")
          None[Isolette_Data_Model.Failure_Flag_impl]()
        case _ => None[Isolette_Data_Model.Failure_Flag_impl]()
      }
      return value
    }

    def getinternal_failure() : Option[Isolette_Data_Model.Failure_Flag_impl] = {
      val value : Option[Isolette_Data_Model.Failure_Flag_impl] = Art.getValue(internal_failure_Id) match {
        case Some(Isolette_Data_Model.Failure_Flag_impl_Payload(v)) => Some(v)
        case Some(v) =>
          Art.logError(id, s"Unexpected payload on port internal_failure.  Expecting 'Isolette_Data_Model.Failure_Flag_impl_Payload' but received ${v}")
          None[Isolette_Data_Model.Failure_Flag_impl]()
        case _ => None[Isolette_Data_Model.Failure_Flag_impl]()
      }
      return value
    }

    def setmonitor_mode(value : Isolette_Data_Model.Monitor_Mode.Type) : Unit = {
      Art.putValue(monitor_mode_Id, Isolette_Data_Model.Monitor_Mode_Payload(value))
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
    Manage_Monitor_Mode_impl_BridgeId : Art.BridgeId,

    current_tempWstatus_Id : Art.PortId,
    interface_failure_Id : Art.PortId,
    internal_failure_Id : Art.PortId,
    monitor_mode_Id : Art.PortId,

    dispatchTriggers : Option[ISZ[Art.PortId]],

    component : Manage_Monitor_Mode_impl_Impl ) extends Bridge.EntryPoints {

    val dataInPortIds: ISZ[Art.PortId] = ISZ(current_tempWstatus_Id,
                                             interface_failure_Id,
                                             internal_failure_Id)

    val eventInPortIds: ISZ[Art.PortId] = ISZ()

    val dataOutPortIds: ISZ[Art.PortId] = ISZ(monitor_mode_Id)

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