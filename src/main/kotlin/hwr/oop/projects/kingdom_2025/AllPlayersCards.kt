package hwr.oop.projects.kingdom_2025

class AllPlayersCards(
  val map: Map<Player, PlayerCards> = emptyMap(),
) : Map<Player, PlayerCards> by map {
  
  fun cardsOf(player: Player): PlayerCards {
    return map[player]
      ?: throw IllegalArgumentException("Player $player is not part of the game")
  }
  
  fun buy(card: Card, player: Player): AllPlayersCards {
    val cards = cardsOf(player)
    val updatedCards = cards.buy(card)
    return copy(
      map.toMutableMap().apply { this[player] = updatedCards }.toMap()
    )
  }
  
  fun copy(map: Map<Player, PlayerCards>) = AllPlayersCards(map)
}