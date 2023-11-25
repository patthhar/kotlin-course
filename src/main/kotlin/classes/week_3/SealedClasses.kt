package classes.week_3

// Restricted - sort of opposite of open
// Can extend it withing this module or package. Control extensions or implementations
// Restricting the hierarchy is main purpose - mainly for library developers
// It is an abstract class

sealed class Player(val name: String, val sport: String) {
  private val timestamp = System.currentTimeMillis()

  data class Virat(val personalName: String) : Player(personalName, "Cricket")
  data class Ronaldo(val personalName: String) : Player(personalName, "Football")

  open fun getData(): String {
    return name.trim() + timestamp
  }
}

data class Verstappen(val personalName: String) : Player(personalName, "F1") {
  override fun getData(): String {
    return personalName
  }
}

// Sealed class can have generics also
sealed class Result<out T> {
  data class Success<out T>(val data: T) : Result<T>()
  data class Error(val errorMsg: String) : Result<Unit>()
}