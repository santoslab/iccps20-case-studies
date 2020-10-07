// #Sireum

package pca_pump.PCA_Safety

import org.sireum._
import art._
import pca_pump._
import pca_pump.PCA_Safety.{failure_led_imp_pump_safety_led => component}

// This file was auto-generated.  Do not edit

@record class failure_led_imp_pump_safety_led_Bridge(
  val id: Art.BridgeId,
  val name: String,
  val dispatchProtocol: DispatchPropertyProtocol,
  val dispatchTriggers: Option[ISZ[Art.PortId]],

  Light: Port[Base_Types.Boolean],
  Illuminate: Port[art.Empty]
  ) extends Bridge {

  val ports : Bridge.Ports = Bridge.Ports(
    all = ISZ(Light,
              Illuminate),

    dataIns = ISZ(),

    dataOuts = ISZ(Light),

    eventIns = ISZ(Illuminate),

    eventOuts = ISZ()
  )

  val initialization_api : failure_led_imp_Initialization_Api = {
    val api = failure_led_imp_Initialization_Api(
      id,
      Light.id,
      Illuminate.id
    )
    failure_led_imp_pump_safety_led_Bridge.c_initialization_api = Some(api)
    api
  }

  val operational_api : failure_led_imp_Operational_Api = {
    val api = failure_led_imp_Operational_Api(
      id,
      Light.id,
      Illuminate.id
    )
    failure_led_imp_pump_safety_led_Bridge.c_operational_api = Some(api)
    api
  }

  val entryPoints : Bridge.EntryPoints =
    failure_led_imp_pump_safety_led_Bridge.EntryPoints(
      id,

      Light.id,
      Illuminate.id,

      dispatchTriggers,

      initialization_api,
      operational_api)
}

object failure_led_imp_pump_safety_led_Bridge {

  var c_initialization_api: Option[failure_led_imp_Initialization_Api] = None()
  var c_operational_api: Option[failure_led_imp_Operational_Api] = None()

  @record class EntryPoints(
    failure_led_imp_pump_safety_led_BridgeId : Art.BridgeId,

    Light_Id : Art.PortId,
    Illuminate_Id : Art.PortId,

    dispatchTriggers : Option[ISZ[Art.PortId]],

    initialization_api: failure_led_imp_Initialization_Api,
    operational_api: failure_led_imp_Operational_Api) extends Bridge.EntryPoints {

    val dataInPortIds: ISZ[Art.PortId] = ISZ()

    val eventInPortIds: ISZ[Art.PortId] = ISZ(Illuminate_Id)

    val dataOutPortIds: ISZ[Art.PortId] = ISZ(Light_Id)

    val eventOutPortIds: ISZ[Art.PortId] = ISZ()

    def compute(): Unit = {
      // transpiler friendly filter
      def filter(receivedEvents: ISZ[Art.PortId], triggers: ISZ[Art.PortId]): ISZ[Art.PortId] = {
        var r = ISZ[Art.PortId]()
        val opsTriggers = ops.ISZOps(triggers)
        for(e <- receivedEvents) {
          if(opsTriggers.contains(e)) {
            r = r :+ e
          }
        }
        return r
      }

      // fetch received events ordered by highest urgency then earliest arrival-time
      val EventTriggered(receivedEvents) = Art.dispatchStatus(failure_led_imp_pump_safety_led_BridgeId)

      // remove non-dispatching event ports
      val dispatchableEventPorts: ISZ[Art.PortId] =
        if(dispatchTriggers.isEmpty) receivedEvents
        else filter(receivedEvents, dispatchTriggers.get)

      Art.receiveInput(eventInPortIds, dataInPortIds)

      for(portId <- dispatchableEventPorts) {
        if(portId == Illuminate_Id) {
          component.handleIlluminate(operational_api)
        }
      }

      Art.sendOutput(eventOutPortIds, dataOutPortIds)
    }

    override
    def testCompute(): Unit = {
      // transpiler friendly filter
      def filter(receivedEvents: ISZ[Art.PortId], triggers: ISZ[Art.PortId]): ISZ[Art.PortId] = {
        var r = ISZ[Art.PortId]()
        val opsTriggers = ops.ISZOps(triggers)
        for(e <- receivedEvents) {
          if(opsTriggers.contains(e)) {
            r = r :+ e
          }
        }
        return r
      }

      // fetch received events ordered by highest urgency then earliest arrival-time
      val EventTriggered(receivedEvents) = Art.dispatchStatus(failure_led_imp_pump_safety_led_BridgeId)

      // remove non-dispatching event ports
      val dispatchableEventPorts: ISZ[Art.PortId] =
        if(dispatchTriggers.isEmpty) receivedEvents
        else filter(receivedEvents, dispatchTriggers.get)

      Art.receiveInput(eventInPortIds, dataInPortIds)

      for(portId <- dispatchableEventPorts) {
        if(portId == Illuminate_Id) {
          component.handleIlluminate(operational_api)
        }
      }

      Art.releaseOutput(eventOutPortIds, dataOutPortIds)
    }

    def activate(): Unit = {
      component.activate(operational_api)
    }

    def deactivate(): Unit = {
      component.deactivate(operational_api)
    }

    def finalise(): Unit = {
      component.finalise(operational_api)
    }

    def initialise(): Unit = {
      component.initialise(initialization_api)
      Art.sendOutput(eventOutPortIds, dataOutPortIds)
    }

    def recover(): Unit = {
      component.recover(operational_api)
    }
  }
}