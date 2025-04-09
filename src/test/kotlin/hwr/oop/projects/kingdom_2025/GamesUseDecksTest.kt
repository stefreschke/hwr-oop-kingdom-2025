package hwr.oop.projects.kingdom_2025

import io.kotest.core.spec.style.AnnotationSpec
import org.assertj.core.api.Assertions.assertThat

typealias K = Card.Kupfer
typealias A = Card.Anwesen

class GamesUseDecksTest : AnnotationSpec() {
  
  private val alice = Player("Alice")  // possible because player is immutable
  
  @Test
  fun `games use deck per player`() {
    // given
    val game = Game(
      players = listOf(alice), decks = mapOf(
        alice to Deck(
          cards = listOf(
            // first hand
            A, A, A, K, K,
            // second hand
            K, K, K, K, A
          )
        )
      )
    )
    // when
    val cardsRetrieved = game.cardsOf(alice)
    val cardsInHand = cardsRetrieved.cardsInHand
    val cardsInDeck = cardsRetrieved.cardsInDeck
    // then
    assertThat(cardsInHand)
      .hasSize(5)
      .containsExactly(A, A, A, K, K)
    assertThat(cardsInDeck)
      .hasSize(5)
      .containsExactly(K, K, K, K, A)
  }
  
}