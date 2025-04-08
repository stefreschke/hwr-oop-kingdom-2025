package hwr.oop.projects.kingdom_2025

class PlayerCards {
  val cardsInDeck: List<Card> = listOf(
    Card.Kupfer,
    Card.Kupfer,
    Card.Kupfer,
    Card.Kupfer,
    Card.Kupfer
  )
  val cardsInHand: List<Card> = listOf(
    Card.Anwesen,
    Card.Anwesen,
    Card.Anwesen,
    Card.Kupfer,
    Card.Kupfer
  )
  val totalCards = cardsInHand + cardsInDeck
}
