package hwr.oop.projects.kingdom_2025

import io.kotest.core.spec.style.AnnotationSpec.Test
import org.assertj.core.api.Assertions.assertThatThrownBy

class SinglePlayerGamesCardsTest {
  
  val alice = Player("Alice")
  val deck = mapOf(
    Card.Copper to 3,
    Card.Estate to 2,
  ).asDeck()
  
  val sut = AllPlayersCards(
    map = mapOf(alice to PlayerCards.drawingNewHand(deck))
  )
  
  @Test
  fun `exception, alice plays, bob requested, illegal argument`() {
    // given
    val bob = Player("Bob")
    // then
    assertThatThrownBy {
      sut.cardsOf(bob)
    }.hasMessageContaining(
      "Player Player(name=Bob) is not part of the game"
    )
  }
}