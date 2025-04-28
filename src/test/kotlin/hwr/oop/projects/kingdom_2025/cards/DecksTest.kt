package hwr.oop.projects.kingdom_2025.cards

import hwr.oop.projects.kingdom_2025.Card
import hwr.oop.projects.kingdom_2025.createStartingDeck
import io.kotest.core.spec.style.AnnotationSpec
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy

class DecksTest : AnnotationSpec() {
  
  @Test
  fun `starting deck, has 10 cards`() {
    // given
    val deck = createStartingDeck()
    // when
    val cardsInDeck = deck.cards
    // then
    assertThat(cardsInDeck).hasSize(10)
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
  fun `exception, starting deck, 10 cards, draw 11, illegal argument`() {
    // given
    val deck = createStartingDeck()
    assertThatThrownBy {
      // when
      deck.draw(11)
    }.hasMessageContaining(
      // then
      "Cannot draw more cards than available",
      "requested: 11",
      "only available: 10"
    )
  }
}