// #Sireum

package isolette

import org.sireum._

// This file will not be overwritten so is safe to edit

object TranspilerToucher {
  def touch(): Unit = {
    // touch types used by Slang extension setters in UserInterface.Interface,
    // but that are not likely used by the other isolated components
    val ui_option_status_some_type: Option[Isolette_Data_Model.Status.Type] = Some(Isolette_Data_Model.Status.Init_Status)
    val ui_option_status_none_type: Option[Isolette_Data_Model.Status.Type] = None()

    val ui_option_temp_impl_some_type: Option[Isolette_Data_Model.Temp_impl] = Some(Isolette_Data_Model.Temp_impl.empty())
    val ui_option_temp_impl_none_type: Option[Isolette_Data_Model.Temp_impl] = None()

    val ui_option_on_off_some_type: Option[Isolette_Data_Model.On_Off.Type] = Some(Isolette_Data_Model.On_Off.Off)
    val ui_option_on_off_none_type: Option[Isolette_Data_Model.On_Off.Type] = None()
  }
}
