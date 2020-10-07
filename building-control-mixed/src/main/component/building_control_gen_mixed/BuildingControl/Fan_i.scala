// #Sireum

package building_control_gen_mixed.BuildingControl

import org.sireum._
import building_control_gen_mixed._

// This file was auto-generated.  Do not edit

@msig trait Fan_i {

  def api : Fan_i_Bridge.Api

  def handlefanCmd(value : BuildingControl.FanCmd.Type): Unit = {
    api.logInfo("default handlefanCmd implementation")
    api.logInfo(s"received ${value}")
  }

  def activate(): Unit = {}

  def deactivate(): Unit = {}

  def finalise(): Unit = {}

  def initialise(): Unit = {}

  def recover(): Unit = {}
}