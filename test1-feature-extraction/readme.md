# Feature Extraction  

Describe your solution here.

TODO: Please explain your solution briefly and highlight the advantages and disadvantages of your implementation. Will it scale for a large number of tests?

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
