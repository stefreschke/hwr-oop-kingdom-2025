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
  // treasure
  Card.Gold to 30,
  Card.Silver to 40,
  Card.Copper to 60,
  // victory
  Card.Province to 12,
  Card.Duchy to 12,
  Card.Estate to 24,
  Card.Curse to 60,
  // action
  Card.DummyCard1 to 10,
  Card.DummyCard2 to 10,
  Card.DummyCard3 to 10,
  Card.DummyCard4 to 10,
  Card.DummyCard5 to 10,
  Card.DummyCard6 to 10,
  Card.DummyCard7 to 10,
  Card.DummyCard8 to 10,
  Card.DummyCard9 to 10,
  Card.DummyCard10 to 10,
)
