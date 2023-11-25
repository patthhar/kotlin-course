package classes.week_01.basics

fun main() {
  val pets: Array<String> = arrayOf("piku", "togo", "momo")
  classes.week_01.basics.printArray(*pets)
  pets[0] = "cheeku"
  println(pets.joinToString())
  println("size of pets array: ${pets.size}")
  println("last item of pets array: ${pets.last()}")

  // My extension function on Array<String>
  println(pets.central())

  // HeteroArray
  val heteroArray: Array<Any> = arrayOf("Parth", 24)
  heteroArray[0] = 25
  heteroArray[1] = "Takkar"
  heteroArray[1] = 17.0
  println(heteroArray.joinToString())

  // 2D arrays
  val twoDimenArray = arrayOf(
    arrayOf(1, 2, 3),
    arrayOf(2, 3, 4),
    arrayOf(3, 4, 5)
  )
  println("twoDimenArray[1][2] = ${twoDimenArray[1][2]}")
}

private fun printArray(vararg items: String) {
  for (item in items) {
    print("$item, ")
  }
  print("\n")
}

fun Array<String>.central(): String? {
  return if (this.size > 2) {
    this[(size - 1) / 2]
  } else null
}