package hwr.oop.projects.kingdom_2025.buying

import assertAll
import hwr.oop.projects.kingdom_2025.Card.Silver
import hwr.oop.projects.kingdom_2025.Deck
import hwr.oop.projects.kingdom_2025.Game
import hwr.oop.projects.kingdom_2025.Player
import io.kotest.core.spec.style.AnnotationSpec
import org.assertj.core.api.Assertions.assertThat

typealias K = hwr.oop.projects.kingdom_2025.Card.Copper
typealias A = hwr.oop.projects.kingdom_2025.Card.Estate

class BuyingSilverSufficientMoneyTest : AnnotationSpec() {
  
  private val alice = Player("Alice")
  private val game = Game(
    players = listOf(alice),
    decks = mapOf(
      alice to Deck(
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
    val updatedGame = game.buy(Silver)
    // when
    val cardsRetrieved = updatedGame.cardsOf(alice)
    // then
    val deck = cardsRetrieved.deck
    val hand = cardsRetrieved.hand
    val playedCards = cardsRetrieved.cardsPlayed
    val totalCards = cardsRetrieved.totalCards
    assertAll {
      assertThat(deck.cards).doesNotContain(Silver)
      assertThat(hand).doesNotContain(Silver)
      assertThat(playedCards).contains(Silver)
      assertThat(totalCards).contains(Silver)
    }
  }
  
  @Test
  fun `buy silver, hand discarded, new hand dealt`() {
    // given
    val updatedGame = game.buy(Silver)
    // when
    val cardsRetrieved = updatedGame.cardsOf(alice)
    // then
    val hand = cardsRetrieved.hand
    assertThat(hand)
      .contains(K, K, K, K, A)
  }
  
  @Test
  fun `games use deck per player`() {
    // given
    val firstHand = listOf(A, A, K, K, K)
    val secondHand = listOf(K, K, K, A, A)
    val game = Game(
      players = listOf(alice), decks = mapOf(
        alice to Deck(firstHand + secondHand)
      )
    )
    // when
    val cardsRetrieved = game.cardsOf(alice)
    // then
    assertAll {
      assertThat(cardsRetrieved.hand).containsExactlyElementsOf(firstHand)
      assertThat(cardsRetrieved.deck.cards).containsExactlyElementsOf(secondHand)
    }
  }
  
  @Test
  fun `buying silver twice, deck reshuffles`() {
    // given
    val firstHand = listOf(A, A, K, K, K)
    val secondHand = listOf(K, K, K, A, A)
    val game = Game(
      players = listOf(alice), decks = mapOf(
        alice to Deck(firstHand + secondHand)
      )
    )
    // when
    val afterFirstSilverBought = game.buy(Silver)
    val afterSecondSilverBought = afterFirstSilverBought.buy(Silver)
    // then
    val cardsOfAlice = afterSecondSilverBought.cardsOf(alice)
    val cardsOfAliceTotal = cardsOfAlice.totalCards
    assertThat(cardsOfAliceTotal)
      .hasSize(12)
      .matches { cards -> cards.filter { it == Silver }.size == 2 }
      .matches { cards -> cards.filter { it == hwr.oop.projects.kingdom_2025.Card.Copper }.size == 6 }
      .matches { cards -> cards.filter { it == hwr.oop.projects.kingdom_2025.Card.Estate }.size == 4 }
  }
  
}