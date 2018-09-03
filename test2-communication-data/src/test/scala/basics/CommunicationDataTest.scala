package basics

import org.apache.spark.sql.SparkSession
import org.junit.{After, Before, Test}
import org.slf4j.{Logger, LoggerFactory}

/**
  * Created by  kumaraswamy on 9/13/17.
  */
@Test class CommunicationDataTest {

  val logger: Logger = LoggerFactory.getLogger(getClass)
  private var spark: SparkSession = _

  /**
    * Create Spark context before tests
    */
  @Before def setUp(): Unit = {
    spark = {
      SparkSession.builder().appName("CommunicationDataTest").master("local").getOrCreate()
    }
  }

  /**
    * Stop Spark context after tests
    */
  @After def tearDown(): Unit = {
    spark.stop()
    spark = null
  }

  @Test def SimpleTest(): Unit = {
    val sc = spark.sparkContext
    val sqlContext =new org.apache.spark.sql.SQLContext(sc)

    sqlContext.read.format("com.databricks.spark.csv").option("header", "true").option("inferSchema", "true").load("src/test/resources/data/comm-data.csv").registerTempTable("table1")
    sqlContext.read.format("com.databricks.spark.csv").option("header", "true").option("inferSchema", "true").load("src/test/resources/data/park-movement.csv").registerTempTable("table2")

    var df = sqlContext.sparkSession.emptyDataFrame
    sqlContext.sql("select t1.timestamp, t1.from "+
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
      "and t1.to = t2_1.id").show()

  }


}
