package assignments.assignment_2

sealed class MediaItem(open val id: String, open val producer: String, open val title: String) {
  data class Book(
    override val id: String,
    override val title: String,
    val author: String,
    val chapters: List<String>
  ) : MediaItem(id, author, title)

  data class Movie(
    override val id: String,
    override val title: String,
    override val producer: String,
    val director: String,
    val actors: List<String>,
    val runtimeInSeconds: Long
  ) : MediaItem(id, title, producer)

  data class Reel(
    override val id: String,
    override val title: String,
    val creatorId: String,
    val creator: String
  ) : MediaItem(id, title, creator)

  data class MusicAlbum(
    override val id: String,
    val albumName: String,
    val artist: String,
    val labelName: String,
    val songs: List<String>
  ) : MediaItem(id, albumName, artist)
}
