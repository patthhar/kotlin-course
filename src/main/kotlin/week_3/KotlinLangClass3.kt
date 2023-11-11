package week_3

interface KotlinLangClass {
  // Added after java 8
  val courseLevel: String
  fun getCourseName(): String

  // Introduced in Java 8
  // cannot do level: String = "Default Level"
  //val newLevel: String = "Some new level"
  val level: String
    get() = "Default Level"

  fun getDefaultLevel(): String {
    return "Default Level from method"
  }
}

interface Duration {

  // Can make private if you have default implementation
  private val time: Long
    get() = 1000L

  // Cannot be private as needs to be implemented by the class
  // And other class needs to access it
  val totalTime: Long
}

class KotlinLangClass3(
  override val courseLevel: String
) : KotlinLangClass, Duration {
  val newLevel: String = "Some new level" // Class level within the class

  override fun getCourseName(): String {
    return "Class 3"
  }

  override val totalTime: Long = 50000L

}

fun main() {
  val class3 = KotlinLangClass3("Medium")
  println(class3.getCourseName())
  println(class3.courseLevel)
}