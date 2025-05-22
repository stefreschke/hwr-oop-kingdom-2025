package hwr.oop.projects.kingdom_2025

internal fun createStartingDeck(): Deck = Deck(startingCards().shuffled())

internal fun startingCards(): List<Card> = listOf(
  Card.Copper,
  Card.Copper,
  Card.Copper,
  Card.Copper,
  Card.Copper,
  Card.Copper,
  Card.Copper,
  Card.Estate,
  Card.Estate,
  Card.Estate
)
