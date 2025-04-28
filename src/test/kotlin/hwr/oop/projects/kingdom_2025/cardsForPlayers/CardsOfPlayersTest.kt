package hwr.oop.projects.kingdom_2025.cardsForPlayers

import hwr.oop.projects.kingdom_2025.*
import io.kotest.core.spec.style.AnnotationSpec
import org.assertj.core.api.Assertions.assertThatThrownBy

class CardsOfPlayersTest : AnnotationSpec() {
  @Test
  fun `exception, alice plays, bob requested, illegal argument`() {
    // given
    val sut = AllPlayersCards(
      map = mapOf(
        Player("Alice") to PlayerCards(
          remainingDeck = Deck(
            listOf(
              Card.Copper, Card.Copper, Card.Copper,
              Card.Estate, Card.Estate
            ),
          ),
        )
      )
    )
    val bob = Player("Bob")
    // then
    assertThatThrownBy {
      sut.cardsOf(bob)
    }.hasMessageContaining(
      "Player Player(name=Bob) is not part of the game"
    )
  }
}