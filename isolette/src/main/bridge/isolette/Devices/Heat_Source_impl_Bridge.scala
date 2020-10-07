// #Sireum

package isolette.Devices

import org.sireum._
import art._
import isolette._

// This file was auto-generated.  Do not edit

@record class Heat_Source_impl_Bridge(
  val id: Art.BridgeId,
  val name: String,
  val dispatchProtocol: DispatchPropertyProtocol,
  val dispatchTriggers: Option[ISZ[Art.PortId]],

  heat_control: Port[Isolette_Data_Model.On_Off.Type],
  heat_out: Port[Isolette_Environment.Heat.Type]
  ) extends Bridge {

  val ports : Bridge.Ports = Bridge.Ports(
    all = ISZ(heat_control,
              heat_out),

    dataIns = ISZ(heat_control),

    dataOuts = ISZ(heat_out),

    eventIns = ISZ(),

    eventOuts = ISZ()
  )

  val api : Heat_Source_impl_Bridge.Api =
    Heat_Source_impl_Bridge.Api(
      id,
      heat_control.id,
      heat_out.id
    )

  val entryPoints : Bridge.EntryPoints =
    Heat_Source_impl_Bridge.EntryPoints(
      id,

      heat_control.id,
      heat_out.id,

      dispatchTriggers,

      Heat_Source_impl_Impl(api)
    )
}

object Heat_Source_impl_Bridge {

  @record class Api(
    id : Art.BridgeId,
    heat_control_Id : Art.PortId,
    heat_out_Id : Art.PortId) {


    def getheat_control() : Option[Isolette_Data_Model.On_Off.Type] = {
      val value : Option[Isolette_Data_Model.On_Off.Type] = Art.getValue(heat_control_Id) match {
        case Some(Isolette_Data_Model.On_Off_Payload(v)) => Some(v)
        case Some(v) =>
          Art.logError(id, s"Unexpected payload on port heat_control.  Expecting 'Isolette_Data_Model.On_Off_Payload' but received ${v}")
          None[Isolette_Data_Model.On_Off.Type]()
        case _ => None[Isolette_Data_Model.On_Off.Type]()
      }
      return value
    }

    def setheat_out(value : Isolette_Environment.Heat.Type) : Unit = {
      Art.putValue(heat_out_Id, Isolette_Environment.Heat_Payload(value))
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
    Heat_Source_impl_BridgeId : Art.BridgeId,

    heat_control_Id : Art.PortId,
    heat_out_Id : Art.PortId,

    dispatchTriggers : Option[ISZ[Art.PortId]],

    component : Heat_Source_impl_Impl ) extends Bridge.EntryPoints {

    val dataInPortIds: ISZ[Art.PortId] = ISZ(heat_control_Id)

    val eventInPortIds: ISZ[Art.PortId] = ISZ()

    val dataOutPortIds: ISZ[Art.PortId] = ISZ(heat_out_Id)

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