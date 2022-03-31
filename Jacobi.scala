import Array._
object jacobi {
def main(args:Array[String]) {
        val originalMatrix = ofDim[Double](3,3)
        originalMatrix(0) = Array(10.0, -4.0, -2.0)
        originalMatrix(1) = Array(-4.0, 10.0, -4.0)
        originalMatrix(2) = Array(-6.0, -2.0, 12.0)

        val originalBs = Array(2.0, 3.0, 1.0)
        val runs = 22
        var (x1, x2, x3) = (0.0, 0.0, 0.0)


            for (a <- 0 to runs) {
                x1 = (originalBs(0) - originalMatrix(0)(1) * x2 - originalMatrix(0)(2) * x3) / originalMatrix(0)(0)
                x2 = (originalBs(1) - originalMatrix(1)(0) * x1 - originalMatrix(1)(2) * x3) / originalMatrix(1)(1)
                x3 = (originalBs(2) - originalMatrix(2)(0) * x1 - originalMatrix(2)(1) * x2) / originalMatrix(2)(2)
                println("Results after " + a + " runs")
                println("x1 = " + x1)
                println("x2 = " + x2)
                println("x3 = " + x3)
            }
	}
}
