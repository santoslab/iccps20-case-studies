// #Sireum

package pca_pump.PCA_Power

import org.sireum._
import art._
import pca_pump._
import pca_pump.PCA_Power.{battery_imp_pump_power_btty => component}

// This file was auto-generated.  Do not edit

@record class battery_imp_pump_power_btty_Bridge(
  val id: Art.BridgeId,
  val name: String,
  val dispatchProtocol: DispatchPropertyProtocol,
  val dispatchTriggers: Option[ISZ[Art.PortId]],

  Battery_Voltage: Port[Physical_Types.Voltage_imp],
  Battery_Current: Port[Physical_Types.Current_imp]
  ) extends Bridge {

  val ports : Bridge.Ports = Bridge.Ports(
    all = ISZ(Battery_Voltage,
              Battery_Current),

    dataIns = ISZ(),

    dataOuts = ISZ(Battery_Voltage,
                   Battery_Current),

    eventIns = ISZ(),

    eventOuts = ISZ()
  )

  val initialization_api : battery_imp_Initialization_Api = {
    val api = battery_imp_Initialization_Api(
      id,
      Battery_Voltage.id,
      Battery_Current.id
    )
    battery_imp_pump_power_btty_Bridge.c_initialization_api = Some(api)
    api
  }

  val operational_api : battery_imp_Operational_Api = {
    val api = battery_imp_Operational_Api(
      id,
      Battery_Voltage.id,
      Battery_Current.id
    )
    battery_imp_pump_power_btty_Bridge.c_operational_api = Some(api)
    api
  }

  val entryPoints : Bridge.EntryPoints =
    battery_imp_pump_power_btty_Bridge.EntryPoints(
      id,

      Battery_Voltage.id,
      Battery_Current.id,

      dispatchTriggers,

      initialization_api,
      operational_api)
}

object battery_imp_pump_power_btty_Bridge {

  var c_initialization_api: Option[battery_imp_Initialization_Api] = None()
  var c_operational_api: Option[battery_imp_Operational_Api] = None()

  @record class EntryPoints(
    battery_imp_pump_power_btty_BridgeId : Art.BridgeId,

    Battery_Voltage_Id : Art.PortId,
    Battery_Current_Id : Art.PortId,

    dispatchTriggers : Option[ISZ[Art.PortId]],

    initialization_api: battery_imp_Initialization_Api,
    operational_api: battery_imp_Operational_Api) extends Bridge.EntryPoints {

    val dataInPortIds: ISZ[Art.PortId] = ISZ()

    val eventInPortIds: ISZ[Art.PortId] = ISZ()

    val dataOutPortIds: ISZ[Art.PortId] = ISZ(Battery_Voltage_Id,
                                              Battery_Current_Id)

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