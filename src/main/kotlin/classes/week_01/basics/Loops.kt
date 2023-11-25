package classes.week_01.basics

fun main() {
  val pets = arrayOf("Piku", "Togo", "Momo", " Snowy")

  val numRange = 1..20
  val numRangeUntil = 1 until 20
//  for (pet in pets) {
//    print("Pet name is: $pet, ")
//  }
//  println()
//  for (i in numRange)
//  for (j in numRangeUntil) {
//    print(j)
//  }
//  for( k in 10 downTo 1) {
//    print(k)
//  }
//
//  for (l in 20 downTo 2 step 1) {
//    print(l)
//  }

  for (ind in pets.indices) {
    if (ind == pets.size - 2) continue
    println("${ind + 1}. ${pets[ind]}")
  }

  // While loop
  println("While loop")
  var sum = 0
  while (sum < 100) {
    sum += 10
    println(sum)
  }
  // do while
  println("doWhile loop")
  sum = 0
  do {
    sum += 10
    println(sum)
  } while (sum < 100)
}