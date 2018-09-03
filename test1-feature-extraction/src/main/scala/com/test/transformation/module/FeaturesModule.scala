package com.test.transformation.module

import org.apache.spark.sql.DataFrame
import org.slf4j.{Logger, LoggerFactory}
import org.apache.spark.sql.functions.explode
import scala.language.implicitConversions

/**
  * Created by kumaraswamy on 9/13/17.
  */
object FeaturesModule {
  val NamesList = List("min", "max", "mean", "var", "std", "slope")
  val Separator = "==="

  implicit def featuresModule(df: DataFrame): FeaturesModuleImplicit = new FeaturesModuleImplicit(df)
}

class FeaturesModuleImplicit(df: DataFrame) extends Serializable {
  val logger: Logger = LoggerFactory.getLogger(getClass)

  //Generate features for the given columns of array values
  //Generate features for the given columns of array values
  def featuresGeneration(sColName: String, windowCount: Int): DataFrame = {
    // column on which features has to be extracted
    var newColName = sColName+"Explode"
    var df1 = df.withColumn(newColName, explode(df(sColName)))
    df1.createOrReplaceTempView("tempTable")
    var df2 = df1.sqlContext.sql("select partNumber, timestamp, min("+newColName+") over (partition by "+sColName+" rows BETWEEN " +
      "CURRENT ROW AND "+windowCount+" FOLLOWING) "+sColName+"_min, max("+newColName+") over (partition by "+sColName+" rows BETWEEN " +
      "CURRENT ROW AND "+windowCount+" FOLLOWING) "+sColName+"_max, mean("+newColName+") over (partition by "+sColName+" rows BETWEEN " +
      "CURRENT ROW AND "+windowCount+" FOLLOWING) "+sColName+"_mean,variance("+newColName+") over (partition by "+sColName+" rows BETWEEN " +
      "CURRENT ROW AND "+windowCount+" FOLLOWING) "+sColName+"_var, std("+newColName+") over (partition by "+sColName+" rows BETWEEN " +
      "CURRENT ROW AND "+windowCount+" FOLLOWING) "+sColName+"_std from tempTable")

    df2
  }
}
