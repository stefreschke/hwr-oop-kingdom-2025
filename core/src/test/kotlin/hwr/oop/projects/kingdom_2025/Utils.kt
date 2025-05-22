package hwr.oop.projects.kingdom_2025

import org.assertj.core.api.SoftAssertions

fun assertAll(assertions: SoftAssertions.() -> Unit) {
  val softAssertions = SoftAssertions()
  softAssertions.assertions()
  softAssertions.assertAll()
}