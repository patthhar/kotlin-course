package week_01.basics

fun main() {
  println(getGreeting("Parth"))
  val resPair = getGreetingWithAge("Takkar", 23)
  println(resPair.first)
  println(getGreetingWithAge("Parth", 23).second)
  val (name, age, hobby) = myInfo()

  // Destructing declaration for pairs or triples // Syntactical sugar
  println("Name: $name")
  println("Age: $age")
  println("Hobby: $hobby")
}

fun getGreeting(name: String): String {
  return "Greetings to $name!"
}

fun getGreetingWithAge(name: String, age: Int): Pair<String, Int> {
  return "Greetings to $name!" to age + 1
}

fun myInfo(): Triple<String, Int, String> {
  return Triple("Parth", 23, "Android")

}