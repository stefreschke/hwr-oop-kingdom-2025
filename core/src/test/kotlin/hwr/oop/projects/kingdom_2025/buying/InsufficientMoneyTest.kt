package hwr.oop.projects.kingdom_2025.buying

import hwr.oop.projects.kingdom_2025.Deck
import hwr.oop.projects.kingdom_2025.Game
import hwr.oop.projects.kingdom_2025.Player
import io.kotest.core.spec.style.AnnotationSpec

class InsufficientMoneyTest : AnnotationSpec() {
  private val alice = Player("Alice")
  
  @Test
  fun `exception, hand has purchase power 2, cannot buy silver`() {
    // given
    val game = Game(
      players = listOf(alice),
      decks = mapOf(
        alice to Deck(
          cards = listOf(
            // first hand
            A, A, A, A, K,
            // second hand
            K, K, K, K, A
          )
        )
      )
    )
    // when
    // TODO Continue here!
  }
}