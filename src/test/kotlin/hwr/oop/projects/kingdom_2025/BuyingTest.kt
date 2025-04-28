package hwr.oop.projects.kingdom_2025

import assertAll
import io.kotest.core.spec.style.AnnotationSpec
import org.assertj.core.api.Assertions.assertThat

typealias K = Card.Copper
typealias A = Card.Estate

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
  fun `buy silver, silver not in hand, not in deck, but in total cards`() {
    // given
    val updatedGame = game.buy(Card.Silver)
    // when
    val cardsRetrieved = updatedGame.cardsOf(player)
    // then
    val deck = cardsRetrieved.deck
    val hand = cardsRetrieved.hand
    val playedCards = cardsRetrieved.cardsPlayed
    val totalCards = cardsRetrieved.totalCards
    assertAll {
      assertThat(deck.cards).doesNotContain(Card.Silver)
      assertThat(hand).doesNotContain(Card.Silver)
      assertThat(playedCards).contains(Card.Silver)
      assertThat(totalCards).contains(Card.Silver)
    }
  }
  
  @Test
  fun `buy silver, hand discarded, new hand dealt`() {
    // given
    val updatedGame = game.buy(Card.Silver)
    // when
    val cardsRetrieved = updatedGame.cardsOf(player)
    // then
    val hand = cardsRetrieved.hand
    assertThat(hand)
      .contains(K, K, K, K, A)
  }
  
}