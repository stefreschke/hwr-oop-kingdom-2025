package hwr.oop.projects.kingdom_2025

class CardsPlayed(val cards: List<Card>) : List<Card> by cards {
  operator fun plus(card: Card): CardsPlayed {
    return CardsPlayed(cards + card)
  }
}

fun noCardsPlayed(): CardsPlayed {
  return CardsPlayed(emptyList())
}