package hwr.oop.projects.kingdom_2025

class PlayerCards(
  val hand: Hand,
  val deck: Deck,
  val cardsPlayed: List<Card> = emptyList(),
) {
  val totalCards = hand.asList() + deck.cards + cardsPlayed
  
  fun noBuy(): PlayerCards = nextPlayerCards()
  
  fun buy(card: Card): PlayerCards {
    val cardToExpensive = card.cost > hand.purchasePower()
    if (cardToExpensive) {
      throw CardToExpensiveException(card, hand)
    }
    return drawingNewHand(
      deck = deck,
      played = hand.asList() + cardsPlayed + card
    )
  }
  
  private fun nextPlayerCards(
    additionalPlayedCards: List<Card> = emptyList(),
  ) = drawingNewHand(
    deck = deck,
    played = cardsPlayed + hand.asList() + additionalPlayedCards,
  )
  
  companion object {
    fun createBeginningSetup(): PlayerCards {
      return drawingNewHand(
        deck = createStartingDeck().shuffled(),
        played = emptyList(),
      )
    }
    
    fun drawingNewHand(
      deck: Deck,
      played: List<Card> = emptyList(),
    ) = if (deck.remainingCards() >= 5) {
      drawingHandFromExistingDeck(
        deck = deck,
        played = played
      )
    } else {
      drawingHandFromDeckIncludingReshuffling(
        deck = deck,
        played = played
      )
    }
    
    private fun drawingHandFromDeckIncludingReshuffling(
      deck: Deck,
      played: List<Card>,
    ): PlayerCards {
      val resultOfFirstDraw =
        deck.draw(deck.remainingCards())
      val partialHand = resultOfFirstDraw.drawnCards
      val resultOfSecondDraw =
        Deck(played).shuffled().draw(5 - partialHand.size)
      val totalDrawnCards = partialHand + resultOfSecondDraw.drawnCards
      val newDeck = resultOfSecondDraw.newDeck
      return PlayerCards(
        hand = totalDrawnCards.toHand(),
        deck = newDeck,
        cardsPlayed = emptyList()
      )
    }
    
    private fun drawingHandFromExistingDeck(
      deck: Deck,
      played: List<Card>,
    ): PlayerCards {
      val resultOfDraw = deck.draw(5)
      return PlayerCards(
        hand = resultOfDraw.drawnCards.toHand(),
        deck = resultOfDraw.newDeck,
        cardsPlayed = played,
      )
    }
    
  }
}

