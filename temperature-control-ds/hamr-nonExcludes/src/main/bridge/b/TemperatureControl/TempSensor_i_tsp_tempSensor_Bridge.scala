// #Sireum

package b.TemperatureControl

import org.sireum._
import art._
import b._
import b.TemperatureControl.{TempSensor_i_tsp_tempSensor => component}

// This file was auto-generated.  Do not edit

@record class TempSensor_i_tsp_tempSensor_Bridge(
  val id: Art.BridgeId,
  val name: String,
  val dispatchProtocol: DispatchPropertyProtocol,
  val dispatchTriggers: Option[ISZ[Art.PortId]],

  currentTemp: Port[TemperatureControl.Temperature_i],
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

  val initialization_api : TempSensor_i_Initialization_Api = {
    val api = TempSensor_i_Initialization_Api(
      id,
      currentTemp.id,
      tempChanged.id
    )
    TempSensor_i_tsp_tempSensor_Bridge.c_initialization_api = Some(api)
    api
  }

  val operational_api : TempSensor_i_Operational_Api = {
    val api = TempSensor_i_Operational_Api(
      id,
      currentTemp.id,
      tempChanged.id
    )
    TempSensor_i_tsp_tempSensor_Bridge.c_operational_api = Some(api)
    api
  }

  val entryPoints : Bridge.EntryPoints =
    TempSensor_i_tsp_tempSensor_Bridge.EntryPoints(
      id,

      currentTemp.id,
      tempChanged.id,

      dispatchTriggers,

      initialization_api,
      operational_api)
}

object TempSensor_i_tsp_tempSensor_Bridge {

  var c_initialization_api: Option[TempSensor_i_Initialization_Api] = None()
  var c_operational_api: Option[TempSensor_i_Operational_Api] = None()

  @record class EntryPoints(
    TempSensor_i_tsp_tempSensor_BridgeId : Art.BridgeId,

    currentTemp_Id : Art.PortId,
    tempChanged_Id : Art.PortId,

    dispatchTriggers : Option[ISZ[Art.PortId]],

    initialization_api: TempSensor_i_Initialization_Api,
    operational_api: TempSensor_i_Operational_Api) extends Bridge.EntryPoints {

    val dataInPortIds: ISZ[Art.PortId] = ISZ()

    val eventInPortIds: ISZ[Art.PortId] = ISZ()

    val dataOutPortIds: ISZ[Art.PortId] = ISZ(currentTemp_Id)

    val eventOutPortIds: ISZ[Art.PortId] = ISZ(tempChanged_Id)

    def compute(): Unit = {
      Art.receiveInput(eventInPortIds, dataInPortIds)
      component.timeTriggered(operational_api)
      Art.sendOutput(eventOutPortIds, dataOutPortIds)
    }

    override
    def testCompute(): Unit = {
      Art.receiveInput(eventInPortIds, dataInPortIds)
      component.timeTriggered(operational_api)
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