package hwr.oop.projects.kingdom_2025

import assertAll
import io.kotest.core.spec.style.AnnotationSpec
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy

class SinglePlayerGameTest : AnnotationSpec() {
  
  private val alice = Player("Alice")  // possible because player is immutable
  private val game =
    Game(players = listOf(alice))  // possible because game is immutable
  
  @Test
  fun `game with single player, game has correct player`() {
    // when
    val retrievedPlayers = game.players
    // then
    assertThat(retrievedPlayers).hasSize(1).containsOnly(alice)
  }
  
  @Test
  fun `exception, game with single player, different player, illegal argument`() {
    // given
    val bob = Player("Bob")
    assertThatThrownBy {
      // when
      game.cardsOf(bob)
    }.hasMessageContaining(
      // then
      "Player $bob is not part of the game"
    )
  }
  
  @Test
  fun `player in game cards, five cards in hand`() {
    // given
    val cardsRetrieved = game.cardsOf(alice)
    // when
    val hand = cardsRetrieved.hand
    // then
    val estates = hand.filter { it == Card.Estate }
    val coppers = hand.filter { it == Card.Copper }
    assertAll {
      assertThat(hand).hasSize(5).hasSize(estates.size + coppers.size)
      assertThat(estates).hasSizeBetween(0, 3)
      assertThat(coppers).hasSizeBetween(2, 5)
    }
  }
  
  @Test
  fun `player in game cards, five cards in deck`() {
    // given
    val cardsRetrieved = game.cardsOf(alice)
    // when
    val deck = cardsRetrieved.deck
    // then
    assertThat(deck.cards)
      .hasSize(5)
  }
  
  @Test
  fun `play in game, cards, total cards, 3 estate, 7 copper`() {
    // given
    val cardsRetrieved = game.cardsOf(alice)
    // when
    val totalCards = cardsRetrieved.totalCards
    // then
    val estates = totalCards.filter { it == Card.Estate }
    val coppers = totalCards.filter { it == Card.Copper }
    assertAll {
      assertThat(estates).hasSize(3)
      assertThat(coppers).hasSize(7)
      assertThat(totalCards).hasSize(10).hasSize(estates.size + coppers.size)
    }
  }
  
  @Test
  fun `play in game, cards, total cards, combined deck and hand`() {
    // given
    val cardsRetrieved = game.cardsOf(alice)
    val deck = cardsRetrieved.deck
    val hand = cardsRetrieved.hand
    // when
    val totalCards = cardsRetrieved.totalCards
    // then
    assertThat(totalCards)
      .hasSize(10)
      .containsAll(deck.cards)
      .containsAll(hand)
  }
  
  @Test
  fun `play in game, purchase power determined by coppers`() {
    // given
    val aliceCards = game.cardsOf(alice)
    // when
    val purchasePower: Int = game.purchasePower()
    // then
    val handPurchasePower = aliceCards.hand.purchasePower()
    val numberOfCoppers = aliceCards.hand.filter { it == Card.Copper }.size
    assertThat(purchasePower)
      .isEqualTo(handPurchasePower)
      .isEqualTo(numberOfCoppers)
  }
  
  @Test
  fun `play in game, has 1 buy available`() {
    // when
    val buysAvailable: Int = game.buysAvailable()
    // then
    assertThat(buysAvailable).isEqualTo(1)
  }
  
  @Test
  fun `play in game, has 1 action available`() {
    // when
    val actionsAvailable: Int = game.actionsAvailable()
    // then
    assertThat(actionsAvailable).isEqualTo(1)
  }
  
  @Test
  fun `game has supply`() {
    // when
    val supply: Supply = game.supply
    // then
    assertThat(supply)
      .matches { it.numberOfAvailable(Card.Copper) == 60 }
      .matches { it.numberOfAvailable(Card.Silver) == 40 }
      .matches { it.numberOfAvailable(Card.Gold) == 30 }
      .matches { it.numberOfAvailable(Card.Estate) == 24 }
      .matches { it.numberOfAvailable(Card.Province) == 12 }
      .matches { it.numberOfAvailable(Card.Duchy) == 12 }
      .matches { it.buyableCards.size == 17 }  // 10 action cards
  }
  
}