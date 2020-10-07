// #Sireum

package pca_pump.util

import org.sireum._
import pca_pump._

@ext object ArtSystem {
  def zToF(z : Z) : F32 = $

  def fToZ(f : F32) : Z = $

  def assertThat(cond: B, message: String, id: art.Art.BridgeId) : Unit = $
}