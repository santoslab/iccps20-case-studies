# pca-pump

 Table of Contents
  * [Diagrams](#diagrams)
    * [AADL Arch](#aadl-arch)
  * [Metrics](#metrics)
    * [AADL Metrics](#aadl-metrics)
    * [JVM Metrics](#jvm-metrics)
  * [Example Output](#example-output)
    * [JVM Expected Output: Timeout = 0 seconds](#jvm-expected-output-timeout--0-seconds)

## Diagrams
### AADL Arch
![AADL Arch](aadl/pca/diagrams/aadl-arch.png)

## Metrics
### AADL Metrics
| | |
|--|--|
|Threads|12|
|Ports|186|
|Connections|101|

### JVM Metrics

Language|files|blank|comment|code
:-------|-------:|-------:|-------:|-------:
Scala|140|3239|850|14223
JSON|4|0|0|179
Bourne Shell|1|11|0|40
--------|--------|--------|--------|--------
SUM:|145|3250|850|14442

## Example Output
*NOTE:* actual output may differ due to issues related to thread interleaving
### JVM Expected Output: Timeout = 0 seconds

  |HAMR Codegen Configuration| |
  |--|--|
  | package-name | pca_pump |
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