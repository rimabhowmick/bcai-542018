package com.test.transformation.module

import org.apache.spark.sql.DataFrame
import org.slf4j.{Logger, LoggerFactory}

import scala.language.{implicitConversions, postfixOps}

/**
  * Created by kumaraswamy on 9/13/17.
  */
object CutoffModule {
  implicit def cutoffModule(df: DataFrame): cutoffModuleImplicit = new cutoffModuleImplicit(df)
}

class cutoffModuleImplicit(df: DataFrame) extends Serializable {
  val logger: Logger = LoggerFactory.getLogger(getClass)

  def cutOffSignals(inXaxis: String, inYaxis: String, outXaxis: String, outYaxis: String, xStart: Int, xEnd: Int): DataFrame = {
    df
  }
}
