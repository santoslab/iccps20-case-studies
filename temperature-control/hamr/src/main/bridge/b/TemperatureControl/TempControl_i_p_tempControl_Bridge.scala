// #Sireum

package b.TemperatureControl

import org.sireum._
import art._
import b._
import b.TemperatureControl.{TempControl_i_p_tempControl => component}

// This file was auto-generated.  Do not edit

@record class TempControl_i_p_tempControl_Bridge(
  val id: Art.BridgeId,
  val name: String,
  val dispatchProtocol: DispatchPropertyProtocol,
  val dispatchTriggers: Option[ISZ[Art.PortId]],

  currentTemp: Port[TemperatureControl.Temperature_i],
  fanAck: Port[TemperatureControl.FanAck.Type],
  setPoint: Port[TemperatureControl.SetPoint_i],
  fanCmd: Port[TemperatureControl.FanCmd.Type],
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

  val initialization_api : TempControl_i_Initialization_Api = {
    val api = TempControl_i_Initialization_Api(
      id,
      currentTemp.id,
      fanAck.id,
      setPoint.id,
      fanCmd.id,
      tempChanged.id
    )
    TempControl_i_p_tempControl_Bridge.c_initialization_api = Some(api)
    api
  }

  val operational_api : TempControl_i_Operational_Api = {
    val api = TempControl_i_Operational_Api(
      id,
      currentTemp.id,
      fanAck.id,
      setPoint.id,
      fanCmd.id,
      tempChanged.id
    )
    TempControl_i_p_tempControl_Bridge.c_operational_api = Some(api)
    api
  }

  val entryPoints : Bridge.EntryPoints =
    TempControl_i_p_tempControl_Bridge.EntryPoints(
      id,

      currentTemp.id,
      fanAck.id,
      setPoint.id,
      fanCmd.id,
      tempChanged.id,

      dispatchTriggers,

      initialization_api,
      operational_api)
}

object TempControl_i_p_tempControl_Bridge {

  var c_initialization_api: Option[TempControl_i_Initialization_Api] = None()
  var c_operational_api: Option[TempControl_i_Operational_Api] = None()

  @record class EntryPoints(
    TempControl_i_p_tempControl_BridgeId : Art.BridgeId,

    currentTemp_Id : Art.PortId,
    fanAck_Id : Art.PortId,
    setPoint_Id : Art.PortId,
    fanCmd_Id : Art.PortId,
    tempChanged_Id : Art.PortId,

    dispatchTriggers : Option[ISZ[Art.PortId]],

    initialization_api: TempControl_i_Initialization_Api,
    operational_api: TempControl_i_Operational_Api) extends Bridge.EntryPoints {

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
      val EventTriggered(receivedEvents) = Art.dispatchStatus(TempControl_i_p_tempControl_BridgeId)

      // remove non-dispatching event ports
      val dispatchableEventPorts: ISZ[Art.PortId] =
        if(dispatchTriggers.isEmpty) receivedEvents
        else filter(receivedEvents, dispatchTriggers.get)

      Art.receiveInput(eventInPortIds, dataInPortIds)

      for(portId <- dispatchableEventPorts) {
        if(portId == fanAck_Id){
          val Some(TemperatureControl.FanAck_Payload(value)) = Art.getValue(fanAck_Id)
          component.handlefanAck(operational_api, value)
        }
        else if(portId == setPoint_Id){
          val Some(TemperatureControl.SetPoint_i_Payload(value)) = Art.getValue(setPoint_Id)
          component.handlesetPoint(operational_api, value)
        }
        else if(portId == tempChanged_Id) {
          component.handletempChanged(operational_api)
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
      val EventTriggered(receivedEvents) = Art.dispatchStatus(TempControl_i_p_tempControl_BridgeId)

      // remove non-dispatching event ports
      val dispatchableEventPorts: ISZ[Art.PortId] =
        if(dispatchTriggers.isEmpty) receivedEvents
        else filter(receivedEvents, dispatchTriggers.get)

      Art.receiveInput(eventInPortIds, dataInPortIds)

      for(portId <- dispatchableEventPorts) {
        if(portId == fanAck_Id){
          val Some(TemperatureControl.FanAck_Payload(value)) = Art.getValue(fanAck_Id)
          component.handlefanAck(operational_api, value)
        }
        else if(portId == setPoint_Id){
          val Some(TemperatureControl.SetPoint_i_Payload(value)) = Art.getValue(setPoint_Id)
          component.handlesetPoint(operational_api, value)
        }
        else if(portId == tempChanged_Id) {
          component.handletempChanged(operational_api)
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