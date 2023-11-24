package week_5

class Comparable<in P : Person> {
  fun compare(p1: P, p2: P): Int {
    return p1.id.compareTo(p2.id)
  }
}

class AnotherEdTech {
  // for in, you can assign superclass type to subclass
  // for out, you can assign subclass type to superclass

  val comparable: Comparable<Teacher> = Comparable<Person>()

  // with out, can assign superclass type to subclass
  val manager: PersonManager<Person> = TeacherManager()

  val people = manager.getAllPersons()

  fun getIds(people: List<Person>): List<String> {
    // This has a performance impact, you can convert it to a sequence instead
    return people.map { it.id }
      .sorted()
  }

  fun doSomething(): Sequence<Int> {
    return (1..10).asSequence()
      .filter {
        it % 2 == 0
      }
  }
}

fun main() {
  val edTech = AnotherEdTech()
  edTech.doSomething()
}

inline fun <reified T> getClass(parameter: T) {
  parameter!!::class.java
}