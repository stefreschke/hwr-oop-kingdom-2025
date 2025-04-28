package hwr.oop.projects.kingdom_2025

class PlayerCards(
  remainingDeck: Deck,
  cardsPreviouslyPlayed: List<Card> = emptyList(),
) {
  val deck: Deck
  val hand: List<Card>
  val cardsPlayed: List<Card>
  
  init {
    if (remainingDeck.remainingCards() >= 5) {
      val resultOfDraw = remainingDeck.draw(5)
      this.hand = resultOfDraw.drawnCards
      this.deck = resultOfDraw.newDeck
      this.cardsPlayed = cardsPreviouslyPlayed
    } else {
      val resultOfFirstDraw = remainingDeck.draw(remainingDeck.remainingCards())
      val partialHand = resultOfFirstDraw.drawnCards
      val resultOfSecondDraw =
        Deck(cardsPreviouslyPlayed).shuffled().draw(5 - partialHand.size)
      val totalDrawnCards = partialHand + resultOfSecondDraw.drawnCards
      val newDeck = resultOfSecondDraw.newDeck
      this.hand = totalDrawnCards
      this.deck = newDeck
      this.cardsPlayed = emptyList<Card>()
    }
  }
  
  val totalCards = hand + deck.cards + cardsPlayed
  
  fun buy(card: Card): PlayerCards {
    return PlayerCards(
      remainingDeck = deck,
      cardsPreviouslyPlayed = hand + cardsPlayed + card
    )
  }
}
