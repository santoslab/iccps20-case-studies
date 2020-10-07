// #Sireum

package pca_pump.PCA_Mechanical

import org.sireum._
import art._
import pca_pump._
import pca_pump.PCA_Mechanical.{scanner_imp_pump_operation_scanner => component}

// This file was auto-generated.  Do not edit

@record class scanner_imp_pump_operation_scanner_Bridge(
  val id: Art.BridgeId,
  val name: String,
  val dispatchProtocol: DispatchPropertyProtocol,
  val dispatchTriggers: Option[ISZ[Art.PortId]],

  Scan_Data: Port[PCA_Types.Scan_Data_Type],
  Do_Scan: Port[art.Empty],
  Scan_Done: Port[art.Empty]
  ) extends Bridge {

  val ports : Bridge.Ports = Bridge.Ports(
    all = ISZ(Scan_Data,
              Do_Scan,
              Scan_Done),

    dataIns = ISZ(),

    dataOuts = ISZ(),

    eventIns = ISZ(Do_Scan),

    eventOuts = ISZ(Scan_Data,
                    Scan_Done)
  )

  val initialization_api : scanner_imp_Initialization_Api = {
    val api = scanner_imp_Initialization_Api(
      id,
      Scan_Data.id,
      Do_Scan.id,
      Scan_Done.id
    )
    scanner_imp_pump_operation_scanner_Bridge.c_initialization_api = Some(api)
    api
  }

  val operational_api : scanner_imp_Operational_Api = {
    val api = scanner_imp_Operational_Api(
      id,
      Scan_Data.id,
      Do_Scan.id,
      Scan_Done.id
    )
    scanner_imp_pump_operation_scanner_Bridge.c_operational_api = Some(api)
    api
  }

  val entryPoints : Bridge.EntryPoints =
    scanner_imp_pump_operation_scanner_Bridge.EntryPoints(
      id,

      Scan_Data.id,
      Do_Scan.id,
      Scan_Done.id,

      dispatchTriggers,

      initialization_api,
      operational_api)
}

object scanner_imp_pump_operation_scanner_Bridge {

  var c_initialization_api: Option[scanner_imp_Initialization_Api] = None()
  var c_operational_api: Option[scanner_imp_Operational_Api] = None()

  @record class EntryPoints(
    scanner_imp_pump_operation_scanner_BridgeId : Art.BridgeId,

    Scan_Data_Id : Art.PortId,
    Do_Scan_Id : Art.PortId,
    Scan_Done_Id : Art.PortId,

    dispatchTriggers : Option[ISZ[Art.PortId]],

    initialization_api: scanner_imp_Initialization_Api,
    operational_api: scanner_imp_Operational_Api) extends Bridge.EntryPoints {

    val dataInPortIds: ISZ[Art.PortId] = ISZ()

    val eventInPortIds: ISZ[Art.PortId] = ISZ(Do_Scan_Id)

    val dataOutPortIds: ISZ[Art.PortId] = ISZ()

    val eventOutPortIds: ISZ[Art.PortId] = ISZ(Scan_Data_Id,
                                               Scan_Done_Id)

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
      val EventTriggered(receivedEvents) = Art.dispatchStatus(scanner_imp_pump_operation_scanner_BridgeId)

      // remove non-dispatching event ports
      val dispatchableEventPorts: ISZ[Art.PortId] =
        if(dispatchTriggers.isEmpty) receivedEvents
        else filter(receivedEvents, dispatchTriggers.get)

      Art.receiveInput(eventInPortIds, dataInPortIds)

      for(portId <- dispatchableEventPorts) {
        if(portId == Do_Scan_Id) {
          component.handleDo_Scan(operational_api)
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
      val EventTriggered(receivedEvents) = Art.dispatchStatus(scanner_imp_pump_operation_scanner_BridgeId)

      // remove non-dispatching event ports
      val dispatchableEventPorts: ISZ[Art.PortId] =
        if(dispatchTriggers.isEmpty) receivedEvents
        else filter(receivedEvents, dispatchTriggers.get)

      Art.receiveInput(eventInPortIds, dataInPortIds)

      for(portId <- dispatchableEventPorts) {
        if(portId == Do_Scan_Id) {
          component.handleDo_Scan(operational_api)
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