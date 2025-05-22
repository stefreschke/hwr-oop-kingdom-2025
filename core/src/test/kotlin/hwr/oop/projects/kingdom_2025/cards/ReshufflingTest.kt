package hwr.oop.projects.kingdom_2025.cards

import hwr.oop.projects.kingdom_2025.*
import io.kotest.core.spec.style.AnnotationSpec

class ReshufflingTest : AnnotationSpec() {
  
  val sut = PlayerCards(
    hand = Hand(mapOf(Card.Copper to 3)),
    deck = Deck(listOf(Card.Gold)),
    cardsPlayed = listOf(Card.Estate),
  )
  
  @Test
  fun `test setup, 3 coppers in hand, 1 gold in deck, 1 estate played`() {
    assertAll {
      assertThat(sut.hand).hasSize(3).contains(Card.Copper)
      assertThat(sut.deck).hasSize(1).contains(Card.Gold)
      assertThat(sut.cardsPlayed).hasSize(1).contains(Card.Estate)
    }
  }
  
  @Test
  fun `no buy, all five cards in hand, deck and played cards empty`() {
    // when
    val updated = sut.noBuy()
    // then
    assertAll {
      assertThat(updated.deck).isEmpty()
      assertThat(updated.cardsPlayed).isEmpty()
      assertThat(updated.hand)
        .hasSize(5)
        .matches { hand -> hand.filter { it == Card.Copper }.size == 3 }
        .matches { hand -> hand.filter { it == Card.Gold }.size == 1 }
        .matches { hand -> hand.filter { it == Card.Estate }.size == 1 }
    }
  }
  
  @Test
  fun `buy silver, gold is drawn from deck, 4 of 5 more random cards`() {
    // when
    val updated = sut.buy(Card.Silver)
    // then
    assertAll {
      assertThat(updated.cardsPlayed).isEmpty()
      assertThat(updated.deck)
        .hasSize(1)
        .containsAnyOf(Card.Silver, Card.Estate, Card.Copper)
      assertThat(updated.hand)
        .hasSize(5)
        .matches { hand -> hand.filter { it == Card.Gold }.size == 1 }
      assertThat(updated.totalCards)
        .hasSize(6)
        .matches { hand -> hand.filter { it == Card.Copper }.size == 3 }
        .matches { hand -> hand.filter { it == Card.Silver }.size == 1 }
        .matches { hand -> hand.filter { it == Card.Gold }.size == 1 }
        .matches { hand -> hand.filter { it == Card.Estate }.size == 1 }
    }
  }
}