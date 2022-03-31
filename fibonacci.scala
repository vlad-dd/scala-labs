import collection.mutable

object Solution {
def fib1(n: Int): BigInt = if(n <= 2) 1 else fib1(n-1) + fib1(n-2)

def fib3(n: Int) = (1 to n).foldLeft(mutable.ListBuffer[BigInt](1, 1))((a, _) => (a(0) + a(1)) +=: a).reverse(n-1)

def fib4(n: Int) = (1 to n).foldLeft(mutable.ArrayBuffer[BigInt](1, 1))((a, _) => (a += a(a.size -1) + a(a.size -2)))(n-1)

val fib5 = {
  val buf = mutable.ArrayBuffer[BigInt](1,1)
  def apply(n: Int):BigInt = n match{
    case n if n <= buf.size => buf(n-1)
    case n => {buf += (apply(n-2) + apply(n-1)); buf(n-1)}
  }
  apply _
}

val fib6 = new Function1[Int, BigInt]{
  val buf = mutable.ArrayBuffer[BigInt](1,1)
  def apply(n: Int):BigInt = n match{
    case n if n <= buf.size => buf(n-1)
    case n => {buf += (apply(n-2) + apply(n-1)); buf(n-1)}
  }
}


  def main(args: Array[String]){

    println(fib1(5))
    println(fib3(5))
    println(fib4(5))
    println(fib5(5))
    println(fib6(5))
  }
}
