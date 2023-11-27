package assignments.assignment_2

import javax.print.attribute.standard.Media

class MediaCollectionManager<T : MediaItem> : MediaManager<T> {
  override fun addCollection(name: String, vararg collection: T): String {
    TODO("Not yet implemented")
  }

  override fun deleteCollection(name: String) {
    TODO("Not yet implemented")
  }

  override fun getById(id: String): T? {
    TODO("Not yet implemented")
  }

  override fun modifyById(id: String): T? {
    TODO("Not yet implemented")
  }

  override fun getCollection(name: String): List<T> {
    TODO("Not yet implemented")
  }

  override fun getAll(): List<T> {
    TODO("Not yet implemented")
  }

  override fun addToCollection(name: String, vararg mediaItems: T) {
    TODO("Not yet implemented")
  }
}

fun main() {
  var mediaManager = MediaCollectionManager<MediaItem>()
  val bookManager = MediaCollectionManager<MediaItem.Book>()
}