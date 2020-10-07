// #Sireum

package pca_pump.PCA_Drug_Library

import org.sireum._
import art._
import pca_pump._
import pca_pump.PCA_Drug_Library.{drug_library_thread_imp_pump_operation_operation_process_drug_library => component}

// This file was auto-generated.  Do not edit

@record class drug_library_thread_imp_pump_operation_operation_process_drug_library_Bridge(
  val id: Art.BridgeId,
  val name: String,
  val dispatchProtocol: DispatchPropertyProtocol,
  val dispatchTriggers: Option[ISZ[Art.PortId]],

  Load_Drug_Library: Port[PCA_Types.Drug_Library],
  Get_Drug_Record: Port[PCA_Types.Drug_Code_imp],
  The_Drug_Record: Port[PCA_Types.Drug_Record_imp],
  No_Drug_Found: Port[art.Empty]
  ) extends Bridge {

  val ports : Bridge.Ports = Bridge.Ports(
    all = ISZ(Load_Drug_Library,
              Get_Drug_Record,
              The_Drug_Record,
              No_Drug_Found),

    dataIns = ISZ(),

    dataOuts = ISZ(),

    eventIns = ISZ(Load_Drug_Library,
                   Get_Drug_Record),

    eventOuts = ISZ(The_Drug_Record,
                    No_Drug_Found)
  )

  val initialization_api : drug_library_thread_imp_Initialization_Api = {
    val api = drug_library_thread_imp_Initialization_Api(
      id,
      Load_Drug_Library.id,
      Get_Drug_Record.id,
      The_Drug_Record.id,
      No_Drug_Found.id
    )
    drug_library_thread_imp_pump_operation_operation_process_drug_library_Bridge.c_initialization_api = Some(api)
    api
  }

  val operational_api : drug_library_thread_imp_Operational_Api = {
    val api = drug_library_thread_imp_Operational_Api(
      id,
      Load_Drug_Library.id,
      Get_Drug_Record.id,
      The_Drug_Record.id,
      No_Drug_Found.id
    )
    drug_library_thread_imp_pump_operation_operation_process_drug_library_Bridge.c_operational_api = Some(api)
    api
  }

  val entryPoints : Bridge.EntryPoints =
    drug_library_thread_imp_pump_operation_operation_process_drug_library_Bridge.EntryPoints(
      id,

      Load_Drug_Library.id,
      Get_Drug_Record.id,
      The_Drug_Record.id,
      No_Drug_Found.id,

      dispatchTriggers,

      initialization_api,
      operational_api)
}

object drug_library_thread_imp_pump_operation_operation_process_drug_library_Bridge {

  var c_initialization_api: Option[drug_library_thread_imp_Initialization_Api] = None()
  var c_operational_api: Option[drug_library_thread_imp_Operational_Api] = None()

  @record class EntryPoints(
    drug_library_thread_imp_pump_operation_operation_process_drug_library_BridgeId : Art.BridgeId,

    Load_Drug_Library_Id : Art.PortId,
    Get_Drug_Record_Id : Art.PortId,
    The_Drug_Record_Id : Art.PortId,
    No_Drug_Found_Id : Art.PortId,

    dispatchTriggers : Option[ISZ[Art.PortId]],

    initialization_api: drug_library_thread_imp_Initialization_Api,
    operational_api: drug_library_thread_imp_Operational_Api) extends Bridge.EntryPoints {

    val dataInPortIds: ISZ[Art.PortId] = ISZ()

    val eventInPortIds: ISZ[Art.PortId] = ISZ(Load_Drug_Library_Id,
                                              Get_Drug_Record_Id)

    val dataOutPortIds: ISZ[Art.PortId] = ISZ()

    val eventOutPortIds: ISZ[Art.PortId] = ISZ(The_Drug_Record_Id,
                                               No_Drug_Found_Id)

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
      val EventTriggered(receivedEvents) = Art.dispatchStatus(drug_library_thread_imp_pump_operation_operation_process_drug_library_BridgeId)

      // remove non-dispatching event ports
      val dispatchableEventPorts: ISZ[Art.PortId] =
        if(dispatchTriggers.isEmpty) receivedEvents
        else filter(receivedEvents, dispatchTriggers.get)

      Art.receiveInput(eventInPortIds, dataInPortIds)

      for(portId <- dispatchableEventPorts) {
        if(portId == Load_Drug_Library_Id){
          val Some(PCA_Types.Drug_Library_Payload(value)) = Art.getValue(Load_Drug_Library_Id)
          component.handleLoad_Drug_Library(operational_api, value)
        }
        else if(portId == Get_Drug_Record_Id){
          val Some(PCA_Types.Drug_Code_imp_Payload(value)) = Art.getValue(Get_Drug_Record_Id)
          component.handleGet_Drug_Record(operational_api, value)
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
      val EventTriggered(receivedEvents) = Art.dispatchStatus(drug_library_thread_imp_pump_operation_operation_process_drug_library_BridgeId)

      // remove non-dispatching event ports
      val dispatchableEventPorts: ISZ[Art.PortId] =
        if(dispatchTriggers.isEmpty) receivedEvents
        else filter(receivedEvents, dispatchTriggers.get)

      Art.receiveInput(eventInPortIds, dataInPortIds)

      for(portId <- dispatchableEventPorts) {
        if(portId == Load_Drug_Library_Id){
          val Some(PCA_Types.Drug_Library_Payload(value)) = Art.getValue(Load_Drug_Library_Id)
          component.handleLoad_Drug_Library(operational_api, value)
        }
        else if(portId == Get_Drug_Record_Id){
          val Some(PCA_Types.Drug_Code_imp_Payload(value)) = Art.getValue(Get_Drug_Record_Id)
          component.handleGet_Drug_Record(operational_api, value)
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