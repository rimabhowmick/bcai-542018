package com.test.transformation

import org.apache.spark.sql.SparkSession
import org.slf4j.{Logger, LoggerFactory}

/**
  * Created by kumaraswamy on 9/13/17.
  */
object FeatureExtraction {
  val logger: Logger = LoggerFactory.getLogger(getClass)
  private val AppName = "FeatureExtraction"

  def main(args: Array[String]) {
    // Check arguments */
    if (args.length < 5) {
      System.err.println("Usage: %s <Configuration> <InputPath> <OutputPath><ColumnName><WindowCount".format(AppName))
      System.exit(1)
    }

    val spark = SparkSession.builder().appName(AppName).master("local").getOrCreate()

    val r1 = FourColumns("75029551647502955164E05091600072505", "05.09.2016 18:15:58", Array(199.006, 201.000, 202.000, 203.000, 204.000, 205.000), Array(31.000, 32.000, 33.000, 36.000, 35.000, 34.000))
    val r2 = FourColumns("75029551647502955164E05091600072504", "05.09.2016 18:17:12", Array(198.000, 199.000, 200.000, 201.005, 202.000, 203.000, 204.000, 204.000, 205.000), Array(30.940, 31.020, 31.100, 31.165, 31.252, 33.345, 34.44, 35.66, 336.99))

    val records = Seq(r2, r1)
    val df = spark.createDataFrame(records)


    val resultDF = df.features(args(3),args(4).toInt)
    resultDF.show()
    resultDF.write.text(args(2))

  }
}


