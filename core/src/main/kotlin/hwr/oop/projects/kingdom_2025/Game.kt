package hwr.oop.projects.kingdom_2025

class Game(
  val players: List<Player>,
  val turn: Player = players.first(),
  decks: Map<Player, Deck> = emptyMap(),
  playerCardMap: AllPlayersCards = AllPlayersCards(emptyMap()),
  val supply: Supply = Supply(),
  val id: GameId = GameId.random(),
) {
  
  private val playerCardMap: AllPlayersCards = if (!playerCardMap.isEmpty()) {
    playerCardMap
  } else if (decks.isEmpty()) {
    val map = players.associateWith { PlayerCards.createBeginningSetup() }
    AllPlayersCards(map)
  } else {
    val map = players.associateWith { player ->
      val deck = decks[player] ?: playerNotAddingUpWithDeck(player, decks)
      PlayerCards.drawingNewHand(deck)
    }
    AllPlayersCards(map)
  }
  
  fun cardsOf(player: Player): PlayerCards {
    return playerCardMap.cardsOf(player)
  }
  
  fun buy(card: Card): Game {
    return copy(
      players = players,
      playerCardMap = playerCardMap.buy(card, turn),
    )
  }
  
  fun copy(
    players: List<Player>,
    playerCardMap: AllPlayersCards,
  ): Game {
    return Game(
      players = players,
      playerCardMap = playerCardMap
    )
  }
  
  fun buysAvailable(): Int {
    return 1
  }
  
  fun actionsAvailable(): Int {
    return 1
  }
  
  fun purchasePower(): Int {
    return cardsOf(turn).hand.purchasePower()
  }
  
  private fun playerNotAddingUpWithDeck(
    player: Player,
    decks: Map<Player, Deck>,
  ): Nothing {
    throw IllegalArgumentException(
      "Provided decks do not contain player $player," +
          " expected any of $players, decks were $decks"
    )
  }
}
