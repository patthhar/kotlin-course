package assignments.assignment_2

interface MediaManager<T : MediaItem> : MediaInputManager<T>, MediaOutputManager<T> {
  override fun addCollection(name: String, vararg collection: T): String
  override fun deleteCollection(name: String)
  override fun addToCollection(name: String, vararg mediaItems: T)
  override fun getById(id: String): T?
  override fun modifyById(id: String): T?
  override fun getCollection(name: String): List<T>
  override fun getAll(): List<T>
}

interface MediaInputManager<in T : MediaItem> {

  fun addCollection(name: String, vararg collection: T): String
  fun deleteCollection(name: String)
  fun addToCollection(name: String, vararg mediaItems: T)
}

interface MediaOutputManager<out T : MediaItem> {
  fun getById(id: String): T?
  fun modifyById(id: String): T?
  fun getCollection(name: String): List<T>
  fun getAll(): List<T>
}