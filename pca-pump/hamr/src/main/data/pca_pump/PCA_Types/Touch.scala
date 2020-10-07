// #Sireum

package pca_pump.PCA_Types

import org.sireum._
import pca_pump._

@datatype trait Touch

@datatype class SimpleButton_Touch(val buttonId: PCA_Types.Button_Id.Type)
  extends Touch

@datatype class SquareBolusDuration_Touch(val duration: ICE_Types.Minute_imp)
  extends Touch


@datatype class Touch_Payload(value: Touch) extends art.DataContent