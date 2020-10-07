// #Sireum

package pca_pump.PCA_Mechanical

import org.sireum._
import art._
import pca_pump._
import pca_pump.PCA_Mechanical.{pump_imp_pump_fluid_mech_pump => component}

// This file was auto-generated.  Do not edit

@record class pump_imp_pump_fluid_mech_pump_Bridge(
  val id: Art.BridgeId,
  val name: String,
  val dispatchProtocol: DispatchPropertyProtocol,
  val dispatchTriggers: Option[ISZ[Art.PortId]],

  Drug_Intake: Port[Physical_Types.Fluid_Flow_imp],
  Rate: Port[PCA_Types.Flow_Rate_imp],
  Drug_Outlet: Port[Physical_Types.Fluid_Flow_imp],
  Halt: Port[art.Empty],
  Pump_Too_Hot: Port[art.Empty]
  ) extends Bridge {

  val ports : Bridge.Ports = Bridge.Ports(
    all = ISZ(Drug_Intake,
              Rate,
              Drug_Outlet,
              Halt,
              Pump_Too_Hot),

    dataIns = ISZ(Drug_Intake,
                  Rate),

    dataOuts = ISZ(Drug_Outlet),

    eventIns = ISZ(Halt),

    eventOuts = ISZ(Pump_Too_Hot)
  )

  val initialization_api : pump_imp_Initialization_Api = {
    val api = pump_imp_Initialization_Api(
      id,
      Drug_Intake.id,
      Rate.id,
      Drug_Outlet.id,
      Halt.id,
      Pump_Too_Hot.id
    )
    pump_imp_pump_fluid_mech_pump_Bridge.c_initialization_api = Some(api)
    api
  }

  val operational_api : pump_imp_Operational_Api = {
    val api = pump_imp_Operational_Api(
      id,
      Drug_Intake.id,
      Rate.id,
      Drug_Outlet.id,
      Halt.id,
      Pump_Too_Hot.id
    )
    pump_imp_pump_fluid_mech_pump_Bridge.c_operational_api = Some(api)
    api
  }

  val entryPoints : Bridge.EntryPoints =
    pump_imp_pump_fluid_mech_pump_Bridge.EntryPoints(
      id,

      Drug_Intake.id,
      Rate.id,
      Drug_Outlet.id,
      Halt.id,
      Pump_Too_Hot.id,

      dispatchTriggers,

      initialization_api,
      operational_api)
}

object pump_imp_pump_fluid_mech_pump_Bridge {

  var c_initialization_api: Option[pump_imp_Initialization_Api] = None()
  var c_operational_api: Option[pump_imp_Operational_Api] = None()

  @record class EntryPoints(
    pump_imp_pump_fluid_mech_pump_BridgeId : Art.BridgeId,

    Drug_Intake_Id : Art.PortId,
    Rate_Id : Art.PortId,
    Drug_Outlet_Id : Art.PortId,
    Halt_Id : Art.PortId,
    Pump_Too_Hot_Id : Art.PortId,

    dispatchTriggers : Option[ISZ[Art.PortId]],

    initialization_api: pump_imp_Initialization_Api,
    operational_api: pump_imp_Operational_Api) extends Bridge.EntryPoints {

    val dataInPortIds: ISZ[Art.PortId] = ISZ(Drug_Intake_Id,
                                             Rate_Id)

    val eventInPortIds: ISZ[Art.PortId] = ISZ(Halt_Id)

    val dataOutPortIds: ISZ[Art.PortId] = ISZ(Drug_Outlet_Id)

    val eventOutPortIds: ISZ[Art.PortId] = ISZ(Pump_Too_Hot_Id)

    def compute(): Unit = {
      // transpiler friendly filter
      def filter(receivedEvents: ISZ[Art.PortId], triggers: ISZ[Art.PortId]): ISZ[Art.PortId] = {
        var r = ISZ[Art.PortId]()
        val opsTriggers = ops.ISZOps(triggers)
        for(e <- receivedEvents) {
          if(opsTriggers.contains(e)) {
            r = r :+ e
          }
        }
        return r
      }

      // fetch received events ordered by highest urgency then earliest arrival-time
      val EventTriggered(receivedEvents) = Art.dispatchStatus(pump_imp_pump_fluid_mech_pump_BridgeId)

      // remove non-dispatching event ports
      val dispatchableEventPorts: ISZ[Art.PortId] =
        if(dispatchTriggers.isEmpty) receivedEvents
        else filter(receivedEvents, dispatchTriggers.get)

      Art.receiveInput(eventInPortIds, dataInPortIds)

      for(portId <- dispatchableEventPorts) {
        if(portId == Halt_Id) {
          component.handleHalt(operational_api)
        }
      }

      Art.sendOutput(eventOutPortIds, dataOutPortIds)
    }

    override
    def testCompute(): Unit = {
      // transpiler friendly filter
      def filter(receivedEvents: ISZ[Art.PortId], triggers: ISZ[Art.PortId]): ISZ[Art.PortId] = {
        var r = ISZ[Art.PortId]()
        val opsTriggers = ops.ISZOps(triggers)
        for(e <- receivedEvents) {
          if(opsTriggers.contains(e)) {
            r = r :+ e
          }
        }
        return r
      }

      // fetch received events ordered by highest urgency then earliest arrival-time
      val EventTriggered(receivedEvents) = Art.dispatchStatus(pump_imp_pump_fluid_mech_pump_BridgeId)

      // remove non-dispatching event ports
      val dispatchableEventPorts: ISZ[Art.PortId] =
        if(dispatchTriggers.isEmpty) receivedEvents
        else filter(receivedEvents, dispatchTriggers.get)

      Art.receiveInput(eventInPortIds, dataInPortIds)

      for(portId <- dispatchableEventPorts) {
        if(portId == Halt_Id) {
          component.handleHalt(operational_api)
        }
      }

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