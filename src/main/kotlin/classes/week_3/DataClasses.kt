package classes.week_3

data class MarvelCharacter(
  val personalName: String,
  val heroName: String,
  val mainPower: Power,
  val powers: List<String>
)
// .copy() method internally creates a new data class object with overridden or changed fields
// Mainly useCase is in the domain layer
// Cannot be extended, cannot make it open. Its final and closed
// .toString() better implementation for the toString function


data class Power(
  var powerName: String,
  var powerLevel: String
)

class MarvelCharacterNormal(
  val personalName: String,
  val heroName: String,
  val powers: List<String>,
  val mainPower: String
)

fun main() {
  val spiderMan = MarvelCharacter(
    personalName = "Peter",
    heroName = "Spider Name",
    mainPower = Power("Web", "Advanced"),
    powers = listOf("Web", "web power")
  )

  val spiderManCopy = MarvelCharacter(
    personalName = "Peter",
    heroName = "Spider Name",
    mainPower = Power("Web", "Advanced"),
    powers = listOf("Web", "web power")
  )

  val spiderManClone = spiderMan.copy("Peter Parker")

  val spiderManNormal = MarvelCharacterNormal(
    personalName = "Peter",
    heroName = "Spider Name",
    powers = listOf("Web", "web power"),
    mainPower = "Web",
  )
  val spiderManNormalCopy = MarvelCharacterNormal(
    personalName = "Peter",
    heroName = "Spider Name",
    powers = listOf("Web", "web power"),
    mainPower = "Web",
  )

  println(spiderManNormal)
  println(spiderManNormal.toString())
  println("~~~~~~~~~~~~")
  // Data class has nicer implementation of the `toString()` method
  println(spiderManCopy)
  println("Before modifying")
  println(spiderMan)
  println(spiderManClone)

  println("After modifying")
  spiderManClone.mainPower.powerName = "New power"

  println(spiderMan)
  println(spiderManClone)

  val spiderManClonesClone = spiderManClone.copy(mainPower = spiderManClone.mainPower.copy(powerName = "Back to web"))
  println(spiderManClonesClone)

  // Copy method by the data classes are actually shallow copy
  // Shallow copy meaning primitives are copied and are exclusive however other types are copied by reference

  // Destructuring data classes
  val (personalNam, heroNam, mainPow, all) = spiderMan
  println("Destructed")
  println(personalNam)
  println(heroNam)
  println(mainPow)
  println(all)

  val heroes = listOf(spiderMan, spiderManCopy)
  val heroesClones = listOf(spiderManClone, spiderManClonesClone)

  for (hero in heroes) {
    println(hero.personalName)
    println(hero.heroName)
    // and so on....
  }

  // Skipping fields when destructing use `_` - ORDER IS IMPORTANT
  for ((personal, hero, main, _) in heroesClones) {
    println("$personal, $hero, $main")
  }

  // This is done to support the destructuring -  ONLY FOR FIELDS IN PRIMARY CONSTRUCTORS
  println(spiderMan.component1())

  println(spiderMan == spiderManCopy) // comparing values
  println(spiderManNormal == spiderManNormalCopy) // comparing references
}

// Extending other open class in data classes - very much possible!
data class DcCharacter(override val baseCharacteristic: String) : BaseClass(baseCharacteristic)

open class BaseClass(
  open val baseCharacteristic: String
) {

}