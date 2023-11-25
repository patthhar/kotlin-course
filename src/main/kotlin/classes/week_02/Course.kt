package classes.week_02

class Course {

}

fun main() {
  val course = Course()
}

open class RivuCourses() {
  open lateinit var name: String

  constructor(type: String) : this() {
    this.name = type
  }
}

class ComposeCourse(type: String, override var name: String) : RivuCourses(type) {

}