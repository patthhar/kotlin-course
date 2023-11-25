package classes.week_01.basics

fun main() {
  for (num in 1..10) {
    val oddOrEven = if (num % 2 == 0) {
      "even"
    } else {
      "is odd"
    }
    println("$num is $oddOrEven.")
  }

  for (pet in Pets.values()) {
    val favouriteFood = when (pet) {
      Pets.CAT -> "milk"
      Pets.DOG -> "bones"
      Pets.FISH -> "something i dont know"
      Pets.HAMSTER -> "cheese"
    }
    print("${pet.name.lowercase()} likes $favouriteFood!\n")
  }
}

enum class Pets {
  DOG, FISH, CAT, HAMSTER
}