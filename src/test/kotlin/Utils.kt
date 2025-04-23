import org.assertj.core.api.SoftAssertions

fun assertAll(assertions: SoftAssertions.() -> Unit) {
  val softAssertions = SoftAssertions()
  softAssertions.assertions()
  softAssertions.assertAll()
}
