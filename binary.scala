object BinarySearch{



def Iterative(list: Array[Int], el : Int): Int =
{
	var lowBound = 0
	var highBound = list.length - 1
	while (lowBound <= highBound)
	{

	var middleVal = lowBound + (highBound - lowBound) / 2

		if (list(middleVal) == el) {
      return (middleVal)
    }

		else if (list(middleVal) > el)
    highBound = middleVal - 1

		else
    lowBound = middleVal + 1
	}
	-1
}

def Recursive(list: Array[Int], el: Int)(lowBound: Int = 0,highBound: Int = list.length - 1): Int = {                      
    if (lowBound > highBound) 
        return -1
      
    var middleVal = lowBound + (highBound - lowBound) / 2
      
    if (list(middleVal) == el)
        return middleVal
      
    else if (list(middleVal) > el)
        return Recursive(list, el)(lowBound, middleVal - 1)
      
    else
        return Recursive(list, el)(middleVal + 1, highBound)
}

def Matching(list: Array[Int], el: Int): Int =
{ 
    def func(list: Array[Int], el: Int, lowBound: Int, highBound: Int): Int =
    {
        if (lowBound > highBound)
            return -1

        var middleVal = lowBound + (highBound - lowBound) / 2
              
        list match {
            case(list:Array[Int]) if (list(middleVal) == el) => middleVal 
                  
            case(list:Array[Int]) if (list(middleVal) < el) => func(list, el, middleVal + 1, highBound)
                  
            case(list:Array[Int]) if (list(middleVal) > el) => func(list, el, lowBound, middleVal - 1)
        }
    } 
        
    func(list, el, 0, list.length - 1)
}

def main(args: Array[String]): Unit =
{
	
	var iterative = Iterative(Array(6, 3, 5, 7, 33,78, 1), 78);
  
  var recursive = Recursive(Array(1, 2, 3, 4, 55, 65, 75), 4)(0, 6)

  var matching = Matching(Array(1, 2, 3, 4, 55,65, 75), 3);
	
	if(iterative == -1 || recursive == -1 || matching == -1)
	print("Not Found")
  		
	else
	print("Iterative element found at index " + iterative, "\n", "Recursive element found at index " + recursive, "\n", 
  "Matching element found at index " + matching)
}
}

