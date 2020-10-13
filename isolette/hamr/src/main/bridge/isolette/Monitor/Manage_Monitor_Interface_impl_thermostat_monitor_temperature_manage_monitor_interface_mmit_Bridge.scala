// #Sireum

package isolette.Monitor

import org.sireum._
import art._
import isolette._
import isolette.Monitor.{Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_mmit => component}

// This file was auto-generated.  Do not edit

@record class Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_mmit_Bridge(
  val id: Art.BridgeId,
  val name: String,
  val dispatchProtocol: DispatchPropertyProtocol,
  val dispatchTriggers: Option[ISZ[Art.PortId]],

  upper_alarm_tempWstatus: Port[Isolette_Data_Model.TempWstatus_impl],
  lower_alarm_tempWstatus: Port[Isolette_Data_Model.TempWstatus_impl],
  current_tempWstatus: Port[Isolette_Data_Model.TempWstatus_impl],
  monitor_mode: Port[Isolette_Data_Model.Monitor_Mode.Type],
  upper_alarm_temp: Port[Isolette_Data_Model.Temp_impl],
  lower_alarm_temp: Port[Isolette_Data_Model.Temp_impl],
  monitor_status: Port[Isolette_Data_Model.Status.Type],
  interface_failure: Port[Isolette_Data_Model.Failure_Flag_impl]
  ) extends Bridge {

  val ports : Bridge.Ports = Bridge.Ports(
    all = ISZ(upper_alarm_tempWstatus,
              lower_alarm_tempWstatus,
              current_tempWstatus,
              monitor_mode,
              upper_alarm_temp,
              lower_alarm_temp,
              monitor_status,
              interface_failure),

    dataIns = ISZ(upper_alarm_tempWstatus,
                  lower_alarm_tempWstatus,
                  current_tempWstatus,
                  monitor_mode),

    dataOuts = ISZ(upper_alarm_temp,
                   lower_alarm_temp,
                   monitor_status,
                   interface_failure),

    eventIns = ISZ(),

    eventOuts = ISZ()
  )

  val initialization_api : Manage_Monitor_Interface_impl_Initialization_Api = {
    val api = Manage_Monitor_Interface_impl_Initialization_Api(
      id,
      upper_alarm_tempWstatus.id,
      lower_alarm_tempWstatus.id,
      current_tempWstatus.id,
      monitor_mode.id,
      upper_alarm_temp.id,
      lower_alarm_temp.id,
      monitor_status.id,
      interface_failure.id
    )
    Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_mmit_Bridge.c_initialization_api = Some(api)
    api
  }

  val operational_api : Manage_Monitor_Interface_impl_Operational_Api = {
    val api = Manage_Monitor_Interface_impl_Operational_Api(
      id,
      upper_alarm_tempWstatus.id,
      lower_alarm_tempWstatus.id,
      current_tempWstatus.id,
      monitor_mode.id,
      upper_alarm_temp.id,
      lower_alarm_temp.id,
      monitor_status.id,
      interface_failure.id
    )
    Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_mmit_Bridge.c_operational_api = Some(api)
    api
  }

  val entryPoints : Bridge.EntryPoints =
    Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_mmit_Bridge.EntryPoints(
      id,

      upper_alarm_tempWstatus.id,
      lower_alarm_tempWstatus.id,
      current_tempWstatus.id,
      monitor_mode.id,
      upper_alarm_temp.id,
      lower_alarm_temp.id,
      monitor_status.id,
      interface_failure.id,

      dispatchTriggers,

      initialization_api,
      operational_api)
}

object Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_mmit_Bridge {

  var c_initialization_api: Option[Manage_Monitor_Interface_impl_Initialization_Api] = None()
  var c_operational_api: Option[Manage_Monitor_Interface_impl_Operational_Api] = None()

  @record class EntryPoints(
    Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_mmit_BridgeId : Art.BridgeId,

    upper_alarm_tempWstatus_Id : Art.PortId,
    lower_alarm_tempWstatus_Id : Art.PortId,
    current_tempWstatus_Id : Art.PortId,
    monitor_mode_Id : Art.PortId,
    upper_alarm_temp_Id : Art.PortId,
    lower_alarm_temp_Id : Art.PortId,
    monitor_status_Id : Art.PortId,
    interface_failure_Id : Art.PortId,

    dispatchTriggers : Option[ISZ[Art.PortId]],

    initialization_api: Manage_Monitor_Interface_impl_Initialization_Api,
    operational_api: Manage_Monitor_Interface_impl_Operational_Api) extends Bridge.EntryPoints {

    val dataInPortIds: ISZ[Art.PortId] = ISZ(upper_alarm_tempWstatus_Id,
                                             lower_alarm_tempWstatus_Id,
                                             current_tempWstatus_Id,
                                             monitor_mode_Id)

    val eventInPortIds: ISZ[Art.PortId] = ISZ()

    val dataOutPortIds: ISZ[Art.PortId] = ISZ(upper_alarm_temp_Id,
                                              lower_alarm_temp_Id,
                                              monitor_status_Id,
                                              interface_failure_Id)

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