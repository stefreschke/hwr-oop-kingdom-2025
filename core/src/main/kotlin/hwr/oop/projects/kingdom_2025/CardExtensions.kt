package hwr.oop.projects.kingdom_2025

fun List<Card>.toHand(): Hand = Hand(this)

fun Map<Card, Int>.asDeck(): Deck = Deck(this.asList())

internal fun Map<Card, Int>.asList(): List<Card> =
  this.flatMap { (card, count) -> List(count) { card } }
