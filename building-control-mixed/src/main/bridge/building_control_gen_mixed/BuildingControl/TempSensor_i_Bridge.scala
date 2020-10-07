// #Sireum

package building_control_gen_mixed.BuildingControl

import org.sireum._
import art._
import building_control_gen_mixed._
import building_control_gen_mixed.BuildingControl.{BuildingControlDemo_i_Instance_tcp_tempSensor => component}

// This file was auto-generated.  Do not edit

@record class TempSensor_i_Bridge(
  val id: Art.BridgeId,
  val name: String,
  val dispatchProtocol: DispatchPropertyProtocol,
  val dispatchTriggers: Option[ISZ[Art.PortId]],

  currentTemp: Port[BuildingControl.Temperature_i],
  tempChanged: Port[art.Empty]
  ) extends Bridge {

  val ports : Bridge.Ports = Bridge.Ports(
    all = ISZ(currentTemp,
              tempChanged),

    dataIns = ISZ(),

    dataOuts = ISZ(currentTemp),

    eventIns = ISZ(),

    eventOuts = ISZ(tempChanged)
  )

  val api : TempSensor_i_Bridge.Api =
    TempSensor_i_Bridge.Api(
      id,
      currentTemp.id,
      tempChanged.id
    )

  val entryPoints : Bridge.EntryPoints =
    TempSensor_i_Bridge.EntryPoints(
      id,

      currentTemp.id,
      tempChanged.id,

      dispatchTriggers)
}

object TempSensor_i_Bridge {

  @record class Api(
    id : Art.BridgeId,
    currentTemp_Id : Art.PortId,
    tempChanged_Id : Art.PortId) {

    def sendtempChanged() : Unit = {
      Art.putValue(tempChanged_Id, art.Empty())
    }

    def setcurrentTemp(value : BuildingControl.Temperature_i) : Unit = {
      Art.putValue(currentTemp_Id, BuildingControl.Temperature_i_Payload(value))
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
    TempSensor_i_BridgeId : Art.BridgeId,

    currentTemp_Id : Art.PortId,
    tempChanged_Id : Art.PortId,

    dispatchTriggers : Option[ISZ[Art.PortId]]
    ) extends Bridge.EntryPoints {

    val dataInPortIds: ISZ[Art.PortId] = ISZ()

    val eventInPortIds: ISZ[Art.PortId] = ISZ()

    val dataOutPortIds: ISZ[Art.PortId] = ISZ(currentTemp_Id)

    val eventOutPortIds: ISZ[Art.PortId] = ISZ(tempChanged_Id)

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