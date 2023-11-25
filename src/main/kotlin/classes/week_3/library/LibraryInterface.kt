package classes.week_3.library

sealed interface LibraryInterface {
  fun getVersion(): String
  fun getName(): String
}

class KotlinLibrary(private val parent: String) : LibraryInterface {
  override fun getVersion(): String {
    return "1.1.1"
  }

  override fun getName(): String {
    return "Kotlin & Parent: $parent"
  }

}

object JavaLibrary : LibraryInterface {
  private val kotlin = KotlinLibrary(this.getName())
  override fun getVersion(): String {
    return "17"
  }

  override fun getName(): String {
    return "Java. Child - $kotlin"
  }

}