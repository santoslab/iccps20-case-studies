// #Sireum

package pca_pump.PCA_Power

import org.sireum._
import art._
import pca_pump._
import pca_pump.PCA_Power.{power_supply_imp_pump_power_vcc => component}

// This file was auto-generated.  Do not edit

@record class power_supply_imp_pump_power_vcc_Bridge(
  val id: Art.BridgeId,
  val name: String,
  val dispatchProtocol: DispatchPropertyProtocol,
  val dispatchTriggers: Option[ISZ[Art.PortId]],

  Power_Voltage: Port[Physical_Types.Voltage_imp]
  ) extends Bridge {

  val ports : Bridge.Ports = Bridge.Ports(
    all = ISZ(Power_Voltage),

    dataIns = ISZ(),

    dataOuts = ISZ(Power_Voltage),

    eventIns = ISZ(),

    eventOuts = ISZ()
  )

  val initialization_api : power_supply_imp_Initialization_Api = {
    val api = power_supply_imp_Initialization_Api(
      id,
      Power_Voltage.id
    )
    power_supply_imp_pump_power_vcc_Bridge.c_initialization_api = Some(api)
    api
  }

  val operational_api : power_supply_imp_Operational_Api = {
    val api = power_supply_imp_Operational_Api(
      id,
      Power_Voltage.id
    )
    power_supply_imp_pump_power_vcc_Bridge.c_operational_api = Some(api)
    api
  }

  val entryPoints : Bridge.EntryPoints =
    power_supply_imp_pump_power_vcc_Bridge.EntryPoints(
      id,

      Power_Voltage.id,

      dispatchTriggers,

      initialization_api,
      operational_api)
}

object power_supply_imp_pump_power_vcc_Bridge {

  var c_initialization_api: Option[power_supply_imp_Initialization_Api] = None()
  var c_operational_api: Option[power_supply_imp_Operational_Api] = None()

  @record class EntryPoints(
    power_supply_imp_pump_power_vcc_BridgeId : Art.BridgeId,

    Power_Voltage_Id : Art.PortId,

    dispatchTriggers : Option[ISZ[Art.PortId]],

    initialization_api: power_supply_imp_Initialization_Api,
    operational_api: power_supply_imp_Operational_Api) extends Bridge.EntryPoints {

    val dataInPortIds: ISZ[Art.PortId] = ISZ()

    val eventInPortIds: ISZ[Art.PortId] = ISZ()

    val dataOutPortIds: ISZ[Art.PortId] = ISZ(Power_Voltage_Id)

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