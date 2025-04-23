package hwr.oop.projects.kingdom_2025

class Deck(
  val cards: List<Card>,
) : List<Card> by cards {
  
  internal fun toMutableDeck(): MutableDeck {
    return MutableDeck(cards.toMutableList())
  }
  
  fun shuffled(): Deck {
    return Deck(cards.shuffled())
  }
}

internal class MutableDeck(
  private val cards: MutableList<Card>,
) {
  fun drawHand(): CardsInHand {
    val firstFive = cards.subList(0, 5).toList()
    (1..5).forEach { _ ->
      cards.removeFirst()
    }
    return CardsInHand(firstFive)
  }
  
  fun toDeck(): Deck {
    return Deck(cards)
  }
}

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
