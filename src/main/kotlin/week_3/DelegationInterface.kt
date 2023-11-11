package week_3

interface Course {
  fun getCourseName(): String
  fun getCourseLevel(): String
  fun getCourseType(): String
}

class OnlineCourse : Course {
  override fun getCourseName(): String {
    return "Online Course"
  }

  override fun getCourseLevel(): String {
    return "Unknown Level"
  }

  override fun getCourseType(): String {
    return "Online Type"
  }

}

class OfflineCourse : Course {
  override fun getCourseName(): String {
    return "Offline Course"
  }

  override fun getCourseLevel(): String {
    return "Unknown Level"
  }

  override fun getCourseType(): String {
    return "Offline Type"
  }
}

// Delegation, other implementations are same as offline as it is a type of offline course itself
class ComposeCourse : Course by OfflineCourse() {
  override fun getCourseName(): String {
    return "Compose Course"
  }
}

class ManualDelegation : Course {
  private val onlineCourse = OnlineCourse()
  override fun getCourseName(): String {
    return onlineCourse.getCourseName()
  }

  override fun getCourseLevel(): String {
    return onlineCourse.getCourseLevel()
  }

  override fun getCourseType(): String {
    return onlineCourse.getCourseType()
  }

}

fun main() {
  val composeCourse = ComposeCourse()
  println(composeCourse.getCourseName())
  println(composeCourse.getCourseType())
  println(composeCourse.getCourseLevel())
}