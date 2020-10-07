// #Sireum

package isolette.Isolette

import org.sireum._
import art._
import isolette._

// This file was auto-generated.  Do not edit

@record class operator_interface_thread_impl_Bridge(
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

  val api : operator_interface_thread_impl_Bridge.Api =
    operator_interface_thread_impl_Bridge.Api(
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

  val entryPoints : Bridge.EntryPoints =
    operator_interface_thread_impl_Bridge.EntryPoints(
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

      operator_interface_thread_impl_Impl(api)
    )
}

object operator_interface_thread_impl_Bridge {

  @record class Api(
    id : Art.BridgeId,
    regulator_status_Id : Art.PortId,
    monitor_status_Id : Art.PortId,
    display_temperature_Id : Art.PortId,
    alarm_control_Id : Art.PortId,
    lower_desired_tempWstatus_Id : Art.PortId,
    upper_desired_tempWstatus_Id : Art.PortId,
    lower_alarm_tempWstatus_Id : Art.PortId,
    upper_alarm_tempWstatus_Id : Art.PortId) {


    def getregulator_status() : Option[Isolette_Data_Model.Status.Type] = {
      val value : Option[Isolette_Data_Model.Status.Type] = Art.getValue(regulator_status_Id) match {
        case Some(Isolette_Data_Model.Status_Payload(v)) => Some(v)
        case Some(v) =>
          Art.logError(id, s"Unexpected payload on port regulator_status.  Expecting 'Isolette_Data_Model.Status_Payload' but received ${v}")
          None[Isolette_Data_Model.Status.Type]()
        case _ => None[Isolette_Data_Model.Status.Type]()
      }
      return value
    }

    def getmonitor_status() : Option[Isolette_Data_Model.Status.Type] = {
      val value : Option[Isolette_Data_Model.Status.Type] = Art.getValue(monitor_status_Id) match {
        case Some(Isolette_Data_Model.Status_Payload(v)) => Some(v)
        case Some(v) =>
          Art.logError(id, s"Unexpected payload on port monitor_status.  Expecting 'Isolette_Data_Model.Status_Payload' but received ${v}")
          None[Isolette_Data_Model.Status.Type]()
        case _ => None[Isolette_Data_Model.Status.Type]()
      }
      return value
    }

    def getdisplay_temperature() : Option[Isolette_Data_Model.Temp_impl] = {
      val value : Option[Isolette_Data_Model.Temp_impl] = Art.getValue(display_temperature_Id) match {
        case Some(Isolette_Data_Model.Temp_impl_Payload(v)) => Some(v)
        case Some(v) =>
          Art.logError(id, s"Unexpected payload on port display_temperature.  Expecting 'Isolette_Data_Model.Temp_impl_Payload' but received ${v}")
          None[Isolette_Data_Model.Temp_impl]()
        case _ => None[Isolette_Data_Model.Temp_impl]()
      }
      return value
    }

    def getalarm_control() : Option[Isolette_Data_Model.On_Off.Type] = {
      val value : Option[Isolette_Data_Model.On_Off.Type] = Art.getValue(alarm_control_Id) match {
        case Some(Isolette_Data_Model.On_Off_Payload(v)) => Some(v)
        case Some(v) =>
          Art.logError(id, s"Unexpected payload on port alarm_control.  Expecting 'Isolette_Data_Model.On_Off_Payload' but received ${v}")
          None[Isolette_Data_Model.On_Off.Type]()
        case _ => None[Isolette_Data_Model.On_Off.Type]()
      }
      return value
    }

    def setlower_desired_tempWstatus(value : Isolette_Data_Model.TempWstatus_impl) : Unit = {
      Art.putValue(lower_desired_tempWstatus_Id, Isolette_Data_Model.TempWstatus_impl_Payload(value))
    }

    def setupper_desired_tempWstatus(value : Isolette_Data_Model.TempWstatus_impl) : Unit = {
      Art.putValue(upper_desired_tempWstatus_Id, Isolette_Data_Model.TempWstatus_impl_Payload(value))
    }

    def setlower_alarm_tempWstatus(value : Isolette_Data_Model.TempWstatus_impl) : Unit = {
      Art.putValue(lower_alarm_tempWstatus_Id, Isolette_Data_Model.TempWstatus_impl_Payload(value))
    }

    def setupper_alarm_tempWstatus(value : Isolette_Data_Model.TempWstatus_impl) : Unit = {
      Art.putValue(upper_alarm_tempWstatus_Id, Isolette_Data_Model.TempWstatus_impl_Payload(value))
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
    operator_interface_thread_impl_BridgeId : Art.BridgeId,

    regulator_status_Id : Art.PortId,
    monitor_status_Id : Art.PortId,
    display_temperature_Id : Art.PortId,
    alarm_control_Id : Art.PortId,
    lower_desired_tempWstatus_Id : Art.PortId,
    upper_desired_tempWstatus_Id : Art.PortId,
    lower_alarm_tempWstatus_Id : Art.PortId,
    upper_alarm_tempWstatus_Id : Art.PortId,

    dispatchTriggers : Option[ISZ[Art.PortId]],

    component : operator_interface_thread_impl_Impl ) extends Bridge.EntryPoints {

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