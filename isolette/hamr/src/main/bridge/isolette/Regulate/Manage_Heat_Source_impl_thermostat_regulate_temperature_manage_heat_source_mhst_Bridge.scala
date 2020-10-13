// #Sireum

package isolette.Regulate

import org.sireum._
import art._
import isolette._
import isolette.Regulate.{Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_mhst => component}

// This file was auto-generated.  Do not edit

@record class Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_mhst_Bridge(
  val id: Art.BridgeId,
  val name: String,
  val dispatchProtocol: DispatchPropertyProtocol,
  val dispatchTriggers: Option[ISZ[Art.PortId]],

  current_tempWstatus: Port[Isolette_Data_Model.TempWstatus_impl],
  lower_desired_temp: Port[Isolette_Data_Model.Temp_impl],
  upper_desired_temp: Port[Isolette_Data_Model.Temp_impl],
  regulator_mode: Port[Isolette_Data_Model.Regulator_Mode.Type],
  heat_control: Port[Isolette_Data_Model.On_Off.Type]
  ) extends Bridge {

  val ports : Bridge.Ports = Bridge.Ports(
    all = ISZ(current_tempWstatus,
              lower_desired_temp,
              upper_desired_temp,
              regulator_mode,
              heat_control),

    dataIns = ISZ(current_tempWstatus,
                  lower_desired_temp,
                  upper_desired_temp,
                  regulator_mode),

    dataOuts = ISZ(heat_control),

    eventIns = ISZ(),

    eventOuts = ISZ()
  )

  val initialization_api : Manage_Heat_Source_impl_Initialization_Api = {
    val api = Manage_Heat_Source_impl_Initialization_Api(
      id,
      current_tempWstatus.id,
      lower_desired_temp.id,
      upper_desired_temp.id,
      regulator_mode.id,
      heat_control.id
    )
    Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_mhst_Bridge.c_initialization_api = Some(api)
    api
  }

  val operational_api : Manage_Heat_Source_impl_Operational_Api = {
    val api = Manage_Heat_Source_impl_Operational_Api(
      id,
      current_tempWstatus.id,
      lower_desired_temp.id,
      upper_desired_temp.id,
      regulator_mode.id,
      heat_control.id
    )
    Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_mhst_Bridge.c_operational_api = Some(api)
    api
  }

  val entryPoints : Bridge.EntryPoints =
    Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_mhst_Bridge.EntryPoints(
      id,

      current_tempWstatus.id,
      lower_desired_temp.id,
      upper_desired_temp.id,
      regulator_mode.id,
      heat_control.id,

      dispatchTriggers,

      initialization_api,
      operational_api)
}

object Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_mhst_Bridge {

  var c_initialization_api: Option[Manage_Heat_Source_impl_Initialization_Api] = None()
  var c_operational_api: Option[Manage_Heat_Source_impl_Operational_Api] = None()

  @record class EntryPoints(
    Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_mhst_BridgeId : Art.BridgeId,

    current_tempWstatus_Id : Art.PortId,
    lower_desired_temp_Id : Art.PortId,
    upper_desired_temp_Id : Art.PortId,
    regulator_mode_Id : Art.PortId,
    heat_control_Id : Art.PortId,

    dispatchTriggers : Option[ISZ[Art.PortId]],

    initialization_api: Manage_Heat_Source_impl_Initialization_Api,
    operational_api: Manage_Heat_Source_impl_Operational_Api) extends Bridge.EntryPoints {

    val dataInPortIds: ISZ[Art.PortId] = ISZ(current_tempWstatus_Id,
                                             lower_desired_temp_Id,
                                             upper_desired_temp_Id,
                                             regulator_mode_Id)

    val eventInPortIds: ISZ[Art.PortId] = ISZ()

    val dataOutPortIds: ISZ[Art.PortId] = ISZ(heat_control_Id)

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