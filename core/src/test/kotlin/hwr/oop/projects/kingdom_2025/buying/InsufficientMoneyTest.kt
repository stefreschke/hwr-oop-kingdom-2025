package hwr.oop.projects.kingdom_2025.buying

import hwr.oop.projects.kingdom_2025.*
import io.kotest.core.spec.style.AnnotationSpec
import org.assertj.core.api.Assertions.assertThatThrownBy

class InsufficientMoneyTest : AnnotationSpec() {
  
  private val alice = Player("Alice")
  private val handOfAlice = HandCards(listOf(A, A, A, A, K))
  private val deckOfAlice = Deck(listOf(K, K, K, K, A))
  private val aliceCards = PlayerCards(
    hand = handOfAlice,
    remainingDeck = deckOfAlice,
  )
  private val game = Game(
    players = listOf<Player>(alice),
    playerCardMap = AllPlayersCards(mapOf<Player, PlayerCards>(alice to aliceCards)),
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