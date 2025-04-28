package hwr.oop.projects.kingdom_2025

class CardsPlayed(val cards: List<Card>) : List<Card> by cards

fun noCardsPlayed(): CardsPlayed {
  return CardsPlayed(emptyList())
}