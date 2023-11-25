package classes.week_5

data class Employee(
  val id: String,
  val name: String,
  val designation: Designation
)

sealed class Designation {
  object Manager : Designation()
  data class Executive(
    val reportee: List<Employee>
  ) : Designation()

  data class Junior(
    val id: String,
    val manager: Manager
  ) : Designation()
}
