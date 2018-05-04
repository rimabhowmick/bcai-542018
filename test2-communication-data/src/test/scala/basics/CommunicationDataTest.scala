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

    // Read file data/comm-data.csv to df
    // Read file data/park-movement.csv to df
    // Get communication details between users
    /*
    === expected result
+----------------------+-------+---------------+-------+-------+-------+---------------+-------+-------+------------+
|Timestamp	           |from   |from_type      |from_X |from_Y |to     |to_type	       |to_X   |to_Y   |location    |
+----------------------+-------+---------------+-------+-------+-------+---------------+-------+-------+------------+
|2014-06-06 08:00:21   |1591741|check-in       |63     |99     |825652 |check-in       |63     |99     |Kiddie Land |
|2014-06-06 08:05:34   |1591741|check-in       |60     |90     |675561 |check-in       |99     |77     |Kiddie Land |
|2014-06-06 08:10:16   |1483004|check-in       |-1     |-1     |825653 |check-in       |22     |22     |Kiddie Land |
|2014-06-06 08:00:00   |1591741|check-in       |-1     |-1     |825652 |check-in       |-1     |-1     |Kiddie Land |
|2014-06-06 08:29:51   |675561 |check-in       |11     |11     |1483004|check-in       |-1     |-1     |Kiddie Land |
+----------------------+-------+---------------+-------+-------+-------+---------------+-------+-------+------------+
    */
    // unit test cases
  }


}
