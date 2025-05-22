package hwr.oop.projects.kingdom_2025

class Deck(
  val cards: List<Card>,
) : Iterable<Card> by cards {
  
  fun remainingCards(): Int {
    return cards.size
  }
  
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
  
  data class DrawResult(
    val newDeck: Deck,
    val drawnCards: List<Card>,
  )
}
