// #Sireum

package pca_pump.PCA_Control_Panel

import org.sireum._
import art._
import pca_pump._
import pca_pump.PCA_Control_Panel.{pca_speaker_imp_pump_operation_control_panel_audible => component}

// This file was auto-generated.  Do not edit

@record class pca_speaker_imp_pump_operation_control_panel_audible_Bridge(
  val id: Art.BridgeId,
  val name: String,
  val dispatchProtocol: DispatchPropertyProtocol,
  val dispatchTriggers: Option[ISZ[Art.PortId]],

  AudioSignal: Port[PCA_Types.Sound.Type],
  Sound: Port[PCA_Types.Sound.Type]
  ) extends Bridge {

  val ports : Bridge.Ports = Bridge.Ports(
    all = ISZ(AudioSignal,
              Sound),

    dataIns = ISZ(AudioSignal),

    dataOuts = ISZ(Sound),

    eventIns = ISZ(),

    eventOuts = ISZ()
  )

  val initialization_api : pca_speaker_imp_Initialization_Api = {
    val api = pca_speaker_imp_Initialization_Api(
      id,
      AudioSignal.id,
      Sound.id
    )
    pca_speaker_imp_pump_operation_control_panel_audible_Bridge.c_initialization_api = Some(api)
    api
  }

  val operational_api : pca_speaker_imp_Operational_Api = {
    val api = pca_speaker_imp_Operational_Api(
      id,
      AudioSignal.id,
      Sound.id
    )
    pca_speaker_imp_pump_operation_control_panel_audible_Bridge.c_operational_api = Some(api)
    api
  }

  val entryPoints : Bridge.EntryPoints =
    pca_speaker_imp_pump_operation_control_panel_audible_Bridge.EntryPoints(
      id,

      AudioSignal.id,
      Sound.id,

      dispatchTriggers,

      initialization_api,
      operational_api)
}

object pca_speaker_imp_pump_operation_control_panel_audible_Bridge {

  var c_initialization_api: Option[pca_speaker_imp_Initialization_Api] = None()
  var c_operational_api: Option[pca_speaker_imp_Operational_Api] = None()

  @record class EntryPoints(
    pca_speaker_imp_pump_operation_control_panel_audible_BridgeId : Art.BridgeId,

    AudioSignal_Id : Art.PortId,
    Sound_Id : Art.PortId,

    dispatchTriggers : Option[ISZ[Art.PortId]],

    initialization_api: pca_speaker_imp_Initialization_Api,
    operational_api: pca_speaker_imp_Operational_Api) extends Bridge.EntryPoints {

    val dataInPortIds: ISZ[Art.PortId] = ISZ(AudioSignal_Id)

    val eventInPortIds: ISZ[Art.PortId] = ISZ()

    val dataOutPortIds: ISZ[Art.PortId] = ISZ(Sound_Id)

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