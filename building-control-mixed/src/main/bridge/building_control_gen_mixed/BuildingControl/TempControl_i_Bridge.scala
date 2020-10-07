// #Sireum

package building_control_gen_mixed.BuildingControl

import org.sireum._
import art._
import building_control_gen_mixed._
import building_control_gen_mixed.BuildingControl.{BuildingControlDemo_i_Instance_tcp_tempControl => component}

// This file was auto-generated.  Do not edit

@record class TempControl_i_Bridge(
  val id: Art.BridgeId,
  val name: String,
  val dispatchProtocol: DispatchPropertyProtocol,
  val dispatchTriggers: Option[ISZ[Art.PortId]],

  currentTemp: Port[BuildingControl.Temperature_i],
  fanAck: Port[BuildingControl.FanAck.Type],
  setPoint: Port[BuildingControl.SetPoint_i],
  fanCmd: Port[BuildingControl.FanCmd.Type],
  tempChanged: Port[art.Empty]
  ) extends Bridge {

  val ports : Bridge.Ports = Bridge.Ports(
    all = ISZ(currentTemp,
              fanAck,
              setPoint,
              fanCmd,
              tempChanged),

    dataIns = ISZ(currentTemp),

    dataOuts = ISZ(),

    eventIns = ISZ(fanAck,
                   setPoint,
                   tempChanged),

    eventOuts = ISZ(fanCmd)
  )

  val api : TempControl_i_Bridge.Api =
    TempControl_i_Bridge.Api(
      id,
      currentTemp.id,
      fanAck.id,
      setPoint.id,
      fanCmd.id,
      tempChanged.id
    )

  val entryPoints : Bridge.EntryPoints =
    TempControl_i_Bridge.EntryPoints(
      id,

      currentTemp.id,
      fanAck.id,
      setPoint.id,
      fanCmd.id,
      tempChanged.id,

      dispatchTriggers)
}

object TempControl_i_Bridge {

  @record class Api(
    id : Art.BridgeId,
    currentTemp_Id : Art.PortId,
    fanAck_Id : Art.PortId,
    setPoint_Id : Art.PortId,
    fanCmd_Id : Art.PortId,
    tempChanged_Id : Art.PortId) {

    def getfanAck() : Option[BuildingControl.FanAck.Type] = {
      val value : Option[BuildingControl.FanAck.Type] = Art.getValue(fanAck_Id) match {
        case Some(BuildingControl.FanAck_Payload(v)) => Some(v)
        case Some(v) =>
          Art.logError(id, s"Unexpected payload on port fanAck.  Expecting 'BuildingControl.FanAck_Payload' but received ${v}")
          None[BuildingControl.FanAck.Type]()
        case _ => None[BuildingControl.FanAck.Type]()
      }
      return value
    }

    def getsetPoint() : Option[BuildingControl.SetPoint_i] = {
      val value : Option[BuildingControl.SetPoint_i] = Art.getValue(setPoint_Id) match {
        case Some(BuildingControl.SetPoint_i_Payload(v)) => Some(v)
        case Some(v) =>
          Art.logError(id, s"Unexpected payload on port setPoint.  Expecting 'BuildingControl.SetPoint_i_Payload' but received ${v}")
          None[BuildingControl.SetPoint_i]()
        case _ => None[BuildingControl.SetPoint_i]()
      }
      return value
    }

    def sendfanCmd(value : BuildingControl.FanCmd.Type) : Unit = {
      Art.putValue(fanCmd_Id, BuildingControl.FanCmd_Payload(value))
    }

    def gettempChanged() : Option[art.Empty] = {
      val value : Option[art.Empty] = Art.getValue(tempChanged_Id) match {
        case Some(Empty()) => Some(Empty())
        case Some(v) =>
          Art.logError(id, s"Unexpected payload on port tempChanged.  Expecting 'Empty' but received ${v}")
          None[art.Empty]()
        case _ => None[art.Empty]()
      }
      return value
    }

    def getcurrentTemp() : Option[BuildingControl.Temperature_i] = {
      val value : Option[BuildingControl.Temperature_i] = Art.getValue(currentTemp_Id) match {
        case Some(BuildingControl.Temperature_i_Payload(v)) => Some(v)
        case Some(v) =>
          Art.logError(id, s"Unexpected payload on port currentTemp.  Expecting 'BuildingControl.Temperature_i_Payload' but received ${v}")
          None[BuildingControl.Temperature_i]()
        case _ => None[BuildingControl.Temperature_i]()
      }
      return value
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
    TempControl_i_BridgeId : Art.BridgeId,

    currentTemp_Id : Art.PortId,
    fanAck_Id : Art.PortId,
    setPoint_Id : Art.PortId,
    fanCmd_Id : Art.PortId,
    tempChanged_Id : Art.PortId,

    dispatchTriggers : Option[ISZ[Art.PortId]]
    ) extends Bridge.EntryPoints {

    val dataInPortIds: ISZ[Art.PortId] = ISZ(currentTemp_Id)

    val eventInPortIds: ISZ[Art.PortId] = ISZ(fanAck_Id,
                                              setPoint_Id,
                                              tempChanged_Id)

    val dataOutPortIds: ISZ[Art.PortId] = ISZ()

    val eventOutPortIds: ISZ[Art.PortId] = ISZ(fanCmd_Id)

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
      val EventTriggered(receivedEvents) = Art.dispatchStatus(TempControl_i_BridgeId)

      // remove non-dispatching event ports
      val dispatchableEventPorts: ISZ[Art.PortId] =
        if(dispatchTriggers.isEmpty) receivedEvents
        else filter(receivedEvents, dispatchTriggers.get)

      Art.receiveInput(eventInPortIds, dataInPortIds)

      for(portId <- dispatchableEventPorts) {
        if(portId == fanAck_Id){
          val Some(BuildingControl.FanAck_Payload(value)) = Art.getValue(fanAck_Id)
          component.handlefanAck(value)
        }
        else if(portId == setPoint_Id){
          val Some(BuildingControl.SetPoint_i_Payload(value)) = Art.getValue(setPoint_Id)
          component.handlesetPoint(value)
        }
        else if(portId == tempChanged_Id) {
          component.handletempChanged()
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
      val EventTriggered(receivedEvents) = Art.dispatchStatus(TempControl_i_BridgeId)

      // remove non-dispatching event ports
      val dispatchableEventPorts: ISZ[Art.PortId] =
        if(dispatchTriggers.isEmpty) receivedEvents
        else filter(receivedEvents, dispatchTriggers.get)

      Art.receiveInput(eventInPortIds, dataInPortIds)

      for(portId <- dispatchableEventPorts) {
        if(portId == fanAck_Id){
          val Some(BuildingControl.FanAck_Payload(value)) = Art.getValue(fanAck_Id)
          component.handlefanAck(value)
        }
        else if(portId == setPoint_Id){
          val Some(BuildingControl.SetPoint_i_Payload(value)) = Art.getValue(setPoint_Id)
          component.handlesetPoint(value)
        }
        else if(portId == tempChanged_Id) {
          component.handletempChanged()
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

    def recover(): Uni = {
      component.recover()
    }
  }
}