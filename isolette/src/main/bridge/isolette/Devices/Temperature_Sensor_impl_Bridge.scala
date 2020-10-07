// #Sireum

package isolette.Devices

import org.sireum._
import art._
import isolette._

// This file was auto-generated.  Do not edit

@record class Temperature_Sensor_impl_Bridge(
  val id: Art.BridgeId,
  val name: String,
  val dispatchProtocol: DispatchPropertyProtocol,
  val dispatchTriggers: Option[ISZ[Art.PortId]],

  air: Port[Isolette_Data_Model.PhysicalTemp_impl],
  current_tempWstatus: Port[Isolette_Data_Model.TempWstatus_impl]
  ) extends Bridge {

  val ports : Bridge.Ports = Bridge.Ports(
    all = ISZ(air,
              current_tempWstatus),

    dataIns = ISZ(air),

    dataOuts = ISZ(current_tempWstatus),

    eventIns = ISZ(),

    eventOuts = ISZ()
  )

  val api : Temperature_Sensor_impl_Bridge.Api =
    Temperature_Sensor_impl_Bridge.Api(
      id,
      air.id,
      current_tempWstatus.id
    )

  val entryPoints : Bridge.EntryPoints =
    Temperature_Sensor_impl_Bridge.EntryPoints(
      id,

      air.id,
      current_tempWstatus.id,

      dispatchTriggers,

      Temperature_Sensor_impl_Impl(api)
    )
}

object Temperature_Sensor_impl_Bridge {

  @record class Api(
    id : Art.BridgeId,
    air_Id : Art.PortId,
    current_tempWstatus_Id : Art.PortId) {


    def getair() : Option[Isolette_Data_Model.PhysicalTemp_impl] = {
      val value : Option[Isolette_Data_Model.PhysicalTemp_impl] = Art.getValue(air_Id) match {
        case Some(Isolette_Data_Model.PhysicalTemp_impl_Payload(v)) => Some(v)
        case Some(v) =>
          Art.logError(id, s"Unexpected payload on port air.  Expecting 'Isolette_Data_Model.PhysicalTemp_impl_Payload' but received ${v}")
          None[Isolette_Data_Model.PhysicalTemp_impl]()
        case _ => None[Isolette_Data_Model.PhysicalTemp_impl]()
      }
      return value
    }

    def setcurrent_tempWstatus(value : Isolette_Data_Model.TempWstatus_impl) : Unit = {
      Art.putValue(current_tempWstatus_Id, Isolette_Data_Model.TempWstatus_impl_Payload(value))
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
    Temperature_Sensor_impl_BridgeId : Art.BridgeId,

    air_Id : Art.PortId,
    current_tempWstatus_Id : Art.PortId,

    dispatchTriggers : Option[ISZ[Art.PortId]],

    component : Temperature_Sensor_impl_Impl ) extends Bridge.EntryPoints {

    val dataInPortIds: ISZ[Art.PortId] = ISZ(air_Id)

    val eventInPortIds: ISZ[Art.PortId] = ISZ()

    val dataOutPortIds: ISZ[Art.PortId] = ISZ(current_tempWstatus_Id)

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