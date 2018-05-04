package com.test.transformation

import com.typesafe.config.Config
import org.apache.spark.sql.DataFrame
import org.slf4j.{Logger, LoggerFactory}

/**
  * Created by kumaraswamy on 9/13/17.
  */
object Features {
  implicit def features(df: DataFrame): FeaturesImplicit = new FeaturesImplicit(df)
}

class FeaturesImplicit(df: DataFrame) extends Serializable {
  val logger: Logger = LoggerFactory.getLogger(getClass)

  def features(configList: List[Config]): DataFrame = {
    df
  }
}
