// #Sireum

package building_control_gen_mixed.BuildingControl

import org.sireum._
import building_control_gen_mixed._

// This file was auto-generated.  Do not edit

@msig trait TempControl_i {

  def api : TempControl_i_Bridge.Api

  def handlefanAck(value : BuildingControl.FanAck.Type): Unit = {
    api.logInfo("default handlefanAck implementation")
    api.logInfo(s"received ${value}")
  }

  def handlesetPoint(value : BuildingControl.SetPoint_i): Unit = {
    api.logInfo("default handlesetPoint implementation")
    api.logInfo(s"received ${value}")
  }

  def handletempChanged(): Unit = {
    api.logInfo("default handletempChanged implementation")
    api.logInfo("received tempChanged")
  }

  def activate(): Unit = {}

  def deactivate(): Unit = {}

  def finalise(): Unit = {}

  def initialise(): Unit = {}

  def recover(): Unit = {}
}