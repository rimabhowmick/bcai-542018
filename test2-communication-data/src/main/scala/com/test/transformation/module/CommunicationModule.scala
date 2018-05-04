package com.test.transformation.module

import org.apache.spark.sql.DataFrame

import scala.language.implicitConversions

/**
  * Created by kumaraswamy on 9/13/17.
  */
object CommunicationModule {
  implicit def CommunicationModule(df: DataFrame): CommunicationModuleImplicit = new CommunicationModuleImplicit(df)
}

class CommunicationModuleImplicit(df: DataFrame) extends Serializable {

  def CommunicationGeneration(): DataFrame = {

    df
  }
}
