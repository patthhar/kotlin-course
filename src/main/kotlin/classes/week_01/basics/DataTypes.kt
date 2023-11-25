package classes.week_01.basics

var petAgeInt = 1
fun main() {
  // Numbers
  val petAgeShort: Short = 1
  val petAgeByte: Byte = 1 // ^8 bit
  val petAgeLong: Long = 1 // ^64 bit
  // Fractional
  val ageDouble = 1.0 // 64 bit
  val ageFloat = 2.0f // 32 bit
  val uraniumAge = 2.8e10 // Scientific notation
  val billion = 1_000_000_000
  val trillion = 1_000_000_000_000

  petAgeInt = petAgeByte.toInt()
}