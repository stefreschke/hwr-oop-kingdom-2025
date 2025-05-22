package hwr.oop.projects.kingdom_2025

data class Hand(
  private val cards: List<Card>,
) : Iterable<Card> by cards {
  
  constructor(cardMap: Map<Card, Int>) : this(
    cards = cardMap.asList()
  )
  
  fun asList(): List<Card> = cards
  
  fun purchasePower() = cards.sumOf { it.purchasePower }
  
}