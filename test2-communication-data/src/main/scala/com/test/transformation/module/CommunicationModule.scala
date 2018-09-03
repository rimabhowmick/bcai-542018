package com.test.transformation.module

import org.apache.spark.sql.DataFrame
import org.slf4j.{Logger, LoggerFactory}
import scala.language.implicitConversions

/**
  * Created by kumaraswamy on 9/13/17.
  */
object CommunicationModule {
  implicit def CommunicationModule(df: DataFrame): CommunicationModuleImplicit = new CommunicationModuleImplicit(df)
}

class CommunicationModuleImplicit(df: DataFrame) extends Serializable {
  val logger: Logger = LoggerFactory.getLogger(getClass)
  def communicationModule(): DataFrame = {

    df.sqlContext.read.format("com.databricks.spark.csv").option("header", "true").option("inferSchema", "true").load("src/test/resources/data/comm-data.csv").createOrReplaceTempView("table1")
    df.sqlContext.read.format("com.databricks.spark.csv").option("header", "true").option("inferSchema", "true").load("src/test/resources/data/park-movement.csv").createOrReplaceTempView("table2")

    var resultDF = df.sqlContext.sql("select t1.timestamp, t1.from "+
      ", t2.type as from_type "+
      ", t2.X as from_x "+
      ", t2.Y as from_y "+
      ", t1.to "+
      ", t2_1.type to_type "+
      ", t2_1.X as to_x "+
      ", t2_1.Y as to_y "+
      ", t1.location "+
      "from table1 t1 "+
      ", table2 t2 "+
      ", table2 t2_1 "+
      "  where t1.from = t2.id "+
      "and t1.to = t2_1.id")
    resultDF
  }
}
