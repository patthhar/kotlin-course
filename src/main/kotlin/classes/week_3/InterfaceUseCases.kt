package classes.week_3

class SDK {
  fun getData(): Array<String> {
    return arrayOf("Data from SDK")
  }
}

class SDK2 {
  fun getData(): Map<String, Int> {
    return mapOf("Parth" to 25)
  }
}

interface SDKWrapper {
  fun getData(): String
}

class SDK1 : SDKWrapper {
  private val sdk = SDK2()
  override fun getData(): String {
    return sdk.getData().keys.first()
  }
}

class ViewModels(
  private val sdk: SDK
) {
  fun getData(): String {
    return sdk.getData().joinToString()
  }
}

class MobileScreen(
  private val viewModel: ViewModels
) {
  fun showData() {
    println(viewModel.getData())
  }
}

fun main() {
  val sdk = SDK()
  val viewModel = ViewModels(sdk)
  val mobileScreen = MobileScreen(viewModel)
  mobileScreen.showData()
}