// #Sireum

package building_control_gen_mixed.BuildingControl

import org.sireum._
import building_control_gen_mixed._

// This file was auto-generated.  Do not edit

@msig trait TempSensor_i {

  def api : TempSensor_i_Bridge.Api

  def timeTriggered() : Unit = {}

  def activate(): Unit = {}

  def deactivate(): Unit = {}

  def finalise(): Unit = {}

  def initialise(): Unit = {}

  def recover(): Unit = {}
}