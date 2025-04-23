package hwr.oop.projects.kingdom_2025

import assertAll
import io.kotest.core.spec.style.AnnotationSpec
import org.assertj.core.api.Assertions.assertThat

// TODO Move this test into the correct feature test class!
class GamesUseDecksTest : AnnotationSpec() {
  
  private val alice = Player("Alice")  // possible because player is immutable
  
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
      assertThat(cardsRetrieved.deck).containsExactlyElementsOf(secondHand)
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
    val afterFirstSilverBought = game.buy(Card.Silver)
    val afterSecondSilverBought = afterFirstSilverBought.buy(Card.Silver)
    // then
    val cardsOfAlice = afterSecondSilverBought.cardsOf(alice)
    val cardsOfAliceTotal = cardsOfAlice.totalCards
    assertThat(cardsOfAliceTotal)
      .hasSize(12)
      .matches { cards -> cards.filter { it == Card.Silver }.size == 2 }
      .matches { cards -> cards.filter { it == Card.Copper }.size == 6 }
      .matches { cards -> cards.filter { it == Card.Estate }.size == 4 }
  }
  
}