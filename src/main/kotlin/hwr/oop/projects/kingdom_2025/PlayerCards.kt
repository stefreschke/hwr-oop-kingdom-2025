package hwr.oop.projects.kingdom_2025

class PlayerCards(deck: Deck) {
  
  val cardsInDeck: Deck
  val cardsInHand: CardsInHand
  
  init {
    val mutableDeck = deck.toMutableDeck()
    cardsInHand = mutableDeck.drawHand()
    cardsInDeck = mutableDeck.toDeck()
  }
  
  val totalCards = cardsInHand + cardsInDeck
  
  private operator fun CardsInHand.plus(deck: Deck): List<Card> {
    return this.cards + deck.cards
  }
}
