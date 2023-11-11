package week_5

data class Employee(
  val id: String,
  val name: String,
  val designation: Designation
)

sealed class Designation {
  object Manager : Designation()
  data class NotManager(
    val id: String,
    val manager: Manager
  ) : Designation()
}
