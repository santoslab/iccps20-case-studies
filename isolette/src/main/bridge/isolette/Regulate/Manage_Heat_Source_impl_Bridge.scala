// #Sireum

package isolette.Regulate

import org.sireum._
import art._
import isolette._

// This file was auto-generated.  Do not edit

@record class Manage_Heat_Source_impl_Bridge(
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

  val api : Manage_Heat_Source_impl_Bridge.Api =
    Manage_Heat_Source_impl_Bridge.Api(
      id,
      current_tempWstatus.id,
      lower_desired_temp.id,
      upper_desired_temp.id,
      regulator_mode.id,
      heat_control.id
    )

  val entryPoints : Bridge.EntryPoints =
    Manage_Heat_Source_impl_Bridge.EntryPoints(
      id,

      current_tempWstatus.id,
      lower_desired_temp.id,
      upper_desired_temp.id,
      regulator_mode.id,
      heat_control.id,

      dispatchTriggers,

      Manage_Heat_Source_impl_Impl(api)
    )
}

object Manage_Heat_Source_impl_Bridge {

  @record class Api(
    id : Art.BridgeId,
    current_tempWstatus_Id : Art.PortId,
    lower_desired_temp_Id : Art.PortId,
    upper_desired_temp_Id : Art.PortId,
    regulator_mode_Id : Art.PortId,
    heat_control_Id : Art.PortId) {


    def getcurrent_tempWstatus() : Option[Isolette_Data_Model.TempWstatus_impl] = {
      val value : Option[Isolette_Data_Model.TempWstatus_impl] = Art.getValue(current_tempWstatus_Id) match {
        case Some(Isolette_Data_Model.TempWstatus_impl_Payload(v)) => Some(v)
        case Some(v) =>
          Art.logError(id, s"Unexpected payload on port current_tempWstatus.  Expecting 'Isolette_Data_Model.TempWstatus_impl_Payload' but received ${v}")
          None[Isolette_Data_Model.TempWstatus_impl]()
        case _ => None[Isolette_Data_Model.TempWstatus_impl]()
      }
      return value
    }

    def getlower_desired_temp() : Option[Isolette_Data_Model.Temp_impl] = {
      val value : Option[Isolette_Data_Model.Temp_impl] = Art.getValue(lower_desired_temp_Id) match {
        case Some(Isolette_Data_Model.Temp_impl_Payload(v)) => Some(v)
        case Some(v) =>
          Art.logError(id, s"Unexpected payload on port lower_desired_temp.  Expecting 'Isolette_Data_Model.Temp_impl_Payload' but received ${v}")
          None[Isolette_Data_Model.Temp_impl]()
        case _ => None[Isolette_Data_Model.Temp_impl]()
      }
      return value
    }

    def getupper_desired_temp() : Option[Isolette_Data_Model.Temp_impl] = {
      val value : Option[Isolette_Data_Model.Temp_impl] = Art.getValue(upper_desired_temp_Id) match {
        case Some(Isolette_Data_Model.Temp_impl_Payload(v)) => Some(v)
        case Some(v) =>
          Art.logError(id, s"Unexpected payload on port upper_desired_temp.  Expecting 'Isolette_Data_Model.Temp_impl_Payload' but received ${v}")
          None[Isolette_Data_Model.Temp_impl]()
        case _ => None[Isolette_Data_Model.Temp_impl]()
      }
      return value
    }

    def getregulator_mode() : Option[Isolette_Data_Model.Regulator_Mode.Type] = {
      val value : Option[Isolette_Data_Model.Regulator_Mode.Type] = Art.getValue(regulator_mode_Id) match {
        case Some(Isolette_Data_Model.Regulator_Mode_Payload(v)) => Some(v)
        case Some(v) =>
          Art.logError(id, s"Unexpected payload on port regulator_mode.  Expecting 'Isolette_Data_Model.Regulator_Mode_Payload' but received ${v}")
          None[Isolette_Data_Model.Regulator_Mode.Type]()
        case _ => None[Isolette_Data_Model.Regulator_Mode.Type]()
      }
      return value
    }

    def setheat_control(value : Isolette_Data_Model.On_Off.Type) : Unit = {
      Art.putValue(heat_control_Id, Isolette_Data_Model.On_Off_Payload(value))
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
    Manage_Heat_Source_impl_BridgeId : Art.BridgeId,

    current_tempWstatus_Id : Art.PortId,
    lower_desired_temp_Id : Art.PortId,
    upper_desired_temp_Id : Art.PortId,
    regulator_mode_Id : Art.PortId,
    heat_control_Id : Art.PortId,

    dispatchTriggers : Option[ISZ[Art.PortId]],

    component : Manage_Heat_Source_impl_Impl ) extends Bridge.EntryPoints {

    val dataInPortIds: ISZ[Art.PortId] = ISZ(current_tempWstatus_Id,
                                             lower_desired_temp_Id,
                                             upper_desired_temp_Id,
                                             regulator_mode_Id)

    val eventInPortIds: ISZ[Art.PortId] = ISZ()

    val dataOutPortIds: ISZ[Art.PortId] = ISZ(heat_control_Id)

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