package classes.week_01.functions

fun main() {
  val a = 10
  val b = 20
  val c = 30
  sum(a, c)
  sum(
    first = b.toDouble(),
    second = c
  )
}

// With default arguments
private fun sum(a: Int, b: Int, c: Int = 0): Int {
  return a + b + c
}

// Overloaded with different parameter types
private fun sum(a: Double, b: Double, c: Double): Double {
  return a + b + c
}

// Without default arguments
private fun sum(a: Int, b: Int): Int {
  return a + b
}

// Named arguments
private fun sum(first: Double, second: Int = 0): Int {
  return (first + second).toInt()
}