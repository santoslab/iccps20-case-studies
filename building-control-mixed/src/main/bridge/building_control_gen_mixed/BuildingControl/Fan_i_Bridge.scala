// #Sireum

package building_control_gen_mixed.BuildingControl

import org.sireum._
import art._
import building_control_gen_mixed.BuildingControl.Fan_i_Bridge.Fan_Singleton_Router
import building_control_gen_mixed._
import building_control_gen_mixed.BuildingControl.{BuildingControlDemo_i_Instance_tcp_fan => component}

// This file was auto-generated.  Do not edit

@record class Fan_i_Bridge(
  val id: Art.BridgeId,
  val name: String,
  val dispatchProtocol: DispatchPropertyProtocol,
  val dispatchTriggers: Option[ISZ[Art.PortId]],

  fanCmd: Port[BuildingControl.FanCmd.Type],
  fanAck: Port[BuildingControl.FanAck.Type]
  ) extends Bridge {

  val ports : Bridge.Ports = Bridge.Ports(
    all = ISZ(fanCmd,
              fanAck),

    dataIns = ISZ(),

    dataOuts = ISZ(),

    eventIns = ISZ(fanCmd),

    eventOuts = ISZ(fanAck)
  )

  val api : Fan_i_Bridge.Api =
    Fan_i_Bridge.Api(
      id,
      fanCmd.id,
      fanAck.id
    )

  val entryPoints : Bridge.EntryPoints =
    Fan_i_Bridge.EntryPoints(
      id,

      fanCmd.id,
      fanAck.id,

      dispatchTriggers)
}

object Fan_i_Bridge {

  @record class Api(
    id : Art.BridgeId,
    fanCmd_Id : Art.PortId,
    fanAck_Id : Art.PortId) {

    def getfanCmd() : Option[BuildingControl.FanCmd.Type] = {
      val value : Option[BuildingControl.FanCmd.Type] = Art.getValue(fanCmd_Id) match {
        case Some(BuildingControl.FanCmd_Payload(v)) => Some(v)
        case Some(v) =>
          Art.logError(id, s"Unexpected payload on port fanCmd.  Expecting 'BuildingControl.FanCmd_Payload' but received ${v}")
          None[BuildingControl.FanCmd.Type]()
        case _ => None[BuildingControl.FanCmd.Type]()
      }
      return value
    }

    def sendfanAck(value : BuildingControl.FanAck.Type) : Unit = {
      Art.putValue(fanAck_Id, BuildingControl.FanAck_Payload(value))
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

  object Fan_Singleton_Router {
    def handlefanCmd(id: Art.BridgeId,
                    value: FanCmd.Type): Unit = {
      val c = BuildingControl.BuildingControlDemo_i_Instance_tcp_fan

      if(id == Arch.BuildingControlDemo_i_Instance_tcp_fan.id) {
        BuildingControl.BuildingControlDemo_i_Instance_tcp_fan.handlefanCmd(value)
      }
      else {
        halt(s"Unexpected bridge id: ${id}")
      }
    }
  }

  @record class EntryPoints(
    Fan_i_BridgeId : Art.BridgeId,

    fanCmd_Id : Art.PortId,
    fanAck_Id : Art.PortId,

    dispatchTriggers : Option[ISZ[Art.PortId]]
    ) extends Bridge.EntryPoints {

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
      val EventTriggered(receivedEvents) = Art.dispatchStatus(Fan_i_BridgeId)

      // remove non-dispatching event ports
      val dispatchableEventPorts: ISZ[Art.PortId] =
        if(dispatchTriggers.isEmpty) receivedEvents
        else filter(receivedEvents, dispatchTriggers.get)

      Art.receiveInput(eventInPortIds, dataInPortIds)

      for(portId <- dispatchableEventPorts) {
        if(portId == fanCmd_Id){
          val Some(BuildingControl.FanCmd_Payload(value)) = Art.getValue(fanCmd_Id)
          Fan_Singleton_Router.handlefanCmd(Fan_i_BridgeId, value)
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
      val EventTriggered(receivedEvents) = Art.dispatchStatus(Fan_i_BridgeId)

      // remove non-dispatching event ports
      val dispatchableEventPorts: ISZ[Art.PortId] =
        if(dispatchTriggers.isEmpty) receivedEvents
        else filter(receivedEvents, dispatchTriggers.get)

      Art.receiveInput(eventInPortIds, dataInPortIds)

      for(portId <- dispatchableEventPorts) {
        if(portId == fanCmd_Id){
          val Some(BuildingControl.FanCmd_Payload(value)) = Art.getValue(fanCmd_Id)
          component.handlefanCmd(value)
        }
      }

      Art.releaseOutput(eventOutPortIds, dataOutPortIds)
    }

    def activate(): Unit = {
      component.activate()
    }

    def deactivate(): Unit = {
      component.deactivate()
    }

    def finalise(): Unit = {
      component.finalise()
    }

    def initialise(): Unit = {
      component.initialise()
      Art.sendOutput(eventOutPortIds, dataOutPortIds)
    }

    def recover(): Unit = {
      component.recover()
    }
  }
}