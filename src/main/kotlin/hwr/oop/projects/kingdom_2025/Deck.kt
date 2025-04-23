package hwr.oop.projects.kingdom_2025

class Deck(
  val cards: List<Card>,
) : List<Card> by cards {
  
  fun shuffled(): Deck {
    return Deck(cards.shuffled())
  }
  
  fun draw(numberOfCards: Int): DrawResult {
    require(cards.size >= numberOfCards) {
      "Cannot draw more cards than available"
    }
    val drawnCards = cards.subList(0, numberOfCards)
    val newDeck = Deck(cards.subList(numberOfCards, cards.size))
    return DrawResult(newDeck, drawnCards)
  }
  
}

data class DrawResult(
  val newDeck: Deck,
  val drawnCards: List<Card>,
) {

}

internal fun createStartingDeck(): Deck = Deck(startingCards().shuffled())

internal fun startingCards(): List<Card> = listOf(
  Card.Copper,
  Card.Copper,
  Card.Copper,
  Card.Copper,
  Card.Copper,
  Card.Copper,
  Card.Copper,
  Card.Estate,
  Card.Estate,
  Card.Estate
)
