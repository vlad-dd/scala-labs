import scala.language.postfixOps

object Sorting {

  def quickSort(a:Array[Int]): Array[Int] =  {
    if (a.length < 2) a
    else {
      val pivot = a(a.length / 2)
      quickSort (a filter (pivot>)) ++ (a filter (pivot == )) ++ quickSort (a filter(pivot <))
    }
  }

   def bubblesort(source: List[Int]) : List[Int]  = {
    def sort(iteration: List[Int], source: List[Int] , result: List[Int]) : List[Int]= source match {
      case h1 :: h2 :: rest => if(h1 > h2) sort(iteration, h1 :: rest, result :+ h2) else sort(iteration, h2 :: rest, result :+ h1) 
      case l:: Nil => sort(iteration, Nil, result :+ l)
      case Nil => if(iteration.isEmpty) return result else sort(iteration.dropRight(1), result, Nil )
    }
    sort(source,source,Nil)
  }

  def merge(seq1: List[Int], seq2: List[Int]): List[Int] = (seq1, seq2) match {
    case (Nil, _) => seq2
    case (_, Nil) => seq1
    case (x::xs, y::ys) =>
    if(x<y) x::merge(xs,seq2)
    else y::merge(seq1,ys)
}

def mergeSort(seq: List[Int]): List[Int] = seq match {
  case Nil => Nil 
  case xs::Nil => List(xs) 
  case _ => 
    val (left, right) = seq splitAt seq.length/2
    merge(mergeSort(left), mergeSort(right))
}

def minimum(xs: List[Int]): List[Int] =
  (List(xs.head) /: xs.tail) {
    (ys, x) =>
      if(x < ys.head) (x :: ys)
      else (ys.head :: x :: ys.tail)
  }

def selectionSort(xs: List[Int]): List[Int] =  
  if(xs.isEmpty) List()
  else {
    val ys = minimum(xs)
    if(ys.tail.isEmpty) 
      ys
    else
      ys.head :: selectionSort(ys.tail)
  }

    def main(args: Array[String]) = {
    val a = Array(5, 3, 2, 1, 20, 46, 9, 39 ,219)
    print("Quick sort: ")
    quickSort(a).foreach(n=> (print(n), print (" " )))
    print("\n")
    print("Bubble sort: ")
    println(bubblesort(List(4,3,2,224,15,17,9,4,225,1,7)))
    print("Merge sort: ")
    println(mergeSort(List(4,3,2,224,15,17,9,4,225,1,7)))
    print("Selection sort: ")
    println(selectionSort(List(4,3,2,224,15,17,9,4,225,1,7)))
    
  }
}
