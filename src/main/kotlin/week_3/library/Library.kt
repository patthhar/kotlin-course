package week_3.library

sealed class DataSource {
  data class Remote(val remoteData: String) : DataSource()
  data class Local(val localData: String) : DataSource()

  fun getData(): String {
    return when (this) {
      is Local -> localData
      is Remote -> remoteData
    }
  }
}