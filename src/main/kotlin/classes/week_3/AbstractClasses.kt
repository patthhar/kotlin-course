package classes.week_3

abstract class BaseCourse {

  val basicMaterial: Int = 0
  fun courseMaterial(): List<String> {
    return emptyList()
  }

  abstract fun material(): List<String>

}

abstract class AbstractCourse(
  private val courseName: String
) : BaseCourse() {
  val stateHolder: Int = 1
  abstract fun startingCourse(): String
  fun startCourse(): String {
    return "Course started"
  }

  override fun material(): List<String> {
    println(basicMaterial)
    println(courseName)
    return courseMaterial()
  }
}

class KmmCourse : AbstractCourse("Kmm") {
  override fun startingCourse(): String {
    println(stateHolder)
    println(material())
    return startCourse()
  }
}

fun main() {
  val kmmCourse = KmmCourse()
  println(kmmCourse.startingCourse())
}

abstract class BaseViewModel(
  val userId: String
) {
  fun logUserState() {
    print("User Id: $userId")
  }

  abstract fun getUserDetails(): String
}

class ScreenViewModel(userId: String, private val username: String) : BaseViewModel(userId) {
  override fun getUserDetails(): String {
    return "user Id: $userId and username: $username"
  }
}