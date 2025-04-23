package hwr.oop.projects.kingdom_2025

import io.kotest.core.spec.style.AnnotationSpec
import org.assertj.core.api.Assertions.assertThat

class GameTest : AnnotationSpec() {
  
  private val alice = Player("Alice")  // possible because player is immutable
  private val game =
    Game(players = listOf(alice))  // possible because game is immutable
  
  @Test
  fun `game with single player, game has correct player`() {
    // when
    val retrievedPlayers = game.players
    // then
    assertThat(retrievedPlayers)
      .hasSize(1)
      .contains(alice)
  }
  
  @Test
  fun `player in game cards, five cards in hand`() {
    // given
    val cardsRetrieved = game.cardsOf(alice)
    // when
    val cardsInHand = cardsRetrieved.hand
    // then
    assertThat(cardsInHand)
      .hasSize(5)
  }
  
  @Test
  fun `player in game cards, five cards in deck`() {
    // given
    val cardsRetrieved = game.cardsOf(alice)
    // when
    val cardsInDeck = cardsRetrieved.deck
    // then
    assertThat(cardsInDeck)
      .hasSize(5)
  }
  
  @Test
  fun `play in game, cards, total cards, 3 estate, 7 copper`() {
    // given
    val cardsRetrieved = game.cardsOf(alice)
    // when
    val totalCards: List<Card> = cardsRetrieved.totalCards
    // then
    assertThat(totalCards)
      .hasSize(10)
      .matches { cards -> cards.filter { it == Card.Estate }.size == 3 }
      .matches { cards -> cards.filter { it == Card.Copper }.size == 7 }
  }
  
  @Test
  fun `play in game, cards, total cards, combined deck and hand`() {
    // given
    val cardsRetrieved = game.cardsOf(alice)
    val deck = cardsRetrieved.deck
    val hand = cardsRetrieved.hand
    // when
    val totalCards: List<Card> = cardsRetrieved.totalCards
    // then
    assertThat(totalCards)
      .hasSize(10)
      .containsAll(deck)
      .containsAll(hand)
  }
  
}