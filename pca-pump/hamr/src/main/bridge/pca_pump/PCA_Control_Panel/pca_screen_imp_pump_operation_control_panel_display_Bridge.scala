// #Sireum

package pca_pump.PCA_Control_Panel

import org.sireum._
import art._
import pca_pump._
import pca_pump.PCA_Control_Panel.{pca_screen_imp_pump_operation_control_panel_display => component}

// This file was auto-generated.  Do not edit

@record class pca_screen_imp_pump_operation_control_panel_display_Bridge(
  val id: Art.BridgeId,
  val name: String,
  val dispatchProtocol: DispatchPropertyProtocol,
  val dispatchTriggers: Option[ISZ[Art.PortId]],

  Image: Port[PCA_Types.Image],
  LightToEye: Port[Base_Types.Boolean],
  Touch: Port[PCA_Types.Touch],
  Finger_Press: Port[Base_Types.Boolean]
  ) extends Bridge {

  val ports : Bridge.Ports = Bridge.Ports(
    all = ISZ(Image,
              LightToEye,
              Touch,
              Finger_Press),

    dataIns = ISZ(Image),

    dataOuts = ISZ(LightToEye),

    eventIns = ISZ(Finger_Press),

    eventOuts = ISZ(Touch)
  )

  val initialization_api : pca_screen_imp_Initialization_Api = {
    val api = pca_screen_imp_Initialization_Api(
      id,
      Image.id,
      LightToEye.id,
      Touch.id,
      Finger_Press.id
    )
    pca_screen_imp_pump_operation_control_panel_display_Bridge.c_initialization_api = Some(api)
    api
  }

  val operational_api : pca_screen_imp_Operational_Api = {
    val api = pca_screen_imp_Operational_Api(
      id,
      Image.id,
      LightToEye.id,
      Touch.id,
      Finger_Press.id
    )
    pca_screen_imp_pump_operation_control_panel_display_Bridge.c_operational_api = Some(api)
    api
  }

  val entryPoints : Bridge.EntryPoints =
    pca_screen_imp_pump_operation_control_panel_display_Bridge.EntryPoints(
      id,

      Image.id,
      LightToEye.id,
      Touch.id,
      Finger_Press.id,

      dispatchTriggers,

      initialization_api,
      operational_api)
}

object pca_screen_imp_pump_operation_control_panel_display_Bridge {

  var c_initialization_api: Option[pca_screen_imp_Initialization_Api] = None()
  var c_operational_api: Option[pca_screen_imp_Operational_Api] = None()

  @record class EntryPoints(
    pca_screen_imp_pump_operation_control_panel_display_BridgeId : Art.BridgeId,

    Image_Id : Art.PortId,
    LightToEye_Id : Art.PortId,
    Touch_Id : Art.PortId,
    Finger_Press_Id : Art.PortId,

    dispatchTriggers : Option[ISZ[Art.PortId]],

    initialization_api: pca_screen_imp_Initialization_Api,
    operational_api: pca_screen_imp_Operational_Api) extends Bridge.EntryPoints {

    val dataInPortIds: ISZ[Art.PortId] = ISZ(Image_Id)

    val eventInPortIds: ISZ[Art.PortId] = ISZ(Finger_Press_Id)

    val dataOutPortIds: ISZ[Art.PortId] = ISZ(LightToEye_Id)

    val eventOutPortIds: ISZ[Art.PortId] = ISZ(Touch_Id)

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