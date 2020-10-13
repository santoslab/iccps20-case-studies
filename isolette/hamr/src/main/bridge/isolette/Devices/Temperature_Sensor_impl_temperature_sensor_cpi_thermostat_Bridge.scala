// #Sireum

package isolette.Devices

import org.sireum._
import art._
import isolette._
import isolette.Devices.{Temperature_Sensor_impl_temperature_sensor_cpi_thermostat => component}

// This file was auto-generated.  Do not edit

@record class Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_Bridge(
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

  val initialization_api : Temperature_Sensor_impl_Initialization_Api = {
    val api = Temperature_Sensor_impl_Initialization_Api(
      id,
      air.id,
      current_tempWstatus.id
    )
    Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_Bridge.c_initialization_api = Some(api)
    api
  }

  val operational_api : Temperature_Sensor_impl_Operational_Api = {
    val api = Temperature_Sensor_impl_Operational_Api(
      id,
      air.id,
      current_tempWstatus.id
    )
    Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_Bridge.c_operational_api = Some(api)
    api
  }

  val entryPoints : Bridge.EntryPoints =
    Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_Bridge.EntryPoints(
      id,

      air.id,
      current_tempWstatus.id,

      dispatchTriggers,

      initialization_api,
      operational_api)
}

object Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_Bridge {

  var c_initialization_api: Option[Temperature_Sensor_impl_Initialization_Api] = None()
  var c_operational_api: Option[Temperature_Sensor_impl_Operational_Api] = None()

  @record class EntryPoints(
    Temperature_Sensor_impl_temperature_sensor_cpi_thermostat_BridgeId : Art.BridgeId,

    air_Id : Art.PortId,
    current_tempWstatus_Id : Art.PortId,

    dispatchTriggers : Option[ISZ[Art.PortId]],

    initialization_api: Temperature_Sensor_impl_Initialization_Api,
    operational_api: Temperature_Sensor_impl_Operational_Api) extends Bridge.EntryPoints {

    val dataInPortIds: ISZ[Art.PortId] = ISZ(air_Id)

    val eventInPortIds: ISZ[Art.PortId] = ISZ()

    val dataOutPortIds: ISZ[Art.PortId] = ISZ(current_tempWstatus_Id)

    val eventOutPortIds: ISZ[Art.PortId] = ISZ()

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