package hwr.oop.projects.kingdom_2025

class PlayerCards(
  remainingDeck: Deck,
  val cardsPlayed: CardsPlayed = CardsPlayed(emptyList()),
) {
  val deck: Deck
  val hand: CardsInHand
  
  init {
    val mutableDeck = remainingDeck.toMutableDeck()
    val drawnHand = mutableDeck.drawHand()
    val updatedDeck = mutableDeck.toDeck()
    this.hand = drawnHand
    this.deck = updatedDeck
  }
  
  val totalCards = hand + deck + cardsPlayed
  
  private operator fun CardsInHand.plus(deck: Deck): List<Card> {
    return this.cards + deck.cards
  }
  
  private operator fun CardsInHand.plus(cardsPlayed: CardsPlayed): List<Card> {
    return this.cards + cardsPlayed
  }
  
  fun buy(card: Card): PlayerCards {
    return PlayerCards(
      remainingDeck = deck,
      cardsPlayed = CardsPlayed(hand + cardsPlayed + card)
    )
  }
}
