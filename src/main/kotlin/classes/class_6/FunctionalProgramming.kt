package classes.class_6

import classes.week_5.Employee
import kotlin.random.Random

/*
What is FP?
- Function => Comes from Math
- Complements OOP, instead of inheritance uses composition. Solve redundancy with inheritance
- f(x) = x^2
- Making computer code similar to math code purely based on
- Input remains same then the return remains same
- Brings programming closer to math functions
- Enhanced version of OOP imo
*/

/*
Concepts in Functional Programming
- Pure Functions
- High Order Functions and Lambda
- Function Caching
- Category Theory
- Map vs FlatMap
- Functional Composition
 */

/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
1. PURE FUNCTIONS
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Pure means pure math, functions that are closest to in math
- Does one thing, has just one single responsibility
- Gives same output with the same input always
- Whenever you access a global state inside a function, it is not a pure function
- Should not access or change anything outside the scope of the function
- Higher order functions can be pure functions as well
- Should be cacheable
- Should not do anything other than computing the result for the input
 */

// Examples of pure functions. Eg. Input 3, 5 then Op -> 8
fun addPure(n1: Int, n2: Int): Int {
  return n1 + n2
}

// Not pure because of the side effect
fun addImpure(n1: Int, n2: Int): Int {
  println("Input nums are n1: $n1, n2:$n2") // Side effect. By definition, pure functions should be devoid of side-effects
  return n1 + n2
}

// Can do the following for pure function, store Map<Input, Output> -  this is FUNCTION CACHING
// Doesn't work when there are side effects.
// Your global state can change over time or say it won't print the log when function be called instead
// just return the relevant output for the particular input

// Map<Input, Output>
// Map<Pair<Int, Int>, Int>

/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
2. IMMUTABILITY
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 - Value once created should not change in its lifetime
 */
val someVariable: Int = 3

// Not a pure immutable type
val someVariableMutable: Int
  get() {
    val random = Random(100)
    return random.nextInt()
  }

// Even fields or member fields in an instance of classes should not change
// Somewhat immutable record types. POJO classes or Data classes are referred to as Records
data class SomeDataClass(
  val something: Int
)


fun main() {
  val someDataClass = SomeDataClass(3)
  //someDataClass.something = 1 - Cannot do this here since record is immutable type
  val someOtherDataClass = someDataClass.copy() //  Duplicate with your fields or changed field of the record
}

/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
3. FUNCTIONAL COMPOSITION
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
fun multiplyTwo(n1: Int, n2: Int): Int {
  return n1 * n2
}

// This is functional composition.
// You are using abstraction concept here and encapsulation
// Mathematical problem: f((x, y), z) = f(g(x, y), z)
// g(x, y) = x + y
fun addAndMultiply(x: Int, y: Int, z: Int): Int {
  return multiplyTwo(addPure(x, y), z)
}

/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
2. CATEGORY THEORY
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
- It's a theory from mathematics
- Say some part of complex problem can be solved with graphs, some with integration
- In layman's terms to solve complex problem. You solve part of the problem with x, part with y then compose it
- Use the solution parts and then use composition to bring it together and solve complex problems
*/

// Normal way to add will be to loop through and add
// In functional programming
val dataList: List<Employee> = listOf()

// Eg. of category theory
// Also ~~~~~~~~~~~ MAP VS FLATMAP ~~~~~~~~~
fun getIdsOfEmployees(dataList: List<Employee>): List<String> {
  return dataList.map { it.id }
}

// - FlatMap changes from Collection<Collection> -> Collection
// - Map will remain <Collection> -> Collection
fun getIdsOfEmployeesFlatMap(dataList: List<List<Employee>>): List<String> {
  return dataList.flatMap { employees ->
    employees.map { it.id }
  }
}

