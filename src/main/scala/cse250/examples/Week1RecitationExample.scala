package cse250.examples
/**
 * cse250.examples.Week1RecitationExamples.scala
 *
 * Copyright 2022 Oliver Kennedy (okennedy@buffalo.edu)
 *           2022 Eric Mikida (epmikida@buffalo.edu)
 *           2021 Andrew Hughes (ahughes6@buffalo.edu)
 *
 * This work is licensed under the Creative Commons
 * Attribution-NonCommercial-ShareAlike 4.0 International License.
 * To view a copy of this license, visit
 * http://creativecommons.org/licenses/by-nc-sa/4.0/.
 *
 */

import scala.io.Source

object Week1RecitationExamples
{
  def main(args: Array[String]): Unit =
  {
    val data =
      Source.fromFile("Solar_Electric_Programs_truncated.csv")
    
    var coordinates = Seq[(Double, Double)]()
    var lastTime = System.currentTimeMillis

    for( (row, index) <- data.getLines().zipWithIndex )
    {
      if(index % 1000 == 0){ 
        val now = System.currentTimeMillis
        println(s"Processing row $index (${now - lastTime}ms since last check)") 
        lastTime = now
      }
      val columns = row.split(",")
      coordinates = coordinates :+ ( (columns(columns.length-3).toDouble, columns(columns.length-2).toDouble) )
    }
    
    /* the code would now do something with coordinates */
  }
}