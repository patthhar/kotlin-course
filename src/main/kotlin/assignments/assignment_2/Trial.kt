package assignments.assignment_2

// Read-only interface for covariance
interface MediaCollectionReader<out T : MediaItem> {
  fun retrieveMediaItems(): List<T>
}

// Write-only interface for contravariance
interface MediaCollectionWriter<in T : MediaItem> {
  fun addMediaItem(item: T)
}

// Combined interface for both read and write
class MyMediaCollectionManager<T : MediaItem> :
  MediaCollectionReader<T>, MediaCollectionWriter<T> {
  private val collection: MutableList<T> = mutableListOf()
  override fun retrieveMediaItems(): List<T> {
    return collection.toList()
  }

  override fun addMediaItem(item: T) {
    collection.add(item)
  }

}