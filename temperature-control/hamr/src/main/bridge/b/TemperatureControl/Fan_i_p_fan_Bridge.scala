// #Sireum

package b.TemperatureControl

import org.sireum._
import art._
import b._
import b.TemperatureControl.{Fan_i_p_fan => component}

// This file was auto-generated.  Do not edit

@record class Fan_i_p_fan_Bridge(
  val id: Art.BridgeId,
  val name: String,
  val dispatchProtocol: DispatchPropertyProtocol,
  val dispatchTriggers: Option[ISZ[Art.PortId]],

  fanCmd: Port[TemperatureControl.FanCmd.Type],
  fanAck: Port[TemperatureControl.FanAck.Type]
  ) extends Bridge {

  val ports : Bridge.Ports = Bridge.Ports(
    all = ISZ(fanCmd,
              fanAck),

    dataIns = ISZ(),

    dataOuts = ISZ(),

    eventIns = ISZ(fanCmd),

    eventOuts = ISZ(fanAck)
  )

  val initialization_api : Fan_i_Initialization_Api = {
    val api = Fan_i_Initialization_Api(
      id,
      fanCmd.id,
      fanAck.id
    )
    Fan_i_p_fan_Bridge.c_initialization_api = Some(api)
    api
  }

  val operational_api : Fan_i_Operational_Api = {
    val api = Fan_i_Operational_Api(
      id,
      fanCmd.id,
      fanAck.id
    )
    Fan_i_p_fan_Bridge.c_operational_api = Some(api)
    api
  }

  val entryPoints : Bridge.EntryPoints =
    Fan_i_p_fan_Bridge.EntryPoints(
      id,

      fanCmd.id,
      fanAck.id,

      dispatchTriggers,

      initialization_api,
      operational_api)
}

object Fan_i_p_fan_Bridge {

  var c_initialization_api: Option[Fan_i_Initialization_Api] = None()
  var c_operational_api: Option[Fan_i_Operational_Api] = None()

  @record class EntryPoints(
    Fan_i_p_fan_BridgeId : Art.BridgeId,

    fanCmd_Id : Art.PortId,
    fanAck_Id : Art.PortId,

    dispatchTriggers : Option[ISZ[Art.PortId]],

    initialization_api: Fan_i_Initialization_Api,
    operational_api: Fan_i_Operational_Api) extends Bridge.EntryPoints {

    val dataInPortIds: ISZ[Art.PortId] = ISZ()

    val eventInPortIds: ISZ[Art.PortId] = ISZ(fanCmd_Id)

    val dataOutPortIds: ISZ[Art.PortId] = ISZ()

    val eventOutPortIds: ISZ[Art.PortId] = ISZ(fanAck_Id)

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
      val EventTriggered(receivedEvents) = Art.dispatchStatus(Fan_i_p_fan_BridgeId)

      // remove non-dispatching event ports
      val dispatchableEventPorts: ISZ[Art.PortId] =
        if(dispatchTriggers.isEmpty) receivedEvents
        else filter(receivedEvents, dispatchTriggers.get)

      Art.receiveInput(eventInPortIds, dataInPortIds)

      for(portId <- dispatchableEventPorts) {
        if(portId == fanCmd_Id){
          val Some(TemperatureControl.FanCmd_Payload(value)) = Art.getValue(fanCmd_Id)
          component.handlefanCmd(operational_api, value)
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
      val EventTriggered(receivedEvents) = Art.dispatchStatus(Fan_i_p_fan_BridgeId)

      // remove non-dispatching event ports
      val dispatchableEventPorts: ISZ[Art.PortId] =
        if(dispatchTriggers.isEmpty) receivedEvents
        else filter(receivedEvents, dispatchTriggers.get)

      Art.receiveInput(eventInPortIds, dataInPortIds)

      for(portId <- dispatchableEventPorts) {
        if(portId == fanCmd_Id){
          val Some(TemperatureControl.FanCmd_Payload(value)) = Art.getValue(fanCmd_Id)
          component.handlefanCmd(operational_api, value)
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