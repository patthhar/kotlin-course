package week_01.basics

fun main() {
  val stringFormatNewLine: String = "Parth \nTakkar"
  val stringFormatQuotations: String = "\"Parth Takkar\""
  println(stringFormatNewLine)
  println(stringFormatQuotations)

  val stringFormatMultiline: String = """
    My name is Parth
        I am an android developer
      I love kotlin!
  """.trimIndent()
  println(stringFormatMultiline)
}