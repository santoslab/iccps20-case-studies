# temperature-control

 Table of Contents
  * [Diagrams](#diagrams)
    * [AADL Arch](#aadl-arch)
    * [SeL4](#sel4)
      * [SeL4 CAmkES Arch](#sel4-camkes-arch)
      * [SeL4 CAmkES HAMR Arch](#sel4-camkes-hamr-arch)
  * [Example Output](#example-output)
    * [SeL4 Expected Output: Timeout = 15 seconds](#sel4-expected-output-timeout--15-seconds)

## Diagrams
### AADL Arch
![AADL Arch](aadl/diagrams/aadl-arch.png)

### SeL4
#### SeL4 CAmkES Arch
![SeL4 CAmkES Arch](aadl/diagrams/CAmkES-arch-SeL4.svg)

#### SeL4 CAmkES HAMR Arch
![SeL4 CAmkES HAMR Arch](aadl/diagrams/CAmkES-HAMR-arch-SeL4.svg)

## Example Output
*NOTE:* actual output may differ due to issues related to thread interleaving
### SeL4 Expected Output: Timeout = 15 seconds

  |HAMR Codegen Configuration| |
  |--|--|
  | package-name | b |
  | exclude-component-impl | true |
  | bit-width | 32 |
  | max-string-size | 256 |
  | max-array-size | 1 |


  **How To Run**
  ```
  temperature-control/hamr/bin/transpile-sel4.sh
  temperature-control/hamr/src/c/CAmkES_seL4/bin/run-camkes.sh -s
  ```

  ```
  Booting all finished, dropped to user space
  Entering pre-init of TempSensor_i_p_tempSensor
  Entering pre-init of TempControl_i_p_tempControl
  Art: RegistEntering pre-init of Fan_i_p_fan
  Art: Registered component: TempControlSystem_i_IArt: Registered component: TempControlSystem_i_Instance_p_tempSensor (periodic: 1000)
  Art: - Registered port: TempControlSystem_i_Instance_p_tempSensor_currentTemp (data out)
  Art: - Registered port: TempControlSystem_ered component: TempControlSystem_i_Instance_p_tempControl (sporadic: 1000)
  Art: - Registered port: TempControlSystem_i_Instance_p_tempControl_currentTemp (data in)
  Art: - Registered port: TempControlSystem_i_Instance_p_tempControl_fanAck (event in)
  Art: - Registered port: TempControlSystem_i_Instance_p_tempControl_setPoint (event in)
  Art: - Registered ponstance_p_fan (sporadic: 1000)
  Art: - Registered port: TempControlSystem_i_Instance_p_fan_fanCmd (event in)
  Art: - Registered port: TempControlSystem_i_Instance_p_fan_fanAck (event out)
  Leaving pre-init of Fan_i_p_fan
  i_Instance_p_tempSensor_tempChanged (event out)
  Leaving pre-init of TempSensor_i_p_tempSensor
  rt: TempControlSystem_i_Instance_p_tempControl_fanCmd (event out)
  Art: - Registered port: TempControlSystem_i_Instance_p_tempControl_tempChanged (event in)
  Leaving pre-init of TempControl_i_p_tempControl
  TempControlSystem_i_Instance_p_tempSensor: Sensed: Temperature_i(84.000000, Fahrenheit)
  TempControlSystem_i_Instance_p_tempControl: Received: Temperature_i(84.000000, Fahrenheit)
  TempControlSystem_i_Instance_p_tempControl: Temperature ok:
  TempControlSystem_i_Instance_p_tempSensor: Sensed: Temperature_i(88.000000, Fahrenheit)
  TempControlSystem_i_Instance_p_tempControl: Received: Temperature_i(88.000000, Fahrenheit)
  TempControlSystem_i_Instance_p_tempControl: Temperature ok:
  TempControlSystem_i_Instance_p_tempSensor: Sensed: Temperature_i(92.000000, Fahrenheit)
  TempControlSystem_i_Instance_p_tempControl: Received: Temperature_i(92.000000, Fahrenheit)
  TempControlSystem_i_Instance_p_tempControl: Temperature ok:
  TempControlSystem_i_Instance_p_tempSensor: Sensed: Temperature_i(96.000000, Fahrenheit)
  TempControlSystem_i_Instance_p_tempControl: Received: Temperature_i(96.000000, Fahrenheit)
  TempControlSystem_i_Instance_p_tempControl: Temperature ok:
  TempControlSystem_i_Instance_p_tempSensor: Sensed: Temperature_i(100.000000, Fahrenheit)
  TempControlSystem_i_Instance_p_tempControl: Received: Temperature_i(100.000000, Fahrenheit)
  TempControlSystem_i_Instance_p_tempControl: Temperature ok:
  TempControlSystem_i_Instance_p_tempSensor: Sensed: Temperature_i(104.000000, Fahrenheit)
  TempControlSystem_i_Instance_p_tempControl: Received: Temperature_i(104.000000, Fahrenheit)
  TempControlSystem_i_Instance_p_tempControl: Sent fan command: On
  TempControlSystem_i_Instance_p_fan: received fanCmd On
  TempControlSystem_i_Instance_p_fan: Actuation result: Ok
  TempControlSystem_i_Instance_p_tempControl: received fanAck Ok
  TempControlSystem_i_Instance_p_tempControl: Actuation worked!
  TempControlSystem_i_Instance_p_tempSensor: Sensed: Temperature_i(100.000000, Fahrenheit)
  TempControlSystem_i_Instance_p_tempControl: Received: Temperature_i(100.000000, Fahrenheit)
  TempControlSystem_i_Instance_p_tempControl: Temperature ok:
  TempControlSystem_i_Instance_p_tempSensor: Sensed: Temperature_i(96.000000, Fahrenheit)
  TempControlSystem_i_Instance_p_tempControl: Received: Temperature_i(96.000000, Fahrenheit)
  TempControlSystem_i_Instance_p_tempControl: Temperature ok:
  TempControlSystem_i_Instance_p_tempSensor: Sensed: Temperature_i(92.000000, Fahrenheit)
  TempControlSystem_i_Instance_p_tempControl: Received: Temperature_i(92.000000, Fahrenheit)
  TempControlSystem_i_Instance_p_tempControl: Temperature ok:
  TempControlSystem_i_Instance_p_tempSensor: Sensed: Temperature_i(88.000000, Fahrenheit)
  TempControlSystem_i_Instance_p_tempControl: Received: Temperature_i(88.000000, Fahrenheit)
  TempControlSystem_i_Instance_p_tempControl: Temperature ok:

  ```