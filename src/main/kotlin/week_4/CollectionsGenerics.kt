package week_4

import java.util.Stack
import java.util.stream.IntStream.IntMapMultiConsumer

// Generics - T - not defining what the type of the class is. But can be general

fun main(args: Array<String>) {
  println("hello, World!")
  X.doSomethingElse()("Argument passed")
  println("Program arguments: ${args.joinToString()}")
  println("~~~~~~~~~~~~")
  GenericClass<String>().print("Something")
  GenericClass<String>().addArray(arrayOf("something", "12", "Nothing"))
  GenericClass<SomeData>().addArray(
    arrayOf(
      SomeData(12),
      SomeData(13),
      SomeData(14),
      SomeData(15),
      SomeData(16),
    )
  )

  AnotherGeneric<Int>().sort(arrayOf(12, 24, 3, 4, 54, 9, 14, 61, 43))

  // MAP
  val child: Map<Any, Any> = mapOf(
    "age" to 12,
    "name" to "encoded",
    "class" to "compose",
    1 to "Out"
  )
  val rothsChild: MutableMap<Any?, Any> = mutableMapOf(
    "age" to 12,
    "name" to "encoded",
    "class" to listOf(1, 2, 3, 45, 5),
    1 to "Out",
    1 to "not out"
  )
  println(rothsChild)
  rothsChild["name"] = "not encoded anymore"
  println("roths child's name changed")
  println(rothsChild)
  println(child["name"].toString()) // entering the key - creates a hash and then stores it
  rothsChild[2] = listOf(12)
  rothsChild[null] = "null value"
  rothsChild[2] = (rothsChild[2] as List<*>) + 12
  println(rothsChild)

  // SET
  val sampleArray = arrayOf(
    1, 3, 2, 1, 12, 43, 14, 456, 2, 51, 4, 8, 4, 9, 9, 1
  )
  val arrayToSet = sampleArray.toSet()
  val uniqueArray = arrayToSet.toIntArray()
  println("Duplicates have been removed")
  val set = setOf(
    1, 3, 14, 2, 1, 9, 11, 14, 12
  )
  println("Set: $set")
  println("Sample array: $sampleArray")
  println("Unique Array:  $uniqueArray")
}


// Whole class is singleton -  In case this is object
class Calculator<T : Number> {
  fun add(n1: T, n2: T): T {
    return n1
//    return n1 + n2
  }
}

typealias StringLambda = (String) -> Unit

class X {
  fun doSomething() {

  }

  // Nested singleton class
  // Avoid doing too many times - as it creates a singleton instance - memory effect
  companion object {
    fun doSomethingElse(): StringLambda = { str ->
      println(str)
    }
  }
}

class Y {
  var companionInstance: Companion? = null

  inner class Companion {
    init {
      companionInstance = this
    }
    // or using the secondary constructor ->
    // constructor()
  }
}

// ~~~~~~~~~~~GENERICS~~~~~~~~


// Or can have the generic type extend a class - say <T : Number>
class GenericClass<T> {
  fun print(value: T) {
    println(value)
  }

  fun addArray(inputArray: Array<T>) {
    inputArray.forEach {
      print(it)
    }
  }
}

data class SomeData(
  val value: Int,
  val byteArray: ByteArray = byteArrayOf()
) {
  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (javaClass != other?.javaClass) return false

    other as SomeData

    if (value != other.value) return false
    if (!byteArray.contentEquals(other.byteArray)) return false

    return true
  }

  override fun hashCode(): Int {
    var result = value
    result = 31 * result + byteArray.contentHashCode()
    return result
  }

}

class AnotherGeneric<T>() where T : Number, T : Comparable<T> {
  fun sort(input: Array<T>): List<T> {
    return input.sortedBy {
      it
    }
  }
}

// Array is more primitive, List is for Dynamicity - Collections
// Has more funcs - doens't have sort() function. List in java is read/write
// In Kotlin, List is read-only. For write, use MutableList() - then have sort()