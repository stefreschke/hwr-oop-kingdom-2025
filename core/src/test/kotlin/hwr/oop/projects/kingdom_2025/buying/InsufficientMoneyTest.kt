package hwr.oop.projects.kingdom_2025.buying

import hwr.oop.projects.kingdom_2025.*
import hwr.oop.projects.kingdom_2025.Deck
import hwr.oop.projects.kingdom_2025.Hand
import io.kotest.core.spec.style.AnnotationSpec
import org.assertj.core.api.Assertions.assertThatThrownBy

class InsufficientMoneyTest : AnnotationSpec() {
  
  private val alice = Player("Alice")
  private val aliceCards = PlayerCards(
    hand = Hand(listOf(E, E, E, E, C)),
    deck = Deck(listOf(C, C, C, C, E)),
  )
  private val game = Game(
    players = listOf(alice),
    playerCardMap = AllPlayersCards(mapOf(alice to aliceCards)),
    supply = Supply.createDefaultSupplyAdding(mapOf(Card.Thief to 3))
  )
  
  @Test
  fun `hand has purchase power 1, cannot buy Thief (costs 4)`() {
    assertThatThrownBy {
      game.buy(Card.Thief)
    }.hasMessageContainingAll(
      "Not enough purchase power to buy",
      "got 1", "expected at least 4",
      Card.Thief.toString(),
    )
  }
  
  @Test
  fun `hand has purchase power 1, cannot buy Gold (costs 6)`() {
    assertThatThrownBy {
      game.buy(Card.Gold)
    }.hasMessageContainingAll(
      "Not enough purchase power to buy",
      "got 1", "expected at least 6",
      Card.Gold.toString(),
    )
  }
  
  @Test
  fun `hand has purchase power 1, cannot buy province (costs 8)`() {
    assertThatThrownBy {
      game.buy(Card.Province)
    }.hasMessageContainingAll(
      "Not enough purchase power to buy",
      "got 1", "expected at least 8",
      Card.Province.toString(),
    )
  }
  
}