package hwr.oop.projects.kingdom_2025

class PlayerCards(
  remainingDeck: Deck,
  cardsPreviouslyPlayed: List<Card> = emptyList(),
) {
  val deck: Deck
  val hand: HandCards
  val cardsPlayed: List<Card>
  
  init {
    if (remainingDeck.remainingCards() >= 5) {
      val resultOfDraw = remainingDeck.draw(5)
      this.hand = resultOfDraw.drawnCards.asHand()
      this.deck = resultOfDraw.newDeck
      this.cardsPlayed = cardsPreviouslyPlayed
    } else {
      val resultOfFirstDraw = remainingDeck.draw(remainingDeck.remainingCards())
      val partialHand = resultOfFirstDraw.drawnCards
      val resultOfSecondDraw =
        Deck(cardsPreviouslyPlayed).shuffled().draw(5 - partialHand.size)
      val totalDrawnCards = partialHand + resultOfSecondDraw.drawnCards
      val newDeck = resultOfSecondDraw.newDeck
      this.hand = totalDrawnCards.asHand()
      this.deck = newDeck
      this.cardsPlayed = emptyList<Card>()
    }
  }
  
  val totalCards = hand.asList() + deck.cards + cardsPlayed
  
  fun buy(card: Card): PlayerCards {
    return PlayerCards(
      remainingDeck = deck,
      cardsPreviouslyPlayed = hand.asList() + cardsPlayed + card
    )
  }
  
  private fun List<Card>.asHand() = HandCards(this)
}

data class HandCards(
  private val cards: List<Card>,
) : Iterable<Card> by cards {
  fun asList(): List<Card> {
    return cards
  }
  
  fun purchasePower(): Int {
    return cards.sumOf { it.purchasePower }
  }
}
