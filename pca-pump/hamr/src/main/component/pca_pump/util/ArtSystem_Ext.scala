package pca_pump.util

import org.sireum._
import pca_pump._

object ArtSystem_Ext {

  def zToF(z : Z) : F32 = {
    return z.toMP.toLong * 1.0f
  }

  def fToZ(f : F32) : Z = {
    return f.native.toInt
  }

  def assertThat(cond: B, message: String, id: art.Art.BridgeId) : Unit = {
    if (!cond) {
      art.Art.logError(id, message)
    }
  }
}