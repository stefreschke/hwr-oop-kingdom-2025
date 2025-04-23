package hwr.oop.projects.kingdom_2025

import io.kotest.core.spec.style.AnnotationSpec
import org.assertj.core.api.Assertions.assertThat

class DecksTest : AnnotationSpec() {
  
  @Test
  fun `starting deck, has 10 cards`() {
    // given
    val deck = createStartingDeck()
    // when
    val cardsInDeck = deck.cards
    // then
    assertThat(cardsInDeck)
      .hasSize(10)
  }
  
  @Test
  fun `starting deck, contains 3 estate, 7 copper`() {
    // given
    val deck = createStartingDeck()
    // when
    val cardsInDeck = deck.cards
    // then
    assertThat(cardsInDeck)
      .matches { cards -> cards.filter { it == Card.Estate }.size == 3 }
      .matches { cards -> cards.filter { it == Card.Copper }.size == 7 }
  }
  
  @Test
  fun `starting deck, shuffled, different sequence`() {
    // given
    val deck = createStartingDeck()
    // when
    val shuffledDeck = deck.shuffled()
    // then
    val cardOrderOriginalDeck = deck.cards
    val cardOrderShuffledDeck = shuffledDeck.cards
    assertThat(cardOrderShuffledDeck)
      .doesNotContainSequence(cardOrderOriginalDeck)
  }
  
  @Test
  fun `mutable Deck, draw hand, first 5 cards drawn, 5 left in deck`() {
    // given
    val originalDeck = createStartingDeck()
    val firstFiveCards = originalDeck.cards.subList(0, 5)
    val mutableDeck = originalDeck.toMutableDeck()
    // when
    val hand = mutableDeck.drawHand()
    // then
    val updatedDeck = mutableDeck.toDeck()
    assertThat(updatedDeck.cards)
      .hasSize(5)
      .doesNotContainSequence(hand.cards)
    assertThat(hand.cards)
      .hasSize(5)
      .containsExactlyElementsOf(firstFiveCards)
  }
}
