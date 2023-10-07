package week_01.basics

fun main() {
  var petName: String? = null
  var age: Int? = null
  age = 1
  var ageInOneYear = age!! + 1

  if (age != null) {
    ageInOneYear = age + 1
    println("Next year my age will be: $ageInOneYear")
  }

  ageInOneYear = age?.plus(1) ?: 0

  // Let call - calls age only if it not null same as above ^


  // !! operator, the programmer takes responsibility for nullability
  val ageInOneYearDoubleBang = age!!.plus(1)
  // Safe call
  val ageInOneYearSafeCall = age?.plus(1) // will assign null if age is null
  // Elvis operator
  val ageInOneYearElvis = age?.plus(1) ?: 0

  infiniteLoopNothing()

}

fun infiniteLoop() {
  while (true) {
  }
}
fun infiniteLoopNothing(): Nothing {
  while (true) {
  }
}