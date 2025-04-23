package hwr.oop.projects.kingdom_2025

class CardsPlayed(private val cards: List<Card>) : List<Card> by cards {
  operator fun plus(card: Card): CardsPlayed {
    return CardsPlayed(cards + card)
  }
}