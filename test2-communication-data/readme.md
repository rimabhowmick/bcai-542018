# Communication Data Extraction  

Describe your solution here.

Rima's Comment:
Got the merged results from both the .csv files, but could not get any matching relationship in between the datasets.
However tried to reach the output, almost matching with expected. Would have been better if some details to link the two datasets would have been provided.
1.	Communicataion.scala
2.	CommunicationModule.scala
3.	CommunicationDataTest.scala


## <a name="configuration">Configuration</a>
If you change the configuration file please specify 

 
## <a name="input">Requirements for input</a>

Input schema of data/comm-data.csv file is given below:

```
  |-- Timestamp: string (nullable = true)
  |-- from: long (nullable = true)
  |-- to: long (nullable = true)
  |-- location: string (nullable = true)
```
Input schema of data/park-movement.csv file is given below:

```
  |-- Timestamp: string (nullable = true)
  |-- id: long (nullable = true)
  |-- type: string (nullable = true)
  |-- X: long (nullable = true)
  |-- Y: long (nullable = true)
```

## <a name="output">Output</a>

output schema: 

```
  |-- Timestamp: string (nullable = true)
  |-- from: long (nullable = true)
  |-- from_type: string (nullable = true)
  |-- from_X: long (nullable = true)
  |-- from_Y: long (nullable = true)
  |-- to: long (nullable = true)
  |-- to_type: string (nullable = true)
  |-- to_X: long (nullable = true)
  |-- to_Y: long (nullable = true)
  |-- location: string (nullable = true)
  
```
