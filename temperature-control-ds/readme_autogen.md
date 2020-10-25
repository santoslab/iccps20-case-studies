# temperature-control-ds

 Table of Contents
  * [Diagrams](#diagrams)
    * [AADL Arch](#aadl-arch)
    * [SeL4](#sel4)
      * [SeL4 CAmkES Arch](#sel4-camkes-arch)
      * [SeL4 CAmkES HAMR Arch](#sel4-camkes-hamr-arch)
  * [Metrics](#metrics)
    * [AADL Metrics](#aadl-metrics)
    * [JVM Metrics](#jvm-metrics)
    * [Linux Metrics](#linux-metrics)
    * [SeL4 Metrics](#sel4-metrics)
  * [Example Output](#example-output)
    * [JVM Expected Output: Timeout = 0 seconds](#jvm-expected-output-timeout--0-seconds)
    * [SeL4 Expected Output: Timeout = 0 seconds](#sel4-expected-output-timeout--0-seconds)

## Diagrams
### AADL Arch
![AADL Arch](aadl/diagrams/aadl-arch.png)

### SeL4
#### SeL4 CAmkES Arch
![SeL4 CAmkES Arch](aadl/diagrams/CAmkES-arch-SeL4.svg)

#### SeL4 CAmkES HAMR Arch
![SeL4 CAmkES HAMR Arch](aadl/diagrams/CAmkES-HAMR-arch-SeL4.svg)

## Metrics
### AADL Metrics
| | |
|--|--|
|Threads|3|
|Ports|9|
|Connections|4|

### JVM Metrics
Total CLOC
-----------

Language|files|blank|comment|code
:-------|-------:|-------:|-------:|-------:
Scala|53|788|277|2409
--------|--------|--------|--------|--------
SUM:|53|788|277|2409

User CLOC
---------
 | | |
 |--|--:|
 |Code|84|
 |Log Code|8|

### Linux Metrics
Total CLOC
-----------

Language|files|blank|comment|code
:-------|-------:|-------:|-------:|-------:
C|148|1790|165|10566
C/C++ Header|284|2531|236|6857
C++|2|102|53|852
--------|--------|--------|--------|--------
SUM:|434|4423|454|18275

User CLOC
---------
| | |
|--|--:|
|Code|17|
|Log Code|0|

### SeL4 Metrics
Not sure what to measure here -- Camkes ADL cloc, glue-code cloc, generated seL4 code?

## Example Output
*NOTE:* actual output may differ due to issues related to thread interleaving
### JVM Expected Output: Timeout = 0 seconds

  |HAMR Codegen Configuration| |
  |--|--|
  | package-name | b |
  | exclude-component-impl | false |
  | bit-width | 32 |
  | max-string-size | 256 |
  | max-array-size | 1 |


  **How To Run**
  ```
  sbt run
  ```

  ```
  Didn't find 'Booting all finished'!
  ```

### SeL4 Expected Output: Timeout = 0 seconds

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
  Didn't find 'Booting all finished'!
  ```