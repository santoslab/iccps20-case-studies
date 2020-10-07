// #Sireum

package pca_pump.PCA_Types

import org.sireum._

@datatype class Image(l : ISZ[Image_Type]){}

@datatype trait Image_Type

@datatype class Alarm_Image(s: String) extends Image_Type

@datatype class Message_Image(s: String) extends Image_Type

@datatype class SystemStatus_Image(s: String) extends Image_Type

@datatype class DrugName_Image(s: String) extends Image_Type

@datatype class DrugConcentration_Image(s: String) extends Image_Type

@datatype class InfusionFlowRate_Image(s: String) extends Image_Type

//@datatype class ImageList(l : ISZ[Image]) extends Image

@datatype class Image_Payload(value: Image) extends art.DataContent