// #Sireum

package b.SlangTypeLibrary

import org.sireum._
import art._
import b._

object SlangTypeLibrary extends App {
  def main(args: ISZ[String]): Z = {

    // touch each payload/type in case some are only used as a field in a record
    def printDataContent(a: art.DataContent): Unit = { println(s"${a}") }

    printDataContent(Base_Types.Float_32_Payload(Base_Types.Float_32_empty()))
    printDataContent(TemperatureControl.TempUnit_Payload(TemperatureControl.TempUnit.byOrdinal(0).get))
    printDataContent(TemperatureControl.Temperature_i_Payload(TemperatureControl.Temperature_i.empty()))
    printDataContent(TemperatureControl.SetPoint_i_Payload(TemperatureControl.SetPoint_i.empty()))
    printDataContent(TemperatureControl.FanAck_Payload(TemperatureControl.FanAck.byOrdinal(0).get))
    printDataContent(TemperatureControl.FanCmd_Payload(TemperatureControl.FanCmd.byOrdinal(0).get))
    printDataContent(art.Empty())

    return 0
  }
}
