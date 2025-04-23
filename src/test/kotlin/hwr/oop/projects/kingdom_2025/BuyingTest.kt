package hwr.oop.projects.kingdom_2025

import assertAll
import io.kotest.core.spec.style.AnnotationSpec
import org.assertj.core.api.Assertions.assertThat

typealias K = Card.Kupfer
typealias A = Card.Anwesen

class BuyingTest : AnnotationSpec() {
  
  private val player = Player("Alice")
  private val game = Game(
    players = listOf(player),
    decks = mapOf(
      player to Deck(
        cards = listOf(
          // first hand
          A, A, K, K, K,
          // second hand
          K, K, K, K, A
        )
      )
    )
  )
  
  @Test
  fun `buy Silber, Silber not in hand, not in deck, but in total cards`() {
    // given
    val updatedGame = game.buy(Card.Silber)
    // when
    val cardsRetrieved = updatedGame.cardsOf(player)
    // then
    val deck = cardsRetrieved.deck
    val hand = cardsRetrieved.hand
    val totalCards = cardsRetrieved.totalCards
    assertAll {
      assertThat(deck).doesNotContain(Card.Silber)
      assertThat(hand).doesNotContain(Card.Silber)
      assertThat(totalCards).contains(Card.Silber)
    }
  }
  
  @Test
  fun `buy Silber, hand discarded, new hand dealt`() {
    // given
    val updatedGame = game.buy(Card.Silber)
    // when
    val cardsRetrieved = updatedGame.cardsOf(player)
    // then
    val hand = cardsRetrieved.hand
    assertThat(hand)
      .contains(K, K, K, K, A)
  }
  
}