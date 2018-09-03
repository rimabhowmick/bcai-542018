# Feature Extraction  

Describe your solution here.

Rima's Comment:
Tried to explode the yAxisArray and calculated the aggregation functions on top of that.
If one input file with data has been provided, it would have been helped a little bit more.
Changes are there in below files:
1.	FeatureExtraction.scala
2.	Features.scala
3.	FeaturesModule.scala


## <a name="configuration">Configuration</a>
If you change the configuration file please specify 

 
## <a name="input">Requirements for input</a>

Input schema is given below:
 
```
 |-- partNumber: string (nullable = true)
 |-- timeStamp: string (nullable = true)
 |-- xAxis: array (nullable = true)
 |    |-- element: double (containsNull = false)
 |-- yAxis: array (nullable = true)
 |    |-- element: double (containsNull = false)

```


## <a name="output">Output</a>

Simple Features Extraction output schema:

```
 |-- partNumber: string (nullable = true)
 |-- timeStamp: string (nullable = true)
 |-- xAxis: array (nullable = true)
 |    |-- element: double (containsNull = false)
 |-- yAxis: array (nullable = true)
 |    |-- element: double (containsNull = false)
 |-- yAxis_features_group: string (nullable = true)
```

Simple Cutoff output schema: 

```
 |-- partNumber: string (nullable = true)
 |-- timeStamp: string (nullable = true)
 |-- xAxis: array (nullable = true)
 |    |-- element: double (containsNull = false)
 |-- yAxis: array (nullable = true)
 |    |-- element: double (containsNull = false)
 |-- xAxis_out: array (nullable = true)
 |    |-- element: double (containsNull = false)
 |-- yAxis_out: array (nullable = true)
 |    |-- element: double (containsNull = false)
```
