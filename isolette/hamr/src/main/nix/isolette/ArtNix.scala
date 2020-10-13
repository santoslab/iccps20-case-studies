// #Sireum

package isolette

import org.sireum._
import art._

// This file was auto-generated.  Do not edit

object ArtNix {

  val maxPortIds: Art.PortId = IPCPorts.Main + 1
  val timeTriggered: TimeTriggered = TimeTriggered()
  val noData: Option[DataContent] = None()
  val data: MS[Art.PortId, Option[DataContent]] = MS.create(maxPortIds, noData)
  val connection: MS[Art.PortId, ISZ[(Art.PortId, Art.PortId)]] = {
    val r = MS.create[Art.PortId, ISZ[(Art.PortId, Art.PortId)]](maxPortIds, ISZ())

    r(Arch.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit.displayed_temp.id) = ISZ(
      (IPCPorts.operator_interface_thread_impl_operator_interface_oip_oit_App, Arch.isolette_single_sensor_Instance_operator_interface_oip_oit.display_temperature.id)
    )
    r(Arch.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit.regulator_status.id) = ISZ(
      (IPCPorts.operator_interface_thread_impl_operator_interface_oip_oit_App, Arch.isolette_single_sensor_Instance_operator_interface_oip_oit.regulator_status.id)
    )
    r(Arch.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_heat_source_mhst.heat_control.id) = ISZ(
      (IPCPorts.Heat_Source_impl_heat_source_cpi_heat_controller_App, Arch.isolette_single_sensor_Instance_heat_source_cpi_heat_controller.heat_control.id)
    )
    r(Arch.isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_alarm_mat.alarm_control.id) = ISZ(
      (IPCPorts.operator_interface_thread_impl_operator_interface_oip_oit_App, Arch.isolette_single_sensor_Instance_operator_interface_oip_oit.alarm_control.id)
    )
    r(Arch.isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_interface_mmit.monitor_status.id) = ISZ(
      (IPCPorts.operator_interface_thread_impl_operator_interface_oip_oit_App, Arch.isolette_single_sensor_Instance_operator_interface_oip_oit.monitor_status.id)
    )
    r(Arch.isolette_single_sensor_Instance_operator_interface_oip_oit.lower_desired_tempWstatus.id) = ISZ(
      (IPCPorts.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_App, Arch.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit.lower_desired_tempWstatus.id)
    )
    r(Arch.isolette_single_sensor_Instance_operator_interface_oip_oit.upper_desired_tempWstatus.id) = ISZ(
      (IPCPorts.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_App, Arch.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit.upper_desired_tempWstatus.id)
    )
    r(Arch.isolette_single_sensor_Instance_operator_interface_oip_oit.upper_alarm_tempWstatus.id) = ISZ(
      (IPCPorts.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_mmit_App, Arch.isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_interface_mmit.upper_alarm_tempWstatus.id),
      (IPCPorts.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_mmit_App, Arch.isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_interface_mmit.lower_alarm_tempWstatus.id)
    )
    r(Arch.isolette_single_sensor_Instance_temperature_sensor_cpi_thermostat.current_tempWstatus.id) = ISZ(
      (IPCPorts.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_mmit_App, Arch.isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_interface_mmit.current_tempWstatus.id),
      (IPCPorts.Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_mat_App, Arch.isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_alarm_mat.current_tempWstatus.id),
      (IPCPorts.Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_mmmt_App, Arch.isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_mode_mmmt.current_tempWstatus.id),
      (IPCPorts.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_App, Arch.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit.current_tempWstatus.id),
      (IPCPorts.Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_mhst_App, Arch.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_heat_source_mhst.current_tempWstatus.id),
      (IPCPorts.Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode_mrmt_App, Arch.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_mode_mrmt.current_tempWstatus.id)
    )
    r(Arch.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit.upper_desired_temp.id) = ISZ(
      (IPCPorts.Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_mhst_App, Arch.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_heat_source_mhst.upper_desired_temp.id)
    )
    r(Arch.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit.lower_desired_temp.id) = ISZ(
      (IPCPorts.Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_mhst_App, Arch.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_heat_source_mhst.lower_desired_temp.id)
    )
    r(Arch.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit.interface_failure.id) = ISZ(
      (IPCPorts.Manage_Regulator_Mode_impl_thermostat_regulate_temperature_manage_regulator_mode_mrmt_App, Arch.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_mode_mrmt.interface_failure.id)
    )
    r(Arch.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_mode_mrmt.regulator_mode.id) = ISZ(
      (IPCPorts.Manage_Regulator_Interface_impl_thermostat_regulate_temperature_manage_regulator_interface_mrit_App, Arch.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_regulator_interface_mrit.regulator_mode.id),
      (IPCPorts.Manage_Heat_Source_impl_thermostat_regulate_temperature_manage_heat_source_mhst_App, Arch.isolette_single_sensor_Instance_thermostat_regulate_temperature_manage_heat_source_mhst.regulator_mode.id)
    )
    r(Arch.isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_interface_mmit.upper_alarm_temp.id) = ISZ(
      (IPCPorts.Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_mat_App, Arch.isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_alarm_mat.upper_alarm_temp.id)
    )
    r(Arch.isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_interface_mmit.lower_alarm_temp.id) = ISZ(
      (IPCPorts.Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_mat_App, Arch.isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_alarm_mat.lower_alarm_temp.id)
    )
    r(Arch.isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_interface_mmit.interface_failure.id) = ISZ(
      (IPCPorts.Manage_Monitor_Mode_impl_thermostat_monitor_temperature_manage_monitor_mode_mmmt_App, Arch.isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_mode_mmmt.interface_failure.id)
    )
    r(Arch.isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_mode_mmmt.monitor_mode.id) = ISZ(
      (IPCPorts.Manage_Monitor_Interface_impl_thermostat_monitor_temperature_manage_monitor_interface_mmit_App, Arch.isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_monitor_interface_mmit.monitor_mode.id),
      (IPCPorts.Manage_Alarm_impl_thermostat_monitor_temperature_manage_alarm_mat_App, Arch.isolette_single_sensor_Instance_thermostat_monitor_temperature_manage_alarm_mat.monitor_mode.id)
    )

    r
  }
  val eventInPorts: MS[Z, Art.PortId] = MSZ(
  )
  var frozen: MS[Art.PortId, Option[DataContent]] = MS.create(maxPortIds, noData)
  var outgoing: MS[Art.PortId, Option[DataContent]] = MS.create(maxPortIds, noData)
  var isTimeDispatch: B = F

  def updateData(port: Art.PortId, d: DataContent): Unit = {
    data(port) = Some(d)
  }

  def timeDispatch(): Unit = {
    isTimeDispatch = T
  }

  def eventDispatch(): Unit = {
    isTimeDispatch = F
  }

  def dispatchStatus(bridgeId: Art.BridgeId): DispatchStatus = {
    if (isTimeDispatch) {
      return timeTriggered
    } else {
      var r = ISZ[Art.PortId]()
      for (i <- eventInPorts if data(i).nonEmpty) {
        r = r :+ i
      }
      return EventTriggered(r)
    }
  }

  def receiveInput(eventPortIds: ISZ[Art.PortId], dataPortIds: ISZ[Art.PortId]): Unit = {
    frozen = data
    for (i <- eventPortIds) {
      data(i) = noData
    }
  }

  def putValue(portId: Art.PortId, data: DataContent): Unit = {
    outgoing(portId) = Some(data)
  }

  def getValue(portId: Art.PortId): Option[DataContent] = {
    return frozen(portId)
  }

  def sendOutput(eventPortIds: ISZ[Art.PortId], dataPortIds: ISZ[Art.PortId]): Unit = {
    for (p <- dataPortIds) {
      outgoing(p) match {
        case Some(d) =>
          outgoing(p) = noData
          for(e <- connection(p)){
            Platform.sendAsync(e._1, e._2, d)
          }
        case _ =>
      }
    }

    for (p <- eventPortIds) {
      outgoing(p) match {
        case Some(d) =>
          outgoing(p) = noData
          for(e <- connection(p)){
            Platform.sendAsync(e._1, e._2, d)
          }
        case _ =>
      }
    }
  }

  def logInfo(title: String, msg: String): Unit = {
    print(title)
    print(": ")
    println(msg)
  }

  def logError(title: String, msg: String): Unit = {
    eprint(title)
    eprint(": ")
    eprintln(msg)
  }

  def logDebug(title: String, msg: String): Unit = {
    print(title)
    print(": ")
    println(msg)
  }

  def run(): Unit = {
  }

  def time(): Art.Time = {
    return Process.time()
  }
}
