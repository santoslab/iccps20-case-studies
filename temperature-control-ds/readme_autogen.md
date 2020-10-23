# temperature-control-ds

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
  | exclude-component-impl | false |
  | bit-width | 32 |
  | max-string-size | 256 |
  | max-array-size | 1 |


  **How To Run**
  ```
  temperature-control-ds/hamr-nonExcludes/bin/transpile-sel4.sh
  temperature-control-ds/hamr-nonExcludes/src/c/CAmkES_seL4/bin/run-camkes.sh -s
  ```

  ```
  Booting all finished, dropped to user space
  Entering pre-init of TempSensor_i_tsp_tempSensor
  Entering pre-init of TempControl_i_tcp_tempControl
  AEntering pre-init of Fan_i_fp_fan
  Art: Registered component:Art: Registered component: TempControlSystem_i_Instance_tsp_tempSensor (periodic: 1000)
  Art: - Registered port: TempControlSystem_i_Instance_tsp_tempSensor_currentTemp (data out)
  Art: - Registered port: TempControlSystem_i_Instance_tsp_tempSensor_tempChanged (evenrt: Registered component: TempControlSystem_i_Instance_tcp_tempControl (sporadic: 1)
  Art: - Registered port: TempControlSystem_i_Instance_tcp_tempControl_currentTemp (data in)
  Art: - Registered port: TempControlSystem_i_Instance_tcp_tempControl_fanAck (event in)
  Art: - Registered port: TempControlSystem_i_Instance_tcp_tempControl_setPoin TempControlSystem_i_Instance_fp_fan (sporadic: 1)
  Art: - Registered port: TempControlSystem_i_Instance_fp_fan_fanCmd (event in)
  Art: - Registered port: TempControlSystem_i_Instance_fp_fan_fanAck (event out)
  Leaving pre-init of Fan_i_fp_fan
  t out)
  Leaving pre-init of TempSensor_i_tsp_tempSensor
  t (event in)
  Art: - Registered port: TempControlSystem_i_Instance_tcp_tempControl_fanCmd (event out)
  Art: - Registered port: TempControlSystem_i_Instance_tcp_tempControl_tempChanged (event in)
  Leaving pre-init of TempControl_i_tcp_tempControl
  TempControlSystem_i_Instance_tsp_tempSensor: Sensed temperature: 63.000000 F
  TempControlSystem_i_Instance_tsp_tempSensor: Sensed temperature: 67.000000 F
  TempControlSystem_i_Instance_tcp_tempControl: Temperature ok: 67.000000 F
  TempControlSystem_i_Instance_tsp_tempSensor: Sensed temperature: 71.000000 F
  TempControlSystem_i_Instance_tcp_tempControl: Temperature ok: 71.000000 F
  TempControlSystem_i_Instance_tsp_tempSensor: Sensed temperature: 75.000000 F
  TempControlSystem_i_Instance_tcp_tempControl: Temperature ok: 75.000000 F
  TempControlSystem_i_Instance_tsp_tempSensor: Sensed temperature: 79.000000 F
  TempControlSystem_i_Instance_tcp_tempControl: Temperature ok: 79.000000 F
  TempControlSystem_i_Instance_tsp_tempSensor: Sensed temperature: 83.000000 F
  TempControlSystem_i_Instance_tcp_tempControl: Temperature ok: 83.000000 F

  ```