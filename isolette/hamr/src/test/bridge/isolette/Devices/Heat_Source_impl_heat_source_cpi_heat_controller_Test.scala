package isolette.Devices

import art.{ArtNative_Ext, Empty}
import isolette._
import org.sireum._

// This file will not be overwritten so is safe to edit
class Heat_Source_impl_heat_source_cpi_heat_controller_Test extends BridgeTestSuite[Heat_Source_impl_heat_source_cpi_heat_controller_Bridge](Arch.isolette_single_sensor_Instance_heat_source_cpi_heat_controller) {
  test("Example Unit Test"){
    executeTest()
  }

  //////////////////////
  // HELPER FUNCTIONS //
  //////////////////////

  // setter for in DataPort
  def put_heat_control(value : Isolette_Data_Model.On_Off.Type): Unit = {
    ArtNative_Ext.insertInPortValue(bridge.operational_api.heat_control_Id, Isolette_Data_Model.On_Off_Payload(value))
  }

  // getter for out DataPort
  def get_heat_out(): Option[Isolette_Environment.Heat.Type] = {
    val value: Option[Isolette_Environment.Heat.Type] = get_heat_out_payload() match {
      case Some(Isolette_Environment.Heat_Payload(v)) => Some(v)
      case Some(v) => fail(s"Unexpected payload on port heat_out.  Expecting 'Isolette_Environment.Heat_Payload' but received ${v}")
      case _ => None[Isolette_Environment.Heat.Type]()
    }
    return value
  }

  // payload getter for out DataPort
  def get_heat_out_payload(): Option[Isolette_Environment.Heat_Payload] = {
    return ArtNative_Ext.observeOutPortValue(bridge.initialization_api.heat_out_Id).asInstanceOf[Option[Isolette_Environment.Heat_Payload]]
  }

}
