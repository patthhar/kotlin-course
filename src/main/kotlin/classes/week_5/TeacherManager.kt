package classes.week_5

data class Teacher(
  override val id: String,
  override val name: String,
  override val classes: List<String>
) : Person

data class Student(
  override val id: String,
  override val name: String,
  override val classes: List<String>
) : Person

interface Person {
  val id: String
  val name: String
  val classes: List<String>
}

interface PersonManager<out T> {
  fun getAllPersons(): List<T>
  fun getPersonById(id: String): T?
  fun getPersonByDesignation(designation: Designation): List<T>
  fun getPersonByClass(classes: String): List<T>
}

class TeacherManager : PersonManager<Teacher> {
  override fun getAllPersons(): List<Teacher> {
    TODO("Not yet implemented")
  }

  override fun getPersonById(id: String): Teacher? {
    TODO("Not yet implemented")
  }

  override fun getPersonByDesignation(designation: Designation): List<Teacher> {
    TODO("Not yet implemented")
  }

  override fun getPersonByClass(classes: String): List<Teacher> {
    TODO("Not yet implemented")
  }
}

class EdTech {
  //  val personManagers: List<PersonManager<Person>> = listOf(
//    TeacherManager()
//  )
  val personManager: PersonManager<Person> = TeacherManager()
}