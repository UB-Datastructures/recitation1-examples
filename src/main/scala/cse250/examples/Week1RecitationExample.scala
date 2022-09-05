package cse250.examples

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
    
    /* the code would now 
    do something with coordinates */
  }
}