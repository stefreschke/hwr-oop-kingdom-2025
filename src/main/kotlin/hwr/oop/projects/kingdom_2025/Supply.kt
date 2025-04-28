package hwr.oop.projects.kingdom_2025

class Supply(
  private val cardCountMap: Map<Card, Int> = defaultSupplyCardCountMap,
) {
  val buyableCards = cardCountMap.filter { it.value > 0 }.keys
  val emptyPiles = cardCountMap.filter { it.value == 0 }.keys
  val numberOfEmptyPiles = emptyPiles.size
  
  fun numberOfAvailable(card: Card): Int {
    return cardCountMap[card] ?: invalidCard(card)
  }
  
  fun remove(numberOf: Int, card: Card): Supply {
    val currentAmountOfCards =
      cardCountMap[card] ?: invalidCard(card)
    require(currentAmountOfCards >= numberOf) {
      "Not enough $card in supply, requested: $numberOf," +
          " only available: $currentAmountOfCards"
    }
    val mutable = cardCountMap.toMutableMap()
    mutable[card] = currentAmountOfCards - numberOf
    return Supply(mutable.toMap())
  }
  
  fun pileIsEmpty(card: Card): Boolean {
    val sizeOfPile = cardCountMap[card] ?: invalidCard(card)
    return sizeOfPile == 0
  }
  
  private fun invalidCard(card: Card): Nothing =
    throw IllegalArgumentException("Card $card is not in supply")
  
}

private val defaultSupplyCardCountMap = mapOf(
  // money
  Card.Gold to 30,
  Card.Silver to 40,
  Card.Copper to 60,
  // points
  Card.Province to 12,
  Card.Duchy to 12,
  Card.Estate to 24
)
