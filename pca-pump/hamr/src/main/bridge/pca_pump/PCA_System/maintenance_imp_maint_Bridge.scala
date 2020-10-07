// #Sireum

package pca_pump.PCA_System

import org.sireum._
import art._
import pca_pump._
import pca_pump.PCA_System.{maintenance_imp_maint => component}

// This file was auto-generated.  Do not edit

@record class maintenance_imp_maint_Bridge(
  val id: Art.BridgeId,
  val name: String,
  val dispatchProtocol: DispatchPropertyProtocol,
  val dispatchTriggers: Option[ISZ[Art.PortId]],

  The_Fault_Log: Port[PCA_Types.Fault_Log],
  The_Event_Log: Port[PCA_Types.Event_Log],
  Load_Drug_Library: Port[PCA_Types.Drug_Library],
  Get_Fault_Log: Port[art.Empty],
  Get_Event_Log: Port[art.Empty]
  ) extends Bridge {

  val ports : Bridge.Ports = Bridge.Ports(
    all = ISZ(The_Fault_Log,
              The_Event_Log,
              Load_Drug_Library,
              Get_Fault_Log,
              Get_Event_Log),

    dataIns = ISZ(),

    dataOuts = ISZ(),

    eventIns = ISZ(The_Fault_Log,
                   The_Event_Log),

    eventOuts = ISZ(Load_Drug_Library,
                    Get_Fault_Log,
                    Get_Event_Log)
  )

  val initialization_api : maintenance_imp_Initialization_Api = {
    val api = maintenance_imp_Initialization_Api(
      id,
      The_Fault_Log.id,
      The_Event_Log.id,
      Load_Drug_Library.id,
      Get_Fault_Log.id,
      Get_Event_Log.id
    )
    maintenance_imp_maint_Bridge.c_initialization_api = Some(api)
    api
  }

  val operational_api : maintenance_imp_Operational_Api = {
    val api = maintenance_imp_Operational_Api(
      id,
      The_Fault_Log.id,
      The_Event_Log.id,
      Load_Drug_Library.id,
      Get_Fault_Log.id,
      Get_Event_Log.id
    )
    maintenance_imp_maint_Bridge.c_operational_api = Some(api)
    api
  }

  val entryPoints : Bridge.EntryPoints =
    maintenance_imp_maint_Bridge.EntryPoints(
      id,

      The_Fault_Log.id,
      The_Event_Log.id,
      Load_Drug_Library.id,
      Get_Fault_Log.id,
      Get_Event_Log.id,

      dispatchTriggers,

      initialization_api,
      operational_api)
}

object maintenance_imp_maint_Bridge {

  var c_initialization_api: Option[maintenance_imp_Initialization_Api] = None()
  var c_operational_api: Option[maintenance_imp_Operational_Api] = None()

  @record class EntryPoints(
    maintenance_imp_maint_BridgeId : Art.BridgeId,

    The_Fault_Log_Id : Art.PortId,
    The_Event_Log_Id : Art.PortId,
    Load_Drug_Library_Id : Art.PortId,
    Get_Fault_Log_Id : Art.PortId,
    Get_Event_Log_Id : Art.PortId,

    dispatchTriggers : Option[ISZ[Art.PortId]],

    initialization_api: maintenance_imp_Initialization_Api,
    operational_api: maintenance_imp_Operational_Api) extends Bridge.EntryPoints {

    val dataInPortIds: ISZ[Art.PortId] = ISZ()

    val eventInPortIds: ISZ[Art.PortId] = ISZ(The_Fault_Log_Id,
                                              The_Event_Log_Id)

    val dataOutPortIds: ISZ[Art.PortId] = ISZ()

    val eventOutPortIds: ISZ[Art.PortId] = ISZ(Load_Drug_Library_Id,
                                               Get_Fault_Log_Id,
                                               Get_Event_Log_Id)

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