package com.test.transformation.module

import org.apache.spark.sql.DataFrame
import org.slf4j.{Logger, LoggerFactory}

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
  def featuresGeneration(sColName: String, windowCount: Int): DataFrame = {
    // column on which features has to be extracted
    df
  }
}
