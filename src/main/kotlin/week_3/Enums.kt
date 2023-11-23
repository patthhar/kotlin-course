package week_3

// Needs to be nested inside the class declaration itself
// Separated by commas
// Have to override or give the parameters
// Cant have unique methods in sub-enum types
// Can have shared function

enum class ThisIsEnum(private val parameterName: String) {

  Enum1("enum1"),
  Enum2("enum2");

  fun sharedMethod(): String {
    return ""
  }
}