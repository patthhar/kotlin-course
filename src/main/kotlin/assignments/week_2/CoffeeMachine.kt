package assignments.week_2

import java.util.*

class CoffeeMachine(
  private var coffeeBeans: Int = 20,
  private var water: Int = 10,
  private var milk: Int = 10,
  private var sugar: Int = 10
) {
  private val sc = Scanner(System.`in`)
  private var money = 0

  init {
    println("Welcome to the Coffee Machine!")
  }

  private fun menu() {
    println("Menu")
    println("0 - Espresso - $4")
    println("1 - Cappuccino - $7")
    println("2 - Latte - $8")
    println("3 - Mocha - $5")
    println("4 - Refill Resources")
    println("5 - Display Status")
    println("\'exit\' - to exit")
  }

  private fun enterChoice(): String {
    println("Enter the number of the coffee you\'d like (0-3) or \'m\' for menu or \'exit\' to quit:")
    return sc.nextLine()
  }

  fun acceptOrder() {
    menu()
    while (true) {
      val choice = enterChoice()
      if (choice == "exit") {
        println("Thank You for visiting the coffee machine!")
        break
      } else if (choice == "m") {
        menu()
      } else {
        when (choice.toIntOrNull()) {
          0 -> makeCoffee("Espresso", 4, 3, 1, 0, 0)
          1 -> makeCoffee("Cappuccino", 7, 2, 1, 1, 1)
          2 -> makeCoffee("Latte", 8, 3, 2, 2, 2)
          3 -> makeCoffee("Mocha", 5, 2, 1, 1, 2)
          4 -> refillResources()
          5 -> displayStatus()
          null -> println("Invalid input")
          else -> println("Invalid input")
        }
      }
    }
  }

  private fun makeCoffee(
    name: String,
    price: Int,
    coffeeNeeded: Int,
    waterNeeded: Int,
    milkNeeded: Int,
    sugarNeeded: Int
  ) {
    if (hasEnoughResources(coffeeNeeded, waterNeeded, milkNeeded, sugarNeeded)) {
      println("Making $name...")
      money += price
      Thread.sleep(1000)
      deductResources(coffeeNeeded, waterNeeded, milkNeeded, sugarNeeded)
      println("Here is your $name. Enjoy!")
    } else println("Sorry not enough resources to make $name. Please refill resources")
  }

  private fun hasEnoughResources(coffeeNeeded: Int, waterNeeded: Int, milkNeeded: Int, sugarNeeded: Int) =
    coffeeBeans >= coffeeNeeded && water >= waterNeeded && milk >= milkNeeded && sugar >= sugarNeeded

  private fun deductResources(coffeeNeeded: Int, waterNeeded: Int, milkNeeded: Int, sugarNeeded: Int) {
    coffeeBeans -= coffeeNeeded
    water -= waterNeeded
    milk -= milkNeeded
    sugar -= sugarNeeded
  }

  private fun refillResources() {
    coffeeBeans = 20
    water = 10
    milk = 10
    sugar = 10
    println("Resources have been refilled.")
  }

  fun displayStatus() {
    println("Money: $$money")
    println("Resources - Water: $water, Milk: $milk, Coffee Beans: $coffeeBeans, Sugar: $sugar")
  }
}

fun main() {
  val coffeeMachine = CoffeeMachine()
  coffeeMachine.acceptOrder()
  coffeeMachine.displayStatus()
}