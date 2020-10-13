// #Sireum

package isolette.Regulate

import org.sireum._
import art._
import isolette._
import isolette.Regulate.{Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode_mrmt => component}

// This file was auto-generated.  Do not edit

@record class Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode_mrmt_Bridge(
  val id: Art.BridgeId,
  val name: String,
  val dispatchProtocol: DispatchPropertyProtocol,
  val dispatchTriggers: Option[ISZ[Art.PortId]],

  current_tempWstatus: Port[Isolette_Data_Model.TempWstatus_impl],
  interface_failure: Port[Isolette_Data_Model.Failure_Flag_impl],
  internal_failure: Port[Isolette_Data_Model.Failure_Flag_impl],
  regulator_mode: Port[Isolette_Data_Model.Regulator_Mode.Type]
  ) extends Bridge {

  val ports : Bridge.Ports = Bridge.Ports(
    all = ISZ(current_tempWstatus,
              interface_failure,
              internal_failure,
              regulator_mode),

    dataIns = ISZ(current_tempWstatus,
                  interface_failure,
                  internal_failure),

    dataOuts = ISZ(regulator_mode),

    eventIns = ISZ(),

    eventOuts = ISZ()
  )

  val initialization_api : Manage_Regulator_Mode_impl_Initialization_Api = {
    val api = Manage_Regulator_Mode_impl_Initialization_Api(
      id,
      current_tempWstatus.id,
      interface_failure.id,
      internal_failure.id,
      regulator_mode.id
    )
    Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode_mrmt_Bridge.c_initialization_api = Some(api)
    api
  }

  val operational_api : Manage_Regulator_Mode_impl_Operational_Api = {
    val api = Manage_Regulator_Mode_impl_Operational_Api(
      id,
      current_tempWstatus.id,
      interface_failure.id,
      internal_failure.id,
      regulator_mode.id
    )
    Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode_mrmt_Bridge.c_operational_api = Some(api)
    api
  }

  val entryPoints : Bridge.EntryPoints =
    Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode_mrmt_Bridge.EntryPoints(
      id,

      current_tempWstatus.id,
      interface_failure.id,
      internal_failure.id,
      regulator_mode.id,

      dispatchTriggers,

      initialization_api,
      operational_api)
}

object Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode_mrmt_Bridge {

  var c_initialization_api: Option[Manage_Regulator_Mode_impl_Initialization_Api] = None()
  var c_operational_api: Option[Manage_Regulator_Mode_impl_Operational_Api] = None()

  @record class EntryPoints(
    Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode_mrmt_BridgeId : Art.BridgeId,

    current_tempWstatus_Id : Art.PortId,
    interface_failure_Id : Art.PortId,
    internal_failure_Id : Art.PortId,
    regulator_mode_Id : Art.PortId,

    dispatchTriggers : Option[ISZ[Art.PortId]],

    initialization_api: Manage_Regulator_Mode_impl_Initialization_Api,
    operational_api: Manage_Regulator_Mode_impl_Operational_Api) extends Bridge.EntryPoints {

    val dataInPortIds: ISZ[Art.PortId] = ISZ(current_tempWstatus_Id,
                                             interface_failure_Id,
                                             internal_failure_Id)

    val eventInPortIds: ISZ[Art.PortId] = ISZ()

    val dataOutPortIds: ISZ[Art.PortId] = ISZ(regulator_mode_Id)

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