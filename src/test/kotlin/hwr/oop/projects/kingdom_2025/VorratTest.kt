package hwr.oop.projects.kingdom_2025

import io.kotest.core.spec.style.AnnotationSpec
import org.assertj.core.api.Assertions.assertThat

class VorratTest : AnnotationSpec() {
  @Test
  fun `default vorrat, contains all money cards`() {
    // given
    val vorrat = Vorrat()
    // when
    val buyableCards: List<Card> = vorrat.buyableCards
    // then
    assertThat(buyableCards).contains(Card.Silver, Card.Gold, Card.Copper)
  }
}