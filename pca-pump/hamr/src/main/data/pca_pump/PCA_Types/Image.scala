// #Sireum

package pca_pump.PCA_Types

import org.sireum._
import pca_pump._

object Image {
  def empty(): PCA_Types.Image = {
    return PCA_Types.Image()
  }
}

@datatype class Image() // type skeleton

object Image_Payload {
  def empty(): Image_Payload = {
    return Image_Payload(PCA_Types.Image.empty())
  }
}

@datatype class Image_Payload(value: PCA_Types.Image) extends art.DataContent
