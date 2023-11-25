package classes.week_3

// How it works internally?
// Creates an ExtensionFunctionsKt class - creates the object of the class and access the method
// Extension functions can only access the public methods or fields of the class
// Private methods or fields are not accessible
// Kotlin sugar easy to extend on third party classes - increases readability
// Also as a safety feature to have you access private data in third-party library classes

// Extension function is decided at compile time which one to use if there are multiple of parent-child extensions
// And extension function will be shadowed by the member functions

open class ComicCharacter(
  open val personalName: String,
  open val mainPower: String = "shield"
) {
  fun getOriginStory(): String {
    return "Origin Story of $personalName"
  }
}

data class SpiderMan(
  val heroName: String,
  override val mainPower: String,
  val age: Int = 29
) : ComicCharacter("Peter Parker", mainPower)

data class Batman(
  val heroName: String,
  override val mainPower: String,
  val city: String = "Gotham City"
) : ComicCharacter("Bruce Wayne", mainPower)

// Extension acts like in the function in the class and is available to the all object
// quick hacky availability on that particular screen only - making it private

fun ComicCharacter.getCharacterName(): String {
  val originStory = getOriginStory()
  return personalName + originStory
}

fun main() {
  val batman = Batman(heroName = "batman", mainPower = "Some power of batman")
  val spiderMan = SpiderMan(heroName = "spider man", mainPower = "Web power")
  batman.getOriginStory()
  spiderMan.getCharacterName()
}