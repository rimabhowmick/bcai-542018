package com.test.transformation

import org.apache.spark.sql.SparkSession
import org.slf4j.{Logger, LoggerFactory}
import com.test.transformation.module.CommunicationModule._

/**
  * Created by kumaraswamy on 9/13/17.
  */
object Communicataion {
  val logger: Logger = LoggerFactory.getLogger(getClass)
  private val AppName = "CommunicationData"

  def main(args: Array[String]) {

    if (args.length < 1) {
      System.err.println("Usage: %s <OutputPath>".format(AppName))
      System.exit(1)
    }
    val spark = SparkSession.builder().appName(AppName).master("local").getOrCreate()

    //spark.read.format("com.databricks.spark.csv").option("header", "true").option("inferSchema", "true").load("test1-feature-extraction/src/test/resources/data/comm-data.csv").createOrReplaceTempView("table1")
    //spark.read.format("com.databricks.spark.csv").option("header", "true").option("inferSchema", "true").load("test1-feature-extraction/src/test/resources/data/park-movement.csv").createOrReplaceTempView("table2")

    var df = spark.emptyDataFrame

    var resultDF = df.communicationModule()
    resultDF.show()
    resultDF.write.text(args(0))

  }
}


