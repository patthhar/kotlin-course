package classes.week_3.application

import week_3.library.DataSource

class Application(
  private val library: DataSource
) {
  fun showData() {
    println(library.getData())
  }

}

fun main() {
  val localData = DataSource.Local("Local Data")
  val remoteData = DataSource.Remote("Remote Data")
  val application = Application(localData)
  application.showData()
}