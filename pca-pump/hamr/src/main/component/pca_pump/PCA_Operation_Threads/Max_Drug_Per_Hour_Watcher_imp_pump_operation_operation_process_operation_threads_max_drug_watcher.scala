// #Sireum

package pca_pump.PCA_Operation_Threads

import org.sireum._
import art.Art
import pca_pump._
import pca_pump.util.ArtSystem

// This file will not be overwritten so is safe to edit
object Max_Drug_Per_Hour_Watcher_imp_pump_operation_operation_process_operation_threads_max_drug_watcher {

  // FIXME: add period to trait?
  val period : Art.Time = 1000 // 1 second

  val msInHours : Z = 1000 * 60 * 60

  // number of slots per hour
  val size : Z = msInHours / period // => 3600

  // length of time for each period
  val interval : F32 = zToF(period) / zToF(msInHours) // => 1/3600

  // one slot for each period
  val data : MSZ[F32] = MSZ.create(size, 0f)

  var first : Z = 0
  var last : Z = 0

  def initialise(api: Max_Drug_Per_Hour_Watcher_imp_Initialization_Api): Unit = {}

  def timeTriggered(api: Max_Drug_Per_Hour_Watcher_imp_Operational_Api): Unit = {
    if(api.getMax_Drug_Per_Hour().isEmpty){
      // FIXME: do nothing if max never set?
      return
    }

    // FIXME:
    //   1) Infusion_Flow_Rate will be non-empty during priming.  Need to know when infusion actually begins
    //   2) Would calculations ever need to be reset?  Would that be accomplished by just turning pump off?
    if(api.getInfusion_Flow_Rate().nonEmpty) {
      // calculate milliliters delivered during last interval
      data(last) = s16ToF(api.getInfusion_Flow_Rate().get.value) * interval
      last = (last + 1) % size
      if(last == first) {
        first = (first + 1) % size
      }

      var i : Z = first
      var sum : F32 = 0f
      while((i % size) != last){
        sum = sum + data(i % size)
        i = i + 1
      }

      if(last % 100 == 0) {
        //api.logInfo(s"first = $first")
        //api.logInfo(s"last = $last")
        //api.logInfo(s"sum = ${sum.value}")
      }

      val max: S16 = api.getMax_Drug_Per_Hour().get.value
      //val nearMax = max - ??? // FIXME

      if(sum > s16ToF(max)) {
        api.logInfo(s"Pumped $sum ml in last hour which exceeds max ($max ml)")
        api.sendOver_Max_Drug_Per_Hour()
      }
      //else if(sum > c(nearMax)) {
      //  api.sendNear_Max_Drug_Per_Hour(Slang_Types.Empty())
      //}
    }
  }

  def s16ToF(s : S16) : F32 = {
    return ArtSystem.zToF(conversions.S16.toZ(s))
  }

  def zToF(z : Z) : F32 = {
    return ArtSystem.zToF(z)
  }

  def activate(api: Max_Drug_Per_Hour_Watcher_imp_Operational_Api): Unit = { }

  def deactivate(api: Max_Drug_Per_Hour_Watcher_imp_Operational_Api): Unit = { }

  def finalise(api: Max_Drug_Per_Hour_Watcher_imp_Operational_Api): Unit = { }

  def recover(api: Max_Drug_Per_Hour_Watcher_imp_Operational_Api): Unit = { }
}
