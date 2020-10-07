// #Sireum

package pca_pump.PCA_Power

import org.sireum._
import art._
import pca_pump._
import pca_pump.PCA_Power.{power_control_imp_pump_power_pwr => component}

// This file was auto-generated.  Do not edit

@record class power_control_imp_pump_power_pwr_Bridge(
  val id: Art.BridgeId,
  val name: String,
  val dispatchProtocol: DispatchPropertyProtocol,
  val dispatchTriggers: Option[ISZ[Art.PortId]],

  Battery_Voltage: Port[Physical_Types.Voltage_imp],
  Battery_Current: Port[Physical_Types.Current_imp],
  Power_Voltage: Port[Physical_Types.Voltage_imp],
  Using_Battery_Power: Port[Base_Types.Boolean],
  Remaining_Battery_Time: Port[BLESS_Types.Time],
  Low_Battery_Warning: Port[art.Empty],
  Defective_Battery: Port[art.Empty],
  Voltage_OOR: Port[art.Empty]
  ) extends Bridge {

  val ports : Bridge.Ports = Bridge.Ports(
    all = ISZ(Battery_Voltage,
              Battery_Current,
              Power_Voltage,
              Using_Battery_Power,
              Remaining_Battery_Time,
              Low_Battery_Warning,
              Defective_Battery,
              Voltage_OOR),

    dataIns = ISZ(Battery_Voltage,
                  Battery_Current,
                  Power_Voltage),

    dataOuts = ISZ(Using_Battery_Power,
                   Remaining_Battery_Time),

    eventIns = ISZ(),

    eventOuts = ISZ(Low_Battery_Warning,
                    Defective_Battery,
                    Voltage_OOR)
  )

  val initialization_api : power_control_imp_Initialization_Api = {
    val api = power_control_imp_Initialization_Api(
      id,
      Battery_Voltage.id,
      Battery_Current.id,
      Power_Voltage.id,
      Using_Battery_Power.id,
      Remaining_Battery_Time.id,
      Low_Battery_Warning.id,
      Defective_Battery.id,
      Voltage_OOR.id
    )
    power_control_imp_pump_power_pwr_Bridge.c_initialization_api = Some(api)
    api
  }

  val operational_api : power_control_imp_Operational_Api = {
    val api = power_control_imp_Operational_Api(
      id,
      Battery_Voltage.id,
      Battery_Current.id,
      Power_Voltage.id,
      Using_Battery_Power.id,
      Remaining_Battery_Time.id,
      Low_Battery_Warning.id,
      Defective_Battery.id,
      Voltage_OOR.id
    )
    power_control_imp_pump_power_pwr_Bridge.c_operational_api = Some(api)
    api
  }

  val entryPoints : Bridge.EntryPoints =
    power_control_imp_pump_power_pwr_Bridge.EntryPoints(
      id,

      Battery_Voltage.id,
      Battery_Current.id,
      Power_Voltage.id,
      Using_Battery_Power.id,
      Remaining_Battery_Time.id,
      Low_Battery_Warning.id,
      Defective_Battery.id,
      Voltage_OOR.id,

      dispatchTriggers,

      initialization_api,
      operational_api)
}

object power_control_imp_pump_power_pwr_Bridge {

  var c_initialization_api: Option[power_control_imp_Initialization_Api] = None()
  var c_operational_api: Option[power_control_imp_Operational_Api] = None()

  @record class EntryPoints(
    power_control_imp_pump_power_pwr_BridgeId : Art.BridgeId,

    Battery_Voltage_Id : Art.PortId,
    Battery_Current_Id : Art.PortId,
    Power_Voltage_Id : Art.PortId,
    Using_Battery_Power_Id : Art.PortId,
    Remaining_Battery_Time_Id : Art.PortId,
    Low_Battery_Warning_Id : Art.PortId,
    Defective_Battery_Id : Art.PortId,
    Voltage_OOR_Id : Art.PortId,

    dispatchTriggers : Option[ISZ[Art.PortId]],

    initialization_api: power_control_imp_Initialization_Api,
    operational_api: power_control_imp_Operational_Api) extends Bridge.EntryPoints {

    val dataInPortIds: ISZ[Art.PortId] = ISZ(Battery_Voltage_Id,
                                             Battery_Current_Id,
                                             Power_Voltage_Id)

    val eventInPortIds: ISZ[Art.PortId] = ISZ()

    val dataOutPortIds: ISZ[Art.PortId] = ISZ(Using_Battery_Power_Id,
                                              Remaining_Battery_Time_Id)

    val eventOutPortIds: ISZ[Art.PortId] = ISZ(Low_Battery_Warning_Id,
                                               Defective_Battery_Id,
                                               Voltage_OOR_Id)

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