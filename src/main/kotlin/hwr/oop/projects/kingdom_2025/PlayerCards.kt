package hwr.oop.projects.kingdom_2025

class PlayerCards(
  remainingDeck: Deck,
  cardsPreviouslyPlayed: CardsPlayed = CardsPlayed(emptyList()),
) {
  val deck: Deck
  val hand: CardsInHand
  val cardsPlayed: CardsPlayed
  
  init {
    if (remainingDeck.size >= 5) {
      val resultOfDraw = remainingDeck.draw(5)
      this.hand = CardsInHand(resultOfDraw.drawnCards)
      this.deck = resultOfDraw.newDeck
      this.cardsPlayed = cardsPreviouslyPlayed
    } else {
      val resultOfFirstDraw = remainingDeck.draw(remainingDeck.size)
      val partialHand = resultOfFirstDraw.drawnCards
      val resultOfSecondDraw =
        Deck(cardsPreviouslyPlayed).shuffled().draw(5 - partialHand.size)
      val totalDrawnCards = partialHand + resultOfSecondDraw.drawnCards
      val newDeck = resultOfSecondDraw.newDeck
      this.hand = CardsInHand(totalDrawnCards)
      this.deck = newDeck
      this.cardsPlayed = noCardsPlayed()
    }
  }
  
  val totalCards = hand.cards + deck.cards + cardsPlayed
  
  fun buy(card: Card): PlayerCards {
    return PlayerCards(
      remainingDeck = deck,
      cardsPreviouslyPlayed = CardsPlayed(hand.cards + cardsPlayed + card)
    )
  }
}
