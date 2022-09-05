package cse250.examples

import scala.io.Source

object Week1RecitationExamples
{
  def main(args: Array[String]): Unit =
  {
    val data =
      Source.fromFile("Solar_Electric_Programs_truncated.csv")
    
    var coordinates = Seq[(Double, Double)]()

    for( (row, index) <- data.getLines().zipWithIndex )
    {
      if(index % 1000 == 0){ println(s"Processing row $index") }
      val columns = row.split(",")
      coordinates = coordinates :+ ( (columns(columns.length-3).toDouble, columns(columns.length-2).toDouble) )
    }
    
    /* do something with coordinates */
  }
}