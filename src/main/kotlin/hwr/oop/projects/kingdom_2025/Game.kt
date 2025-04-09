package hwr.oop.projects.kingdom_2025

class Game(
  val players: List<Player>,
  decks: Map<Player, Deck> = emptyMap(),
) {
  
  private val playerCardMap = if (decks.isEmpty()) {
    players.associateWith { PlayerCards(createStartingDeck().shuffled()) }
  } else {
    players.associateWith { player -> PlayerCards(decks[player]!!) }
  }
  
  fun cardsOf(player: Player): PlayerCards {
    return playerCardMap[player]
      ?: throw IllegalStateException("Player $player is not part of the game")
  }
  
}
