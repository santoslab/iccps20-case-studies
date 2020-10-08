// #Sireum

package pca_pump.PCA_Operation

import org.sireum._
import pca_pump._

/* req: PCA Pump Interfaces: Logging {@link https://www.smarturl.it/OPCA#subsec_logging}
   (2) The PCA pump shall maintain an electronic event log to record each action taken by the pump
       and each event sensed of its environment. (no UC or EC specific to logging)
   TODO
   (4) The patient’s prescription shall be retained for at least \delta_{data} = 96 hours after the PCA pump is
       turned-off and unplugged.
   TODO
   (5) Information in event and Fault Logs shall be retained90 for at least \delta_{log} = 1000 hours after the
       PCA pump is turned-off and unplugged.
   TODO
   (6) The event log shall record 30 days of typical events before overwriting oldest event records first.
   req: Event Logger Thread {@link https://www.smarturl.it/OPCA#subsubsec_eventloggerthread
 */

// This file will not be overwritten so is safe to edit
object event_logger_thread_imp_pump_operation_operation_process_event_logger {

  var log: ISZ[PCA_Types.Event_Record] = ISZ()

  def initialise(api: event_logger_thread_imp_Initialization_Api): Unit = {}

  def handleLog_Event(api: event_logger_thread_imp_Operational_Api, value : PCA_Types.Event_Record): Unit = {
    api.logInfo(s"received ${value}")

    log = log :+ value
  }

  def handleGet_Event_Log(api: event_logger_thread_imp_Operational_Api): Unit = {
    api.logInfo("received Get_Event_Log")

    api.sendThe_Event_Log(PCA_Types.Event_Log(log))
  }

  def activate(api: event_logger_thread_imp_Operational_Api): Unit = { }

  def deactivate(api: event_logger_thread_imp_Operational_Api): Unit = { }

  def finalise(api: event_logger_thread_imp_Operational_Api): Unit = { }

  def recover(api: event_logger_thread_imp_Operational_Api): Unit = { }
}
