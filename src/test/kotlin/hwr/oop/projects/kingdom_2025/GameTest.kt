package hwr.oop.projects.kingdom_2025

import io.kotest.core.spec.style.AnnotationSpec
import org.assertj.core.api.Assertions.assertThat

class GameTest : AnnotationSpec() {
  
  @Test
  fun `game with single player, game has correct player`() {
    // given
    val alice = Player("Alice")
    val game = Game(players = listOf(alice))
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
    val alice = Player("Alice")
    val game = Game(players = listOf(alice))
    // when
    val cardsRetrieved = game.cardsOf(alice)
    val cardsInHand = cardsRetrieved.cardsInHand
    // then
    assertThat(cardsInHand)
      .hasSize(5)
  }
  
  @Test
  fun `player in game cards, five cards in deck`() {
    // given
    val alice = Player("Alice")
    val game = Game(players = listOf(alice))
    // when
    val cardsRetrieved = game.cardsOf(alice)
    val cardsInDeck = cardsRetrieved.cardsInDeck
    // then
    assertThat(cardsInDeck)
      .hasSize(5)
  }
  
  @Test
  fun `play in game, cards, total cards, 3 anwesen, 7 kupfer`() {
    // given
    val alice = Player("Alice")
    val game = Game(players = listOf(alice))
    // when
    val cardsRetrieved = game.cardsOf(alice)
    val totalCards: List<Card> = cardsRetrieved.totalCards
    // then
    assertThat(totalCards)
      .hasSize(10)
      .matches { it.filter { it == Card.Anwesen }.size == 3 }
      .matches { it.filter { it == Card.Kupfer }.size == 7 }
  }
}