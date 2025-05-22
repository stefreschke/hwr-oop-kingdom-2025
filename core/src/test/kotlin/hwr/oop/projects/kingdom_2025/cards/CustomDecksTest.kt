package hwr.oop.projects.kingdom_2025.cards

import hwr.oop.projects.kingdom_2025.Card
import hwr.oop.projects.kingdom_2025.asDeck
import io.kotest.core.spec.style.AnnotationSpec
import org.assertj.core.api.Assertions.assertThat

class CustomDecksTest : AnnotationSpec() {
  
  val deck = mapOf(
    Card.Copper to 10,
    Card.Silver to 3,
    Card.Gold to 1,
    Card.Estate to 2,
    Card.Province to 3,
  ).asDeck()
  
  val cardsInDeck = deck.cards
  
  @Test
  fun `test data deck, 10 coppers`() {
    assertThat(cardsInDeck)
      .matches { cards -> cards.filter { it == Card.Copper }.size == 10 }
  }
  
  @Test
  fun `test data deck, 3 silvers`() {
    assertThat(cardsInDeck)
      .matches { cards -> cards.filter { it == Card.Silver }.size == 3 }
  }
  
  @Test
  fun `test data deck, single gold`() {
    assertThat(cardsInDeck)
      .matches { cards -> cards.filter { it == Card.Gold }.size == 1 }
  }
  
  @Test
  fun `test data deck, two estates`() {
    assertThat(cardsInDeck)
      .matches { cards -> cards.filter { it == Card.Estate }.size == 2 }
  }
  
  @Test
  fun `test data deck, 3 provinces`() {
    assertThat(cardsInDeck)
      .matches { cards -> cards.filter { it == Card.Province }.size == 3 }
  }
}