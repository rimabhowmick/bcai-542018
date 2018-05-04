package com.test.transformation

import org.slf4j.{Logger, LoggerFactory}

/**
  * Created by kumaraswamy on 9/13/17.
  */
object FeatureExtraction {
  val logger: Logger = LoggerFactory.getLogger(getClass)
  private val AppName = "FeatureExtraction"

  def main(args: Array[String]) {
    // Check arguments */
    if (args.length < 3) {
      System.err.println("Usage: %s <Configuration> <InputPath> <OutputPath>".format(AppName))
      System.exit(1)
    }

    // load application configuration
    /** Get the Spark context object and data frame */
    /** Get source input path */
    /** Write results to output path */
    /** clean up */
  }
}


