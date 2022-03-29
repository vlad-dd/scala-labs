object Shit {
    def calc(args: String) = {
    val lowerMap = Map(
    't' -> '7',
    'i' -> '1',
    's' -> '5',
    'e' -> '3',
    'a' -> '4',
    'o' -> '0'
    )

    val upperMap = lowerMap.map {
      case (k,v) => k.toUpper -> v
    }

    val allMap = (lowerMap ++ upperMap).withDefault(k => k)

    println(args.map(allMap))
    }

def main(args: Array[String]): Unit =
{
	calc("Just a random string")

}
}
