// #Sireum

package isolette.SlangTypeLibrary

import org.sireum._
import art._
import isolette._

object SlangTypeLibrary extends App {
  def main(args: ISZ[String]): Z = {

    // touch each payload/type in case some are only used as a field in a record
    def printDataContent(a: art.DataContent): Unit = { println(s"${a}") }

    printDataContent(Isolette_Environment.Heat_Payload(Isolette_Environment.Heat.byOrdinal(0).get))
    printDataContent(Isolette_Environment.Interface_Interaction_Payload(Isolette_Environment.Interface_Interaction.byOrdinal(0).get))
    printDataContent(Base_Types.Float_32_Payload(Base_Types.Float_32_empty()))
    printDataContent(Isolette_Data_Model.PhysicalTemp_impl_Payload(Isolette_Data_Model.PhysicalTemp_impl.empty()))
    printDataContent(Isolette_Data_Model.ValueStatus_Payload(Isolette_Data_Model.ValueStatus.byOrdinal(0).get))
    printDataContent(Isolette_Data_Model.TempWstatus_impl_Payload(Isolette_Data_Model.TempWstatus_impl.empty()))
    printDataContent(Isolette_Data_Model.On_Off_Payload(Isolette_Data_Model.On_Off.byOrdinal(0).get))
    printDataContent(Isolette_Data_Model.Status_Payload(Isolette_Data_Model.Status.byOrdinal(0).get))
    printDataContent(Isolette_Data_Model.Temp_impl_Payload(Isolette_Data_Model.Temp_impl.empty()))
    printDataContent(Isolette_Data_Model.Regulator_Mode_Payload(Isolette_Data_Model.Regulator_Mode.byOrdinal(0).get))
    printDataContent(Base_Types.Boolean_Payload(Base_Types.Boolean_empty()))
    printDataContent(Isolette_Data_Model.Failure_Flag_impl_Payload(Isolette_Data_Model.Failure_Flag_impl.empty()))
    printDataContent(Isolette_Data_Model.Monitor_Mode_Payload(Isolette_Data_Model.Monitor_Mode.byOrdinal(0).get))
    printDataContent(art.Empty())

    return 0
  }
}
