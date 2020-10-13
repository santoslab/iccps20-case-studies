// #Sireum

package isolette.Isolette

import org.sireum._
import art._
import isolette._
import isolette.Isolette.{operator_interface_thread_impl_operator_interface_oip_oit => component}

// This file was auto-generated.  Do not edit

@record class operator_interface_thread_impl_operator_interface_oip_oit_Bridge(
  val id: Art.BridgeId,
  val name: String,
  val dispatchProtocol: DispatchPropertyProtocol,
  val dispatchTriggers: Option[ISZ[Art.PortId]],

  regulator_status: Port[Isolette_Data_Model.Status.Type],
  monitor_status: Port[Isolette_Data_Model.Status.Type],
  display_temperature: Port[Isolette_Data_Model.Temp_impl],
  alarm_control: Port[Isolette_Data_Model.On_Off.Type],
  lower_desired_tempWstatus: Port[Isolette_Data_Model.TempWstatus_impl],
  upper_desired_tempWstatus: Port[Isolette_Data_Model.TempWstatus_impl],
  lower_alarm_tempWstatus: Port[Isolette_Data_Model.TempWstatus_impl],
  upper_alarm_tempWstatus: Port[Isolette_Data_Model.TempWstatus_impl]
  ) extends Bridge {

  val ports : Bridge.Ports = Bridge.Ports(
    all = ISZ(regulator_status,
              monitor_status,
              display_temperature,
              alarm_control,
              lower_desired_tempWstatus,
              upper_desired_tempWstatus,
              lower_alarm_tempWstatus,
              upper_alarm_tempWstatus),

    dataIns = ISZ(regulator_status,
                  monitor_status,
                  display_temperature,
                  alarm_control),

    dataOuts = ISZ(lower_desired_tempWstatus,
                   upper_desired_tempWstatus,
                   lower_alarm_tempWstatus,
                   upper_alarm_tempWstatus),

    eventIns = ISZ(),

    eventOuts = ISZ()
  )

  val initialization_api : operator_interface_thread_impl_Initialization_Api = {
    val api = operator_interface_thread_impl_Initialization_Api(
      id,
      regulator_status.id,
      monitor_status.id,
      display_temperature.id,
      alarm_control.id,
      lower_desired_tempWstatus.id,
      upper_desired_tempWstatus.id,
      lower_alarm_tempWstatus.id,
      upper_alarm_tempWstatus.id
    )
    operator_interface_thread_impl_operator_interface_oip_oit_Bridge.c_initialization_api = Some(api)
    api
  }

  val operational_api : operator_interface_thread_impl_Operational_Api = {
    val api = operator_interface_thread_impl_Operational_Api(
      id,
      regulator_status.id,
      monitor_status.id,
      display_temperature.id,
      alarm_control.id,
      lower_desired_tempWstatus.id,
      upper_desired_tempWstatus.id,
      lower_alarm_tempWstatus.id,
      upper_alarm_tempWstatus.id
    )
    operator_interface_thread_impl_operator_interface_oip_oit_Bridge.c_operational_api = Some(api)
    api
  }

  val entryPoints : Bridge.EntryPoints =
    operator_interface_thread_impl_operator_interface_oip_oit_Bridge.EntryPoints(
      id,

      regulator_status.id,
      monitor_status.id,
      display_temperature.id,
      alarm_control.id,
      lower_desired_tempWstatus.id,
      upper_desired_tempWstatus.id,
      lower_alarm_tempWstatus.id,
      upper_alarm_tempWstatus.id,

      dispatchTriggers,

      initialization_api,
      operational_api)
}

object operator_interface_thread_impl_operator_interface_oip_oit_Bridge {

  var c_initialization_api: Option[operator_interface_thread_impl_Initialization_Api] = None()
  var c_operational_api: Option[operator_interface_thread_impl_Operational_Api] = None()

  @record class EntryPoints(
    operator_interface_thread_impl_operator_interface_oip_oit_BridgeId : Art.BridgeId,

    regulator_status_Id : Art.PortId,
    monitor_status_Id : Art.PortId,
    display_temperature_Id : Art.PortId,
    alarm_control_Id : Art.PortId,
    lower_desired_tempWstatus_Id : Art.PortId,
    upper_desired_tempWstatus_Id : Art.PortId,
    lower_alarm_tempWstatus_Id : Art.PortId,
    upper_alarm_tempWstatus_Id : Art.PortId,

    dispatchTriggers : Option[ISZ[Art.PortId]],

    initialization_api: operator_interface_thread_impl_Initialization_Api,
    operational_api: operator_interface_thread_impl_Operational_Api) extends Bridge.EntryPoints {

    val dataInPortIds: ISZ[Art.PortId] = ISZ(regulator_status_Id,
                                             monitor_status_Id,
                                             display_temperature_Id,
                                             alarm_control_Id)

    val eventInPortIds: ISZ[Art.PortId] = ISZ()

    val dataOutPortIds: ISZ[Art.PortId] = ISZ(lower_desired_tempWstatus_Id,
                                              upper_desired_tempWstatus_Id,
                                              lower_alarm_tempWstatus_Id,
                                              upper_alarm_tempWstatus_Id)

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