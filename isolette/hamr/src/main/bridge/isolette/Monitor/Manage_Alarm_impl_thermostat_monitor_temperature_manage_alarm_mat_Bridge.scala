// #Sireum

package isolette.Monitor

import org.sireum._
import art._
import isolette._
import isolette.Monitor.{Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_mat => component}

// This file was auto-generated.  Do not edit

@record class Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_mat_Bridge(
  val id: Art.BridgeId,
  val name: String,
  val dispatchProtocol: DispatchPropertyProtocol,
  val dispatchTriggers: Option[ISZ[Art.PortId]],

  current_tempWstatus: Port[Isolette_Data_Model.TempWstatus_impl],
  lower_alarm_temp: Port[Isolette_Data_Model.Temp_impl],
  upper_alarm_temp: Port[Isolette_Data_Model.Temp_impl],
  monitor_mode: Port[Isolette_Data_Model.Monitor_Mode.Type],
  alarm_control: Port[Isolette_Data_Model.On_Off.Type]
  ) extends Bridge {

  val ports : Bridge.Ports = Bridge.Ports(
    all = ISZ(current_tempWstatus,
              lower_alarm_temp,
              upper_alarm_temp,
              monitor_mode,
              alarm_control),

    dataIns = ISZ(current_tempWstatus,
                  lower_alarm_temp,
                  upper_alarm_temp,
                  monitor_mode),

    dataOuts = ISZ(alarm_control),

    eventIns = ISZ(),

    eventOuts = ISZ()
  )

  val initialization_api : Manage_Alarm_impl_Initialization_Api = {
    val api = Manage_Alarm_impl_Initialization_Api(
      id,
      current_tempWstatus.id,
      lower_alarm_temp.id,
      upper_alarm_temp.id,
      monitor_mode.id,
      alarm_control.id
    )
    Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_mat_Bridge.c_initialization_api = Some(api)
    api
  }

  val operational_api : Manage_Alarm_impl_Operational_Api = {
    val api = Manage_Alarm_impl_Operational_Api(
      id,
      current_tempWstatus.id,
      lower_alarm_temp.id,
      upper_alarm_temp.id,
      monitor_mode.id,
      alarm_control.id
    )
    Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_mat_Bridge.c_operational_api = Some(api)
    api
  }

  val entryPoints : Bridge.EntryPoints =
    Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_mat_Bridge.EntryPoints(
      id,

      current_tempWstatus.id,
      lower_alarm_temp.id,
      upper_alarm_temp.id,
      monitor_mode.id,
      alarm_control.id,

      dispatchTriggers,

      initialization_api,
      operational_api)
}

object Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_mat_Bridge {

  var c_initialization_api: Option[Manage_Alarm_impl_Initialization_Api] = None()
  var c_operational_api: Option[Manage_Alarm_impl_Operational_Api] = None()

  @record class EntryPoints(
    Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_mat_BridgeId : Art.BridgeId,

    current_tempWstatus_Id : Art.PortId,
    lower_alarm_temp_Id : Art.PortId,
    upper_alarm_temp_Id : Art.PortId,
    monitor_mode_Id : Art.PortId,
    alarm_control_Id : Art.PortId,

    dispatchTriggers : Option[ISZ[Art.PortId]],

    initialization_api: Manage_Alarm_impl_Initialization_Api,
    operational_api: Manage_Alarm_impl_Operational_Api) extends Bridge.EntryPoints {

    val dataInPortIds: ISZ[Art.PortId] = ISZ(current_tempWstatus_Id,
                                             lower_alarm_temp_Id,
                                             upper_alarm_temp_Id,
                                             monitor_mode_Id)

    val eventInPortIds: ISZ[Art.PortId] = ISZ()

    val dataOutPortIds: ISZ[Art.PortId] = ISZ(alarm_control_Id)

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