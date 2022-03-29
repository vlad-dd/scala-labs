import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.ListBuffer

object Main extends App {
  val mutableList = ListBuffer[Int]()
  mutableList.append(1).append(2).append(3).appendAll(List(4,5,6))
  val x = 0 +: mutableList :+ 7 :++ List(8,9,10)
  x.map(_ + "th").foreach(println)
}
