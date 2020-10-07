// #Sireum

package pca_pump.PCA_Mechanical

import org.sireum._
import art._
import pca_pump._
import pca_pump.PCA_Mechanical.{patient_button_imp_pump_operation_patient_button => component}

// This file was auto-generated.  Do not edit

@record class patient_button_imp_pump_operation_patient_button_Bridge(
  val id: Art.BridgeId,
  val name: String,
  val dispatchProtocol: DispatchPropertyProtocol,
  val dispatchTriggers: Option[ISZ[Art.PortId]],

  Button_Press: Port[art.Empty],
  Request_Bolus: Port[art.Empty]
  ) extends Bridge {

  val ports : Bridge.Ports = Bridge.Ports(
    all = ISZ(Button_Press,
              Request_Bolus),

    dataIns = ISZ(),

    dataOuts = ISZ(),

    eventIns = ISZ(Button_Press),

    eventOuts = ISZ(Request_Bolus)
  )

  val initialization_api : patient_button_imp_Initialization_Api = {
    val api = patient_button_imp_Initialization_Api(
      id,
      Button_Press.id,
      Request_Bolus.id
    )
    patient_button_imp_pump_operation_patient_button_Bridge.c_initialization_api = Some(api)
    api
  }

  val operational_api : patient_button_imp_Operational_Api = {
    val api = patient_button_imp_Operational_Api(
      id,
      Button_Press.id,
      Request_Bolus.id
    )
    patient_button_imp_pump_operation_patient_button_Bridge.c_operational_api = Some(api)
    api
  }

  val entryPoints : Bridge.EntryPoints =
    patient_button_imp_pump_operation_patient_button_Bridge.EntryPoints(
      id,

      Button_Press.id,
      Request_Bolus.id,

      dispatchTriggers,

      initialization_api,
      operational_api)
}

object patient_button_imp_pump_operation_patient_button_Bridge {

  var c_initialization_api: Option[patient_button_imp_Initialization_Api] = None()
  var c_operational_api: Option[patient_button_imp_Operational_Api] = None()

  @record class EntryPoints(
    patient_button_imp_pump_operation_patient_button_BridgeId : Art.BridgeId,

    Button_Press_Id : Art.PortId,
    Request_Bolus_Id : Art.PortId,

    dispatchTriggers : Option[ISZ[Art.PortId]],

    initialization_api: patient_button_imp_Initialization_Api,
    operational_api: patient_button_imp_Operational_Api) extends Bridge.EntryPoints {

    val dataInPortIds: ISZ[Art.PortId] = ISZ()

    val eventInPortIds: ISZ[Art.PortId] = ISZ(Button_Press_Id)

    val dataOutPortIds: ISZ[Art.PortId] = ISZ()

    val eventOutPortIds: ISZ[Art.PortId] = ISZ(Request_Bolus_Id)

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
      val EventTriggered(receivedEvents) = Art.dispatchStatus(patient_button_imp_pump_operation_patient_button_BridgeId)

      // remove non-dispatching event ports
      val dispatchableEventPorts: ISZ[Art.PortId] =
        if(dispatchTriggers.isEmpty) receivedEvents
        else filter(receivedEvents, dispatchTriggers.get)

      Art.receiveInput(eventInPortIds, dataInPortIds)

      for(portId <- dispatchableEventPorts) {
        if(portId == Button_Press_Id) {
          component.handleButton_Press(operational_api)
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
      val EventTriggered(receivedEvents) = Art.dispatchStatus(patient_button_imp_pump_operation_patient_button_BridgeId)

      // remove non-dispatching event ports
      val dispatchableEventPorts: ISZ[Art.PortId] =
        if(dispatchTriggers.isEmpty) receivedEvents
        else filter(receivedEvents, dispatchTriggers.get)

      Art.receiveInput(eventInPortIds, dataInPortIds)

      for(portId <- dispatchableEventPorts) {
        if(portId == Button_Press_Id) {
          component.handleButton_Press(operational_api)
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