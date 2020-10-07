// #Sireum

package pca_pump.PCA_Mechanical

import org.sireum._
import pca_pump._
import pca_pump.util.{ArtSystem, PCA_Constants}
import org.sireum.conversions.N16

// This file will not be overwritten so is safe to edit
object drug_reservoir_imp_pump_fluid_reservoir {

  val debugKey: String = "reservoir_impl"

  // convert N16 constants to F32 constants
  val Reservoir_Empty_Limit: F32 = ArtSystem.zToF(N16.toZ(PCA_Constants.Reservoir_Empty_Limit))
  val Reservoir_Low_Limit: F32 = ArtSystem.zToF(N16.toZ(PCA_Constants.Reservoir_Low_Limit))

  //@debugObject // when deploying (e.g. compiling to C), convert record's fields into local vars
  val state: Wrapper = Wrapper(
    volume = Physical_Types.Fluid_Volume_imp(0f),
    doorOpen = T)

  var last_Fill_Reservoir: Option[Physical_Types.Fluid_Volume_imp] = None[Physical_Types.Fluid_Volume_imp]()
  var lastDoorState: B = getDoorState()

  def initialise(api: drug_reservoir_imp_Initialization_Api): Unit = {
    // invariant
    assert(Reservoir_Empty_Limit < Reservoir_Low_Limit)

    art.ArtDebug.setDebugObject(debugKey, state)
  }

  def timeTriggered(api: drug_reservoir_imp_Operational_Api): Unit = {
    if(api.getFill_Reservoir() != last_Fill_Reservoir) {
      // NOTE: nothing is connected to Fill_Reservoir.  Assuming it's an external event

      // TODO: can reservoir be refilled?
      assert(last_Fill_Reservoir.isEmpty)
      assert(api.getFill_Reservoir().nonEmpty)

      state.volume = api.getFill_Reservoir().get

      last_Fill_Reservoir = api.getFill_Reservoir()
    }


    if(last_Fill_Reservoir.nonEmpty) {
      if (state.volume.value <= Reservoir_Empty_Limit) {
        api.sendEmpty_Reservoir()
      }
      else if (state.volume.value <= Reservoir_Low_Limit) {
        api.sendLow_Reservoir()
      }
    }

    val isDoorOpen = getDoorState()
    if(lastDoorState != isDoorOpen) {
      api.logInfo("Detected change in door state")
      lastDoorState = isDoorOpen
      api.setDoor_Open(state.doorOpen)
      if(!isDoorOpen){
        api.sendDoor_Closed()
      }
    }
  }

  def getDoorState(): B = {
    // fetch door bit
    return state.doorOpen
  }

  def activate(api: drug_reservoir_imp_Operational_Api): Unit = { }

  def deactivate(api: drug_reservoir_imp_Operational_Api): Unit = { }

  def finalise(api: drug_reservoir_imp_Operational_Api): Unit = { }

  def recover(api: drug_reservoir_imp_Operational_Api): Unit = { }
}

@record class Wrapper(var volume: Physical_Types.Fluid_Volume_imp,
                      var doorOpen: B)