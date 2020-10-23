#ifndef SP_TEMPERATURECONTROL__TEMPERATURE_I_H
#define SP_TEMPERATURECONTROL__TEMPERATURE_I_H

#include <sb_types.h>
#include <seqNum.h>

// Sampling port message with bool data
typedef struct sp_TemperatureControl__Temperature_i {

  // The sampling port message data.
  //
  TemperatureControl__Temperature_i data;

  // Sequence number incremented by the writer every time the sampling port is
  // written. Read by the receiver to detect dropped messages and incoherent
  // message reads.  An incoherent message is one that is formed of parts of
  // more than one message.  An incoherent message can occur when writing
  // happens during read. If the component runs long enough, this counter
  // will wrap back to zero.  This causes no problems unless the receiver is
  // delayed for the wrap time. In that case the receiver may not detect
  // dropped or incoherent message. But if the receiver is delayed for that
  // long the system is probably in a very bad state. Also see DIRTY_SEQ_NUM
  // above.
  //
  // TODO: Currently using ggc builtin _Atomic. Would like to use c11 std, but
  // have not figured out how to do this int the seL4 cmake build environment.
  _Atomic seqNum_t seqNum;  

} sp_TemperatureControl__Temperature_i_t;

void init_sp_TemperatureControl__Temperature_i(sp_TemperatureControl__Temperature_i_t *port, seqNum_t *seqNum);

bool write_sp_TemperatureControl__Temperature_i(sp_TemperatureControl__Temperature_i_t *port, const TemperatureControl__Temperature_i *data, seqNum_t *seqNum);

bool read_sp_TemperatureControl__Temperature_i(sp_TemperatureControl__Temperature_i_t *port, TemperatureControl__Temperature_i *data, seqNum_t *seqNum);

bool is_empty_sp_TemperatureControl__Temperature_i(sp_TemperatureControl__Temperature_i_t *port);

#endif
